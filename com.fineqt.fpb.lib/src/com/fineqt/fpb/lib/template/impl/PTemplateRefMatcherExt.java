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
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplateRefMatcherPar;
import com.fineqt.fpb.lib.template.PEntityTemplateExt;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.template.PTemplateInstance;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.PTemplateParMeta;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PTemplateRefMatcherExt extends PSimpleMatcherExtBase {
	private PTemplateExt templateMeta;
	private List<ParameterCreator> parCreators = new ArrayList<ParameterCreator>();
	
	public PTemplateRefMatcherExt(PTemplateRefMatcher model, PTypeElementMeta matcherMeta,
			PModuleExt ownerModule) {
		super(model, matcherMeta, ownerModule);
	}

	@Override
	protected boolean doMatch(PValue value, Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		if (parCreators.size() > 0) {
			Object newParas[] = new Object[parCreators.size()];
			for (int i = 0; i < parCreators.size(); i++) {
				ParameterCreator creator = parCreators.get(i);
				newParas[i] = creator.create(paras);
			}
			return templateMeta.matchPValue(value, false, newParas);
		} else {
			return templateMeta.matchPValue(value, false);
		}
	}

	@Override
	public PValue valueOf(Map<String, PTemplateParIns> paras)
			throws TemplateMatchingExption {
		if (parCreators.size() > 0) {
			Object newParas[] = new Object[parCreators.size()];
			for (int i = 0; i < parCreators.size(); i++) {
				ParameterCreator creator = parCreators.get(i);
				newParas[i] = creator.create(paras);
			}
			return templateMeta.pValueOf(newParas);
		} else {
			return templateMeta.pValueOf();
		}
	}

	public List<ParameterCreator> getParCreators() {
		return parCreators;
	}
	
	@Override
	protected void doInit() throws InitMetaException {
		//父方法
		super.doInit();
		//取得Template
		PTemplateRefMatcher model = (PTemplateRefMatcher)pmodel;
		templateMeta = getPModule().pPTemplate(model.getExternalTemplateName());
		if (templateMeta == null) {
			throw new InitMetaException(getPModule(), MetaException.CODE.TEMPLATE_NOT_FOUND_ERROR, 
					model.getExternalTemplateName(), getPModule().getModuleName());
		}
		//ParameterCreator
		for (int i = 0; i < model.getParameters().size(); i++) {
			PTemplateRefMatcherPar parModel = model.getParameters().get(i);
			PTemplateParMeta parMeta = templateMeta.getParMetas().get(i);
			assert parModel.getMatcher() != null;
			PMatcherExt valueMatcher = extFactory.createMatcher(getMatcherMeta(), 
					parModel.getMatcher(), this, getPModule());
			PTemplateRefMatcherExt.ParameterCreator creator;
			if (parMeta.isTemplate()) {
				creator = new TemplateParameterCreator(parMeta, valueMatcher);
			} else {
				creator = new ValueParameterCreator(parMeta, valueMatcher);
			}
			//TODO Modified 情况没有处理
			getParCreators().add(creator);
		}
	}

	abstract public class ParameterCreator {
		protected PTemplateParMeta parMeta;
		public ParameterCreator(PTemplateParMeta parMeta) {
			this.parMeta = parMeta;
		}
		
		abstract public Object create(Map<String, PTemplateParIns> paras) 
		throws TemplateMatchingExption;
		
		public PTemplateParMeta getParMeta() {
			return parMeta;
		}
	}
	
	public class ValueParameterCreator extends ParameterCreator {
		private PMatcherExt matcher;

		public ValueParameterCreator(PTemplateParMeta parMeta, PMatcherExt matcher) {
			super(parMeta);
			this.matcher = matcher;
			assert !parMeta.isTemplate();
		}

		@Override
		public Object create(Map<String, PTemplateParIns> paras) 
		throws TemplateMatchingExption {
			return matcher.valueOf(paras);
		}
		
	}

	public class TemplateParameterCreator extends ParameterCreator {
		private PEntityTemplateExt innerTemplate;
		
		public TemplateParameterCreator(PTemplateParMeta parMeta, PMatcherExt matcher) {
			super(parMeta);
			assert parMeta.isTemplate();
			innerTemplate = new PEntityTemplateExtImpl(parMeta.getType(), matcher);
		}
		
		@Override
		public Object create(Map<String, PTemplateParIns> paras) 
		throws TemplateMatchingExption {
			PTemplateInstance ins = innerTemplate.createInstance();
			return ins;
		}
		
	}
	
	/**
	 * TODO 未完成
	 */
	public class ModifiedTemplateParameterCreator extends ParameterCreator {

		public ModifiedTemplateParameterCreator(PTemplateParMeta parMeta) {
			super(parMeta);
		}

		@Override
		public Object create(Map<String, PTemplateParIns> paras)
				throws TemplateMatchingExption {
			return null;
		}

	}

}
