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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.fineqt.fpb.lib.model.fpbmodule.DocumentRoot;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmoduleFactory;
import com.fineqt.fpb.lib.model.fpbmodule.FpbmodulePackage;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.util.FpbmoduleResourceFactoryImpl;

public class ResourceManagerImpl implements ResourceManager {
	private ResourceSet resourceSet;
	
	{
		resourceSet = new ResourceSetImpl();
		// Register the appropriate resource factory to handle all file extentions.
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
			("*", 
			 new FpbmoduleResourceFactoryImpl());

		// Register the package to ensure it is available during loading.
		resourceSet.getPackageRegistry().put
			(FpbmodulePackage.eNS_URI, 
			FpbmodulePackage.eINSTANCE);
	}
	
	@Override
	public PModule getModule(String moduleName) {
		Resource resource = getModuleResource(moduleName);
		if (resource == null)
			return null;
		if (resource.getContents().size() <= 0) {
			return null;
		}
		DocumentRoot root = (DocumentRoot)resource.getContents().get(0);
		return root.getPModule();
	}

	@Override
	public void saveModule(PModule module) {
		assert module.getName() != null;
		Resource resource = getModuleResource(module.getName());
		if (resource == null) {
			resource = resourceSet.createResource(URI.createURI(module.getName()));			
		}
		assert resource != null;
		resource.getContents().clear();
		DocumentRoot root = FpbmoduleFactory.eINSTANCE.createDocumentRoot();
		root.setPModule(module);
		resource.getContents().add(root);
	}

	@Override
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Resource getModuleResource(String moduleName) {
		return resourceSet.getResource(URI.createURI(moduleName), false);
	}
}
