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
package com.fineqt.fpb.lib.builtin;

import com.fineqt.fpb.lib.builtin.impl.BuiltinModuleImpl;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.type.PTypeExt;

public interface BuiltinModule {
	PModuleExt BUILTIN_INSTANCE = BuiltinModuleImpl.init();
	String BUILTIN_MODULE_NAME = "builtin";
	//PInteger类型ID
	int PINTEGER = 1;
	//PFloat
	int PFLOAT = 2;
	//PObjid
	int POBJID = 3;
	//PBoolean
	int PBOOLEAN = 4;
	//PCharstring
	int PCHARSTRING = 5;
	//PUniversalCharstring
	int PUCHARSTRING = 6;
	//PBitstring
	int PBITSTRING = 7;
	//PHexstring
	int PHEXSTRING = 8;
	//POctetstring
	int POCTETSTRING = 9;
	//PVerdict
	int PVERDICT = 10;
	//PAddress
	int PADDRESS = 11;
	
	interface BuiltinNames {
		String PINTEGER = "integer";
		String PFLOAT = "float";
		String POBJID = "objid";
		String PBOOLEAN = "boolean";
		String PCHARSTRING = "charstring";
		String PUCHARSTRING = "universal_charstring";
		String PBITSTRING = "bitstring";
		String PHEXSTRING = "hexstring";
		String POCTETSTRING = "octetstring";
		String PVERDICT = "verdict";
		String PADDRESS = "address";
	}
	//取得PInteger类型定义对象
	PTypeExt getInteger();
	
	PTypeExt getFloat();
	
	PTypeExt getObjid();
	
	PTypeExt getBoolean();
	
	PTypeExt getBitstring();
	
	PTypeExt getHexstring();
	
	PTypeExt getOctetstring();
	
	PTypeExt getCharstring();
	
	PTypeExt getUniversalCharstring();
	
	PTypeExt getVerdict();
	
	int MAX_BUILTIN_TYPE = 100;
}
