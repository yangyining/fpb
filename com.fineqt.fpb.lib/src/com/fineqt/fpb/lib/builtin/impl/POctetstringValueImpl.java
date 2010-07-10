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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.util.FpbUtils;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.InvalidText2ValueException;
import com.fineqt.fpb.lib.value.InvalidValueToTextException;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class POctetstringValueImpl extends PStringValueBase implements POctetstringValue {
	protected byte[] value = new byte[0];
	
	public static POctetstringValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPOctetstringValue(valueMeta);
		} else {
			return new POctetstringValueImpl(valueMeta);
		}
	}

	public POctetstringValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}


	@Override
	public String getText() {
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < getLength(); i++) {
			buf.append(byteToHexStr(value[i]));
		}
		return buf.toString();
	}

	@Override
	public void setText(String hexs) {
		byte[] orgBuf = value;
		//设置缓存
		if (hexs.length() % 2 != 0) {
			throw new IllegalLiteralFormatException();
		}
		byte[] newBuf = new byte[hexs.length() / 2];
		setValue(newBuf);
		//设置数值
		try {
			for (int i = 0; i < newBuf.length; i++) {
				newBuf[i] = hexStrToByte(hexs.charAt(i * 2), hexs.charAt(i * 2 + 1));
			}
		} catch (IllegalArgumentException e) {
			//恢复缓存
			setValue(orgBuf);
			//异常
			throw new IllegalLiteralFormatException();
		}
	}

	@Override
	public String getTextAs(IValueTextStyle style) {
		switch(style) {
		case IPV4_ADDRESS:
			if (getLength() != IPV4_ADDRESS_BYTES) {
				throw new InvalidValueToTextException(getLiteral(), style);
			}
			try {
				InetAddress v4Addr = InetAddress.getByAddress(value);
				return v4Addr.getHostAddress();
			} catch (UnknownHostException e) {
				throw new InvalidValueToTextException(getLiteral(), style, e);
			}
		case IPV6_ADDRESS:
			if (getLength() != IPV6_ADDRESS_BYTES) {
				throw new InvalidValueToTextException(getLiteral(), style);
			}
			try {
				InetAddress v6Addr = InetAddress.getByAddress(value);
				return v6Addr.getHostAddress();
			} catch (UnknownHostException e) {
				throw new InvalidValueToTextException(getLiteral(), style, e);
			}
		case MAC_ADDRESS:
			if (getLength() != MAC_ADDRESS_BYTES) {
				throw new InvalidValueToTextException(getLiteral(), style);
			}
			return FpbUtils.getMacDesc(value);
		default:
			return super.getTextAs(style);
		}
	}

	@Override
	public void setTextAs(String text, IValueTextStyle style) {
		switch(style) {
		case IPV4_ADDRESS:
		case IPV6_ADDRESS:
			InetAddress addr;
			try {
				addr = InetAddress.getByName(text);
			} catch (UnknownHostException e) {
				throw new InvalidText2ValueException(text, style, e);
			}
			value = addr.getAddress();
			break;
		case MAC_ADDRESS:
			try {
				value = getMacBytes(text);
			} catch (RuntimeException e) {
				throw new InvalidText2ValueException(text, style, e);
			}
			break;
		default:
			super.setTextAs(text, style);
			break;
		}
	}

	private static byte[] getMacBytes(String desc) {
		String[] frms = desc.split(":");
		byte[] macs = new byte[MAC_ADDRESS_BYTES]; 
		for (int i = 0; i < frms.length && i < MAC_ADDRESS_BYTES; i++) {
			macs[i] = (byte)(Integer.parseInt(frms[i], 16) & 0xFF);
		}
		return macs;
	}
	
	@Override
	public byte[] getValue() {
		return value;
	}

	@Override
	public void setValue(byte[] value) {
		this.value = value;
	}

	@Override
	public int getLength() {
		return value.length;
	}

	@Override
	public void setLength(int newLen) {
		if (newLen == value.length)
			return;
		byte[] newBuf = new byte[newLen];
		int copyLen = newLen > value.length ? value.length : newLen;
		System.arraycopy(value, 0, newBuf, 0, copyLen);
		value = newBuf;
	}
	
	@Override
	public String getString() {
		StringBuilder buf = new StringBuilder();
		buf.append(SINGLE_QUOTATION_MARK);
		for (int i = 0; i < getLength(); i++) {
			buf.append(byteToHexStr(value[i]));
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
	public int getOctet(int position) {
		return 0xFF & value[position];
	}

	@Override
	public void setOctet(int position, int newValue) {
		value[position] = (byte)newValue;
	}
	
	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		POctetstringValueImpl entity = (POctetstringValueImpl)srcValue;
		byte[] newBuf = new byte[entity.getLength()];
		System.arraycopy(entity.value, 0, newBuf, 0, newBuf.length);
		setValue(newBuf);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		final POctetstringValueImpl other = (POctetstringValueImpl) obj;
		if (!Arrays.equals(value, other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.appendSuper(super.toString());
		builder.append("length", getLength());
		builder.append("value", getString());
		return builder.toString();
	}

	public static class OmitPOctetstringValue extends OmitPStringValueBase 
	implements POctetstringValue {

		public OmitPOctetstringValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public int getOctet(int position) {
			throw new OmitValueException();
		}

		@Override
		public void setOctet(int position, int value) {
			throw new OmitValueException();
		}

		@Override
		public byte[] getValue() {
			throw new OmitValueException();
		}

		@Override
		public void setValue(byte[] value) {
			throw new OmitValueException();
		}

	}
}
