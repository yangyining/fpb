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

import com.fineqt.fpb.lib.grammer.T34fpbUtil;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumeratedItem;
import com.fineqt.fpb.lib.modelview.EnumTypeItemMV;

public class EnumTypeItemSymbol extends SymbolElement implements EnumTypeItemMV {
	private PEnumeratedItem model;

	public EnumTypeItemSymbol(String enumName, String minus, String number) {
		model = mfactory.createPEnumeratedItem();
		model.setEnumName(enumName);
		if (number != null) {
			int value = T34fpbUtil.parseIntValue(number);
			if (minus != null) {
				value *= -1;
			}
			model.setEnumValue(value);
		}
		
	}

	public PEnumeratedItem getModel() {
		return model;
	}

	@Override
	public String getEnumName() {
		return model.getEnumName();
	}

	@Override
	public int getEnumValue() {
		return model.getEnumValue();
	}
	
}
