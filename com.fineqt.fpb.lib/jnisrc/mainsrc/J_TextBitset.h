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
/* Header for class TextBitset */

#ifndef _Included_TextBitset
#define _Included_TextBitset
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeFree
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeFree
  (JNIEnv *, jobject);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeCreate
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeCreate
  (JNIEnv *, jobject);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeInitIDs
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeInitIDs
  (JNIEnv *, jclass);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeSet
 * Signature: (IILjava/lang/String;I)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSet__IILjava_lang_String_2I
  (JNIEnv *, jobject, jint, jint, jstring, jint);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeSet
 * Signature: (Ljava/lang/String;I)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSet__Ljava_lang_String_2I
  (JNIEnv *, jobject, jstring, jint);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeSetBit
 * Signature: (IZ)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSetBit
  (JNIEnv *, jobject, jint, jboolean);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeSetRaw
 * Signature: (II[B)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSetRaw__II_3B
  (JNIEnv *, jobject, jint, jint, jbyteArray);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeSetRaw
 * Signature: ([B)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSetRaw___3B
  (JNIEnv *, jobject, jbyteArray);
/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeGet
 * Signature: (III)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGet__III
  (JNIEnv *, jobject, jint, jint, jint);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeGet
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGet__I
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeGetRaw
 * Signature: (II)[B
 */
JNIEXPORT jbyteArray JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGetRaw__II
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeGetRaw
 * Signature: ()[B
 */
JNIEXPORT jbyteArray JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGetRaw__
  (JNIEnv *, jobject);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeGetBit
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeGetBit
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeSize
  (JNIEnv *, jobject);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeResize
 * Signature: (IZ)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeResize
  (JNIEnv *, jobject, jint, jboolean);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeAppend
 * Signature: (B)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeAppend__B
  (JNIEnv *, jobject, jbyte);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeAppend
 * Signature: ([B)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeAppend___3B
  (JNIEnv *, jobject, jbyteArray);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeAppend
 * Signature: (Lcom/fineqt/pktbuilder/core/pdu/TextBitset;)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeAppend__Lcom_fineqt_fpb_lib_util_TextBitset_2
  (JNIEnv *, jobject, jobject);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativePushBack
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativePushBack
  (JNIEnv *, jobject, jboolean);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeShiftLeft
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeShiftLeft
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_fineqt_fpb_lib_util_NativeTextBitset
 * Method:    nativeShiftRight
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_fineqt_fpb_lib_util_NativeTextBitset_nativeShiftRight
  (JNIEnv *, jobject, jint);

#ifdef __cplusplus
}
#endif
#endif
