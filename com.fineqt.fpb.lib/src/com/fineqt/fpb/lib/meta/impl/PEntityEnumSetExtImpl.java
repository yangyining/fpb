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

import java.util.ArrayList;
import java.util.List;

import com.fineqt.fpb.lib.meta.PEntityEnumSetExt;
import com.fineqt.fpb.lib.meta.PEnumItemExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.type.PTypeExt;

public class PEntityEnumSetExtImpl extends PEnumSetExtBase implements PEntityEnumSetExt{
	private List<PEnumItemExt> enumItems = new ArrayList<PEnumItemExt>();
	private PTypeExt typeMeta;
	private String name;
	
	public PEntityEnumSetExtImpl(PEntityEnumSet model, PModuleExt module) {
		super(model, module);
		//Name
		this.name = model.getName();
	}
	
	@Override
	public List<PEnumItemExt> getEnumItems() {
		return enumItems;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public PTypeExt getBaseType() {
		return typeMeta;
	}

	@Override
	public String getFullName() {
		return pmoduleExt.getModuleName() + "." + name;
	}

	@Override
	public boolean isImport() {
		return false;
	}

	@Override
	public void init() throws InitMetaException {
		PEntityEnumSet model = (PEntityEnumSet)pmodel;
		//basetype
		typeMeta = getPModule().pPType(model.getBaseTypeName());
		if (typeMeta == null) {
			throw new InitMetaException(getPModule(), MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
					model.getBaseTypeName(), getPModule().getModuleName());
		}
		//生成EnumItem
		for (PEnumItem item : model.getEnumItems()) {
			PEnumItemExt itemMeta = new PEnumItemExtImpl(item, typeMeta);
			itemMeta.init();
			enumItems.add(itemMeta);
		}
	}
	
}
