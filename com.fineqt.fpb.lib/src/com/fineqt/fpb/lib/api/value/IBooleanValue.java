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
 * boolean类型值对象类。
 * 
 * @author JiangMin
 *
 */
public interface IBooleanValue extends IPrimitiveValue {
	/**
	 * 取得值对象的布尔值。
	 * @return
	 */
	boolean getBoolean();
	/**
	 * 设置值对象的布尔值。
	 * @param value
	 */
	void setBoolean(boolean value);
}
