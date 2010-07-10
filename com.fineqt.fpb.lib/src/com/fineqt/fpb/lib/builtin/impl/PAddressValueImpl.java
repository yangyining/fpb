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

import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.builtin.PAddressValue;
import com.fineqt.fpb.lib.value.PPrimitiveValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

/**
 * TODO 未实现
 * @author JiangMin
 *
 */
public class PAddressValueImpl extends PPrimitiveValueBase implements PAddressValue {

	protected PAddressValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	public static PAddressValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPAddressValue(valueMeta);
		} else {
			return new PAddressValueImpl(valueMeta);
		}
	}

	@Override
	public String getText() {
		return null;
	}

	@Override
	public void setText(String text) {
	}

	@Override
	public String getLiteral() {
		return null;
	}

	@Override
	public PValue getAddress() {
		return null;
	}

	@Override
	public void setAddress(PValue value) {
	}


	@Override
	public IValue getAddressValue() {
		return null;
	}

	@Override
	public void setAddressValue(IValue value) {
	}

	protected static class OmitPAddressValue extends OmitPPrimitiveValueBase implements PAddressValue {


		public OmitPAddressValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PValue getAddress() {
			return null;
		}

		@Override
		public void setAddress(PValue value) {
		}
		
		@Override
		public IValue getAddressValue() {
			return null;
		}

		@Override
		public void setAddressValue(IValue value) {
		}

	}
}
