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

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PListConstraint;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.template.impl.PValueListMatcherExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PListConstraintExt extends PTypeConstraintExtBase {
	private PMatcherExt matcher;
	private PValue fixedValue;
	
	public PListConstraintExt(PListConstraint pmodel, PTypeExt targetType) {
		super(pmodel, targetType);
		assert pmodel.getMatcher() != null;
	}

	@Override
	public boolean validate(PValue value, DiagnosticChain chain) {
		try {
			if (matcher.match(value, null)) {
				return true;
			}
			if (chain != null) {
				chain.add(new SimpleDiagnostic(Diagnostic.FAIL, "List Matching Failed", value));
			}
		} catch (TemplateMatchingExption e) {
			chain.add(new SimpleDiagnostic(Diagnostic.FAIL, "List Matching Failed", value, e));
		}
		return false;
	}

	public PValue getFixedValue() {
		return fixedValue;
	}

	@Override
	protected void doInit() throws InitMetaException {
		PListConstraint model = (PListConstraint)pmodel;
		matcher = extFactory.createMatcher(targetType, model.getMatcher(), null, 
				getPModule());
		//macher只可能是ValueList
		assert matcher instanceof PValueListMatcherExt;
		//取得fixedValue
		PValueListMatcherExt listMatcher = (PValueListMatcherExt)matcher;
		if (listMatcher.getItems().size() == 1) {
			try {
				fixedValue = listMatcher.getItems().get(0).valueOf(null);
			} catch (TemplateMatchingExption e) {
				//忽略错误（可能是Range，Any等匹配类型模版）
			}
		}
		super.doInit();
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("fixedValue", fixedValue)
			.append("matcher", matcher)
			.toString();
	}
}
