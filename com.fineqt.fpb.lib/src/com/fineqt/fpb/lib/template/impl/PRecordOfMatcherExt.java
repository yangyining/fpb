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

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PRecordOfMatcherExt extends PListValueMatcherBase {

	public PRecordOfMatcherExt(PListValueMatcher model, PTypeElementMeta matcherMeta, 
			PModuleExt ownerModule) {
		super(model, matcherMeta, ownerModule);
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
		//当前位置的偏移量
		int offset = 0;
		int usedFixedLength = 0;
		for (int i = 0; i < elements.size(); i++) {
			PElementPattern pattern = elements.get(i);
			switch(pattern.getType()) {
			case Value:
				PElementPattern.PValueElementPattern valuePattern = 
					(PElementPattern.PValueElementPattern)pattern;
				int len = valuePattern.match(value, offset, paras);
				if (len < 0) {
					return false;
				}
				offset += len;
				usedFixedLength += len;
				break;
			case Any:
				if (listValue.getLength() > offset) {
					offset++;
					usedFixedLength++;
				} else {
					return false;
				}
				break;
			case AnyOrNone:
				PElementPattern.PValueElementPattern nextValuePtn = null;
				//Next Pattern
				if (i + 1 < elements.size()) {
					PElementPattern nextPtn = elements.get(i + 1);
					if (nextPtn.getType() == PElementPattern.Type.Value) {
						nextValuePtn = (PElementPattern.PValueElementPattern)nextPtn;
					}
				}
				while(offset < listValue.getLength()) {
					//确保剩余固定长度
					if (listValue.getLength() - offset <= fixedPartLength - usedFixedLength) {
						break;
					}
					//Lookahead 1
					if (nextValuePtn != null && nextValuePtn.match(value, offset, paras) >= 0) {
						break;
					}
					//Inc 1
					offset++;
				}
				break;
			}
		}
		//判断是否匹配完所有成员
		if (offset < listValue.getLength()) {
			return false;
		}
		return true;
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
				PElementPattern.PValueElementPattern valuePattern = 
					(PElementPattern.PValueElementPattern)pattern;
				fixedPartLength += valuePattern.getFixedLength();
				break;
			case Any:
				fixedPartLength += 1;
				break;
			}
		}
	}
	
}
