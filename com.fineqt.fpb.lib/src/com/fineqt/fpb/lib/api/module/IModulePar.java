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
 * 模块参数对象类。
 * 
 * @author JiangMin
 *
 */
public interface IModulePar extends IModuleElement{
	/**
	 * 取得模块参数值的副本。
	 * @param constantID
	 * @return
	 */
	IValue getValue();
	/**
	 * 取得模块参数的类型。
	 * @return
	 */
	IType getType();
	/**
	 * 设置模块参数的全局初始值。
	 * @param value
	 */
	void setInitValue(IValue value);
	/**
	 * 设置模块参数的线程局部值。只有在isThreadLocal（）方法返回true时有效。
	 * @param value
	 */
	void setLocalValue(IValue value);
	/**
	 * 判断该ModulePar是否有独立的Thread局部状态。
	 * 在有独立Thread局部状态的情况下，通过getValue方法取得参数值副本时，首先判断是否有线程局部值
	 * （用setLocalValue设置），然后再使用全局初始值（用setInitValue设置或模块定义内的设置）。
	 * @return
	 */
	boolean isThreadLocal();
}
