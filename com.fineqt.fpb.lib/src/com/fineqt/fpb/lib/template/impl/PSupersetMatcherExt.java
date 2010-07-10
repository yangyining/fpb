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

import org.eclipse.emf.common.util.EList;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PSuperSetMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateMatcher;
import com.fineqt.fpb.lib.template.NotSingleValueException;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PSupersetMatcherExt extends PSimpleMatcherExtBase {
	private List<PValue> items = new ArrayList<PValue>();
	protected LengthRestriction lengthRestriction;

	public PSupersetMatcherExt(PSuperSetMatcher model, PTypeElementMeta matcherMeta) {
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
		//field
		//匹配成功的对应比特为false
		BitSet notMatchedItems = new BitSet(items.size());
		notMatchedItems.set(0, items.size());
		for (int i = 0; i < listValue.getLength(); i++) {
			PValue fieldValue = listValue.getItem(i);
			if (fieldValue == null) {
				continue;
			}
			//匹配还没有匹配成功的Matcher
			for (int j = 0; j < items.size(); j++) {
				if (notMatchedItems.get(j)) {
					PValue matcher = items.get(j);
					if (matcher.equals(fieldValue)) {
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

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		throw new NotSingleValueException();
	}

	public List<PValue> getItems() {
		return items;
	}
	
	@Override
	protected void doInit() throws InitMetaException {
		//父方法
		super.doInit();
		//Items
		PSuperSetMatcher model = (PSuperSetMatcher)pmodel;		
		EList<PTemplateMatcher> modelItems = model.getItems();
		PListTypeExt listType = (PListTypeExt)matcherMeta.asTypeMeta().getRootType();
		for (PMatcher modelItem : modelItems) {
			PMatcherExt matcherItem;
			matcherItem = extFactory.createMatcher(
					listType.getItemType(), 
					modelItem, 
					this);
			matcherItem.init();
			PValue value;
			try {
				value = matcherItem.valueOf(null);
			} catch (TemplateMatchingExption e) {
				throw new InitMetaException(getPModule(), 
						MetaException.CODE.MUST_CONSTANT_EXPRESSION_ERROR, "SuperSet");
			}
			getItems().add(value);
		}
	}
	
}
