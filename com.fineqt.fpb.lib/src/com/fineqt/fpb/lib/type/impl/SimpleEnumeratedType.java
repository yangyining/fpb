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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumerated;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.modelview.EnumTypeItemMV;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PEnumeratedItemExt;
import com.fineqt.fpb.lib.type.PEnumeratedTypeExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.value.PEnumeratedValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.SimpleEnumeratedValue;

public class SimpleEnumeratedType extends PPrimitiveTypeExtBase implements PEnumeratedTypeExt {
	protected Map<Integer, PEnumeratedItemExt> itemMap = 
		new HashMap<Integer, PEnumeratedItemExt>();
	protected Map<String, Integer> nameIdMap = new HashMap<String, Integer>();
	protected Map<Integer, Integer> valueIDMap = new HashMap<Integer, Integer>();
	
	public SimpleEnumeratedType(PType pmodel, PModuleExt pmoduleExt) {
		super((PEnumerated)pmodel, pmoduleExt);
	}

	@Override
	public void addItem(PEnumeratedItemExt itemExt) {
		itemMap.put(itemExt.getEnumID(), itemExt);
		nameIdMap.put(itemExt.getEnumName(), itemExt.getEnumID());
		valueIDMap.put(itemExt.getEnumValue(), itemExt.getEnumID());
	}

	@Override
	public PEnumeratedItemExt getItemByID(int enumID) {
		return itemMap.get(enumID);
	}

	@Override
	public PEnumeratedItemExt getItemByName(String enumName) {
		Integer id = nameIdMap.get(enumName);
		if (id == null) {
			return null;
		}
		return itemMap.get(id);
	}

	@Override
	public PEnumeratedItemExt getItemByValue(int enumValue) {
		Integer id = valueIDMap.get(enumValue);
		if (id == null) {
			return null;
		}
		return itemMap.get(id);
	}

	@Override
	public int getItemSize() {
		return itemMap.values().size();
	}

	@Override
	public EnumTypeItemMV getEnumTypeItemMV(String itemName) {
		return getItemByName(itemName);
	}

	@Override
	public Collection<String> getEnumTypeItemNames() {
		return nameIdMap.keySet();
	}
	
	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		PValue result = super.createNormalValue(paras);
		if (paras.getInitValue() != null) {
			result.assignPValue(paras.getInitValue());
		}
		return result;
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.appendSuper(super.toString());
		for (PEnumeratedItemExt item : itemMap.values()) {
			builder.getStringBuffer().append(LN+TAB);
			builder.append(item.getEnumName(), item);
		}
		return builder.toString();
		
	}

	public static class PEnumeratedEVExt extends PFpbPrimitiveEVExt {
		
		public PEnumeratedEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep) 
		throws DumpException {
			assert value instanceof PEnumeratedValue;
			//dump（忽略长度）
			dumpPrimitive(cxt, value, valueName, elementMeta.getConstraints(), deep, 0, 
			        (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			return 0;
		}
		
	}	
}
