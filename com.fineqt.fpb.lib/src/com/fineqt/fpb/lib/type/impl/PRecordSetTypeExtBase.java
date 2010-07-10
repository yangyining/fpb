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
package com.fineqt.fpb.lib.type.impl;

import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.constraint.Diagnostic;
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.constraint.SimpleDiagnostic;
import com.fineqt.fpb.lib.dump.DumpLine;
import com.fineqt.fpb.lib.dump.TopTypeDumpLine;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PContainerType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PRecordSetTypeExt;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.BitRegionImpl;
import com.fineqt.fpb.lib.value.PRecordSetValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PRecordSetTypeExtBase extends PContainerTypeExtBase 
implements PRecordSetTypeExt {

	public PRecordSetTypeExtBase(PContainerType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	@Override
	public boolean validateFields(PValue value, DiagnosticChain chain) {
		if (!(value instanceof PRecordSetValue)) {
			return false;
		}
		boolean continueOnError = false;
		if (chain != null) {
			continueOnError = chain.shouldCollectAllError();
		}
		PRecordSetValue containerValue = (PRecordSetValue)value;
		boolean hasError = false;
		for (int i = 0; i < getFieldSize(); i++) {
			PValue fieldValue = containerValue.pGetFieldByID(i);
			//Null check
			if (fieldValue == null) {
				if (chain != null) {
					chain.add(new SimpleDiagnostic(Diagnostic.ERROR, "Field of " + 
							getFieldMeta(i).getFieldName() + "is null."));
				}
				hasError = true;
				if (!continueOnError) {
					break;
				}
			//字段值检测
			} else {
				//omit
				if (fieldValue.pFieldMeta().isOptional() && fieldValue.notPresent()) {
					continue;
				}
				//not omit
				if (!fieldValue.validate(chain)) {
					hasError = true;
					if (!continueOnError) {
						break;
					}
				}
			}
		}
		return !hasError;
	}
	
	abstract public static class PFpbRecordSetEVExt extends PFpbContaineEVExt {

		public PFpbRecordSetEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		protected int doEncode(EncodeContext cxt, PValue value, int parentLength, 
		        PTypeElementMeta elementMeta, ByteOrder byteOrder) 
		throws EncodeException {
			assert value instanceof PRecordSetValue;
			PRecordSetValue rsValue = (PRecordSetValue)value;
			//全部字段
			int selfLength = 0;
			for (int i = 0; i < rsValue.getFieldSize(); i++) {
				PValue childValue = rsValue.pGetFieldByID(i);
				PFieldExt fieldMeta = childValue.pFieldMeta();
				assert childValue != null;
				assert fieldMeta != null;
				//字段前置处理
				preEncodeField(cxt, childValue, selfLength, fieldMeta, byteOrder);
				int fieldLength = 0;
				try {
					//使用字段的信息来调用字段类型的操作
					fieldLength = fieldMeta.encode(cxt, childValue, selfLength, byteOrder);	
				} finally {
					//字段后续处理
					fieldLength = postEncodeField(cxt, childValue, selfLength, fieldLength, 
							fieldMeta, byteOrder);
				}
				selfLength += fieldLength;
			}
			return selfLength;
		}
		
		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep)
				throws DumpException {
			assert value instanceof PRecordSetValue;
			PRecordSetValue rsValue = (PRecordSetValue)value;
			PContainerTypeExt containerType = 
			    (PContainerTypeExt)rsValue.pTypeMeta().getRootType();
			DumpLine line;
			int startOffset = cxt.getOffset();
			//Create Line
			line = createAndAddDumpLine(cxt, value, valueName, deep, 
			        (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			//TopType
			DumpLine orgPrtlLine = cxt.getCurrentTopType();
			if (line instanceof TopTypeDumpLine) {
				cxt.setCurrentTopType(line);
			}
			//全部字段
			int selfLength = 0;
			for (int i = 0; i < rsValue.getFieldSize(); i++) {
			    PFieldExt fieldMeta = containerType.getFieldMeta(i);
				PValue childValue = rsValue.pGetFieldByID(i);
				int fieldLength = 0;
				//使用字段的信息来调用字段类型的操作
				fieldLength = fieldMeta.dump(cxt, childValue, deep+1);
				selfLength += fieldLength;
			}
			//ValueRegion
			BitRegion valueRegion = new BitRegionImpl(startOffset, selfLength);
			line.setValueRegion(valueRegion);
			//恢复TopType
			cxt.setCurrentTopType(orgPrtlLine);
			return selfLength;
		}
		
	}
}
