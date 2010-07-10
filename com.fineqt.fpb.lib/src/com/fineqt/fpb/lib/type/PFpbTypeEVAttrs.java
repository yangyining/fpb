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

import java.util.List;

import com.fineqt.fpb.lib.builtin.PStringValue;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.evattr.DisplayFormat;
import com.fineqt.fpb.lib.meta.evattr.FieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.RegionRefDesc;
import com.fineqt.fpb.lib.meta.evattr.StackFieldOperation;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.OnelineMode;
import com.fineqt.fpb.lib.model.fpbmodule.PadType;

public interface PFpbTypeEVAttrs extends PTypeEVAttrs {
	boolean hasSettedAttr();
	/**
	 * 设置默认ByteOrder
	 */
	void setDefaultByteOrder(ByteOrder byteOrder);
	ByteOrder getDefaultByteOrder();
	/**
	 * 取得LengthMultiplier属性，如果priorityAttrs非空并且同名属性已被设置了的话，则priorityAttrs
	 * 中的属性值优先。
	 * @param priorityAttrs
	 * @return
	 */
	int getLengthMultiplier(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetLengthMultiplier();
	
	int getLengthIncrement(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetLengthIncrement();
	
	boolean isRefreshLengthRef(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetRefreshLengthRef();
	
	OnelineMode getOnelineMode(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetOnelineMode();
	
	boolean isRestOfData(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetRestOfData();
	
	ByteOrder getByteorder(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetByteorder();
	
	FieldRefDesc getLengthRef(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetLengthRef();
	
	List<StackFieldOperation> getPushEmptyField(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetPushEmptyField();
	
	FieldRefDesc getSelectRef(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetSelectRef();
	
	List<PTypeConstraintExt> getSelectCond(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetSelectCond();
	
	RegionRefDesc getSelectRefRegion(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetSelectRefRegion();
	
	PadType getPadType(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetPadType();
	
	/**
	 * 
	 * @param priorityAttrs
	 * @return 可能是PBitstringValue或POctetstringValue
	 */
	PStringValue getPadValue(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetPadValue();
	
	boolean isSigned(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetSigned();
	
	int getLength(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetLength();
	
	boolean isProtocol(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetProtocol();
	
	FieldRefDesc getRepeatRef(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetRepeatRef();
	
	boolean isRefreshRepeatRef(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetRefreshRepeatRef();
	
	FieldRefDesc getCaseRef(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetCaseRef();
	
	RegionRefDesc getCaseRefRegion(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetCaseRefRegion();

	PFieldExt getCaseDefault(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetCaseDefault();
	
	DisplayFormat getFormat(PFpbTypeEVAttrs priorityAttrs);
	boolean isSetFormat();
	
	/**
	 * 使用srcAttrs中有修改的特性覆盖自己对应没有修改的特性。
	 * @param srcAttrs
	 */
	void overrideNotChangedByChanged(PFpbTypeEVAttrs srcAttrs);
}
