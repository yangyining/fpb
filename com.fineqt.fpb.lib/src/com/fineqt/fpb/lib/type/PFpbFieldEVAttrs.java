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

import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.evattr.StackFieldOperation;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.value.PValue;

public interface PFpbFieldEVAttrs {
	List<PTypeConstraintExt> getCaseCond();
	boolean isSetCaseCond();
	
	PValue getDefaultValue();
	boolean isSetDefaultValue();
	
	/**
	 * @return -1代表无效
	 */
	int getDefaultLength();
	boolean isSetDefaultLength();
	
	StackFieldOperation getSetField();
	boolean isSetSetField();
	
	boolean isDefaultPresent();
	boolean isSetDefaultPresent();
	
	FlagFieldType getFlagType();
	boolean isSetFlagType();
	
	boolean isOverrideWhole();
	boolean isSetOverrideWhole();
	
}
