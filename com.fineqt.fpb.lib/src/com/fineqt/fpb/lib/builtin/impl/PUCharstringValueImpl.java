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

import com.fineqt.fpb.lib.builtin.PUCharstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PUCharstringValueImpl extends PCharstringValueBase implements PUCharstringValue {

	public static PUCharstringValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPUCharstringValue(valueMeta);
		} else {
			return new PUCharstringValueImpl(valueMeta);
		}
	}

	public PUCharstringValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	protected static class OmitPUCharstringValue extends OmitPStringValueBase implements PUCharstringValue {

		public OmitPUCharstringValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public char[] getValue() {
			throw new OmitValueException();
		}

		@Override
		public void setValue(char[] chars) {
			throw new OmitValueException();
		}

		@Override
		public char getChar(int position) {
			throw new OmitValueException();
		}

		@Override
		public void setChar(int position, char value) {
			throw new OmitValueException();
		}

	}

}
