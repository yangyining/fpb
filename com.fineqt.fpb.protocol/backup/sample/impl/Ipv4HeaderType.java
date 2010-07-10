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

import com.fineqt.common.Util;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.EncodeException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase;
import com.fineqt.fpb.lib.util.BitBuffer;
import com.fineqt.fpb.lib.util.BitBufferException;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.value.PValue;

public class Ipv4HeaderType extends PRecordTypeExtBase {

	public Ipv4HeaderType(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		return (PValue)Ipv4HeaderImpl.createValue(this, false);
	}

	@Override
	public PValue createOmitValue() {
		return (PValue)Ipv4HeaderImpl.createValue(this, true);
	}

	@Override
	public PValue createEmptyValue() {
		return (PValue)Ipv4HeaderImpl.createEmptyValue(this);
	}

	public static class PTypeEVExt4Fpb extends PFpbRecordEVExt {
		final static int CHECKSUM_FIELD_OFFSET = 10 * FpbConstants.OCTET_BITS;
		
		public PTypeEVExt4Fpb(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public int encode(EncodeContext cxt, PValue value, int parentLength,
				PTypeConstraintStorage constraint, ByteOrder byteOrder, PFpbTypeEVAttrs priorityAttrs)
				throws EncodeException {
			BitBuffer buffer = cxt.getBuffer();
			//Header开始位置
			int startOffset = buffer.position();
			int result = super.encode(cxt, value, parentLength, constraint, byteOrder, 
					priorityAttrs);
			//Header结束位置
			int curPosition = cxt.getBuffer().position();
			try {
				//取得Header数据
				assert startOffset % FpbConstants.OCTET_BITS == 0;
				assert curPosition % FpbConstants.OCTET_BITS == 0;
				int byteLen = (curPosition - startOffset) / FpbConstants.OCTET_BITS;
				byte[] headerData = new byte[byteLen];
				buffer.position(startOffset);
				buffer.getByte(headerData);
				//计算Checksum
				byte[] checksum = Util.internetChecksum(headerData);
				buffer.position(startOffset + CHECKSUM_FIELD_OFFSET);
				buffer.putByte(checksum);
			} catch (BitBufferException e) {
				throw new EncodeException(targetTypeMeta, 
						MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
			}
			//回复Position
			buffer.position(curPosition);
			return result;
		}
		
	}
}
