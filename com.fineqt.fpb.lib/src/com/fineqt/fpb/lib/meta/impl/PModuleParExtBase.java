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

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PModuleParExtBase extends PModuleElementExtBase 
implements PModuleParExt {
	private int moduleParID;

	public PModuleParExtBase(PModulePar pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		//ID
		moduleParID = pmodel.getModuleParID();
	}

	@Override
	public int getID() {
		return moduleParID;
	}

	@Override
	public Type getModuleElementType() {
		return Type.MODULE_PARAMETER;
	}

	@Override
	public IValue getValue() {
		PValue value = getPValue();
		if (value != null) {
			return (PValue)value.clone();
		}
		return null;
	}

	@Override
	public TypeMV getBaseTypeMV() {
		return getBasetype();
	}

	@Override
	public IType getType() {
		return getBasetype();
	}

	@Override
	public void setInitValue(IValue value) {
		setInitPValue((PValue)value);
	}

	@Override
	public void setLocalValue(IValue value) {
		setLocalPValue((PValue)value);
	}

}
