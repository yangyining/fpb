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
package com.fineqt.fpb.lib.codec;

import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;

public class SimpleDeocdeParameters implements DecodeParameters {
	protected DecodeResult parentResult;	
	protected ByteOrder byteOrder;
	protected int hypFixedLength = -1;
    
	public SimpleDeocdeParameters(){
	}
	
	public SimpleDeocdeParameters(DecodeResult parentResult,
			ByteOrder byteOrder) {
		this.parentResult = parentResult;
		this.byteOrder = byteOrder;
	}

	@Override
	public ByteOrder getByteOrder() {
		return byteOrder;
	}

	@Override
	public void setByteOrder(ByteOrder byteOrder) {
		this.byteOrder = byteOrder;
	}

	@Override
	public DecodeResult getParentResult() {
		return parentResult;
	}

	@Override
	public void setParentResult(DecodeResult result) {
		parentResult = result;
	}

	@Override
    public int getHypFixedLength() {
        return hypFixedLength;
    }

    @Override
    public void setHypFixedLength(int fixedLength) {
        hypFixedLength = fixedLength;        
    }



    @Override
	public void passivate() {
		parentResult = null;
		byteOrder = null;
		hypFixedLength = -1;
	}

}
