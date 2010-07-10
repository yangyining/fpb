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

import java.math.BigInteger;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PPrimitiveValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PIntegerValueImpl extends PPrimitiveValueBase implements PIntegerValue {
	private static final String HEX_PREFIX = "0x";
	
	protected BigInteger value = BigInteger.valueOf(0);
	
	public static PIntegerValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPIntegerValue(valueMeta);
		} else {
			return new PIntegerValueImpl(valueMeta);
		}
	}

	protected PIntegerValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	@Override
	public String getText() {
		return value.toString();
	}

	@Override
	public void setText(String text) {
		if (text.startsWith(HEX_PREFIX)) {
			value = new BigInteger(text.substring(HEX_PREFIX.length()), 16);
		} else {
			value = new BigInteger(text);
		}
	}

	@Override
	public String getLiteral() {
		return getText();
	}

	@Override
	public int getInteger() {
		return value.intValue();
	}

	@Override
	public void setInteger(int intValue) {
		value = BigInteger.valueOf(intValue);
	}

	@Override
	public BigInteger getBigInteger() {
		return value;
	}

	@Override
	public long getLong() {
		return value.longValue();
	}

	@Override
	public void setBigInteger(BigInteger bigValue) {
		value = bigValue;
	}

	@Override
	public void setLong(long longValue) {
		value = BigInteger.valueOf(longValue);
	}

	@Override
	public void negate() {
		value = value.negate();
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		PIntegerValueImpl entity = (PIntegerValueImpl)srcValue;
		this.value = entity.value;
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
		final PIntegerValueImpl other = (PIntegerValueImpl) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("value", value);
		return builder.toString();
	}
	
	public static class OmitPIntegerValue extends OmitPPrimitiveValueBase implements PIntegerValue {

		public OmitPIntegerValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public int getInteger() {
			throw new OmitValueException();
		}

		@Override
		public void setInteger(int value) {
			throw new OmitValueException();
		}

		@Override
		public BigInteger getBigInteger() {
			throw new OmitValueException();
		}

		@Override
		public long getLong() {
			throw new OmitValueException();
		}

		@Override
		public void setBigInteger(BigInteger bigValue) {
			throw new OmitValueException();
		}

		@Override
		public void setLong(long value) {
			throw new OmitValueException();
		}

		@Override
		public void negate() {
			throw new OmitValueException();
		}

	}
}
