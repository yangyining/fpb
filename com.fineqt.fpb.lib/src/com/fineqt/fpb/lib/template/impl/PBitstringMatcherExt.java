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
import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbtemplate.PBitstringMatcher;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PBitstringMatcherExt extends PStringMatcherExtBase {
	/**
	 * 
	 * @param meta
	 * @param literal 去掉前后缀后的文本。比如'11?10'B -> 11?10
	 * @return
	 * @throws IllegalLiteralFormatException
	 */
	public static PBitstringMatcherExt create(PBitstringMatcher model, PTypeElementMeta meta) {
		String literal = model.getDesc();
		PBitstringMatcherExt matcher = new PBitstringMatcherExt(model, meta);
		StringBuilder partBuf = null;
		//Parse Literal
		for (int i = 0; i < literal.length(); i++) {
			char ch = literal.charAt(i);
			switch(ch) {
			case '0':
			case '1':
				if (partBuf == null) {
					partBuf = new StringBuilder();
				}
				partBuf.append(ch);
				break;
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
				throw new InitMetaException(meta.getPModule(),
						MetaException.CODE.ILLEGAL_LITERAL_FORMAT_ERROR);
			}
		}
		//没有处理的ValueElement
		if (partBuf != null) {
			addValuePattern(matcher, partBuf);
			partBuf = null;
		}
		return matcher;
	}

	private static void addValuePattern(PBitstringMatcherExt matcher,
			StringBuilder partBuf) {
		PBitstringValue value = (PBitstringValue)BuiltinFactory.BUILTIN_INSTANCE.
			createBitstring();
		value.setText(partBuf.toString());
		PElementPattern.PBValueElementPattern pattern = 
			new PElementPattern.PBValueElementPattern(value);
		matcher.getElements().add(pattern);
	}
	
	private PBitstringMatcherExt(PBitstringMatcher model, PTypeElementMeta matcherMeta) {
		super(model, matcherMeta);
		if (matcherMeta.asTypeMeta().getTypeClass() != TypeClass.BITSTRING) {
			throw new IllegalArgumentException();
		}
	}

}
