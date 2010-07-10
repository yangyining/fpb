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

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.constraint.Diagnostic;
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.constraint.SimpleDiagnostic;
import com.fineqt.fpb.lib.dump.DumpLine;
import com.fineqt.fpb.lib.dump.TopTypeDumpLine;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.evattr.FieldRefDesc;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PListType;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PListTypeExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.BitRegionImpl;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PRecordSetOfValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PListTypeExtBase extends PEntityTypeExtBase 
implements PListTypeExt {
	protected PListItemExt itemMeta;
	
	public PListTypeExtBase(PListType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	@Override
	public boolean isListType() {
		return true;
	}
	
	@Override
	public ListItemMV getListItemMV() {
		return itemMeta;
	}

	@Override
	public boolean validateFields(PValue value, DiagnosticChain chain) {
		if (!(value instanceof PListValue)) {
			return false;
		}
		boolean continueOnError = false;
		if (chain != null) {
			continueOnError = chain.shouldCollectAllError();
		}
		@SuppressWarnings("unchecked")
		PListValue<PValue> listValue = (PListValue<PValue>)value;
		boolean hasError = false;
		for (int i = 0; i < listValue.getLength(); i++) {
			PValue itemValue = listValue.getItem(i);
			//Null check
			if (itemValue == null) {
				if (chain != null) {
					chain.add(new SimpleDiagnostic(Diagnostic.ERROR, "Field in index["+i
							+"] of list is null."));
				}
				hasError = true;
				if (!continueOnError) {
					break;
				}
			//字段值检测
			} else {
				if (!itemValue.validate(chain)) {
					hasError = true;
					if (!continueOnError) {
						break;
					}
				}
			}
		}
		return !hasError;
	}
	
	protected PListType pListTypeModel() {
		return (PListType)pmodel;
	}
	
	@Override
	public PListItemExt getItemMeta() {
		return itemMeta;
	}

	@Override
	public void setItemMeta(PListItemExt itemMeta) {
		this.itemMeta = itemMeta;
	}

	@Override
	public PTypeExt getItemType() {
		return itemMeta.asTypeMeta();
	}

	@Override
	public int getFixedLength() {
		return pconstraints.getFixedLength();
	}

	@Override
	public int getFieldSize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IType getFieldType(int fieldIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IType getFieldType(String fieldName) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父类方法
		super.doInit();
		//初始化项目
		itemMeta.init();
	}
	
	public static class PFpbListEVExt extends PFpbEntityEVExt {

		public PFpbListEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public void init() throws InitMetaException {
			//父类方法
			super.init();
		}

		@Override
		public int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof PListValue<?>;
			@SuppressWarnings("unchecked")
			PListValue<PValue> listValue = (PListValue<PValue>)value;
			//全部字段
			int selfLength = 0;
			for (int i = 0; i < listValue.getLength(); i++) {
				PValue itemValue = listValue.getItem(i);
				PListItemExt itemMeta = itemValue.pValueMeta().asListItemMeta();
				selfLength += itemMeta.encode(cxt, itemValue, selfLength, byteOrder);
			}
			return selfLength;
		}

		@Override
		public int postEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				int selfLength, ByteOrder byteOrder) 
		throws EncodeException {
			int result = super.postEncode(cxt, value, parentLength, elementMeta, selfLength,
					byteOrder);
            PFpbTypeEVAttrs priorityAttrs  = 
                (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			PListValue<?> listValue = (PListValue<?>)value;
			if (cxt.withCalculateAction()) {
				FieldRefDesc repeatRef = fpbTypeEVAttrs.getRepeatRef(priorityAttrs);
				if (repeatRef != null && fpbTypeEVAttrs.isRefreshRepeatRef(priorityAttrs)) {
					//取得最先找到的引用字段
					PValue refValue = findRefValue(cxt, value, value.pParent(), null, repeatRef);;
					//设置被引用字段的值
					if (refValue != null && fpbTypeEVAttrs.isRefreshRepeatRef(priorityAttrs)) {
						setIntValue(refValue, listValue.getLength());
					}
				}
			}
			return result;
		}

        @Override
        protected void assumeFixedDecodeLength(DecodeContext cxt,
                IReadableBitBuffer input, PTypeElementMeta elementMeta, DecodeParameters paras, 
                DecodeResult result)
                throws DecodeException {
            DecodeResult parentResult = paras.getParentResult();
            PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
            PValue parentValue = parentResult == null?null:parentResult.getValue();
            try {
                int fixedLength = getFixedLength(cxt, input, parentValue, result, null, 
                        0, priorityAttrs);
                paras.setHypFixedLength(fixedLength);
            } catch (BitBufferException e) {
                throw new DecodeException(targetTypeMeta, 
                        MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
            }
        }
		
		@Override
		protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer orgInput, 
		        PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult result)
		throws DecodeException {
			DecodeResult parentResult = paras.getParentResult();
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			PValue parentValue = parentResult == null?null:parentResult.getValue();
			//根据推测长度来生成新的Input
			IReadableBitBuffer targetInput = createTargetInputByFixedLength(orgInput,
                    paras.getHypFixedLength());
			//剩余数据不够
			if (targetInput == null) {
				//可选则返回空
				if (elementMeta.isOptional()) {
					return result;
				//不可选则强制解析
				} else {
					targetInput = orgInput;
				}
			}
			//取得固定个数
			int fixedRepeatCnt;
            fixedRepeatCnt = getFixedRepeatCnt(cxt, parentValue, result, elementMeta
                    .getConstraints(), priorityAttrs);
			//生成自己
			@SuppressWarnings("unchecked")
			PRecordSetOfValue<PValue> listValue = 
				(PRecordSetOfValue<PValue>)targetTypeMeta.createEmptyValue();
			result.setValue(listValue);
			
			//生成所有List的成员
			PListTypeExt listType = (PListTypeExt)targetTypeMeta.getRootType();
			PListItemExt itemMeta = listType.getItemMeta();
			int selfLength = 0;
			//固定个数
			if (fixedRepeatCnt >= 0) {
				for (int i = 0; i < fixedRepeatCnt; i++) {
					DecodeResult itemResult = itemMeta.decode(cxt, targetInput, 
							result, paras.getByteOrder());
					assert itemResult != null;
					if (itemResult.getValue() != null) {
						selfLength += itemResult.getValueLength();
						listValue.appendItem(itemResult.getValue());
					} else {
                        throw new DecodeException(targetTypeMeta, 
                                MetaException.CODE.FIELD_DECODING_FAILED, "item(" + i + ")");
					}
					//后置处理
					if (!postDecodeItem(cxt, targetInput, elementMeta, paras, 
					        result, itemResult, itemMeta)) {
						break;
					}
				}
			//使用所有的剩余空间
			} else {
                //非增量解码或固定limit的情况下判断是否有剩余空间
			    boolean checkRemaining = !cxt.isIncrement() || !targetInput.useCapacityAsLimit();
				while(true) {
				    //判断剩余空间
				    if (checkRemaining && !targetInput.hasRemaining()) {
                        break;
				    }
					DecodeResult itemResult = itemMeta.decode(cxt, targetInput, 
							result, paras.getByteOrder());
					assert itemResult != null;
					if (itemResult.getValue() != null) {
						selfLength += itemResult.getValueLength();
						listValue.appendItem(itemResult.getValue());
					}
					//后置处理
					if (!postDecodeItem(cxt, targetInput, elementMeta, paras, result, 
					        itemResult, itemMeta)) {
						break;
					}
					//返回为空则终止循环
					if (itemResult.getValue() == null) {
					    break;
					}
				}
			}
			//可选且长度为0则返回null
			if (selfLength == 0 && elementMeta.isOptional()) {
				assert listValue.getLength() == 0;
				result.setValue(null);
			} else {
				//返回长度
				result.setValueLength(selfLength);
			}
			//如果Input是新生成的则移动原来Input的位置
			if (targetInput != orgInput) {
				assert selfLength == targetInput.position();
				orgInput.position(orgInput.position() + targetInput.position());
			}
			//返回
			return result;
		}

		protected boolean postDecodeItem(DecodeContext cxt, IBitBuffer input, 
		        PTypeElementMeta elementMeta, DecodeParameters paras,
				DecodeResult parentResult, DecodeResult itemResult, PListItemExt itemMeta) {
			return true;
		}
		
		/**
		 * 
		 * @return 根据repeatRef的设置来取得List的固定长度。如果没有则返回-1。
		 */
		protected int getFixedRepeatCnt(DecodeContext cxt, PValue parentValue,
                DecodeResult selfResult, PTypeConstraintStorage constraint,
                PFpbTypeEVAttrs priorityAttrs) {
			int fixedCnt = constraint.getFixedLength();
			FieldRefDesc repeatRef = fpbTypeEVAttrs.getRepeatRef(priorityAttrs);
			if (repeatRef != null) {
				PValue repeatRefValue = findRefValue(cxt, selfResult.getValue(), parentValue, 
						selfResult, repeatRef);
				if (repeatRefValue != null) {
					fixedCnt = getIntValue(repeatRefValue);
				}
			}
			return fixedCnt;
		}
		
		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep)
                throws DumpException {
			assert value instanceof PListValue<?>;
			@SuppressWarnings("unchecked")
			PListValue<PValue> listValue = (PListValue<PValue>)value;
			PListTypeExt listType = (PListTypeExt)listValue.pTypeMeta().getRootType();
			PListItemExt itemMeta = listType.getItemMeta();
			DumpLine line;
			int startOffset = cxt.getOffset();
			//Add Line
			line = createAndAddDumpLine(cxt, value, valueName, deep, 
			        (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			//TopType
			DumpLine orgPrtlLine = cxt.getCurrentTopType();
			if (line instanceof TopTypeDumpLine) {
				cxt.setCurrentTopType(line);
			}
			//所有列表成员
			int selfLength = 0;
			for (int i = 0; i < listValue.getLength(); i++) {
				PValue itemValue = listValue.getItem(i);
                selfLength += itemMeta.dump(cxt, itemValue, "["+i+"]", deep+1);
			}			
			//ValueRegion
			BitRegion valueRegion = new BitRegionImpl(startOffset, selfLength);
			line.setValueRegion(valueRegion);
			//恢复Protocol
			cxt.setCurrentTopType(orgPrtlLine);
			return selfLength;
		}
		
	}
}
