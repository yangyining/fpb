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

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase;
import com.fineqt.fpb.lib.value.PValue;

public class Icmpv4EchoReplyType extends PRecordTypeExtBase {

	public Icmpv4EchoReplyType(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		return (PValue)Icmpv4EchoReplyImpl.createValue(this, false);
	}

	@Override
	public PValue createOmitValue() {
		return (PValue)Icmpv4EchoReplyImpl.createValue(this, true);
	}

	@Override
	public PValue createEmptyValue() {
		return (PValue)Icmpv4EchoReplyImpl.createEmptyValue(this);
	}

	//逻辑与Icmpv4EchoRequestType相同
	public static class PTypeEVExt4Fpb extends Icmpv4EchoRequestType.PTypeEVExt4Fpb {

		public PTypeEVExt4Fpb(PFpbTypeEV model) {
			super(model);
		}
		
	}
	
}