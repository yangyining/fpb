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

/**
 * 任意長さのBitsetクラス、しかもその値は文字列設定可能。
 * ビット列のインデクスは左から計算する。例え0X3Fの場合に、対応関係は次のようになる。
 * 0 0 1 1 1 1 1 1	ビットの値
 * 0 1 2 3 4 5 6 7	インデクスの値
 * 先頭　->　　　　後部
 * 文字列設定可能なタイプは次のようになる。
 * INTEGER　0～2^32-1正整数（BIG ENDIAN）		1,1000
 * HEX		十六進のバイト列値					[255, 1]->FF01
 * ASCII	ASCIIコードのバイト列値,不可視文字列[<32 or >126]は「\xFF」で記入、\文字は「\\」で記入 
 * 			ABC\x0DEFG
 * BIN		二進のビット列値					[四ビットの14]->1110
 * @author JiangMin
 *
 */
public interface TextBitset extends TextValueType, Cloneable {
	int INTEGER_LENGTH = 32;
	int LONG_LENGTH = 64;
	int INET4_ADDR_LENGTH = 32;
	int INET6_ADDR_LENGTH = 128;
	int MAC_ADDR_LENGTH = 48;
	
	void set(int offset, int len, String textValue, int type);
	/**
	 * 全部データを指定タイプの文字列で設定する。設定後、サイズが変わる可能性がある。
	 * @param textValue 文字列
	 * @param type 文字列タイプ
	 */
	void set(String textValue, int type);
	/**
	 * 设定指定位的值。
	 * @param offset 设置位的偏移量。
	 * @param val 设定值。
	 */
	void setBit(int offset, boolean val);
	/**
	 * 将字节数组的数据设置到指定范围的位中去。
	 * @param offset 设置范围的偏移量
	 * @param len 设置范围的长度
	 * @param value 被设置数据。从0位开始的len位被设置。
	 */
	void setRaw(int offset, int len, byte[] value);
	/**
	 * 以字节数组的数据完全替换已有的位数据。替换后对象的长度(size)可能会改变。
	 * @param rawValue 用于设置的数据
	 */
	void setRaw(byte[] rawValue);

	String get(int offset, int len, int type);
	
	String get(int type);
	
	byte[] getRaw(int offset, int len);
	
	byte[] getRaw();

	boolean getBit(int offset);
	
	int size();
	/**
	 * ビットセットのサイズを再設定する。元のサイズより小さいなら後ろの部分が切離される。
	 * 元のサイズより大きいなら最後にvalueで指定するビットが追加される。
	 * @param n　サイズ、ビット単位
	 * @param value　追加するビットの値、Trueは１、Falseは０
	 */
	void resize(int n, boolean value);
	
	void append(byte rawValue);
	
	void append(byte[] rawValue);
	/**
	 * 追加指定范围的字节数组数据。
	 * @param rawValue 被追加数据
	 * @param byteOffset 字节偏移量
	 * @param byteLen 字节长度
	 */
	void append(byte[] rawValue, int byteOffset, int byteLen);
	
	void append(TextBitset bitset);
	
	void pushBack(boolean bit);
	/**
	 * ビットセットのサイズを再設定する。元のサイズより小さいなら後ろの部分が切離される。
	 * 元のサイズより大きいなら最後に０が追加される。
	 * @param n サイズ、ビット単位
	 */
	void resize(int n);
	
	void shiftLeft(int n);
	
	void shiftRight(int n);
	/**
	 * sizeが1以上が必要。
	 * 但し、sizeが0の場合に0を戻す
	 * @return 符号無しIntegerの値
	 */
	long getAsInteger();
	/**
	 * sizeが1以上が必要。
	 * 但し、sizeが0の場合に何も設定しない。余ったビットは切られるので、設定後、サイズが変わらない。
	 * @param value 符号無しIntegerの値
	 */
	void setAsInteger(long value);
	
	TextBitset subset(int offset, int len);
	Object clone();
	int hashCode();
}