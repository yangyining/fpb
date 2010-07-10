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
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.grammer.SimplePropertyList;
import com.fineqt.fpb.lib.modelview.ModuleElementMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;

abstract public class ModuleElementSymbolBase extends SymbolElement 
implements ModuleElementMV {
	public static final String ELEMENT_ID_PRP = "ElementID";
	
	private ModuleMV module;
	protected SimplePropertyList runtimePropertyList;
	private List<ValueReferenceSymbol> refValues = new ArrayList<ValueReferenceSymbol>();
	
	public ModuleElementSymbolBase(ModuleMV module) {
		this.module = module;
	}

	public ModuleMV getModuleMV() {
		return module;
	}

	public SimplePropertyList getRuntimePropertyList() {
		return runtimePropertyList;
	}

	public void setRuntimePropertyList(SimplePropertyList runtimePropertyList) {
		this.runtimePropertyList = runtimePropertyList;
	}
	
	public List<ValueReferenceSymbol> getRefValues() {
		return refValues;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		//ValueReference
		for (ValueReferenceSymbol symbol : refValues) {
			symbol.initModel(cxt);
		}
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("name", getName())
			.append("moduleElementType", getModuleElementType())
			.append("import", isImport())
			.append("fullName", getFullName())
			.toString();
	}

}
