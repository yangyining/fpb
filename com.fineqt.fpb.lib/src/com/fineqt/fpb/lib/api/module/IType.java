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
package com.fineqt.fpb.lib.api.module;

import com.fineqt.fpb.lib.api.value.IPath;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;

/**
 * 类型定义类。
 * 
 * @author JiangMin
 *
 */
public interface IType extends IModuleElement {
	/**
	 * 是否是Record,Set或Union
	 * @return
	 */
	boolean isContainerType();
	/**
	 * 是否是RecordOf或SetOf
	 * @return
	 */
	boolean isListType();
	/**
	 * 是否是Primitive
	 * @return
	 */
	boolean isPrimitiveType();
	/**
	 * 取得所有字段的名称。仅对ContainerType有效。
	 * @return
	 */
	String[] getFieldNames();
	/**
	 * 取得字段的总数。仅对ContainerType有效。
	 * @return
	 */
	int getFieldSize();
	/**
	 * 根据字段索引（0开始）取得字段类型。仅对ContainerType有效。
	 * @param fieldName
	 * @return
	 */
	IType getFieldType(int fieldIndex);
	/**
	 * 根据字段名称取得字段类型。仅对ContainerType有效。
	 * @param fieldName
	 * @return
	 */
	IType getFieldType(String fieldName);
	/**
	 * 取得列表项目的类型。仅对ListType有效。
	 * @return
	 */
	IType getItemType();
	/**
	 * 生成以该类型为目标的Path对象。
	 * @param pathDesc 路径描述
	 * @return
	 */
	IPath createPath(String pathDesc) throws MetaException;
	/**
	 * 取得类型分类。
	 * @return
	 */
	TypeClass getTypeClass();
}
