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

import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PValueMeta;
import com.fineqt.fpb.protocol.sample.Ipv4Header;
import com.fineqt.fpb.protocol.sample.Ipv4Payload;
import com.fineqt.fpb.protocol.sample.Ipv4Protocol;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Ipv4ProtocolImpl extends PRecordSetValueBase implements Ipv4Protocol {
	private Ipv4Header header;
	private Ipv4Payload payload;
	
	public static Ipv4Protocol createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIpv4Protocol(meta);
		} else {
			return new Ipv4ProtocolImpl(meta, false);
		}
	}

	public static Ipv4Protocol createEmptyValue(PValueMeta meta) {
		return new Ipv4ProtocolImpl(meta, true);
	}
	
	protected Ipv4ProtocolImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			header = (Ipv4Header)createDefaultFieldValue(
					SampleModule.IPV4_PROTOCOL__HEADER);
			
			payload = (Ipv4Payload)createDefaultFieldValue(
					SampleModule.IPV4_PROTOCOL__PAYLOAD);
		}
	}
	
	@Override
	public Ipv4Header getHeader() {
		return header;
	}

	@Override
	public Ipv4Payload getPayload() {
		return payload;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case SampleModule.IPV4_PROTOCOL__HEADER:
			return (PValue)header;
		case SampleModule.IPV4_PROTOCOL__PAYLOAD:
			return (PValue)payload;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case SampleModule.IPV4_PROTOCOL__HEADER:
			header = (Ipv4Header)assignNewFieldValue(fieldId, (PValue)header, newValue);
			break;
		case SampleModule.IPV4_PROTOCOL__PAYLOAD:
			payload = (Ipv4Payload)assignNewFieldValue(fieldId, (PValue)payload, newValue);
			break;
		}		
	}

	protected static class OmitIpv4Protocol extends OmitPRecordSetValueBase implements Ipv4Protocol {

		public OmitIpv4Protocol(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public Ipv4Header getHeader() {
			throw new OmitValueException();
		}

		@Override
		public Ipv4Payload getPayload() {
			throw new OmitValueException();
		}
		
	}	
}
