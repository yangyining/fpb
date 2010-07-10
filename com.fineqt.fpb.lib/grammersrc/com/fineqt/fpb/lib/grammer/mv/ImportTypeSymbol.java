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

import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PImportType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

public class ImportTypeSymbol extends DerivedTypeSymbolBase {
	private PImportType model;
	
	public ImportTypeSymbol(ModuleMV module, String importedModuleName, String importedTypeName) {
		super(module);
		model = FpbmoduleFactory.eINSTANCE.createPImportType();
		model.setImportedModuleName(importedModuleName);
		model.setImportedTypeName(importedTypeName);
	}

	@Override
    public TypeMV getSuperType() {
	    return superType;
    }

    public void resolveImportRef() {
        if (superType == null) {
            ModuleSymbol moduleSymbol = (ModuleSymbol)getModuleMV();
            ImportTypeSymbol type = (ImportTypeSymbol)moduleSymbol.pTypeMV(getFullName());
            ModuleMV importedModule = moduleSymbol.getParsingContext().getCreatedModule(
                    type.getImportedModuleName());
            if (importedModule == null) {
                moduleSymbol.getParserHelper().addErrorMsg(
                        type.getStartPosition(), 
                        MetaException.CODE.MODULE_NOT_IMPORTED_ERROR, 
                        type.getImportedModuleName(), moduleSymbol.getModuleName());
                return;
            }
            TypeMV importedType = importedModule.pTypeMV(type.getImportedTypeName());
            if (importedType == null) {
                moduleSymbol.getParserHelper().addErrorMsg(
                        type.getStartPosition(), 
                        MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
                        type.getImportedTypeName(), importedModule.getModuleName());
                return;
            }
            type.setSuperType(importedType);
        }
    }
	
    @Override
	public String getFullName() {
		return getImportedModuleName() + "." + getImportedTypeName();
	}

	@Override
	public String getName() {
		return getImportedTypeName();
	}

	@Override
	public boolean isImport() {
		return true;
	}

	public String getImportedModuleName() {
		return model.getImportedModuleName();
	}

	public String getImportedTypeName() {
		return model.getImportedTypeName();
	}

	@Override
	public TypeDerivativeMode getDerivativeMode() {
		return TypeDerivativeMode.IMPORT;
	}

	@Override
	public PType getTypeModel() {
		return model;
	}

	public PImportType getModel() {
		return model;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("importedModuleName", getImportedModuleName())
			.append("importedTypeName", getImportedTypeName())
			.append("model", model)
			.toString();
	}
	
}
