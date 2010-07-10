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

import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.builtin.PHexstringValue;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PHexstringValueImpl extends PStringValueBase implements PHexstringValue {
	private byte[] value = new byte[0];
	private int length = 0;
	
	public static PHexstringValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPHexstringValue(valueMeta);
		} else {
			return new PHexstringValueImpl(valueMeta);
		}
	}

	protected PHexstringValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}


	@Override
	public String getText() {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < length; i++) {
			buf.append(toHexChar(getHex(i)));
		}
		return buf.toString();
	}

	@Override
	public void setText(String hexs) {
		int orgLen = length;
		byte[] orgBuf = value;
		//设置缓存
		int newLen = hexs.length();
		byte[] newBuf = new byte[(newLen + 1) / 2];
		setValue(newBuf, newLen);
		//设置数值
		try {
			for (int i = 0; i < newLen; i++) {
				setHex(i, toHexValue(hexs.charAt(i)));
			}
		} catch (IllegalArgumentException e) {
			//恢复缓存
			setValue(orgBuf, orgLen);
			//异常
			throw new IllegalLiteralFormatException();
		}
	}

	@Override
	public int getHex(int position) {
		if (position >= length) {
			throw new IllegalArgumentException();
		}
		int byteOff = position / 2;
		int hexOff = position % 2;
		int bt = value[byteOff];
		if (hexOff == 0) {
			return (bt & 0xF0) >> 4;
		} else {
			return bt & 0x0F;
		}
	}

	@Override
	public void setHex(int position, int newValue) {
		if (position >= length) {
			throw new IllegalArgumentException();
		}
		int byteOff = position / 2;
		int hexOff = position % 2;
		int bt = value[byteOff];
		if (hexOff == 0) {
			bt = bt & 0x0F | (newValue << 4);
		} else {
			bt = bt & 0xF0 | newValue;
		}
		value[byteOff] = (byte)(0xFF & bt);
	}

	@Override
	public byte[] getValue() {
		return value;
	}

	@Override
	public void setValue(byte[] value, int length) {
		if (value.length * 2 < length) {
			throw new IllegalArgumentException();
		}
		this.value = value;
		this.length = length;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setLength(int newLen) {
		if (length == newLen)
			return;
		int orgBytes = (length + 1) / 2;
		int newBytes = (newLen + 1) / 2;
		if (newBytes > orgBytes) {
			byte[] newBuf = new byte[newBytes];
			System.arraycopy(value, 0, newBuf, 0, orgBytes);
			value = newBuf;
		}
		length = newLen;
	}

	@Override
	public String getString() {
		StringBuilder buf = new StringBuilder();
		buf.append(SINGLE_QUOTATION_MARK);
		for (int i = 0; i < length; i++) {
			buf.append(toHexChar(getHex(i)));
		}
		buf.append(SINGLE_QUOTATION_RIGHT_MARK);
		return buf.toString();
	}

	@Override
	public void setString(String literal) {
		if (literal.length() < 3) {
			throw new IllegalArgumentException();
		}
		if ((literal.charAt(0) == DOUBLE_QUOTATION_MARK && 
				literal.endsWith(DOUBLE_QUOTATION_RIGHT_MARK)) ||
				(literal.charAt(0) == SINGLE_QUOTATION_MARK && 
						literal.endsWith(SINGLE_QUOTATION_RIGHT_MARK))) {
			String hexs = literal.substring(1, literal.length() - 2);
			setText(hexs);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		PHexstringValueImpl entity = (PHexstringValueImpl)srcValue;
		byte[] newBuf = new byte[entity.value.length];
		System.arraycopy(entity.value, 0, newBuf, 0, newBuf.length);
		setValue(newBuf, entity.length);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + length;
		result = prime * result + Arrays.hashCode(value);
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
		final PHexstringValueImpl other = (PHexstringValueImpl) obj;
		if (length != other.length)
			return false;
		if (!Arrays.equals(value, other.value))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("length", length);
		builder.append("value", getString());
		return builder.toString();
	}

	public static class OmitPHexstringValue extends OmitPStringValueBase implements PHexstringValue {

		public OmitPHexstringValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public byte[] getValue() {
			throw new OmitValueException();
		}

		@Override
		public void setValue(byte[] value, int length) {
			throw new OmitValueException();
		}

		@Override
		public int getHex(int position) {
			throw new OmitValueException();
		}

		@Override
		public void setHex(int position, int value) {
			throw new OmitValueException();
		}
		
	}
}
