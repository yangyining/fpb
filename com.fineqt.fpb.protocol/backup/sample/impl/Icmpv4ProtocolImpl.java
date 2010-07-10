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
import com.fineqt.fpb.lib.value.SimpleUnionValue;
import com.fineqt.fpb.lib.value.PValueMeta;
import com.fineqt.fpb.protocol.sample.Icmpv4EchoReply;
import com.fineqt.fpb.protocol.sample.Icmpv4EchoRequest;
import com.fineqt.fpb.protocol.sample.Icmpv4Protocol;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Icmpv4ProtocolImpl extends SimpleUnionValue implements Icmpv4Protocol{

	public static Icmpv4Protocol createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIcmpv4Protocol(meta);
		} else {
			return new Icmpv4ProtocolImpl(meta, false);
		}
	}
	
	public static Icmpv4Protocol createEmptyValue(PValueMeta meta) {
		return new Icmpv4ProtocolImpl(meta, true);
	}
	
	protected Icmpv4ProtocolImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta, empty);
	}

	@Override
	public Icmpv4EchoReply getEchoReply() {
		return (Icmpv4EchoReply)pGetFieldByID(SampleModule.ICMPV4_PROTOCOL__ECHO_REPLY);
	}

	@Override
	public Icmpv4EchoRequest getEchoRequest() {
		return (Icmpv4EchoRequest)pGetFieldByID(SampleModule.ICMPV4_PROTOCOL__ECHO_REQUEST);
	}

	protected static class OmitIcmpv4Protocol extends OmitPUnionValue implements Icmpv4Protocol {

		public OmitIcmpv4Protocol(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public Icmpv4EchoReply getEchoReply() {
			throw new OmitValueException();
		}

		@Override
		public Icmpv4EchoRequest getEchoRequest() {
			throw new OmitValueException();
		}

	}	

}
