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

import com.fineqt.fpb.lib.codec.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.SimpleUnionValue;
import com.fineqt.fpb.lib.value.PValueMeta;
import com.fineqt.fpb.protocol.sample.Icmpv4Protocol;
import com.fineqt.fpb.protocol.sample.Ipv4Payload;
import com.fineqt.fpb.protocol.sample.Ipv4Protocol;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Ipv4PayloadImpl extends SimpleUnionValue implements Ipv4Payload {

	public static Ipv4Payload createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIpv4Payload(meta);
		} else {
			return new Ipv4PayloadImpl(meta, false);
		}
	}
	
	public static Ipv4Payload createEmptyValue(PValueMeta meta) {
		return new Ipv4PayloadImpl(meta, true);
	}
	
	protected Ipv4PayloadImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta, empty);
	}

	@Override
	public POctetstringValue getData() {
		return (POctetstringValue)pGetFieldByID(SampleModule.IPV4_PAYLOAD__DATA);
	}

	@Override
	public Icmpv4Protocol getIcmpv4() {
		return (Icmpv4Protocol)pGetFieldByID(SampleModule.IPV4_PAYLOAD__ICMPV4);
	}

	@Override
	public Ipv4Protocol getIpv4() {
		return (Ipv4Protocol)pGetFieldByID(SampleModule.IPV4_PAYLOAD__IPV4);
	}

	protected static class OmitIpv4Payload extends OmitPUnionValue implements Ipv4Payload {

		public OmitIpv4Payload(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public POctetstringValue getData() {
			throw new OmitValueException();
		}

		@Override
		public Icmpv4Protocol getIcmpv4() {
			throw new OmitValueException();
		}

		@Override
		public Ipv4Protocol getIpv4() {
			throw new OmitValueException();
		}
		
	}	
}
