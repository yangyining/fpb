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
package com.fineqt.fpb.lib.meta.impl;

import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PImportConstantExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PImportConstant;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PImportConstantExtImpl extends PConstantExtBase implements PImportConstantExt {
	private String importedModuleName;
	private String importedConstantName;
	private PConstantExt importedConstant;
	
	public PImportConstantExtImpl(PImportConstant pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		this.importedModuleName = pmodel.getImportedModuleName();
		this.importedConstantName = pmodel.getImportedConstantName();
	}

	@Override
	public PConstantExt getImportedConstant() {
		return importedConstant;
	}

	@Override
	public String getImportedConstantName() {
		return importedConstantName;
	}

	@Override
	public String getImportedModuleName() {
		return importedModuleName;
	}

	@Override
	public void setImportedConstant(PConstantExt cons) {
		importedConstant = cons;
	}

	@Override
	public String getFullName() {
		return importedModuleName + "." + importedConstantName;
	}

	@Override
	public String getName() {
		return importedConstantName;
	}

	@Override
	public PValue getPValue() {
		return importedConstant.getPValue();
	}

	@Override
	public PTypeExt getBasetype() {
		return importedConstant.getBasetype();
	}

	@Override
	public boolean isImport() {
		return true;
	}

    @Override
    protected void doInit() throws InitMetaException {
        //依赖元素的初始化
        importedConstant.init();
        //父方法
        super.doInit();
    }
	
}
