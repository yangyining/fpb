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

import com.fineqt.fpb.lib.api.value.IObjId;
import com.fineqt.fpb.lib.builtin.PObjidValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PPrimitiveValueBase;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
/**
 * TODO 未实现
 * @author JiangMin
 *
 */
public class PObjidValueImpl extends PPrimitiveValueBase implements PObjidValue {

	public static PObjidValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		if (notPresent) {
			return new OmitPObjidValue(valueMeta);
		} else {
			return new PObjidValueImpl(valueMeta);
		}
	}
	
	public PObjidValueImpl(PTypeElementMeta valueMeta) {
		super(valueMeta);
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
	public IObjId getObjid() {
		return null;
	}

	@Override
	public void setObjid(IObjId value) {
	}

	protected static class OmitPObjidValue extends OmitPPrimitiveValueBase implements PObjidValue {

		public OmitPObjidValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public IObjId getObjid() {
			throw new OmitValueException();
		}

		@Override
		public void setObjid(IObjId value) {
			throw new OmitValueException();
		}
		
	}
}
