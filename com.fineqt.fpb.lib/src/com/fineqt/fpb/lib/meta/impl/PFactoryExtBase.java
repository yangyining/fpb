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

import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.PFactoryExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PFactoryExtBase implements PFactoryExt{
	protected PModuleExt pmodule;
	
	@Override
	public PModuleExt getPModule() {
		return pmodule;
	}
	@Override
	public void setPModule(PModuleExt module) {
		this.pmodule = module;
	}

	protected PValue createObjByMode(ValueMode mode, PTypeExt typeMeta) {
		switch(mode) {
		case EMPTY:
			return typeMeta.createEmptyValue();
		case OMIT:
			return typeMeta.createOmitValue();
		default:
			return typeMeta.createNormalValue();
		}
	}

	@Override
	public IValue createValue(int typeID) {
		return createPValue(typeID);
	}
	@Override
	public IValue createValue(IType type) {
		return createPValue((PTypeExt)type);
	}
	@Override
	public IValue createValue(String typeName) {
		PTypeExt typeMeta = pmodule.pPType(typeName);
		if (typeMeta == null) {
			return null;
		}
		return createValue(typeMeta);
	}
	@Override
	public IValue createOmitValue(int typeID) {
		return createOmitPValue(typeID);
	}
	@Override
	public IValue createOmitValue(IType type) {
		return createOmitPValue((PTypeExt)type);
	}
	@Override
	public IValue createOmitValue(String typeName) {
		PTypeExt typeMeta = pmodule.pPType(typeName);
		if (typeMeta == null) {
			return null;
		}
		return createOmitValue(typeMeta);
	}
	@Override
	public IModule getModule() {
		return pmodule;
	}

	@Override
	public void postInitModule(PModuleExt module) throws InitMetaException {
		
	}
	@Override
	public void preInitModule(PModuleExt module) throws InitMetaException {
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("pmodule", pmodule==null?null:pmodule.getModuleName())
			.toString();
	}
	
	protected enum ValueMode {DEFAULT, EMPTY, OMIT};

}
