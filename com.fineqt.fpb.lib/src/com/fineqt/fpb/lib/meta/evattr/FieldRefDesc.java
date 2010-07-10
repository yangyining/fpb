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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;

abstract public class FieldRefDesc {
	public static final char STACK_FIELD_PREFIX = '-';
	public static final char CXT_ATTR_PREFIX = '$';
	public static final char OWNER_FIELD_PREFIX = '^';
	public static final char TYPE_FIELD_PREFIX = '+';
	public static final char RESULT_PROPERTY_PREFIX = '@';
	public static final char DELIMITER = '/';
	public static final char LIST_INDEX_LEFT = '[';
	
	protected PPath path;
	
	public static FieldRefDesc parse(String literal, PTypeExt ownerType, 
			PTypeExt targetType, Class<? extends DecodeResult> decodeResultClass) 
	throws IllegalLiteralFormatException {
		String str = literal.trim();
		if (str.length() <= 0) {
			throw new IllegalLiteralFormatException();
		}
		char prefix = str.charAt(0);
		String content = str.substring(1).trim();
		if (content.length() <= 0) {
			throw new IllegalLiteralFormatException();
		}
		String rootElementDesc = null;
		String pathDesc = null;
		switch(prefix) {
		case STACK_FIELD_PREFIX:
		case CXT_ATTR_PREFIX:
		case RESULT_PROPERTY_PREFIX:
			int firstDeliIdx = content.indexOf(DELIMITER);
			if (firstDeliIdx >= 0) {
				rootElementDesc = content.substring(0, firstDeliIdx);
				int firstLeftIdx = rootElementDesc.indexOf(LIST_INDEX_LEFT);
				if (firstLeftIdx >= 0) {
					rootElementDesc = content.substring(0, firstLeftIdx);
					pathDesc = content.substring(firstLeftIdx);
				} else {
					pathDesc = content.substring(firstDeliIdx);
				}
			} else {
				rootElementDesc = content;
				pathDesc = null;
			}
		}
		try {
			switch(prefix) {
			case STACK_FIELD_PREFIX:
				assert targetType != null;
				return new StackFieldRefDesc(rootElementDesc, pathDesc, targetType);
			case CXT_ATTR_PREFIX:
				assert targetType != null;
				return new CxtAttrFieldRefDesc(rootElementDesc, pathDesc, targetType);
			case OWNER_FIELD_PREFIX:
				assert ownerType != null;
				return new OwnerFieldRefDesc(content, ownerType);
			case TYPE_FIELD_PREFIX:
				assert targetType != null;
				return new TypeFieldRefDesc(content, targetType);
			case RESULT_PROPERTY_PREFIX:
				return new ResultPrpFieldRefDesc(rootElementDesc, pathDesc, targetType, 
						decodeResultClass);
			//默认为TypeField
			default:
				assert targetType != null;
				return new TypeFieldRefDesc(content, targetType);
			}
		} catch (MetaException e) {
			throw new IllegalLiteralFormatException(e);
		}
	}
	
	protected void createPPath(String pathDesc, PTypeExt targetType)
			throws MetaException {
		if (pathDesc == null) {
			path = PPath.createSelfPath(targetType);
		} else {
			path = PPath.parse(pathDesc, targetType);
		}
	}
	/**
	 * 取得引用目标字段(路径最末端字段)的类型。
	 * @return
	 */
	public PTypeExt getRefFieldType() {
		return path.getRefFieldType();
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("type", getType())
			.append("path", path)
			.toString();
	}
	
	public enum Type{
		STACK, 
		CONTEXT_ATTRIBUTE, 
		OWNER_FIELD, 	//只在Field的定义中使用有效
		TYPE_FIELD,		//Decode时只在Record类型中有效
		RESULT_PROPERTY	//只在Decode时有效
		};
	
	abstract public FieldRefDesc.Type getType();

	public PPath getPath() {
		return path;
	}
	
}