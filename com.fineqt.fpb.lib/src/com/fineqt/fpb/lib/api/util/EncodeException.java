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

import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.TypeMetaException;
import com.fineqt.fpb.lib.type.PTypeExt;

public class EncodeException extends TypeMetaException {
	public final static long serialVersionUID = 0;

	private EncodeContext encodeContext;
	
	public EncodeException(PTypeExt source, String code, Object... msgArgs) {
		super(source, code, msgArgs);
	}

	public EncodeException(PTypeExt source, String code, Throwable cause,
			Object... msgArgs) {
		super(source, code, cause, msgArgs);
	}

	public EncodeContext getEncodeContext() {
		return encodeContext;
	}

	public void setEncodeContext(EncodeContext encodeContext) {
		this.encodeContext = encodeContext;
	}

}
