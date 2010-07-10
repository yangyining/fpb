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

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

import com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PSetOfMatcherExt extends PListValueMatcherBase {
	private List<PElementPattern.PListValueElementPattern> valueElements = 
		new ArrayList<PElementPattern.PListValueElementPattern>();
	
	public PSetOfMatcherExt(PListValueMatcher model, PTypeElementMeta matcherMeta) {
		super(model, matcherMeta);
	}

	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		@SuppressWarnings("unchecked")
		PListValue<PValue> listValue = (PListValue<PValue>)value;
		//lengthRestriction
		if (lengthRestriction != null) {
			if ( !lengthRestriction.accept(listValue.getLength()) ) {
				return false;
			}
		}
		//判断固定部分长度
		if (listValue.getLength() < fixedPartLength) {
			return false;
		}
		//field
		//匹配成功的对应比特为false
		BitSet notMatchedItems = new BitSet(valueElements.size());
		notMatchedItems.set(0, valueElements.size());
		for (int i = 0; i < listValue.getLength(); i++) {
			PValue fieldValue = listValue.getItem(i);
			if (fieldValue == null) {
				continue;
			}
			//匹配还没有匹配成功的Matcher
			for (int j = 0; j < valueElements.size(); j++) {
				if (notMatchedItems.get(j)) {
					if (valueElements.get(j).match(listValue, i, paras) > 0) {
						notMatchedItems.clear(j);
						break;
					}
				}
			}
			//判断是否全部匹配成功
			if (notMatchedItems.isEmpty()) {
				return true;
			}
		}		
		//判断是否全部匹配成功
		return notMatchedItems.isEmpty();
	}

	//初始化
	public void init() {
		//父方法
		super.doInit();
		//fixedPartLength的计算
		fixedPartLength = 0;
		for (PElementPattern pattern : elements) {
			switch (pattern.getType()) {
			case Value:
				PElementPattern.PListValueElementPattern valuePattern = 
					(PElementPattern.PListValueElementPattern)pattern;
				fixedPartLength += valuePattern.getFixedLength();
				valueElements.add(valuePattern);
				break;
			case Any:
				fixedPartLength += 1;
				break;
			}
		}
	}
	
}
