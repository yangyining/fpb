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

import com.fineqt.fpb.lib.codec.builtin.PBitstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.SimpleUnionValue;
import com.fineqt.fpb.lib.value.PValueMeta;
import com.fineqt.fpb.protocol.sample.Ipv4LssrOption;
import com.fineqt.fpb.protocol.sample.Ipv4OptionItem;
import com.fineqt.fpb.protocol.sample.Ipv4SecurityOption;
import com.fineqt.fpb.protocol.sample.SampleModule;

public class Ipv4OptionItemImpl extends SimpleUnionValue implements Ipv4OptionItem {

	public static Ipv4OptionItem createValue(PValueMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitIpv4OptionItem(meta);
		} else {
			return new Ipv4OptionItemImpl(meta, false);
		}
	}
	
	public static Ipv4OptionItem createEmptyValue(PValueMeta meta) {
		return new Ipv4OptionItemImpl(meta, true);
	}
	
	protected Ipv4OptionItemImpl(PValueMeta valueMeta, boolean empty) {
		super(valueMeta, empty);
	}

	@Override
	public PBitstringValue getLastOption() {
		return (PBitstringValue)pGetFieldByID(SampleModule.IPV4_OPTION_ITEM__LAST);
	}

	@Override
	public Ipv4LssrOption getLssr() {
		return (Ipv4LssrOption)pGetFieldByID(SampleModule.IPV4_OPTION_ITEM__LSSR);
	}

	@Override
	public Ipv4SecurityOption getSecurity() {
		return (Ipv4SecurityOption)pGetFieldByID(SampleModule.IPV4_OPTION_ITEM__SECURITY);
	}
	
	protected static class OmitIpv4OptionItem extends OmitPUnionValue implements Ipv4OptionItem {

		public OmitIpv4OptionItem(PValueMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PBitstringValue getLastOption() {
			throw new OmitValueException();
		}

		@Override
		public Ipv4LssrOption getLssr() {
			throw new OmitValueException();
		}

		@Override
		public Ipv4SecurityOption getSecurity() {
			throw new OmitValueException();
		}
		
	}	
}
