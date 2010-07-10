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
package com.fineqt.fpb.lib.builtin.impl;

import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;


public class BuiltinFactoryImpl extends AbstractBuiltinFactory {
	private static BuiltinFactoryImpl instance;
	
	private BuiltinFactoryImpl() {
	}

	synchronized public static BuiltinFactory init() {
		if (instance == null) {
			instance = new BuiltinFactoryImpl();
		}
		return instance;
	}

	@Override
	public PValue createPValue(PTypeExt type) {
		return (PValue)createBuiltin(type, ValueMode.DEFAULT);
	}

	@Override
	public PValue createPValue(int typeID) {
		return (PValue)createBuiltin(typeID, ValueMode.DEFAULT);
	}

	@Override
	public PValue createEmptyPValue(int typeID) {
		return (PValue)createBuiltin(typeID, ValueMode.EMPTY);
	}

	@Override
	public PValue createEmptyPValue(PTypeExt type) {
		return (PValue)createBuiltin(type, ValueMode.EMPTY);
	}

	@Override
	public PValue createOmitPValue(int typeID) {
		return (PValue)createBuiltin(typeID, ValueMode.OMIT);
	}

	@Override
	public PValue createOmitPValue(PTypeExt type) {
		return (PValue)createBuiltin(type, ValueMode.OMIT);
	}

}
