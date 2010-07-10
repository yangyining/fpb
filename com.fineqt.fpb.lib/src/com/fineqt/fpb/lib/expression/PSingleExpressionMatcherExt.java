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
package com.fineqt.fpb.lib.expression;

import java.util.Map;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PSingleExpressionMatcher;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.template.impl.PSimpleMatcherExtBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PSingleExpressionMatcherExt extends PSimpleMatcherExtBase {
	private PMatcherExt expressionMatcher;
	
	public PSingleExpressionMatcherExt(PSingleExpressionMatcher pmodel,
			PTypeElementMeta matcherMeta) {
		super(pmodel, matcherMeta);
	}

	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		PValue targetValue = expressionMatcher.valueOf(paras);
		return value.equals(targetValue);
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		PValue result = expressionMatcher.valueOf(paras);
		//设置类型信息
		if(result != null) {
		    result.pValueMeta(matcherMeta);
		}
		return result;
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父方法
		super.doInit();
		//表达式
		PSingleExpressionMatcher model = (PSingleExpressionMatcher)pmodel;
		assert model.getExpression() != null;
		expressionMatcher = extFactory.createMatcher(matcherMeta, 
				model.getExpression(), this);
		assert expressionMatcher != null;
	}

}
