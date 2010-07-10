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
package com.fineqt.fpb.lib.meta.evattr;

import com.fineqt.fpb.lib.meta.PFpbModuleEVAttrs;
import com.fineqt.fpb.lib.meta.PFpbModuleEVExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.property.PArgumentExt;
import com.fineqt.fpb.lib.meta.property.PIdentifierArgumentExt;
import com.fineqt.fpb.lib.meta.property.PPropertyExt;
import com.fineqt.fpb.lib.meta.property.PPropertyListExt;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;

public class PFpbModuleEVAttrsImpl extends PFpbEVAttrsBase implements PFpbModuleEVAttrs {
	public static String BYTE_ORDER_NAME = "ByteOrder";

	private ByteOrder byteOrder = ByteOrder.NONE;
	private PFpbModuleEVExt ownerEV;	
	
	public PFpbModuleEVAttrsImpl(PPropertyListExt prpList, PFpbModuleEVExt ownerEV) 
	throws InitMetaException {
		this.ownerEV = ownerEV;
		//byteOrder
		if (!parseByteOrder(prpList)) {
			throw new InitMetaException(getPModule(), 
					MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(BYTE_ORDER_NAME), BYTE_ORDER_NAME, BYTE_ORDER_FORMAT);
		}
	}	

	private PModuleExt getPModule() {
		return ownerEV.getOwner();
	}
	
	private boolean parseByteOrder(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(BYTE_ORDER_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleNoValueArgument(property, PArgumentExt.Type.IDENTIFIER);
		if (tempArg == null) {
			return false;
		}
		String name = ((PIdentifierArgumentExt)tempArg).getId();
		byteOrder = ByteOrder.get(name);
		if (byteOrder == null) {
			return false;
		}
		return true;
	}

	@Override
	public ByteOrder getByteOrder() {
		return byteOrder;
	}

}
