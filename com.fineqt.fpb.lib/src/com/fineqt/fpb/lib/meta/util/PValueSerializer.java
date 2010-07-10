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

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public interface PValueSerializer extends IValueSerializer {
	PValueSerializer PINSTANCE = new PValueSerializerImpl();
	
	byte[] encode(PValue value, boolean doCalculating) throws EncodeException;
	
	PValue decode(byte[] data, PTypeExt hypType) throws DecodeException;

	PValue decode(byte[] data, int offset, int len, PTypeExt hypType) throws DecodeException;
	
	PValue incrementDecode(IEnsurableBitBuffer buffer, PTypeExt hypType) throws DecodeException;
	
    PValue decode(byte[] data, PTypeExt hypType, int[] resultValueLen) throws DecodeException;

    PValue decode(byte[] data, int offset, int len, PTypeExt hypType, int[] resultValueLen)
    throws DecodeException;
    
    PValue incrementDecode(IEnsurableBitBuffer buffer, PTypeExt hypType, int[] resultValueLen)
    throws DecodeException;

    int calculate(PValue value) throws EncodeException;
	
	int getSize(PValue value) throws EncodeException;
	
}
