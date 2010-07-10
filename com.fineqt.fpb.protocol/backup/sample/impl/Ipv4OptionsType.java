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
package com.fineqt.fpb.protocol.sample.impl;

import com.fineqt.fpb.lib.api.IListValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.impl.PRecordOfTypeExtBase;
import com.fineqt.fpb.lib.value.PRecordSetOfValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.protocol.sample.Ipv4OptionItem;

public class Ipv4OptionsType extends PRecordOfTypeExtBase {

	public Ipv4OptionsType(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		IListValue<Ipv4OptionItem> result =
			PRecordSetOfValue.createValue(Ipv4OptionItem.class, this, false);
		if (paras.getInitLength() >= 0) {
			result.setLength(paras.getInitLength());
		}
		return (PValue)result;
	}

	@Override
	public PValue createOmitValue() {
		return (PValue)PRecordSetOfValue.createValue(Ipv4OptionItem.class, this, true);
	}
	
	@Override
	public PValue createEmptyValue() {
		return (PValue)PRecordSetOfValue.createValue(Ipv4OptionItem.class, this, false);
	}

}
