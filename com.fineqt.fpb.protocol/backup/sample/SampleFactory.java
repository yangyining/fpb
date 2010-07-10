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
package com.fineqt.fpb.protocol.sample;

import com.fineqt.fpb.lib.api.IBitstringValue;
import com.fineqt.fpb.lib.api.IIntegerValue;
import com.fineqt.fpb.lib.api.IListValue;
import com.fineqt.fpb.lib.api.IOctetstringValue;
import com.fineqt.fpb.lib.api.IUnionValue;
import com.fineqt.fpb.lib.codec.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.codec.builtin.PIntegerValue;
import com.fineqt.fpb.protocol.sample.impl.SampleFactoryImpl;

public interface SampleFactory extends BuiltinFactory {
	SampleFactory INSTANCE = SampleFactoryImpl.init();
	
	IIntegerValue createUInt1();

	IIntegerValue createUInt4();

	IIntegerValue createUInt8();
	
	IIntegerValue createUInt13();
	
	IIntegerValue createUInt16();

	IIntegerValue createUInt24();

	IIntegerValue createUInt32();
	
	IBitstringValue createBit8();
	
	IOctetstringValue createOct2();
	
	IOctetstringValue createOct4();
	
	EtherProtocol createEtherProtocol();
	
	EtherPayload createEtherPayload();
	
	ArpProtocol createArpProtocol();
	
	Ipv4Protocol createIpv4Protocol();
	
	Ipv4Header createIpv4Header();
	
	IListValue<IUnionValue> createIpv4Options();
	
	Ipv4OptionItem createIpv4OptionItem();
	
	PIntegerValue createIpv4Nop();
	
	Ipv4SecurityOption createIpv4SecurityOption();
	
	Ipv4LssrOption createIpv4LssrOption();
	
	IIntegerValue createIpv4LastOption();
	
	Ipv4Payload createIpv4Payload();
	
	Icmpv4Protocol createIcmpv4Protocol();
	
	Icmpv4EchoRequest createIcmpv4EchoRequest();
	
	Icmpv4EchoReply createIcmpv4EchoReply();
	
}
