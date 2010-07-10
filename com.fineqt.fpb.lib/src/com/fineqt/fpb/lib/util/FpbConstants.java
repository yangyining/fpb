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

public interface FpbConstants {
	int OCTET_BITS = 8;
	int INT_BITS = 32;
	int CHAR_BITS = 8;
	int UCHAR_BITS = 16;
	int HEX_BITS = 4;
	int BIT_BITS = 1;
	
	int INT64_BYTES = 8;
	int INT32_BYTES = 4;
	int INT16_BYTES = 2;
	int INT8_BYTES = 1;
	
	char[] CRLF_CHARS = new char[]{'\r', '\n'};
	char[] CR_CHARS = new char[]{'\r'};
	char[] LF_CHARS = new char[]{'\n'};
	char CR = '\r';
	char LF = '\n';
	byte[] CRLF_BYTES = new byte[]{0x0d, 0x0a};
    byte[] CR_BYTES = new byte[]{0x0d};
    byte[] LF_BYTES = new byte[]{0x0a};
	
	
	String PLUS_INFINITY_LITERAL = "infinity";
	String MINUS_INFINITY_LITERAL = "-infinity";
	String HEX_INT_PREFIX = "0x";
	
	String LS = System.getProperty("line.separator");
	
	String SIMPLE_PROPERTY_DELIMITER = ";";
}
