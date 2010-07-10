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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 
 * @author JiangMin
 *
 */
public class SimpleScopeContext implements ScopeContext{
	protected Map<String, Object> attributes = new ConcurrentHashMap<String, Object>();
	protected ScopeContext parent;

	public SimpleScopeContext(ScopeContext parent) {
		this.parent = parent;
	}
	
	@Override
	public String[] allAttributeNames(boolean deep) {
		//自分のみ
		if (!deep) {
			return attributes.keySet().toArray(new String[attributes.keySet().size()]);
		}
		//親のみ
		else {
			Set<String> names = new HashSet<String>();
			//自分の属性
			String[] ite = attributes.keySet().toArray(new String[attributes.keySet().size()]);
			for (String str : ite) {
				names.add(str);
			}
			//親の属性
			if (parent != null) {
				ite = parent.allAttributeNames(true);
				for (String str : ite) {
					names.add(str);
				}
			}
			return names.toArray(new String[names.size()]);
		}
	}

	@Override
	public boolean containsAttribute(String name) {
		return containsAttribute(name, true);
	}

	@Override
	public Object getAttribute(String name) {
		return getAttribute(name, true);
	}

	@Override
	public boolean containsAttribute(String name, boolean deep) {
		if (attributes.containsKey(name)) {
			return true;
		}
		else if (deep && parent != null) {
			return parent.containsAttribute(name, true);
		}
		return false;
	}

	@Override
	public Object getAttribute(String name, boolean deep) {
		Object value;
		value = attributes.get(name);
		if (value != null) {
			return value;
		}
		else if (deep && parent != null) {
			return parent.getAttribute(name, true);
		}
		return null;
	}

	@Override
	public void removeAttribute(String name) {
		attributes.remove(name);
	}

	@Override
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	@Override
	public ScopeContext getParent() {
		return parent;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.append("attributes", attributes.keySet().toArray());
		return builder.toString();
	}

}
