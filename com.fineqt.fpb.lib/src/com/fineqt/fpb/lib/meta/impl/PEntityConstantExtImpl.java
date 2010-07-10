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

import com.fineqt.fpb.lib.meta.PEntityConstantExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PEntityConstantExtImpl extends PConstantExtBase implements PEntityConstantExt {
	private PMatcherExt matcher;
	private PTypeExt basetype;
	private String name;
	private PValue value;

	public PEntityConstantExtImpl(PEntityConstant model, PModuleExt module) {
		super(model, module);
		if (model == null || model.getBaseTypeName() == null) {
			throw new IllegalArgumentException();
		}
		//Name
		this.name = model.getName();
	}

	@Override
	public String getFullName() {
		return getPModule().getModuleName() + "." + name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public PValue getPValue() {
		return value;
	}

	@Override
	public PTypeExt getBasetype() {
		return basetype;
	}

	@Override
	public boolean isImport() {
		return false;
	}

	@Override
	protected void doInit() throws InitMetaException {
		PEntityConstant model = (PEntityConstant)pmodel;
		super.doInit();
		//Basetype
		basetype = getPModule().pPType(model.getBaseTypeName());
		if (basetype == null) {
			throw new InitMetaException(getPModule(),
					MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
					model.getBaseTypeName(), getPModule().getModuleName());
		}
		//依赖类型的初始化
		basetype.init();
		//Matcher
		if (model.getMatcher() == null) {
			throw new IllegalArgumentException();
		}
		matcher = extFactory.createMatcher(basetype, model.getMatcher(), null);
		//依赖Matcher的初始化
		matcher.init();
		//取得常量的值
		try {
			value = matcher.valueOf(null);
		} catch (TemplateMatchingExption e) {
			throw new InitMetaException(getPModule(), 
					MetaException.CODE.TEMPLATE_MATCHING_ERROR, e);
		}
	}

}
