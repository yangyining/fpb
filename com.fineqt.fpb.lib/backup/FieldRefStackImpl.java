package com.fineqt.fpb.lib.meta.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fineqt.fpb.lib.meta.FieldRef;
import com.fineqt.fpb.lib.meta.FieldRefStack;
import com.fineqt.fpb.lib.meta.PFieldExt;
import com.fineqt.fpb.lib.value.PValue;

public class FieldRefStackImpl implements FieldRefStack {
	private Map<String, LinkedList<FieldRefBase>> fieldMap = 
			new HashMap<String, LinkedList<FieldRefBase>>();
	private LinkedList<HookFieldRef> hookFields = new LinkedList<HookFieldRef>();
	
	@Override
	public FieldRef pop(String fieldName, String rootTypeName, String moduleName) {
		LinkedList<FieldRefBase> fields = getFields(fieldName);
		for (Iterator<FieldRefBase> iterator = fields.iterator(); iterator.hasNext();) {
			FieldRefBase fieldRef = iterator.next();
			if (!(rootTypeName != null && rootTypeName.equals(fieldRef.getRootTypeName()))) {
				continue;
			}
			if (!(moduleName != null && moduleName.equals(fieldRef.getModuleName()))) {
				continue;
			}
			iterator.remove();
			return fieldRef;
		}
		return null;
	}

	@Override
	public FieldRef push(PValue fieldValue) {
		PFieldExt fieldMeta = fieldValue.getFieldMeta();
		assert fieldMeta != null;
		String fieldName = fieldMeta.pFieldName();
		FieldRefBase fieldRef = null;
		//尝试取得HookFieldRef
		for (Iterator<HookFieldRef> iterator = hookFields.iterator(); iterator.hasNext();) {
			HookFieldRef ref = iterator.next();
			if (!fieldName.equals(ref.getFieldName())) {
				continue;
			}
			if (!(ref.getRootTypeName() != null && 
					ref.getRootTypeName().equals(fieldMeta.pOwner().pRootType().getName()))) {
				continue;
			}
			if (!(ref.getModuleName() != null && ref.getModuleName().equals(
					fieldMeta.pOwner().pRootType().pModule().pModuleName())))  {
				continue;
			}
			iterator.remove();
			ref.setValue(fieldValue);
			fieldRef = ref;
		}
		//如果没有HookFieldRef则生成新的
		if (fieldRef == null) {
			fieldRef = new RegularFieldRef(fieldValue);
		}
		LinkedList<FieldRefBase> fields = getFields(fieldMeta.pFieldName());
		//加入队列头
		fields.add(0, fieldRef);
		return fieldRef;
	}

	@Override
	public FieldRef pushHook(String fieldName, String rootTypeName,
			String moduleName) {
		HookFieldRef ref = new HookFieldRef(fieldName, rootTypeName, moduleName);
		//加入Hook队列头
		hookFields.add(0, ref);
		return ref;
	}

	private LinkedList<FieldRefBase> getFields(String fieldName) {
		LinkedList<FieldRefBase> fields = fieldMap.get(fieldName);
		if (fields == null) {
			fields = new LinkedList<FieldRefBase>();
		}
		return fields;
	}
	
	static abstract class FieldRefBase implements FieldRef {
		protected List<LengthSettedListener> lenSettedLsns;
		protected List<ValueSettedListener> valueSettedLsns;
		protected int length = -1;
		protected PValue value;
		
		@Override
		public void addLengthSettedListener(LengthSettedListener lsn) {
			if (lenSettedLsns == null) {
				lenSettedLsns = new LinkedList<LengthSettedListener>();
			}
			lenSettedLsns.add(lsn);
		}

		@Override
		public void addValueSettedListener(ValueSettedListener lsn) {
			if (valueSettedLsns == null) {
				valueSettedLsns = new LinkedList<ValueSettedListener>();
			}
			valueSettedLsns.add(lsn);
		}

		@Override
		public int getLength() {
			return length;
		}

		@Override
		public PValue getValue() {
			return value;
		}

		@Override
		public boolean isLengthSetted() {
			return length >= 0;
		}

		public void setLength(int newLength) {
			length = newLength;
			//激发监听事件
			if (lenSettedLsns != null) {
				for (LengthSettedListener lsn : lenSettedLsns) {
					lsn.setted(this, length);
					if (lsn.shouldRemovedAfterCalled()) {
						lenSettedLsns.remove(lsn);
					}
				}
			}
		}
		
		@Override
		public boolean isValueSetted() {
			return value != null;
		}

		@Override
		public boolean removeLengthSettedListener(LengthSettedListener lsn) {
			if (lenSettedLsns == null)
				return false;
			return lenSettedLsns.remove(lsn);
		}

		@Override
		public boolean removeValueSettedListener(ValueSettedListener lsn) {
			if (valueSettedLsns == null)
				return false;
			return valueSettedLsns.remove(lsn);
		}
		
	}
	
	static class RegularFieldRef extends FieldRefBase {
		private PFieldExt fieldMeta;
		
		public RegularFieldRef(PValue value) {
			this.value = value;
			fieldMeta = value.getFieldMeta();
		}
		
		@Override
		public String getFieldName() {
			return fieldMeta.pFieldName();
		}

		@Override
		public String getModuleName() {
			return fieldMeta.pOwner().pRootType().pModule().pModuleName();
		}

		@Override
		public String getRootTypeName() {
			return fieldMeta.pOwner().pRootType().pTypeName();
		}

		public void setValue(PValue newValue) {
			throw new UnsupportedOperationException();
		}
		
	}
	
	static class HookFieldRef extends FieldRefBase {
		private String fieldName;
		private String rootTypeName;
		private String moduleName;
		
		public HookFieldRef(String fieldName, String rootTypeName, String moduleName) {
			this.fieldName = fieldName;
			this.rootTypeName = rootTypeName;
			this.moduleName = moduleName;
		}

		@Override
		public String getFieldName() {
			if (value == null) 
				return fieldName;
			return value.getFieldMeta().pFieldName();
		}

		@Override
		public String getModuleName() {
			if (value == null)
				return moduleName;
			return value.getFieldMeta().pOwner().pRootType().pModule().pModuleName();
		}

		@Override
		public String getRootTypeName() {
			if (value == null)
				return rootTypeName;
			return value.getFieldMeta().pOwner().pRootType().pTypeName();
		}
		
		public void setValue(PValue newValue) {
			value = newValue;
			if (valueSettedLsns != null) {
				for (ValueSettedListener lsn : valueSettedLsns) {
					lsn.setted(this, value);
					if (lsn.shouldRemovedAfterCalled()) {
						valueSettedLsns.remove(lsn);
					}
				}
			}
		}
		
		
	}
}
