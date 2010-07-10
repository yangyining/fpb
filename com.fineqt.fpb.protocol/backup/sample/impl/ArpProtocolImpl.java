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

import com.fineqt.fpb.lib.codec.builtin.PIntegerValue;
import com.fineqt.fpb.lib.codec.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PValueMeta;
import com.fineqt.fpb.protocol.sample.ArpProtocol;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class ArpProtocolImpl extends PRecordSetValueBase implements ArpProtocol {
	private PIntegerValue hwType;
	private PIntegerValue protocolType;
	private PIntegerValue hlen;
	private PIntegerValue plen;
	private PIntegerValue operation;
	private POctetstringValue senderHwAddress;
	private POctetstringValue senderProtocolAddress;
	private POctetstringValue targetHwAddress;
	private POctetstringValue targetProtocolAddress;
	
	public static ArpProtocol createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitArpProtocol(meta);
		} else {
			return new ArpProtocolImpl(meta, false);
		}
	}

	public static ArpProtocol createEmptyValue(PValueMeta meta) {
		return new ArpProtocolImpl(meta, true);
	}
	
	protected ArpProtocolImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			hwType = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__HW_TYPE);
			
			protocolType = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__PROTOCOL_TYPE);
			
			hlen = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__HLEN);
			
			plen = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__PLEN);
			
			operation = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__OPERATION);
			
			senderHwAddress = (POctetstringValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__SENDER_HW_ADDRESS);
			
			senderProtocolAddress = (POctetstringValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__SENDER_PROTOCOL_ADDRESS);
			
			targetHwAddress = (POctetstringValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__TARGET_HW_ADDRESS);
			
			targetProtocolAddress = (POctetstringValue)createDefaultFieldValue(
					SampleModule.ARP_PROTOCOL__TARGET_PROTOCOL_ADDRESS);
			
		}
	}
	
	@Override
	public PIntegerValue getHlen() {
		return hlen;
	}

	@Override
	public PIntegerValue getHwType() {
		return hwType;
	}

	@Override
	public PIntegerValue getOperation() {
		return operation;
	}

	@Override
	public PIntegerValue getPlen() {
		return plen;
	}

	@Override
	public PIntegerValue getProtocolType() {
		return protocolType;
	}

	@Override
	public POctetstringValue getSenderHwAddress() {
		return senderHwAddress;
	}

	@Override
	public POctetstringValue getSenderProtocolAddress() {
		return senderProtocolAddress;
	}

	@Override
	public POctetstringValue getTargetHwAddress() {
		return targetHwAddress;
	}

	@Override
	public POctetstringValue getTargetProtocolAddress() {
		return targetProtocolAddress;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case SampleModule.ARP_PROTOCOL__HW_TYPE:
			return hwType;
		case SampleModule.ARP_PROTOCOL__PROTOCOL_TYPE:
			return protocolType;
		case SampleModule.ARP_PROTOCOL__HLEN:
			return hlen;
		case SampleModule.ARP_PROTOCOL__PLEN:
			return plen;
		case SampleModule.ARP_PROTOCOL__OPERATION:
			return operation;
		case SampleModule.ARP_PROTOCOL__SENDER_HW_ADDRESS:
			return senderHwAddress;
		case SampleModule.ARP_PROTOCOL__SENDER_PROTOCOL_ADDRESS:
			return senderProtocolAddress;
		case SampleModule.ARP_PROTOCOL__TARGET_HW_ADDRESS:
			return targetHwAddress;
		case SampleModule.ARP_PROTOCOL__TARGET_PROTOCOL_ADDRESS:
			return targetProtocolAddress;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case SampleModule.ARP_PROTOCOL__HW_TYPE:
			hwType = (PIntegerValue)assignNewFieldValue(fieldId, hwType, newValue);;
			break;
		case SampleModule.ARP_PROTOCOL__PROTOCOL_TYPE:
			protocolType = (PIntegerValue)assignNewFieldValue(fieldId, protocolType, newValue);;
			break;
		case SampleModule.ARP_PROTOCOL__HLEN:
			hlen = (PIntegerValue)assignNewFieldValue(fieldId, hlen, newValue);;
			break;
		case SampleModule.ARP_PROTOCOL__PLEN:
			plen = (PIntegerValue)assignNewFieldValue(fieldId, plen, newValue);;
			break;
		case SampleModule.ARP_PROTOCOL__OPERATION:
			operation = (PIntegerValue)assignNewFieldValue(fieldId, operation, newValue);;
			break;
		case SampleModule.ARP_PROTOCOL__SENDER_HW_ADDRESS:
			senderHwAddress = (POctetstringValue)assignNewFieldValue(fieldId, senderHwAddress, newValue);;
			break;
		case SampleModule.ARP_PROTOCOL__SENDER_PROTOCOL_ADDRESS:
			senderProtocolAddress = (POctetstringValue)assignNewFieldValue(fieldId, senderProtocolAddress, newValue);;
			break;
		case SampleModule.ARP_PROTOCOL__TARGET_HW_ADDRESS:
			targetHwAddress = (POctetstringValue)assignNewFieldValue(fieldId, targetHwAddress, newValue);;
			break;
		case SampleModule.ARP_PROTOCOL__TARGET_PROTOCOL_ADDRESS:
			targetProtocolAddress = (POctetstringValue)assignNewFieldValue(fieldId, targetProtocolAddress, newValue);;
			break;
		}
		
	}

	protected static class OmitArpProtocol extends OmitPRecordSetValueBase implements ArpProtocol {

		public OmitArpProtocol(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PIntegerValue getHlen() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getHwType() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getOperation() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getPlen() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getProtocolType() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getSenderHwAddress() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getSenderProtocolAddress() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getTargetHwAddress() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getTargetProtocolAddress() {
			throw new OmitValueException();
		}
		
	}
}
