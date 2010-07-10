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
#include <iostream>
#include <string>
#include <cassert>
#include <boost/dynamic_bitset.hpp>
#include "J_TextBitset.h"
#include "TextBitset.h"
#include "AutotestUtil.h"

using namespace std;
using namespace boost;

jfieldID ID_TextBitset_Peer;

//for debug
void printBuffer(const char * head, string & buf) {
	cout << head << endl; 
    for(unsigned int i = 0; i < buf.size(); i++) {
    	cout << " buf[" << i << "]:" << hex << (0xFF & buf[i]) << endl;
    }
}

inline void getStdString(JNIEnv * env, jstring jstr, string & stdStr) {
    if (jstr != NULL) {
        jsize strLen = env->GetStringLength(jstr);
        stdStr.resize(strLen);
        env->GetStringUTFRegion(jstr, 0, strLen, &stdStr[0]);
    }
    else {
        stdStr.resize(0);
    }
}

inline TextBitset * getPeerPtr(JNIEnv * env, jobject obj) {
    long lptr = env->GetLongField(obj, ID_TextBitset_Peer);
//    cout << "lptr:" << lptr << endl;
    return reinterpret_cast<TextBitset *>(lptr);
}

inline void getByteArray(JNIEnv * env, jbyteArray array, string & buff) {
    if (array != NULL) {
        jsize len = env->GetArrayLength(array);
        buff.resize(len);
        env->GetByteArrayRegion(array, 0, len, reinterpret_cast<jbyte *>(&buff[0]));
    }
    else {
        buff.resize(0);
    }
}

inline jbyteArray createJbyteArray(JNIEnv * env, const string & buff) {
    jbyteArray array = env->NewByteArray(buff.size());
    env->SetByteArrayRegion(array, 0, buff.size(), 
            reinterpret_cast<const jbyte *>(&buff[0]));
    return array;   
}

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    free
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeFree
  (JNIEnv * env, jobject obj) {
//    cout << "TextBitset Free" << endl;
    TextBitset * ptr = getPeerPtr(env, obj);
    delete ptr;
}

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    create
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeCreate
  (JNIEnv * env, jobject obj) {
//    cout << "TextBitset Create" << endl;
    TextBitset * ptr = new TextBitset();
    long lptr = reinterpret_cast<long>(ptr);
//    cout << "lptr:" << lptr << endl;
    env->SetLongField(obj, ID_TextBitset_Peer, lptr);
}

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    initIDs
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeInitIDs
  (JNIEnv * env, jclass cls) {
    ID_TextBitset_Peer = env->GetFieldID(cls, "peer", "J");
    if (ID_TextBitset_Peer == NULL) return;
//    cout << "ID_TextBitset_Peer:" << ID_TextBitset_Peer << endl;
}

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    set
 * Signature: (IILjava/lang/String;I)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSet__IILjava_lang_String_2I
  (JNIEnv * env, jobject obj, jint offset, jint len, jstring jtextValue, jint type) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string textValue;
    getStdString(env, jtextValue, textValue);
    bitset->set(offset, len, textValue, static_cast<TextBitset::TextValueType>(type));
}

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    set
 * Signature: (Ljava/lang/String;I)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSet__Ljava_lang_String_2I
  (JNIEnv * env, jobject obj, jstring jtextValue, jint type) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string textValue;
    getStdString(env, jtextValue, textValue);
    bitset->set(textValue, static_cast<TextBitset::TextValueType>(type));
}

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    setBit
 * Signature: (IZ)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSetBit
  (JNIEnv * env, jobject obj, jint offset, jboolean value) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    bitset->set(offset, value);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeSetRaw
 * Signature: (II[B)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSetRaw__II_3B
  (JNIEnv * env, jobject obj, jint offset, jint len, jbyteArray array) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string buff;
    getByteArray(env, array, buff);
    bitset->setRaw(offset, len, buff);
}

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    setRaw
 * Signature: ([B)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSetRaw___3B
  (JNIEnv * env, jobject obj, jbyteArray array) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string buff;
    getByteArray(env, array, buff);
    bitset->setRaw(buff);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    get
 * Signature: (III)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGet__III
  (JNIEnv * env, jobject obj, jint offset, jint len, jint type) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string stdStr;
    stdStr = bitset->get(offset, len, static_cast<TextBitset::TextValueType>(type));
    return env->NewStringUTF(stdStr.c_str());
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    get
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGet__I
  (JNIEnv * env, jobject obj, jint type) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string stdStr;
    stdStr = bitset->get(static_cast<TextBitset::TextValueType>(type));
    return env->NewStringUTF(stdStr.c_str());
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeGetRaw
 * Signature: (II)[B
 */
JNIEXPORT jbyteArray JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGetRaw__II
  (JNIEnv * env, jobject obj, jint offset, jint len) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string buff = bitset->getRaw(offset, len);
    return createJbyteArray(env, buff);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    getRaw
 * Signature: ()[B
 */
JNIEXPORT jbyteArray JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGetRaw__
  (JNIEnv * env, jobject obj) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string buff = bitset->getRaw();
    return createJbyteArray(env, buff);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    getBit
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGetBit
  (JNIEnv * env, jobject obj, jint offset) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    return bitset->get(offset);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    size
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSize
  (JNIEnv * env, jobject obj) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    return bitset->size();
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    resize
 * Signature: (IZ)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeResize
  (JNIEnv * env, jobject obj, jint len, jboolean b) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    bitset->resize(len, b);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    append
 * Signature: (B)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeAppend__B
  (JNIEnv * env, jobject obj, jbyte byt) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    bitset->append(byt);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    append
 * Signature: ([B)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeAppend___3B
  (JNIEnv * env, jobject obj, jbyteArray array) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    string buff;
    getByteArray(env, array, buff);
	bitset->append(buff.begin(), buff.end());
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    append
 * Signature: (Lcom_fineqt_fpb_lib_util_NativeTextBitset;)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeAppend__Lcom_fineqt_fpb_lib_util_TextBitset_2
  (JNIEnv * env, jobject obj, jobject valueObj) {
    TextBitset * dstBitset = getPeerPtr(env, obj);
    assert(dstBitset != NULL);
    TextBitset * srcBitset = getPeerPtr(env, valueObj);
    assert(srcBitset != NULL);
    dstBitset->append(*srcBitset);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    pushBack
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativePushBack
  (JNIEnv * env, jobject obj, jboolean b) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    bitset->pushBack(b);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeShiftLeft
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeShiftLeft
  (JNIEnv * env, jobject obj, jint n) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    bitset->shiftLeft(n);
}
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeShiftRight
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeShiftRight
  (JNIEnv * env, jobject obj, jint n) {
    TextBitset * bitset = getPeerPtr(env, obj);
    assert(bitset != NULL);
    bitset->shiftRight(n);
}
