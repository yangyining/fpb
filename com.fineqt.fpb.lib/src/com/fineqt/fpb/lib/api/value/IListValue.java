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
 * set of和record of类型值对象类。
 * 
 * @author JiangMin
 *
 * @param <T>
 */

public interface IListValue<T extends IValue> extends IValue {
	/**
	 * 取得指定位置的列表项目的值。并根据newWhenNull参数来决定是否生成并设置默认值对象。
	 * @param position 列表索引（从0开始）。
	 * @param newWhenNull 当指定列表项目存在但是值是null时是否生成并设置默认值对象。
	 * @return 如果指定列表项目不存在则返回null。
	 */
	T getItem(int position, boolean newWhenNull);
	
	/**
	 * 取得指定位置的列表项目的值。
	 * @param position 列表索引（从0开始）。
	 * @return 如果指定列表项目不存在则返回null。
	 */
	T getItem(int position);
	/**
	 * 将参数value设置到参数position指定的列表项目中去。
	 * 如果该项目不存在该操作将被忽略。
	 * @param position 列表索引（从0开始）。
	 * @param value 目标项目值。
	 */
	void setItem(int position, T value);
	
	/**
	 * 在列表尾部增加一个值为参数value的项目。
	 * @param value
	 */
	void appendItem(T value);
	
	/**
	 * 取得该列表的长度。
	 * @return
	 */
	int	getLength();
	
	/**
	 * 设置列表的长度，当原来长度小于或大于参数len指定的长度时将在列表末尾追加或删除列表项目直到长度为len。
	 * 列表末尾追加的项目值将为null。
	 * @param len 列表长度
	 */
	void setLength(int len);
}
