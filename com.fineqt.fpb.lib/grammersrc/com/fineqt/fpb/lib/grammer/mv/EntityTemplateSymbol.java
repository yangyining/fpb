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

import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.TemplateMV;
import com.fineqt.fpb.lib.modelview.TemplateParMV;

public class EntityTemplateSymbol extends EntityModuleElementSymbolBase
implements TemplateMV {
	private List<TemplateParMV> pars = new ArrayList<TemplateParMV>();
	private PEntityTemplate model;
	
	public EntityTemplateSymbol(ModuleMV module, String name,
			String baseTypeName) {
		super(module, name, baseTypeName);
	}

	@Override
	public TemplateParMV getParMV(int index) {
		return pars.get(index);
	}

	@Override
	public int getParSize() {
		return pars.size();
	}

	public void addParMV(TemplateParMV par) {
		pars.add(par);
	}

	@Override
	public Type getModuleElementType() {
		return Type.TEMPLATE;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("pars", pars)
			.toString();
	}

	public PEntityTemplate getModel() {
		return model;
	}

	public void setModel(PEntityTemplate model) {
		this.model = model;
	}
	
	@Override
	protected void doInitModel(ParserHelper cxt) {
		PModule pmodule = cxt.getModuleSymbol().getModel();
		//加入模块
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
		//父方法
		super.doInitModel(cxt);
	}
	
}
