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
package com.fineqt.fpb.lib.builtin.impl;

import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.builtin.PVerdictValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PVerdict;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.impl.PPrimitiveTypeExtBase;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

/**
 * TODO 未实现
 * @author JiangMin
 *
 */
public class PVerdictTypeExtImpl extends PPrimitiveTypeExtBase {

	public PVerdictTypeExtImpl(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		assert pmodel instanceof PVerdict;
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		PVerdictValue result = (PVerdictValue)super.createNormalValue(paras);
		if (paras.getInitValue() != null) {
			result.assignPValue(paras.getInitValue());
		}
		return result;
	}

	public static class PVerdictEVExt extends PFpbPrimitiveEVExt {
		
		public PVerdictEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			throw new UnsupportedOperationException();
		}

		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep)
				throws DumpException {
			assert value instanceof PVerdictValue;
			//dump（忽略长度）
			dumpPrimitive(cxt, value, valueName, elementMeta.getConstraints(), deep, 0, 
			        (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			return 0;
		}
		
	}	
	
}
