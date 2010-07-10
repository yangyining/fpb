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

import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PListFieldMatcherItem;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PListFieldMatcherExt extends PTemplateMatcherExtBase {
	private List<Item> items = new ArrayList<Item>();
	protected LengthRestriction lengthRestriction;
	
	public PListFieldMatcherExt(PListFieldMatcher model, PTypeElementMeta matcherMeta) {
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

	public List<Item> getItems() {
		return items;
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
		//record of field
		if (getMatcherMeta().asTypeMeta().getTypeClass() == TypeClass.RECORDOF) {
			for (int i = 0; i < items.size(); i++) {
				Item item = items.get(i);
				PValue fieldValue = listValue.getItem(item.getIndex(paras));
				if (fieldValue == null) {
					return false;
				}
				if (!item.getMatcher().match(fieldValue, paras)) {
					return false;
				}
			}
			return true;
		//set of field(逻辑与SupersetMatche相同)
		} else {
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
						PMatcherExt matcher = items.get(j).getMatcher();
						if (matcher.match(fieldValue, paras)) {
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
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		@SuppressWarnings("unchecked")
		PListValue<PValue> resultValue = (PListValue<PValue>)matcherMeta.
				asTypeMeta().createEmptyValue();
		//field
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			PValue fieldValue = item.getMatcher().valueOf(paras);
			//如果是null则认为是-（占位符），不改变原来的值
			if (fieldValue != null) {
	            resultValue.setItem(item.getIndex(paras), fieldValue);
			}
		}		
		return resultValue;
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父方法
		super.doInit();
		//生成项目
		PListFieldMatcher model = (PListFieldMatcher)pmodel;
		if (model != null) {
			for (PListFieldMatcherItem modelItem : model.getItems()) {
				PListTypeExt listType = (PListTypeExt)matcherMeta.asTypeMeta().getRootType();
				//生成Item
				PMatcherExt itemMatcher = extFactory.createMatcher(
						listType.getItemType(), modelItem.getMatcher(), 
						this);
				Item item;
				//静态Index
				if (modelItem.getIndexMatcher() == null) {
					item = new StaticItem(modelItem.getIndex());
				//动态Index
				} else {
					PMatcherExt indexMatcher = extFactory.createMatcher(
							getPModule().getInteger(), 
							modelItem.getIndexMatcher(), null);
					item = new DynamicItem(indexMatcher);
				}
				item.setMatcher(itemMatcher);
				getItems().add(item);
			}
		}
	}
	
	abstract public static class Item {
		private PMatcherExt matcher;
		
		public PMatcherExt getMatcher() {
			return matcher;
		}

		public void setMatcher(PMatcherExt matcher) {
			this.matcher = matcher;
		}

		abstract public int getIndex(Map<String, PTemplateParIns> paras) 
		throws TemplateMatchingExption;
		
	}

	public static class StaticItem extends Item {
		private int index;

		public StaticItem(int index) {
			this.index = index;
		}

		public int getIndex(Map<String, PTemplateParIns> paras) {
			return index;
		}
		
	}
	

	public static class DynamicItem extends Item {
		private PMatcherExt indexMatcher;

		public DynamicItem(PMatcherExt indexMatcher) {
			this.indexMatcher = indexMatcher;
		}

		@Override
		public int getIndex(Map<String, PTemplateParIns> paras) 
		throws TemplateMatchingExption {
			PValue value = indexMatcher.valueOf(paras);
			assert value instanceof PIntegerValue;
			return ((PIntegerValue)value).getInteger();
		}
		
	}
}
