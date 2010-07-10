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
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeEVExtFactory;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class SampleTypeEVExtFactoryImpl extends PUserTypeEVExtFactoryBase {
	private static SampleTypeEVExtFactoryImpl instance;
	
	protected SampleTypeEVExtFactoryImpl() {
	}

	synchronized public static PTypeEVExtFactory init() {
		//TypeEVExtFactory
		PTypeEVExtFactory typeEVMetaFactory = PModuleExt.Registry.PINSTANCE.getTypeEVMetaFactory(
				SampleModule.MODULE_NAME);
		if (typeEVMetaFactory != null) {
			return typeEVMetaFactory;
		}
		if (instance == null) {
			instance = new SampleTypeEVExtFactoryImpl();
			PModuleExt.Registry.PINSTANCE.registerTypeEVMetaFactory(
					SampleModule.MODULE_NAME, instance);
		}
		return instance;
	}

	@Override
	protected PFpbTypeEVExt createTypeEVExt4FPB(int typeID, PFpbTypeEV evModel) {
		SampleModule module = (SampleModule)pmodule;
		switch(typeID) {
		case SampleModule.UINT1:
			return (PFpbTypeEVExt)module.getUInt1().getSuperType().createTypeEVExt(evModel);
		case SampleModule.UINT4:
			return (PFpbTypeEVExt)module.getUInt4().getSuperType().createTypeEVExt(evModel);
		case SampleModule.UINT8:
			return (PFpbTypeEVExt)module.getUInt8().getSuperType().createTypeEVExt(evModel);
		case SampleModule.UINT13:
			return (PFpbTypeEVExt)module.getUInt13().getSuperType().createTypeEVExt(evModel);
		case SampleModule.UINT16:
			return (PFpbTypeEVExt)module.getUInt16().getSuperType().createTypeEVExt(evModel);
		case SampleModule.UINT24:
			return (PFpbTypeEVExt)module.getUInt24().getSuperType().createTypeEVExt(evModel);
		case SampleModule.UINT32:
			return (PFpbTypeEVExt)module.getUInt32().getSuperType().createTypeEVExt(evModel);
		case SampleModule.BIT8:
			return (PFpbTypeEVExt)module.getBit8().getSuperType().createTypeEVExt(evModel);
		case SampleModule.OCT2:
			return (PFpbTypeEVExt)module.getOct2().getSuperType().createTypeEVExt(evModel);
		case SampleModule.OCT4:
			return (PFpbTypeEVExt)module.getOct4().getSuperType().createTypeEVExt(evModel);
		case SampleModule.ETHER_PROTOCOL:
			return new EtherProtocolType.PTypeEVExt4Fpb(evModel);
		case SampleModule.ETHER_PAYLOAD:
			return new EtherPayloadType.PTypeEVExt4Fpb(evModel);
		case SampleModule.ARP_PROTOCOL:
			return new ArpProtocolType.PTypeEVExt4Fpb(evModel);
		case SampleModule.IPV4_PROTOCOL:
			return new Ipv4ProtocolType.PTypeEVExt4Fpb(evModel);
		case SampleModule.IPV4_HEADER:
			return new Ipv4HeaderType.PTypeEVExt4Fpb(evModel);
		case SampleModule.IPV4_OPTIONS:
			return new Ipv4OptionsType.PTypeEVExt4Fpb(evModel);
		case SampleModule.IPV4_OPTION_ITEM:
			return new Ipv4OptionItemType.PTypeEVExt4Fpb(evModel);
		case SampleModule.IPV4_NOP:
			return (PFpbTypeEVExt)module.getIpv4Nop().getSuperType().createTypeEVExt(evModel);
		case SampleModule.IPV4_SECURITY_OPTION:
			return new Ipv4SecurityOptionType.PTypeEVExt4Fpb(evModel);
		case SampleModule.IPV4_LSSR_OPTION:
			return new Ipv4LssrOptionType.PTypeEVExt4Fpb(evModel);
		case SampleModule.IPV4_LAST_OPTION:
			return (PFpbTypeEVExt)module.getIpv4LastOption().getSuperType().createTypeEVExt(evModel);
		case SampleModule.IPV4_PAYLOAD:
			return new Ipv4PayloadType.PTypeEVExt4Fpb(evModel);
		case SampleModule.ICMPV4_PROTOCOL:
			return new Icmpv4ProtocolType.PTypeEVExt4Fpb(evModel);
		case SampleModule.ICMPV4_ECHO_REQUEST:
			return new Icmpv4EchoRequestType.PTypeEVExt4Fpb(evModel);
		case SampleModule.ICMPV4_ECHO_REPLY:
			return new Icmpv4EchoReplyType.PTypeEVExt4Fpb(evModel);
		}
		return super.createTypeEVExt4FPB(typeID, evModel);
	}
	
}
