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
package com.fineqt.fpb.lib.meta;

import com.fineqt.fpb.lib.api.module.IModulePar;
import com.fineqt.fpb.lib.modelview.ModuleParMV;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public interface PModuleParExt extends PModuleElementExt, IModulePar, ModuleParMV {
	PTypeExt getBasetype();
	/**
	 * 设置ModulePar的初始值。
	 * @param value
	 */
	void setInitPValue(PValue value);
	/**
	 * 设置ModulePar在不同Thread空间下的值。
	 * 只有在isThreadLocal()为true的情况下有效。
	 * @param value
	 */
	void setLocalPValue(PValue value);
	/**
	 * 取得ModulePar的当前值。
	 * 当isThreadLocal()为true时，首先会去取在当前Thread空间下用setLocalValue设置的值，
	 * 如果没有那样的值则返回初始值。
	 * @return
	 */
	PValue getPValue();
}
