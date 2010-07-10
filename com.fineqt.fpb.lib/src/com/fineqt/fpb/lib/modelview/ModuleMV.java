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
import java.util.List;


public interface ModuleMV {
	String getModuleName();
	TypeMV pTypeMV(String name);
	TemplateMV pTemplateMV(String name);
	ConstantMV pConstantMV(String name);
	ModuleParMV pModuleParMV(String name);
	EnumSetMV pEnumSetMV(String name);
	ModuleMV pImportedModuleMV(String moduleName);
	/**
	 * 取得指定模块元素的类型(包括Type,Template,Constant,ModulePar,EnumSet)。
	 * @param name 元素的名称或全称。
	 * @return 模块元素的类型，如果不存在则返回null。
	 */
	ModuleElementMV pModuleElement(String name);
	/**
	 * 取得指定类型的模块元素。
	 * @param type 模块元素的类型。null时表示所有类型。
	 * @param name 模块元素的名称。
	 * @return
	 */
	ModuleElementMV pModuleElement(ModuleElementMV.Type type, String name);
	/**
	 * 取得所有的模块元素。
	 * @return
	 */
	Collection<ModuleElementMV> allModuleElements();
	/**
	 * 取得指定类型实体模块元素的全称列表。
	 * @param type 模块元素的类型。不可为null。
	 * @return
	 */
	List<String> pEntityElements(ModuleElementMV.Type type);
	/**
	 * 取得指定类型导入模块元素的全称列表。
	 * @param type 模块元素的类型。不可为null。
	 * @return
	 */
	List<String> pImportElements(ModuleElementMV.Type type);
	
	/**
	 * 取得所有子类型。
	 * @return
	 */
	List<String> pSubTypes();
	
}
