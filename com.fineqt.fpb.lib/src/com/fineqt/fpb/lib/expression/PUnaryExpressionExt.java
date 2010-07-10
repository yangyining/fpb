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

import com.fineqt.fpb.lib.builtin.PFloatValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PUnaryExpression;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.template.impl.PExpressionMatcherExtBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PUnaryExpressionExt extends PExpressionMatcherExtBase {
	private boolean isMinusOp;
	private PMatcherExt primaryMatcher;
	
	public PUnaryExpressionExt(PUnaryExpression pmodel, PTypeElementMeta matcherMeta, 
			PModuleExt ownerModule) {
		super(pmodel, matcherMeta, ownerModule);
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		PValue value = primaryMatcher.valueOf(paras);
		if (value != null && isMinusOp) {
			switch(value.getType().getTypeClass()) {
			case INTEGER:
				PIntegerValue intValue = (PIntegerValue)value;
				intValue.negate();
				break;
			case FLOAT:
				PFloatValue floatValue = (PFloatValue)value;
				floatValue.negate();
				break;
			default:
				throw new TemplateMatchingExption(
						MetaException.CODE.TYPE_NOT_COMPATIBLE_ERROR, 
						value.getType().getFullName(),
						"integer or float");
			}
		}
        //设置类型信息
		if (value != null) {
		    value.pValueMeta(matcherMeta);
		}
		return value;
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父方法
		super.doInit();
		//
		PUnaryExpression model = (PUnaryExpression)pmodel;
		assert model.getPrimary() != null;
		primaryMatcher = extFactory.createMatcher(
				matcherMeta, model.getPrimary(), this, getPModule());
		if ("-".equals(model.getOperator())) {
			isMinusOp = true;
		}
	}
	
	

}
