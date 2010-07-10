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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.model.fpbmodule.PProperty;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PPropertyListExt extends PElementExtBase {
	private List<PPropertyExt> properties = new ArrayList<PPropertyExt>();
	private Set<String> unusedProperties = new HashSet<String>();
	
	public PPropertyListExt(PPropertyList pmodel, PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta.getPModule());
		for (PProperty prp : pmodel.getProperties()) {
			PPropertyExt meta = new PPropertyExt(prp, ownerMeta);
			properties.add(meta);
			unusedProperties.add(meta.getName());
		}
	}

	@Override
	protected void doInit() throws InitMetaException {
		for (PPropertyExt meta : properties) {
			meta.init();
		}
		super.doInit();
	}

	public List<PPropertyExt> getProperties() {
		return properties;
	}

	public PPropertyExt getProperty(String prpName) {
		for (PPropertyExt prp : properties) {
			if (prp.getName().equals(prpName)) {
				unusedProperties.remove(prpName);
				return prp;
			}
		}
		return null;
	}

	public Set<String> getUnusedProperties() {
		return unusedProperties;
	}
}
