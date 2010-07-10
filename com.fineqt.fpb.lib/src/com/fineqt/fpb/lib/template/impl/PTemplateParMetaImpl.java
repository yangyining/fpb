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

import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.template.PTemplateInstance;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.PTemplateParMeta;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PTemplateParMetaImpl implements PTemplateParMeta {
	private boolean template;
	private PTypeExt type;
	private String name;
	
	public PTemplateParMetaImpl(boolean template, PTypeExt type, String name) {
		this.template = template;
		this.type = type;
		this.name = name;
	}

	@Override
	public TypeMV getTypeMV() {
		return type;
	}

	@Override
	public PTemplateParIns createTmpIns(final PTemplateInstance templateIns) {
		if (!isTemplate()) {
			throw new UnsupportedOperationException();
		}
		return new PTemplateParIns() {

			@Override
			public PTemplateParMeta getMeta() {
				return PTemplateParMetaImpl.this;
			}

			@Override
			public PTemplateInstance getTemplateIns() {
				return templateIns;
			}

			@Override
			public PValue getValue() {
				throw new UnsupportedOperationException();
			}

			@Override
			public boolean isTemplateIns() {
				return true;
			}
			
		};
	}

	@Override
	public PTemplateParIns createValueIns(final PValue valueIns) {
		if (isTemplate()) {
			throw new UnsupportedOperationException();
		}
		return new PTemplateParIns() {

			@Override
			public PTemplateParMeta getMeta() {
				return PTemplateParMetaImpl.this;
			}

			@Override
			public PTemplateInstance getTemplateIns() {
				throw new UnsupportedOperationException();
			}

			@Override
			public PValue getValue() {
				return valueIns;
			}

			@Override
			public boolean isTemplateIns() {
				return false;
			}
			
		};
	}

	@Override
	public String getParName() {
		return name;
	}

	@Override
	public PTypeExt getType() {
		return type;
	}

	@Override
	public boolean isTemplate() {
		return template;
	}

}
