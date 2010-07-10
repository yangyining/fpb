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
import com.fineqt.fpb.protocol.sample.ArpProtocol;
import com.fineqt.fpb.protocol.sample.EtherPayload;
import com.fineqt.fpb.protocol.sample.Ipv4Protocol;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class EtherPayloadImpl extends SimpleUnionValue implements EtherPayload {

	public static EtherPayload createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitEtherPayload(meta);
		} else {
			return new EtherPayloadImpl(meta, false);
		}
	}
	
	public static EtherPayload createEmptyValue(PValueMeta meta) {
		return new EtherPayloadImpl(meta, true);
	}
	
	protected EtherPayloadImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta, empty);
	}

	@Override
	public ArpProtocol getArp() {
		return (ArpProtocol)pGetFieldByID(SampleModule.ETHER_PAYLOAD__ARP);
	}

	@Override
	public POctetstringValue getData() {
		return (POctetstringValue)pGetFieldByID(SampleModule.ETHER_PAYLOAD__DATA);
	}

	@Override
	public Ipv4Protocol getIpv4() {
		return (Ipv4Protocol)pGetFieldByID(SampleModule.ETHER_PAYLOAD__IPV4);
	}

	protected static class OmitEtherPayload extends OmitPUnionValue implements EtherPayload {

		public OmitEtherPayload(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public ArpProtocol getArp() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getData() {
			throw new OmitValueException();
		}

		@Override
		public Ipv4Protocol getIpv4() {
			throw new OmitValueException();
		}
		
	}
}
