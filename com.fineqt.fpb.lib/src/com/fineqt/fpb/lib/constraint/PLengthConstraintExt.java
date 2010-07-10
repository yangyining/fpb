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
package com.fineqt.fpb.lib.constraint;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.builtin.PStringValue;
import com.fineqt.fpb.lib.expression.PExpressionExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PLengthConstraint;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;

public class PLengthConstraintExt extends PTypeConstraintExtBase {
	//非null
	private Integer minLength;
	//null表示infinity
	private Integer maxLength;

	public PLengthConstraintExt(PLengthConstraint pmodel, PTypeExt targetType) {
		super(pmodel, targetType);
		switch(targetType.getTypeClass()) {
		case BITSTRING:
		case HEXSTRING:
		case OCTETSTRING:
		case CHARSTRING:
		case UNIVERSAL_CHARSTRING:
		case RECORDOF:
		case SETOF:
			break;
		default:
			throw new IllegalArgumentException(targetType.getFullName());
		}
	}

	
	@Override
	protected void doInit() throws InitMetaException {
		PLengthConstraint model = (PLengthConstraint)pmodel;
		//取得常数表达式的值
		PMatcher minMatcher = model.getLowerBound();
		PMatcher maxMatcher = model.getUpperBound();
		assert minMatcher != null;
		try {
			PExpressionExt exp;
			PIntegerValue intValue;
			//minLength
			exp = extFactory.createExpression(
					getPModule().getInteger(), minMatcher);
			intValue = (PIntegerValue)exp.valueOf();
			minLength = intValue.getInteger();
			//maxLength
			if (maxMatcher != null) {
				exp = extFactory.createExpression(
						getPModule().getInteger(), maxMatcher);
				intValue = (PIntegerValue)exp.valueOf();
				maxLength = intValue.getInteger();
			}
		} catch (TemplateMatchingExption e) {
			throw new InitMetaException(getPModule(), 
					MetaException.CODE.TEMPLATE_MATCHING_ERROR, e);
		}
		//父方法
		super.doInit();
	}


	@Override
	public boolean validate(PValue value, DiagnosticChain chain) {
		if (value.pTypeMeta().getRootType() != targetType.getRootType()) {
			throw new IllegalArgumentException();
		}
		switch(targetType.getTypeClass()) {
		case BITSTRING:
		case HEXSTRING:
		case OCTETSTRING:
		case CHARSTRING:
		case UNIVERSAL_CHARSTRING:
			PStringValue strValue = (PStringValue)value;
			return checkLength(value, strValue.getLength(), chain);
		case RECORDOF:
		case SETOF:
			@SuppressWarnings("unchecked")
			PListValue listValue = (PListValue)value;
			return checkLength(value, listValue.getLength(), chain);
		}
		assert false;
		return false;
	}

	private boolean checkLength(PValue value, int len, DiagnosticChain chain) {
		assert minLength != null;
		if (len < minLength || 
				(maxLength != null && len > maxLength)) {
			if (chain != null) {
				chain.add(new SimpleDiagnostic(Diagnostic.FAIL, 
						"Length of " + len + " not match the constraint of ["
						+minLength+", "+maxLength+"].",
						value));
			}
			return false;
		}
		return true;
	}
	
	/**
	 * 返回固定长度。如果非固定则返回-1。
	 * @return
	 */
	public int getFixedlLength() {
		if (!minLength.equals(maxLength) ) {
			return -1;
		}
		return minLength;
	}

	public int getMinLength() {
		return minLength;
	}

	public int getMaxLength() {
		return maxLength;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("minLength", minLength)
			.append("maxLength", maxLength)
			.toString();
	}
}
