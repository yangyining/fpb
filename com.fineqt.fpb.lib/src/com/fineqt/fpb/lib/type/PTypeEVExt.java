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
package com.fineqt.fpb.lib.type;

import com.fineqt.fpb.lib.meta.PEVExt;
import com.fineqt.fpb.lib.meta.property.PPropertyListExt;

public interface PTypeEVExt extends PEVExt {
	/**
	 * 取得该EV所描述的目标类型的Meta。
	 * @return
	 */
	PTypeExt getTargetTypeMeta();
	void setTargetTypeMeta(PTypeExt target);
	/**
	 * 取得该EV的拥有者。
	 * 当该EV在PField中定义时则拥有者为该字段的所在类型。
	 * 当该EV在PType中定义是则拥有者为这个PType代表的类型。
	 * @return
	 */
	PTypeExt getOnwerTypeMeta();
	void setOnwerTypeMeta(PTypeExt owner);

	/**
	 * 有设置过的属性，也就是有非默认设置。
	 * @return
	 */
	boolean hasSettedAttr();
	/**
	 * 设置外部的特性列表，用于初始化。
	 * @param prpList
	 */
	void setInitPropertyList(PPropertyListExt prpList);
	
	PTypeEVAttrs getTypeEVAttrs();	
	
}
