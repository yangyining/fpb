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

import com.fineqt.fpb.lib.value.PValue;

public class IncompatibleValueException extends RuntimeException {
	public final static long serialVersionUID = 0;

	public IncompatibleValueException(PValue value1, PValue value2) {
		super("Type of " + (value1==null?null:value1.pTypeMeta().getFullName()) + " and " + 
				(value2==null?null:value2.pTypeMeta().getFullName()) + 
				" is not compatible or the value is omit.");
	}
}
