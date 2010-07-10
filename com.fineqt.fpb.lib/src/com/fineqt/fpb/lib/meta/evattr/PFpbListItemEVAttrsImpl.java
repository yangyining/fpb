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

import java.util.BitSet;

import com.fineqt.fpb.lib.builtin.PBooleanValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.property.PArgumentExt;
import com.fineqt.fpb.lib.meta.property.PPropertyExt;
import com.fineqt.fpb.lib.meta.property.PPropertyListExt;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.type.PFpbListItemEVAttrs;
import com.fineqt.fpb.lib.type.PFpbListItemEVExt;
import com.fineqt.fpb.lib.value.PValue;

public class PFpbListItemEVAttrsImpl extends PFpbEVAttrsBase
implements PFpbListItemEVAttrs {
	private static int OVERRIDE_WHOLE = 0;
    private static int DEFAULT_LENGTH = 1;
    private static int DEFAULT_VALUE = 2;
	private static int MAX_ID = DEFAULT_VALUE;
	
	private static String OVERRIDE_WHOLE_NAME = "OverrideWhole";
    private static String DEFAULT_LENGTH_NAME = "DefaultLength";
    private static String DEFAULT_VALUE_NAME = "DefaultValue";

	private PFpbListItemEVExt ownerEV;
	private BitSet changedFlags = new BitSet(MAX_ID + 1);
	private boolean overrideWhole = false;
    private int defaultLength = -1;
    private PValue defaultValue;

	public PFpbListItemEVAttrsImpl(PPropertyListExt prpList, PFpbListItemEVExt ownerEV) {
		this.ownerEV = ownerEV;
		if (prpList != null) {
			initPropertyList(prpList);
		}
	}
	
	private PModuleExt getPModule() {
		return ownerEV.getOwner().getPModule();
	}
	
	@Override
	public boolean isOverrideWhole() {
		return overrideWhole;
	}

	@Override
	public boolean isSetOverrideWhole() {
		return changedFlags.get(OVERRIDE_WHOLE);
	}

    @Override
    public int getDefaultLength() {
        return defaultLength;
    }

    @Override
    public PValue getDefaultValue() {
        return defaultValue;
    }

    @Override
    public boolean isSetDefaultLength() {
        return changedFlags.get(DEFAULT_LENGTH);
    }

    @Override
    public boolean isSetDefaultValue() {
        return changedFlags.get(DEFAULT_VALUE);
    }

    
	private void initPropertyList(PPropertyListExt prpList) {
		//overrideWhole
		if (!parseOverrideWhole(prpList)) {
			throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
					prpList.getProperty(OVERRIDE_WHOLE_NAME), OVERRIDE_WHOLE_NAME, 
					SINGLE_BOOLEAN_FORMAT);
		}
        //defaultLength
        if (!parseDefaultLength(prpList)) {
            throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
                    prpList.getProperty(DEFAULT_LENGTH_NAME), DEFAULT_LENGTH_NAME, 
                    SINGLE_INTEGER_FORMAT);
        }
        //defaultValue
        if (!parseDefaultValue(prpList)) {
            throw new InitMetaException(getPModule(), MetaException.CODE.EV_ARGUMENT_FORMAT_ERROR, 
                    prpList.getProperty(DEFAULT_VALUE_NAME), DEFAULT_VALUE_NAME, SINGLE_VALUE_FORMAT);
        }
		
	}

	private boolean parseOverrideWhole(PPropertyListExt prpList) {
		PPropertyExt property = prpList.getProperty(OVERRIDE_WHOLE_NAME);
		if (property == null) {
			return true;
		}
		PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.BOOLEAN);
		if (tempArg == null) {
			return false;
		}
		overrideWhole = ((PBooleanValue)tempArg.getValue()).getBoolean();
		changedFlags.set(OVERRIDE_WHOLE);
		return true;
	}

    private boolean parseDefaultLength(PPropertyListExt prpList) {
        PPropertyExt property = prpList.getProperty(DEFAULT_LENGTH_NAME);
        if (property == null) {
            return true;
        }
        PArgumentExt tempArg = getSingleValueArgument(property, TypeClass.INTEGER);
        if (tempArg == null) {
            return false;
        }
        defaultLength = ((PIntegerValue)tempArg.getValue()).getInteger();
        changedFlags.set(DEFAULT_LENGTH);
        return true;
    }
	
    private boolean parseDefaultValue(PPropertyListExt prpList) throws InitMetaException {
        PPropertyExt property = prpList.getProperty(DEFAULT_VALUE_NAME);
        if (property == null)
            return true;
        defaultValue = parseSingleValue(property, ownerEV.getOwner().getType());
        if (defaultValue == null) {
            return false;
        }
        changedFlags.set(DEFAULT_VALUE);
        return true;
    }

}
