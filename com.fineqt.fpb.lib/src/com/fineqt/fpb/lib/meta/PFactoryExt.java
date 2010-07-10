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

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public interface PFactoryExt extends IFactory, PModuleExtEventListener {
	PModuleExt getPModule();
	void setPModule(PModuleExt module);
	/**
	 * 生成指定类型的默认值，使用类型以及字段的默认设置（如defaultPresent, defaultValue等）。
	 * @param type
	 * @return
	 */
	PValue createPValue(PTypeExt type);
	PValue createPValue(int typeID);
	/**
	 * 生成指定类型的空值。
	 * Record和Set及Union字段时所有的字段为null,Primitive类型时为初始值不使用外部的初始设置（如defaultValue等），
	 * List的长度则固定为0。
	 * @param type
	 * @return
	 */
	PValue createEmptyPValue(PTypeExt type);
	PValue createEmptyPValue(int typeID);
	/**
	 * 生成指定类型的Omit值。
	 * @param type
	 * @return
	 */
	PValue createOmitPValue(PTypeExt type);
	PValue createOmitPValue(int typeID);
}
