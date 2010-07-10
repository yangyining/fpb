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
package com.fineqt.fpb.lib.meta.util;

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IWritableBitBuffer;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.context.ContextPool;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.buffer.SimpleBitBuffer;
import com.fineqt.fpb.lib.value.PValue;

public class PValueSerializerImpl implements PValueSerializer {
	
	@Override
	public int calculate(PValue value) throws EncodeException {
		EncodeContext cxt = ContextPool.INSTANCE.borrowEncodeContext();
		cxt.setPacket(value);
		cxt.setActionFlag(EncodeContext.GET_SIZE_ACTION | EncodeContext.CALCULATE_ACTION);
		PTypeExt typeMeta = value.pTypeMeta();
		try {
		    //执行计算
			int result = typeMeta.getRootType().encode(cxt, value, 0, 
			        typeMeta, null);
	        //回收Context对象
			ContextPool.INSTANCE.returnEncodeContext(cxt);
			return result;
		} catch (EncodeException e) {
			e.setEncodeContext(cxt);
			throw e;
		}
	}

	@Override
	public PValue decode(byte[] data, PTypeExt hypType) throws DecodeException {
		return decode(data, 0, data.length, hypType, null);
	}

	@Override
	public PValue decode(byte[] data, int offset, int len, PTypeExt hypType)
			throws DecodeException {
	    return decode(data, offset, len, hypType, null);
	}

	
    @Override
    public PValue decode(byte[] data, int offset, int len, PTypeExt hypType,
            int[] resultValueLen) throws DecodeException {
        IReadWritableBitBuffer buffer = new SimpleBitBuffer(data);
        return doDecode(offset * FpbConstants.OCTET_BITS, len * FpbConstants.OCTET_BITS, 
                hypType, buffer, resultValueLen);
    }

    @Override
    public PValue decode(byte[] data, PTypeExt hypType, int[] resultValueLen)
            throws DecodeException {
        return decode(data, 0, data.length, hypType, resultValueLen);
    }

    @Override
    public PValue incrementDecode(IEnsurableBitBuffer buffer, PTypeExt hypType)
            throws DecodeException {
        return incrementDecode(buffer, hypType, null);
    }
	
    @Override
    public PValue incrementDecode(IEnsurableBitBuffer buffer, PTypeExt hypType,
            int[] resultValueLen) throws DecodeException {
        return doDecode(0, IBitBuffer.GET_LEN_BY_SUPER_POSITION, 
                hypType, buffer, resultValueLen);
    }

    private PValue doDecode(int topSubBufferOffset, int topSubBufferLen, PTypeExt hypType,
            IWritableBitBuffer buffer, int[] resultValueLen) throws DecodeException {
        ContextPool factory = ContextPool.INSTANCE;
		//取得上下文对象
		DecodeContext cxt = factory.borrowDecodeContext();
		cxt.setOrgInput(buffer);
		cxt.setHypType(hypType);
		DecodeResult result;
		try {
			//设置参数
			DecodeParameters paras = cxt.createDecodeParas(null, null);
			//解码
	        IReadableBitBuffer topInput = buffer.subBitBuffer(topSubBufferOffset, 
	                topSubBufferLen);
			result = hypType.getRootType().decode(cxt, topInput, hypType, paras);
			//设置长度
			if (result != null && resultValueLen != null) {
			    resultValueLen[0] = result.getValueLength();
			}
			//回收参数对象
			cxt.returnDecodeParas(paras);
		} catch (DecodeException e) {
			e.setDecodeContext(cxt);
			throw e;
		}
		//回收上下文对象
		factory.returnDecodeContext(cxt);
		//返回解码结果
		if (result != null)
			return result.getValue();
		return null;
    }

	@Override
	public byte[] encode(PValue value, boolean doCalculating) throws EncodeException {
		EncodeContext cxt = ContextPool.INSTANCE.borrowEncodeContext();
		int actionFlag = EncodeContext.GET_SIZE_ACTION | EncodeContext.ENCODE_ACTION;
		if (doCalculating) {
			actionFlag |= EncodeContext.CALCULATE_ACTION;
		}
		cxt.setActionFlag(actionFlag);
		cxt.setPacket(value);
		PTypeExt typeMeta = value.pTypeMeta();
		try {
            //编码
			typeMeta.getRootType().encode(cxt, value, 0, typeMeta, null);
		} catch (EncodeException e1) {
			e1.setEncodeContext(cxt);
			throw e1;
		}
		//复制数据
		IReadWritableBitBuffer buffer = cxt.getBuffer();
		buffer.flip();
		assert buffer.limit() % FpbConstants.OCTET_BITS == 0;
		byte[] data = new byte[buffer.limit() / FpbConstants.OCTET_BITS];
		try {
			buffer.getByte(data);
		} catch (BitBufferException e) {
			throw new EncodeException(null, MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
		}
		//回收Context对象
	    ContextPool.INSTANCE.returnEncodeContext(cxt);
		return data;
	}

    @Override
	public int getSize(PValue value) throws EncodeException {
		EncodeContext cxt = ContextPool.INSTANCE.borrowEncodeContext();
		cxt.setPacket(value);
		cxt.setActionFlag(EncodeContext.GET_SIZE_ACTION);
		PTypeExt typeMeta = value.pTypeMeta();
		try {
            //调用编码方法（只做Get Size操作）
			int result = typeMeta.getRootType().encode(cxt, value, 0, typeMeta, null);
			//回收Context
			ContextPool.INSTANCE.returnEncodeContext(cxt);
			return result;
		} catch (EncodeException e) {
			e.setEncodeContext(cxt);
			throw e;
		}
	}

	@Override
	public int calculate(IValue value) throws EncodeException {
		return calculate((PValue)value);
	}

	@Override
	public IValue decode(byte[] data, int offset, int len, IType hypType)
			throws DecodeException {
		return decode(data, offset, len, (PTypeExt)hypType);
	}

	@Override
	public IValue decode(byte[] data, IType hypType) throws DecodeException {
		return decode(data, (PTypeExt)hypType);
	}

	@Override
    public IValue incrementDecode(IEnsurableBitBuffer buffer, IType hypType)
            throws DecodeException {
        return incrementDecode(buffer, (PTypeExt)hypType);
    }

	@Override
    public IValue decode(byte[] data, int offset, int len, IType hypType,
            int[] resultValueLen) throws DecodeException {
        return decode(data, offset, len, (PTypeExt)hypType, resultValueLen);
    }

    @Override
    public IValue decode(byte[] data, IType hypType, int[] resultValueLen)
            throws DecodeException {
        return decode(data, (PTypeExt)hypType, resultValueLen);
    }

    @Override
    public IValue incrementDecode(IEnsurableBitBuffer buffer, IType hypType,
            int[] resultValueLen) throws DecodeException {
        return incrementDecode(buffer, (PTypeExt)hypType, resultValueLen);
    }

    @Override
	public byte[] encode(IValue value, boolean doCalculating)
			throws EncodeException {
		return encode((PValue)value, doCalculating);
	}

	@Override
	public int getSize(IValue value) throws EncodeException {
		return getSize((PValue)value);
	}

}
