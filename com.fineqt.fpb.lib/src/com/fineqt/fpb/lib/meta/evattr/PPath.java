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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.value.IPath;
import com.fineqt.fpb.lib.api.value.IPathFragment;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PContainerValue;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;

public class PPath implements IPath {
	final protected static Pattern FLAG_PATTERN = 
		Pattern.compile("([a-zA-Z][a-zA-Z0-9_.]*)?[ ]*(\\[[0-9]+\\])?");
	
	private PTypeExt targetType;
	private PPathFragment[] fragments;
	private PTypeExt refFieldType;
	
	protected PPath(PPathFragment[] fragments, PTypeExt targetType) {
		this.fragments = fragments;
		this.targetType = targetType;
		//取得最终引用字段的类型
		refFieldType = targetType;
		if (fragments.length > 0) {
			refFieldType = fragments[fragments.length-1].getRefFieldType();
		}
	}
	
	/**
	 * 
	 * @param pathDesc 路径的描述。路径的书写格式为FLAG_PATTERN的格式。
	 * @param targetType 路径的根元素的类型
	 * @return
	 * @throws MetaException
	 */
	public static PPath parse(String pathDesc, PTypeExt targetType) 
	throws MetaException {
		List<PPathFragment> list = new ArrayList<PPathFragment>();
		boolean ocurEscape = false;
		Matcher matcher = FLAG_PATTERN.matcher(pathDesc);
		PTypeExt currentOwnerType = targetType;
		for (int i = 0; i < pathDesc.length(); i++) {
			char ch = pathDesc.charAt(i);
			//skip space and delimiter
			if (ch == ' ' || ch == '\t' || ch == '/') {
				if (ch == '/') {
					if (ocurEscape) {
						throw new MetaException(MetaException.CODE.PARSE_PPATH_ERROR, null, 
							"Repeat delimiter error.");
					}
					ocurEscape = true;
				}
				continue;
			}
			if (!ocurEscape && list.size() != 0) {
				throw new MetaException(MetaException.CODE.PARSE_PPATH_ERROR, null, 
						"Need the delimiter of / between fragment.");
			}
			if (matcher.find(i)) {
				ocurEscape = false;
				assert matcher.groupCount() >= 2;
				//group从1开始,group 0不被计算在groupCount内
				String fieldName = matcher.group(1);
				int listIndex = -1;
				String group2 = matcher.group(2);
				if (group2 != null) {
					String index = group2.substring(1, group2.length() - 1).trim();
					try {
						listIndex = Integer.parseInt(index);
					} catch (NumberFormatException e) {
						throw new MetaException(MetaException.CODE.PARSE_PPATH_ERROR, e, 
						"Number format error.");					}
				}
				PPathFragment fragment = new PPathFragment(fieldName, listIndex, currentOwnerType);
				list.add(fragment);
				//下一次的准备
				currentOwnerType = fragment.getRefFieldType();
				i = matcher.end()-1;
			} else {
//				System.out.println("left:"+desc.substring(i+1));
				break;
			}
		}
		return new PPath(list.toArray(new PPathFragment[list.size()]), targetType);
	}
	
	public static PPath createSelfPath(PTypeExt targetType) {
		return new SelfPath(targetType);
	}
	
	public PPathFragment[] getFragments() {
		return fragments;
	}

	public PTypeExt getTargetType() {
		return targetType;
	}
	
	public PTypeExt getRefFieldType() {
		return refFieldType;
	}
	
	public PValue findField(PValue targetValue) {
		return findField(targetValue, false);
	}
	
	/**
	 * 根据路径从容器中寻找对应字段，如果没有找到则返回null。
	 * @param targetValue
	 * @return
	 */
	public PValue findField(PValue targetValue, boolean fillPath) {
		PValue result = targetValue;
		if (!targetValue.pTypeMeta().isCompatible(targetType)) {
			return null;
		}
		for (int i = 0; i < fragments.length; i++) {
			PPathFragment frag = fragments[i];
			result = frag.findField(result, fillPath);
			if (result == null)
				return null;
		}
		return result;
	}
	
	
	@Override
	public IValue findField(IValue targetValue, boolean fillPath) {
		return findField((PValue)targetValue, fillPath);
	}

	@Override
	public IValue findField(IValue targetValue) {
		return findField((PValue)targetValue);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("targetType", targetType.getFullName())
			.append("fragments", fragments)
			.toString();
	}
	
	public static class PPathFragment implements IPathFragment {
		private PFieldExt fieldMeta;
		private PTypeExt listItemType;
		private int listIndex = -1;
		private PTypeExt targetType;
		
		private PPathFragment(String fieldName, int listIndex, PTypeExt targetType) 
		throws MetaException {
			this.targetType = targetType;
			if (fieldName != null) {
				if (!(targetType.isContainerType())) {
					throw new MetaException(MetaException.CODE.MUST_CONTAINER_TYPE_ERROR, 
							null, targetType.getFullName());
				}
				PContainerTypeExt containerType = (PContainerTypeExt)targetType.getRootType();
				fieldMeta = containerType.getFieldMeta(fieldName);
				if (fieldMeta == null) {
					throw new MetaException(MetaException.CODE.FIELD_NOT_FOUND_ERROR, 
							null, fieldName, targetType.getFullName());
				}
			} else if (listIndex < 0) {
				throw new MetaException(MetaException.CODE.PARSE_PPATH_ERROR, null, 
						"In one path elelment either field name or list index must be set");
			}
			if (listIndex >= 0) {
				setListIndex(listIndex);
			}
		}
		
		public int getListIndex() {
			return listIndex;
		}

		public PFieldExt getFieldMeta() {
			return fieldMeta;
		}
		
		@Override
		public String getFieldName() {
			if (fieldMeta != null) {
				return fieldMeta.getFieldName();
			}
			return null;
		}

		private void setListIndex(int index) throws MetaException {
			if (index < 0) {
				throw new IllegalArgumentException();
			}
			if (index >= 0 && listItemType == null) {
				PTypeExt listType;
				if (fieldMeta != null) {
					listType = fieldMeta.getType();
				} else {
					listType = targetType;
				}
				if (!listType.isListType()) {
					throw new MetaException(MetaException.CODE.MUST_LIST_TYPE_ERROR, 
							null, targetType.getFullName());
				}
				PListTypeExt listTypeMeta = (PListTypeExt)listType.getRootType();
				listItemType = listTypeMeta.getItemType();
			}
			listIndex = index;
		}

		@Override
		public IType getTargetType() {
			return targetType;
		}

		public PTypeExt getRefFieldType() {
			if ( listItemType != null) {
				return listItemType;
			} else if (fieldMeta != null) {
				return fieldMeta.getType();
			} else {
				return targetType;
			}
		}

		public PValue findField(PValue owner, boolean newWhenNullOrOmit) {
			if (fieldMeta != null && 
				owner.pTypeMeta().getRootType() != fieldMeta.getOwner().getRootType()) {
				return null;
			}
			if (fieldMeta != null &&!(owner instanceof PContainerValue)) {
				return null;
			}
			//field
			PValue result;
			if (fieldMeta != null) {
				PContainerValue container = (PContainerValue)owner;
				if (container.notPresent()) {
					return null;
				}
				result = container.pGetFieldByID(fieldMeta.getFieldID(), newWhenNullOrOmit);
				if (result == null)
					return null;
			} else {
				result = owner;
			}
			//list element
			if (listIndex >= 0) {
				if (result instanceof PListValue<?>) {
					if (result.notPresent()) {
						return null;
					}
					result = (PValue)((PListValue<?>)result).getItem(listIndex, newWhenNullOrOmit);
				} else {
					return null;
				}
			}
			return result;
		}
		
		@Override
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("fieldMeta", fieldMeta==null?null:fieldMeta.getFullFieldName())
				.append("listIndex", listIndex)
				.toString();
		}
		
	}
	
	protected static class SelfPath extends PPath {

		public SelfPath(PTypeExt targetType) {
			super(new PPathFragment[0], targetType);
		}
		
	}

}
