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
package com.fineqt.fpb.lib.meta.util;

import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.expression.PExpressionExt;
import com.fineqt.fpb.lib.meta.PConstantExt;
import com.fineqt.fpb.lib.meta.PEnumSetExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.PModuleParExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumSet;
import com.fineqt.fpb.lib.model.fpbmodule.PField;
import com.fineqt.fpb.lib.model.fpbmodule.PFieldEV;
import com.fineqt.fpb.lib.model.fpbmodule.PListItem;
import com.fineqt.fpb.lib.model.fpbmodule.PListItemEV;
import com.fineqt.fpb.lib.model.fpbmodule.PModulePar;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PTemplate;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PItemFieldEVExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public interface PElementExtFactory {
	PElementExtFactory INSTANCE = new PElementExtFactoryImpl();
	/**
	 * 生成一般类型定义对象。
	 * @param module
	 * @param model
	 * @return
	 */
	<T extends PTypeExt> T  createType(Class<T> cls, PModuleExt module, PType model)
	throws InitMetaException;
	/**
	 * 生成紧凑类型定义对象。
	 */
	PTypeExt createCompactType(PModuleExt module, PType model)
	throws InitMetaException;
	/**
	 * 生成模版定义对象。
	 * @param model 模型对象
	 * @return
	 */
	PTemplateExt createTemplate(PModuleExt module, PTemplate model) 
	throws InitMetaException;
	/**
	 * 生成常量定义对象。
	 */
	PConstantExt createConstant(PModuleExt module, PConstant model)
	throws InitMetaException;
	/**
	 * 生成模块参数定义对象。
	 */
	PModuleParExt createModulePar(PModuleExt module, PModulePar model) 
	throws InitMetaException;
	/**
	 * 生成枚举集合定义对象。
	 */
	PEnumSetExt createEnumSet(PModuleExt module, PEnumSet model)
	throws InitMetaException;
	/**
	 * 生成匹配器定义对象，并初始化。
	 * @param model 模型对象。
	 * @return
	 */
	PMatcherExt createMatcher(PTypeElementMeta baseType, PMatcher model, 
			PMatcherExt parentMatcher, PModuleExt ownerModule) 
	throws InitMetaException;
	/**
	 * 生成类型限制条件定义对象，并初始化。
	 * @return
	 */
	PTypeConstraintExt createTypeConstraint(PTypeExt targetType, PTypeConstraint model)
	throws InitMetaException;
	/**
	 * 生成表达式，并初始化。
	 * @return
	 */
	PExpressionExt createExpression(PTypeExt basetype, PMatcher model);
	/**
	 * 生成字段定义。
	 * @return
	 */
	PFieldExt createField(PTypeExt owner, PField model);
	/**
	 * 生成列表项目定义。 
	 * @return
	 */
	PListItemExt createListItem(PTypeExt owner, PListItem model);	
	/**
	 * 生成字段编码变量定义。 
	 * @return
	 */
	PItemFieldEVExt createFieldEV(PFieldExt owner, PFieldEV pmodel);
	/**
	 * 生成列表项目变量定义。
	 * @return
	 */
	PItemFieldEVExt createListItemEV(PListItemExt owner, PListItemEV pmodel); 
}
