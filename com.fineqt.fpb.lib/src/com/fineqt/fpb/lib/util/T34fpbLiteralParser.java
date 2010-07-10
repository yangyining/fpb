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

import com.fineqt.fpb.lib.expression.PExpressionExt;
import com.fineqt.fpb.lib.grammer.T34fpbHelper;
import com.fineqt.fpb.lib.grammer.mv.ModuleSymbol;
import com.fineqt.fpb.lib.meta.context.PModuleInitContext;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.type.PTypeExt;

public interface T34fpbLiteralParser {
	T34fpbLiteralParser INSTANCE = new T34fpbLiteralParserImpl();
	
    T34fpbHelper createNoImportElementSymbol(String moduleName, 
            PModuleParsingContext cxt) throws ParserException;
    
	ModuleSymbol parseModuleModel(String moduleName, PModuleParsingContext cxt) 
	throws ParserException;

	/**
	 * 创建模块Meta对象。
	 * @param cxt 上下文中需要包含模块所引用的所有未载入模块的模型对象。
	 */
	void createModuleExt(PModuleInitContext cxt) 
	throws InitMetaException;

	PExpressionExt parseExpression(String literal, PTypeExt baseType) 
	throws ParserException;
}
