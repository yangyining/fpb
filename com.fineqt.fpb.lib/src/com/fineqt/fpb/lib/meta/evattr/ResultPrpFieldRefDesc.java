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

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class ResultPrpFieldRefDesc extends FieldRefDesc {
	private Method readMethod;
	
	public ResultPrpFieldRefDesc(String prpName, String pathDesc, 
			PTypeExt targetType, Class<? extends DecodeResult> decodeResultClass) 
	throws MetaException {
		if (targetType == null)
			throw new IllegalArgumentException();
		try {
			PropertyDescriptor targetProperty = new PropertyDescriptor(prpName, decodeResultClass);
			readMethod = targetProperty.getReadMethod();
		} catch (IntrospectionException e) {
			throw new MetaException(MetaException.CODE.FIELD_REF_DESC_CREATING_ERROR, e);
		}
		//PPath
		createPPath(pathDesc, targetType);
	}
	
	@Override
	public Type getType() {
		return Type.RESULT_PROPERTY;
	}

	
	public PValue findRefValue(DecodeResult decodeResult) {
		try {
			return (PValue)readMethod.invoke(decodeResult, new Object[0]);
		} catch (Exception e) {
			System.err.println(e);
			//出错则返回null
			return null;
		}
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.appendSuper(super.toString())
			.append("readMethod", readMethod)
			.toString();
	}

	public Method getReadMethod() {
		return readMethod;
	}
	
}
