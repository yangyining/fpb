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

import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;

abstract public class PContainerValueBase extends PValueBase 
implements PContainerValue {


	public PContainerValueBase(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	protected PContainerTypeExt getContainerTypeExt() {
		//有Import, Sub和Entity三种类型，所以用RootType
		return (PContainerTypeExt)pTypeMeta().getRootType();
	}

	@Override
	public PValue pGetFieldByName(String fieldName) {
		int id = getContainerTypeExt().getFieldID(fieldName);
		if (id < 0)
			return null;
		return pGetFieldByID(id);
	}

	@Override
	public void pSetFieldByName(String fieldName, PValue value) {
		int id = getContainerTypeExt().getFieldID(fieldName);
		if (id < 0)
			return;
		pSetFieldByID(id, value);
	}
	
	protected PValue createDefaultFieldValue(int fieldID) {
		PValue newValue = getContainerTypeExt().getFieldMeta(fieldID).createDefaultValue();
		newValue.pParent(this);
		return newValue;
	}
	
	@Override
	public PValue pGetFieldByID(int fieldId, boolean newWhenOmitOrNull) {
		PFieldExt fieldMeta = getContainerTypeExt().getFieldMeta(fieldId);
		if (fieldMeta == null) {
			return null;
		}
		PValue result = pGetFieldByID(fieldId);
		if ((result == null || result.notPresent()) && newWhenOmitOrNull) {
			if (!fieldMeta.isOptional()) {
				result = fieldMeta.createDefaultValue();
			} else {
				result = fieldMeta.getType().createNormalValue();
			}
			pSetFieldByID(fieldId, result);
		}
		return result;
	}

	@Override
	public PValue pGetFieldByName(String fieldName, boolean newWhenOmitOrNull) {
		PFieldExt fieldMeta = getContainerTypeExt().getFieldMeta(fieldName);
		if (fieldMeta == null) {
			return null;
		}
		PValue result = pGetFieldByID(fieldMeta.getFieldID());
		if ((result == null || result.notPresent()) && newWhenOmitOrNull) {
			if (!fieldMeta.isOptional()) {
				result = fieldMeta.createDefaultValue();
			} else {
				result = fieldMeta.getType().createNormalValue();
			}
			pSetFieldByID(fieldMeta.getFieldID(), result);
		}
		return result;
	}

	@Override
	public IValue getField(int fieldIndex, boolean newWhenOmitOrNull) {
		return pGetFieldByID(fieldIndex, newWhenOmitOrNull);
	}

	@Override
	public IValue getField(String fieldName, boolean newWhenOmitOrNull) {
		return pGetFieldByName(fieldName, newWhenOmitOrNull);
	}

	@Override
	public IValue getField(int fieldId) {
		return pGetFieldByID(fieldId);
	}

	@Override
	public IValue getField(String fieldName) {
		return pGetFieldByName(fieldName);
	}

	@Override
	public void setField(int fieldId, IValue value) {
		pSetFieldByID(fieldId, (PValue)value);
	}

	@Override
	public void setField(String fieldName, IValue value) {
		pSetFieldByName(fieldName, (PValue)value);
	}

	@Override
	public boolean isContainer() {
		return true;
	}

	@Override
	public boolean isList() {
		return false;
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}

	/**
	 * 将新的字段值（newValue）赋给原来的字段值对象，当newValue是其他容器值的字段时则不能改变newValue
	 * 的原有状态。用于Record, Set, Union, RecordOf, SetOf 
	 * @param orgField 原来的字段值
	 * @param newValue 新的字段值
	 * @return
	 */
	protected PValue assignNewFieldValue(int fieldID, PValue orgField, PValue newValue) {
		if (newValue == null) {
			return assignNullNewValue(fieldID, orgField);
		//new value is omit
		} else if (newValue.notPresent()) {
			return assignOmitNewValue(fieldID, orgField, newValue);
		//new value is normal
		} else {
			return assignNormalNewValue(fieldID, orgField, newValue);
		}
	}
	
	private PValue assignNullNewValue(int fieldID, PValue orgField) {
		if (orgField != null) {
			orgField.pParent(null);
		}
		return null;
	}
	
	/**
	 * @return 新的值
	 */
	private PValue assignNormalNewValue(int fieldID, PValue orgField, PValue newValue) {
		assert !newValue.notPresent();
		PValue tempValue;
		//取得ValueMeta
		PTypeElementMeta valueMeta;
		if (orgField != null) {
			valueMeta = orgField.pValueMeta();
		} else {
			valueMeta = (PTypeElementMeta)getContainerTypeExt().getFieldMeta(fieldID);
			//如果字段不存在则返回原值
			if (valueMeta == null) {
				return orgField;
			}
		}
		assert valueMeta != null;
		//原来是为空或omit则需要新生成
		if (orgField == null || orgField.notPresent()) {
			//顶层值对象(直接赋值)
			if (newValue.pParent() == null) {
				tempValue = newValue;
				tempValue.pValueMeta(valueMeta);
				tempValue.pParent(this);
			//其他容器的字段值对象（值拷贝）
			} else {
				//不用FieldMeta的createDefaultValue()方法是由于生成结果有可能是Omit，则assignValue
				//就会失败
				tempValue = (PValue)valueMeta.asTypeMeta().createEmptyValue();
				tempValue.pValueMeta(valueMeta);
				tempValue.assignPValue(newValue);
				tempValue.pParent(this);
			}
			if (orgField != null) {
				orgField.pParent(null);
			}
			return tempValue;
		//一般赋值
		} else {
			//顶层值对象(直接赋值)
			if (newValue.pParent() == null) {
				tempValue = newValue;
				tempValue.pValueMeta(valueMeta);
				tempValue.pParent(this);
				if (orgField != null) {
					orgField.pParent(null);
				}
				return tempValue;
			//其他容器的字段值对象（值拷贝）
			} else {
				orgField.assignPValue(newValue);
				return orgField;
			}
		}
	}
	
	/**
	 * @return 新的值
	 */
	private PValue assignOmitNewValue(int fieldID, PValue orgField, PValue newValue) {
		PValue tempValue;
		PFieldExt fieldMeta;
		if (orgField != null) {
			fieldMeta = orgField.pFieldMeta();
		} else {
			fieldMeta = getContainerTypeExt().getFieldMeta(fieldID);
			//如果字段不存在则返回原值
			if (valueMeta == null) {
				return orgField;
			}
		}
		assert fieldMeta != null;
		//原值不是Omit或为空则重新生成
		if (orgField == null || !orgField.notPresent()) {
			tempValue = fieldMeta.createOmitValue();
			tempValue.pParent(this);
			if (orgField != null) {
				orgField.pParent(null);
			}
			return tempValue;
		//原值是Omit则直接返回
		} else {
			return orgField;
		}
	}
	
	abstract protected static class OmitPContainerValueBase extends OmitPValueBase 
	implements PContainerValue {

		public OmitPContainerValueBase(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		protected PContainerTypeExt getContainerTypeExt() {
			//有Import, Sub和Entity三种类型，所以用RootType
			return (PContainerTypeExt)pTypeMeta().getRootType();
		}
		
		@Override
		public PValue pGetFieldByID(int fieldId) {
			throw new OmitValueException();
		}

		@Override
		public PValue pGetFieldByName(String fieldName) {
			throw new OmitValueException();
		}

		@Override
		public void pSetFieldByID(int fieldId, PValue value) {
			throw new OmitValueException();
		}

		@Override
		public void pSetFieldByName(String fieldName, PValue value) {
			throw new OmitValueException();
		}
		
		@Override
		public IValue getField(int fieldId) {
			throw new OmitValueException();
		}

		@Override
		public IValue getField(String fieldName) {
			throw new OmitValueException();
		}

		@Override
		public void setField(int fieldId, IValue value) {
			throw new OmitValueException();
		}

		@Override
		public void setField(String fieldName, IValue value) {
			throw new OmitValueException();
		}

		@Override
		public PValue pGetFieldByID(int fieldId, boolean newWhenOmitOrNull) {
			throw new OmitValueException();
		}

		@Override
		public PValue pGetFieldByName(String fieldName,
				boolean newWhenOmitOrNull) {
			throw new OmitValueException();
		}

		@Override
		public IValue getField(int fieldIndex, boolean newWhenOmitOrNull) {
			throw new OmitValueException();
		}

		@Override
		public IValue getField(String fieldName, boolean newWhenOmitOrNull) {
			throw new OmitValueException();
		}

		@Override
		public boolean isContainer() {
			return true;
		}

		@Override
		public boolean isList() {
			return false;
		}

		@Override
		public boolean isPrimitive() {
			return false;
		}

	}
	
}
