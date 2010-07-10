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

import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.type.PEnumeratedItemExt;
import com.fineqt.fpb.lib.type.PEnumeratedTypeExt;
/**
 * 在Enumerated的项目数为0时无法设定初始值，所以只能设为Omit。这样的话当枚举项目没有选中时认为是omit，也
 * 就没有必要定义独立的Omit类了。
 * @author JiangMin
 *
 */
public class SimpleEnumeratedValue extends PPrimitiveValueBase implements PEnumeratedValue {
	private PEnumeratedItemExt itemExt;
	
	public static PEnumeratedValue createValue(PTypeElementMeta valueMeta, boolean notPresent) {
		PEnumeratedValue result = new SimpleEnumeratedValue(valueMeta);
		//默认使用第一个Enum项目
		if (!notPresent) {
			PEnumeratedTypeExt type = (PEnumeratedTypeExt)valueMeta.asTypeMeta();
			if (type.getItemSize() > 0) {
				result.setEnumByID(0);
			}
		}
		return result;
	}
	
	protected SimpleEnumeratedValue(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	protected PEnumeratedTypeExt getEnumeratedTypeExt() {
		return (PEnumeratedTypeExt)pTypeMeta().getRootType();
	}
	
	@Override
	public String getLiteral() {
		if (itemExt == null) {
			return OMIT_LITERAL;
		}
		return getText();
	}

	@Override
	public String getText() {
		if (itemExt == null) {
			throw new OmitValueException();
		}
		return itemExt.getEnumName();
	}

	@Override
	public void setText(String text) {
		setEnumByName(text);
	}

	@Override
	public int getEnumID() {
		if (itemExt == null) {
			throw new OmitValueException();
		}
		return itemExt.getEnumID();
	}

	@Override
	public String getEnumName() {
		if (itemExt == null) {
			throw new OmitValueException();
		}
		return itemExt.getEnumName();
	}

	@Override
	public int getEnumValue() {
		if (itemExt == null) {
			throw new OmitValueException();
		}
		return itemExt.getEnumValue();
	}

	@Override
	public void setEnumByID(int enumID) {
		PEnumeratedItemExt targetItem = getEnumeratedTypeExt().getItemByID(enumID);
		if (targetItem != null) {
			itemExt = targetItem;
		}
	}

	@Override
	public void setEnumByName(String enumName) {
		PEnumeratedItemExt targetItem = getEnumeratedTypeExt().getItemByName(enumName);
		if (targetItem != null) {
			itemExt = targetItem;
		}
	}

	@Override
	public void setEnumByValue(int enumValue) {
		PEnumeratedItemExt targetItem = getEnumeratedTypeExt().getItemByValue(enumValue);
		if (targetItem != null) {
			itemExt = targetItem;
		}
	}

	@Override
	public boolean notPresent() {
		return itemExt == null;
	}

	public void assignPValue(PValue target) {
		if (!isCompatible(target)) {
			throw new IncompatibleValueException(this, target);
		}
		PEnumeratedValue entity = (PEnumeratedValue)target;
		if (entity.notPresent()) {
			itemExt = null;
		}  else {
			itemExt = getEnumeratedTypeExt().getItemByID(entity.getEnumID());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((itemExt == null) ? 0 : itemExt.hashCode());
		return result;
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
		final SimpleEnumeratedValue other = (SimpleEnumeratedValue) obj;
		if (itemExt == null) {
			if (other.itemExt != null)
				return false;
		} else if (!itemExt.equals(other.itemExt))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.appendSuper(super.toString());
		builder.append("enum", itemExt==null?"omit":getText());
		return builder.toString();
	}
	
}
