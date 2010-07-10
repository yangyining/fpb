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
 * octetstring类型的值对象类。内部以byte[]形式来保存值。
 * 
 * @author JiangMin
 *
 */
public interface IOctetstringValue extends IStringValue {
	/**
	 * 取得内部保存值。
	 * @return
	 */
	byte[] getValue();
	/**
	 * 设置内部保存值。
	 * @param value
	 */
	void setValue(byte[] value);
	/**
	 * 取得特定串元素的值。
	 * @param position 目标元素的指定位置，0到length-1。
	 * @return 返回指定位置的元素值，(0 .. 255)。
	 */
	int    getOctet(int position);
	/**
	 * 设置特定串元素的值。
	 * @param position 目标元素的指定位置，0到length-1。
	 * @param value 设置元素值，(0 .. 255)。
	 */
	void   setOctet(int position, int value);
}
