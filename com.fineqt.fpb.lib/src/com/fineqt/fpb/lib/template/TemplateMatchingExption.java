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
package com.fineqt.fpb.lib.template;

import com.fineqt.fpb.lib.meta.exception.MetaException;

public class TemplateMatchingExption extends MetaException {
	public final static long serialVersionUID = 0;

	public TemplateMatchingExption(String code, Throwable cause,
			Object... msgArgs) {
		super(code, cause, msgArgs);
	}

	public TemplateMatchingExption(String code, Object... msgArgs) {
		super(code, null, msgArgs);
	}
}
