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
package com.fineqt.fpb.lib.type.impl;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PRecordOf;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PRecordOfTypeExtBase extends PListTypeExtBase {

	public PRecordOfTypeExtBase(PRecordOf pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		@SuppressWarnings("unchecked")
		PListValue<PValue> result = (PListValue<PValue>)super.createNormalValue(paras);
		if (paras.getInitLength() >= 0) {
			result.setLength(paras.getInitLength());
		}
		return (PValue)result;
	}


	public static class PFpbRecordOfEVExt extends PFpbListEVExt {

		public PFpbRecordOfEVExt(PFpbTypeEV model) {
			super(model);
		}

	}
	
}
