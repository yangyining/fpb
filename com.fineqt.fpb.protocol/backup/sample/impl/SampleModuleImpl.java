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

import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.impl.AbstractPModuleExtProxy;
import com.fineqt.fpb.lib.meta.user.PUserModuleExtBase;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.model.fpbmodule.PContainerType;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV;
import com.fineqt.fpb.lib.model.fpbmodule.PListType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PadType;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.type.PRecordSetTypeExt;
import com.fineqt.fpb.lib.type.PSubTypeExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.PUnionTypeExt;
import com.fineqt.fpb.lib.type.impl.PSubTypeExtImpl;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class SampleModuleImpl extends PUserModuleExtBase implements SampleModule{
	private static SampleModuleImpl instance;
	
	private PSubTypeExt uint1;
	private PSubTypeExt uint4;
	private PSubTypeExt uint8;
	private PSubTypeExt uint13;
	private PSubTypeExt uint16;
	private PSubTypeExt uint24;
	private PSubTypeExt uint32;
	private PSubTypeExt bit8;
	private PSubTypeExt oct2;
	private PSubTypeExt oct4;
	private PRecordSetTypeExt etherProtocol;
	private PUnionTypeExt etherPayload;
	private PRecordSetTypeExt arpProtocol;
	private PRecordSetTypeExt ipv4Protocol;
	private PRecordSetTypeExt ipv4Header;
	private PListTypeExt ipv4Options;
	private PUnionTypeExt ipv4OptionItem;
	private PSubTypeExt ipv4Nop;
	private PRecordSetTypeExt ipv4SecurityOption;
	private PRecordSetTypeExt ipv4LssrOption;
	private PSubTypeExt ipv4LastOption;
	private PUnionTypeExt ipv4Payload;
	private PUnionTypeExt icmpv4Protocol;
	private PRecordSetTypeExt icmpv4EchoRequest;
	private PRecordSetTypeExt icmpv4EchoReply;
	
	private SampleModuleImpl() {
		super(SampleFactoryImpl.init());
	}
	
	synchronized public static SampleModule init() throws InitMetaException {
		PModuleExt moduleMeta = PModuleExt.Registry.PINSTANCE.resolvePModule(
				SampleModule.MODULE_NAME);
		if (moduleMeta != null) {
			return (SampleModule)moduleMeta;
		}
		if (instance == null) {
			instance = new SampleModuleImpl();
			
			PModuleExt.Registry.PINSTANCE.register(new AbstractPModuleExtProxy(
					SampleModule.MODULE_NAME){
				@Override
				protected PModuleExt doResolveModule() throws InitMetaException {
					return instance;
				}
			});
			
			instance.createModuleContents();
			
			instance.initializeModuleContents();
			
		}
		return instance;
	}
	
	protected void createModuleContents() {
/*		PType typemodel;
		PField fieldmodel;
		//TypeEVExtFactory
		pTypeEVExtFactory(SampleTypeEVExtFactoryImpl.init());
		
		//生成Module的模型
		pmodel = createPModuleModel(MODULE_NAME, EncodingType.FPB);
		setFpbModuleEV((PFpbModuleEV)pmodel.getVariant(), ByteOrder.BIG_ENDIAN);

		//EnumSet
		addPEnumSet("Protocols", "integer", new String[][]{
				{"IPv6 Hop-by-Hop Options", "(0)"}, 
				{"ICMP: Internet Control Message Protocol", "(1)"},
				{"IGMP: Internet Group Management Protocol", "(2)"},
				{"GGP: Gateway-to-Gateway Protocol", "(3)"},
				{"IPv4: IP in IP Encasulation", "(4)"},
				{"ST: Stream", "(5)"},
				{"TCP: Transmission Control Protocol", "(6)"},
				{"UCL", "(7)"},
				{"EGP: Exterior Gateway Protocol", "(8)"},
				{"IGRP: Any private interior gateway", "(9)"},
				{"VRRP: Virtual Router Redundancy Protocol", "(12)"},
				{"UDP: User Datagram Protocol", "(17)"},
				{"IPv6: Internet Protocol Version 6", "(41)"}
		});
		addPEnumSet("EtherTypes", "integer", new String[][]{
				{"IEEE802.3 Length Field", "(0..0x05dc)"}, 
				{"IPv4", "(0x0800)"}, 
				{"X.25 Level 3", "(0x0805)"}, 
				{"ARP", "(0x0806)"}
		});
		addPEnumSet("ArpHardwareTypes", "integer", new String[][]{
				{"Ethernet - 10Mb", "(1)"},
				{"IEEE 802 Networks", "(6)"},
				{"Frame Relay", "(15)"},
				{"ATM 16", "(16)"},
				{"HDLC", "(17)"}
		});
		//Builtin和EnumSetExt的生成
		super.createModuleContents(EncodingType.FPB);
		//UInt1
		typemodel = createPSubTypeModel(Names.UINT1, Names.PINTEGER, "(0..1)");
		setFpbTypeEV(typemodel, new Object[][]{{FPBPKG_L.PFPB_TYPE_EV__LENGTH, 1}, 
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.NONE}});
		uint1 = createTypeExt(PSubTypeExtImpl.class, typemodel, UINT1);

		typemodel = createPSubTypeModel(Names.UINT4, Names.PINTEGER, "(0..15)");
		setFpbTypeEV(typemodel, new Object[][]{{FPBPKG_L.PFPB_TYPE_EV__LENGTH, 4}, 
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.NONE}});
		uint4 = createTypeExt(PSubTypeExtImpl.class, typemodel, UINT4);

		typemodel = createPSubTypeModel(Names.UINT8, Names.PINTEGER, "(0..255)");
		setFpbTypeEV(typemodel, new Object[][]{{FPBPKG_L.PFPB_TYPE_EV__LENGTH, 8}, 
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.NONE}});
		uint8 = createTypeExt(PSubTypeExtImpl.class, typemodel, UINT8);

		typemodel = createPSubTypeModel(Names.UINT13, Names.PINTEGER, "(0..8191)");
		setFpbTypeEV(typemodel, new Object[][]{{FPBPKG_L.PFPB_TYPE_EV__LENGTH, 13}, 
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.NONE}});
		uint13 = createTypeExt(PSubTypeExtImpl.class, typemodel, UINT13);

		typemodel = createPSubTypeModel(Names.UINT16, Names.PINTEGER, "(0..65535)");
		setFpbTypeEV(typemodel, new Object[][]{{FPBPKG_L.PFPB_TYPE_EV__LENGTH, 16}, 
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.NONE}});
		uint16 = createTypeExt(PSubTypeExtImpl.class, typemodel, UINT16);

		typemodel = createPSubTypeModel(Names.UINT24, Names.PINTEGER, "(0..16777215)");
		setFpbTypeEV(typemodel, new Object[][]{{FPBPKG_L.PFPB_TYPE_EV__LENGTH, 24}, 
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.NONE}});
		uint24 = createTypeExt(PSubTypeExtImpl.class, typemodel, UINT24);

		typemodel = createPSubTypeModel(Names.UINT32, Names.PINTEGER, "(0..4294967295)");
		setFpbTypeEV(typemodel, new Object[][]{{FPBPKG_L.PFPB_TYPE_EV__LENGTH, 32}, 
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.NONE}});
		uint32 = createTypeExt(PSubTypeExtImpl.class, typemodel, UINT32);


		typemodel = createPSubTypeModel(Names.BIT8, Names.PBITSTRING, "length(8)");
		setFpbTypeEV(typemodel, new Object[][]{});
		bit8 = createTypeExt(PSubTypeExtImpl.class, typemodel, BIT8);
		
		typemodel = createPSubTypeModel(Names.OCT2, Names.POCTETSTRING, "length(2)");
		setFpbTypeEV(typemodel, new Object[][]{});
		oct2 = createTypeExt(PSubTypeExtImpl.class, typemodel, OCT2);
		
		typemodel = createPSubTypeModel(Names.OCT4, Names.POCTETSTRING, "length(4)");
		setFpbTypeEV(typemodel, new Object[][]{});
		oct4 = createTypeExt(PSubTypeExtImpl.class, typemodel, OCT4);
		
		//EtherProtocol
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD, Names.ETHER_PROTOCOL, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__POP_FIELD, "([decode], etherType)"},
				{FPBPKG_L.PFPB_TYPE_EV__PROTOCOL, true}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ETHER_PROTOCOL__DST_ADDRESS, Names.POCTETSTRING, false, "length(6)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ETHER_PROTOCOL__SRC_ADDRESS, Names.POCTETSTRING, false, "length(6)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ETHER_PROTOCOL__ETHER_TYPE, Names.UINT16, false, null, "EtherTypes");
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__PUSH_FIELD, "([decode])"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ETHER_PROTOCOL__PAYLOAD, Names.ETHER_PAYLOAD, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ETHER_PROTOCOL__FCS, Names.OCT4, true, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		etherProtocol = createTypeExt(EtherProtocolType.class, typemodel, ETHER_PROTOCOL);
		
		//EhterPayload
		typemodel = createPEntityTypeModel(FPBPKG_L.PUNION, Names.ETHER_PAYLOAD, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__CASE_REF, "(-etherType, integer)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ETHER_PAYLOAD__IPV4, Names.IPV4_PROTOCOL, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "(integer, (0x0800))"}
		});
	
		fieldmodel = addField((PContainerType)typemodel, Names.ETHER_PAYLOAD__ARP, Names.ARP_PROTOCOL, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "(integer, (0x0806))"}
		});
		
		etherPayload = createTypeExt(EtherPayloadType.class, typemodel, ETHER_PAYLOAD);
		
		//ArpProtocol
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD, Names.ARP_PROTOCOL, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__PROTOCOL, true}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__HW_TYPE, Names.UINT16, false, null, "ArpHardwareTypes");
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__DEFAULT_VALUE, "(6)"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__PROTOCOL_TYPE, Names.UINT16, false, null, "EtherTypes");
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__DEFAULT_VALUE, "(0x0800)"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__HLEN, Names.UINT8, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__DEFAULT_VALUE, "(6)"}
		});
		setFieldEnumItems(fieldmodel, new String[][]{{"MAC", "(6)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__PLEN, Names.UINT8, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__DEFAULT_VALUE, "(4)"}
		});
		setFieldEnumItems(fieldmodel, new String[][]{{"IPv4", "(4)"}, {"IPv6", "(6)"}});

		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__OPERATION, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		setFieldEnumItems(fieldmodel, new String[][]{{"ARP Request", "(1)"}, {"ARP Response", "(2)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__SENDER_HW_ADDRESS, Names.POCTETSTRING, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		setFpbFieldTypeEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_REF, "(^hlen)"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_MULTIPLIER, 8}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__SENDER_PROTOCOL_ADDRESS, Names.POCTETSTRING, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		setFpbFieldTypeEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_REF, "(^plen)"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_MULTIPLIER, 8}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__TARGET_HW_ADDRESS, Names.POCTETSTRING, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		setFpbFieldTypeEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_REF, "(^hlen)"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_MULTIPLIER, 8}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ARP_PROTOCOL__TARGET_PROTOCOL_ADDRESS, Names.POCTETSTRING, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		setFpbFieldTypeEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_REF, "(^plen)"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_MULTIPLIER, 8}
		});
		
		arpProtocol = createTypeExt(ArpProtocolType.class, typemodel, ARP_PROTOCOL);
		
		//Ipv4Protocol
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD, Names.IPV4_PROTOCOL, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__PROTOCOL, true},
				{FPBPKG_L.PFPB_TYPE_EV__SELECT_REF_REGION, "(0, 4)"},
				{FPBPKG_L.PFPB_TYPE_EV__SELECT_COND, "(integer, (4))"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_REF, "(+header/totalLength)"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_MULTIPLIER, 8},
				{FPBPKG_L.PFPB_TYPE_EV__POP_FIELD, "([decode], protocol)"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_PROTOCOL__HEADER, Names.IPV4_HEADER, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_PROTOCOL__PAYLOAD, Names.IPV4_PAYLOAD, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		ipv4Protocol = createTypeExt(Ipv4ProtocolType.class, typemodel, IPV4_PROTOCOL);
		
		//Ipv4Header 
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD, Names.IPV4_HEADER, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_REF, "(+headerLength)"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_MULTIPLIER, 32}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__VERSION, Names.UINT4, false, "(4)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__FLAG_TYPE, FlagFieldType.OCTET}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__HEADER_LENGTH, Names.UINT4, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__FLAG_TYPE, FlagFieldType.OCTET}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__TYPE_OF_SERVICE, Names.BIT8, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__TOTAL_LENGTH, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__IDENTIFICATION, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__RESERVED, Names.UINT1, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__FLAG_TYPE, FlagFieldType._2OCTET}
		});
		setFieldEnumItems(fieldmodel, new String[][]{{"Must be zero", "(0)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__DO_NOT_FLAG_FLAG, Names.UINT1, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__FLAG_TYPE, FlagFieldType._2OCTET}
		});
		setFieldEnumItems(fieldmodel, new String[][]{{"May fragment", "(0)"},
				{"Do not fragment", "(1)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__MORE_FLAGS_FLAG, Names.UINT1, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__FLAG_TYPE, FlagFieldType._2OCTET}
		});
		setFieldEnumItems(fieldmodel, new String[][]{{"Last fragment", "(0)"},
				{"More fragments", "(1)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__FRAGMENT_OFFSET, Names.UINT13, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__FLAG_TYPE, FlagFieldType._2OCTET}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__TIME_TO_LIVE, Names.UINT8, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__PROTOCOL, Names.UINT8, false, null, "Protocols");
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__PUSH_FIELD, "([decode])"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__HCS, Names.OCT2, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__SOURCE_ADDRESS, Names.OCT4, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__DESTINATION_ADDRESS, Names.OCT4, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_HEADER__OPTIONS, Names.IPV4_OPTIONS, true, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		ipv4Header = createTypeExt(Ipv4HeaderType.class, typemodel, IPV4_HEADER);
		
		//Ipv4Options
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD_OF, Names.IPV4_OPTIONS, null);
		setListTypeModel((PListType)typemodel, Names.IPV4_OPTION_ITEM);
		setFpbTypeEV(typemodel, new Object[][]{{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN}});

		ipv4Options = createTypeExt(Ipv4OptionsType.class, typemodel, IPV4_OPTIONS);
		
		//Ipv4OptionItem
		typemodel = createPEntityTypeModel(FPBPKG_L.PUNION, Names.IPV4_OPTION_ITEM, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__CASE_REF_REGION, "(0, 8)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_OPTION_ITEM__SECURITY, Names.IPV4_SECURITY_OPTION, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "caseCond(integer, (130))"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_OPTION_ITEM__LSSR, Names.IPV4_LSSR_OPTION, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "caseCond(integer, (131))"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_OPTION_ITEM__LAST, Names.IPV4_LAST_OPTION, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "caseCond(integer, (0))"}
		});
		
		ipv4OptionItem = createTypeExt(Ipv4OptionItemType.class, typemodel, IPV4_OPTION_ITEM);
		
		//Ipv4Nop
		typemodel = createPSubTypeModel(Names.IPV4_NOP, Names.UINT8, "(1)");
		setFpbTypeEV(typemodel, new Object[][]{});
		ipv4Nop = createTypeExt(PSubTypeExtImpl.class, typemodel, IPV4_NOP);
		
		//Ipv4SecurityOption
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD, Names.IPV4_SECURITY_OPTION, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_REF, "(+length)"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_MULTIPLIER, 8}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_SECURITY_OPTION__TYPE, Names.UINT8, false, "(8)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_SECURITY_OPTION__LENGTH, Names.UINT8, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_SECURITY_OPTION__SECURITY, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_SECURITY_OPTION__COMPARTMENTS, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_SECURITY_OPTION__HANDLING, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_SECURITY_OPTION__TCC, Names.UINT24, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_SECURITY_OPTION__NOP, Names.IPV4_NOP, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		ipv4SecurityOption = createTypeExt(Ipv4SecurityOptionType.class, typemodel, IPV4_SECURITY_OPTION);
		
		//Ipv4LssrOption
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD, Names.IPV4_LSSR_OPTION, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_REF, "(+length)"},
				{FPBPKG_L.PFPB_TYPE_EV__LENGTH_MULTIPLIER, 8}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_LSSR_OPTION__TYPE, Names.UINT8, false, "(8)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_LSSR_OPTION__LENGTH, Names.UINT8, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_LSSR_OPTION__POINTER, Names.UINT8, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_LSSR_OPTION__ROUTE_DATA, Names.OCT4, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_LSSR_OPTION__NOP, Names.IPV4_NOP, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		ipv4LssrOption = createTypeExt(Ipv4SecurityOptionType.class, typemodel, IPV4_LSSR_OPTION);
		
		//Ipv4LastOption
		typemodel = createPSubTypeModel(Names.IPV4_LAST_OPTION, Names.PBITSTRING, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__PAD_TYPE, PadType._4OCTET}
		});
		ipv4LastOption = createTypeExt(PSubTypeExtImpl.class, typemodel, IPV4_LAST_OPTION);
		
		//Ipv4Payload
		typemodel = createPEntityTypeModel(FPBPKG_L.PUNION, Names.IPV4_PAYLOAD, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__CASE_REF, "(-protocol, integer)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_PAYLOAD__ICMPV4, Names.ICMPV4_PROTOCOL, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "(integer, (1))"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_PAYLOAD__IPV4, Names.IPV4_PROTOCOL, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "(integer, (4))"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.IPV4_PAYLOAD__DATA, Names.POCTETSTRING, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		ipv4Payload = createTypeExt(Ipv4PayloadType.class, typemodel, IPV4_PAYLOAD);
		
		//Icmpv4Protocol
		typemodel = createPEntityTypeModel(FPBPKG_L.PUNION, Names.ICMPV4_PROTOCOL, null);
		setFpbTypeEV(typemodel, new Object[][]{
				{FPBPKG_L.PFPB_TYPE_EV__BYTEORDER, ByteOrder.BIG_ENDIAN},
				{FPBPKG_L.PFPB_TYPE_EV__PROTOCOL, true},
				{FPBPKG_L.PFPB_TYPE_EV__CASE_REF_REGION, "(0, 8)"}});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_PROTOCOL__ECHO_REQUEST, Names.ICMPV4_ECHO_REQUEST, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "(integer, (8))"}
		});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_PROTOCOL__ECHO_REPLY, Names.ICMPV4_ECHO_REPLY, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{
				{FPBPKG_L.PFPB_FIELD_EV__CASE_COND, "(integer, (0))"}
		});
		
		icmpv4Protocol = createTypeExt(Icmpv4ProtocolType.class, typemodel, ICMPV4_PROTOCOL);
		
		//Icmpv4EchoRequest
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD, Names.ICMPV4_ECHO_REQUEST, null);
		setFpbTypeEV(typemodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REQUEST__TYPE, Names.UINT8, false, "(8)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REQUEST__CODE, Names.UINT8, false, "(0)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REQUEST__CHECKSUM, Names.OCT2, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REQUEST__IDENTIFIER, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REQUEST__SEQUENCE_NUMBER, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REQUEST__DATA, Names.POCTETSTRING, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		icmpv4EchoRequest = createTypeExt(Icmpv4EchoRequestType.class, typemodel, ICMPV4_ECHO_REQUEST);

		//Icmpv4EchoReply
		typemodel = createPEntityTypeModel(FPBPKG_L.PRECORD, Names.ICMPV4_ECHO_REPLY, null);
		setFpbTypeEV(typemodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REPLY__TYPE, Names.UINT8, false, "(0)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REPLY__CODE, Names.UINT8, false, "(0)", null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REPLY__CHECKSUM, Names.OCT2, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REPLY__IDENTIFIER, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REPLY__SEQUENCE_NUMBER, Names.UINT16, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		fieldmodel = addField((PContainerType)typemodel, Names.ICMPV4_ECHO_REPLY__DATA, Names.POCTETSTRING, false, null, null);
		setFpbFieldEV(fieldmodel, new Object[][]{});
		
		icmpv4EchoReply = createTypeExt(Icmpv4EchoReplyType.class, typemodel, ICMPV4_ECHO_REPLY);
		
		//解决SubType引用的类型和模型
		resolveSubTypeRef();
		
		//解决ImportedType引用的类型和模型
		resolveImportedTypeRef();
		
		//解决Field引用的类型和模型
		resolveFieldTypeRef();
*/
	}
	
	@Override
	public PRecordSetTypeExt getArpProtocol() {
		return arpProtocol;
	}

	@Override
	public PSubTypeExt getBit8() {
		return bit8;
	}

	@Override
	public PUnionTypeExt getEtherPayload() {
		return etherPayload;
	}

	@Override
	public PRecordSetTypeExt getEtherProtocol() {
		return etherProtocol;
	}

	@Override
	public PSubTypeExt getOct2() {
		return oct2;
	}

	@Override
	public PSubTypeExt getOct4() {
		return oct4;
	}

	@Override
	public PSubTypeExt getUInt1() {
		return uint1;
	}

	@Override
	public PSubTypeExt getUInt13() {
		return uint13;
	}

	@Override
	public PSubTypeExt getUInt16() {
		return uint16;
	}

	@Override
	public PSubTypeExt getUInt24() {
		return uint24;
	}

	@Override
	public PSubTypeExt getUInt32() {
		return uint32;
	}

	@Override
	public PSubTypeExt getUInt4() {
		return uint4;
	}

	@Override
	public PSubTypeExt getUInt8() {
		return uint8;
	}

	@Override
	public PRecordSetTypeExt getIcmpv4EchoReply() {
		return icmpv4EchoReply;
	}

	@Override
	public PRecordSetTypeExt getIcmpv4EchoRequest() {
		return icmpv4EchoRequest;
	}

	@Override
	public PUnionTypeExt getIcmpv4Protocol() {
		return icmpv4Protocol;
	}

	@Override
	public PRecordSetTypeExt getIpv4Header() {
		return ipv4Header;
	}

	@Override
	public PSubTypeExt getIpv4LastOption() {
		return ipv4LastOption;
	}

	@Override
	public PRecordSetTypeExt getIpv4LssrOption() {
		return ipv4LssrOption;
	}

	@Override
	public PSubTypeExt getIpv4Nop() {
		return ipv4Nop;
	}

	@Override
	public PUnionTypeExt getIpv4OptionItem() {
		return ipv4OptionItem;
	}

	@Override
	public PListTypeExt getIpv4Options() {
		return ipv4Options;
	}

	@Override
	public PUnionTypeExt getIpv4Payload() {
		return ipv4Payload;
	}

	@Override
	public PRecordSetTypeExt getIpv4Protocol() {
		return ipv4Protocol;
	}

	@Override
	public PRecordSetTypeExt getIpv4SecurityOption() {
		return ipv4SecurityOption;
	}

	@Override
	public PTypeExt pPType(int typeID) {
		switch(typeID) {
		case UINT1:
			return uint1;
		case UINT4:
			return uint4;
		case UINT8:
			return uint8;
		case UINT13:
			return uint13;
		case UINT16:
			return uint16;
		case UINT24:
			return uint24;
		case UINT32:
			return uint32;
		case BIT8:
			return bit8;
		case OCT2:
			return oct2;
		case OCT4:
			return oct4;
		case ETHER_PROTOCOL:
			return etherProtocol;
		case ETHER_PAYLOAD:
			return etherPayload;
		case ARP_PROTOCOL:
			return arpProtocol;
		case IPV4_PROTOCOL:
			return ipv4Protocol;
		case IPV4_HEADER:
			return ipv4Header;
		case IPV4_OPTIONS:
			return ipv4Options;
		case IPV4_OPTION_ITEM:
			return ipv4OptionItem;
		case IPV4_NOP:
			return ipv4Nop;
		case IPV4_SECURITY_OPTION:
			return ipv4SecurityOption;
		case IPV4_LSSR_OPTION:
			return ipv4LssrOption;
		case IPV4_LAST_OPTION:
			return ipv4LastOption;
		case IPV4_PAYLOAD:
			return ipv4Payload;
		case ICMPV4_PROTOCOL:
			return icmpv4Protocol;
		case ICMPV4_ECHO_REQUEST:
			return icmpv4EchoRequest;
		case ICMPV4_ECHO_REPLY:
			return icmpv4EchoReply;
		}
		return getBuiltinTypeExt(typeID);
	}

	@Override
	public PTemplateExt pPTemplate(int templateID) {
		return null;
	}

	@Override
	public PConstantExt pPConstant(int constantID) {
		return null;
	}

	@Override
	public PModuleParExt pPModulePar(int moduleParID) {
		return null;
	}

}
