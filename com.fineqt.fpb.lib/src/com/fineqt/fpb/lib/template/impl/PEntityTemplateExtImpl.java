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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbtemplate.PEntityTemplate;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplatePar;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.template.PEntityTemplateExt;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.template.PTemplateInstance;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.PTemplateParMeta;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PEntityTemplateExtImpl extends PTemplateExtBase 
implements PEntityTemplateExt {
	private PMatcherExt matcher;
	private PTypeExt basetype;
	private List<PTemplateParMeta> parMetas = new ArrayList<PTemplateParMeta>();
	private String name;
	/**
	 * 临时模版的生成
	 * @param basetype
	 */
	public PEntityTemplateExtImpl(PTypeExt basetype, PMatcherExt matcher) {
		super(null, basetype.getPModule());
		this.basetype = basetype;
		this.matcher = matcher;
	}
	/**
	 * 外部定义模版的生成
	 * @param model
	 * @param module
	 * @throws ElementExtCreatingException
	 */ 
	public PEntityTemplateExtImpl(PEntityTemplate model, PModuleExt module) {
		super(model, module);
		if (model == null || model.getBasetype() == null) {
			throw new IllegalArgumentException();
		}
		if (model.getMatcher() == null) {
			throw new IllegalArgumentException();
		}
		//Name
		this.name = model.getName();
	}

	@Override
	public PMatcherExt getMatcher() {
		return matcher;
	}

	@Override
	public void setMatcher(PMatcherExt matcher) {
		this.matcher = matcher;
	}

	@Override
	public List<PTemplateParMeta> getParMetas() {
		return parMetas;
	}

	@Override
	public PTemplateParMeta getParMeta(String parName) {
		for (PTemplateParMeta meta : parMetas) {
			if (meta.getParName().equals(parName)) {
				return meta;
			}
		}
		return null;
	}

	@Override
	public PTypeExt getBasetype() {
		return basetype;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getFullName() {
		return getPModule().getModuleName() + "." + name;
	}

	@Override
	public boolean matchPValue(PValue value, boolean doValidation, Object... paras) 
	throws TemplateMatchingExption{
		PTemplateInstance ins = createInstance(paras);
		return ins.match(value, doValidation);
	}


	@Override
	public PValue pValueOf(Object... paras) throws TemplateMatchingExption {
		PTemplateInstance ins = createInstance(paras);
		return ins.valueOf();
	}

	@Override
	public boolean matchValue(IValue value, Object... paras)
			throws TemplateMatchingExption {
		return matchPValue((PValue)value, true);
	}
	
	@Override
	public IValue valueOf(Object... paras) throws TemplateMatchingExption {
		return pValueOf(paras);
	}
	
	@Override
	public PTemplateInstance createInstance(Object... paras) {
		return new PTemplateInstanceImpl(paras);
	}

	@Override
	public TypeMV getBaseTypeMV() {
		return getBasetype();
	}

	@Override
	public boolean isImport() {
		return false;
	}
	
	@Override
	protected void doInit() throws InitMetaException {
		super.doInit();
		if (pmodel != null) {
			PEntityTemplate model = (PEntityTemplate)pmodel;
			//basetype
			basetype = getPModule().pPType(model.getBasetype());
			if (basetype == null) {
				throw new InitMetaException(getPModule(), 
						MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
						model.getBasetype(), getPModule().getModuleName());
			}
			basetype.init();
			//Parameter
			for (PTemplatePar par : model.getParameters()) {
				PTypeExt parType = getPModule().pPType(par.getBasetype());
				if (parType == null) {
					throw new InitMetaException(getPModule(),
							MetaException.CODE.TYPE_NOT_FOUND_ERROR, 
							par.getBasetype(), getPModule().getModuleName());
				}
				PTemplateParMeta meta = new PTemplateParMetaImpl(par.isTemplate(), parType, 
						par.getName());
				getParMetas().add(meta);
			}
			//Matcher
			matcher = extFactory.createMatcher(
					basetype, model.getMatcher(), null, getPModule());
			//依赖Matcher的初始化
			if (matcher != null) {
				matcher.init();
			}
		}
	}

	private class PTemplateInstanceImpl implements PTemplateInstance {
		private Map<String, PTemplateParIns> parameterInses;
		
		public PTemplateInstanceImpl(Object[] paras) {
			parameterInses = createParaInsMap(paras);
		}
		
		@Override
		public Map<String, PTemplateParIns> getParmeterInses() {
			return parameterInses;
		}

		@Override
		public PTemplateExt getTemplateMeta() {
			return PEntityTemplateExtImpl.this;
		}

		@Override
		public boolean match(PValue value, boolean doValidation) throws TemplateMatchingExption {
			if (matcher == null) {
				throw new NullPointerException();
			}
			if (value == null) {
				return false;
			}
			if (doValidation) {
				if (!basetype.validate(value, null)) {
					return false;
				}
			}
			return matcher.match(value, parameterInses);
		}

		@Override
		public PValue valueOf() throws TemplateMatchingExption {
			if (matcher == null) {
				throw new NullPointerException();
			}
			return matcher.valueOf(parameterInses);
		}
		
		private Map<String, PTemplateParIns> createParaInsMap(Object[] paras) {
			Map<String, PTemplateParIns> paraInses = null;
			if (parMetas.size() != paras.length) {
				throw new IllegalArgumentException();
			}
			if (parMetas.size() > 0) {
				paraInses = new HashMap<String, PTemplateParIns>();
				for (int i = 0; i < paras.length; i++) {
					PTemplateParMeta parMeta = parMetas.get(i);
					Object parObj = paras[i];
					PTemplateParIns ins;
					if (parMeta.isTemplate()) {
						if (!(parObj instanceof PTemplateInstance)) {
							throw new IllegalArgumentException();
						}
						ins = parMeta.createTmpIns((PTemplateInstance)parObj);
					} else {
						if (!(parObj instanceof PValue)) {
							throw new IllegalArgumentException();
						}
						ins = parMeta.createValueIns((PValue)parObj);
					}
					paraInses.put(parMeta.getParName(), ins);
				}
			}
			return paraInses;
		}
		
	}
}
