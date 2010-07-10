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
package com.fineqt.fpb.lib.meta;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.List;

import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.meta.context.PModuleInitContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.impl.PModuleExtRegistryImpl;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.modelview.ModuleMV;
import com.fineqt.fpb.lib.template.PTemplateExt;
import com.fineqt.fpb.lib.type.PTypeEVExtFactory;
import com.fineqt.fpb.lib.type.PTypeExt;

public interface PModuleExt extends IModule, BuiltinModule, ModuleMV{
	
    void creatModuleContents(PModule model, PModuleInitContext cxt) 
    throws InitMetaException;
    
    void resolveReference(PModuleInitContext cxt) throws InitMetaException;
    
	void initModule(PModuleInitContext cxt) throws InitMetaException;
	
    void initModuleElements(PModuleInitContext cxt)  throws InitMetaException;
    
	ByteOrder pByteOrder();
	EncodingType pEncodingType();
	/**
	 * 根据模块名称来取得被导入模块。
	 * @param moduleName
	 * @return
	 */
	PModuleExt pImportedModule(String moduleName);
	/**
	 * 取得所有被导入的模块。
	 * @return
	 */
	Collection<PModuleExt> pImportedModules();
	/**
	 * 取得该模块相对应的工厂对象。
	 * @return
	 */
	PFactoryExt pPFactory();
	/**
	 * 设置该模块相对应的工厂对象。
	 * @param factory
	 */
	void pPFactory(PFactoryExt factory);
	/**
	 * 取得对应编码的PTypeEVExt工厂对象。
	 * @param encoding 目标编码
	 * @return 没有则返回null。
	 */
	PTypeEVExtFactory pTypeEVExtFactory(EncodingType encoding);
	/**
	 * 设置PTypeEVExt工厂对象。如果对应编码的工厂已有，则被该对象覆盖。
	 * @param factory
	 */
	void pTypeEVExtFactory(PTypeEVExtFactory factory);
	/**
	 * 通过类型编号来取得类型定义。
	 * @param typeID
	 * @return 不存在则返回null。
	 */
	PTypeExt pPType(int typeID);
	/**
	 * 通过名称来取得类型定义。可以使用module.type的全称。
	 * @param typeName 类型定义名。如果是Import类型并且在该Module内有同名类型的话，需要用module.type
	 * 格式来取得。
	 * @return 不存在则返回null。
	 */
	PTypeExt pPType(String typeName);
	/**
	 * 取得模块内可以访问的所有类型。
	 * @return
	 */
	List<PTypeExt> pTypes();
	/**
	 * 通过模板编号来取得模板定义。
	 * @param templateID
	 * @return 不存在则返回null。
	 */
	PTemplateExt pPTemplate(int templateID);
	/**
	 * 通过模板名称来取得模板定义。
	 * @param templateName
	 * @return 不存在则返回null。
	 */
	PTemplateExt pPTemplate(String templateName);
	/**
	 * 取得所有的模版定义。
	 * @return
	 */
	List<PTemplateExt> pTemplates();
	/**
	 * 根据常量编号取得常量的定义。
	 * @param constantID
	 * @return
	 */
	PConstantExt pPConstant(int constantID);
	/**
	 * 根据常量名称取得常量的定义。
	 * @param constantName
	 * @return
	 */
	PConstantExt pPConstant(String constantName);
	/**
	 * 取得所有常量定义。
	 * @return
	 */
	List<PConstantExt> pConstants();
	/**
	 * 根据常量编号取得模块参数的定义。
	 * @param moduleParID
	 * @return
	 */
	PModuleParExt pPModulePar(int moduleParID);
	/**
	 * 根据常量名称取得模块参数的定义。
	 * @param moduleParName
	 * @return
	 */
	PModuleParExt pPModulePar(String moduleParName);
	/**
	 * 取得所有模块参数定义。
	 * @return
	 */
	List<PModuleParExt> pModulePars();
	/**
	 * 根据常量编号取得枚举集合的定义。
	 * @param constantID
	 * @return
	 */
	PEnumSetExt pPEnumSet(int enumSetID);
	/**
	 * 根据常量名称取得枚举集合的定义。
	 * @param EnumSetName
	 * @return
	 */
	PEnumSetExt pPEnumSet(String enumSetName);
	/**
	 * 取得所有枚举集合定义。
	 * @return
	 */
	List<PEnumSetExt> pEnumSets();
	/**
	 * 取得该模块的编码属性Meta对象。
	 */
	PModuleEVExt pEVMeta();
	
	/**
	 * 加入事件监听器
	 * @param lsn
	 */
	void addEventListener(PModuleExtEventListener lsn);
	/**
	 * 删除事件监听器
	 * @param lsn
	 * @return 删除是否成功
	 */
	boolean removeEventListener(PModuleExtEventListener lsn);
	
	/**
 	 * 模块登记器
	 */
	interface Registry extends IModuleRegistry {
		Registry PINSTANCE = new PModuleExtRegistryImpl();
		
		interface ModuleResource {
		    Reader createReader() throws IOException;
		    String getName();
		}
		
		/**
		 * 模块代理。
		 */
		interface Proxy {
			/**
			 * 取得代理模块名称。
			 * @return
			 */
			String getModuleName();
			/**
			 * 解决代理模块。如果该模块还没有初始化则对其进行初始化。
			 * @return
			 * @throws InitMetaException
			 */
			PModuleExt resolvePModule() throws InitMetaException;
	        /**
	         * 取得已经解决的模块。
	         * 没有则返回null。
	         * @return
	         */
	        PModuleExt getResolvedPModule();
	        /**
	         * 设置在外部已经解决的模块。
	         * @param module
	         */
	        boolean setResolvedPModule(PModuleExt module);
	        /**
	         * 取得资源描述。
	         * @return
	         */
	        ModuleResource getResource();
		}
		PTypeEVExtFactory getTypeEVExtFactory(EncodingType encoding);
		void registerTypeEVExtFactory(PTypeEVExtFactory factory);
		/**
		 * 登记指定模块的代理。
		 * @param proxy
		 */
		void register(Proxy proxy);
		/**
		 * 解决指定模块。
		 * 如果没有登记则返回null。
		 * @param moduleName
		 * @return
		 * @throws InitMetaException
		 */
		PModuleExt resolvePModule(String moduleName) throws InitMetaException;
		/**
		 * 取得已经解决的模块。
		 * 没有则返回null。
		 * @param moduleName
		 * @return
		 */
		PModuleExt getResolvedPModule(String moduleName);
        /**
         * 取得资源描述。
         * @return
         */
        ModuleResource getResource(String moduleName);
        /**
         * 设置在外部已经解决的模块。
         * @param module
         */
        boolean setResolvedPModule(PModuleExt module);
		/**
		 * 解决指定模块的工厂对象。
		 * 首先会解决对应模块对象。
		 * @param moduleName
		 * @return
		 * @throws InitMetaException
		 */
		PFactoryExt resolvePFactory(String moduleName) throws InitMetaException;
		
	}
	//为了引用方便
	interface FPBPKG_L extends FpbmodulePackage.Literals {
	}
	
	//为了引用方便
	interface FPBPKG extends FpbmodulePackage {
	}
	
}
