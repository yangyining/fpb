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
package com.fineqt.fpb.lib.grammer.mv;

import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.FpbtemplateFactory;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType;
import com.fineqt.fpb.lib.modelview.ConstantMV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.modelview.ModuleElementMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.modelview.ModuleParMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

public class ValueReferenceSymbol extends SymbolElement {
	private ModuleMV module;
	private ModuleElementSymbolBase owner;
	private PValueReferenceMatcher model;
	private ModuleElementMV refElement;
	private TypeMV baseType;
	private boolean inConstScope;
	
	public ValueReferenceSymbol(ModuleMV module, ModuleElementSymbolBase owner, 
			String refElementName, TypeMV baseType, boolean inConstScope) {
		this.owner = owner;
		this.module = module;
		this.baseType = baseType;
		this.inConstScope = inConstScope;
		model = FpbtemplateFactory.eINSTANCE.createPValueReferenceMatcher();
		model.setRefName(refElementName);
		if (owner != null) {
			owner.getRefValues().add(this);
		}
	}
	
	public void addFieldFragment(String fieldName) {
		PValueReferenceFragment fragment = 
			FpbtemplateFactory.eINSTANCE.createPValueReferenceFragment();
		fragment.setFieldName(fieldName);
		model.getFragments().add(fragment);
	}
	
	public void addIndexFragment(PMatcher indexMatcher) {
		PValueReferenceFragment fragment = 
			FpbtemplateFactory.eINSTANCE.createPValueReferenceFragment();
		fragment.setIndexMatcher(indexMatcher);
		model.getFragments().add(fragment);
	}

	public ModuleElementSymbolBase getOwner() {
		return owner;
	}

	public PValueReferenceMatcher getModel() {
		return model;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		if (baseType == null) {
			return;
		}
		String refElementName = model.getRefName();
		//取得引用对象
		refElement = module.pModuleElement(refElementName);
		if (refElement == null) {
			cxt.addErrorMsg(getStartPosition(),
					MetaException.CODE.REFERENCED_ELEMENT_NOT_FOUND_ERROR,
					refElementName);
			return;
		}
		ValueReferenceType refType = null;
		TypeMV refDstType = null;
		//取得引用类型
		switch(refElement.getModuleElementType()) {
		case CONSTANT:
			refType = ValueReferenceType.CONSTANT;
			refDstType = ((ConstantMV)refElement).getBaseTypeMV();
			break;
		case MODULE_PARAMETER:
			if (!inConstScope) {
				refType = ValueReferenceType.MODULEPAR;
				refDstType = ((ModuleParMV)refElement).getBaseTypeMV();
			} else {
				cxt.addErrorMsg(getStartPosition(),
						MetaException.CODE.ELEMENT_REFERENCE_NOT_ALLOWED_ERROR,
						refElementName);
				return;
			}
			break;
		case ENUM_SET:
		case TEMPLATE:
		case TYPE:
			cxt.addErrorMsg(getStartPosition(),
					MetaException.CODE.ELEMENT_REFERENCE_NOT_ALLOWED_ERROR,
					refElementName);
			return;
		}
		model.setRefType(refType);
		//检验Fragment的有效性
		assert refDstType != null;
		TypeMV currentOwnerType = refDstType;
		for (PValueReferenceFragment fragment : model.getFragments()) {
			//Field
			if (fragment.getFieldName() != null) {
				if (!currentOwnerType.isContainerType()) {
					cxt.addErrorMsg(getStartPosition(),
							MetaException.CODE.MUST_CONTAINER_TYPE_ERROR,
							currentOwnerType.getFullName());
					return;
				}
				FieldMV field = currentOwnerType.getFieldMV(fragment.getFieldName());
				if (field == null) {
					cxt.addErrorMsg(getStartPosition(),
							MetaException.CODE.FIELD_NOT_FOUND_ERROR,
							fragment.getFieldName(), currentOwnerType.getFullName());
					return;
				}
				currentOwnerType = field.getFieldTypeMV();
			//List
			} else {
				if (!currentOwnerType.isListType()) {
					cxt.addErrorMsg(getStartPosition(),
							MetaException.CODE.MUST_LIST_TYPE_ERROR,
							currentOwnerType.getFullName());
					return;
				}
				ListItemMV item = currentOwnerType.getListItemMV();
				currentOwnerType = item.getItemTypeMV();
			}
		}
		//验证类型是否匹配
		if (!baseType.isCompatibleMV(currentOwnerType)) {
			cxt.addErrorMsg(getStartPosition(),
					MetaException.CODE.TYPE_NOT_COMPATIBLE_ERROR,
					refDstType.getFullName(), baseType.getFullName());
			return;
		}
		super.doInitModel(cxt);
	}

	public ModuleElementMV getRefElement() {
		return refElement;
	}

	public void setRefElement(ModuleElementMV refElement) {
		this.refElement = refElement;
	}

	public TypeMV getBaseType() {
		return baseType;
	}
	
	
}
