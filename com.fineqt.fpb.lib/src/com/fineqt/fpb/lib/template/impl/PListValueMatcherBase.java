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
import java.util.List;
import java.util.Map;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PListValueMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.template.NotSingleValueException;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

abstract public class PListValueMatcherBase extends PTemplateMatcherExtBase {
	protected List<PElementPattern> elements = new ArrayList<PElementPattern>();
	protected LengthRestriction lengthRestriction;
	
	//Value和Any部分的固定长度（单位成员的个数）
	protected int fixedPartLength;

	public PListValueMatcherBase(PListValueMatcher model, PTypeElementMeta matcherMeta) {
		super(model, matcherMeta);
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
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		@SuppressWarnings("unchecked")
		PListValue<PValue> resultValue = (PListValue<PValue>)matcherMeta.
				asTypeMeta().createEmptyValue();
		//field
		for (int i = 0; i < elements.size(); i++) {
			PElementPattern item = elements.get(i);
			if (item.getType() == PElementPattern.Type.Value) {
				PElementPattern.PListValueElementPattern valuePattern = 
					(PElementPattern.PListValueElementPattern)item;
				PValue fieldValue = valuePattern.getPartValue().valueOf(paras);
				assert fieldValue != null;
				resultValue.appendItem(fieldValue);
			} else {
				throw new NotSingleValueException();
			}
		}		
		return resultValue;
	}

	public List<PElementPattern> getElements() {
		return elements;
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父方法
		super.doInit();
		//项目
		PListValueMatcher model = (PListValueMatcher)pmodel;
		if (model != null) {
			//Items
			for (PMatcher modelItem : model.getItems()) {
				PListTypeExt listType = (PListTypeExt)matcherMeta.asTypeMeta().getRootType();
				PMatcherExt itemMatcher = extFactory.createMatcher(
						listType.getItemType(), modelItem, this);
				PElementPattern pattern;
				if (itemMatcher instanceof PAnyMatcherExt) {
					pattern = new PElementPattern.PAnyElementPattern();
				} else if (itemMatcher instanceof PAnyOrOmitMatcherExt) {
					pattern = new PElementPattern.PAnyOrNoneElementPattern();
				} else {
					pattern = new PElementPattern.PListValueElementPattern(itemMatcher);
				}
				elements.add(pattern);
			}
		}
	}

}
