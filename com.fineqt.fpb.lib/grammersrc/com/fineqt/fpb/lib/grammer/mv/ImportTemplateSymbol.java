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

import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory;
import com.fineqt.fpb.lib.model.fpbtemplate.PImportTemplate;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.TemplateMV;
import com.fineqt.fpb.lib.modelview.TemplateParMV;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.util.ParserException;

public class ImportTemplateSymbol extends ImportModuleElementSymbolBase
implements TemplateMV {
	private TemplateMV importedTemplate;
	private PImportTemplate model;
	
	public ImportTemplateSymbol(ModuleMV module, String importedModuleName,
			String importedElementName) {
		super(module, importedModuleName, importedElementName);
		model = FpbtemplateFactory.eINSTANCE.createPImportTemplate();
		model.setImportedModuleName(importedModuleName);
		model.setImportedTemplateName(importedElementName);
	}

	@Override
	public TypeMV getBaseTypeMV() {
		return importedTemplate.getBaseTypeMV();
	}

	@Override
	public TemplateParMV getParMV(int index) {
		return importedTemplate.getParMV(index);
	}

	@Override
	public int getParSize() {
		return importedTemplate.getParSize();
	}

	public TemplateMV getImportedTemplate() throws ParserException {
		return importedTemplate;
	}

    public void resolveImportRef() {
        if (importedTemplate == null) {
            importedTemplate = (TemplateMV)getImportedElement();
        }
    }
	
	@Override
	public Type getModuleElementType() {
		return Type.TEMPLATE;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("importedTemplate", importedTemplate)
			.toString();
	}

	public PImportTemplate getModel() {
		return model;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		PModule pmodule = cxt.getModuleSymbol().getModel();
		//加入模块
		if (model == null) {
		}
		pmodule.getTemplates().add(model);
		//runtime propertyList
		if (runtimePropertyList != null) {
			String value;
			//ElementID
			value = runtimePropertyList.getProperty(ELEMENT_ID_PRP);
			if (value != null) {
				try {
					int id = Integer.parseInt(value);
					model.setTemplateID(id);
				} catch (NumberFormatException e) {
					//忽略ID设置
				}
			}
		}
	}
	
}
