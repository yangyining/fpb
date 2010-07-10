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

import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.util.TextBitset;

public interface FlagFieldWriter {
	long getFlagValue();
	long getOffset();
	void writeInteger(long value, int length) throws BitBufferException;
	void writeBoolean(boolean value) throws BitBufferException;
	void writeBits(TextBitset bits) throws BitBufferException;
	boolean isFinished();
}
