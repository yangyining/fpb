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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fineqt.fpb.lib.api.IType;
import com.fineqt.fpb.lib.api.IValue;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.meta.context.DebugDecodeContext;

public class ProtocolUtils {
	private final static Log log = LogFactory.getLog(ProtocolUtils.class);
	
	private static IValueSerializer ser = IValueSerializer.INSTANCE;

	public static IValue decode(byte[] data, IType hypType) throws DecodeException {
		try {
			return ser.decode(data, hypType);
		} catch (DecodeException e) {
			logDecodeException(e);
			throw e;
		}
	}

	public static IValue decode(byte[] data, int offset, int len, IType hypType) 
	throws DecodeException {
		try {
			return ser.decode(data, offset, len, hypType);
		} catch (DecodeException e) {
			logDecodeException(e);
			throw e;
		}
	}

	public static IValue incrementDecode(IEnsurableBitBuffer buffer, IType hypType) 
	throws DecodeException {
        try {
            return ser.incrementDecode(buffer, hypType);
        } catch (DecodeException e) {
            logDecodeException(e);
            throw e;
        }
	}
	
    public static IValue decode(byte[] data, IType hypType, int[] resultValueLen) 
    throws DecodeException {
        try {
            return ser.decode(data, hypType, resultValueLen);
        } catch (DecodeException e) {
            logDecodeException(e);
            throw e;
        }
    }

    public static IValue decode(byte[] data, int offset, int len, IType hypType, 
            int[] resultValueLen) 
    throws DecodeException {
        try {
            return ser.decode(data, offset, len, hypType, resultValueLen);
        } catch (DecodeException e) {
            logDecodeException(e);
            throw e;
        }
    }

    public static IValue incrementDecode(IEnsurableBitBuffer buffer, IType hypType, 
            int[] resultValueLen) 
    throws DecodeException {
        try {
            return ser.incrementDecode(buffer, hypType, resultValueLen);
        } catch (DecodeException e) {
            logDecodeException(e);
            throw e;
        }
    }	
	private static void logDecodeException(DecodeException e) {
		if (IFpbSystem.INSTANCE.isDebug() && log.isDebugEnabled()) {
			DebugDecodeContext dcxt = (DebugDecodeContext)e.getDecodeContext();
			for (int i = 0; i < dcxt.getNotChainedResults().size(); i++) {
				log.debug("NotChainedResults["+i+"]:"+dcxt.getNotChainedResults().get(i));
			}
			for (int i = 0; i < dcxt.getAllResults().size(); i++) {
				log.debug("AllResults["+i+"]:"+dcxt.getAllResults().get(i));
			}
			log.debug("DebugDecodeContext:"+dcxt);
		}
	}
	
}
