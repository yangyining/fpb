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

import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.codec.FlagFieldWriter;
import com.fineqt.fpb.lib.util.buffer.SimpleBitBuffer;
import com.fineqt.fpb.lib.value.PValue;

public class EncodeContextImpl extends AbstractCommonContext implements EncodeContext {
	private IReadWritableBitBuffer buffer;
	private PValue packet;
	private FlagFieldWriter flagFieldWriter;
	private int actionFlag;
	
	public EncodeContextImpl() {
		buffer = new SimpleBitBuffer(SimpleBitBuffer.DEFAULT_INIT_CAPACITY, true);
	}
	
	@Override
	public PValue getPacket() {
		return packet;
	}

	@Override
	public void setPacket(PValue value) {
		packet = value;
	}

	@Override
	public IReadWritableBitBuffer getBuffer() {
		return buffer;
	}

	@Override
	public FlagFieldWriter getFlagFieldWriter() {
		return flagFieldWriter;
	}

	@Override
	public void setFlagFieldWriter(FlagFieldWriter writer) {
		flagFieldWriter = writer;
	}

	@Override
	public boolean withCalculateAction() {
		return (actionFlag & CALCULATE_ACTION) != 0;
	}

	@Override
	public boolean withEncodeAction() {
		return (actionFlag & ENCODE_ACTION) != 0;
	}

	@Override
	public boolean withGetSizeAction() {
		return (actionFlag & GET_SIZE_ACTION) != 0;
	}

	@Override
	public void passivate() {
		buffer.clear();
		packet = null;
		flagFieldWriter = null;
		actionFlag = 0;
		super.passivate();
	}

	public int getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(int actionFlag) {
		this.actionFlag = actionFlag;
	}
	
}
