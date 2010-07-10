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

import java.util.Map;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.model.fpbtemplate.PExpressionMatcher;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

abstract public class PExpressionMatcherExtBase extends PElementExtBase 
implements PMatcherExt {
	protected PTypeElementMeta matcherMeta;

	public PExpressionMatcherExtBase(PExpressionMatcher pmodel, PTypeElementMeta matcherMeta) {
		super(pmodel, matcherMeta.asTypeMeta().getPModule());
		this.matcherMeta = matcherMeta;
	}
	
	@Override
	protected void doInit() throws InitMetaException {
		super.doInit();
		//初始化依赖类型
		matcherMeta.asTypeMeta().init();
	}
	
	@Override
	public PTypeElementMeta getMatcherMeta() {
		return matcherMeta;
	}
	
	public Object clone() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean match(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		throw new UnsupportedOperationException();
	}
	
}
