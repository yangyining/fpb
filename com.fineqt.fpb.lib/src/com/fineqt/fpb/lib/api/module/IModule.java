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


/**
 * 模块类。
 * 
 * @author JiangMin
 *
 */
public interface IModule {
	/**
	 * 取得模块名称。
	 * @return
	 */
	String getModuleName();
	/**
	 * 取得值对象工厂实例，通过该工厂对象来生成该模块内各种类型的值对象。
	 * @return
	 */
	IFactory getFactory();
	/**
	 * 以类型标示符取得模块内类型定义。
	 * @param typeID
	 * @return
	 */
	IType getType(int typeID);
	/**
	 * 以类型名称取得模块内类型定义。
	 * @param typeName
	 * @return
	 */
	IType getType(String typeName);
	/**
	 * 取得所有类型的全称。
	 * @return
	 */
	String[] getTypeNames();
	/**
	 * 以模版标示符取得模块内模版定义。
	 * @param typeID
	 * @return
	 */
	ITemplate getTemplate(int typeID);
	/**
	 * 以模版名称取得模块内模版定义。
	 * @param typeName
	 * @return
	 */
	ITemplate getTemplate(String typeName);
	/**
	 * 取得所有模型的全称。
	 */
	String[] getTemplateNames();
	/**
	 * 以常量对象标示符取得模块内常量对象。
	 * @param constantID
	 * @return
	 */
	IConstant getConstant(int constantID);
	/**
	 * 以常量对象名称取得模块内常量对象。
	 * @param constantName
	 * @return
	 */
	IConstant getConstant(String constantName);
	/**
	 * 取得所有常量的全称。
	 * @return
	 */
	String[] getConstantNames();
	/**
	 * 取得所有模块参数的全称。
	 * @return
	 */
	String[] getModuleParNames();
	/**
	 * 以模块参数对象标示符取得模块内模块参数对象。
	 * @param moduleParID
	 * @return
	 */
	IModulePar getModulePar(int moduleParID);
	/**
	 * 以模块参数对象名称取得模块内模块参数对象。
	 * @param moduleParName
	 * @return
	 */
	IModulePar getModulePar(String moduleParName);
}
