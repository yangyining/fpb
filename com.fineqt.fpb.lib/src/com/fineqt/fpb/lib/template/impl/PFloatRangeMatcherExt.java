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

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.builtin.PFloatValue;
import com.fineqt.fpb.lib.expression.PExpressionExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PRangeMatcher;
import com.fineqt.fpb.lib.template.NotSingleValueException;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PFloatRangeMatcherExt extends PSimpleMatcherExtBase {
	//null表示minus infinity
	private BigDecimal lowerBound;
	//null表示infinity
	private BigDecimal upperBound;

	public PFloatRangeMatcherExt(PRangeMatcher model, PTypeElementMeta matcherMeta, 
			PModuleExt ownerModule) {
		super(model, matcherMeta, ownerModule);
		if (matcherMeta.asTypeMeta().getTypeClass() != TypeClass.FLOAT) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	protected void doInit() throws InitMetaException {
		PRangeMatcher model = (PRangeMatcher)pmodel;
		//取得常数表达式的值
		PMatcher minMatcher = model.getLowerBound();
		PMatcher maxMatcher = model.getUpperBound();
		try {
			PExpressionExt exp;
			PFloatValue floatValue;
			//minLength
			if (minMatcher != null) {
				 exp = extFactory.createExpression(
						 getPModule().getFloat(), minMatcher);
				floatValue = (PFloatValue)exp.valueOf();
				lowerBound = floatValue.getBigDecimal();
			}
			//maxLength
			if (maxMatcher != null) {
				exp = extFactory.createExpression(
						getPModule().getFloat(), maxMatcher);
				floatValue = (PFloatValue)exp.valueOf();
				upperBound = floatValue.getBigDecimal();
			}
		} catch (TemplateMatchingExption e) {
			throw new InitMetaException(getPModule(), 
					MetaException.CODE.TEMPLATE_MATCHING_ERROR, e);
		}
		//父方法
		super.doInit();
	}
	
	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		if (value.pTypeMeta().getTypeClass() != TypeClass.FLOAT) {
			return false;
		}
		BigDecimal decValue = ((PFloatValue)value).getBigDecimal();
		if (( lowerBound != null && decValue.compareTo(lowerBound) < 0) || 
			( upperBound != null && decValue.compareTo(upperBound) > 0)) {
			return false;
		}
		return true;
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		throw new NotSingleValueException();
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("lowerBound", lowerBound)
			.append("upperBound", upperBound)
			.toString();
	}
	
}
