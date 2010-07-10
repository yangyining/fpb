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

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.ContainerDecodeResult;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.codec.FieldSettedReaction;
import com.fineqt.fpb.lib.codec.FieldSettedReactionBase;
import com.fineqt.fpb.lib.codec.FlagFieldReader;
import com.fineqt.fpb.lib.codec.FlagFieldReaderImpl;
import com.fineqt.fpb.lib.codec.FlagFieldWriter;
import com.fineqt.fpb.lib.codec.FlagFieldWriterImpl;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.evattr.FieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.TypeFieldRefDesc;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PRecord;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbFieldEVExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PRecordSetTypeExt;
import com.fineqt.fpb.lib.value.PRecordSetValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PRecordTypeExtBase extends PRecordSetTypeExtBase {

	public PRecordTypeExtBase(PRecord pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}

	public static class PFpbRecordEVExt extends PFpbRecordSetEVExt {

		public PFpbRecordEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		protected void preEncodeField(EncodeContext cxt, PValue fieldValue,
				int parentLength, PFieldExt fieldMeta, ByteOrder byteOrder) 
		throws EncodeException{
			//处理FlagType
			if (cxt.withEncodeAction()) {
				PFpbFieldEVExt fieldEVMeta = (PFpbFieldEVExt)fieldMeta.getEVMeta();
				//生成Writer
				if (cxt.getFlagFieldWriter() == null && fieldEVMeta.getFlagType() != FlagFieldType.NONE) {
					FlagFieldWriter writer = new FlagFieldWriterImpl(cxt.getBuffer(), 
							fieldEVMeta.getFlagType(), byteOrder);
					cxt.setFlagFieldWriter(writer);
				}
			}
			//父类方法
			super.preEncodeField(cxt, fieldValue, parentLength, fieldMeta, byteOrder);
		}

		@Override
		protected int postEncodeField(EncodeContext cxt, PValue fieldValue,
				int parentLength, int fieldLength, PFieldExt fieldMeta,
				ByteOrder byteOrder) throws EncodeException {
			//处理FlagType
			if (cxt.withEncodeAction()) {
				//清除Writer
				FlagFieldWriter writer = cxt.getFlagFieldWriter();
				if (writer != null && writer.isFinished()) {
					cxt.setFlagFieldWriter(null);
				}
			}
			//父类方法
			return super.postEncodeField(cxt, fieldValue, parentLength, fieldLength,
					fieldMeta, byteOrder);
		}

		@Override
		protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer orgInput, 
		        PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult selfResult)
		throws DecodeException {
			DecodeResult parentResult = paras.getParentResult();
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			ContainerDecodeResult result = (ContainerDecodeResult)selfResult;
			PValue parentValue = parentResult == null?null:parentResult.getValue();
			//根据推测长度来生成新的Input
			IReadableBitBuffer targetInput = createInputForHypLength(cxt, orgInput, parentValue,
					elementMeta.getConstraints(), result, priorityAttrs, paras.getHypFixedLength());
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
			PRecordSetValue recordValue = (PRecordSetValue)targetTypeMeta.createEmptyValue();
			result.setValue(recordValue);
			//遍历field
			PRecordSetTypeExt recordType = (PRecordSetTypeExt)targetTypeMeta.getRootType();
			for (int i = 0; i < recordType.getFieldSize(); i++) {
				PFieldExt fieldMeta = recordType.getFieldMeta(i);
				//前置处理
				preDecodeField(cxt, targetInput, paras, result, fieldMeta);
				//decode
				DecodeResult fieldResult = fieldMeta.decode(cxt, targetInput, result, 
						paras.getByteOrder());
				PValue fieldValue = fieldResult.getValue();
				if (fieldValue == null) {
					throw new DecodeException(targetTypeMeta, 
							MetaException.CODE.FIELD_DECODING_FAILED, fieldMeta.getFullFieldName());
				}
				//设置Field(一定使用ContainerDecodeResult的setFieldByID方法，这样才能激活+方式的引用)
				result.setFieldByID(fieldMeta.getFieldID(), fieldValue);
				//后续处理
				boolean continueDecode = postDecodeField(cxt, targetInput, paras, result, 
						fieldResult, fieldMeta);
				//长度累计
				result.setValueLength(result.getValueLength() + fieldResult.getValueLength());
				//判断是否继续
				if (!continueDecode) {
					break;
				}
			}
			//如果Input是新生成的则移动原来Input的位置
			if (targetInput != orgInput) {
				//在长度计算中使用了+字段引用的时候，由于引用字段的错误值可能会在字段设置响应事件中因为
				//设置了错误的limit值而改变targetInput的position值。
				if (result.getValueLength() != targetInput.position()) {
					//TODO output warning
				}
				orgInput.position(orgInput.position() + result.getValueLength());
			}
			//返回
			return result;
		}

        @Override
        protected void assumeFixedDecodeLength(DecodeContext cxt,
                IReadableBitBuffer input, PTypeElementMeta elementMeta, 
                DecodeParameters paras, DecodeResult result)
                throws DecodeException {
            DecodeResult parentResult = paras.getParentResult();
            PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
            PValue parentValue = parentResult == null?null:parentResult.getValue();
            FieldRefDesc lengthRef = fpbTypeEVAttrs.getLengthRef(priorityAttrs);
            //不是依赖于未生成字段
            if (lengthRef == null || 
                    !lengthRef.getType().equals(FieldRefDesc.Type.TYPE_FIELD)) {
                try {
                    int fixedLength = getFixedLength(cxt, input, parentValue, result, 
                            null, 0, priorityAttrs);
                    paras.setHypFixedLength(fixedLength);
                } catch (BitBufferException e) {
                    throw new DecodeException(targetTypeMeta, 
                            MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
                }
            }
        }

        private IReadableBitBuffer createInputForHypLength(final DecodeContext cxt,
				final IReadableBitBuffer orgInput, final PValue parentValue,
				final PTypeConstraintStorage constraint,
				final ContainerDecodeResult result, final PFpbTypeEVAttrs priorityAttrs,
				int hypFixedLength)
				throws DecodeException {
		    IReadableBitBuffer targetInput = orgInput;
			//TypeField类型的长度引用，依赖于未生成的字段
			FieldRefDesc lengthRef = fpbTypeEVAttrs.getLengthRef(priorityAttrs);
			if (lengthRef != null && lengthRef.getType().equals(FieldRefDesc.Type.TYPE_FIELD)) {
				PFieldExt dependedField = ((TypeFieldRefDesc)lengthRef).getDenpendedField();
				assert dependedField != null;
				assert dependedField.getOwner() == targetTypeMeta;
				targetInput = orgInput.subBitBuffer(orgInput.position(), IBitBuffer.GET_LEN_BY_SUPER_CAPACITY);
				final IBitBuffer tmpInput = targetInput;
				FieldSettedReaction reaction = new FieldSettedReactionBase(dependedField.getFieldID()){
					private IBitBuffer targetInput = tmpInput;
					@Override
					public void fieldSetted(int fieldId, PValue value)
							throws DecodeException {
						//取得固定长度
						int fixedLength;
						try {
							fixedLength = getFixedLength(cxt, orgInput, parentValue,  result,
									null, 0, priorityAttrs);
						} catch (BitBufferException e) {
							throw new DecodeException(targetTypeMeta, 
									MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
						}
						//设置Input的长度
						if (fixedLength >= 0) {
							if (fixedLength <= targetInput.capacity()) {
								targetInput.limit(fixedLength);
							} else {
								//剩余长度不够（保持原样）
								//TODO warning output
							}
						}
					}
				};
				result.addFieldSettedReaction(reaction);
			//其他类型的长度预测（不依赖于未生成的字段）
			} else {
				//取得固定长度
				int fixedLength = hypFixedLength;
				//生成Input
				if (fixedLength >= 0) {
					if (fixedLength > orgInput.remaining()) {
						return null;
					}
					targetInput = orgInput.subBitBuffer(orgInput.position(), fixedLength);
				}
			}
			return targetInput;
		}

		@Override
		protected void preDecodeField(DecodeContext cxt, IReadableBitBuffer input, DecodeParameters paras, 
				DecodeResult parentResult, PFieldExt fieldMeta) throws DecodeException {
			PFpbFieldEVExt fieldEVMeta = (PFpbFieldEVExt)fieldMeta.getEVMeta();
			//生成Reader
			if (cxt.getFlagFieldReader() == null && fieldEVMeta.getFlagType() != FlagFieldType.NONE) {
				try {
					FlagFieldReader reader = new FlagFieldReaderImpl(input, 
							fieldEVMeta.getFlagType(), paras.getByteOrder());
					cxt.setFlagFieldReader(reader);
				} catch (BitBufferException e) {
					throw new DecodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
			}
			//父类方法
			super.preDecodeField(cxt, input, paras, parentResult, fieldMeta);
		}
		
		@Override
		protected boolean postDecodeField(DecodeContext cxt, IReadableBitBuffer input, DecodeParameters paras, 
				DecodeResult parentResult, 
				DecodeResult fieldResult, PFieldExt fieldMeta) 
		throws DecodeException {
			//清除Reader
			FlagFieldReader reader = cxt.getFlagFieldReader();
			if (reader != null && reader.isFinished()) {
				cxt.setFlagFieldReader(null);
			}
			//父类方法
			return super.postDecodeField(cxt, input, paras, parentResult, fieldResult, fieldMeta);
		}

	}
	
}
