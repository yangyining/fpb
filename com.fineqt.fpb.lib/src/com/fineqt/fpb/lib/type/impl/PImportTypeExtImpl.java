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
package com.fineqt.fpb.lib.type.impl;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PImportType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;
import com.fineqt.fpb.lib.type.PImportTypeExt;

public class PImportTypeExtImpl extends PDerivedTypeExtBase implements PImportTypeExt {
	private String importedModuleName;
	private String importedTypeName;
	
	public PImportTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super((PImportType)pmodel, pmoduleExt);
		importedModuleName = ((PImportType)pmodel).getImportedModuleName();
		importedTypeName = ((PImportType)pmodel).getImportedTypeName();
		assert importedModuleName != null;
		assert importedTypeName != null;
	}

	@Override
	public PModuleExt getImportedModule() {
		if (pSuperType != null)
			return pSuperType.getPModule();
		return null;
	}

	@Override
	public String getFullName() {
		return importedModuleName + "." + getName();
	}

	@Override
	public String getName() {
		return importedTypeName;
	}
	
	@Override
	public TypeDerivativeMode getDerivativeMode() {
		return TypeDerivativeMode.IMPORT;
	}
	
	@Override
	public boolean isImport() {
		return true;
	}

	public String getImportedModuleName() {
		return importedModuleName;
	}

	public String getImportedTypeName() {
		return importedTypeName;
	}

}
