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
package com.fineqt.fpb.lib.template.impl;

import com.fineqt.fpb.lib.builtin.BuiltinFactory;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbtemplate.POctetstringMatcher;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class POctetstringMatcherExt extends PStringMatcherExtBase {

	/**
	 * 
	 * @param meta
	 * @param literal 去掉前后缀后的文本。
	 * @return
	 * @throws IllegalLiteralFormatException
	 */
	public static POctetstringMatcherExt create(POctetstringMatcher model, 
			PTypeElementMeta meta, PModuleExt ownerModule) {
		String literal = model.getDesc();
		POctetstringMatcherExt matcher = 
			new POctetstringMatcherExt(model, meta, ownerModule);
		StringBuilder partBuf = null;
		//Parse Literal
		for (int i = 0; i < literal.length(); i++) {
			char ch = literal.charAt(i);
			switch(ch) {
			case PElementPattern.ANY:
			case PElementPattern.ANY_OR_NONE:
				//ValueElement
				if (partBuf != null) {
					addValuePattern(matcher, partBuf);
					partBuf = null;
				}
				//AnyElement
				if (ch == PElementPattern.ANY) {
					matcher.getElements().add(new PElementPattern.PAnyElementPattern());
				//AnyOrNone
				} else {
					matcher.getElements().add(new PElementPattern.PAnyOrNoneElementPattern());
				}
				break;
			default:
				if (ch >= '0' && ch <= '9' ||
						ch >= 'a' && ch <= 'f' ||
						ch >= 'A' && ch <= 'F') {
					if (partBuf == null) {
						partBuf = new StringBuilder();
					}
					partBuf.append(ch);
				} else {
					throw new InitMetaException(meta.getPModule(), 
							MetaException.CODE.ILLEGAL_LITERAL_FORMAT_ERROR);
				}
			}
		}
		//没有处理的ValueElement
		if (partBuf != null) {
			addValuePattern(matcher, partBuf);
			partBuf = null;
		}
		return matcher;
	}
	
	private static void addValuePattern(POctetstringMatcherExt matcher,
			StringBuilder partBuf) {
		POctetstringValue value = (POctetstringValue)BuiltinFactory.BUILTIN_INSTANCE.
			createOctetstring();
		value.setText(partBuf.toString());
		PElementPattern.POValueElementPattern pattern = 
			new PElementPattern.POValueElementPattern(value);
		matcher.getElements().add(pattern);
	}
	
	private POctetstringMatcherExt(POctetstringMatcher model, 
			PTypeElementMeta matcherMeta, PModuleExt ownerModule) {
		super(model, matcherMeta, ownerModule);
		if (matcherMeta.asTypeMeta().getTypeClass() != TypeClass.OCTETSTRING) {
			throw new IllegalArgumentException();
		}
	}
}
