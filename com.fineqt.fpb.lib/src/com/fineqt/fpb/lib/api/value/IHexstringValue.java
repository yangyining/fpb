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
package com.fineqt.fpb.lib.api.value;
/**
 * hexstring类型的值对象类。内部以byte[]和长度形式来保存值。
 * 
 * @author JiangMin
 *
 */
public interface IHexstringValue extends IStringValue {
	/**
	 * 返回内部值。
	 * @return
	 */
	byte[] getValue();
	/**
	 * 设置内部值。
	 * @param value 目标数据。
	 * @param length 长度,Hex的个数即比特数除以4。
	 */
	void setValue(byte[] value, int length);
	/**
	 * 返回指定位置的元素值。
	 * @param position 指定位置，0到length-1。
	 * @return 特定位置的元素值，范围是(0 .. 15)。
	 */
	int getHex (int position);
	/**
	 * 设置指定位置的元素值。 
	 * @param position 指定位置，0到length-1。
	 * @param value 特定位置的元素值，范围是(0 .. 15)。
	 */
	void setHex (int position, int value);
}
