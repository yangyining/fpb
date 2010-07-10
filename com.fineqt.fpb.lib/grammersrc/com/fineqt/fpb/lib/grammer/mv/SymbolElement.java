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
package com.fineqt.fpb.lib.grammer.mv;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;

abstract public class SymbolElement {
	protected static FpbmoduleFactory mfactory = FpbmoduleFactory.eINSTANCE;
	protected final static String LN = System.getProperty("line.separator");
	protected final static String TAB = "  ";
	
	private Token startToken;
	private boolean inited;
	
	public Token getStartToken() {
		return startToken;
	}

	public void setStartToken(Token startToken) {
		this.startToken = startToken;
	}
	
	public String getStartPosition() {
		return getStartPosition(startToken);
	}
	
	public static String getStartPosition(Token token) {
		if (token == null) {
			return "0:0";
		} else {
			return token.getLine() + ":" + token.getCharPositionInLine();
		}
	}
	
	public static String getStartPosition(TokenStream input) {
		return getStartPosition(input.LT(1));
	}
	
	public void initModel(ParserHelper cxt) {
		if (!inited) {
			inited = true;
			doInitModel(cxt);
		}
	}
	
//	abstract protected void doInitModel(SymbolInitContext cxt, SymbolElement parent);
	protected void doInitModel(ParserHelper cxt) {
		
	}
}
