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

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;

abstract public class AbstractPModuleExtProxy implements PModuleExt.Registry.Proxy {
	protected String moduleName;
	protected PModuleExt moduleMeta;
	
	public AbstractPModuleExtProxy(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String getModuleName() {
		return moduleName;
	}

	@Override
	public PModuleExt resolvePModule() throws InitMetaException {
		if (moduleMeta != null)
			return moduleMeta;
		moduleMeta = doResolveModule();
		return moduleMeta;
	}

	@Override
    public PModuleExt getResolvedPModule() {
        return moduleMeta;
    }

    @Override
    public boolean setResolvedPModule(PModuleExt module) {
        moduleMeta = module;
        return true;
    }

    abstract protected PModuleExt doResolveModule() throws InitMetaException;
	
}
