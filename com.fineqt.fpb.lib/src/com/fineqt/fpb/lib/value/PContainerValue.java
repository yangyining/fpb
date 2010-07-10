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

import com.fineqt.fpb.lib.api.value.IContainerValue;

public interface PContainerValue extends PValue, IContainerValue {
	/**
	 * 对应字段不存在则返回空。
	 * @param fieldId
	 * @return
	 */
	PValue pGetFieldByID(int fieldId);
	PValue pGetFieldByID(int fieldId, boolean newWhenOmitOrNull);
	/**
	 * 对应字段不存在则该操作被忽略。
	 * @param fieldId
	 * @param value 可以为null
	 */
	void pSetFieldByID(int fieldId, PValue value);
	/**
	 * 对应字段不存在则返回空。
	 * @param fieldName
	 * @return
	 */
	PValue pGetFieldByName(String fieldName);
	PValue pGetFieldByName(String fieldName, boolean newWhenOmitOrNull);
	/**
	 * 对应字段不存在则该操作被忽略。
	 * @param fieldName
	 * @param value
	 */
	void pSetFieldByName(String fieldName, PValue value);
}
