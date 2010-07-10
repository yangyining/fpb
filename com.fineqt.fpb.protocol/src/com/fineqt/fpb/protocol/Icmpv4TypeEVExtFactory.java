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
package com.fineqt.fpb.protocol;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase.PFpbRecordEVExt;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.FpbUtils;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class Icmpv4TypeEVExtFactory extends PUserTypeEVExtFactoryBase {
	private static final String[] MSG_TYPES = {
		"EchoRequest",
		"EchoReply",
		"InformationRequest",
		"InformationReply",
		"TimestampRequest",
		"TimestampReply",
		"MaskRequest",
		"MaskReply",
		"RouterAdvertisement",
		"RouterSolicitation",
		"Unknown",
		"DestinationUnreachable",
		"Redirect",
		"SourceQuench",
		"TimeExceeded",
		"ParameterProblem"
	};
	private static final Set<String> msgTypeSet = new HashSet<String>(Arrays.asList(MSG_TYPES));
	
	@Override
	protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta,
			PFpbTypeEV evModel) {
		String typeName = typeMeta.getName();
		if (msgTypeSet.contains(typeName)) {
			return new Icmpv4MessageTypeEVExt(evModel);
		}
		return super.createTypeEVExt4FPB(typeMeta, evModel);
	}
	
	private static class Icmpv4MessageTypeEVExt extends PFpbRecordEVExt {
		final static int CHECKSUM_FIELD_OFFSET = 2 * FpbConstants.OCTET_BITS;

		public Icmpv4MessageTypeEVExt(PFpbTypeEV model) {
			super(model);
		}
		
		@Override
		public int encode(EncodeContext cxt, PValue value, int parentLength,
		        PTypeElementMeta elementMeta, ByteOrder byteOrder)
				throws EncodeException {
			if (cxt.withEncodeAction()) {
				IReadWritableBitBuffer buffer = cxt.getBuffer();
				//Header开始位置
				int startOffset = buffer.position();
				int result = super.encode(cxt, value, parentLength, elementMeta, byteOrder);
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
					byte[] checksum = FpbUtils.internetChecksum(headerData);
					buffer.position(startOffset + CHECKSUM_FIELD_OFFSET);
					buffer.putByte(checksum);
				} catch (BitBufferException e) {
					throw new EncodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
				//回复Position
				buffer.position(curPosition);
				return result;
			} else {
				return super.encode(cxt, value, parentLength, elementMeta, byteOrder);
			}
		}
		
	}

}
