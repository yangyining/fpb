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

import java.util.List;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PListArgument;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PListArgumentExt extends PArgumentExt {
	PArgumentGroupExt group;
	
	public PListArgumentExt(PListArgument pmodel, PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta);
		assert pmodel.getGroup() != null;
		group = new PArgumentGroupExt(pmodel.getGroup(), ownerMeta);
	}

	@Override
	protected void doInit() throws InitMetaException {
		super.doInit();
		group.init();
	}

	public List<PArgumentExt> getItems() {
		return group.getArguments();
	}

	@Override
	public Type getType() {
		return Type.LIST;
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
}
