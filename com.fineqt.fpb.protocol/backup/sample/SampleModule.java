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

import com.fineqt.fpb.lib.codec.builtin.BuiltinModule;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.type.PRecordSetTypeExt;
import com.fineqt.fpb.lib.type.PSubTypeExt;
import com.fineqt.fpb.lib.type.PUnionTypeExt;
import com.fineqt.fpb.protocol.sample.impl.SampleModuleImpl;

public interface SampleModule extends BuiltinModule {
	SampleModule INSTANCE = SampleModuleImpl.init();
	
	String MODULE_NAME = "sample";
	int UINT1 = MAX_BUILTIN_TYPE + 1;
	int UINT4 = MAX_BUILTIN_TYPE + 2;
	int UINT8 = MAX_BUILTIN_TYPE + 3;
	int UINT13 = MAX_BUILTIN_TYPE + 4;
	int UINT16 = MAX_BUILTIN_TYPE + 5;
	int UINT24 = MAX_BUILTIN_TYPE + 6;
	int UINT32 = MAX_BUILTIN_TYPE + 7;
	int BIT8 = MAX_BUILTIN_TYPE + 8;
	int OCT2 = MAX_BUILTIN_TYPE + 9;
	int OCT4 = MAX_BUILTIN_TYPE + 10;
	
	int ETHER_PROTOCOL = MAX_BUILTIN_TYPE + 100;
	int ETHER_PROTOCOL__DST_ADDRESS = 0;
	int ETHER_PROTOCOL__SRC_ADDRESS = 1;
	int ETHER_PROTOCOL__ETHER_TYPE = 2;
	int ETHER_PROTOCOL__PAYLOAD = 3;
	int ETHER_PROTOCOL__FCS = 4;
	
	int ETHER_PAYLOAD = MAX_BUILTIN_TYPE + 102;
	int ETHER_PAYLOAD__IPV4 = 0;
	int ETHER_PAYLOAD__ARP = 1;
	int ETHER_PAYLOAD__DATA = 2;
	
	int ARP_PROTOCOL = MAX_BUILTIN_TYPE + 103;
	int ARP_PROTOCOL__HW_TYPE = 0;
	int ARP_PROTOCOL__PROTOCOL_TYPE = 1;
	int ARP_PROTOCOL__HLEN = 2;
	int ARP_PROTOCOL__PLEN = 3;
	int ARP_PROTOCOL__OPERATION = 4;
	int ARP_PROTOCOL__SENDER_HW_ADDRESS = 5;
	int ARP_PROTOCOL__SENDER_PROTOCOL_ADDRESS = 6;
	int ARP_PROTOCOL__TARGET_HW_ADDRESS = 7;
	int ARP_PROTOCOL__TARGET_PROTOCOL_ADDRESS = 8;
	
	int IPV4_PROTOCOL = MAX_BUILTIN_TYPE + 104;
	int IPV4_PROTOCOL__HEADER = 0;
	int IPV4_PROTOCOL__PAYLOAD = 1;
	
	int IPV4_HEADER = MAX_BUILTIN_TYPE + 105;
	int IPV4_HEADER__VERSION = 0;
	int IPV4_HEADER__HEADER_LENGTH = 1;
	int IPV4_HEADER__TYPE_OF_SERVICE = 2;
	int IPV4_HEADER__TOTAL_LENGTH = 3;
	int IPV4_HEADER__IDENTIFICATION = 4;
	int IPV4_HEADER__RESERVED = 5;
	int IPV4_HEADER__DO_NOT_FLAG_FLAG = 6;
	int IPV4_HEADER__MORE_FLAGS_FLAG = 7;
	int IPV4_HEADER__FRAGMENT_OFFSET = 8;
	int IPV4_HEADER__TIME_TO_LIVE = 9;
	int IPV4_HEADER__PROTOCOL = 10;
	int IPV4_HEADER__HCS = 11;
	int IPV4_HEADER__SOURCE_ADDRESS = 12;
	int IPV4_HEADER__DESTINATION_ADDRESS = 13;
	int IPV4_HEADER__OPTIONS = 14;
	
	int IPV4_OPTIONS = MAX_BUILTIN_TYPE + 106;
	
	int IPV4_OPTION_ITEM = MAX_BUILTIN_TYPE + 107;
	int IPV4_OPTION_ITEM__SECURITY = 0;
	int IPV4_OPTION_ITEM__LSSR = 1;
	int IPV4_OPTION_ITEM__LAST = 2;
	
	int IPV4_NOP = MAX_BUILTIN_TYPE + 108;
	
	int IPV4_SECURITY_OPTION = MAX_BUILTIN_TYPE + 109;
	int IPV4_SECURITY_OPTION__TYPE = 0;
	int IPV4_SECURITY_OPTION__LENGTH = 1;
	int IPV4_SECURITY_OPTION__SECURITY = 2;
	int IPV4_SECURITY_OPTION__COMPARTMENTS = 3;
	int IPV4_SECURITY_OPTION__HANDLING = 4;
	int IPV4_SECURITY_OPTION__TCC = 5;
	int IPV4_SECURITY_OPTION__NOP = 6;
	
	int IPV4_LSSR_OPTION = MAX_BUILTIN_TYPE + 110;
	int IPV4_LSSR_OPTION__TYPE = 0;
	int IPV4_LSSR_OPTION__LENGTH = 1;
	int IPV4_LSSR_OPTION__POINTER = 2;
	int IPV4_LSSR_OPTION__ROUTE_DATA = 3;
	int IPV4_LSSR_OPTION__NOP = 4;
	
	int IPV4_LAST_OPTION = MAX_BUILTIN_TYPE + 111;
	
	int IPV4_PAYLOAD = MAX_BUILTIN_TYPE + 112;
	int IPV4_PAYLOAD__ICMPV4 = 0;
	int IPV4_PAYLOAD__IPV4 = 1;
	int IPV4_PAYLOAD__DATA = 2;
	
	int ICMPV4_PROTOCOL = MAX_BUILTIN_TYPE + 113;
	int ICMPV4_PROTOCOL__ECHO_REQUEST = 0;
	int ICMPV4_PROTOCOL__ECHO_REPLY = 1;
	
	int ICMPV4_ECHO_REQUEST = MAX_BUILTIN_TYPE + 114;
	int ICMPV4_ECHO_REQUEST__TYPE = 0;
	int ICMPV4_ECHO_REQUEST__CODE = 1;
	int ICMPV4_ECHO_REQUEST__CHECKSUM = 2;
	int ICMPV4_ECHO_REQUEST__IDENTIFIER = 3;
	int ICMPV4_ECHO_REQUEST__SEQUENCE_NUMBER = 4;
	int ICMPV4_ECHO_REQUEST__DATA = 5;
	
	int ICMPV4_ECHO_REPLY = MAX_BUILTIN_TYPE + 115;
	int ICMPV4_ECHO_REPLY__TYPE = 0;
	int ICMPV4_ECHO_REPLY__CODE = 1;
	int ICMPV4_ECHO_REPLY__CHECKSUM = 2;
	int ICMPV4_ECHO_REPLY__IDENTIFIER = 3;
	int ICMPV4_ECHO_REPLY__SEQUENCE_NUMBER = 4;
	int ICMPV4_ECHO_REPLY__DATA = 5;
	
	interface Names extends BuiltinNames {
		String UINT1 = "UInt1";
		String UINT4 = "UInt4";
		String UINT8 = "UInt8";
		String UINT13 = "UInt13";
		String UINT16 = "UInt16";
		String UINT24 = "UInt24";
		String UINT32 = "UInt32";
		String BIT8 = "Bit8";
		String OCT2 = "Oct2";
		String OCT4 = "Oct4";
		
		String ETHER_PROTOCOL = "EtherProtocol";
		String ETHER_PROTOCOL__DST_ADDRESS = "dstAddress";
		String ETHER_PROTOCOL__SRC_ADDRESS = "srcAddress";
		String ETHER_PROTOCOL__ETHER_TYPE = "etherType";
		String ETHER_PROTOCOL__PAYLOAD = "payload";
		String ETHER_PROTOCOL__FCS = "fcs";
		
		String ETHER_PAYLOAD = "EtherPayload";
		String ETHER_PAYLOAD__IPV4 = "ipv4";
		String ETHER_PAYLOAD__ARP = "arp";
		String ETHER_PAYLOAD__DATA = "data";
		
		String ARP_PROTOCOL = "ArpProtocol";
		String ARP_PROTOCOL__HW_TYPE = "hwType";
		String ARP_PROTOCOL__PROTOCOL_TYPE = "protocolType";
		String ARP_PROTOCOL__HLEN = "hlen";
		String ARP_PROTOCOL__PLEN = "plen";
		String ARP_PROTOCOL__OPERATION = "operation";
		String ARP_PROTOCOL__SENDER_HW_ADDRESS = "senderHwAddress";
		String ARP_PROTOCOL__SENDER_PROTOCOL_ADDRESS = "senderProtocolAddress";
		String ARP_PROTOCOL__TARGET_HW_ADDRESS = "targetHwAddress";
		String ARP_PROTOCOL__TARGET_PROTOCOL_ADDRESS = "targetProtocolAddress";

		String IPV4_PROTOCOL = "Ipv4Protocol";
		String IPV4_PROTOCOL__HEADER = "header";
		String IPV4_PROTOCOL__PAYLOAD = "payload";
		
		String IPV4_HEADER = "Ipv4Header";
		String IPV4_HEADER__VERSION = "version";
		String IPV4_HEADER__HEADER_LENGTH = "headerLength";
		String IPV4_HEADER__TYPE_OF_SERVICE = "typeOfService";
		String IPV4_HEADER__TOTAL_LENGTH = "totalLength";
		String IPV4_HEADER__IDENTIFICATION = "identification";
		String IPV4_HEADER__RESERVED = "reserved";
		String IPV4_HEADER__DO_NOT_FLAG_FLAG = "doNotFlagFlag";
		String IPV4_HEADER__MORE_FLAGS_FLAG = "moreFlagsFlag";
		String IPV4_HEADER__FRAGMENT_OFFSET = "fragmentOffset";
		String IPV4_HEADER__TIME_TO_LIVE = "timeToLive";
		String IPV4_HEADER__PROTOCOL = "protocol";
		String IPV4_HEADER__HCS = "hcs";
		String IPV4_HEADER__SOURCE_ADDRESS = "sourceAddress";
		String IPV4_HEADER__DESTINATION_ADDRESS = "destinationAddress";
		String IPV4_HEADER__OPTIONS = "options";
		
		String IPV4_OPTIONS = "Ipv4Options";
		
		String IPV4_OPTION_ITEM = "Ipv4OptionItem";
		String IPV4_OPTION_ITEM__SECURITY = "security";
		String IPV4_OPTION_ITEM__LSSR = "lssr";
		String IPV4_OPTION_ITEM__LAST = "last";
		
		String IPV4_NOP = "nop";
		
		String IPV4_SECURITY_OPTION = "Ipv4SecurityOption";
		String IPV4_SECURITY_OPTION__TYPE = "type";
		String IPV4_SECURITY_OPTION__LENGTH = "length";
		String IPV4_SECURITY_OPTION__SECURITY = "security";
		String IPV4_SECURITY_OPTION__COMPARTMENTS = "compartments";
		String IPV4_SECURITY_OPTION__HANDLING = "handling";
		String IPV4_SECURITY_OPTION__TCC = "tcc";
		String IPV4_SECURITY_OPTION__NOP = "nop";
		
		String IPV4_LSSR_OPTION = "Ipv4LssrOption";
		String IPV4_LSSR_OPTION__TYPE = "type";
		String IPV4_LSSR_OPTION__LENGTH = "length";
		String IPV4_LSSR_OPTION__POINTER = "pointer";
		String IPV4_LSSR_OPTION__ROUTE_DATA = "routeData";
		String IPV4_LSSR_OPTION__NOP = "nop";
		
		String IPV4_LAST_OPTION = "LastOption";
		
		String IPV4_PAYLOAD = "Ipv4Payload";
		String IPV4_PAYLOAD__ICMPV4 = "icmpv4";
		String IPV4_PAYLOAD__IPV4 = "ipv4";
		String IPV4_PAYLOAD__DATA = "data";
		
		String ICMPV4_PROTOCOL = "Icmpv4Protocol";
		String ICMPV4_PROTOCOL__ECHO_REQUEST = "echoRequest";
		String ICMPV4_PROTOCOL__ECHO_REPLY = "echoReply";
		
		String ICMPV4_ECHO_REQUEST = "Icmpv4EchoRequest";
		String ICMPV4_ECHO_REQUEST__TYPE = "type";
		String ICMPV4_ECHO_REQUEST__CODE = "code";
		String ICMPV4_ECHO_REQUEST__CHECKSUM = "checksum";
		String ICMPV4_ECHO_REQUEST__IDENTIFIER = "identifier";
		String ICMPV4_ECHO_REQUEST__SEQUENCE_NUMBER = "sequenceNumber";
		String ICMPV4_ECHO_REQUEST__DATA = "data";
		
		String ICMPV4_ECHO_REPLY = "Icmpv4EchoReply";
		String ICMPV4_ECHO_REPLY__TYPE = "type";
		String ICMPV4_ECHO_REPLY__CODE = "code";
		String ICMPV4_ECHO_REPLY__CHECKSUM = "checksum";
		String ICMPV4_ECHO_REPLY__IDENTIFIER = "identifier";
		String ICMPV4_ECHO_REPLY__SEQUENCE_NUMBER = "sequenceNumber";
		String ICMPV4_ECHO_REPLY__DATA = "data";
	}
	
	PSubTypeExt getUInt1();
	PSubTypeExt getUInt4();
	PSubTypeExt getUInt8();
	PSubTypeExt getUInt13();
	PSubTypeExt getUInt16();
	PSubTypeExt getUInt24();
	PSubTypeExt getUInt32();
	PSubTypeExt getBit8();
	PSubTypeExt getOct2();
	PSubTypeExt getOct4();
	PRecordSetTypeExt getEtherProtocol();
	PUnionTypeExt getEtherPayload();
	PRecordSetTypeExt getArpProtocol();
	PRecordSetTypeExt getIpv4Protocol();
	PRecordSetTypeExt getIpv4Header();
	PListTypeExt getIpv4Options();
	PUnionTypeExt getIpv4OptionItem();
	PSubTypeExt getIpv4Nop();
	PRecordSetTypeExt getIpv4SecurityOption();
	PRecordSetTypeExt getIpv4LssrOption();
	PSubTypeExt getIpv4LastOption();
	PUnionTypeExt getIpv4Payload();
	PUnionTypeExt getIcmpv4Protocol();
	PRecordSetTypeExt getIcmpv4EchoRequest();
	PRecordSetTypeExt getIcmpv4EchoReply();
}
