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
package com.fineqt.fpb.lib.api.util;

import java.util.Collection;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.meta.PModuleExt;
/**
 * 模块注册器。通过该注册器来取得所需的模块对象实例。
 * 
 * @author JiangMin
 *
 */
public interface IModuleRegistry {
	/**
	 * 全局实例。
	 */
	IModuleRegistry INSTANCE = PModuleExt.Registry.PINSTANCE;
	/**
	 * 解决并取得模块对象实例。没有对应模块则返回null。
	 * @param moduleName 目标模块名称
	 * @return
	 */
	IModule resolveModule(String moduleName);
	/**
	 * 解决并取得值对象工厂的实例，首先会解决对象的模块。没有对应模块则返回null。
	 * @param moduleName 目标模块名称
	 * @return
	 */
	IFactory resolveFactory(String moduleName);
	/**
	 * 取得所有已登记的模块。
	 * @return
	 */
	Collection<String> allModuleNames();
}
