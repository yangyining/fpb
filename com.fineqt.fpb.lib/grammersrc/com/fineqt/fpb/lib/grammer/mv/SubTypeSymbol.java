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

import com.fineqt.fpb.lib.model.fpbmodule.PSubType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;
import com.fineqt.fpb.lib.modelview.ModuleMV;

public class SubTypeSymbol extends DerivedTypeSymbolBase {
	private String name;
	private String superTypeName;
	private PSubType model;
	
	public SubTypeSymbol(ModuleMV module, String superTypeName, String name) {
		super(module);
		this.superTypeName = superTypeName;
		this.name = name;
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

	public String getSuperTypeName() {
		return superTypeName;
	}
	
	@Override
	public TypeDerivativeMode getDerivativeMode() {
		return TypeDerivativeMode.SUB;
	}

	public PSubType getModel() {
		return model;
	}

	public void setModel(PSubType model) {
		this.model = model;
	}
	
	@Override
	public PType getTypeModel() {
		return model;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		//初始化依赖类
		assert superType != null;
		TypeSymbolBase superTypeSymbol = (TypeSymbolBase)superType;
		superTypeSymbol.initModel(cxt);
		//父方法
		super.doInitModel(cxt);
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("name", name)
			.append("superTypeName", superTypeName)
			.append("model", model)
			.toString();
	}
	
}
