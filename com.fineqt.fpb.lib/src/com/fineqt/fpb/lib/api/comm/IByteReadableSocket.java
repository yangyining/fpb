/*************************************************************************
Protocol Meter, copyright (C) 2007-2008 fineqt.com

Protocol Meter is free software; you can redistribute it and/or modify it 
under the terms of version 2.1 of the GNU Lesser General Public License as 
published by the Free Software Foundation.

Protocol Meter is distributed in the hope that it will be useful, but WITHOUT 
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
License for more details at gnu.org.
**************************************************************************/
package com.fineqt.fpb.lib.api.comm;

import java.io.IOException;
/**
 * 
 * @author JiangMin
 * 以字节为数据单位的可读Socket
 */
public interface IByteReadableSocket extends ICommonSocket {
	/**
	 * 从Socket读入接收到的数据，并存入数据块中。
	 * @param b 存储数据块。
	 * @return 读入数据长度。
	 * @throws IOException IO例外
	 */
	int read(byte[] b) throws IOException;
	/**
	 * 从Socket读入接收到的数据，并存入数据块的指定范围中。
	 * @param b 存储数据块。
	 * @param off 数据块范围的开始偏移。
	 * @param len 数据块范围的长度
	 * @return 读入数据长度。
	 * @throws IOException IO例外
	 */
	int read(byte[] b, int off, int len) throws IOException;
}
