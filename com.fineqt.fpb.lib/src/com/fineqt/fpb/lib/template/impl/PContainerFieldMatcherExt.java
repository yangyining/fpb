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

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PContainerFieldMatcherItem;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.value.PContainerValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PContainerFieldMatcherExt extends PTemplateMatcherExtBase {
	private List<Item> items = new ArrayList<Item>();
	
	public PContainerFieldMatcherExt(PContainerFieldMatcher model, 
			PTypeElementMeta matcherMeta, PModuleExt ownerModule) {
		super(model, matcherMeta, ownerModule);
	}

	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		PContainerValue containerValue = (PContainerValue)value;
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			PValue fieldValue = containerValue.pGetFieldByID(item.getFieldMeta().getFieldID());
			if (fieldValue == null) {
				return false;
			}
			if ( !item.getMatcher().match(fieldValue, paras) ) {
				return false;
			}
		}
		return true;
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		PContainerValue resultValue = (PContainerValue)matcherMeta.asTypeMeta().createEmptyValue();
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			PValue fieldValue = item.getMatcher().valueOf(paras);
            //如果是null则认为是-（占位符），不改变原来的值
			if (fieldValue != null) {
	            resultValue.pSetFieldByID(item.getFieldMeta().getFieldID(), fieldValue);
			}
		}
		return resultValue;
	}

	public List<Item> getItems() {
		return items;
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父方法
		super.doInit();
		//生成项目
		PContainerFieldMatcher model = (PContainerFieldMatcher)pmodel;
		if (model != null) {
			//Items
			for (PContainerFieldMatcherItem modelItem : model.getItems()) {
				PContainerTypeExt containerType = 
					(PContainerTypeExt)matcherMeta.asTypeMeta().getRootType();
				//取得字段Meta
				PFieldExt fieldMeta = containerType.getFieldMeta(modelItem.getFieldName());
				if (fieldMeta == null) {
					throw new InitMetaException(getPModule(), 
							MetaException.CODE.FIELD_NOT_FOUND_ERROR, 
							modelItem.getFieldName(), containerType.getFullName());
				}
				//生成Item
				PMatcherExt itemMatcher = extFactory.createMatcher(fieldMeta, modelItem.getMatcher(), 
						this, getPModule());
				PContainerFieldMatcherExt.Item item = new PContainerFieldMatcherExt.Item(
						fieldMeta);
				item.setMatcher(itemMatcher);
				getItems().add(item);
			}
		}
	}

	public static class Item {
		private PFieldExt fieldMeta;
		private PMatcherExt matcher;
		
		public Item(PFieldExt fieldMeta) {
			this.fieldMeta = fieldMeta;
		}

		public PMatcherExt getMatcher() {
			return matcher;
		}

		public void setMatcher(PMatcherExt matcher) {
			this.matcher = matcher;
		}

		public PFieldExt getFieldMeta() {
			return fieldMeta;
		}
	}
}
