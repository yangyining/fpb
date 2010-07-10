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
package com.fineqt.fpb.lib.value;

import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PTypeExt;

public interface PValue extends IValue{
	String OMIT_LITERAL = "omit";
	String TRUE_LITERAL = "true";
	String FALSE_LITERAL = "false";
	PFieldExt pFieldMeta();
	PTypeExt pTypeMeta();
	PTypeElementMeta pValueMeta();
	void pValueMeta(PTypeElementMeta newMeta);
	boolean isCompatible(PValue value);
	/**
	 * 赋予新的值。
	 * 在赋值前先做兼容性测试，然后拷贝新的值，但是原来的Meta信息并不改变。
	 * @param value
	 */
	void assignPValue(PValue value) throws IncompatibleValueException;
	/**
	 * 取得父亲值对象。
	 * @return
	 */
	PValue pParent();
	/**
	 * 设置父亲值对象。
	 * @param parent
	 */
	void pParent(PValue parent);
	boolean isPrimitive();
	boolean isContainer();
	boolean isList();
}
