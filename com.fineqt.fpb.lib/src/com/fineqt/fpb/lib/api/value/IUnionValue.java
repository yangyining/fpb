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
 * union类型值对象类。
 * 
 * @author JiangMin
 *
 */
public interface IUnionValue extends IContainerValue {
	/**
	 * 取得当前有效的变量（字段）。没有则返回null。
	 * @return
	 */
	IValue getPresentVariant();
	/**
	 * 取得当前有效变量（字段）的名称。没有则返回null。
	 * @return
	 */
	String getPresentVariantName();
	/**
	 * 取得说有候补变量（字段）的名称。
	 * @return
	 */
	String[] getVariantNames();
}
