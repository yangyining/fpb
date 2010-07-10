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
package com.fineqt.fpb.lib.value;

import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeEVAttrs;
import com.fineqt.fpb.lib.type.PTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;

/**
 * 类型元素设置。
 * 
 * 类型元素包括类型、字段和列表项目，都是可以参加编码和解码的元素，具有自己的类型信息。
 * 
 * @author JiangMin
 *
 */
public interface PTypeElementMeta {
	PModuleExt getPModule();
    /**
     * 是否是可选的(当当前对象是optional的字段或列表的项目时为true)。
     * @return
     */
    boolean isOptional();
    /**
     * 优先编码变量。所在Field或者派生的SubType或ImportType的。
     * @return
     */
    PTypeEVExt getPriorityVariant();
    /**
     * 类型限制。所在Field或List项目或派生SubType的。
     * @return
     */
    PTypeConstraintStorage getConstraints();
    /**
     * 优先EV属性集合.优先EV属性比源类型的EV属性优先。优先EV属性集合通常在PFieldEV的overrideWhole
     * 被设置成false时被设置。
     * @return
     */
    PTypeEVAttrs getPriorityAttrs();
	/**
	 * 作为Value的类型Meta。
	 * @return
	 */
	PTypeExt asTypeMeta();
	/**
	 * 作为Value所在容器（Record,Set,Union）字段的Meta，可能为null。
	 * @return
	 */
	PFieldExt asFieldMeta();
	/**
	 * 作为Value所在列表（RecordOf,SetOf）项目的Meta，可能为null。
	 * @return
	 */
	PListItemExt asListItemMeta();
}
