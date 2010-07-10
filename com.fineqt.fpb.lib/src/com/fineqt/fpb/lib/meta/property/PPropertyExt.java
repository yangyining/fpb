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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup;
import com.fineqt.fpb.lib.model.fpbmodule.PProperty;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PPropertyExt extends PElementExtBase {
	private List<PArgumentGroupExt> groups = new ArrayList<PArgumentGroupExt>();
	private String name;
	
	public PPropertyExt(PProperty pmodel, PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta.getPModule());
		this.name = pmodel.getName();
		for (PArgumentGroup group : pmodel.getGroups()) {
			groups.add(new PArgumentGroupExt(group, ownerMeta));
		}
	}

	@Override
	protected void doInit() throws InitMetaException {
		for (PArgumentGroupExt meta : groups) {
			meta.init();
		}
		super.doInit();
	}

	public List<PArgumentGroupExt> getGroups() {
		return groups;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("name", name)
			.append("groups", groups)
			.toString();
	}
}
