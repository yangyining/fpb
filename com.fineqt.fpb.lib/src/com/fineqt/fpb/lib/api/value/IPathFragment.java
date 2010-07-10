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

import com.fineqt.fpb.lib.api.module.IType;

/**
 * 路径片断类。片断可以指定容器类型（record, set, union）的字段或列表类型（recordOf, setOf）的元素。
 * 
 * @author JiangMin
 *
 */
public interface IPathFragment {
	/**
	 * 取得指定列表元素的索引。
	 * @return 元素的索引，从0开始。
	 */
	int getListIndex();
	/**
	 * 取得指定字段的名称。
	 * @return
	 */
	String getFieldName();
	/**
	 * 运用片断的目标类型，即该片断的根类型。
	 * @return
	 */
	IType getTargetType();
	/**
	 * 引用字段的类型，即改片断的末端元素类型。
	 * @return
	 */
	IType getRefFieldType();
}
