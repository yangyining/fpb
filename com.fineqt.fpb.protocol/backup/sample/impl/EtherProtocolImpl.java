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
import com.fineqt.fpb.protocol.sample.EtherPayload;
import com.fineqt.fpb.protocol.sample.EtherProtocol;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class EtherProtocolImpl extends PRecordSetValueBase implements EtherProtocol {
	POctetstringValue dstAddress;
	POctetstringValue srcAddress;
	PIntegerValue etherType;
	EtherPayload payload;
	POctetstringValue fcs;

	public static EtherProtocol createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitEtherProtocol(meta);
		} else {
			return new EtherProtocolImpl(meta, false);
		}
	}

	public static EtherProtocol createEmptyValue(PValueMeta meta) {
		return new EtherProtocolImpl(meta, true);
	}
	
	protected EtherProtocolImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			dstAddress = (POctetstringValue)createDefaultFieldValue(
					SampleModule.ETHER_PROTOCOL__DST_ADDRESS);
			
			srcAddress = (POctetstringValue)createDefaultFieldValue(
					SampleModule.ETHER_PROTOCOL__SRC_ADDRESS);

			etherType = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ETHER_PROTOCOL__ETHER_TYPE);

			payload = (EtherPayload)createDefaultFieldValue(
					SampleModule.ETHER_PROTOCOL__PAYLOAD);

			fcs = (POctetstringValue)createDefaultFieldValue(
					SampleModule.ETHER_PROTOCOL__FCS);

		}
	}
	
	@Override
	public POctetstringValue getDstAddress() {
		return dstAddress;
	}

	@Override
	public PIntegerValue getEtherType() {
		return etherType;
	}

	@Override
	public POctetstringValue getFcs() {
		return fcs;
	}

	@Override
	public EtherPayload getPayload() {
		return payload;
	}

	@Override
	public POctetstringValue getSrcAddress() {
		return srcAddress;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case SampleModule.ETHER_PROTOCOL__DST_ADDRESS:
			return dstAddress;
		case SampleModule.ETHER_PROTOCOL__SRC_ADDRESS:
			return srcAddress;
		case SampleModule.ETHER_PROTOCOL__ETHER_TYPE:
			return etherType;
		case SampleModule.ETHER_PROTOCOL__PAYLOAD:
			return (PValue)payload;
		case SampleModule.ETHER_PROTOCOL__FCS:
			return fcs;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case SampleModule.ETHER_PROTOCOL__DST_ADDRESS:
			dstAddress = (POctetstringValue)assignNewFieldValue(fieldId, dstAddress, newValue);
			break;
		case SampleModule.ETHER_PROTOCOL__SRC_ADDRESS:
			srcAddress = (POctetstringValue)assignNewFieldValue(fieldId, srcAddress, newValue);
			break;
		case SampleModule.ETHER_PROTOCOL__ETHER_TYPE:
			etherType = (PIntegerValue)assignNewFieldValue(fieldId, etherType, newValue);
			break;
		case SampleModule.ETHER_PROTOCOL__PAYLOAD:
			payload = (EtherPayload)assignNewFieldValue(fieldId, (PValue)payload, newValue);
			break;
		case SampleModule.ETHER_PROTOCOL__FCS:
			fcs = (POctetstringValue)assignNewFieldValue(fieldId, fcs, newValue);
			break;
		}
	}
	
	protected static class OmitEtherProtocol extends OmitPRecordSetValueBase implements EtherProtocol {

		public OmitEtherProtocol(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public POctetstringValue getDstAddress() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getEtherType() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getFcs() {
			throw new OmitValueException();
		}

		@Override
		public EtherPayload getPayload() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getSrcAddress() {
			throw new OmitValueException();
		}
		
	}	
}
