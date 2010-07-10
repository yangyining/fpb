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

import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

abstract public class EntityTypeSymbolBase extends TypeSymbolBase {
	private String name;
	private TypeClass typeClass;
	
	public EntityTypeSymbolBase(ModuleMV module, String name, TypeClass typeClass) {
		super(module);
		this.name = name;
		this.typeClass = typeClass;
	}

	@Override
	public String getFullName() {
		return getModuleMV().getModuleName() + "." + name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isImport() {
		return false;
	}

	@Override
	public TypeClass getTypeClass() {
		return typeClass;
	}
	
	@Override
	public TypeDerivativeMode getDerivativeMode() {
		return TypeDerivativeMode.ENTITY;
	}

	@Override
	public TypeMV getRootTypeMV() {
		return this;
	}

	@Override
	public TypeMV getSuperTypeMV() {
		return null;
	}

}
