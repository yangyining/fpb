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

import com.fineqt.fpb.lib.meta.PImportModuleParExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PImportModulePar;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PImportModuleParExtImpl extends PModuleParExtBase 
implements PImportModuleParExt {
	private String importedModuleName;
	private String importedModuleParName;
	private PModuleParExt importedModulePar;

	public PImportModuleParExtImpl(PImportModulePar pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		importedModuleName = pmodel.getImportedModuleName();
		importedModuleParName = pmodel.getImportedModulePartName();
	}

	@Override
	public String getImportedModuleName() {
		return importedModuleName;
	}

	@Override
	public PModuleParExt getImportedModulePar() {
		return importedModulePar;
	}

	@Override
	public String getImportedModuleParName() {
		return importedModuleParName;
	}

	@Override
	public void setImportedModulePar(PModuleParExt par) {
		this.importedModulePar = par;
	}

	@Override
	public String getFullName() {
		return importedModuleName + "." + getName();
	}

	@Override
	public String getName() {
		return importedModuleParName;
	}

	@Override
	public PValue getPValue() {
		return importedModulePar.getPValue();
	}

	@Override
	public PTypeExt getBasetype() {
		return importedModulePar.getBasetype();
	}

	@Override
	public boolean isThreadLocal() {
		return importedModulePar.isThreadLocal();
	}

	@Override
	public void setInitPValue(PValue value) {
		importedModulePar.setInitPValue(value);
	}

	@Override
	public void setLocalPValue(PValue value) {
		importedModulePar.setLocalPValue(value);
	}

	@Override
	public boolean isImport() {
		return true;
	}
	
    @Override
    protected void doInit() throws InitMetaException {
        //依赖元素的初始化
        importedModulePar.init();
        //父方法
        super.doInit();
    }
	
}
