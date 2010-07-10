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
package com.fineqt.fpb.lib.util;

import java.util.ArrayList;
import java.util.List;

public class ParserException extends Exception {
	public final static long serialVersionUID = 0;

	private List<String> grammerErrorMsgs;
	
	public ParserException() {
		super();
	}

	public ParserException(Throwable cause) {
		super(cause);
	}

	public ParserException(List<String> grammerErrorMsgs) {
		this.grammerErrorMsgs = grammerErrorMsgs;
	}
	
	public ParserException(Throwable cause, List<String> grammerErrorMsgs) {
		super(cause);
		this.grammerErrorMsgs = grammerErrorMsgs;
	}
	
	public List<String> getGrammerErrorMsgs() {
		if (grammerErrorMsgs == null)
			grammerErrorMsgs = new ArrayList<String>();
		return grammerErrorMsgs;
	}

	@Override
	public String getMessage() {
		String msg = super.getMessage();
		if (msg == null) {
			msg = FpbConstants.LS;
		} else {
			msg += FpbConstants.LS;
		}
		if (grammerErrorMsgs != null) {
			for (String msgline : grammerErrorMsgs) {
				msg += msgline + FpbConstants.LS;
			}
		}
		return msg;
	}

	
}
