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

import java.security.InvalidParameterException;

import com.fineqt.fpb.lib.api.value.IBitstringValue;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.api.value.IFloatValue;
import com.fineqt.fpb.lib.api.value.IHexstringValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IObjidValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IUCharstringValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.api.value.IVerdictValue;
import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.meta.impl.PFactoryExtBase;
import com.fineqt.fpb.lib.type.PTypeExt;

abstract public class AbstractBuiltinFactory extends PFactoryExtBase implements BuiltinFactory {

	@Override
	public IIntegerValue createInteger() {
		return doCreateInteger(ValueMode.DEFAULT);
	}

	public IIntegerValue doCreateInteger(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IIntegerValue)createObjByMode(mode, module.getInteger());
	}
	
	@Override
	public IBitstringValue createBitstring() {
		return doCreateBitstring(ValueMode.DEFAULT);
	}

	public IBitstringValue doCreateBitstring(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IBitstringValue)createObjByMode(mode, module.getBitstring());
	}

	@Override
	public IBooleanValue createBoolean() {
		return doCreateBoolean(ValueMode.DEFAULT);
	}

	public IBooleanValue doCreateBoolean(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IBooleanValue)createObjByMode(mode, module.getBoolean());
	}

	@Override
	public ICharstringValue createCharstring() {
		return doCreateCharstring(ValueMode.DEFAULT);
	}

	public ICharstringValue doCreateCharstring(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (ICharstringValue)createObjByMode(mode, module.getCharstring());
	}
	
	@Override
	public IFloatValue createFloat() {
		return doCreateFloat(ValueMode.DEFAULT);
	}

	public IFloatValue doCreateFloat(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IFloatValue)createObjByMode(mode, module.getFloat());
	}

	@Override
	public IHexstringValue createHexstring() {
		return doCreateHexstring(ValueMode.DEFAULT);
	}

	public IHexstringValue doCreateHexstring(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IHexstringValue)createObjByMode(mode, module.getHexstring());
	}

	@Override
	public IObjidValue createObjid() {
		return doCreateObjid(ValueMode.DEFAULT);
	}

	public IObjidValue doCreateObjid(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IObjidValue)createObjByMode(mode, module.getObjid());
	}

	@Override
	public IOctetstringValue createOctetstring() {
		return doCreateOctetstring(ValueMode.DEFAULT);
	}

	public IOctetstringValue doCreateOctetstring(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IOctetstringValue)createObjByMode(mode, module.getOctetstring());
	}

	@Override
	public IUCharstringValue createUCharstring() {
		return doCreateUCharstring(ValueMode.DEFAULT);
	}

	public IUCharstringValue doCreateUCharstring(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IUCharstringValue)createObjByMode(mode, module.getUniversalCharstring());
	}

	@Override
	public IVerdictValue createVerdict() {
		return doCreateVerdict(ValueMode.DEFAULT);
	}

	public IVerdictValue doCreateVerdict(ValueMode mode) {
		BuiltinModule module = (BuiltinModule)pmodule;
		return (IVerdictValue)createObjByMode(mode, module.getVerdict());
	}

	protected IValue createBuiltin(PTypeExt type, ValueMode mode) {
		if (type.getPModule() != getPModule()) {
			throw new InvalidParameterException("Different module");
		}
		return createBuiltin(type.getID(), mode);
	}
	
	protected IValue createBuiltin(int typeID, ValueMode mode) {
		switch(typeID) {
		case BuiltinModule.PINTEGER:
			return doCreateInteger(mode);
		case BuiltinModule.PFLOAT:
			return doCreateFloat(mode);
		case BuiltinModule.PBOOLEAN:
			return doCreateBoolean(mode);
		case BuiltinModule.POBJID:
			return doCreateObjid(mode);
		case BuiltinModule.PCHARSTRING:
			return doCreateCharstring(mode);
		case BuiltinModule.PUCHARSTRING:
			return doCreateUCharstring(mode);
		case BuiltinModule.PBITSTRING:
			return doCreateBitstring(mode);
		case BuiltinModule.PHEXSTRING:
			return doCreateHexstring(mode);
		case BuiltinModule.POCTETSTRING:
			return doCreateOctetstring(mode);
		case BuiltinModule.PVERDICT:
			return doCreateVerdict(mode);
		}
		return null;
	}	
}
