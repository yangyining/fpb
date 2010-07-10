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

import com.fineqt.fpb.lib.meta.PEntityModuleParExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityModulePar;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PEntityModuleParExtImpl extends PModuleParExtBase 
implements PEntityModuleParExt {
	private String name;
	private PMatcherExt matcher;
	private PTypeExt basetype;
	private PValue initValue;
	private boolean threadLocal;
	private ThreadLocal<PValue> localValue;
	
	public PEntityModuleParExtImpl(PEntityModulePar model, PModuleExt module) {
		super(model, module);
		if (model == null || model.getBaseTypeName() == null) {
			throw new IllegalArgumentException();
		}
		//Name
		name = model.getName();
		//threadLocal
		threadLocal = model.isThread();
		if (threadLocal) {
			localValue = new ThreadLocal<PValue>() {
				@Override
				protected PValue initialValue() {
					return initValue;
				}
			};
		}
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
		if (threadLocal) {
			return localValue.get();
		} else {
			return initValue;
		}
	}


	@Override
	public PTypeExt getBasetype() {
		return basetype;
	}

	@Override
	public boolean isThreadLocal() {
		return threadLocal;
	}

	@Override
	public void setInitPValue(PValue value) {
		initValue = value;
	}

	@Override
	public void setLocalPValue(PValue value) {
		if (!threadLocal) {
			throw new UnsupportedOperationException();
		}
		localValue.set(value);
	}
	
	@Override
	public boolean isImport() {
		return false;
	}

	@Override
	protected void doInit() throws InitMetaException {
		super.doInit();
		PEntityModulePar model = (PEntityModulePar)pmodel;
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
		if (model.getMatcher() != null) {
			matcher = extFactory.createMatcher(basetype, model.getMatcher(), null, getPModule());
		}
		if (matcher != null) {
			//依赖Matcher的初始化
			matcher.init();
			//取得常量的值
			try {
				initValue = matcher.valueOf(null);
			} catch (TemplateMatchingExption e) {
				throw new InitMetaException(getPModule(), 
						MetaException.CODE.TEMPLATE_MATCHING_ERROR, e);
			}
		}
	}
	
}
