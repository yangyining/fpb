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

import java.util.Collection;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.model.fpbmodule.PListType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.modelview.EnumTypeItemMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;

public class ListTypeSymbol extends EntityTypeSymbolBase {
	private PListType model;
	private ListItemSymbol listItem;
	
	public ListTypeSymbol(ModuleMV module, String name, TypeClass typeClass, String itemTypeName) {
		super(module, name, typeClass);
		listItem = new ListItemSymbol(this, itemTypeName);
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
	public EnumTypeItemMV getEnumTypeItemMV(String itemName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<String> getEnumTypeItemNames() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListItemMV getListItemMV() {
		return listItem;
	}

	
	@Override
	public boolean isContainerType() {
		return false;
	}

	@Override
	public boolean isListType() {
		return true;
	}

	@Override
	public boolean isPrimitiveType() {
		return false;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("listItem", listItem)
			.toString();
	}

	public PListType getModel() {
		return model;
	}

	public void setModel(PListType model) {
		this.model = model;
	}
	
	@Override
	public PType getTypeModel() {
		return model;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		//父方法
		super.doInitModel(cxt);
		//项目
		assert listItem != null;
		listItem.initModel(cxt);
	}

	public ListItemSymbol getListItem() {
		return listItem;
	}

	public void setListItem(ListItemSymbol listItem) {
		this.listItem = listItem;
	}
	
}
