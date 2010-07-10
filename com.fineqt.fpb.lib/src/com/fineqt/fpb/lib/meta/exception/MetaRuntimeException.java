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
package com.fineqt.fpb.lib.meta.exception;

import java.text.MessageFormat;
import java.util.Map;

import com.fineqt.fpb.lib.meta.PModuleExt;

public class MetaRuntimeException extends RuntimeException {
	public final static long serialVersionUID = 0;

	private static Map<String, String> code2msgMap = MetaException.code2msgMap;
	
	public interface CODE extends MetaException.CODE {
	}
	
	private String code;
	
	public MetaRuntimeException(PModuleExt module, String code, Throwable cause, Object... msgArgs) {
		super(createMessage(module, code, msgArgs), cause);
		this.code = code;
	}
	
	public MetaRuntimeException(String code, Throwable cause, Object... msgArgs) {
		super(createMessage(null, code, msgArgs), cause);
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	static String createMessage(PModuleExt module, String code, Object... msgArgs) {
		String msg = "";
		if (module != null) {
			msg = "["+module.getModuleName()+"]";
		} else {
			msg = "[?]";
		}
		msg += code + ";" + MessageFormat.format(code2msgMap.get(code), msgArgs);
		return msg;
	}
}
