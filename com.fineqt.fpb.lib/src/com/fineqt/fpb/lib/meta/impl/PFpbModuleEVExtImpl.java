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

import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PFpbModuleEVAttrs;
import com.fineqt.fpb.lib.meta.PFpbModuleEVExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.evattr.PFpbModuleEVAttrsImpl;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.property.PPropertyListExt;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbModuleEV;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeEVAttrs;
import com.fineqt.fpb.lib.type.PTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class PFpbModuleEVExtImpl extends PElementExtBase 
implements PFpbModuleEVExt {
	private PFpbModuleEVAttrs evAttrs;
	
	public PFpbModuleEVExtImpl(PFpbModuleEV pmodel, PModuleExt owner) {
		super(pmodel, owner);
	}

	@Override
	public PModuleExt getOwner() {
		return pmoduleExt;
	}

	private PFpbModuleEV getFpbModel() {
		return (PFpbModuleEV)pmodel;
	}

	@Override
	public ByteOrder getByteOrder() {
		if (evAttrs != null)
			return evAttrs.getByteOrder();
		return ByteOrder.NONE;
	}
	
	@Override
	public EncodingType getEncodingType() {
		return EncodingType.FPB;
	}

	@Override
	public void init() throws InitMetaException {
		if ( getFpbModel() != null) {
			//Property List
			PPropertyListExt prpListExt = new PPropertyListExt(getFpbModel().getPrpList(), 
					new PTypeElementMeta(){

						@Override
						public PFieldExt asFieldMeta() {
							return null;
						}

						@Override
						public PListItemExt asListItemMeta() {
							return null;
						}

						@Override
						public PModuleExt getPModule() {
							return getOwner();
						}

						@Override
						public PTypeExt asTypeMeta() {
							return null;
						}

                        @Override
                        public PTypeConstraintStorage getConstraints() {
                            return null;
                        }

                        @Override
                        public PTypeEVAttrs getPriorityAttrs() {
                            return null;
                        }

                        @Override
                        public PTypeEVExt getPriorityVariant() {
                            return null;
                        }

                        @Override
                        public boolean isOptional() {
                            return false;
                        }
						
			});
			prpListExt.init();
			//EV Attrs
			evAttrs = new PFpbModuleEVAttrsImpl(prpListExt, this); 
		}
	}

}
