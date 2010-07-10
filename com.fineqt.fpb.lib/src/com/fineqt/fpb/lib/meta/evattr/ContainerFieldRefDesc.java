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

import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PContainerValue;
import com.fineqt.fpb.lib.value.PValue;

abstract public class ContainerFieldRefDesc extends FieldRefDesc {
	public ContainerFieldRefDesc(String pathDesc, PTypeExt containerType) 
	throws MetaException {
		if (!(containerType instanceof PContainerTypeExt)) {
			throw new IllegalArgumentException();
		}
		//Path
		createPPath(pathDesc, containerType);
	}

	public PValue findRefValue(PContainerValue targetValue) {
		if (targetValue == null)
			return null;
		return path.findField(targetValue);
	}
	
}