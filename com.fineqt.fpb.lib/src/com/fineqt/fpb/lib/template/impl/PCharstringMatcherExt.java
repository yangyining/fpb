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

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PCharstringMatcher;
import com.fineqt.fpb.lib.template.NotSingleValueException;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PCharstringMatcherExt extends PSimpleMatcherExtBase {
	private Pattern stringPattern;
	protected LengthRestriction lengthRestriction;
	private ThreadLocal<Matcher> stringMatcher = new ThreadLocal<Matcher>() {
		@Override
		protected Matcher initialValue() {
			if (stringPattern == null)
				return null;
			return stringPattern.matcher("");
		}
		
	};
	
	/**
	 * 
	 * @param meta
	 * @param literal 书写规则参照java.util.regex.Pattern类。
	 * @return
	 * @throws IllegalLiteralFormatException
	 */
	public static PCharstringMatcherExt create(PCharstringMatcher model, PTypeElementMeta meta) {
		String literal = model.getDesc();
		Pattern pattern;
		try {
			pattern = Pattern.compile(literal);
		} catch (PatternSyntaxException e) {
			throw new InitMetaException(meta.getPModule(),
					MetaException.CODE.ILLEGAL_LITERAL_FORMAT_ERROR, e);
		}
		PCharstringMatcherExt matcher = new PCharstringMatcherExt(model, meta, pattern);
		return matcher;
	}
		
	private PCharstringMatcherExt(PCharstringMatcher model, PTypeElementMeta matcherMeta, 
			Pattern pattern) {
		super(model, matcherMeta);
		stringPattern = pattern;
	}

	@Override
	public LengthRestriction lengthRestriction() {
		return lengthRestriction;
	}

	@Override
	public void setLengthRestriction(LengthRestriction restriction) {
		lengthRestriction = restriction;
	}
	
	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		PCharstringValue strValue = (PCharstringValue)value;
		//lengthRestriction
		if (lengthRestriction != null) {
			if ( !lengthRestriction.accept(strValue.getLength()) ) {
				return false;
			}
		}
		//pattern
		String seq = new String(strValue.getValue());
		Matcher matcher = stringMatcher.get();
		assert matcher != null;
		matcher.reset(seq);
		return matcher.matches();
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		throw new NotSingleValueException();
	}

	public Pattern getStringPattern() {
		return stringPattern;
	}

	
}
