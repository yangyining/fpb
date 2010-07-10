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

import java.util.BitSet;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.evattr.FieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.RegionRefDesc;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PSet;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbFieldEVExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PRecordSetTypeExt;
import com.fineqt.fpb.lib.value.PRecordSetValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PSetTypeExtBase extends PRecordSetTypeExtBase {

	public PSetTypeExtBase(PSet pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	public static class PFpbSetEVExt extends PFpbRecordSetEVExt {

		public PFpbSetEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public void init() throws InitMetaException {
			super.init();
		}
		
        @Override
        protected void assumeFixedDecodeLength(DecodeContext cxt,
                IReadableBitBuffer input, PTypeElementMeta elementMeta, 
                DecodeParameters paras, DecodeResult result)
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
			//生成自己
			PRecordSetValue setValue = (PRecordSetValue)targetTypeMeta.createEmptyValue();
			result.setValue(setValue);
			//选择Union的成员
			PRecordSetTypeExt setType = (PRecordSetTypeExt)targetTypeMeta.getRootType();
			BitSet decodedFields = new BitSet(setType.getFieldSize());
			//根据caseRef选择
			FieldRefDesc caseRef = fpbTypeEVAttrs.getCaseRef(priorityAttrs);
			RegionRefDesc caseRefRegion = fpbTypeEVAttrs.getCaseRefRegion(priorityAttrs);
			if (caseRef != null || caseRefRegion != null) {
				while(true) {
					PFieldExt targetField = null;
					//取得引用值(对于caseRefRegion来说需要重复取新值)
					PValue caseRefValue;
					try {
						caseRefValue = getCaseRefValue(cxt, targetInput, parentValue,
                                result, caseRef, caseRefRegion);
					} catch (BitBufferException e) {
						throw new DecodeException(targetTypeMeta, 
								MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
					}
					if (caseRefValue == null) {
						break;
					}
					//选择目标字段
					for (int i = 0; i < setType.getFieldSize(); i++) {
						//判断是否已经解码过了
						if (decodedFields.get(i)) {
							continue;
						}
						PFieldExt fieldMeta = setType.getFieldMeta(i);
						PFpbFieldEVExt fieldEVMeta = (PFpbFieldEVExt)fieldMeta.getEVMeta();
						//使用caseCond判断是否选中
						boolean selected = true;
						if (fieldEVMeta.getCaseCond() == null || fieldEVMeta.getCaseCond().size() <= 0) {
							throw new DecodeException(getTargetTypeMeta(), 
									MetaException.CODE.NOT_MATCHED_REF_AND_COND_ERROR, 
									"caseRef or caseRefRegion");
						}
						for (PTypeConstraintExt caseCond : fieldEVMeta.getCaseCond()) {
							if (!caseCond.validate(caseRefValue)) {
								selected = false;
								break;
							}
						}
						if (selected) {
							targetField = fieldMeta;
							break;
						}
					}
					//解码选中的字段
					if (targetField != null) {
						if (!processSelectedField(cxt, paras, result, targetInput, setValue, 
								targetField, decodedFields, true)) {
							break;
						}
					//没有选中字段则结束
					} else {
						break;
					}
				}
			} else {
				TOP_LOOP:
				while(true) {
					boolean hasSucceedDecodedField = false;
					for (int i = 0; i < setType.getFieldSize(); i++) {
						//判断是否已经解码过了
						if (decodedFields.get(i)) {
							continue;
						}
						PFieldExt fieldMeta = setType.getFieldMeta(i);
						if (!processSelectedField(cxt, paras, result, targetInput, setValue, 
								fieldMeta, decodedFields, false)) {
							break TOP_LOOP;
						}
						//是否解码成功
						hasSucceedDecodedField = decodedFields.get(i);
						if (hasSucceedDecodedField) {
							break;
						}
					}
					//没有选中字段则结束
					if (!hasSucceedDecodedField) {
						break;
					}
				}
			}
			//判断是否有没有处理的Optional和非Optional字段
			for (int i = 0; i < setType.getFieldSize(); i++) {
				if (!decodedFields.get(i)) {
					PFieldExt fieldMeta = setType.getFieldMeta(i);
					if (fieldMeta.isOptional()) {
						setValue.pSetFieldByID(i, fieldMeta.createOmitValue());
					} else {
						throw new DecodeException(targetTypeMeta,
								MetaException.CODE.NONE_OPTIONAL_FIELD_NOT_DECODED_ERROR, 
								fieldMeta.getFieldName(), fieldMeta.getType().getFullName());
					}
				}
			}
			return result;
		}

		private boolean processSelectedField(DecodeContext cxt, DecodeParameters paras,
				DecodeResult result, IReadableBitBuffer targetInput,
				PRecordSetValue setValue, PFieldExt fieldMeta, BitSet decodedFields, boolean force)
				throws DecodeException {
			//前置处理
			preDecodeField(cxt, targetInput, paras, result, fieldMeta);
			//decode
			DecodeResult fieldResult = fieldMeta.decode(cxt, targetInput, result, paras.getByteOrder());
			PValue fieldValue = fieldResult.getValue();
			if (fieldValue != null) {
				//设置Field
				setValue.pSetFieldByID(fieldMeta.getFieldID(), fieldValue);
			}
			//后续处理
			boolean continueDecode = postDecodeField(cxt, targetInput, paras, result, fieldResult, 
					fieldMeta);
			if (fieldValue != null) {
				//长度累计
				result.setValueLength(result.getValueLength() + fieldResult.getValueLength());
				//已解码标记
				decodedFields.set(fieldMeta.getFieldID());
			} else {
				//强制解码
				if (force) {
					throw new DecodeException(targetTypeMeta,
							MetaException.CODE.SELECTED_FIELD_DECODED_FAILED, 
							fieldMeta.getFieldName(), fieldMeta.getType().getFullName());
				}
			}
			return continueDecode;
		}
		
	}
	
}
