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

import java.util.regex.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.model.fpbmodule.PPatternConstraint;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.template.impl.PCharstringMatcherExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PPatternConstraintExt extends PTypeConstraintExtBase {
	private PCharstringMatcherExt matcher;

	public PPatternConstraintExt(PPatternConstraint pmodel, PTypeExt targetType) {
		super(pmodel, targetType);
		assert pmodel.getMatcher() != null;
		matcher = (PCharstringMatcherExt)extFactory.createMatcher(targetType, 
				pmodel.getMatcher(), null);
	}

	@Override
	public boolean validate(PValue value, DiagnosticChain chain) {
		try {
			if (matcher.match(value, null)) {
				return true;
			}
			if (chain != null) {
				chain.add(new SimpleDiagnostic(Diagnostic.FAIL, 
						"String matching failed for patter of " + getPattern(),
						value));
			}
		} catch (TemplateMatchingExption e) {
			if (chain != null) {
				chain.add(new SimpleDiagnostic(Diagnostic.FAIL, 
						"String matching failed for patter of " + getPattern(),
						value, e));
			}
		}
		return false;
	}

	public Pattern getPattern() {
		return matcher.getStringPattern();
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("matcher", matcher)
			.toString();
	}
	
}
