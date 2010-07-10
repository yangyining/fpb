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
package com.fineqt.fpb.lib.constraint;

import java.util.Collections;
import java.util.List;

import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PTypeConstraintExtBase extends PElementExtBase 
implements PTypeConstraintExt {
	protected PTypeExt targetType;

	public PTypeConstraintExtBase(PModelElement pmodel, PTypeExt targetType) {
		super(pmodel, targetType.getPModule());
		this.targetType = targetType;
	}

	@Override
	public PTypeExt getTargetType() {
		return targetType;
	}

	@Override
	public boolean validate(PValue value) {
		return validate(value, null);
	}
	
	@Override
	public List<PTypeConstraintExt> getChildren() {
		return Collections.emptyList();
	}

	@Override
	public boolean isCompound() {
		return false;
	}

	@Override
	public boolean isLeaf() {
		return true;
	}
	
}
