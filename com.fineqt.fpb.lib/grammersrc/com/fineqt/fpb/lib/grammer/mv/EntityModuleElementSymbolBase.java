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

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

abstract public class EntityModuleElementSymbolBase extends ModuleElementSymbolBase {
	private String name;
	private String baseTypeName;
	private TypeMV baseType;

	public EntityModuleElementSymbolBase(ModuleMV module, String name, String baseTypeName) {
		super(module);
		this.name = name;
		this.baseTypeName = baseTypeName;
	}

	public TypeMV getBaseTypeMV() {
		return baseType;
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

	public String getBaseTypeName() {
		return baseTypeName;
	}

	public void setBaseType(TypeMV baseType) {
		this.baseType = baseType;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("baseTypeName", baseTypeName)
			.append("baseType", baseType==null?null:baseType.getFullName())
			.toString();
	}
	
}
