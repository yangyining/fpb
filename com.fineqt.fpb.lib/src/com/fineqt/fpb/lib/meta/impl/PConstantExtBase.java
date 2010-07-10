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

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.modelview.TypeMV;

abstract public class PConstantExtBase extends PModuleElementExtBase implements PConstantExt {
	private int constantID;
	
	public PConstantExtBase(PConstant pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		//ID
		this.constantID = pmodel.getConstantID();
	}

	@Override
	public int getID() {
		return constantID;
	}

	@Override
	public IValue getValue() {
		return (IValue)getPValue().clone();
	}

	@Override
	public Type getModuleElementType() {
		return Type.CONSTANT;
	}

	@Override
	public IType getType() {
		return getBasetype();
	}

	@Override
	public TypeMV getBaseTypeMV() {
		return getBasetype();
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("fullName", getFullName())
			.append("value", getPValue())
			.toString();
	}
}
