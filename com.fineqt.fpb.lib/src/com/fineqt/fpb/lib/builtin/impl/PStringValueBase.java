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

import com.fineqt.fpb.lib.builtin.PStringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PPrimitiveValueBase;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

abstract public class PStringValueBase extends PPrimitiveValueBase implements PStringValue{

	public PStringValueBase(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	protected static int toHexValue(char hex) {
		if (hex >= '0' && hex <= '9') {
			return hex - '0';
		}
		if (hex >= 'a' && hex <= 'f') {
			return hex - 'a' + 10;
		}
		if (hex >= 'A' && hex <= 'F') {
			return hex - 'A' + 10;
		}
		throw new IllegalArgumentException();
	}
	
	protected static char toHexChar(int value) {
		switch(value) {
		case 0:
			return '0';
		case 1:
			return '1';
		case 2:
			return '2';
		case 3:
			return '3';
		case 4:
			return '4';
		case 5:
			return '5';
		case 6:
			return '6';
		case 7:
			return '7';
		case 8:
			return '8';
		case 9:
			return '9';
		case 10:
			return 'A';
		case 11:
			return 'B';
		case 12:
			return 'C';
		case 13:
			return 'D';
		case 14:
			return 'E';
		case 15:
			return 'F';
		default:
			throw new IllegalArgumentException();
		}
	}

	protected String byteToHexStr(byte bt) {
		StringBuilder buf = new StringBuilder();
		buf.append(toHexChar(bt >> 4 & 0x0F));
		buf.append(toHexChar(bt & 0x0F));
		return buf.toString();
	}
	
	protected byte hexStrToByte(char first, char second) {
		int value = ( toHexValue(first) << 4 ) + toHexValue(second);
		return (byte)value;
	}
	
	@Override
	public String getLiteral() {
		return getString();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	abstract protected static class OmitPStringValueBase extends OmitPPrimitiveValueBase 
	implements PStringValue {

		public OmitPStringValueBase(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public int getLength() {
			throw new OmitValueException();
		}

		@Override
		public String getString() {
			return OMIT_LITERAL;
		}

		@Override
		public void setLength(int len) {
			throw new OmitValueException();
		}

		@Override
		public void setString(String literal) {
			throw new OmitValueException();
		}

		@Override
		public String getText() {
			throw new OmitValueException();
		}

		@Override
		public void setText(String text) {
			throw new OmitValueException();
		}
		
	}
}
