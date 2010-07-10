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

import java.util.List;

import com.fineqt.fpb.lib.meta.PEnumItemExt;
import com.fineqt.fpb.lib.meta.PEnumSetExt;
import com.fineqt.fpb.lib.meta.PImportEnumSetExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PImportEnumSet;
import com.fineqt.fpb.lib.type.PTypeExt;

public class PImportEnumSetExtImpl extends PEnumSetExtBase implements PImportEnumSetExt {
	private String importedModuleName;
	private String importedEnumSetName;
	private PEnumSetExt importedEnumSet;
	
	public PImportEnumSetExtImpl(PImportEnumSet pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		importedModuleName = pmodel.getImportedModuleName();
		importedEnumSetName = pmodel.getImportedEnumSetName();
		assert importedModuleName != null;
		assert importedEnumSetName != null;
	}

	@Override
	public PEnumSetExt getImportedEnumSet() {
		return importedEnumSet;
	}

	@Override
	public String getImportedEnumSetName() {
		return importedEnumSetName;
	}

	@Override
	public String getImportedModuleName() {
		return importedModuleName;
	}

	@Override
	public void setImportedEnumSet(PEnumSetExt enumSet) {
		importedEnumSet = enumSet;
	}

	@Override
	public PTypeExt getBaseType() {
		return importedEnumSet.getBaseType();
	}

	@Override
	public List<PEnumItemExt> getEnumItems() {
		return importedEnumSet.getEnumItems();
	}

	@Override
	public String getFullName() {
		return importedModuleName + "." + importedEnumSetName;
	}

	@Override
	public String getName() {
		return importedEnumSetName;
	}

	@Override
	public boolean isImport() {
		return true;
	}

    @Override
    protected void doInit() throws InitMetaException {
        //依赖元素的初始化
        importedEnumSet.init();
        //父方法
        super.doInit();
    }
	
}
