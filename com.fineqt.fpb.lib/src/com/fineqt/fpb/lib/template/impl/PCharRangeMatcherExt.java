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

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.expression.PExpressionExt;
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

public class PCharRangeMatcherExt extends PSimpleMatcherExtBase {
	//null表示minus infinity
	private Character lowerBound; 
	//null表示infinity
	private Character upperBound;

	public PCharRangeMatcherExt(PRangeMatcher model, PTypeElementMeta matcherMeta) {
		super(model, matcherMeta);
		if (matcherMeta.asTypeMeta().getTypeClass() != TypeClass.CHARSTRING) {
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
			PCharstringValue cstrValue;
			//minLength
			if (minMatcher != null) {
				exp = extFactory.createExpression(
						getPModule().getCharstring(), minMatcher);
				cstrValue = (PCharstringValue)exp.valueOf();
				lowerBound = cstrValue.getChar(0);
			}
			//maxLength
			if (maxMatcher != null) {
				exp = extFactory.createExpression(
						getPModule().getCharstring(), maxMatcher);
				cstrValue = (PCharstringValue)exp.valueOf();
				upperBound = cstrValue.getChar(0);
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
		if (value.pTypeMeta().getTypeClass() != TypeClass.CHARSTRING) {
			return false;
		}
		PCharstringValue charValue = (PCharstringValue)value;
		if (charValue.getLength() != 1)
			return false;
		char ch = charValue.getChar(0);
		if ((lowerBound != null && ch < lowerBound) || 
				(upperBound != null && ch > upperBound)) {
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
