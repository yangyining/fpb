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

import com.fineqt.fpb.lib.api.value.IValue;

/**
 * 值对象工厂类。与模块相对应,用来创建模块内各种类型的值对象。
 * 
 * @author JiangMin
 *
 */
public interface IFactory extends IBuiltinFactory {
	/**
	 * 取得对应的模块对象。
	 * @return
	 */
	IModule getModule();
	/**
	 * 根据类型对象来创建该类型的值对象，它的值为模块定义的默认值。
	 * @param type 目标类型的对象
	 * @return 类型为目标类型的值对象。
	 */
	IValue createValue(IType type);
	/**
	 * 根据类型名称来创建该类型的值对象，它的值为模块定义的默认值。
	 * @param typeName 目标类型的名称
	 * @return 类型为目标类型的值对象。
	 */
	IValue createValue(String typeName);
	/**
	 * 根据类型标示符来创建该类型的值对象，它的值为模块定义的默认值。
	 * @param typeID 目标类型的标示符
	 * @return 类型为目标类型的值对象。
	 */
	IValue createValue(int typeID);
	/**
	 * 根据类型标示符来创建该类型的omit值对象。
	 * @param type 目标类型的对象
	 * @return 类型为目标类型的值对象。
	 */
	IValue createOmitValue(IType type);
	/**
	 * 根据类型标示符来创建该类型的omit值对象。
	 * @param typeName 目标类型的名称
	 * @return 类型为目标类型的值对象。
	 */
	IValue createOmitValue(String typeName);
	/**
	 * 根据类型标示符来创建该类型的omit值对象。
	 * @param typeID 目标类型的标示符
	 * @return 类型为目标类型的值对象。
	 */
	IValue createOmitValue(int typeID);
}
