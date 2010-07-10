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
package com.fineqt.fpb.lib.system;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.fineqt.fpb.lib.model.fpbmodule.PModule;

public interface ResourceManager {
	ResourceManager INSTANCE = new ResourceManagerImpl();
	/**
	 * 将指定Module模型对象以EMF的Resource形式保存。如果已经存在，则覆盖原来的对象。
	 * @param module
	 */
	void saveModule(PModule module);
	/**
	 * 取得指定Module的模型对象。需要事先通过saveModule()方法来保存。
	 * @param moduleName
	 * @return
	 */
	PModule getModule(String moduleName);
	
	ResourceSet getResourceSet();
	
	Resource getModuleResource(String moduleName);	
}
