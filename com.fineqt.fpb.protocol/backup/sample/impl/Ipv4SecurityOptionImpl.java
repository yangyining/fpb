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
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PValueMeta;
import com.fineqt.fpb.protocol.sample.Ipv4SecurityOption;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Ipv4SecurityOptionImpl extends PRecordSetValueBase implements Ipv4SecurityOption{
	private PIntegerValue type;
	private PIntegerValue length;
	private PIntegerValue security;
	private PIntegerValue compartments;
	private PIntegerValue handling;
	private PIntegerValue tcc;
	private PIntegerValue nop;
	
	public static Ipv4SecurityOption createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIpv4SecurityOption(meta);
		} else {
			return new Ipv4SecurityOptionImpl(meta, false);
		}
	}

	public static Ipv4SecurityOption createEmptyValue(PValueMeta meta) {
		return new Ipv4SecurityOptionImpl(meta, true);
	}
	
	protected Ipv4SecurityOptionImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			type = (PIntegerValue)createDefaultFieldValue(
					SampleModule.IPV4_SECURITY_OPTION__TYPE);
			
			length = (PIntegerValue)createDefaultFieldValue(
					SampleModule.IPV4_SECURITY_OPTION__LENGTH);
			
			security = (PIntegerValue)createDefaultFieldValue(
					SampleModule.IPV4_SECURITY_OPTION__SECURITY);
			
			compartments = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_SECURITY_OPTION__COMPARTMENTS);
				
			handling = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_SECURITY_OPTION__HANDLING);
				
			tcc = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_SECURITY_OPTION__TCC);
				
			nop = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_SECURITY_OPTION__NOP);
		}
	}
	
	@Override
	public PIntegerValue getCompartments() {
		return compartments;
	}

	@Override
	public PIntegerValue getHandling() {
		return handling;
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
	public PIntegerValue getSecurity() {
		return security;
	}

	@Override
	public PIntegerValue getTcc() {
		return tcc;
	}

	@Override
	public PIntegerValue getType() {
		return type;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case SampleModule.IPV4_SECURITY_OPTION__TYPE:
			return type;
		case SampleModule.IPV4_SECURITY_OPTION__LENGTH:
			return length;
		case SampleModule.IPV4_SECURITY_OPTION__SECURITY:
			return security;
		case SampleModule.IPV4_SECURITY_OPTION__COMPARTMENTS:
			return compartments;
		case SampleModule.IPV4_SECURITY_OPTION__HANDLING:
			return handling;
		case SampleModule.IPV4_SECURITY_OPTION__TCC:
			return tcc;
		case SampleModule.IPV4_SECURITY_OPTION__NOP:
			return nop;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case SampleModule.IPV4_SECURITY_OPTION__TYPE:
			type = (PIntegerValue)assignNewFieldValue(fieldId, type, newValue);
			break;
		case SampleModule.IPV4_SECURITY_OPTION__LENGTH:
			length = (PIntegerValue)assignNewFieldValue(fieldId, length, newValue);
			break;
		case SampleModule.IPV4_SECURITY_OPTION__SECURITY:
			security = (PIntegerValue)assignNewFieldValue(fieldId, security, newValue);
			break;
		case SampleModule.IPV4_SECURITY_OPTION__COMPARTMENTS:
			compartments = (PIntegerValue)assignNewFieldValue(fieldId, compartments, newValue);
			break;
		case SampleModule.IPV4_SECURITY_OPTION__HANDLING:
			handling = (PIntegerValue)assignNewFieldValue(fieldId, handling, newValue);
			break;
		case SampleModule.IPV4_SECURITY_OPTION__TCC:
			tcc = (PIntegerValue)assignNewFieldValue(fieldId, tcc, newValue);
			break;
		case SampleModule.IPV4_SECURITY_OPTION__NOP:
			nop = (PIntegerValue)assignNewFieldValue(fieldId, nop, newValue);
			break;
		}
	}
	
	protected static class OmitIpv4SecurityOption extends OmitPRecordSetValueBase implements Ipv4SecurityOption {

		public OmitIpv4SecurityOption(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PIntegerValue getCompartments() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getHandling() {
			throw new OmitValueException();
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
		public PIntegerValue getSecurity() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getTcc() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getType() {
			throw new OmitValueException();
		}
		
	}
}
