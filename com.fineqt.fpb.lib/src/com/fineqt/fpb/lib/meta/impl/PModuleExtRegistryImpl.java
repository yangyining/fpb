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
package com.fineqt.fpb.lib.meta.impl;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.meta.PFactoryExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.type.PTypeEVExtFactory;

public class PModuleExtRegistryImpl implements PModuleExt.Registry {
	private Map<String, Proxy> proxys = new HashMap<String, Proxy>();
	private EnumMap<EncodingType, PTypeEVExtFactory> ptypeEvExtFactories = 
		new EnumMap<EncodingType, PTypeEVExtFactory>(EncodingType.class);
	
	@Override
	synchronized public Collection<String> allModuleNames() {
		return proxys.keySet();
	}

	@Override
	synchronized public void register(Proxy proxy) {
		proxys.put(proxy.getModuleName(), proxy);
	}

	@Override
	public PTypeEVExtFactory getTypeEVExtFactory(EncodingType encoding) {
		return ptypeEvExtFactories.get(encoding);
	}

	@Override
	public void registerTypeEVExtFactory(PTypeEVExtFactory factory) {
		ptypeEvExtFactories.put(factory.supportEncoding(), factory);
	}

	@Override
	synchronized public PModuleExt resolvePModule(String moduleName) throws InitMetaException {
		Proxy proxy = proxys.get(moduleName);
		if (proxy == null) {
			return null;
		}
		return proxy.resolvePModule();
	}

	@Override
	synchronized public PModuleExt getResolvedPModule(String moduleName) {
        Proxy proxy = proxys.get(moduleName);
        if (proxy == null) {
            return null;
        }
        return proxy.getResolvedPModule();
    }

	
    @Override
    public boolean setResolvedPModule(PModuleExt module) {
        if (module == null) {
            throw new IllegalArgumentException();
        }
        Proxy proxy = proxys.get(module.getModuleName());
        if (proxy == null) {
            return false;
        }
        return proxy.setResolvedPModule(module);
    }

    @Override
	synchronized public PFactoryExt resolvePFactory(String moduleName)
			throws InitMetaException {
		PModuleExt module = resolvePModule(moduleName);
		if (module == null)
			return null;
		return module.pPFactory();
	}

    @Override
    public ModuleResource getResource(String moduleName) {
        Proxy proxy = proxys.get(moduleName);
        if (proxy == null) {
            return null;
        }
        return proxy.getResource();
    }

    @Override
	public IFactory resolveFactory(String moduleName) {
		return resolvePFactory(moduleName);
	}

	@Override
	public IModule resolveModule(String moduleName) {
		return resolvePModule(moduleName);
	}

}
