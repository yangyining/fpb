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
package com.fineqt.fpb.lib.constraint;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PCompoundConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PValue;

public class PCompoundConstraintExt extends PTypeConstraintExtBase {
	private List<PTypeConstraintExt> children = new ArrayList<PTypeConstraintExt>();
	
	public PCompoundConstraintExt(PCompoundConstraint pmodel, PTypeExt targetType) {
		super(pmodel, targetType);
		for (PTypeConstraint consModel : pmodel.getChildren()) {
			PTypeConstraintExt meta = extFactory.createTypeConstraint(targetType, 
					consModel);
			children.add(meta);
		}
	}

	@Override
	public List<PTypeConstraintExt> getChildren() {
		return children;
	}

	@Override
	public boolean isCompound() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public boolean validate(PValue value, DiagnosticChain chain) {
		for (PTypeConstraintExt cons : children) {
			if (!cons.validate(value, chain)) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected void doInit() throws InitMetaException {
		//包含限制的初始化
		for (int i = 0; i < children.size(); i++) {
			children.get(i).init();
		}
		//父方法
		super.doInit();
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("children", children)
			.toString();
	}
	
}
