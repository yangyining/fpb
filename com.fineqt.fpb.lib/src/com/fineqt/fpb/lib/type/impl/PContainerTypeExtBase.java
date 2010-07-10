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
package com.fineqt.fpb.lib.type.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.codec.SimpleContainerDecodeResult;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.evattr.FieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.FieldRefOperation;
import com.fineqt.fpb.lib.meta.evattr.RegionRefDesc;
import com.fineqt.fpb.lib.meta.evattr.StackFieldOperation;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PContainerType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.modelview.FieldMV;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbFieldEVExt;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PContainerTypeExtBase extends PEntityTypeExtBase 
implements PContainerTypeExt {
	private String[] fieldNames;
	protected List<PFieldExt> fields = new ArrayList<PFieldExt>();
	protected Map<String, Integer> name2idMap = new HashMap<String, Integer>();
	
	public PContainerTypeExtBase(PContainerType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	@Override
	public boolean isContainerType() {
		return true;
	}
	
	@Override
	public Collection<PFieldExt> getAllFields() {
		return fields;
	}

	@Override
	public PFieldExt getFieldMeta(String fieldName) {
		Integer id = name2idMap.get(fieldName);
		if (id != null) {
			return getFieldMeta(id);
		}
		return null;
	}

	@Override
	public void addFieldMeta(PFieldExt meta) {
		fields.add(meta);
		name2idMap.put(meta.getFieldName(), meta.getFieldID());
	}

	@Override
	public int getFieldID(String fieldName) {
		Integer id = name2idMap.get(fieldName);
		if (id != null) {
			return id;
		}
		return -1;
	}

	@Override
	public PFieldExt getFieldMeta(int fieldID) {
		//fieldID是从0开始顺序增加的，所以可以作为列表的索引
		return fields.get(fieldID);
	}

	@Override
	public String[] getFieldNames() {
		if (fieldNames == null) {
			ArrayList<String> list = new ArrayList<String>();
			for (PFieldExt field : fields) {
				list.add(field.getFieldName());
			}
			fieldNames = list.toArray(new String[list.size()]);
		}
		return fieldNames;
	}
	
	@Override
	public int getFieldSize() {
		return fields.size();
	}

	@Override
	public IType getFieldType(int fieldIndex) {
		PFieldExt fieldMeta = getFieldMeta(fieldIndex);
		if (fieldMeta == null) {
			return null;
		}
		return fieldMeta.getType();
	}

	@Override
	public IType getFieldType(String fieldName) {
		PFieldExt fieldMeta = getFieldMeta(fieldName);
		if (fieldMeta == null) {
			return null;
		}
		return fieldMeta.getType();
	}

	@Override
	public IType getItemType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public FieldMV getFieldMV(String fieldName) {
		return getFieldMeta(fieldName);
	}

	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		builder.appendSuper(super.toString());
		for (PFieldExt field : fields) {
			builder.getStringBuffer().append(LN+TAB);
			builder.append(field.getFieldName(), field);
		}		
		return builder.toString();
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父类方法
		super.doInit();
		//初始化所有的字段（在父类方法之后，保证字段的类型是自己（递归）时已成功初始化）
		for (PFieldExt field : fields) {
			field.init();
		}
	}

	abstract public static class PFpbContaineEVExt extends PFpbEntityEVExt {

		public PFpbContaineEVExt(PFpbTypeEV model) {
			super(model);
		}

		protected void preEncodeField(EncodeContext cxt, PValue fieldValue,
				int parentLength, PFieldExt fieldMeta, ByteOrder byteOrder) throws EncodeException {
			PFpbFieldEVExt fieldEv = (PFpbFieldEVExt)fieldMeta.getEVMeta();
			//setField
			StackFieldOperation setField = fieldEv.getSetField();
			if (setField != null ) {
				if (cxt.withCalculateAction() && setField.getTimings().contains(FieldRefOperation.Timing.CALCULATE) ||
						cxt.withEncodeAction() && setField.getTimings().contains(FieldRefOperation.Timing.ENCODE) ||
						cxt.withGetSizeAction() && setField.getTimings().contains(FieldRefOperation.Timing.GETSIZE)) {
					if (!cxt.getFieldStackMap().setTopField(setField.getField(), fieldValue)) {
						throw new EncodeException(targetTypeMeta, 
								MetaException.CODE.FIELD_NOT_FOUND_IN_STACK_ERROR, 
								setField.getField());
					}
				}
			}
		}

		protected int postEncodeField(EncodeContext cxt, PValue fieldValue,
				int parentLength, int fieldLength, PFieldExt fieldMeta, ByteOrder byteOrder) 
		throws EncodeException {
			return fieldLength;
		}
		
		protected void preDecodeField(DecodeContext cxt, IReadableBitBuffer input, 
		        DecodeParameters paras, DecodeResult parentResult, PFieldExt fieldMeta) 
		throws DecodeException {
		}

		/**
		 * @return 返回是否继续余下字段的解码
		 * @throws DecodeException
		 */
		protected boolean postDecodeField(DecodeContext cxt, IReadableBitBuffer input, 
		        DecodeParameters paras, DecodeResult parentResult, 
				DecodeResult fieldResult, PFieldExt fieldMeta) 
		throws DecodeException {
			PFpbFieldEVExt fieldEv = (PFpbFieldEVExt)fieldMeta.getEVMeta();
			//setField(fieldResult里的Value有可能是null)
			StackFieldOperation setField = fieldEv.getSetField();
			if (setField != null ) {
				if (setField.getTimings().contains(FieldRefOperation.Timing.DECODE)) {
					if (!cxt.getFieldStackMap().setTopField(setField.getField(), 
							fieldResult.getValue())) {
						throw new DecodeException(targetTypeMeta, 
								MetaException.CODE.FIELD_NOT_FOUND_IN_STACK_ERROR, 
								setField.getField());
					}
				}
			}
			return true;
		}
		
		public  Class<? extends DecodeResult> getDecodeResultClass() {
			return SimpleContainerDecodeResult.class;
		}
		
		protected PValue getCaseRefValue(DecodeContext cxt, IReadableBitBuffer input,
				PValue parentValue, DecodeResult selfResult, FieldRefDesc caseRef, 
				RegionRefDesc caseRefRegion) throws BitBufferException {
			if (caseRef != null) {
				return findRefValue(cxt, null, parentValue, selfResult, caseRef);
			} else if (caseRefRegion != null) {
				return getRefRegionValue(cxt, caseRefRegion, input);
			}
			return null;
		}
		
		
	}
}
