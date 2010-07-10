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
 * 以字节为数据单位的可些Socket
 */
public interface IByteWritableSocket extends ICommonSocket {
	/**
	 * 将数据块中的所有数据写入Socket中。
	 * @param b 数据块
	 * @throws IOException IO列外
	 */
	void write(byte[] b) throws IOException;
	/**
	 * 将数据块中指定范围的数据写入Socket中。
	 * @param b 数据块
	 * @param off 指定范围的偏移量
	 * @param len 指定范围的长度
	 * @throws IOException IO列外
	 */
	void write(byte[] b, int off, int len) throws IOException;
}
