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
package com.fineqt.fpb.lib.meta.evattr;

import com.fineqt.fpb.lib.meta.evattr.PPath.PPathFragment;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PTypeExt;

public class TypeFieldRefDesc extends ContainerFieldRefDesc {
	PPathFragment firstFrag;

	public TypeFieldRefDesc(String pathDesc,
			PTypeExt parentType) throws MetaException {
		super(pathDesc, parentType);
		assert path.getFragments().length > 0;
		firstFrag =  path.getFragments()[0];
	}

	@Override
	public Type getType() {
		return Type.TYPE_FIELD;
	}

	public PFieldExt getDenpendedField() {
		return firstFrag.getFieldMeta();
	}
}
