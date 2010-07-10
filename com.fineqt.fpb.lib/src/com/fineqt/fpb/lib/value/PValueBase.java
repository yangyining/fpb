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

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.value.IPath;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PTypeExt;

abstract public class PValueBase implements PValue {
	protected PTypeElementMeta valueMeta;
	protected PValue parent;
	
	protected PValueBase(PTypeElementMeta valueMeta) {
		this.valueMeta = valueMeta;
	}
	
	@Override
	public PFieldExt pFieldMeta() {
		return valueMeta.asFieldMeta();
	}

	@Override
	public PTypeExt pTypeMeta() {
		return valueMeta.asTypeMeta();
	}

	@Override
	public boolean notPresent() {
		return false;
	}

//	@Override
//	public String pGetValueEncoding() {
//		if (valueMeta.getFieldMeta() != null)
//			return valueMeta.getFieldMeta().getFieldEncoding();
//		return null;
//	}
//
//	@Override
//	public String pGetValueEncodingVariant() {
//		if (valueMeta.getFieldMeta() != null)
//			return valueMeta.getFieldMeta().getFieldEncodingVariant();
//		return null;
//	}
//
//	@Override
//	public String pGetValueExtension() {
//		if (valueMeta.getFieldMeta() != null)
//			return valueMeta.getFieldMeta().getFieldExtension();
//		return null;
//	}

	@Override
	public String getLiteral() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getText() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getTextAs(IValueTextStyle style) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setText(String text) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTextAs(String text, IValueTextStyle style) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PTypeElementMeta pValueMeta() {
		return valueMeta;
	}

	@Override
	public void pValueMeta(PTypeElementMeta newMeta) {
		this.valueMeta = newMeta;
	}

	@Override
	public PValue pParent() {
		return parent;
	}

	@Override
	public void pParent(PValue parent) {
		this.parent = parent;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	@Override
	public void assignValue(IValue value) throws IncompatibleValueException {
		assignPValue((PValue)value);
	}

	@Override
	public IValue findField(IPath path) {
		return path.findField(this);
	}

	@Override
	public IValue findField(String pathDesc) throws MetaException {
		IPath path = getType().createPath(pathDesc);
		return path.findField(this);
	}

	@Override
	public IValue findField(String pathDesc, boolean fillPath)
			throws MetaException {
		IPath path = getType().createPath(pathDesc);
		return path.findField(this, fillPath);
	}

	@Override
	public IValue findField(IPath path, boolean fillPath) {
		return path.findField(this, fillPath);
	}
	
	@Override
	public boolean validate(DiagnosticChain chain) {
		//字段
		if (valueMeta.asFieldMeta() != null) {
			return valueMeta.asTypeMeta().validate(this, chain, 
					valueMeta.asFieldMeta().getConstraints());
		//列表项目
		} else if (valueMeta.asListItemMeta() != null) {
			return valueMeta.asTypeMeta().validate(this, chain, 
					valueMeta.asListItemMeta().getConstraints());
		//一般顶层对象
		} else {
			return valueMeta.asTypeMeta().validate(this, chain);
		}
	}

	//	@Override
//	public boolean equals(Object obj) {
//		//meta信息不计算在内
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		return true;
//	}
//
	@Override
	public Object clone() {
		PValueBase newObj;
		newObj = (PValueBase)valueMeta.asTypeMeta().createNormalValue();
		newObj.assignPValue(this);
		return newObj;
	}
	
	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		if (srcValue == null) {
			throw new IllegalArgumentException();
		}
		if (notPresent() || srcValue.notPresent()) {
			throw new IncompatibleValueException(this, srcValue);
		}
		if (!isCompatible(srcValue)) {
			throw new IncompatibleValueException(this, srcValue);
		}
	}
	
	@Override
	public boolean isCompatible(PValue value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		return valueMeta.asTypeMeta().isCompatible(value.pTypeMeta());
	}

	@Override
	public IType getType() {
		return pTypeMeta();
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("ptypeExt", valueMeta.asTypeMeta().getName())
		.append("pfieldExt", valueMeta.asFieldMeta()==null?null:valueMeta.asFieldMeta().getFieldName())
		.append("notPresent", false)
//		.append("parent", parent!=null?parent.getValueMeta().getTypeMeta().getName():null)
		.toString();
	}
	
	abstract public static class OmitPValueBase implements PValue {
		protected PTypeElementMeta valueMeta;
		protected PValue parent;

		protected OmitPValueBase(PTypeElementMeta valueMeta) {
			this.valueMeta = valueMeta;
		}
		
		@Override
		public PTypeElementMeta pValueMeta() {
			return valueMeta;
		}

		@Override
		public void pValueMeta(PTypeElementMeta newMeta) {
			valueMeta = newMeta;
		}

		@Override
		public PFieldExt pFieldMeta() {
			return valueMeta.asFieldMeta();
		}

		@Override
		public PTypeExt pTypeMeta() {
			return valueMeta.asTypeMeta();
		}

		@Override
		public void assignPValue(PValue value) throws IncompatibleValueException {
			throw new OmitValueException();
		}

		@Override
		public void assignValue(IValue value)
				throws IncompatibleValueException {
			throw new OmitValueException();
		}

		@Override
		public String getLiteral() {
			throw new UnsupportedOperationException();
		}

		@Override
		public String getText() {
			throw new UnsupportedOperationException();
		}

		@Override
		public String getTextAs(IValueTextStyle style) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setText(String text) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setTextAs(String text, IValueTextStyle style) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public boolean validate(DiagnosticChain chain) {
			if (valueMeta.asFieldMeta() != null) {
				return valueMeta.asTypeMeta().validate(this, null, 
						valueMeta.asFieldMeta().getConstraints());
			} else {
				return valueMeta.asTypeMeta().validate(this, null);
			}
		}

		@Override
		public PValue pParent() {
			return parent;
		}

		@Override
		public boolean isCompatible(PValue value) {
			throw new OmitValueException();
		}

		@Override
		public void pParent(PValue parent) {
			this.parent = parent;
		}

//		@Override
//		public String pGetValueEncoding() {
//			if (valueMeta.getFieldMeta() != null)
//				return valueMeta.getFieldMeta().getFieldEncoding();
//			return null;
//		}
//
//		@Override
//		public String pGetValueEncodingVariant() {
//			if (valueMeta.getFieldMeta() != null)
//				return valueMeta.getFieldMeta().getFieldEncodingVariant();
//			return null;
//		}
//
//		@Override
//		public String pGetValueExtension() {
//			if (valueMeta.getFieldMeta() != null)
//				return valueMeta.getFieldMeta().getFieldExtension();
//			return null;
//		}

		@Override
		public IValue findField(IPath path) {
			return path.findField(this);
		}

		@Override
		public IValue findField(IPath path, boolean fillPath) {
			return path.findField(this, fillPath);
		}

		@Override
		public IValue findField(String pathDesc) throws MetaException {
			IPath path = getType().createPath(pathDesc);
			return path.findField(this);
		}

		@Override
		public IValue findField(String pathDesc, boolean fillPath)
				throws MetaException {
			IPath path = getType().createPath(pathDesc);
			return path.findField(this, fillPath);
		}
		
		@Override
		public boolean notPresent() {
			return true;
		}

		@Override
		public IType getType() {
			return pTypeMeta();
		}

		@Override
		public Object clone() {
			return valueMeta.asTypeMeta().createOmitValue();
		}
		
		@Override
		public boolean equals(Object obj) {
			//meta信息不计算在内
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("ptypeExt", valueMeta.asTypeMeta().getName())
			.append("pfieldExt", valueMeta.asFieldMeta()==null?null:valueMeta.asFieldMeta().getFieldName())
			.append("notPresent", true)
//			.append("parent", parent!=null?parent.getValueMeta().getTypeMeta().getName():null)
			.toString();
		}
		
	}
}
