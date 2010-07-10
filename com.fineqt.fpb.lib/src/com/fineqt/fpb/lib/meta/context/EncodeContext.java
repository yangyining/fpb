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
import com.fineqt.fpb.lib.value.PValue;

public interface EncodeContext extends CommonContext {
	int GET_SIZE_ACTION = 1;
	int CALCULATE_ACTION = 2;
	int ENCODE_ACTION = 4;

	IReadWritableBitBuffer getBuffer();
	PValue getPacket();
	void setPacket(PValue value);
	FlagFieldWriter getFlagFieldWriter();
	void setFlagFieldWriter(FlagFieldWriter writer);
	boolean withGetSizeAction();
	boolean withCalculateAction();
	boolean withEncodeAction();
	int getActionFlag();
	void setActionFlag(int flag);
}
