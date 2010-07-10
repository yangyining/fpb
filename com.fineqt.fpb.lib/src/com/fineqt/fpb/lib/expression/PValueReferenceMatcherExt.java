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
package com.fineqt.fpb.lib.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceFragment;
import com.fineqt.fpb.lib.model.fpbtemplate.PValueReferenceMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.ValueReferenceType;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateInstance;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.template.impl.PExpressionMatcherExtBase;
import com.fineqt.fpb.lib.value.PContainerValue;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PValueReferenceMatcherExt extends PExpressionMatcherExtBase {
	private String refName;
	private ValueReferenceType refType;
	private List<FragmentExt> fragments;
	private PConstantExt refConstant;
	private PModuleParExt refModulePar;
	
	public PValueReferenceMatcherExt(PValueReferenceMatcher model, PTypeElementMeta matcherMeta) {
		super(model, matcherMeta);
		refName = model.getRefName();
		refType = model.getRefType();
		if (model.getFragments().size() > 0) {
			fragments = new ArrayList<FragmentExt>();
			for (PValueReferenceFragment frag : model.getFragments()) {
				if (frag.getFieldName() != null) {
					fragments.add(new FieldFragment(frag.getFieldName()));
				} else if (frag.getIndexMatcher() != null){
					fragments.add(new IndexFragment(this, frag.getIndexMatcher()));
				} else {
					assert false;
				}
			}
		}
	}

	private PValue valueOfRefValue(Map<String, PTemplateParIns> paras, PValue refValue)
	throws TemplateMatchingExption {
		if (refValue == null) {
			return null;
		}
		if (fragments != null) {
			PValue subValue = getSubField(refValue, paras);
			if (subValue == null) {
				return null;
			}
			return (PValue)subValue.clone();
		} else {
			return (PValue)refValue.clone();
		}
	}
	
	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		switch(refType) {
		case CONSTANT:
			assert refConstant != null;
			PValue consValue = refConstant.getPValue();
//			System.out.println("refConstant:"+refConstant);
			return valueOfRefValue(paras, consValue);
		case MODULEPAR:
			assert refModulePar != null;
			PValue mparValue = refModulePar.getPValue();
			return valueOfRefValue(paras, mparValue);
		case TEMPLATEPAR:
			PTemplateParIns parIns = getParIns(paras);
			if (parIns.isTemplateIns()) {
				PTemplateInstance parTmpIns = parIns.getTemplateIns();
				return parTmpIns.valueOf();
			} else {
				PValue parValue = parIns.getValue();
				return valueOfRefValue(paras, parValue);
			}
		}
		assert false;
		return null;
	}

	private PValue getSubField(PValue rootField, Map<String, PTemplateParIns> paras) 
	throws TemplateMatchingExption {
		for (int i = 0; i < fragments.size(); i++) {
			FragmentExt meta = fragments.get(i);
			rootField = meta.getField(rootField, paras);
			if (rootField == null) {
				return null;
			}
		}
		return rootField;
	}
	
	private void initConstant() throws InitMetaException {
		//常量
		refConstant = getPModule().pPConstant(refName);
		if (refConstant == null) {
			throw new InitMetaException(
					getPModule(),
					MetaException.CODE.CONSTANT_NOT_FOUND_ERROR, 
					refName, getPModule().getModuleName());
		}
		//初始化
		refConstant.init();
	}
	
	private void initModulePar() throws InitMetaException {
		//模块参数
		refModulePar = getPModule().pPModulePar(refName);
		if (refModulePar == null) {
			throw new InitMetaException(
					getPModule(),
					MetaException.CODE.MODULEPAR_NOT_FOUND_ERROR, 
					refName, getPModule().getModuleName());
		}
		//初始化
		refModulePar.init();
	}
	
	
	private PTemplateParIns getParIns(Map<String, PTemplateParIns> paras) 
	throws TemplateMatchingExption {
		if (paras == null) {
			throw new NullPointerException();
		}
		PTemplateParIns ins = paras.get(refName);
		if (ins == null) {
			throw new TemplateMatchingExption(
					MetaException.CODE.TEMPLATE_PARAMETER_REQUIRED_ERROR, 
					refName, "Any");
		}
		return ins;
	}

	public String getRefName() {
		return refName;
	}

	@Override
	protected void doInit() throws InitMetaException {
		super.doInit();
		//依赖元素的初始化
		switch(refType) {
		case CONSTANT:
			initConstant();
			break;
		case MODULEPAR:
			initModulePar();
			break;
		case TEMPLATEPAR:
			break;
		}
	}

	private abstract static class FragmentExt {
		abstract PValue getField(PValue value, Map<String, PTemplateParIns> paras) 
		throws TemplateMatchingExption;
	}
	
	private static class FieldFragment extends FragmentExt {
		private String fieldName;
		
	
		public FieldFragment(String fieldName) {
			this.fieldName = fieldName;
		}

		@Override
		PValue getField(PValue value, Map<String, PTemplateParIns> paras) {
			if (!(value instanceof PContainerValue)) {
				return null;
			}
			if (value.notPresent()) {
				return null;
			}
			return ((PContainerValue)value).pGetFieldByName(fieldName);
		}
		
	}
	
	private static class IndexFragment extends FragmentExt {
		private PMatcherExt indexMatcher;
		
		public IndexFragment(PValueReferenceMatcherExt owner, PMatcher matcher) {
			indexMatcher = extFactory.createMatcher(
					owner.getPModule().getInteger(), matcher, null);
		}

		@Override
		PValue getField(PValue value, Map<String, PTemplateParIns> paras) throws TemplateMatchingExption {
			if (!(value instanceof PListValue)) {
				return null;
			}
			if (value.notPresent()) {
				return null;
			}
			PValue indexValue = indexMatcher.valueOf(paras);
			assert indexValue instanceof PIntegerValue;
			int index = ((PIntegerValue)indexValue).getInteger();
			@SuppressWarnings("unchecked")
			PListValue<PValue> lstValue = (PListValue<PValue>)value;
			return lstValue.getItem(index);
		}
		
		
	}
}
