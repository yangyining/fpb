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
import com.fineqt.fpb.protocol.sample.Ipv4LssrOption;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Ipv4LssrOptionImpl extends PRecordSetValueBase implements Ipv4LssrOption {
	private PIntegerValue type;
	private PIntegerValue length;
	private PIntegerValue pointer;
	private POctetstringValue routeData;
	private PIntegerValue nop;
	
	public static Ipv4LssrOption createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIpv4LssrOption(meta);
		} else {
			return new Ipv4LssrOptionImpl(meta, false);
		}
	}

	public static Ipv4LssrOption createEmptyValue(PValueMeta meta) {
		return new Ipv4LssrOptionImpl(meta, true);
	}
	
	protected Ipv4LssrOptionImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			type = (PIntegerValue)createDefaultFieldValue(
					SampleModule.IPV4_LSSR_OPTION__TYPE);
			
			length = (PIntegerValue)createDefaultFieldValue(
					SampleModule.IPV4_LSSR_OPTION__LENGTH);

			pointer = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_LSSR_OPTION__POINTER);

			routeData = (POctetstringValue)createDefaultFieldValue(
						SampleModule.IPV4_LSSR_OPTION__ROUTE_DATA);

			nop = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_LSSR_OPTION__NOP);
		}
	}
	
	@Override
	public PIntegerValue getLength() {
		return length;
	}

	@Override
	public PIntegerValue getNop() {
		return nop;
	}

	@Override
	public PIntegerValue getPointer() {
		return pointer;
	}

	@Override
	public POctetstringValue getRouteData() {
		return routeData;
	}

	@Override
	public PIntegerValue getType() {
		return type;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case SampleModule.IPV4_LSSR_OPTION__TYPE:
			return type;
		case SampleModule.IPV4_LSSR_OPTION__LENGTH:
			return length;
		case SampleModule.IPV4_LSSR_OPTION__POINTER:
			return pointer;
		case SampleModule.IPV4_LSSR_OPTION__ROUTE_DATA:
			return routeData;
		case SampleModule.IPV4_LSSR_OPTION__NOP:
			return nop;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case SampleModule.IPV4_LSSR_OPTION__TYPE:
			type = (PIntegerValue)assignNewFieldValue(fieldId, type, newValue);
			break;
		case SampleModule.IPV4_LSSR_OPTION__LENGTH:
			length = (PIntegerValue)assignNewFieldValue(fieldId, length, newValue);
			break;
		case SampleModule.IPV4_LSSR_OPTION__POINTER:
			pointer = (PIntegerValue)assignNewFieldValue(fieldId, pointer, newValue);
			break;
		case SampleModule.IPV4_LSSR_OPTION__ROUTE_DATA:
			routeData = (POctetstringValue)assignNewFieldValue(fieldId, routeData, newValue);
			break;
		case SampleModule.IPV4_LSSR_OPTION__NOP:
			nop = (PIntegerValue)assignNewFieldValue(fieldId, nop, newValue);
			break;
		}
	}

	protected static class OmitIpv4LssrOption extends OmitPRecordSetValueBase implements Ipv4LssrOption {

		public OmitIpv4LssrOption(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PIntegerValue getLength() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getNop() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getPointer() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getRouteData() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getType() {
			throw new OmitValueException();
		}
		
	}
}
