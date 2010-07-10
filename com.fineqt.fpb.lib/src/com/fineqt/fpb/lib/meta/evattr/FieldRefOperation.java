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
package com.fineqt.fpb.lib.meta.evattr;

import java.util.EnumSet;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;

public abstract class FieldRefOperation {
	public enum Timing {ENCODE, DECODE, CALCULATE, GETSIZE};
	protected EnumSet<FieldRefOperation.Timing> timings = EnumSet.noneOf(FieldRefOperation.Timing.class);
	
	public FieldRefOperation(String[] timingDescs) throws IllegalLiteralFormatException {
		if (timingDescs == null || timingDescs.length <= 0) {
			throw new IllegalLiteralFormatException();
		}
		for (int i = 0; i < timingDescs.length; i++) {
			String desc = timingDescs[i].toUpperCase();
			timings.add(Timing.valueOf(desc));
		}
	}

	public EnumSet<FieldRefOperation.Timing> getTimings() {
		return timings;
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("timings", timings)
			.toString();
	}
}