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
import com.fineqt.fpb.protocol.sample.Icmpv4EchoReply;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Icmpv4EchoReplyImpl extends PRecordSetValueBase implements Icmpv4EchoReply {
	private PIntegerValue type;
	private PIntegerValue code;
	private POctetstringValue checksum;
	private PIntegerValue identifier;
	private PIntegerValue sequenceNumber;
	private POctetstringValue data;
	
	public static Icmpv4EchoReply createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIcmpv4EchoReply(meta);
		} else {
			return new Icmpv4EchoReplyImpl(meta, false);
		}
	}

	public static Icmpv4EchoReply createEmptyValue(PValueMeta meta) {
		return new Icmpv4EchoReplyImpl(meta, true);
	}
	
	protected Icmpv4EchoReplyImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			type = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ICMPV4_ECHO_REPLY__TYPE);
			
			code = (PIntegerValue)createDefaultFieldValue(
					SampleModule.ICMPV4_ECHO_REPLY__CODE);
			
			checksum = (POctetstringValue)createDefaultFieldValue(
						SampleModule.ICMPV4_ECHO_REPLY__CHECKSUM);
				
			identifier = (PIntegerValue)createDefaultFieldValue(
						SampleModule.ICMPV4_ECHO_REPLY__IDENTIFIER);
				
			sequenceNumber = (PIntegerValue)createDefaultFieldValue(
						SampleModule.ICMPV4_ECHO_REPLY__SEQUENCE_NUMBER);
				
			data = (POctetstringValue)createDefaultFieldValue(
						SampleModule.ICMPV4_ECHO_REPLY__DATA);
		}
	}
	
	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case SampleModule.ICMPV4_ECHO_REPLY__TYPE:
			return type;
		case SampleModule.ICMPV4_ECHO_REPLY__CODE:
			return code;
		case SampleModule.ICMPV4_ECHO_REPLY__CHECKSUM:
			return checksum;
		case SampleModule.ICMPV4_ECHO_REPLY__IDENTIFIER:
			return identifier;
		case SampleModule.ICMPV4_ECHO_REPLY__SEQUENCE_NUMBER:
			return sequenceNumber;
		case SampleModule.ICMPV4_ECHO_REPLY__DATA:
			return data;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case SampleModule.ICMPV4_ECHO_REPLY__TYPE:
			type = (PIntegerValue)assignNewFieldValue(fieldId, type, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REPLY__CODE:
			code = (PIntegerValue)assignNewFieldValue(fieldId, code, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REPLY__CHECKSUM:
			checksum = (POctetstringValue)assignNewFieldValue(fieldId, checksum, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REPLY__IDENTIFIER:
			identifier = (PIntegerValue)assignNewFieldValue(fieldId, identifier, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REPLY__SEQUENCE_NUMBER:
			sequenceNumber = (PIntegerValue)assignNewFieldValue(fieldId, sequenceNumber, newValue);
			break;
		case SampleModule.ICMPV4_ECHO_REPLY__DATA:
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

	protected static class OmitIcmpv4EchoReply extends OmitPRecordSetValueBase 
	implements Icmpv4EchoReply {

		public OmitIcmpv4EchoReply(PValueMeta valueMeta) {
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
