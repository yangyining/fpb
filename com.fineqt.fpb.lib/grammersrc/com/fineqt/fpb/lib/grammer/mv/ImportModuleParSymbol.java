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

import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.ModuleParMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

public class ImportModuleParSymbol extends ImportModuleElementSymbolBase 
implements ModuleParMV {
	private ModuleParMV importedModulePar;
	private PImportModulePar model;
	
	public ImportModuleParSymbol(ModuleMV module, String importedModuleName,
			String importedElementName) {
		super(module, importedModuleName, importedElementName);
		model = FpbmoduleFactory.eINSTANCE.createPImportModulePar();
		model.setImportedModuleName(importedModuleName);
		model.setImportedModulePartName(importedElementName);
	}

	public ModuleParMV getImportedModulePar() {
		return importedModulePar;
	}

    public void resolveImportRef() {
        if (importedModulePar == null) {
            importedModulePar = (ModuleParMV)getImportedElement();
        }
    }
	
	@Override
	public TypeMV getBaseTypeMV() {
		return importedModulePar.getBaseTypeMV();
	}

	@Override
	public Type getModuleElementType() {
		return Type.MODULE_PARAMETER;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("importedModulePar", importedModulePar)
			.toString();
	}

	public PImportModulePar getModel() {
		return model;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		PModule pmodule = cxt.getModuleSymbol().getModel();
		//加入模块
		pmodule.getModulePars().add(model);
		//runtime propertyList
		if (runtimePropertyList != null) {
			String value;
			//ElementID
			value = runtimePropertyList.getProperty(ELEMENT_ID_PRP);
			if (value != null) {
				try {
					int id = Integer.parseInt(value);
					model.setModuleParID(id);
				} catch (NumberFormatException e) {
					//忽略ID设置
				}
			}
		}
	}
	
}
