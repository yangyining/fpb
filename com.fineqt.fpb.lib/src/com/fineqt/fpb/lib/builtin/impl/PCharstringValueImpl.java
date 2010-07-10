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
package com.fineqt.fpb.lib.builtin.impl;

import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PCharstringValueImpl extends PCharstringValueBase implements PCharstringValue {
	
	public static PCharstringValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPCharstringValue(valueMeta);
		} else {
			return new PCharstringValueImpl(valueMeta);
		}
	}

	protected PCharstringValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	public static class OmitPCharstringValue extends OmitPStringValueBase implements PCharstringValue {

		public OmitPCharstringValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public char getChar(int position) {
			throw new OmitValueException();
		}

		@Override
		public void setChar(int position, char value) {
			throw new OmitValueException();
		}

		@Override
		public char[] getValue() {
			throw new OmitValueException();
		}

		@Override
		public void setValue(char[] chars) {
			throw new OmitValueException();
		}
		
	}
}
