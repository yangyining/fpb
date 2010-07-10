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
package com.fineqt.fpb.lib.type.impl;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.builtin.impl.PBitstringTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.PBooleanTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.PCharstringTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.PFloatTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.PHexstringTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.PIntegerTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.PObjidTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.POctetstringTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.PUCharstringTypeExtImpl;
import com.fineqt.fpb.lib.builtin.impl.PVerdictTypeExtImpl;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeEV;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeEVExtFactory;
import com.fineqt.fpb.lib.type.PTypeExt;

abstract public class PFpbTypeEVExtFactoryBase implements PTypeEVExtFactory {
	@Override
	public PTypeEVExt createTypeEVExt(PTypeExt typeMeta, PTypeEV evModel) {
		if (!(evModel instanceof PFpbTypeEV)) {
			throw new IllegalArgumentException();
		}
		return createTypeEVExt4FPB(typeMeta, (PFpbTypeEV)evModel);
	}

	@Override
	public EncodingType supportEncoding() {
		return EncodingType.FPB;
	}

	@Override
	public void postInitModule(PModuleExt module) throws InitMetaException {
	}

	@Override
	public void preInitModule(PModuleExt module) throws InitMetaException {
	}

	protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta, PFpbTypeEV evModel) {
		switch(typeMeta.getTypeClass()) {
		case ADDRESS:
			assert false;
			return null;
		case BITSTRING:
			return new PBitstringTypeExtImpl.PBitstringEVExt(evModel);
		case BOOLEAN:
			return new PBooleanTypeExtImpl.PBooleanEVExt(evModel);
		case CHARSTRING:
			return new PCharstringTypeExtImpl.PCharstringEVExt(evModel);
		case ENUMERATED:
			return new SimpleEnumeratedType.PEnumeratedEVExt(evModel);
		case FLOAT:
			return new PFloatTypeExtImpl.PFloatEVExt(evModel);
		case HEXSTRING:
			return new PHexstringTypeExtImpl.PHexstringEVExt(evModel);
		case INTEGER:
			return new PIntegerTypeExtImpl.PIntegerEVExt(evModel);
		case OBJID:
			return new PObjidTypeExtImpl.PObjidEVExt(evModel);
		case OCTETSTRING:
			return new POctetstringTypeExtImpl.POctetstringEVExt(evModel);
		case RECORD:
			return new PRecordTypeExtBase.PFpbRecordEVExt(evModel);
		case RECORDOF:
			return new PRecordOfTypeExtBase.PFpbRecordOfEVExt(evModel);
		case SET:
			return new PSetTypeExtBase.PFpbSetEVExt(evModel);
		case SETOF:
			return new PSetOfTypeExtBase.PFpbSetOfEVExt(evModel);
		case UNION:
			return new PUnionTypeExtBase.PFpbUnionEVExt(evModel);
		case UNIVERSAL_CHARSTRING:
			return new PUCharstringTypeExtImpl.PUCharstringEVExt(evModel);
		case VERDICT:
			return new PVerdictTypeExtImpl.PVerdictEVExt(evModel);
		}
		assert false;
		return null;
	}	
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("supportEncoding", supportEncoding())
			.toString();
	}
	
}
