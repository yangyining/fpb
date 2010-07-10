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
package com.fineqt.fpb.lib.meta.impl;

import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.PEnumItemExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PEnumItemExtImpl implements PEnumItemExt {
	private PEnumItem model;
	private PTypeConstraintExt condition;
	private PTypeExt typeMeta;
	
	public PEnumItemExtImpl(PEnumItem model, PTypeExt typeMeta) {
		this.model = model;
		this.typeMeta = typeMeta;
	}
	
	@Override
	public String getName() {
		return model.getName();
	}

	@Override
	public TypeClass getTypeClass() {
		return typeMeta.getTypeClass();
	}

	@Override
	public PTypeConstraintExt getCondition() {
		return condition;
	}

	@Override
	public boolean match(PValue value) {
		return condition.validate(value);
	}

	@Override
	public void init() throws InitMetaException {
		condition = PElementExtFactory.INSTANCE.createTypeConstraint(typeMeta, 
				model.getCond());
	}

}
