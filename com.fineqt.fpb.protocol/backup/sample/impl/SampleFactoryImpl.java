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
import com.fineqt.fpb.lib.api.IUnionValue;
import com.fineqt.fpb.lib.api.IValue;
import com.fineqt.fpb.lib.codec.builtin.PBitstringValue;
import com.fineqt.fpb.lib.codec.builtin.PIntegerValue;
import com.fineqt.fpb.lib.codec.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.user.PUserFactoryExtBase;
import com.fineqt.fpb.protocol.sample.ArpProtocol;
import com.fineqt.fpb.protocol.sample.EtherPayload;
import com.fineqt.fpb.protocol.sample.EtherProtocol;
import com.fineqt.fpb.protocol.sample.Icmpv4EchoReply;
import com.fineqt.fpb.protocol.sample.Icmpv4EchoRequest;
import com.fineqt.fpb.protocol.sample.Icmpv4Protocol;
import com.fineqt.fpb.protocol.sample.Ipv4Header;
import com.fineqt.fpb.protocol.sample.Ipv4LssrOption;
import com.fineqt.fpb.protocol.sample.Ipv4OptionItem;
import com.fineqt.fpb.protocol.sample.Ipv4Payload;
import com.fineqt.fpb.protocol.sample.Ipv4Protocol;
import com.fineqt.fpb.protocol.sample.Ipv4SecurityOption;
import com.fineqt.fpb.protocol.sample.SampleFactory;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class SampleFactoryImpl extends PUserFactoryExtBase implements SampleFactory {
	private static SampleFactoryImpl instance;
	
	private SampleFactoryImpl() {
	}

	synchronized public static SampleFactory init() {
		SampleFactory factory = (SampleFactory)PModuleExt.Registry.PINSTANCE.getPFactory(
				SampleModule.MODULE_NAME);
		if (factory != null) {
			return factory;
		}
		if (instance == null) {
			instance = new SampleFactoryImpl();
			PModuleExt.Registry.PINSTANCE.registerPFactory(
					SampleModule.MODULE_NAME, instance);
		}
		return instance;
	}

	@Override
	public ArpProtocol createArpProtocol() {
		return doCreateArpProtocol(ValueMode.DEFAULT);
	}

	protected ArpProtocol doCreateArpProtocol(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (ArpProtocol)createObjByMode(mode, module.getArpProtocol());
	}
	
	@Override
	public PBitstringValue createBit8() {
		return doCreateBit8(ValueMode.DEFAULT);
	}

	protected PBitstringValue doCreateBit8(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PBitstringValue)createObjByMode(mode, module.getBit8());
	}
	
	@Override
	public EtherPayload createEtherPayload() {
		return doCreateEtherPayload(ValueMode.DEFAULT);
	}

	protected EtherPayload doCreateEtherPayload(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (EtherPayload)createObjByMode(mode, module.getEtherPayload());
	}
	
	@Override
	public EtherProtocol createEtherProtocol() {
		return doCreateEtherProtocol(ValueMode.DEFAULT);
	}

	protected EtherProtocol doCreateEtherProtocol(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (EtherProtocol)createObjByMode(mode, module.getEtherProtocol());
	}
	
	@Override
	public POctetstringValue createOct2() {
		return doCreateOct2(ValueMode.DEFAULT);
	}

	protected POctetstringValue doCreateOct2(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (POctetstringValue)createObjByMode(mode, module.getOct2());
	}

	@Override
	public POctetstringValue createOct4() {
		return doCreateOct4(ValueMode.DEFAULT);
	}

	protected POctetstringValue doCreateOct4(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (POctetstringValue)createObjByMode(mode, module.getOct4());
	}

	@Override
	public PIntegerValue createUInt1() {
		return doCreateUint1(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUint1(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUInt1());
	}

	@Override
	public PIntegerValue createUInt13() {
		return doCreateUint13(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUint13(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUInt13());
	}

	@Override
	public PIntegerValue createUInt16() {
		return doCreateUint16(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUint16(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUInt16());
	}

	@Override
	public PIntegerValue createUInt24() {
		return doCreateUint24(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUint24(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUInt24());
	}
	
	@Override
	public PIntegerValue createUInt32() {
		return doCreateUint32(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUint32(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUInt32());
	}

	@Override
	public PIntegerValue createUInt4() {
		return doCreateUint4(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUint4(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUInt4());
	}

	@Override
	public PIntegerValue createUInt8() {
		return doCreateUint8(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateUint8(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getUInt8());
	}
	
	@Override
	public Icmpv4EchoReply createIcmpv4EchoReply() {
		return doCreateIcmpv4EchoReply(ValueMode.DEFAULT);
	}

	protected Icmpv4EchoReply doCreateIcmpv4EchoReply(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Icmpv4EchoReply)createObjByMode(mode, module.getIcmpv4EchoReply());
	}
	
	@Override
	public Icmpv4EchoRequest createIcmpv4EchoRequest() {
		return doCreateIcmpv4EchoRequest(ValueMode.DEFAULT);
	}

	protected Icmpv4EchoRequest doCreateIcmpv4EchoRequest(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Icmpv4EchoRequest)createObjByMode(mode, module.getIcmpv4EchoRequest());
	}
	
	@Override
	public Icmpv4Protocol createIcmpv4Protocol() {
		return doCreateIcmpv4Protocol(ValueMode.DEFAULT);
	}

	protected Icmpv4Protocol doCreateIcmpv4Protocol(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Icmpv4Protocol)createObjByMode(mode, module.getIcmpv4Protocol());
	}
	
	@Override
	public Ipv4Header createIpv4Header() {
		return doCreateIpv4Header(ValueMode.DEFAULT);
	}

	protected Ipv4Header doCreateIpv4Header(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Ipv4Header)createObjByMode(mode, module.getIpv4Header());
	}
	
	@Override
	public PIntegerValue createIpv4LastOption() {
		return doCreateIpv4LastOption(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateIpv4LastOption(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getIpv4LastOption());
	}
	
	@Override
	public Ipv4LssrOption createIpv4LssrOption() {
		return doCreateIpv4LssrOption(ValueMode.DEFAULT);
	}

	protected Ipv4LssrOption doCreateIpv4LssrOption(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Ipv4LssrOption)createObjByMode(mode, module.getIpv4LssrOption());
	}
	
	@Override
	public PIntegerValue createIpv4Nop() {
		return doCreateIpv4Nop(ValueMode.DEFAULT);
	}

	protected PIntegerValue doCreateIpv4Nop(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (PIntegerValue)createObjByMode(mode, module.getIpv4Nop());
	}
	
	@Override
	public Ipv4OptionItem createIpv4OptionItem() {
		return doCreateIpv4OptionItem(ValueMode.DEFAULT);
	}

	protected Ipv4OptionItem doCreateIpv4OptionItem(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Ipv4OptionItem)createObjByMode(mode, module.getIpv4OptionItem());
	}
	
	@Override
	public IListValue<IUnionValue> createIpv4Options() {
		return doCreateIpv4Options(ValueMode.DEFAULT);
	}

	@SuppressWarnings("unchecked")
	protected IListValue<IUnionValue> doCreateIpv4Options(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (IListValue<IUnionValue>)createObjByMode(mode, module.getIpv4Options());
	}
	
	@Override
	public Ipv4Payload createIpv4Payload() {
		return doCreateIpv4Payload(ValueMode.DEFAULT);
	}

	protected Ipv4Payload doCreateIpv4Payload(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Ipv4Payload)createObjByMode(mode, module.getIpv4Payload());
	}
	
	@Override
	public Ipv4Protocol createIpv4Protocol() {
		return doCreateIpv4Protocol(ValueMode.DEFAULT);
	}

	protected Ipv4Protocol doCreateIpv4Protocol(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Ipv4Protocol)createObjByMode(mode, module.getIpv4Protocol());
	}
	
	@Override
	public Ipv4SecurityOption createIpv4SecurityOption() {
		return doCreateIpv4SecurityOption(ValueMode.DEFAULT);
	}

	protected Ipv4SecurityOption doCreateIpv4SecurityOption(ValueMode mode) {
		SampleModule module = (SampleModule)pmodule;
		return (Ipv4SecurityOption)createObjByMode(mode, module.getIpv4SecurityOption());
	}
	
	protected IValue doCreate(int typeID, ValueMode mode) {
		switch(typeID) {
		case SampleModule.UINT1:
			return doCreateUint1(mode);
		case SampleModule.UINT4:
			return doCreateUint4(mode);
		case SampleModule.UINT8:
			return doCreateUint8(mode);
		case SampleModule.UINT13:
			return doCreateUint13(mode);
		case SampleModule.UINT16:
			return doCreateUint16(mode);
		case SampleModule.UINT24:
			return doCreateUint24(mode);
		case SampleModule.UINT32:
			return doCreateUint32(mode);
		case SampleModule.BIT8:
			return doCreateBit8(mode);
		case SampleModule.OCT2:
			return doCreateOct2(mode);
		case SampleModule.OCT4:
			return doCreateOct4(mode);
		case SampleModule.ETHER_PROTOCOL:
			return doCreateEtherProtocol(mode);
		case SampleModule.ETHER_PAYLOAD:
			return doCreateEtherPayload(mode);
		case SampleModule.ARP_PROTOCOL:
			return doCreateArpProtocol(mode);
		case SampleModule.IPV4_PROTOCOL:
			return doCreateIpv4Protocol(mode);
		case SampleModule.IPV4_HEADER:
			return doCreateIpv4Header(mode);
		case SampleModule.IPV4_OPTIONS:
			return doCreateIpv4Options(mode);
		case SampleModule.IPV4_OPTION_ITEM:
			return doCreateIpv4OptionItem(mode);
		case SampleModule.IPV4_NOP:
			return doCreateIpv4Nop(mode);
		case SampleModule.IPV4_SECURITY_OPTION:
			return doCreateIpv4SecurityOption(mode);
		case SampleModule.IPV4_LSSR_OPTION:
			return doCreateIpv4LssrOption(mode);
		case SampleModule.IPV4_LAST_OPTION:
			return doCreateIpv4LastOption(mode);
		case SampleModule.IPV4_PAYLOAD:
			return doCreateIpv4Payload(mode);
		case SampleModule.ICMPV4_PROTOCOL:
			return doCreateIcmpv4Protocol(mode);
		case SampleModule.ICMPV4_ECHO_REQUEST:
			return doCreateIcmpv4EchoRequest(mode);
		case SampleModule.ICMPV4_ECHO_REPLY:
			return doCreateIcmpv4EchoReply(mode);
		}
		return super.doCreate(typeID, mode);
	}

}
