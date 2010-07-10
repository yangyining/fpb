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
package com.fineqt.fpb.lib.grammer.mv;

import com.fineqt.fpb.lib.modelview.TemplateParMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

public class TemplateParSymbol extends SymbolElement implements TemplateParMV {
	private String parName;
	private String baseTypeName;
	private TypeMV typeMV;
	private boolean template;
	
	public TemplateParSymbol(String parName, String baseTypeName,
			boolean template) {
		this.parName = parName;
		this.baseTypeName = baseTypeName;
		this.template = template;
	}

	@Override
	public String getParName() {
		return parName;
	}

	@Override
	public TypeMV getTypeMV() {
		return typeMV;
	}

	@Override
	public boolean isTemplate() {
		return template;
	}

	public String getBaseTypeName() {
		return baseTypeName;
	}

	public void setTypeMV(TypeMV typeMV) {
		this.typeMV = typeMV;
	}

}
