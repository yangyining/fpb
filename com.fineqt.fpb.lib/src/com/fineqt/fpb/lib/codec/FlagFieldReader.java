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

import com.fineqt.fpb.lib.util.TextBitset;

public interface FlagFieldReader {
	long getFlagValue();
	long getOffset();
	long readInteger(boolean signed, int length);
	boolean readBoolean();
	TextBitset readBits(int length);
	/**
	 * 是否Flag所有的比特都已经读完。
	 * @return
	 */
	boolean isFinished();
}
