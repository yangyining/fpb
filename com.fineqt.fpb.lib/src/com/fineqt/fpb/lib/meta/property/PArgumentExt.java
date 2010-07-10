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
package com.fineqt.fpb.lib.meta.property;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PBooleanArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PCharstringArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PConditionArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PIdentifierArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PIntegerArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PListArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeReferenceArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PValueReferenceArgument;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

abstract public class PArgumentExt extends PElementExtBase {
	public enum Type {
		INTEGER,
		BOOLEAN,
		CHARSTRING,
		IDENTIFIER,
		CONDITION,
		LIST,
		TYPE_REFERENCE,
		VALUE_REFERENCE
	}
	
	public PArgumentExt(PArgument pmodel, PTypeElementMeta ownerMeta) {
		super(pmodel, ownerMeta.getPModule());
	}

	public abstract Type getType();
	
	public abstract boolean isValueArgument();
	
	public abstract TypeClass getValueTypeClass();
	
	public abstract PValue getValue();
	
	public static PArgumentExt createArgumentExt(PTypeElementMeta ownerMeta, PArgument arg) {
		PArgumentExt result = null;
		switch(arg.eClass().getClassifierID()) {
		case FpbmodulePackage.PINTEGER_ARGUMENT:
			result = new PIntegerArgumentExt((PIntegerArgument)arg, ownerMeta);
			break;
		case FpbmodulePackage.PBOOLEAN_ARGUMENT:
			result = new PBooleanArgumentExt((PBooleanArgument)arg, ownerMeta);
			break;
		case FpbmodulePackage.PIDENTIFIER_ARGUMENT:
			result = new PIdentifierArgumentExt((PIdentifierArgument)arg, ownerMeta);
			break;
		case FpbmodulePackage.PCHARSTRING_ARGUMENT:
			result = new PCharstringArgumentExt((PCharstringArgument)arg, ownerMeta);
			break;
		case FpbmodulePackage.PLIST_ARGUMENT:
			result = new PListArgumentExt((PListArgument)arg, ownerMeta);
			break;
		case FpbmodulePackage.PCONDITION_ARGUMENT:
			result = new PConditionArgumentExt((PConditionArgument)arg, ownerMeta);
			break;
		case FpbmodulePackage.PTYPE_REFERENCE_ARGUMENT:
			result = new PTypeReferenceArgumentExt((PTypeReferenceArgument)arg, ownerMeta);
			break;
		case FpbmodulePackage.PVALUE_REFERENCE_ARGUMENT:
			result = new PValueReferenceArgumentExt((PValueReferenceArgument)arg, ownerMeta);
			break;
		}
		assert result != null;
		return result;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("type", getType())
			.toString();
	}
	
}
