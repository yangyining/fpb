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
package com.fineqt.fpb.lib.value;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.type.PFieldExt;

abstract public class PRecordSetValueBase extends PContainerValueBase 
implements PRecordSetValue {


	protected PRecordSetValueBase(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	@Override
	public void setFieldOmitted(String fieldName) {
		PFieldExt meta = getContainerTypeExt().getFieldMeta(fieldName);
		if (meta != null) {
			pSetFieldByID(meta.getFieldID(), meta.getType().createOmitValue());
		}
	}
	
	@Override
	public void setFieldOmitted(int fieldID) {
		PFieldExt meta = getContainerTypeExt().getFieldMeta(fieldID);
		if (meta != null) {
			pSetFieldByID(fieldID, meta.getType().createOmitValue());
		}
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		if (!(srcValue instanceof PContainerValue)) {
			throw new IncompatibleValueException(this, srcValue);
		}
		PContainerValue srcContainerValue = (PContainerValue)srcValue;
		for (int i = 0; i < getContainerTypeExt().getFieldSize(); i++) {
			PValue newValue = srcContainerValue.pGetFieldByID(i);
			pSetFieldByID(i, newValue);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PRecordSetValueBase srcContainerValue = (PRecordSetValueBase)obj;
		if (srcContainerValue.getContainerTypeExt().getFieldSize() != 
			getContainerTypeExt().getFieldSize()) {
			return false;
		}
		for (int i = 0; i < getContainerTypeExt().getFieldSize(); i++) {
			PValue srcValue = srcContainerValue.pGetFieldByID(i);
			PValue dstValue = pGetFieldByID(i);
			if (!dstValue.equals(srcValue)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String[] getFieldNames() {
		return getContainerTypeExt().getFieldNames();
	}

	@Override
	public int getFieldSize() {
		return getContainerTypeExt().getFieldSize();
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
		builder.appendSuper(super.toString());
		String[] names = getFieldNames();
		for (String name : names) {
			builder.append(name, pGetFieldByName(name));
		}
		return builder.toString();
	}
	
	protected static class OmitPRecordSetValueBase extends OmitPContainerValueBase 
	implements PRecordSetValue {

		public OmitPRecordSetValueBase(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public int getFieldSize() {
			return getContainerTypeExt().getFieldSize();
		}

		@Override
		public String[] getFieldNames() {
			return getContainerTypeExt().getFieldNames();
		}

		@Override
		public void setFieldOmitted(String fieldName) {
			throw new OmitValueException();
		}

		@Override
		public void setFieldOmitted(int fieldID) {
			throw new OmitValueException();
		}
		
	}
}
