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
 * charstring类型的值对象类。内部的值以char[]形式保存。
 * 
 * @author JiangMin
 *
 */
public interface ICharstringValue extends IStringValue {
	/**
	 * 取得值对象内部的文字数组。
	 * @return
	 */
	char[] getValue();
	/**
	 * 设置值对象内部的文字数组。
	 * @param chars
	 */
	void setValue(char[] chars);
	/**
	 * 取得特定位置的文字。
	 * @param position 0到length -1
	 * @return
	 */
	char   getChar(int position);
	/**
	 * 设置特定位置的文字。
	 * @param position 0到length -1
	 * @param value 被设置文字
	 */
	void   setChar(int position, char value);
}
