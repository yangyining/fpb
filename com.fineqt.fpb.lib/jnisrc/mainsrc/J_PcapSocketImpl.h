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
#include <jni.h>
/* Header for class comm_pcap_PcapSocketImpl */

#ifndef _Included_comm_pcap_PcapSocketImpl
#define _Included_comm_pcap_PcapSocketImpl
#ifdef __cplusplus
extern "C" {
#endif
#undef com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_OPEN_LIVE
#define com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_OPEN_LIVE 1L
#undef com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_OPEN_OFFLINE
#define com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_OPEN_OFFLINE 2L
#undef com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_OPEN_DUMP
#define com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_OPEN_DUMP 3L
/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeInitIDs
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeInitIDs
  (JNIEnv *, jclass);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    getDeviceList
 * Signature: ()[Lcom/fineqt/pktbuilder/core/comm/pcap/NetworkInterface;
 */
JNIEXPORT jobjectArray JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_getDeviceList
  (JNIEnv *, jclass);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeOpenLive
 * Signature: (Ljava/lang/String;III)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeOpenLive
  (JNIEnv *, jobject, jstring, jint, jint, jint);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeClose
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeClose
  (JNIEnv *, jobject);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeRecvPacket
 * Signature: (Lcom/fineqt/pktbuilder/core/comm/pcap/PcapPacket;II)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeRecvPacket
  (JNIEnv *, jobject, jobject, jint, jint);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeSendPacket
 * Signature: ([BII)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeSendPacket
  (JNIEnv *, jobject, jbyteArray, jint, jint);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeSetFilter
 * Signature: (Ljava/lang/String;Z)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeSetFilter
  (JNIEnv *, jobject, jstring, jboolean);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeGetErrMsg
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeGetErrMsg
  (JNIEnv *, jobject);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeOpenOffline
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeOpenOffline
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeCapture
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeCapture
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeEndCapture
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeEndCapture
  (JNIEnv *, jobject);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeOpenDump
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeOpenDump
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeDump
 * Signature: (Lcom/fineqt/pktbuilder/core/comm/pcap/PcapPacket;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeDump
  (JNIEnv *, jobject, jobject);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeFlushDump
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeFlushDump
  (JNIEnv *, jobject);

/*
 * Class:     com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl
 * Method:    nativeCloseDump
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_comm_pcap_PcapSocketImpl_nativeCloseDump
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
