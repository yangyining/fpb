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
package com.fineqt.fpb.lib.value;


public class SimpleRecordSetValue extends PRecordSetValueBase {
	protected PValue[] values;
	
	public static PRecordSetValue createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitCompactRecordSetValue(meta);
		} else {
			return new SimpleRecordSetValue(meta, false);
		}
	}

	public static PRecordSetValue createEmptyValue(PTypeElementMeta meta) {
		return new SimpleRecordSetValue(meta, true);
	}
	
	protected SimpleRecordSetValue(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		int fieldSize = getContainerTypeExt().getFieldSize();
		values = new PValue[fieldSize];
		if (!empty) {
			//候设置初始值
			for (int i = 0; i < fieldSize; i++) {
				values[i] = createDefaultFieldValue(i);
			}
		}
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		return values[fieldId];
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		values[fieldId] = assignNewFieldValue(fieldId, values[fieldId], newValue);
	}

	public static class OmitCompactRecordSetValue extends OmitPRecordSetValueBase{

		public OmitCompactRecordSetValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}
	}
}
