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

import com.fineqt.fpb.lib.util.TextBitset;
/**
 * 保存bitstring类型的值。内部以TextBitset形式来保存值。
 * 
 * @author JiangMin
 *
 */
public interface IBitstringValue extends IStringValue {
	/**
	 * 取得内部的值。
	 * @return
	 */
	TextBitset getValue();
	/**
	 * 设置内部的值。
	 * @param bitset
	 */
	void setValue(TextBitset bitset);
	/**
	 * 返回bitstring值中指定位置的比特值。
	 * @param position 目标比特位置，有效值为0到length-1。
	 * @return
	 */
	int getBit(int position);
	
	/**
	 * 设置bitstring值中指定位置的比特值。
	 * @param position 目标比特位置，有效值为0到length-1。
	 * @param value 目标值，有效值为0和1。
	 */
	void setBit(int position, int value);

}
