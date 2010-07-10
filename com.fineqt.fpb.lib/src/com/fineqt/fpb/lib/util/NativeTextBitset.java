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
package com.fineqt.fpb.lib.util;

import java.security.InvalidParameterException;

import org.apache.commons.lang.builder.ToStringBuilder;

public class NativeTextBitset implements TextBitset{
	@SuppressWarnings("all")
	volatile private long peer;
	
	private native synchronized void nativeFree();

	private native synchronized void nativeCreate();

	private static native void nativeInitIDs();

	static {
		nativeInitIDs();
	}
	
	public native void nativeSet(int offset, int len, String textValue, int type);

	public native void nativeSet(String textValue, int type);

	public native void nativeSetBit(int offset, boolean val);

	public native void nativeSetRaw(int offset, int len, byte[] value);

	public native void nativeSetRaw(byte[] rawValue);

	public native String nativeGet(int offset, int len, int type);

	public native String nativeGet(int type);

	public native byte[] nativeGetRaw(int offset, int len);

	public native byte[] nativeGetRaw();

	public native boolean nativeGetBit(int offset);

	public native int nativeSize();

	public native void nativeResize(int n, boolean value);

	public native void nativeAppend(byte rawValue);

	public native void nativeAppend(byte[] rawValue);

	public native void nativeAppend(TextBitset bitset);

	public native void nativePushBack(boolean bit);
	
	public native void nativeShiftLeft(int n);
	
	public native void nativeShiftRight(int n);
	
	public NativeTextBitset() {
		nativeCreate();
	}
	
	/**
	 * 指定範囲のバイト配列でBitsetを作成する。
	 * @param rawValue バイトデータ配列
	 * @param offset　対象範囲のオフセット(バイト単位)
	 * @param len 対象範囲の長さ(バイト単位)
	 */
	public NativeTextBitset(byte[] rawValue, int offset, int len) {
		this();
		if (rawValue == null || rawValue.length == 0)
			return;
		byte[] newRaw = new byte[len];
		System.arraycopy(rawValue, offset, newRaw, 0, len);
		nativeSetRaw(newRaw);
	}

	public NativeTextBitset(byte[] rawValue) {
		this();
		if (rawValue == null || rawValue.length == 0)
			return;
		nativeSetRaw(rawValue);
	}

	public NativeTextBitset(String textValue, int type) {
		this();
		if (textValue == null || textValue.length() == 0) {
			return;
		}
		nativeSet(textValue, type);
	}
	
	protected void finalize() {
		nativeFree();
	}
	public void resize(int n) {
		nativeResize(n, false);
	}

	public void append(byte rawValue) {
		nativeAppend(rawValue);
	}

	public void append(byte[] rawValue) {
		nativeAppend(rawValue);		
	}

	@Override
	public void append(byte[] rawValue, int byteOffset, int byteLen) {
		for (int i = 0; i < byteLen ; i++) {
			nativeAppend(rawValue[byteOffset + i]);
		}
	}

	public void append(TextBitset bitset) {
		assert bitset instanceof NativeTextBitset;
		nativeAppend(bitset);
	}

	public String get(int offset, int len, int type) {
		//パラメータ有効性チェック
		checkOffsetLen(offset, len);
		return nativeGet(offset, len, type);
	}

	public String get(int type) {
		return nativeGet(type);
	}

	public boolean getBit(int offset) {
		//パラメータ有効性チェック
		checkOffsetLen(offset, 1);
		return nativeGetBit(offset);
	}

	public byte[] getRaw() {
		return nativeGetRaw();
	}

	public void pushBack(boolean bit) {
		nativePushBack(bit);
	}

	public void resize(int n, boolean value) {
		if (n < 0) {
			throw new InvalidParameterException();
		}
		nativeResize(n, value);
	}

	public void set(int offset, int len, String textValue, int type) {
		//パラメータ有効性チェック
		checkOffsetLen(offset, len);
		nativeSet(offset, len, textValue, type);
	}

	public void set(String textValue, int type) {
		nativeSet(textValue, type);
	}

	public void setBit(int offset, boolean val) {
		//パラメータ有効性チェック
		checkOffsetLen(offset, 1);
		nativeSetBit(offset, val);
	}

	public void setRaw(byte[] rawValue) {
		nativeSetRaw(rawValue);
	}

	public int size() {
		return nativeSize();
	}

	public void shiftLeft(int n) {
		nativeShiftLeft(n);
	}

	public void shiftRight(int n) {
		nativeShiftRight(n);
	}
	
	public long getAsInteger(){
		int size = nativeSize();
		if (size <= 0) {
			return 0;
		}
		String value = get(TextBitset.INTEGER);
		return Long.parseLong(value);
	}

	public void setAsInteger(long value){
		int size = nativeSize();
		if (size <= 0) {
			return;
		}
		String str = Long.toString(value & 0xFFFFFFFFL);
		if (size >= INTEGER_LENGTH) {
			nativeSet(0, INTEGER_LENGTH, str, TextBitset.INTEGER);
		}
		else {
			nativeSet(0, size, str, TextBitset.INTEGER);
		}
	}

	public byte[] getRaw(int offset, int len) {
		//パラメータ有効性チェック
		checkOffsetLen(offset, len);
		return nativeGetRaw(offset, len);
	}

	public void setRaw(int offset, int len, byte[] value) {
		//パラメータ有効性チェック
		checkOffsetLen(offset, len);
		nativeSetRaw(offset, len, value);
	}

	public TextBitset subset(int offset, int len) {
		//パラメータ有効性チェック
		checkOffsetLen(offset, len);
//		//サブセットの文字列取得
//		String value = get(offset, len, TextBitset.HEX);
//		//サブセットの生成
//		TextBitset result = new NativeTextBitset(value, TextBitset.HEX);
		byte[] raw = nativeGetRaw(offset, len);
		TextBitset result = new NativeTextBitset(raw);
		result.resize(len);
		return result;
	}

	private void checkOffsetLen(int offset, int len) {
		if( offset + len > size() || offset + len < 0 || offset < 0 || len < 0) {
			throw new InvalidParameterException("offset:"+offset+" len:"+len+" size:"+size());
		}
	}
	
	public String toString() {
		return new ToStringBuilder(this).
				appendSuper(super.toString()).
				append("size", size()).
				append("value", "0x"+get(TextBitset.HEX)).
				toString();
	}

	public Object clone(){
		NativeTextBitset newSet = new NativeTextBitset();
		newSet.append(this);
		return newSet;
	}
	
	public boolean equals(Object o) {
		if (o == null)
			return false;
		
		if (!(o instanceof TextBitset)) {
			return false;
		}
		
		TextBitset srcBitset = (TextBitset)o;
		if (srcBitset.size() != size()) {
			return false;
		}
		byte[] srcBytes = srcBitset.getRaw();
		byte[] dstBytes = getRaw();
		for (int i = 0; i < dstBytes.length; i++) {
			if (srcBytes[i] != dstBytes[i])
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		// TODO 暂时使用默认方法
		return super.hashCode();
	}
	
}
