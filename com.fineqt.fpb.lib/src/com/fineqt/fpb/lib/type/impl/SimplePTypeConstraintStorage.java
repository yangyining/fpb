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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IStringValue;
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.constraint.PLengthConstraintExt;
import com.fineqt.fpb.lib.constraint.PListConstraintExt;
import com.fineqt.fpb.lib.constraint.PPatternConstraintExt;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.value.PValue;

public class SimplePTypeConstraintStorage 
implements PTypeConstraintStorage, CreatePTypeValueParamaters{
	//保存的都是Leaf限制
	private List<PTypeConstraintExt> constraints = new ArrayList<PTypeConstraintExt>();
	private int fixedLength = -1;
	private PValue fixedValue;
	private Pattern stringPattern;
	private ThreadLocal<Matcher> stringMatcher = new ThreadLocal<Matcher>() {
		@Override
		protected Matcher initialValue() {
			if (stringPattern == null)
				return null;
			return stringPattern.matcher("");
		}
		
	};
	
	@Override
	public void addConstraint(List<PTypeConstraintExt> constraints) {
		for (PTypeConstraintExt cons : constraints) {
			addConstraint(cons);
		}
	}

	private void addLeafConstraint(PTypeConstraintExt cons) {
		assert cons.isLeaf();
		if (cons instanceof PLengthConstraintExt) {
			//最后一个有效
			PLengthConstraintExt lenCons = (PLengthConstraintExt)cons;
			if (lenCons.getFixedlLength() >= 0) {
				fixedLength = lenCons.getFixedlLength();
			}
		} else if (cons instanceof PListConstraintExt) {
			//fixedValue取第一次的List中的固定值
			if (fixedValue == null) {
				fixedValue = ((PListConstraintExt)cons).getFixedValue();
			//两次以上则认为没有固定值
			} else if (((PListConstraintExt)cons).getFixedValue() != null){
				fixedValue = null;
			}
		} else if (cons instanceof PPatternConstraintExt) {
			//最后一个有效
			stringPattern = ((PPatternConstraintExt)cons).getPattern();
		}
		constraints.add(cons);
	}

	private void addCompoundConstraint(PTypeConstraintExt constraint) {
		assert constraint.isCompound();
		for (PTypeConstraintExt cons : constraint.getChildren()) {
			if (cons.isCompound()) {
				addCompoundConstraint(cons);
			} else {
				addLeafConstraint(cons);
			}
		}
	}
	
	@Override
	public void addConstraint(PTypeConstraintExt constraint) {
		if (constraint.isCompound()) {
			addCompoundConstraint(constraint);
		} else {
			addLeafConstraint(constraint);
		}
	}

	@Override
	public List<PTypeConstraintExt> getAll() {
		return Collections.unmodifiableList(constraints);
	}

	@Override
	public int getFixedLength() {
	    if (fixedValue != null) {
	        if (fixedValue instanceof IStringValue) {
	            return ((IStringValue)fixedValue).getLength();
	        } else if (fixedValue instanceof IListValue<?>) {
	            return ((IListValue<?>)fixedValue).getLength();
	        }
	    }
		return fixedLength;
	}

	@Override
	public PValue getFixedValue() {
		return fixedValue;
	}

	@Override
	public int getInitLength() {
		return fixedLength;
	}

	@Override
	public PValue getInitValue() {
		return fixedValue;
	}

	@Override
	public Pattern getStringPattern() {
		return stringPattern;
	}

	@Override
	public Matcher getThreadStringMatcher() {
		return stringMatcher.get();
	}

	@Override
	public boolean validate(PValue value, DiagnosticChain chain) {
		boolean result = true;
		boolean continueOnError = false;
		if (chain != null) {
			continueOnError = chain.shouldCollectAllError();
		}
		for (PTypeConstraintExt cons : constraints) {
			if (!cons.validate(value, chain)) {
				result = false;
				if (!continueOnError) {
					return result;
				}
			}
		}
		return result;
	}

	@Override
	public boolean validate(PValue value) {
		return validate(value, null);
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("constraints", constraints)
			.append("fixedLength", fixedLength)
			.append("fixedValue", fixedValue)
			.append("stringPattern", stringPattern==null?null:stringPattern.pattern())
			.toString();
	}
}
