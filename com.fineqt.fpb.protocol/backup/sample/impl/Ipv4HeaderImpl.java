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

import com.fineqt.fpb.lib.api.IListValue;
import com.fineqt.fpb.lib.codec.builtin.PBitstringValue;
import com.fineqt.fpb.lib.codec.builtin.PIntegerValue;
import com.fineqt.fpb.lib.codec.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PValueMeta;
import com.fineqt.fpb.protocol.sample.Ipv4Header;
import com.fineqt.fpb.protocol.sample.Ipv4OptionItem;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Ipv4HeaderImpl extends PRecordSetValueBase implements Ipv4Header{
	private PIntegerValue version;
	private PIntegerValue headerLength;
	private PBitstringValue typeOfService;
	private PIntegerValue totalLength;
	private PIntegerValue identification;
	private PIntegerValue reserved;
	private PIntegerValue doNotFlagFlag;
	private PIntegerValue moreFlagsFlag;
	private PIntegerValue fragmentOffset;
	private PIntegerValue timeToLive;
	private PIntegerValue protocol;
	private POctetstringValue hcs;
	private POctetstringValue sourceAddress;
	private POctetstringValue destinationAddress;
	private IListValue<Ipv4OptionItem> options;

	public static Ipv4Header createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIpv4Header(meta);
		} else {
			return new Ipv4HeaderImpl(meta, false);
		}
	}

	public static Ipv4Header createEmptyValue(PValueMeta meta) {
		return new Ipv4HeaderImpl(meta, true);
	}
	
	protected Ipv4HeaderImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			version = (PIntegerValue)createDefaultFieldValue(
					SampleModule.IPV4_HEADER__VERSION);
			
			headerLength = (PIntegerValue)createDefaultFieldValue(
					SampleModule.IPV4_HEADER__HEADER_LENGTH);
			
			typeOfService = (PBitstringValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__TYPE_OF_SERVICE);
				
			totalLength = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__TOTAL_LENGTH);
				
			identification = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__IDENTIFICATION);
				
			reserved = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__RESERVED);
				
			doNotFlagFlag = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__DO_NOT_FLAG_FLAG);
				
			moreFlagsFlag = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__MORE_FLAGS_FLAG);
				
			fragmentOffset = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__FRAGMENT_OFFSET);
				
			timeToLive = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__TIME_TO_LIVE);
				
			protocol = (PIntegerValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__PROTOCOL);
				
			hcs = (POctetstringValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__HCS);
				
			sourceAddress = (POctetstringValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__SOURCE_ADDRESS);
				
			destinationAddress = (POctetstringValue)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__DESTINATION_ADDRESS);
				
			options = (IListValue<Ipv4OptionItem>)createDefaultFieldValue(
						SampleModule.IPV4_HEADER__OPTIONS);
				
		}
	}	
	
	@Override
	public POctetstringValue getDestinationAddress() {
		return destinationAddress;
	}

	@Override
	public PIntegerValue getDoNotFlagFlag() {
		return doNotFlagFlag;
	}

	@Override
	public PIntegerValue getFragmentOffset() {
		return fragmentOffset;
	}

	@Override
	public POctetstringValue getHcs() {
		return hcs;
	}

	@Override
	public PIntegerValue getHeaderLength() {
		return headerLength;
	}

	@Override
	public PIntegerValue getIdentification() {
		return identification;
	}

	@Override
	public PIntegerValue getMoreFlagsFlag() {
		return moreFlagsFlag;
	}

	@Override
	public IListValue<Ipv4OptionItem> getOptions() {
		return options;
	}

	@Override
	public PIntegerValue getProtocol() {
		return protocol;
	}

	@Override
	public PIntegerValue getReserved() {
		return reserved;
	}

	@Override
	public POctetstringValue getSourceAddress() {
		return sourceAddress;
	}

	@Override
	public PIntegerValue getTimeToLive() {
		return timeToLive;
	}

	@Override
	public PIntegerValue getTotalLength() {
		return totalLength;
	}

	@Override
	public PBitstringValue getTypeOfService() {
		return typeOfService;
	}

	@Override
	public PIntegerValue getVersion() {
		return version;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case SampleModule.IPV4_HEADER__VERSION:
			return version;
		case SampleModule.IPV4_HEADER__HEADER_LENGTH:
			return headerLength;
		case SampleModule.IPV4_HEADER__TYPE_OF_SERVICE:
			return typeOfService;
		case SampleModule.IPV4_HEADER__TOTAL_LENGTH:
			return totalLength;
		case SampleModule.IPV4_HEADER__IDENTIFICATION:
			return identification;
		case SampleModule.IPV4_HEADER__RESERVED:
			return reserved;
		case SampleModule.IPV4_HEADER__DO_NOT_FLAG_FLAG:
			return doNotFlagFlag;
		case SampleModule.IPV4_HEADER__MORE_FLAGS_FLAG:
			return moreFlagsFlag;
		case SampleModule.IPV4_HEADER__FRAGMENT_OFFSET:
			return fragmentOffset;
		case SampleModule.IPV4_HEADER__TIME_TO_LIVE:
			return timeToLive;
		case SampleModule.IPV4_HEADER__PROTOCOL:
			return protocol;
		case SampleModule.IPV4_HEADER__HCS:
			return hcs;
		case SampleModule.IPV4_HEADER__SOURCE_ADDRESS:
			return sourceAddress;
		case SampleModule.IPV4_HEADER__DESTINATION_ADDRESS:
			return destinationAddress;
		case SampleModule.IPV4_HEADER__OPTIONS:
			return (PValue)options;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case SampleModule.IPV4_HEADER__VERSION:
			version = (PIntegerValue)assignNewFieldValue(fieldId, version, newValue);
			break;
		case SampleModule.IPV4_HEADER__HEADER_LENGTH:
			headerLength = (PIntegerValue)assignNewFieldValue(fieldId, headerLength, newValue);
			break;
		case SampleModule.IPV4_HEADER__TYPE_OF_SERVICE:
			typeOfService = (PBitstringValue)assignNewFieldValue(fieldId, typeOfService, newValue);
			break;
		case SampleModule.IPV4_HEADER__TOTAL_LENGTH:
			totalLength = (PIntegerValue)assignNewFieldValue(fieldId, totalLength, newValue);
			break;
		case SampleModule.IPV4_HEADER__IDENTIFICATION:
			identification = (PIntegerValue)assignNewFieldValue(fieldId, identification, newValue);
			break;
		case SampleModule.IPV4_HEADER__RESERVED:
			reserved = (PIntegerValue)assignNewFieldValue(fieldId, reserved, newValue);
			break;
		case SampleModule.IPV4_HEADER__DO_NOT_FLAG_FLAG:
			doNotFlagFlag = (PIntegerValue)assignNewFieldValue(fieldId, doNotFlagFlag, newValue);
			break;
		case SampleModule.IPV4_HEADER__MORE_FLAGS_FLAG:
			moreFlagsFlag = (PIntegerValue)assignNewFieldValue(fieldId, moreFlagsFlag, newValue);
			break;
		case SampleModule.IPV4_HEADER__FRAGMENT_OFFSET:
			fragmentOffset = (PIntegerValue)assignNewFieldValue(fieldId, fragmentOffset, newValue);
			break;
		case SampleModule.IPV4_HEADER__TIME_TO_LIVE:
			timeToLive = (PIntegerValue)assignNewFieldValue(fieldId, timeToLive, newValue);
			break;
		case SampleModule.IPV4_HEADER__PROTOCOL:
			protocol = (PIntegerValue)assignNewFieldValue(fieldId, protocol, newValue);
			break;
		case SampleModule.IPV4_HEADER__HCS:
			hcs = (POctetstringValue)assignNewFieldValue(fieldId, hcs, newValue);
			break;
		case SampleModule.IPV4_HEADER__SOURCE_ADDRESS:
			sourceAddress = (POctetstringValue)assignNewFieldValue(fieldId, sourceAddress, newValue);
			break;
		case SampleModule.IPV4_HEADER__DESTINATION_ADDRESS:
			destinationAddress = (POctetstringValue)assignNewFieldValue(fieldId, destinationAddress, newValue);
			break;
		case SampleModule.IPV4_HEADER__OPTIONS:
			options = (IListValue<Ipv4OptionItem>)assignNewFieldValue(fieldId, (PValue)options, newValue);
			break;
		}
	}

	protected static class OmitIpv4Header extends OmitPRecordSetValueBase implements Ipv4Header {

		public OmitIpv4Header(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public POctetstringValue getDestinationAddress() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getDoNotFlagFlag() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getFragmentOffset() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getHcs() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getHeaderLength() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getIdentification() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getMoreFlagsFlag() {
			throw new OmitValueException();
		}

		@Override
		public IListValue<Ipv4OptionItem> getOptions() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getProtocol() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getReserved() {
			throw new OmitValueException();
		}

		@Override
		public POctetstringValue getSourceAddress() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getTimeToLive() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getTotalLength() {
			throw new OmitValueException();
		}

		@Override
		public PBitstringValue getTypeOfService() {
			throw new OmitValueException();
		}

		@Override
		public PIntegerValue getVersion() {
			throw new OmitValueException();
		}
		
	}	
}
