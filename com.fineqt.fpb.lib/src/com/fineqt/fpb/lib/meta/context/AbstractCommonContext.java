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
package com.fineqt.fpb.lib.meta.context;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.system.SimpleScopeContext;

abstract public class AbstractCommonContext extends SimpleScopeContext 
implements CommonContext {
	private FieldStackMap fieldStackMap;
	
	public AbstractCommonContext() {
		super(IFpbSystem.INSTANCE);
	}

	@Override
	public FieldStackMap getFieldStackMap() {
		if (fieldStackMap == null) {
			fieldStackMap = new FieldStackMapImpl();
		}
		return fieldStackMap;
	}

	public static class FieldStackMapImpl implements FieldStackMap {
		private Map<String, FieldStackEntry> stackMap = new HashMap<String, FieldStackEntry>();
		@Override
		public Object peekField(String fieldName) {
			return getEntry(fieldName).peekField();
		}

		@Override
		public Object popField(String fieldName) {
			return getEntry(fieldName).popField();
		}

		@Override
		public void pushField(String fieldName, Object fieldValue) {
			getEntry(fieldName).pushField(fieldValue);			
		}

		@Override
		public boolean setTopField(String fieldName, Object fieldValue) {
			return getEntry(fieldName).setTopField(fieldValue);
		}

		private FieldStackEntry getEntry(String fieldName) {
			FieldStackEntry entry = stackMap.get(fieldName);
			if (entry == null) {
				entry = new FieldStackEntry();
				stackMap.put(fieldName, entry);
			}
			return entry;
		}
		
		@Override
		public void clear() {
			stackMap.clear();
		}

		private static class FieldStackEntry {
			FieldStackEntryItem topItem;
			/**
			 * 将字段的值压入堆栈。
			 * @param fieldValue
			 */
			public void pushField(Object fieldValue) {
				//堆栈为空
				if (topItem == null) {
					topItem = new FieldStackEntryItem();
					topItem.setValue(fieldValue);
				//设为顶部项目
				} else {
					FieldStackEntryItem prevTop = topItem;
					topItem = new FieldStackEntryItem();
					topItem.setValue(fieldValue);
					topItem.setNext(prevTop);
				}
			}
			/**
			 * 弹出堆栈中的字段。没有则返回null。
			 * @return
			 */
			public Object popField() {
				//堆栈为空
				if (topItem == null) {
					return null;
				//弹出顶部项目
				} else {
					FieldStackEntryItem prevTop = topItem;
					topItem = prevTop.getNext();
					prevTop.setNext(null);
					return prevTop.getValue();
				}
			}
			/**
			 * 取得堆栈中的字段。没有则返回null。
			 * @return
			 */
			public Object peekField() {
				//堆栈为空
				if (topItem == null) {
					return null;
				//取得顶部项目
				} else {
					return topItem.getValue();
				}
			}
			
			/**
			 * 改变堆栈中最顶层项目的值，如果堆栈为空则返回false.
			 * @param fieldValue
			 * @return
			 */
			public boolean setTopField(Object fieldValue) {
				//堆栈为空
				if (topItem == null) {
					return false;
				//取得顶部项目
				} else {
					topItem.setValue(fieldValue);
					return true;
				}
			}
			
			@Override
			public String toString() {
				return new ToStringBuilder(this)
				.append("topItem", topItem)
				.toString();
			}
		}

		static class FieldStackEntryItem {
			private FieldStackEntryItem next;
			private Object value;
			
			public FieldStackEntryItem getNext() {
				return next;
			}
			public void setNext(FieldStackEntryItem next) {
				this.next = next;
			}
			public Object getValue() {
				return value;
			}
			public void setValue(Object value) {
				this.value = value;
			}
			
			@Override
			public String toString() {
				return new ToStringBuilder(this)
					.append("value", value)
					.append("next", next)
					.toString();
			}
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this)
			.append("stackMap", stackMap)
			.toString();
		}
	}

	@Override
	public void passivate() {
		//清空属性
		attributes.clear();
		//清空堆栈
		if (fieldStackMap != null) {
	        fieldStackMap.clear();
		}
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.appendSuper(super.toString())
		.append("fieldStackMap", fieldStackMap)
		.toString();
	}
	
}
