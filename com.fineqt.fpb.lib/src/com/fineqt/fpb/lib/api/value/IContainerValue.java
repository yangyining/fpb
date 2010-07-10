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
 * 容器值对象类型(Record、Set和Union)的基类。
 * 
 * @author JiangMin
 *
 */
public interface IContainerValue extends IValue {
	/**
	 * 根据字段索引来取得字段的值。
	 * @param fieldIndex 字段索引（从0开始）。
	 * @return 如果指定字段不存在则返回null。
	 */
	IValue getField(int fieldIndex);
	/**
	 * 根据字段索引来取得字段的值。如果指定字段的值是null或omit时将根据newWhenOmitOrNull参数来决定
	 * 是否生成并设置新值对象。
	 * @param fieldIndex 字段索引（从0开始）。
	 * @param newWhenOmitOrNull 指定字段的值是null或omit时是否生成并设置新值对象。
	 * @return 如果指定字段不存在则返回null。
	 */
	IValue getField(int fieldIndex, boolean newWhenOmitOrNull);
	/**
	 * 将参数value设置到参数fiendIndex指定的字段中。
	 * 如果对应字段不存在则该操作被忽略。
	 * @param fieldIndex 字段索引（从0开始）。
	 * @param value 目标字段值。
	 */
	void setField(int fieldIndex, IValue value);
	/**
	 * 根据字段名称来取得字段的值。
	 * @param fieldName 字段名称。
	 * @return 如果指定字段不存在则返回null。
	 */
	IValue getField(String fieldName);
	/**
	 * 根据字段名称来取得字段的值。如果指定字段的值是null或omit时将根据newWhenOmitOrNull参数来决定
	 * 是否生成并设置新值对象。
	 * @param fieldName 字段名称。
	 * @param newWhenOmitOrNull 指定字段的值是null或omit时是否生成并设置新值对象。
	 * @return 如果指定字段不存在则返回null。
	 */
	IValue getField(String fieldName, boolean newWhenOmitOrNull);
	/**
	 * 将参数value设置到参数fiendName指定的字段中。
	 * 如果对应字段不存在则该操作被忽略。
	 * @param fieldName 参数名称。
	 * @param value 目标字段值。
	 */
	void setField(String fieldName, IValue value);
}
