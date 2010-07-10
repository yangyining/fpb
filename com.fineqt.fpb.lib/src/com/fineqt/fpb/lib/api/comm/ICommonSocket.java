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
import java.net.SocketException;

/**
 * 
 * @author JiangMin
 * 共同Socket接口。
 */
public interface ICommonSocket {
	/**
	 * 默认超时时间1000毫秒。
	 */
	int DEFAULT_TIMEOUT = 1000;
	/**
	 * 打开Socket
	 * @throws IOException
	 */
	void open() throws IOException;
	/**
	 * 关闭Socket
	 * @throws IOException
	 */
	void close() throws IOException;
	/**
	 * 设定输入输出操作的超时时间。必须在open方法执行前设置。
	 * @param milliSec 超时时间。1/1000秒单位。
	 * @throws SocketException
	 */
	void setTimeout(int milliSec) throws SocketException;
	/**
	 * 取的输入输出操作的超时时间。
	 * @return 超时时间。1/1000秒单位。
	 * @throws SocketException
	 */
	int getTimeout() throws SocketException;
}
