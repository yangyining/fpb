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
package com.fineqt.fpb.lib.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;

import com.fineqt.fpb.lib.expression.PExpressionExt;
import com.fineqt.fpb.lib.grammer.T34fpbHelper;
import com.fineqt.fpb.lib.grammer.mv.ModuleSymbol;
import com.fineqt.fpb.lib.meta.PFactoryExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.PModuleInitContext;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContext;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContextImpl;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.SimplePFactoryExt;
import com.fineqt.fpb.lib.meta.impl.SimplePModuleExt;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.type.PTypeEVExtFactory;
import com.fineqt.fpb.lib.type.PTypeExt;

public class T34fpbLiteralParserImpl implements T34fpbLiteralParser{

	private PFactoryExt createPFactoryExt(PModule module) throws InitMetaException {
		PFactoryExt result;
		String className = module.getFactoryJavaClass();
		if (className != null) {
			try {
				Class<?> javaClass = Class.forName(className);
				@SuppressWarnings("unchecked")
				Class<PFactoryExt> factoryClass = (Class<PFactoryExt>)javaClass.asSubclass(
						PFactoryExt.class);
				result = factoryClass.newInstance();
			} catch (Exception e) {
				throw new InitMetaException(null, MetaException.CODE.LOAD_JAVA_CLASS_ERROR, 
				        e, className);
			}
		} else {
			result = new SimplePFactoryExt();
		}
		return result;
	}
	
	private PTypeEVExtFactory[] createTypeEVExtFactory(PModule module) throws InitMetaException {
		List<PTypeEVExtFactory> list = new ArrayList<PTypeEVExtFactory>();
		if (module.getTypeEvFactoryJavaClass() != null) {
			String[] descs = module.getTypeEvFactoryJavaClass().split(
					FpbConstants.SIMPLE_PROPERTY_DELIMITER);
			for (int i = 0; i < descs.length; i++) {
			    String className = descs[i].trim();
				try {
					Class<?> javaClass = Class.forName(className);
					@SuppressWarnings("unchecked")
					Class<PTypeEVExtFactory> factoryClass = (Class<PTypeEVExtFactory>)javaClass.asSubclass(
							PTypeEVExtFactory.class);
					list.add(factoryClass.newInstance());
				} catch (Exception e) {
	                throw new InitMetaException(null, MetaException.CODE.LOAD_JAVA_CLASS_ERROR, 
	                        e, className);
				}
			}
		} 
		return list.toArray(new PTypeEVExtFactory[list.size()]);
	}
	
	
    private PModuleExt createModuleExtContents(PModule moduleModel, PModuleInitContext cxt)
            throws InitMetaException {
        //PFactoryExt
        PFactoryExt factory = createPFactoryExt(moduleModel);
        
        //TypeEVExtFactory
        PTypeEVExtFactory evFactories[] = createTypeEVExtFactory(moduleModel);
        
        //PMoudleExt
        PModuleExt result;
        if (moduleModel.getModuleJavaClass() != null) {
            try {
                Class<?> javaClass = Class.forName(moduleModel.getModuleJavaClass());
                @SuppressWarnings("unchecked")
                Class<PModuleExt> moduleClass = (Class<PModuleExt>)javaClass.asSubclass(
                        PModuleExt.class);
                result = moduleClass.newInstance();
            } catch (Exception e) {
                throw new InitMetaException(null, MetaException.CODE.UNKOWN_ERROR, e);
            }
        } else {
            result = new SimplePModuleExt();
        }
        //factory
        assert factory != null;
        result.pPFactory(factory);
        //typeEVExtFactory
        for (PTypeEVExtFactory typeEVExtFactory : evFactories) {
            result.pTypeEVExtFactory(typeEVExtFactory);
        }
        //生成模块内的元素对象
        result.creatModuleContents(moduleModel, cxt);
        return result;
    }

    @Override
    public void createModuleExt(PModuleInitContext cxt) 
	throws InitMetaException {
	    if (cxt.getModelsForInit().size() == 0) {
	        throw new IllegalArgumentException();
	    }
	    //创建所有相关模块对象及其内部的模块元素
	    for (PModule moduleModel : cxt.getModelsForInit()) {
            PModuleExt meta = createModuleExtContents(moduleModel, cxt);
            cxt.getResultList().add(meta);
        }
	    //解决模块间的引用
	    for (PModuleExt meta : cxt.getResultList()) {
            meta.resolveReference(cxt);
        }
	    //模块本身的初始化
        for (PModuleExt meta : cxt.getResultList()) {
            meta.initModule(cxt);
        }
        //模块内元素的初始化
        for (PModuleExt meta : cxt.getResultList()) {
            meta.initModuleElements(cxt);
        }
    }

	@Override
	public T34fpbHelper createNoImportElementSymbol(String moduleName, 
	        PModuleParsingContext cxt) throws ParserException {
        PModuleExt.Registry.ModuleResource resource = PModuleExt.Registry.PINSTANCE
                .getResource(moduleName);
        if (resource == null) {
            throw new ParserException(new MetaException(
                    MetaException.CODE.MODULE_NOT_FOUND_REGISTRY_ERROR, null, moduleName));
        }
        T34fpbHelper helper;
        try {
            // 生成的Reader在T34fpbParser内部会被自动释放
            Reader moduleReader = resource.createReader();
            helper = T34fpbHelper.createT34fpbHelper(moduleReader, cxt, resource
                    .getName());
        } catch (IOException e1) {
            throw new ParserException(e1);
        }
        // 准备
        helper.prepareCreatingSymbol();
        // 生成非Import的元素Symbol，并且递归调用被Import的模块
        helper.createNoImportElementSymbol();
        return helper;
	}
	
    @Override
	public ModuleSymbol parseModuleModel(String moduleName, PModuleParsingContext cxt) 
	throws ParserException {
	    // 生成非Import的元素Symbol，并且递归调用被Import的模块
        T34fpbHelper helper = createNoImportElementSymbol(moduleName, cxt);
        List<ModuleSymbol> symbols = cxt.getResultList();
        // 生成Import元素
        for (ModuleSymbol moduleSymbol : symbols) {
            helper = (T34fpbHelper) moduleSymbol.getParserHelper();
            helper.createImportElemenSymbol();
        }
        // 解决各种元素引用
        for (ModuleSymbol moduleSymbol : symbols) {
            helper = (T34fpbHelper) moduleSymbol.getParserHelper();
            helper.resolveReference();
        }
        // 验证模型元素完整性
        for (ModuleSymbol moduleSymbol : symbols) {
            helper = (T34fpbHelper) moduleSymbol.getParserHelper();
            helper.validateModuleElements();
        }
        // 检查是否有错
        List<String> allMsgs = new ArrayList<String>();
        for (ModuleSymbol moduleSymbol : symbols) {
            helper = (T34fpbHelper) moduleSymbol.getParserHelper();
            allMsgs.addAll(helper.getGrammerErrorMsgs());
        }
        if (allMsgs.size() > 0) {
            throw new ParserException(allMsgs);
        }
        // 生成和初始化Model信息
        for (ModuleSymbol moduleSymbol : symbols) {
            helper = (T34fpbHelper) moduleSymbol.getParserHelper();
            // 生成Model信息
            helper.getParser().reset();
            // 准备
            helper.prepareCreatingModuleModel();
            // 执行
            helper.createModuleModel();
            // 初始化
            helper.initCreatedModuleModel();
        }
        return cxt.getResult(moduleName);
	}
	
	@Override
	public PExpressionExt parseExpression(String literal, PTypeExt baseType)
			throws ParserException {
	    PModuleParsingContext cxt = new PModuleParsingContextImpl();
		T34fpbHelper helper = T34fpbHelper.createT34fpbHelper(new StringReader(literal), 
                cxt, null);
		helper.setModuleMV(baseType.getModuleMV());
		PMatcher matcher;
		//压入基类型名称
		helper.getParser().pushTypeScope(baseType.getFullName());
		try {
			try {
				matcher = helper.getParser().expression();
				//检查语法错误
				if (helper.getGrammerErrorMsgs().size() > 0) {
					ParserException exp = new ParserException();
					exp.getGrammerErrorMsgs().addAll(helper.getGrammerErrorMsgs());
					throw exp;
				}
			} catch (RecognitionException e) {
				ParserException exp = new ParserException(e);
				exp.getGrammerErrorMsgs().addAll(helper.getGrammerErrorMsgs());
				throw exp;
			}
		} finally {
		    helper.getParser().popTypeScope();
		}
		assert matcher != null;
		//生成Expression对象
		try {
			return PElementExtFactory.INSTANCE.createExpression(baseType, matcher);
		} catch (InitMetaException e) {
			throw new ParserException(e);
		}
	}

}
