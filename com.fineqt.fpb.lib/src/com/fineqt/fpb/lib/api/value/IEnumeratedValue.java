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
 * enumerated（枚举）类型值对象的类。
 * 
 * @author JiangMin
 *
 */
public interface IEnumeratedValue extends IPrimitiveValue {
	/**
	 * 取得枚举类型当前值的Value属性。
	 * @return
	 */
	int getEnumValue();
	/**
	 * 取得枚举类型代表当前值的元素的标示符。
	 * @return
	 */
	int getEnumID();
	/**
	 * 取得枚举类型代表当前值的元素的名称。
	 * @return
	 */
	String getEnumName();
	/**
	 * 以枚举类型目标元素的标示符来设置当前值。
	 * @param enumID
	 */
	void setEnumByID(int enumID);
	/**
	 * 以枚举类型目标元素的名称来设置当前值。
	 * @param enumName
	 */
	void setEnumByName(String enumName);
	/**
	 * 以目标元素的Value属性来设置当前值。
	 * @param enumValue
	 */
	void setEnumByValue(int enumValue);
}
