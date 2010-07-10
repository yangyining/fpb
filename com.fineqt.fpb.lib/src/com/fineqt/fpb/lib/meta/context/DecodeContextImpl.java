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
package com.fineqt.fpb.lib.meta.context;

import java.util.ArrayDeque;
import java.util.Queue;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IWritableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.codec.FlagFieldReader;
import com.fineqt.fpb.lib.codec.SimpleDeocdeParameters;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.type.PTypeExt;

public class DecodeContextImpl extends AbstractCommonContext implements DecodeContext {
	private PTypeExt hypType;
	private IWritableBitBuffer orgInput;
	private FlagFieldReader flagFieldReader;
	private Queue<DecodeParameters> parasQueue = new ArrayDeque<DecodeParameters>();
	
	
	@Override
	public PTypeExt getHypType() {
		return hypType;
	}

	@Override
	public IWritableBitBuffer getOrgInput() {
		return orgInput;
	}

	@Override
	public void setOrgInput(IWritableBitBuffer buf) {
		orgInput = buf;
	}

	@Override
	public void setHypType(PTypeExt hypeType) {
		this.hypType = hypeType;
	}

	@Override
	public FlagFieldReader getFlagFieldReader() {
		return flagFieldReader;
	}

	@Override
	public void setFlagFieldReader(FlagFieldReader reader) {
		flagFieldReader = reader;
	}


	@Override
    public boolean isIncrement() {
        return orgInput instanceof IEnsurableBitBuffer;
    }

    @Override
    public DecodeParameters createDecodeParas( 
			DecodeResult parentResult, 
			ByteOrder byteOrder) {
		DecodeParameters paras = parasQueue.poll();
		if (paras == null) {
			paras = new SimpleDeocdeParameters(parentResult, byteOrder);
		} else {
			paras.setParentResult(parentResult);
			paras.setByteOrder(byteOrder);
		}
		return paras;
	}
	
	@Override
	public void returnDecodeParas(DecodeParameters paras) {
		//忽略paras的passivate方法
	    paras.passivate();
		parasQueue.add(paras);
	}

	@Override
	public void passivate() {
		hypType = null;
		orgInput = null;
		flagFieldReader = null;
		super.passivate();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.appendSuper(super.toString())
		.append("hypType", hypType.getName())
//		.append("orgSubInput", orgSubInput)
		.append("flagFieldReader", flagFieldReader)
		.toString();
	}
	
}
