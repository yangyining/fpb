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

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PListTypeExt;

public class PRecordSetOfValue<T extends PValue> extends PValueBase implements PListValue<T> {
	protected List<T> items = new ArrayList<T>();

	@SuppressWarnings("unchecked")
	public static <T extends PValue> PListValue<T> createValue(Class<T> cls, PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return (PListValue<T>)new OmitPRecordSetOfValue<PValue>(meta);
		} else {
			return (PListValue<T>)new PRecordSetOfValue<PValue>(meta);
		}
	}

	public static PListValue<PValue> createValue(PTypeElementMeta meta, boolean notPresent) {
		return createValue(PValue.class, meta, notPresent);
	}
	
	protected PRecordSetOfValue(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	@Override
	public void appendItem(T value) {
		setItem(getLength(), value);
	}

	@Override
	public T getItem(int position) {
		return getItem(position, false);
	}

	@Override
	public T getItem(int position, boolean newWhenNull) {
		if (position < 0) {
			throw new IllegalArgumentException();
		}
		if (position >= items.size()) {
			if (newWhenNull) {
				setLength(position + 1);
			} else {
				return null;
			}
		}
		T result = items.get(position);
		if (result == null && newWhenNull) {
			PListTypeExt listType = (PListTypeExt)pTypeMeta().getRootType();
			PListItemExt itemMeta = listType.getItemMeta();
			@SuppressWarnings("unchecked")
			T newValue = (T)itemMeta.createDefaultValue();
			newValue.pParent(this);
			items.set(position, newValue);
			return newValue;
		} else {
			return result;
		}
	}

	@Override
	public void setItem(int position, T newValue) {
		if (position < 0) {
			throw new IllegalArgumentException();
		}
		//确保空间
		ensureCapacity(position);
		T orgValue = items.get(position);
		PListTypeExt listType = (PListTypeExt)pTypeMeta().getRootType();
		PListItemExt itemMeta = listType.getItemMeta();
		if (newValue != null) {
			if (!itemMeta.getType().isCompatible(newValue.pTypeMeta())) {
				throw new IncompatibleValueException(orgValue, newValue);
			}
			//其他容器的字段值对象（值拷贝）
			if (newValue.pParent() != null) {
			    //omit
			    if (newValue.notPresent()) {
                    if (orgValue != null) {
                        if (!orgValue.notPresent()) {
                            orgValue.pParent(null);
                            @SuppressWarnings("unchecked")
                            T tempValue = (T)itemMeta.createOmitValue();
                            tempValue.pParent(this);
                            items.set(position, tempValue);
                        }
                    } else {
                        @SuppressWarnings("unchecked")
                        T tempValue = (T)itemMeta.createOmitValue();
                        tempValue.pParent(this);
                        items.set(position, tempValue);
                    }
			        
			    //not omit
			    } else {
	                if (orgValue != null) {
	                    orgValue.assignPValue(newValue);
	                } else {
	                    @SuppressWarnings("unchecked")
	                    T tempValue = (T)itemMeta.createEmptyValue();
	                    tempValue.assignPValue(newValue);
	                    tempValue.pParent(this);
	                    items.set(position, tempValue);
	                }
			    }
			//顶层值对象(直接赋值)
			} else {
				if (orgValue != null) {
					orgValue.pParent(null);
				}
				newValue.pParent(this);
				newValue.pValueMeta(itemMeta);
				items.set(position, newValue);
			}
		//空值
		} else {
			if (orgValue != null) {
				orgValue.pParent(null);
			}
			items.set(position, null);
		}
	}

	private void ensureCapacity(int position) {
		if (position >= items.size()) {
			for (int i = items.size(); i <= position; i++) {
				items.add(null);
			}
		}
	}

	@Override
	public int getLength() {
		return items.size();
	}

	@Override
	public void setLength(int len) {
		//确保空间
		ensureCapacity(len - 1);
		//删除多余的
		if (items.size() > len) {
			for (int i = items.size() - 1; i > len - 1; i--) {
				T orgValue = items.remove(i);
				if (orgValue != null) {
					orgValue.pParent(null);
				}
			}
		}
	}

	@Override
	public boolean isContainer() {
		return false;
	}

	@Override
	public boolean isList() {
		return true;
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		if (!(srcValue instanceof PListValue<?>)) {
			throw new IncompatibleValueException(this, srcValue);
		}
		@SuppressWarnings("unchecked")
		PListValue<T> srcList = (PListValue<T>)srcValue;
		//设置长度
		if (srcList.getLength() != getLength()) {
			setLength(srcList.getLength());
		}
		//拷贝值
		for (int i = 0; i < srcList.getLength(); i++) {
			setItem(i, srcList.getItem(i));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!super.equals(obj)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		PListValue<PValue> srcList = (PListValue<PValue>)obj;
		//长度
		if (srcList.getLength() != getLength()) {
			return false;
		}
		//record of
		if (pTypeMeta().getTypeClass() == TypeClass.RECORDOF) {
			//按顺序逐个比较
			for (int i = 0; i < srcList.getLength(); i++) {
				if (!srcList.getItem(i).equals(getItem(i))) {
					return false;
				}
			}
			return true;
		//set of
		} else {
			//准备索引集合
			BitSet usedIndexSet = new BitSet(getLength());
			//比较（没有顺序要求）
			for (int i = 0; i < srcList.getLength(); i++) {
				PValue srcObj = srcList.getItem(i);
				boolean hasMatch = false;
				for (int j = 0; j < getLength(); j++) {
					if (usedIndexSet.get(j)) {
						continue;
					}
					PValue dstObj = getItem(j);
					if (dstObj.equals(srcObj)) {
						usedIndexSet.set(j);
						hasMatch = true;
					}
				}
				if (!hasMatch) {
					return false;
				}
			}
			return true;
		}
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("items", items.toArray());
		return builder.toString();
	}
	
	public static class OmitPRecordSetOfValue<T extends PValue> 
	extends OmitPValueBase implements PListValue<T> {

		public OmitPRecordSetOfValue(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public void appendItem(T value) {
			throw new OmitValueException();
		}

		@Override
		public T getItem(int position) {
			throw new OmitValueException();
		}

		@Override
		public T getItem(int position, boolean newWhenNull) {
			throw new OmitValueException();
		}

		@Override
		public void setItem(int position, T value) {
			throw new OmitValueException();
		}

		@Override
		public int getLength() {
			return 0;
		}

		@Override
		public void setLength(int len) {
			throw new OmitValueException();
		}

		@Override
		public boolean isContainer() {
			return false;
		}

		@Override
		public boolean isList() {
			return true;
		}

		@Override
		public boolean isPrimitive() {
			return false;
		}

	}
	
}
