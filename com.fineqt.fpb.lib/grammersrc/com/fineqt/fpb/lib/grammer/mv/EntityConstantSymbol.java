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

import com.fineqt.fpb.lib.model.fpbmodule.PEntityConstant;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.modelview.ConstantMV;
import com.fineqt.fpb.lib.modelview.ModuleMV;

public class EntityConstantSymbol extends EntityModuleElementSymbolBase 
implements ConstantMV {
	private PEntityConstant model;
	
	public EntityConstantSymbol(ModuleMV module, String name,
			String baseTypeName) {
		super(module, name, baseTypeName);
	}
	
	@Override
	public Type getModuleElementType() {
		return Type.CONSTANT;
	}

	public PEntityConstant getModel() {
		return model;
	}

	public void setModel(PEntityConstant model) {
		this.model = model;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		PModule pmodule = cxt.getModuleSymbol().getModel();
		//加入模块
		pmodule.getConstants().add(model);
		//runtime propertyList
		if (runtimePropertyList != null) {
			String value;
			//ElementID
			value = runtimePropertyList.getProperty(ELEMENT_ID_PRP);
			if (value != null) {
				try {
					int id = Integer.parseInt(value);
					model.setConstantID(id);
				} catch (NumberFormatException e) {
					//忽略ID设置
				}
			}
		}
		//父方法
		super.doInitModel(cxt);
	}
	
}