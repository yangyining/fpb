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
package com.fineqt.fpb.lib.type.impl;

import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PSubType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;
import com.fineqt.fpb.lib.type.PSubTypeExt;

public class PSubTypeExtImpl extends PDerivedTypeExtBase implements PSubTypeExt {
	private String superTypeName;
	private String name;
	
	public PSubTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super((PSubType)pmodel, pmoduleExt);
		superTypeName = ((PSubType)pmodel).getSuperTypeName();
		name = pmodel.getName();
		assert superTypeName != null;
		assert name != null;
	}

	@Override
	public String getSuperTypeName() {
		return superTypeName;
	}


	@Override
	public String getName() {
		return name;
	}

	@Override
	public TypeDerivativeMode getDerivativeMode() {
		return TypeDerivativeMode.SUB;
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父类方法
		super.doInit();
		PSubType subTypeModel = (PSubType)pmodel;
		//编译自己限制信息
		if (subTypeModel.getConstraint() != null) {
			PTypeConstraintExt cons = extFactory.createTypeConstraint(this, 
					subTypeModel.getConstraint());
			pconstraints.addConstraint(cons);
		}
	}


	@Override
	public boolean isImport() {
		return false;
	}
	
}
