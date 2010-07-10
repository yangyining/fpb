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

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.builtin.PFloatValue;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PPrimitiveValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PFloatValueImpl extends PPrimitiveValueBase implements PFloatValue{
	protected BigDecimal value = BigDecimal.valueOf(0); 
	
	public static PFloatValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPFloatValue(valueMeta);
		} else {
			return new PFloatValueImpl(valueMeta);
		}
	}

	protected PFloatValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	@Override
	public String getText() {
		return value.toString();
	}

	@Override
	public String getLiteral() {
		return getText();
	}

	@Override
	public void setText(String text) {
		value = new BigDecimal(text);
	}

	@Override
	public BigDecimal getBigDecimal() {
		return value;
	}

	@Override
	public double getDouble() {
		return value.doubleValue();
	}

	@Override
	public void setBigDecimal(BigDecimal bigValue) {
		this.value = bigValue;
	}

	@Override
	public void setDouble(double newValue) {
		value = BigDecimal.valueOf(newValue);
	}

	@Override
	public float getFloat() {
		return value.floatValue();
	}

	@Override
	public void setFloat(float newValue) {
		value = BigDecimal.valueOf(newValue);
	}

	@Override
	public void negate() {
		value = value.negate();
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		PFloatValueImpl entity = (PFloatValueImpl)srcValue;
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
		final PFloatValueImpl other = (PFloatValueImpl) obj;
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

	public static class OmitPFloatValue extends OmitPPrimitiveValueBase implements PFloatValue {

		public OmitPFloatValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public BigDecimal getBigDecimal() {
			throw new OmitValueException();
		}

		@Override
		public double getDouble() {
			throw new OmitValueException();
		}

		@Override
		public void setBigDecimal(BigDecimal bigValue) {
			throw new OmitValueException();
		}

		@Override
		public void setDouble(double value) {
			throw new OmitValueException();
		}

		@Override
		public float getFloat() {
			throw new OmitValueException();
		}

		@Override
		public void setFloat(float value) {
			throw new OmitValueException();
		}
		
		@Override
		public void negate() {
			throw new OmitValueException();
		}

	}
}
