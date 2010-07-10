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

import com.fineqt.fpb.lib.type.PTypeExt;

public class TypeMetaException extends MetaException {
	public final static long serialVersionUID = 0;
	
	private PTypeExt source;
	public TypeMetaException(PTypeExt source, String code, Throwable cause, Object... msgArgs) {
		super(code, cause, msgArgs);
		this.source = source;
	}

	public TypeMetaException(PTypeExt source, String code, Object... msgArgs) {
		this(source, code, null, msgArgs);
	}

	public String toString() {
		String str = super.toString();
		if (source != null) {
			str += " SourceType:" + source.getFullName();
		}
		return str;
	}
}
