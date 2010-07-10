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

import com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PIdentifierArgumentExt extends PSingleArgumentExt {
	private String id;
	
	public PIdentifierArgumentExt(PIdentifierArgument pmodel, PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta);
		id = pmodel.getDesc();
	}

	@Override
	public Type getType() {
		return Type.IDENTIFIER;
	}
	
	public String getId() {
		return id;
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
	
	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("id", id)
			.toString();
	}
	
}
