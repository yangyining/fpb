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
package com.fineqt.fpb.lib.api.util.buffer;

import com.fineqt.fpb.lib.util.buffer.BitBufferFactoryImpl;

public interface IBitBufferFactory {
    /**
     * 全局实例
     */
    IBitBufferFactory INSTANCE = new BitBufferFactoryImpl();
    /**
     * 创建已有数据长度可确认的缓存。被创建的缓存对象支持非同步操作。
     * @return
     */
    IEnsurableBitBuffer createEnsurableBuffer();
    /**
     * 创建一般可读写缓存。被创建的缓存对象不支持非同步操作。
     * @return
     */
    IReadWritableBitBuffer createNormalBuffer();
}
