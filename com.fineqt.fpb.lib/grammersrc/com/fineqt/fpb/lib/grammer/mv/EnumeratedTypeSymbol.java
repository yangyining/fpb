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
package com.fineqt.fpb.lib.grammer.mv;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.model.fpbmodule.PEnumerated;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.modelview.EnumTypeItemMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;

public class EnumeratedTypeSymbol extends EntityTypeSymbolBase {
	private PEnumerated model;
	private List<EnumTypeItemSymbol> items = new ArrayList<EnumTypeItemSymbol>();
	private List<String> itemNames = new ArrayList<String>();
	
	public EnumeratedTypeSymbol(ModuleMV module, String name,
			TypeClass typeClass) {
		super(module, name, typeClass);
		model = mfactory.createPEnumerated();
		model.setName(name);
	}

	@Override
	public FieldMV getFieldMV(String fieldName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String[] getFieldNames() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListItemMV getListItemMV() {
		throw new UnsupportedOperationException();
	}

	public PEnumerated getModel() {
		return model;
	}

	@Override
	public PType getTypeModel() {
		return model;
	}

	@Override
	public boolean isContainerType() {
		return false;
	}

	@Override
	public boolean isListType() {
		return false;
	}

	@Override
	public boolean isPrimitiveType() {
		return true;
	}

	public void addItem(EnumTypeItemSymbol item) {
		items.add(item);
		itemNames.add(item.getEnumName());
	}
	
	public List<EnumTypeItemSymbol> getItems() {
		return Collections.unmodifiableList(items);
	}
	
	@Override
	public EnumTypeItemMV getEnumTypeItemMV(String itemName) {
		for (EnumTypeItemSymbol item : items) {
			if (item.getEnumName().equals(itemName)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public Collection<String> getEnumTypeItemNames() {
		return itemNames;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		for (EnumTypeItemSymbol item : items) {
			model.getItems().add(item.getModel());
		}
		super.doInitModel(cxt);
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("model", model)
			.toString();
	}

}
