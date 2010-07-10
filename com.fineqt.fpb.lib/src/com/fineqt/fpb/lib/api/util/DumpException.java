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

import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.exception.TypeMetaException;
import com.fineqt.fpb.lib.type.PTypeExt;

public class DumpException extends TypeMetaException {
	public final static long serialVersionUID = 0;
	private DumpContext dumpContext;
	
	public DumpException(PTypeExt source, String code, Object... msgArgs) {
		super(source, code, msgArgs);
	}

	public DumpException(PTypeExt source, String code, Throwable cause,
			Object... msgArgs) {
		super(source, code, cause, msgArgs);
	}

	public DumpContext getDumpContext() {
		return dumpContext;
	}

	public void setDumpContext(DumpContext dumpContext) {
		this.dumpContext = dumpContext;
	}
	
}
