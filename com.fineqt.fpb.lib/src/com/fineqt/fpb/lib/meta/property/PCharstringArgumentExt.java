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
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PCharstringArgumentExt extends PValueArgumentExtBase  {
	private PCharstringValue value;
	
	public PCharstringArgumentExt(PCharstringArgument pmodel, PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta);
	}

	@Override
	protected void doInit() throws InitMetaException {
		value = (PCharstringValue)BuiltinFactory.BUILTIN_INSTANCE.createCharstring();
		value.setText(((PCharstringArgument)pmodel).getDesc());
		super.doInit();
	}

	public PCharstringValue getValue() {
		return value;
	}

	@Override
	public TypeClass getValueTypeClass() {
		return TypeClass.CHARSTRING;
	}

	@Override
	public Type getType() {
		return Type.CHARSTRING;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("value", value==null?null:value.getText())
			.toString();
	}
}
