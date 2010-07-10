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
import com.fineqt.fpb.protocol.sample.Icmpv4EchoRequest;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Icmpv4EchoRequestImpl extends PRecordSetValueBase implements Icmpv4EchoRequest {
	private PIntegerValue type;
	private PIntegerValue code;
	private POctetstringValue checksum;
	private PIntegerValue identifier;
	private PIntegerValue sequenceNumber;
	private POctetstringValue data;
	
	public static Icmpv4EchoRequest createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIcmpv4EchoRequest(meta);
		} else {
			return new Icmpv4EchoRequestImpl(meta, false);
		}
	}

	public static Icmpv4EchoRequest createEmptyValue(PValueMeta meta) {
		return new Icmpv4EchoRequestImpl(meta, true);
	}
	
	protected Icmpv4EchoRequestImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			type = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ICMPV4_ECHO_REQUEST__TYPE);
			
			code = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ICMPV4_ECHO_REQUEST__CODE);
			
			checksum = (POctetstringValue)createDefaultFieldValue(
						SampleModule.ICMPV4_ECHO_REQUEST__CHECKSUM);
				
			identifier = (PIntegerValue)createDefaultFieldValue(
						SampleModule.ICMPV4_ECHO_REQUEST__IDENTIFIER);
				
			sequenceNumber = (PIntegerValue)createDefaultFieldValue(
						SampleModule.ICMPV4_ECHO_REQUEST__SEQUENCE_NUMBER);
				
			data = (POctetstringValue)createDefaultFieldValue(
						SampleModule.ICMPV4_ECHO_REQUEST__DATA);
		}
	}
	
	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case SampleModule.ICMPV4_ECHO_REQUEST__TYPE:
			return type;
		case SampleModule.ICMPV4_ECHO_REQUEST__CODE:
			return code;
		case SampleModule.ICMPV4_ECHO_REQUEST__CHECKSUM:
			return checksum;
		case SampleModule.ICMPV4_ECHO_REQUEST__IDENTIFIER:
			return identifier;
		case SampleModule.ICMPV4_ECHO_REQUEST__SEQUENCE_NUMBER:
			return sequenceNumber;
		case SampleModule.ICMPV4_ECHO_REQUEST__DATA:
			return data;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case SampleModule.ICMPV4_ECHO_REQUEST__TYPE:
			type = (PIntegerValue)assignNewFieldValue(fieldId, type, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REQUEST__CODE:
			code = (PIntegerValue)assignNewFieldValue(fieldId, code, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REQUEST__CHECKSUM:
			checksum = (POctetstringValue)assignNewFieldValue(fieldId, checksum, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REQUEST__IDENTIFIER:
			identifier = (PIntegerValue)assignNewFieldValue(fieldId, identifier, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REQUEST__SEQUENCE_NUMBER:
			sequenceNumber = (PIntegerValue)assignNewFieldValue(fieldId, sequenceNumber, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REQUEST__DATA:
			data = (POctetstringValue)assignNewFieldValue(fieldId, data, newValue);
			break;
		}
	}

	@Override
	public POctetstringValue getChecksum() {
		return checksum;
	}

	@Override
	public PIntegerValue getCode() {
		return code;
	}

	@Override
	public POctetstringValue getData() {
		return data;
	}

	@Override
	public PIntegerValue getIndentifier() {
		return identifier;
	}

	@Override
	public PIntegerValue getSequenceNumber() {
		return sequenceNumber;
	}

	@Override
	public PIntegerValue getType() {
		return type;
	}

	protected static class OmitIcmpv4EchoRequest extends OmitPRecordSetValueBase 
	implements Icmpv4EchoRequest {

		public OmitIcmpv4EchoRequest(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public POctetstringValue getChecksum() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getCode() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getData() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getIndentifier() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getSequenceNumber() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getType() {
			throw new OmitValueException();
		}

	}	
}
