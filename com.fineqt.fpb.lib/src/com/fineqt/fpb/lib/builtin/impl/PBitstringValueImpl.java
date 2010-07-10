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

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PBitstringValueImpl extends PStringValueBase implements PBitstringValue {
	
	protected TextBitset value = new NativeTextBitset();
	
	public static PBitstringValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPBitstringValue(valueMeta);
		} else {
			return new PBitstringValueImpl(valueMeta);
		}
	}
	
	protected PBitstringValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	@Override
	public String getText() {
		String bits = value.get(TextBitset.BIN);
		return bits;
	}

	@Override
	public void setText(String bits) {
		for (int i = 0; i < bits.length(); i++) {
			char ch = bits.charAt(i);
			if (ch != '1' && ch != '0') {
				throw new IllegalLiteralFormatException();
			}
		}
		value.set(bits, TextBitset.BIN);
	}

	@Override
	public int getBit(int position) {
		return value.getBit(position)?1:0;
	}

	@Override
	public void setBit(int position, int newValue) {
		value.setBit(position, newValue!=0);
	}

	@Override
	public int getLength() {
		return value.size();
	}

	@Override
	public void setLength(int len) {
		value.resize(len);
	}

	@Override
	public TextBitset getValue() {
		return value;
	}

	@Override
	public void setValue(TextBitset bitset) {
		value = bitset;
	}

	@Override
	public void setString(String literal) {
		if (literal.length() < 3) {
			throw new IllegalArgumentException(literal);
		}
		if ((literal.charAt(0) == DOUBLE_QUOTATION_MARK && 
			literal.endsWith(DOUBLE_QUOTATION_RIGHT_MARK)) ||
			(literal.charAt(0) == SINGLE_QUOTATION_MARK && 
					literal.endsWith(SINGLE_QUOTATION_RIGHT_MARK))) {
			String bits = literal.substring(1, literal.length() - 2);
			setText(bits);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String getString() {
		String bits = getText();
		return SINGLE_QUOTATION_MARK + bits + SINGLE_QUOTATION_RIGHT_MARK;
	}
	
	public void assignPValue(PValue target) {
		super.assignPValue(target);
		PBitstringValueImpl entity = (PBitstringValueImpl)target; 
		this.value.resize(0);
		this.value.append(entity.value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PBitstringValueImpl other = (PBitstringValueImpl) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.appendSuper(super.toString());
		builder.append("value", getString());
		return builder.toString();
	}
	
	public static class OmitPBitstringValue extends OmitPStringValueBase implements PBitstringValue{

		public OmitPBitstringValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public TextBitset getValue() {
			throw new OmitValueException();
		}

		@Override
		public void setValue(TextBitset bitset) {
			throw new OmitValueException();
		}

		@Override
		public int getBit(int position) {
			throw new OmitValueException();
		}

		@Override
		public void setBit(int position, int value) {
			throw new OmitValueException();
		}
		
	}
	
}
