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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PComplementListMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher;
import com.fineqt.fpb.lib.template.NotSingleValueException;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PComplementListMatcherExt extends PSimpleMatcherExtBase{
	private List<PMatcherExt> items = new ArrayList<PMatcherExt>();
	
	public PComplementListMatcherExt(PComplementListMatcher pmodel, 
			PTypeElementMeta matcherMeta, PModuleExt ownerModule) {
		super(pmodel, matcherMeta, ownerModule);
	}

	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras) 
	throws TemplateMatchingExption {
		for (PMatcherExt item : items) {
			if (item.match(value, paras)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras) throws TemplateMatchingExption {
		throw new NotSingleValueException();
	}

	public List<PMatcherExt> getItems() {
		return items;
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父方法
		super.doInit();
		//Items
		PComplementListMatcher model = (PComplementListMatcher)pmodel;
		EList<PTemplateMatcher> modelItems = model.getItems();
		for (PMatcher modelItem : modelItems) {
			PMatcherExt matcherItem = extFactory.createMatcher(matcherMeta, modelItem, 
					this, getPModule());
			getItems().add(matcherItem);
		}
	}
	
	
}
