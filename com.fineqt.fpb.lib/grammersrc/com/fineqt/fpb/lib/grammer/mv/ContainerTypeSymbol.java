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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.model.fpbmodule.PContainerType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.modelview.EnumTypeItemMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;

public class ContainerTypeSymbol extends EntityTypeSymbolBase {
	private Map<String, FieldMV> fieldMap = new HashMap<String, FieldMV>();
	private List<FieldMV> fieldList = new ArrayList<FieldMV>();
	private List<String> fieldNames = new ArrayList<String>();
	private PContainerType model;
	
	public ContainerTypeSymbol(ModuleMV module, String name,
			TypeClass typeClass) {
		super(module, name, typeClass);
	}

	@Override
	public FieldMV getFieldMV(String fieldName) {
		return fieldMap.get(fieldName);
	}

	@Override
	public String[] getFieldNames() {
		return fieldNames.toArray(new String[fieldNames.size()]);
	}

	@Override
	public ListItemMV getListItemMV() {
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

	public List<FieldMV> getFieldList() {
		return fieldList;
	}
	
	public void addFieldMV(FieldMV field) {
		fieldMap.put(field.getFieldName(), field);
		fieldList.add(field);
		fieldNames.add(field.getFieldName());
	}

	public PContainerType getModel() {
		return model;
	}

	public void setModel(PContainerType model) {
		this.model = model;
	}

	@Override
	public PType getTypeModel() {
		return model;
	}
	
	@Override
	public boolean isContainerType() {
		return true;
	}

	@Override
	public boolean isListType() {
		return false;
	}

	@Override
	public boolean isPrimitiveType() {
		return false;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		//父方法
		super.doInitModel(cxt);
		//字段(按书写顺序)
		for (String fieldName : fieldNames) {
			FieldMV field = getFieldMV(fieldName);
			assert field != null;
			FieldSymbol symbol = (FieldSymbol)field;
			symbol.initModel(cxt);
		}
	}
	
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.appendSuper(super.toString());
		builder.append("model", model);
		builder.append(LN);
		for (int i = 0; i < fieldNames.size(); i++) {
			builder.append(TAB);
			builder.append("fields["+i+"]", fieldMap.get(fieldNames.get(i)));
			builder.append(LN);
		}
		return builder.toString();
			
	}

}
