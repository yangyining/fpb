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

import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PUnionTypeExt;

public class SimpleUnionValue extends PContainerValueBase implements PUnionValue {
	protected PValue presentVariant;
	
	public static PUnionValue createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitPUnionValue(meta);
		} else {
			return new SimpleUnionValue(meta, false);
		}
	}
	
	public static PUnionValue createEmptyValue(PTypeElementMeta meta) {
		return new SimpleUnionValue(meta, true);
	}
	
	protected SimpleUnionValue(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//生成默认有效值
			int defaultPresentId = getUnionTypeExt().getDefaultPresentFieldID();
			if (defaultPresentId >= 0) {
				presentVariant = getUnionTypeExt().getFieldMeta(defaultPresentId).createDefaultValue();
			}
		}
	}

	protected PUnionTypeExt getUnionTypeExt() {
		return (PUnionTypeExt)pTypeMeta();
	}
	
	@Override
	public PValue pGetPresentVariant() {
		return presentVariant;
	}

	@Override
	public String getPresentVariantName() {
		if (presentVariant != null) {
			return presentVariant.pFieldMeta().getFieldName();
		}
		return null;
	}

	@Override
	public String[] getVariantNames() {
		return getContainerTypeExt().getFieldNames();
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		if (!(srcValue instanceof PUnionValue)) {
			throw new IncompatibleValueException(this, srcValue);
		}
		PUnionValue srcUnionValue = (PUnionValue)srcValue;
		if (srcUnionValue.pGetPresentVariant() == null) {
			presentVariant = null;
		} else {
			pSetFieldByName(srcUnionValue.getPresentVariantName(), srcUnionValue.pGetPresentVariant()); 
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
		PUnionValue srcUnionValue = (PUnionValue)obj;
		String srcPresentVariantName = srcUnionValue.getPresentVariantName();
		if (srcPresentVariantName != null) {
			if (!srcPresentVariantName.equals(getPresentVariantName())) {
				return false;
			}
		} else {
			if (getPresentVariantName() != null) {
				return false;
			}
		}
		PValue srcPresentVariant = srcUnionValue.pGetPresentVariant();
		if (srcPresentVariant != null) {
			if (!srcPresentVariant.equals(presentVariant)) {
				return false;
			}
		} else {
			if (presentVariant != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public PValue pGetFieldByID(int fieldId) {
		if (presentVariant == null)
			return null;
		if (fieldId == presentVariant.pFieldMeta().getFieldID()) {
			return presentVariant;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int newFieldId, PValue newValue) {
		PFieldExt newFieldMeta = getContainerTypeExt().getFieldMeta(newFieldId);
		if (newFieldMeta == null)
			return;
		//没有已存在的变量
		if (presentVariant == null) {
			presentVariant = newFieldMeta.createOmitValue();
		//有已存在的变量
		} else if (presentVariant != null) {
			int curFieldId = presentVariant.pFieldMeta().getFieldID();
			//与现有的不相同
			if (curFieldId != newFieldId) {
				presentVariant.pParent(null);
				presentVariant = newFieldMeta.createOmitValue();
			}
		} 
		//赋值
		presentVariant = assignNewFieldValue(newFieldId, presentVariant, newValue);
	}

	@Override
	public IValue getPresentVariant() {
		return pGetPresentVariant();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.appendSuper(super.toString())
			.append("presentVariantName", getPresentVariantName())
			.append("presentVariant", presentVariant)
			.toString();
	}
	
	public static class OmitPUnionValue extends OmitPContainerValueBase implements PUnionValue {

		public OmitPUnionValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public String getPresentVariantName() {
			throw new OmitValueException();
		}

		@Override
		public String[] getVariantNames() {
			throw new OmitValueException();
		}

		@Override
		public PValue pGetPresentVariant() {
			throw new OmitValueException();
		}
	
		@Override
		public IValue getPresentVariant() {
			throw new OmitValueException();
		}
		
	}
}
