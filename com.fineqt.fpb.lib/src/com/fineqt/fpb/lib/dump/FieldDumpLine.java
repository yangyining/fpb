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
package com.fineqt.fpb.lib.dump;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.value.PValue;

public class FieldDumpLine extends DumpLineBase {
	private TopTypeDumpLine topTypeLine;
	private String enumName;
	private FlagFieldType flagType;
	private DumpLine valueRangeRef;
	private String fieldName;
	
	public FieldDumpLine(PValue value, String fieldName) {
		super(value);
		this.fieldName = fieldName;
	}

	@Override
	public String getName() {
		if (fieldName != null) {
			return fieldName;
		} else if (value == null) {
			return "";
		} else if (value.pFieldMeta() != null) {
			return value.pFieldMeta().getFieldName();
		} else {
			return "";
		}
	}

	public TopTypeDumpLine getTopTypeLine() {
		return topTypeLine;
	}
	public void setTopTypeLine(TopTypeDumpLine topTypeLine) {
		this.topTypeLine = topTypeLine;
	}
	public String getEnumName() {
		return enumName;
	}
	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}
	public FlagFieldType getFlagType() {
		return flagType;
	}
	public void setFlagType(FlagFieldType flagType) {
		this.flagType = flagType;
	}

	@Override
	public Type getType() {
		return Type.FIELD;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.appendSuper(super.toString())
		.append("protocolLine", topTypeLine==null?null:topTypeLine.getName())
		.append("enumName", enumName)
		.append("flagType", flagType)
		.toString();
	}

	public DumpLine getValueRangeRef() {
		return valueRangeRef;
	}

	public void setValueRangeRef(DumpLine valueRangeRef) {
		this.valueRangeRef = valueRangeRef;
	}
	
	@Override
	public BitRegion getValueRegion() {
		if (valueRangeRef != null) {
			return valueRangeRef.getValueRegion();
		}
		return valueRegion;
	}
	
}
