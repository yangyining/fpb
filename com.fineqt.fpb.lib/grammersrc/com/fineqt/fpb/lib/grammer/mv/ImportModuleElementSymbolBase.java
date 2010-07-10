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

import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.modelview.ModuleElementMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;

abstract public class ImportModuleElementSymbolBase extends ModuleElementSymbolBase {
	protected String importedModuleName;
	protected String importedElementName;
	
	public ImportModuleElementSymbolBase(ModuleMV module, 
			String importedModuleName, String importedElementName) {
		super(module);
		this.importedModuleName = importedModuleName;
		this.importedElementName = importedElementName;
	}

	public String getImportedModuleName() {
		return importedModuleName;
	}

	public String getImportedElementName() {
		return importedElementName;
	}

	@Override
	public String getFullName() {
		return importedModuleName + "." + importedElementName;
	}

	@Override
	public String getName() {
		return importedElementName;
	}

	@Override
	public boolean isImport() {
		return true;
	}
	
    protected ModuleElementMV getImportedElement() {
        ModuleSymbol moduleSymbol = (ModuleSymbol)getModuleMV();
        ImportModuleElementSymbolBase importElement = 
            (ImportModuleElementSymbolBase)moduleSymbol.pModuleElement(getFullName());
        assert importElement != null; 
        assert importElement.getImportedModuleName() != null;
        //解决外部导入模块
        ModuleMV importedModule = moduleSymbol.getParsingContext().getCreatedModule(
                importElement.getImportedModuleName());
        if (importedModule == null) {
            moduleSymbol.getParserHelper().addErrorMsg(
                    importElement.getStartPosition(), 
                    MetaException.CODE.MODULE_NOT_IMPORTED_ERROR, 
                    importElement.getImportedModuleName(), moduleSymbol.getModuleName());
            return null;
        }
        assert importElement.getImportedElementName() != null;
        ModuleElementMV importedElement = importedModule.pModuleElement(
                importElement.getModuleElementType(), 
                importElement.getImportedElementName());
        if (importedElement == null) {
            moduleSymbol.getParserHelper().addErrorMsg(
                    importElement.getStartPosition(), 
                    MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
                    importElement.getImportedElementName(), importedModule.getModuleName());
            return null;
        }
        return importedElement;
    }
	
}
