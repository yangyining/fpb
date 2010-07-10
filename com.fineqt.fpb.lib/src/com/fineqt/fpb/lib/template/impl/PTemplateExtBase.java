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

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.impl.PModuleElementExtBase;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;
import com.fineqt.fpb.lib.modelview.TemplateParMV;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.template.PTemplateParMeta;

abstract public class PTemplateExtBase extends PModuleElementExtBase implements PTemplateExt {
	private int templateID;

	public PTemplateExtBase(PTemplate pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		if (pmodel != null) {
			templateID = pmodel.getTemplateID();
		}
	}

	@Override
	public int getID() {
		return templateID;
	}


	@Override
	public Type getModuleElementType() {
		return Type.TEMPLATE;
	}

	@Override
	public TemplateParMV getParMV(int index) {
		List<PTemplateParMeta> pars = getParMetas();
		return pars.get(index);
	}

	@Override
	public int getParSize() {
		List<PTemplateParMeta> pars = getParMetas();
		return pars.size();
	}

	@Override
	public IType getType() {
		return getBasetype();
	}
	
}
