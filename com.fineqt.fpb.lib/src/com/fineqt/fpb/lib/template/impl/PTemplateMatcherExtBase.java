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

import java.math.BigInteger;
import java.util.Map;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher;
import com.fineqt.fpb.lib.template.PTemplateMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

abstract public class PTemplateMatcherExtBase extends PElementExtBase
implements PTemplateMatcherExt {
	protected PTypeElementMeta matcherMeta;
	private boolean ifPresent;
	
	public PTemplateMatcherExtBase(PTemplateMatcher pmodel, PTypeElementMeta matcherMeta, 
			PModuleExt ownerModule) {
		super(pmodel, ownerModule);
		this.matcherMeta = matcherMeta;
	}

	@Override
	protected void doInit() throws InitMetaException {
		super.doInit();
		//初始化依赖类型
		matcherMeta.asTypeMeta().init();
		PTemplateMatcher model = (PTemplateMatcher)pmodel;
		if (model != null) {
			//attribute
			setAttribute(model);
		}
	}

	@Override
	public PTypeElementMeta getMatcherMeta() {
		return matcherMeta;
	}

	@Override
	public boolean ifPresent() {
		return ifPresent;
	}

	@Override
	public LengthRestriction lengthRestriction() {
		return null;
	}

	@Override
	public boolean setIfPresent(boolean ifPresent) {
		return this.ifPresent = ifPresent;
	}

	@Override
	public void setLengthRestriction(LengthRestriction restriction) {
		throw new UnsupportedOperationException();
	}
	
	public Object clone() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean match(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		//omit检测
		if (ifPresent && value.notPresent()) {
			return true;
		}
		return doMatch(value, paras);
	}
	
	abstract protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
	throws TemplateMatchingExption;

	private void setAttribute(PTemplateMatcher model) 
	throws InitMetaException {
		//ifPresent
		setIfPresent(model.isIfPresent());
		//lengthRestriction
		String lenRestStr = model.getLengthRestriction();
		if (lenRestStr != null) {
			PTemplateMatcherExt.LengthRestriction restriction;
			try {
				if (lenRestStr.contains("..")) {
					String[] rangeItems = lenRestStr.split("\\.\\.");
					if (rangeItems.length != 2) {
						throw new InitMetaException(getPModule(),
								MetaException.CODE.ILLEGAL_LITERAL_FORMAT_ERROR, 
								" parsing length restriction of " + lenRestStr);
					}
					//minValue
					String desc =rangeItems[0].trim();
					BigInteger minValue;
					if (desc.equals(FpbConstants.MINUS_INFINITY_LITERAL)) {
						minValue = BigInteger.valueOf(Long.MIN_VALUE);
					} else {
						minValue = parseBigInteger(desc);
					}
					//maxValue
					desc =rangeItems[1].trim();
					BigInteger maxValue;
					if (desc.equals(FpbConstants.PLUS_INFINITY_LITERAL)) {
						maxValue = BigInteger.valueOf(Long.MAX_VALUE);
					} else {
						maxValue = parseBigInteger(desc);
					}
					restriction = new PTemplateMatcherExtBase.LengthRange(minValue.intValue(), 
							maxValue.intValue());
				} else {
					BigInteger fixValue = parseBigInteger(lenRestStr);
					restriction = new PTemplateMatcherExtBase.LengthRange(fixValue.intValue(), 
							fixValue.intValue());
				}
			} catch (IllegalLiteralFormatException e) {
				throw new InitMetaException(getPModule(),
						MetaException.CODE.ILLEGAL_LITERAL_FORMAT_ERROR, 
						e, " parsing length restriction of " + lenRestStr);
			}
			setLengthRestriction(restriction);
		}
	}
	
	public static class LengthRange implements LengthRestriction {
		private int lowerBound;
		private int upperBound;
		
		public LengthRange(int lowerBound, int upperBound) {
			super();
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}
		
		public boolean accept(int length) {
			return length >= lowerBound && length <= upperBound;
		}
	}
	
}
