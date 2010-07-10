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
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
/**
 * 模版定义类。
 * TODO 尚未实现。
 * 
 * @author JiangMin
 *
 */
public interface ITemplate extends IModuleElement {
	/**
	 * 取得模版的基类型。
	 * @return
	 */
	IType getType();
	
	IValue valueOf(Object ... paras) throws TemplateMatchingExption;
	
	boolean matchValue(IValue value, Object ... paras) throws TemplateMatchingExption;
}
