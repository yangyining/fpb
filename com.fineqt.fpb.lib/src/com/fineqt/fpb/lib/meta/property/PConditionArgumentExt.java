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
package com.fineqt.fpb.lib.meta.property;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.constraint.PListConstraintExt;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PConditionArgumentExt extends PSingleArgumentExt {
	private PTypeConstraintExt condition;
	
	public PConditionArgumentExt(PConditionArgument pmodel, PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta);
	}

	@Override
	protected void doInit() throws InitMetaException {
		PConditionArgument argModel = (PConditionArgument)pmodel;
		assert argModel.getTypeName() != null;
		//type
		PTypeExt type = getPModule().pPType(argModel.getTypeName());
		if (type == null) {
			throw new InitMetaException(getPModule(), MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
					argModel.getTypeName(), getPModule().getModuleName());
		}
		//constraint
		assert argModel.getCondition() != null;
		condition = extFactory.createTypeConstraint(type, argModel.getCondition());
		condition.init();
		//父方法
		super.doInit();
	}

	
	@Override
	public PValue getValue() {
		throw new UnsupportedOperationException();
	}

	@Override
	public TypeClass getValueTypeClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isValueArgument() {
		return false;
	}

	public PTypeConstraintExt getCondition() {
		return condition;
	}

	public PValue getFixedValue() {
		if (condition instanceof PListConstraintExt) {
			return ((PListConstraintExt)condition).getFixedValue();
		}
		return null;
	}
	
	@Override
	public Type getType() {
		return Type.CONDITION;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("condition", condition)
			.toString();
	}
	
}
