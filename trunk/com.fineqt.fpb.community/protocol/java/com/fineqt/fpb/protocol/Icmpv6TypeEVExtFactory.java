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

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fineqt.fpb.lib.api.IOctetstringValue;
import com.fineqt.fpb.lib.api.IRecordSetValue;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.EncodeException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase.PFpbRecordEVExt;
import com.fineqt.fpb.lib.util.BitBuffer;
import com.fineqt.fpb.lib.util.BitBufferException;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.FpbUtils;
import com.fineqt.fpb.lib.value.PValue;

public class Icmpv6TypeEVExtFactory extends PUserTypeEVExtFactoryBase {
	
	private static final String[] MSG_TYPES = {
		"DestinationUnreachable",
		"PacketTooBig",
		"TimeExceeded",
		"ParameterProblem",
		"EchoRequest",
		"EchoReply",
		"RouterSolicitation",
		"RouterAdvertisement",
		"NeighborSolicitation",
		"NeighborAdvertisement",
		"Redirect",
		"MldQueryV2",
		"MldReportV2",
		"MldDone",
		"OtherIcmpv6Msg"
	};
	private static final Set<String> msgTypeSet = new HashSet<String>(Arrays.asList(MSG_TYPES));

	@Override
	protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta,
			PFpbTypeEV evModel) {
		String typeName = typeMeta.getName();
		if (msgTypeSet.contains(typeName)) {
			return new Icmpv6MessageTypeEVExt(evModel);
		}
		return super.createTypeEVExt4FPB(typeMeta, evModel);
	}

	private static class Icmpv6MessageTypeEVExt extends PFpbRecordEVExt {
		private final static int ICMP_CHECKSUM_FIELD_OFFSET = 2 * FpbConstants.OCTET_BITS;
		private final static int PSEUDO_HEADER_BYTES = 40;
		private final static byte ICMP_NEXT_HEADER = 58;
		public Icmpv6MessageTypeEVExt(PFpbTypeEV model) {
			super(model);
		}
		
		@Override
		public int encode(EncodeContext cxt, PValue value, int parentLength,
				PTypeConstraintStorage constraint, ByteOrder byteOrder, PFpbTypeEVAttrs priorityAttrs)
				throws EncodeException {
			if (cxt.withEncodeAction()) {
				BitBuffer buffer = cxt.getBuffer();
				//Header开始位置
				int startOffset = buffer.position();
				int result = super.encode(cxt, value, parentLength, constraint, byteOrder, 
						priorityAttrs);
				//Header结束位置
				int curPosition = cxt.getBuffer().position();
				try {
					assert startOffset % FpbConstants.OCTET_BITS == 0;
					assert curPosition % FpbConstants.OCTET_BITS == 0;
					int icmpPrtlBytes = (curPosition - startOffset) / FpbConstants.OCTET_BITS;
					byte[] pseudoBlock = new byte[PSEUDO_HEADER_BYTES + icmpPrtlBytes];
					//填充虚头部数据
					fillPseudoHeader(cxt, pseudoBlock, icmpPrtlBytes);

					//取得Icmp协议的数据并填充
					buffer.position(startOffset);
					buffer.getByte(pseudoBlock, PSEUDO_HEADER_BYTES,  icmpPrtlBytes);
					//计算Checksum
					byte[] checksum = FpbUtils.internetChecksum(pseudoBlock);
					buffer.position(startOffset + ICMP_CHECKSUM_FIELD_OFFSET);
					buffer.putByte(checksum);
				} catch (BitBufferException e) {
					throw new EncodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
				//恢复Position
				buffer.position(curPosition);
				return result;
			} else {
				return super.encode(cxt, value, parentLength, constraint, byteOrder, 
						priorityAttrs);
			}
		}
		
		private void fillPseudoHeader(EncodeContext cxt, byte[] pseudoBlock, int icmpPrtlBytes) 
		throws EncodeException {
			ByteBuffer byteBuffer = ByteBuffer.wrap(pseudoBlock);
			//取得上层IPV6协议的头部字段
			IRecordSetValue ipv6Header = (IRecordSetValue)cxt.getFieldStackMap().peekField(
					Ipv6TypeEVExtFactory.HEADER_FIELD);
			if (ipv6Header == null) {
				throw new EncodeException(targetTypeMeta, 
						MetaException.CODE.FIELD_NOT_FOUND_IN_STACK_ERROR, 
						Ipv6TypeEVExtFactory.HEADER_FIELD);
			}
			IOctetstringValue address;
			//Source Address
			address = (IOctetstringValue)ipv6Header.getField(
					Ipv6TypeEVExtFactory.IPV6_HEADER_SOURCE_ADDRESS);
			assert address != null;
			byteBuffer.put(address.getValue());
			//Destination Address
			address = (IOctetstringValue)ipv6Header.getField(
					Ipv6TypeEVExtFactory.IPV6_HEADER_DESTINATION_ADDRESS);
			assert address != null;
			byteBuffer.put(address.getValue());
			//Upper Layer Packet Length
			byteBuffer.putInt(icmpPrtlBytes);
			//3octet zero
			byteBuffer.position(byteBuffer.position() + 3);
			//Next Header
			byteBuffer.put(ICMP_NEXT_HEADER);
		}
		
	}
	
	
	
}
