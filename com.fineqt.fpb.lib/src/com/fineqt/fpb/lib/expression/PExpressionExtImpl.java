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

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PExpressionExtImpl implements PExpressionExt {
	private PMatcherExt matcher;
	private PTypeExt basetype;
	
	public PExpressionExtImpl(PTypeExt basetype, PMatcherExt matcher) {
		this.basetype = basetype;
		this.matcher = matcher;
	}

	@Override
	public PMatcherExt getMatcher() {
		return matcher;
	}

	@Override
	public PValue valueOf() throws TemplateMatchingExption {
		return matcher.valueOf(null);
	}

	@Override
	public PTypeExt getBasetype() {
		return basetype;
	}
	
	@Override
	public PModuleExt getModule() {
		return basetype.getPModule();
	}

}
