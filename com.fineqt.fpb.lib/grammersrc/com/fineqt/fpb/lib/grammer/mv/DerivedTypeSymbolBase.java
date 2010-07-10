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

import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.modelview.EnumTypeItemMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

abstract public class DerivedTypeSymbolBase extends TypeSymbolBase {
	protected TypeMV superType;
	
	public DerivedTypeSymbolBase(ModuleMV module) {
		super(module);
	}

	public TypeMV getSuperType() {
		return superType;
	}

	public void setSuperType(TypeMV superType) {
		this.superType = superType;
	}

	@Override
	public FieldMV getFieldMV(String fieldName) {
		if (superType == null)
			return null;
		return superType.getFieldMV(fieldName);
	}

	@Override
	public String[] getFieldNames() {
		if (superType == null)
			return null;
		return superType.getFieldNames();
	}

	@Override
	public ListItemMV getListItemMV() {
		return superType.getListItemMV();
	}

	@Override
	public EnumTypeItemMV getEnumTypeItemMV(String itemName) {
		return superType.getEnumTypeItemMV(itemName);
	}

	@Override
	public Collection<String> getEnumTypeItemNames() {
		return superType.getEnumTypeItemNames();
	}

	@Override
	public TypeClass getTypeClass() {
		if (superType == null)
			return null;
		return superType.getTypeClass();
	}
	
	@Override
	public TypeMV getRootTypeMV() {
		if (superType == null)
			return null;
		return superType.getRootTypeMV();
	}

	@Override
	public TypeMV getSuperTypeMV() {
		return superType;
	}

	@Override
	public boolean isContainerType() {
		return superType.isContainerType();
	}

	@Override
	public boolean isListType() {
		return superType.isListType();
	}

	@Override
	public boolean isPrimitiveType() {
		return superType.isPrimitiveType();
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("superType", superType==null?null:superType.getFullName())
			.toString();
	}
	
}
