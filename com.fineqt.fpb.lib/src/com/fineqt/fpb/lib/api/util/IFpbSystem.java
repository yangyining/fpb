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
package com.fineqt.fpb.lib.api.util;

import java.io.File;
import java.io.IOException;

import com.fineqt.fpb.lib.system.PFpbSystem;
import com.fineqt.fpb.lib.system.ScopeContext;
/**
 * FPB系统控制接口。用于FPB系统的初始化。
 * 
 * @author JiangMin
 *
 */
public interface IFpbSystem extends ScopeContext {
	IFpbSystem INSTANCE = PFpbSystem.PINSTANCE;
	
	/**
	 * 初始化FPB系统。
	 * @param fpbHomeFolderPath FPB系统的根目录,可为null。
	 * @param fpbProtocolFolderPath FPB协议定义文件目录，可为null。
	 * @throws IOException
	 */
	void init(String fpbHomeFolderPath, String fpbProtocolFolderPath) throws IOException;
	
	/**
	 * 使用默认参数初始化FPB系统。
	 * 对于FPB系统的根目录，首先使用操作系统的FPB_HOME环境变量，如果不存在的话则使用当前目录作为值。对于
	 * FPB协议定义文件目录，在为FPB系统根目录下的"protocol"目录。
	 * @throws IOException
	 */
	void init() throws IOException;
	
	/**
	 * FPB系统是否是调试模式。
	 * @return
	 */
	boolean isDebug();
	
	/**
	 * 是否将FPB系统设置为调试模式。
	 * @param debug
	 */
	void setDebug(boolean debug);
	
	/**
	 * 取得FPB系统的根目录。
	 * @return
	 */
	File getFpbHomeFolder();
	
	/**
	 * 取得FPB协议定义文件目录。
	 * @return
	 */
	File getFpbProtocolFolder();
}
