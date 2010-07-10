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

import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.builtin.PBooleanValue;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PBooleanArgumentExt extends PValueArgumentExtBase {
	private PBooleanValue value;
	
	public PBooleanArgumentExt(PBooleanArgument pmodel, PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta);
	}

	@Override
	protected void doInit() throws InitMetaException {
		value = (PBooleanValue)BuiltinFactory.BUILTIN_INSTANCE.createBoolean();
		value.setText(((PBooleanArgument)pmodel).getDesc());
		super.doInit();
	}

	public PBooleanValue getValue() {
		return value;
	}

	@Override
	public TypeClass getValueTypeClass() {
		return TypeClass.BOOLEAN;
	}

	@Override
	public Type getType() {
		return Type.BOOLEAN;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("value", value==null?null:value.getBoolean())
			.toString();
	}
	
}
