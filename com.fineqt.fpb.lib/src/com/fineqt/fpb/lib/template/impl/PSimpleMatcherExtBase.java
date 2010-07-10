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

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

abstract public class PSimpleMatcherExtBase extends PTemplateMatcherExtBase {

	public PSimpleMatcherExtBase(PTemplateMatcher pmodel, PTypeElementMeta matcherMeta, 
			PModuleExt ownerModule) {
		super(pmodel, matcherMeta, ownerModule);
	}

}
