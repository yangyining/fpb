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

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.dump.DumpLine;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PPrimitiveType;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PadType;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PPrimitiveTypeExt;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.BitRegionImpl;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PPrimitiveTypeExtBase extends PEntityTypeExtBase 
implements PPrimitiveTypeExt {

	public PPrimitiveTypeExtBase(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		assert pmodel instanceof PPrimitiveType;
	}

	@Override
	public boolean isPrimitiveType() {
		return true;
	}
	
	@Override
	public int getFieldSize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IType getFieldType(int fieldIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IType getFieldType(String fieldName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IType getItemType() {
		throw new UnsupportedOperationException();
	}

	public abstract static class PFpbPrimitiveEVExt extends PFpbEntityEVExt {
		private static int OCTET_BITS = 8;

		public PFpbPrimitiveEVExt(PFpbTypeEV model) {
			super(model);
		}

		protected DumpLine dumpPrimitive(DumpContext cxt, PValue value, String valueName,
				PTypeConstraintStorage constraint, int deep, int valueBits, PFpbTypeEVAttrs priorityAttrs) {
			DumpLine line;
			//Create Line
			line = createAndAddDumpLine(cxt, value, valueName, deep, priorityAttrs);
			//ValueRegion
			BitRegion valueRegion = new BitRegionImpl(cxt.getOffset(), valueBits);
			line.setValueRegion(valueRegion);
			//Move Offset
			cxt.incOffset(valueBits);
			return line;
		}
		
		/**
		 * 
		 * @param parentLength
		 * @return 没有PadType设置则为-1
		 */
		protected int getLengthFromPadType(int parentLength, PadType padType) {
			//padSize
			int padSize = 0;
			switch(padType) {
			case OCTET:
				padSize = OCTET_BITS;
				break;
			case OCTET2:
				padSize = 2 * OCTET_BITS;
				break;
			case OCTET4:
				padSize = 4 * OCTET_BITS;
				break;
			case OCTET8:
				padSize = 8 * OCTET_BITS;
				break;
			}
			int resultLength = -1;
			if (padSize > 0) {
				int modValue = parentLength % padSize;
				if (modValue > 0) {
					resultLength = padSize - modValue;
				} else {
					resultLength = 0;
				}
			}
			
			return resultLength;
		}
		
	}
}
