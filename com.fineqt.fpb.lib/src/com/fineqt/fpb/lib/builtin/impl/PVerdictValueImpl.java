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

import com.fineqt.fpb.lib.builtin.PVerdictValue;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.PPrimitiveValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PVerdictValueImpl extends PPrimitiveValueBase implements PVerdictValue{
	protected int value = NONE;
	
	public static PVerdictValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPVerdictValue(valueMeta);
		} else {
			return new PVerdictValueImpl(valueMeta);
		}
	}

	public PVerdictValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	@Override
	public int getVerdict() {
		return value;
	}

	@Override
	public String getText() {
		String desc = "";
		switch(value) {
		case NONE:
			desc = NONE_LITERAL;
			break;
		case PASS:
			desc = PASS_LITERAL;
			break;
		case INCONC:
			desc = INCONC_LITERAL;
			break;
		case FAIL:
			desc = FAIL_LITERAL;
			break;
		case ERROR:
			desc = ERROR_LITERAL;
			break;
		}
		return desc;
	}

	@Override
	public void setText(String text) {
		String st = text.toLowerCase();
		if (st.equals(NONE_LITERAL)) {
			value = NONE;
		} else if (st.equals(PASS_LITERAL)) {
			value = PASS;
		} else if (st.equals(INCONC_LITERAL)) {
			value = INCONC;
		} else if (st.equals(FAIL_LITERAL)) {
			value = FAIL;
		} else if (st.equals(ERROR_LITERAL)) {
			value = ERROR;
		} else {
			throw new IllegalLiteralFormatException();
		}
	}

	@Override
	public String getLiteral() {
		return getText();
	}

	@Override
	public void setVerdict(int newValue) {
		switch(value) {
		case NONE:
		case PASS:
		case INCONC:
		case FAIL:
		case ERROR:
			value = newValue;
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		PVerdictValueImpl entity = (PVerdictValueImpl)srcValue;
		this.value = entity.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + value;
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
		final PVerdictValueImpl other = (PVerdictValueImpl) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("value", getText());
		return builder.toString();
	}

	public static class OmitPVerdictValue extends OmitPPrimitiveValueBase implements PVerdictValue {

		public OmitPVerdictValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public int getVerdict() {
			throw new OmitValueException();
		}

		@Override
		public void setVerdict(int value) {
			throw new OmitValueException();
		}
		
	}
}
