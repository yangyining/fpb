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
package com.fineqt.fpb.lib.modelview;

import java.util.Collection;

import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;

public interface TypeMV extends ModuleElementMV{
	/**
	 * 取得该类型的类型分类。
	 * @return
	 */
	TypeClass getTypeClass();
	/**
	 * 取得字段的定义，只对Container类型有效。
	 * @return
	 */
	FieldMV getFieldMV(String fieldName);
	/**
	 * 取得子所有字段的名称，只对Container类型有效。
	 * @return
	 */
	String[] getFieldNames();
	/**
	 * 取得列表内项目的类型，只读List类型有效。
	 * @return
	 */
	ListItemMV getListItemMV();
	/**
	 * 取得枚举类型的项目定义，只对Enumerated类型有效。
	 * @param itemName
	 * @return
	 */
	EnumTypeItemMV getEnumTypeItemMV(String itemName);
	/**
	 * 取得所有枚举类型项目名称，只对Enumerated类型有效。
	 * @return
	 */
	Collection<String> getEnumTypeItemNames();
	/**
	 * 取得该类型的派生模式。
	 * @return
	 */
	TypeDerivativeMode getDerivativeMode();
	/**
	 * 取得上位类型。
	 * @return
	 */
	TypeMV getSuperTypeMV();
	/**
	 * 取得根（最上位）类型。
	 * @return
	 */
	TypeMV getRootTypeMV();
	boolean isCompatibleMV(TypeMV dstType);
	/**
	 * 取得编码类型。
	 * @return
	 */
	EncodingType getEncodingType();
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
	
}
