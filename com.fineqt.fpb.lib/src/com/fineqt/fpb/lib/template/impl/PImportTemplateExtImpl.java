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
package com.fineqt.fpb.lib.template.impl;

import java.util.List;

import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.template.PImportTemplateExt;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.template.PTemplateInstance;
import com.fineqt.fpb.lib.template.PTemplateParMeta;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PImportTemplateExtImpl extends PTemplateExtBase 
implements PImportTemplateExt{
	private String importedModuleName;
	private String importedTemplateName;
	private PTemplateExt importedTemplate;
	
	public PImportTemplateExtImpl(PImportTemplate pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		importedModuleName = pmodel.getImportedModuleName();
		importedTemplateName = pmodel.getImportedTemplateName();
		assert importedModuleName != null;
		assert importedTemplateName != null;
	}

	@Override
	public String getImportedModuleName() {
		return importedModuleName;
	}

	@Override
	public PTemplateExt getImportedTemplate() {
		return importedTemplate;
	}

	@Override
	public String getImportedTemplateName() {
		return importedTemplateName;
	}

	@Override
	public void setImportedTemplate(PTemplateExt tmp) {
		importedTemplate = tmp;
	}

	@Override
	public TypeMV getBaseTypeMV() {
		return importedTemplate.getBaseTypeMV();
	}

	@Override
	public String getFullName() {
		return importedModuleName + "." + getName();
	}

	@Override
	public String getName() {
		return importedTemplateName;
	}

	@Override
	public PTemplateInstance createInstance(Object... paras) {
		return importedTemplate.createInstance(paras);
	}

	@Override
	public PTypeExt getBasetype() {
		return importedTemplate.getBasetype();
	}

	@Override
	public PMatcherExt getMatcher() {
		return importedTemplate.getMatcher();
	}

	@Override
	public PTemplateParMeta getParMeta(String parName) {
		return importedTemplate.getParMeta(parName);
	}

	@Override
	public List<PTemplateParMeta> getParMetas() {
		return importedTemplate.getParMetas();
	}

	@Override
	public boolean matchPValue(PValue value, boolean doValidation, Object... paras)
			throws TemplateMatchingExption {
		return importedTemplate.matchPValue(value, doValidation, paras);
	}

	@Override
	public PValue pValueOf(Object... paras) throws TemplateMatchingExption {
		return importedTemplate.pValueOf(paras);
	}

	@Override
	public boolean matchValue(IValue value, Object... paras)
			throws TemplateMatchingExption {
		return importedTemplate.matchValue(value, paras);
	}

	@Override
	public IValue valueOf(Object... paras) throws TemplateMatchingExption {
		return importedTemplate.valueOf(paras);
	}

	@Override
	public boolean isImport() {
		return true;
	}

    @Override
    protected void doInit() throws InitMetaException {
        //依赖元素的初始化
        importedTemplate.init();
        //父方法
        super.doInit();
    }

}
