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
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.builtin.PBooleanValue;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PPrimitiveValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PBooleanValueImpl extends PPrimitiveValueBase implements PBooleanValue {
	protected boolean value;
	
	public static PBooleanValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPBooleanValue(valueMeta);
		} else {
			return new PBooleanValueImpl(valueMeta);
		}
	}

	protected PBooleanValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}


	@Override
	public String getText() {
		return Boolean.toString(value);
	}

	@Override
	public void setText(String text) {
		value = new Boolean(text);
	}

	@Override
	public boolean getBoolean() {
		return value;
	}

	@Override
	public void setBoolean(boolean newValue) {
		this.value = newValue;
	}

	@Override
	public String getLiteral() {
		return value ? TRUE_LITERAL : FALSE_LITERAL;
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		PBooleanValueImpl entity = (PBooleanValueImpl)srcValue;
		this.value = entity.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (value ? 1231 : 1237);
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
		final PBooleanValueImpl other = (PBooleanValueImpl) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.appendSuper(super.toString());
		builder.append("value", value);
		return builder.toString();
	}

	public static class OmitPBooleanValue extends OmitPPrimitiveValueBase implements PBooleanValue {

		public OmitPBooleanValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public boolean getBoolean() {
			throw new OmitValueException();
		}

		@Override
		public void setBoolean(boolean value) {
			throw new OmitValueException();
		}
		
	}
}
