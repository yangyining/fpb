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
package com.fineqt.fpb.lib.value;

import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;

abstract public class PPrimitiveValueBase extends PValueBase implements PPrimitiveValue{

	public PPrimitiveValueBase(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	@Override
	public boolean isContainer() {
		return false;
	}

	@Override
	public boolean isList() {
		return false;
	}

	@Override
	public boolean isPrimitive() {
		return true;
	}
	
	@Override
	public String getTextAs(IValueTextStyle style) {
		throw new UnsupportedTextStyleException(style, pTypeMeta());
	}

	@Override
	public void setTextAs(String text, IValueTextStyle style) {
		throw new UnsupportedTextStyleException(style, pTypeMeta());
	}

	
	abstract public static class OmitPPrimitiveValueBase extends OmitPValueBase 
	implements PPrimitiveValue {

		public OmitPPrimitiveValueBase(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}
		
		@Override
		public boolean isContainer() {
			return false;
		}

		@Override
		public boolean isList() {
			return false;
		}

		@Override
		public boolean isPrimitive() {
			return true;
		}
		
		@Override
		public String getText() {
			throw new OmitValueException();
		}

		@Override
		public void setText(String text) {
			throw new OmitValueException();
		}

		@Override
		public String getTextAs(IValueTextStyle style) {
			throw new OmitValueException();
		}

		@Override
		public void setTextAs(String text, IValueTextStyle style) {
			throw new OmitValueException();
		}

		@Override
		public String getLiteral() {
			return OMIT_LITERAL;
		}

		
	}

}
