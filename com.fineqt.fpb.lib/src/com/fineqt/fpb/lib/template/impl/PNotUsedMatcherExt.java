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

import com.fineqt.fpb.lib.model.fpbtemplate.PNotUsedMatcher;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PNotUsedMatcherExt extends PSimpleMatcherExtBase {
	
	public PNotUsedMatcherExt(PNotUsedMatcher model,PTypeElementMeta matcherMeta) {
		super(model, matcherMeta);
	}

	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		return true;
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		return null;
	}

}
