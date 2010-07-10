/****************************************************************
Fine Packet Builder, copyright (C) 2007-2009 fineqt.com

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
GNU General Public License for more details at gnu.org.
******************************************************************/
#ifdef WIN32
#include<winsock2.h>
#endif /* for WIN32 */

#ifndef WIN32
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <sys/time.h>
#include "pcap-int.h" //pcap0.9.8
#endif /* for Linux */

#include <jni.h>
#include <pcap.h>
#include <iostream>
#include <string>
#include <cassert>
#include "J_PcapSocketImpl.h"
#include "Processing.h"

#define MAX_PACKET_SIZE 1600
#define OPEN_LIVE 1
#define OPEN_OFFLINE 2
#define OPEN_DUMP 3

const char *SOCKET_EXCEPTION = "java/net/SocketException";
const char *SESSION_NOT_OPEN_MSG = "Session is not open.";
const char *NETWORK_INTERFACE_CLASS = "com/fineqt/fpb/lib/api/comm/pcap/NetworkInterface";
const char *NETWORK_INTERFACE_ADDRESS_CLASS = "com/fineqt/fpb/lib/api/comm/pcap/NetworkInterfaceAddress";
const char *PCAP_PACKET_CLASS = "com/fineqt/fpb/lib/api/comm/pcap/PcapPacket";
const char *STRING_CLASS = "java/lang/String";
using namespace std;

jclass CLS_NetIf;
jclass CLS_NetIfAddr;
jclass CLS_WinPapSocket;
jclass CLS_PcapPacket;
jclass CLS_String;

jmethodID ID_NetIf_init;
jfieldID ID_NetIf_Name;
jfieldID ID_NetIf_Description;
jfieldID ID_NetIf_Loopback;
jfieldID ID_NetIf_Addresses;

jmethodID ID_NetIfAddr_init;

jfieldID ID_WinPapSocket_handle;
jfieldID ID_WinPapSocket_dumpHandle;

jfieldID ID_PcapPacket_sec;
jfieldID ID_PcapPacket_usec;
jfieldID ID_PcapPacket_caplen;
jfieldID ID_PcapPacket_len;
jfieldID ID_PcapPacket_data;

jmethodID MID_String_getBytes;
jmethodID MID_String_init;
/**
 * loopメソッド用callbackメソッド
 */
void processData(u_char *user, struct pcap_pkthdr *h, jbyte *sp) {
	Processing *proc;
	proc = (Processing *) user;
	proc->processData(user, h, sp);
}

jbyteArray getAddressByteArray(JNIEnv *env,struct sockaddr *addr)
{
	jbyteArray array;
	if(addr==NULL) return NULL;

	switch(addr->sa_family){
		case AF_INET:
			array=env->NewByteArray(4);
			env->SetByteArrayRegion(array,0,4,(jbyte *)&((struct sockaddr_in *)addr)->sin_addr);
			break;
		case AF_INET6:
			array=env->NewByteArray(16);
			env->SetByteArrayRegion(array,0,16,(jbyte *)&((struct sockaddr_in6 *)addr)->sin6_addr);
			break;
		default:
			//printf("AF:%d\n",addr->sa_family);
			return NULL;
			break;
	}
	return array;
}

pcap_t * getPeerHandle(JNIEnv * env, jobject obj) {
    long lptr = env->GetLongField(obj, ID_WinPapSocket_handle);
//    cout << "lptr:" << lptr << endl;
    return reinterpret_cast<pcap_t *>(lptr);
}

pcap_dumper_t * getPeerDumpHandle(JNIEnv * env, jobject obj) {
    long lptr = env->GetLongField(obj, ID_WinPapSocket_dumpHandle);
    return reinterpret_cast<pcap_dumper_t *>(lptr);
}

void throwException(JNIEnv *env, const char *excClassName, char *message) {
  // create an instance of the specified exception
  jclass exception = env->FindClass(excClassName);

  if(exception != NULL) 
    // throw the new exception back to the java wrapper
    env->ThrowNew(exception, message);

  // free the local reference. if exception is still null, delete is a noop.
  env->DeleteLocalRef(exception);

}

//Get String in Native Code
char * getStringNativeChars(JNIEnv *env, jstring jstr) {
	jbyteArray bytes = NULL;
	jthrowable exc;
	char *result = NULL;
	if (env->EnsureLocalCapacity(2) < 0) {
		return NULL; /* out of memory error */
	}
	bytes = reinterpret_cast<jbyteArray>(env->CallObjectMethod(jstr, MID_String_getBytes));
	exc = env->ExceptionOccurred();
	if (!exc) {
		jint len = env->GetArrayLength(bytes);
		result = (char *)malloc(len + 1);
		if (result == NULL) {
			throwException(env, "java/lang/OutOfMemoryError", NULL);
			env->DeleteLocalRef(bytes);
			return NULL;
		}
		env->GetByteArrayRegion(bytes, 0, len, (jbyte *)result);
		result[len] = 0; /* NULL-terminate */
	} else {
		env->DeleteLocalRef(exc);
	}
	env->DeleteLocalRef(bytes);
	return result;
}
//New Java String from Native String
jstring newStringNative(JNIEnv *env, const char *str) {
	//クラスIDの再ロード (NewObject或いはNewObjectArrayに必須みたい) 	
  	CLS_String = env->FindClass(STRING_CLASS);
  	
	jstring result;
	jbyteArray bytes = 0;
	int len;
	if (env->EnsureLocalCapacity(2) < 0) {
		return NULL; /* out of memory error */
	}
	len = strlen(str);
	bytes = env->NewByteArray(len);
	if (bytes != NULL) {
		env->SetByteArrayRegion(bytes, 0, len, (jbyte *)str);
		result = reinterpret_cast<jstring>(
				env->NewObject(CLS_String, MID_String_init, bytes));
		env->DeleteLocalRef(bytes);
		return result;
	} /* else fall through */
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeInitIDs
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeInitIDs
  (JNIEnv * env, jclass cls) {
//	cout << "nativeInitIDs" << endl;
  	CLS_NetIf = env->FindClass(NETWORK_INTERFACE_CLASS);
  	CLS_NetIfAddr = env->FindClass(NETWORK_INTERFACE_ADDRESS_CLASS);
  	CLS_WinPapSocket = cls;
  	CLS_PcapPacket = env->FindClass(PCAP_PACKET_CLASS);
  	CLS_String = env->FindClass(STRING_CLASS);
  	//異常のプリント
  	env->ExceptionDescribe();
  	
  	string parasig;
  	ID_NetIf_Name = env->GetFieldID(CLS_NetIf, "name", "Ljava/lang/String;");
  	ID_NetIf_Description = env->GetFieldID(CLS_NetIf, "description", "Ljava/lang/String;");
  	ID_NetIf_Loopback = env->GetFieldID(CLS_NetIf, "loopback", "Z");
  	parasig = string("[L")+NETWORK_INTERFACE_ADDRESS_CLASS+";";
  	ID_NetIf_Addresses = env->GetFieldID(CLS_NetIf, "addresses", parasig.c_str());
  	parasig = string("(Ljava/lang/String;Ljava/lang/String;Z[L")+NETWORK_INTERFACE_ADDRESS_CLASS+";)V";
  	ID_NetIf_init = env->GetMethodID(CLS_NetIf, "<init>", parasig.c_str()); 
  	ID_NetIfAddr_init = env->GetMethodID(CLS_NetIfAddr,"<init>","([B[B[B[B)V");
  	
  	ID_WinPapSocket_handle = env->GetFieldID(CLS_WinPapSocket, "handle", "J");
  	ID_WinPapSocket_dumpHandle = env->GetFieldID(CLS_WinPapSocket, "dumpHandle", "J");
  	
  	ID_PcapPacket_sec = env->GetFieldID(CLS_PcapPacket, "sec", "J");
  	ID_PcapPacket_usec = env->GetFieldID(CLS_PcapPacket, "usec", "J");
  	ID_PcapPacket_caplen = env->GetFieldID(CLS_PcapPacket, "caplen", "I");
  	ID_PcapPacket_len = env->GetFieldID(CLS_PcapPacket, "len", "I");
  	ID_PcapPacket_data = env->GetFieldID(CLS_PcapPacket, "data", "[B");
  	
  	MID_String_getBytes = env->GetMethodID(CLS_String,"getBytes","()[B");
  	MID_String_init = env->GetMethodID(CLS_String,"<init>","([B)V");
  	//異常のプリント
  	env->ExceptionDescribe();
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    getDeviceList
 * Signature: ()[Lcomm/pcap/NetworkInterface;
 */
JNIEXPORT jobjectArray JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_getDeviceList
  (JNIEnv * env, jclass) {
	//クラスIDの再ロード (NewObject或いはNewObjectArrayに必須みたい) 	
	CLS_NetIf = env->FindClass(NETWORK_INTERFACE_CLASS);
  	CLS_NetIfAddr = env->FindClass(NETWORK_INTERFACE_ADDRESS_CLASS);

	pcap_if_t *alldevs;
	pcap_if_t *d;
	pcap_addr_t *a;
	char errbuf[PCAP_ERRBUF_SIZE];
	jobjectArray devices=NULL;
	jobjectArray addresses=NULL;
	jobject device=NULL;
	jobject address=NULL;
	int i=0;
	int j=0;
	//device listの取得
    if (pcap_findalldevs(&alldevs, errbuf) == -1)
    {
    	throwException(env, SOCKET_EXCEPTION, errbuf);
        return NULL;
    }

	//deviceの計算
	for(i=0,d=alldevs;d;d=d->next,i++);

	//IF配列の作成
	devices=env->NewObjectArray((jsize)i,CLS_NetIf,NULL);
	//IFの内容の設定
    for(i=0,d=alldevs;d;d=d->next) {
		//count # of addresses
		for(j=0,a=d->addresses;a;a=a->next)
			if(getAddressByteArray(env,a->addr)) j++;
    	//IFAddress配列の生成
		addresses=env->NewObjectArray((jsize)j,CLS_NetIfAddr,NULL);

		//IFAddressの生成
		for(j=0,a=d->addresses;a;a=a->next)
		{
			jbyteArray addr=getAddressByteArray(env,a->addr);
			if(addr){
				address=env->NewObject(CLS_NetIfAddr,ID_NetIfAddr_init,
					addr,
					getAddressByteArray(env,a->netmask),
					getAddressByteArray(env,a->broadaddr),
					getAddressByteArray(env,a->dstaddr));
				env->SetObjectArrayElement(addresses,j++,address);
			}
		}
    	//IFの生成
    	device=env->NewObject(CLS_NetIf, ID_NetIf_init, 
    		newStringNative(env, d->name),
    		newStringNative(env, d->description),
    		(d->flags&PCAP_IF_LOOPBACK?JNI_TRUE:JNI_FALSE), 
			addresses);
		//配列へ設定
		env->SetObjectArrayElement(devices,i++,device);
    	env->DeleteLocalRef(device);
    }
    //device listのリリース
    pcap_freealldevs(alldevs);
	//異常のプリント
	env->ExceptionDescribe();

	return devices;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeOpenLive
 * Signature: (Ljava/lang/String;III)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeOpenLive
  (JNIEnv * env, jobject obj, jstring device, jint snaplen, jint promisc, jint to_ms) {
	char *dev;
	pcap_t * handle;
	char errbuf[PCAP_ERRBUF_SIZE];
	assert(device != NULL);
//  	dev=(char *)env->GetStringUTFChars(device, NULL);
	dev = (char *)getStringNativeChars(env, device);
	if (dev == NULL) {
		return NULL;
	}
  	//セッションのOpen
  	handle = pcap_open_live(dev, snaplen, promisc, to_ms, errbuf);
//  	env->ReleaseStringUTFChars(device, dev);
  	free(dev);
  	//失敗なら、エラーメッセージを戻す
  	if (handle == NULL) {
  		return newStringNative(env, errbuf);
  	}
  	//Handleの設定
  	long ptr = reinterpret_cast<long>(handle);
  	env->SetLongField(obj, ID_WinPapSocket_handle, ptr);
#ifdef WIN32
	//set min copy size
	int rst = pcap_setmintocopy(handle, 1);
	if (rst == -1) {
  		return newStringNative(env, errbuf);
	}
#else
	//none block
	int rst = pcap_setnonblock(handle, 1, errbuf);
	if (rst == -1) {
  		return newStringNative(env, errbuf);
	}
#endif
	//異常のプリント;
	env->ExceptionDescribe();
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeClose
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeClose
  (JNIEnv * env, jobject obj){
  	pcap_t * handle;
  	//Handleの取得
  	handle = getPeerHandle(env, obj);
  	if (handle == NULL)
  		return;
  	//Close
  	pcap_close(handle);
}

/**
 * 現在時刻の取得。timevalをミリ秒に転換
 * Windowsの場合はマシン起動からの時間である。
 */
jlong getsystime() {
#ifdef WIN32	
  	return GetTickCount();
#else
  	timeval tv;
  	jlong rst = gettimeofday(&tv, NULL);
  	assert(rst == 0);
  	return tv.tv_sec * 1000 + tv.tv_usec / 1000;
#endif
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeRecvPacket
 * Signature: (Lcomm/pcap/PcapPacket;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeRecvPacket
  (JNIEnv * env, jobject obj, jobject packet, jint ms, jint status) {
	struct pcap_pkthdr *header;
  	pcap_t * handle;
  	const u_char * data;
  	assert(packet != NULL);
  	//Handleの取得
  	handle = getPeerHandle(env, obj);
  	if (handle == NULL)
  		return newStringNative(env, SESSION_NOT_OPEN_MSG);
#ifdef WIN32
  	//現在時刻の取得
  	jlong startms = getsystime();
  	//パケットの取得
  	while(true) {
		int rst = pcap_next_ex(handle, &header, &data);
		//Timeout
		if (rst == 0) {
			if (ms <= 0 || (getsystime() - startms < ms)) {
				continue;
			} else {
				//本当のTimeout
		  		return newStringNative(env, "Timeout.");
				
			}
		//EOF
		} else if (rst == -2) {
	  		return newStringNative(env, "EOF.");
		//Error
		} else if (rst == -1) {
	  		return newStringNative(env, pcap_geterr(handle));
		}
		//成功
		break;
  	}
//  	cout << "recvms: " << (int)(getsystime() - startms) << endl;
//  	printf("nativeRecv1-1 %d sec:%d usec:%d clen:%d len:%d \n", (int)handle, (int)header->ts.tv_sec, 
//  			(int)header->ts.tv_usec, (int)header->caplen, (int)header->len);
#else 
  	//OPEN_LIVEの場合にselect　APIで入力の検知
  	if (status == OPEN_LIVE) {
  	    fd_set fd_wait;
  	    int sel;
  	    struct timeval st;
  	    //select
  	    FD_ZERO(&fd_wait);
  	    FD_SET(pcap_fileno(handle), &fd_wait);
  	    st.tv_sec = ms / 1000;
  	    st.tv_usec = (ms % 1000) * 1000;
  	    sel = select(FD_SETSIZE, &fd_wait, NULL, NULL, &st);
  	    //timeout
  	    if (sel == 0) {
  	  		return newStringNative(env, "Timeout.");
  	    //error
  	    } else if (sel < 0) {
  	  		return newStringNative(env, "select return -1");
  	    } 
  	}
  	//Dataの取得
	int rst = pcap_next_ex(handle, &header, &data);
	//Timeout
	if (rst == 0) {
  		return newStringNative(env, "Timeout.");
	//EOF
	} else if (rst == -2) {
  		return newStringNative(env, "EOF.");
	//Error
	} else if (rst == -1) {
  		return newStringNative(env, pcap_geterr(handle));
	}
#endif
	//Packetに値の設定
	env->SetLongField(packet, ID_PcapPacket_sec, (jlong)header->ts.tv_sec);
	env->SetLongField(packet, ID_PcapPacket_usec, (jlong)header->ts.tv_usec);
	env->SetIntField(packet, ID_PcapPacket_caplen, (jint)header->caplen);
	env->SetIntField(packet, ID_PcapPacket_len, (jint)header->len);
	//data配列の生成
	jbyteArray dataArray = env->NewByteArray(header->caplen);
	if (dataArray == NULL) {
  		return newStringNative(env, "No enough memeory");
	}
	env->SetByteArrayRegion(dataArray, 0, header->caplen, reinterpret_cast<const signed char *>(data));
	env->SetObjectField(packet, ID_PcapPacket_data, dataArray);
	env->DeleteLocalRef(dataArray);
//  	printf("nativeRecv2-4 %d\n", handle);
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeSendPacket
 * Signature: ([BII)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeSendPacket
  (JNIEnv * env, jobject obj, jbyteArray dataArray, jint off, jint len){
  	pcap_t * handle;
  	char buf[MAX_PACKET_SIZE];
  	//Handleの取得
  	handle = getPeerHandle(env, obj);
  	if (handle == NULL)
  		return newStringNative(env, SESSION_NOT_OPEN_MSG);
  		
  	//Dataの取得
  	if (len > MAX_PACKET_SIZE)
  		len = MAX_PACKET_SIZE;
  	env->GetByteArrayRegion(dataArray, off, len, reinterpret_cast<signed char *>(buf));
	
	//Dataの送信
//  	jlong startms = getsystime();
  	int rst = pcap_sendpacket(handle, reinterpret_cast<const unsigned char *>(buf), len);
//  	cout << "sendms: " << (int)(getsystime() - startms) << endl;
  	if (rst < 0) {
  		return newStringNative(env, pcap_geterr(handle));
  	}
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeSetFilter
 * Signature: (Ljava/lang/String;Z)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeSetFilter
  (JNIEnv * env, jobject obj, jstring condition, jboolean optimize){
  	pcap_t * handle;
	struct bpf_program program;
  	//Handleの取得
  	handle = getPeerHandle(env, obj);
  	if (handle == NULL)
  		return newStringNative(env, SESSION_NOT_OPEN_MSG);
  		
//	char *cdt=(char *)env->GetStringUTFChars(condition, NULL);
	char *cdt = (char *)getStringNativeChars(env, condition);
	if (cdt == NULL) {
		return NULL;
	}
	//条件のコンパイル
	if(pcap_compile(handle,&program,cdt,(optimize==JNI_TRUE?-1:0),0)!=0){
		free(cdt);
  		return newStringNative(env, pcap_geterr(handle));
	}
	//フィルタの設定
	if(pcap_setfilter(handle,&program)!=0){
		free(cdt);
  		return newStringNative(env, pcap_geterr(handle));
		
	}
//	env->ReleaseStringUTFChars(condition,cdt);
	free(cdt);
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeGetErrMsg
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeGetErrMsg
  (JNIEnv * env, jobject obj) {
  	pcap_t * handle;
  	//Handleの取得
  	handle = getPeerHandle(env, obj);
  	if (handle == NULL)
  		return newStringNative(env, SESSION_NOT_OPEN_MSG);
  		
  	return newStringNative(env, pcap_geterr(handle));
  	
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeOpenOffline
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeOpenOffline
  (JNIEnv * env, jobject obj, jstring fileName) {
	pcap_t * handle;
	char errbuf[PCAP_ERRBUF_SIZE];
	char * file;
	assert(fileName != NULL);
  	//file = (char *)env->GetStringUTFChars(fileName, NULL);
	file = (char *)getStringNativeChars(env, fileName);
	if (file == NULL) {
		return NULL;
	}
  	//セッションのOpen
  	handle = pcap_open_offline(file, errbuf);
  	//env->ReleaseStringUTFChars(fileName, file);
  	free(file);
  	//失敗なら、エラーメッセージを戻す
  	if (handle == NULL) {
  		return newStringNative(env, errbuf);
  	}
  	//Handleの設定
  	long ptr = reinterpret_cast<long>(handle);
  	env->SetLongField(obj, ID_WinPapSocket_handle, ptr);
	//異常のプリント;
	env->ExceptionDescribe();
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeCapture
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeCapture
  (JNIEnv * env, jobject obj, jint count) {
  	//Handleの取得
  	pcap_t * handle;
  	handle = getPeerHandle(env, obj);
  	if (handle == NULL)
  		return newStringNative(env, SESSION_NOT_OPEN_MSG);
  		
  	//Callbackオブジェクトの生成
	Processing p;
	p.javaEnvironment = env;
	p.javaObject = obj;
	//loopする
#ifdef WIN32
	int ret = pcap_loop(handle, count, (pcap_handler)processData, (u_char *)(&p));
    if ( ret == -1) {
  		return newStringNative(env, pcap_geterr(handle));
    }
#else
    int recvedPkts = 0;
    while(count == -1 || recvedPkts < count) {
    	//データを待つ
  	    fd_set fd_wait;
  	    int ret;
  	    //select
  	    FD_ZERO(&fd_wait);
  	    FD_SET(pcap_fileno(handle), &fd_wait);
  	    struct timeval st;
  	    st.tv_sec = handle->md.timeout / 1000;
  	    st.tv_usec = (handle->md.timeout % 1000) * 1000;
  	    ret = select(FD_SETSIZE, &fd_wait, NULL, NULL, &st);
//  	    cout << "select:" << ret << " " << getsystime() << endl;
  	    //timeout
  	    if (ret == 0) {
  	    	//breakloop判断
  	    	if (handle->break_loop) {
  	    		handle->break_loop = 0;
  	    		return NULL;
  	    	}
  	    	//継続
  	    	continue;
  	    //error
  	    } else if (ret < 0) {
  	  		return newStringNative(env, "select return -1");
  	    }
  	    while(count == -1 || recvedPkts < count) {
  	  	    //パケット受信
  	        ret = pcap_dispatch(handle, count == -1? -1: count - recvedPkts, 
  	        		(pcap_handler)processData, (u_char *)(&p));
//  	        cout << "pcap_dispatch:" << ret << " " << getsystime() << endl;
  	        //Timeout(no data)
  	        if ( ret == 0) {
  	        	break;
  	        //Error
  	        } else if ( ret == -1) {
  	    		return newStringNative(env, pcap_geterr(handle));
  	        //breakloop
  	        } else if ( ret == -2) {
  	        	return NULL;
  	        //パケット数
  	        } else {
  	        	recvedPkts += ret;
  	        }
  	    }
    }
#endif
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeEndCapture
 * Signature: ()V;
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeEndCapture
  (JNIEnv * env, jobject obj) {
  	pcap_t * handle;
  	//Handleの取得
  	handle = getPeerHandle(env, obj);
  	if (handle == NULL)
  		return;
  	pcap_breakloop(handle);
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeOpenDump
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeOpenDump
  (JNIEnv * env, jobject obj, jstring fileName) {
  	pcap_t * handle;
  	//Handleの取得
  	handle = getPeerHandle(env, obj);
  	if (handle == NULL)
		return newStringNative(env, SESSION_NOT_OPEN_MSG);
  	//DumpセッションのOpen
	char * file;
	assert(fileName != NULL);
//  	file = (char *)env->GetStringUTFChars(fileName, NULL);
	file = (char *)getStringNativeChars(env, fileName);
	if (file == NULL) {
		return NULL;
	}
  	pcap_dumper_t * dumpHandle = pcap_dump_open(handle, file);
//  	env->ReleaseStringUTFChars(fileName, file);
  	free(file);
  	if (dumpHandle == NULL) {
  		return newStringNative(env, pcap_geterr(handle));
  	}
  	//DumpHandleの設定
  	long ptr = reinterpret_cast<long>(dumpHandle);
  	env->SetLongField(obj, ID_WinPapSocket_dumpHandle, ptr);
	//異常のプリント;
	env->ExceptionDescribe();
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeDump
 * Signature: (Lcomm/pcap/PcapPacket;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeDump
  (JNIEnv * env, jobject obj, jobject packet) {
	//DumpHandleの取得
	pcap_dumper_t * dumpHandle;
	dumpHandle = getPeerDumpHandle(env, obj);
  	if (dumpHandle == NULL)
  		return newStringNative(env, SESSION_NOT_OPEN_MSG);
  	//パケット属性の取得
	struct pcap_pkthdr header;
  	header.ts.tv_sec = env->GetLongField(packet, ID_PcapPacket_sec);
  	header.ts.tv_usec = env->GetLongField(packet, ID_PcapPacket_usec);
  	header.caplen = env->GetLongField(packet, ID_PcapPacket_caplen);
  	header.len = env->GetLongField(packet, ID_PcapPacket_len);
  	//パケットデータの取得
  	jbyteArray dataArray = reinterpret_cast<jbyteArray>
  			(env->GetObjectField(packet, ID_PcapPacket_data));
	if (dataArray == NULL) {
  		return newStringNative(env, "Data field of packet is NULL.");
	}
	string dataBuf;
	dataBuf.resize(header.caplen);
	env->GetByteArrayRegion(dataArray, 0, header.caplen, 
			reinterpret_cast<signed char *>(&dataBuf[0]));
	env->DeleteLocalRef(dataArray);
	//パケットのDump
	pcap_dump(reinterpret_cast<unsigned char *>(dumpHandle), &header, 
			reinterpret_cast<const unsigned char *>(&dataBuf[0]));
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeFlushDump
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeFlushDump
  (JNIEnv *env, jobject obj) {
  	//Handleの取得
  	pcap_t * handle = getPeerHandle(env, obj);
  	if (handle == NULL)
  		return newStringNative(env, SESSION_NOT_OPEN_MSG);
	//DumpHandleの取得
	pcap_dumper_t * dumpHandle;
	dumpHandle = getPeerDumpHandle(env, obj);
  	if (dumpHandle == NULL)
  		return newStringNative(env, SESSION_NOT_OPEN_MSG);
	//flush
	int rst = pcap_dump_flush(dumpHandle);
	if (rst == -1) {
  		return newStringNative(env, pcap_geterr(handle));
	}
	return NULL;
}

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeCloseDump
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeCloseDump
  (JNIEnv * env, jobject obj) {
	//DumpHandleの取得
	pcap_dumper_t * dumpHandle;
	dumpHandle = getPeerDumpHandle(env, obj);
  	if (dumpHandle == NULL)
  		return;
	//close
	pcap_dump_close(dumpHandle);  
}

