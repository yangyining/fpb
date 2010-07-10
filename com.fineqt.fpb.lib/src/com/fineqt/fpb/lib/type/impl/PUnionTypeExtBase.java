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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.constraint.Diagnostic;
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.constraint.SimpleDiagnostic;
import com.fineqt.fpb.lib.dump.DumpLine;
import com.fineqt.fpb.lib.dump.TopTypeDumpLine;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.evattr.FieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.RegionRefDesc;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PUnion;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbFieldEVExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PUnionTypeExt;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.BitRegionImpl;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PUnionValue;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PUnionTypeExtBase extends PContainerTypeExtBase 
implements PUnionTypeExt {
	protected int defaultPresentFieldID = -1;
	
	public PUnionTypeExtBase(PUnion pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
	}
	
	@Override
	public boolean validateFields(PValue value, DiagnosticChain chain) {
		if (!(value instanceof PUnionValue)) {
			return false;
		}
		PUnionValue unionValue = (PUnionValue)value;
		PValue presentVariant = unionValue.pGetPresentVariant();
		if (presentVariant == null) {
			if (chain != null) {
				chain.add(new SimpleDiagnostic(Diagnostic.ERROR, 
						"There are none present varaint for union."));
			}
			return false;
		}
		return presentVariant.validate(chain);
	}
	
	@Override
	protected void doInit() throws InitMetaException {
		//父类方法
		super.doInit();
		//defaultPresentFieldID
		for (PFieldExt fieldMeta : fields) {
			if (fieldMeta.isDefaultPresent()) {
				defaultPresentFieldID = fieldMeta.getFieldID();
				break;
			}
		}
	}	
	
	@Override
	public int getDefaultPresentFieldID() {
		return defaultPresentFieldID;
	}
	
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.appendSuper(super.toString())
			.append("defaultPresentFieldID", defaultPresentFieldID)
			.toString();
	}
	
	public static class PFpbUnionEVExt extends PFpbContaineEVExt {
		public PFpbUnionEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		public void init() throws InitMetaException {
			super.init();
		}
		
		@Override
		public int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof PUnionValue;
			PUnionValue unionValue = (PUnionValue)value;
			PValue presentVariant = unionValue.pGetPresentVariant();
			if (presentVariant == null) {
				return 0;
			}
			PFieldExt fieldMeta = presentVariant.pFieldMeta();
			assert fieldMeta != null;
			//字段前置处理
			preEncodeField(cxt, presentVariant, 0, fieldMeta, byteOrder);
			int fieldLength = 0;
			try {
				//使用字段的信息来调用字段类型的操作
				fieldLength = fieldMeta.encode(cxt, presentVariant, 0, byteOrder);
			} finally {
				fieldLength = postEncodeField(cxt, presentVariant, 0, fieldLength, 
						fieldMeta, byteOrder);
			}
			return fieldLength;
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
			PUnionValue unionValue = (PUnionValue)targetTypeMeta.createEmptyValue();
			result.setValue(unionValue);
			//选择Union的成员
			PUnionTypeExt unionType = (PUnionTypeExt)targetTypeMeta.getRootType();
			boolean hasSelectedField = false;
			//根据caseRef选择
			FieldRefDesc caseRef = fpbTypeEVAttrs.getCaseRef(priorityAttrs);
			RegionRefDesc caseRefRegion = fpbTypeEVAttrs.getCaseRefRegion(priorityAttrs);
			PFieldExt caseDefaultField = fpbTypeEVAttrs.getCaseDefault(priorityAttrs);
			if (caseRef != null || caseRefRegion != null) {
				PValue caseRefValue;
				try {
					caseRefValue = getCaseRefValue(cxt, targetInput, parentValue, result, 
							caseRef, caseRefRegion);
				} catch (BitBufferException e) {
					throw new DecodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
                PFieldExt targetField = null;
				if (caseRefValue != null) {
					for (int i = 0; i < unionType.getFieldSize(); i++) {
						PFieldExt fieldMeta = unionType.getFieldMeta(i);
						PFpbFieldEVExt fieldEVMeta = (PFpbFieldEVExt)fieldMeta.getEVMeta();
						//使用caseCond判断是否选中
						boolean selected = true;
						if (fieldEVMeta.getCaseCond() == null || fieldEVMeta.getCaseCond().size() <= 0) {
							continue;
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
				} else {
					//TODO output warning
				}
                //default
                if (caseDefaultField != null && targetField == null) {
                    targetField = caseDefaultField;
                }
                //解码选中的字段
                if (targetField != null) {
                    if (processSelectedField(cxt, paras, result, targetInput, unionValue, 
                            targetField)) {
                        hasSelectedField = true;
                    }
                }
			//尝试解码每一个
			} else {
				for (int i = 0; i < unionType.getFieldSize(); i++) {
					PFieldExt fieldMeta = unionType.getFieldMeta(i);
					if (processSelectedField(cxt, paras, result, targetInput, unionValue, 
							fieldMeta)) {
						hasSelectedField = true;
						break;
					}
				}
			}
			//只有当Union中成功选中的字段才认为Union的Decode成功
			if (!hasSelectedField) {
				result.setValue(null);
			}
			//如果Input是新生成的则移动原来Input的位置
			if (targetInput != orgInput) {
				assert result.getValueLength() == targetInput.position();
				orgInput.position(orgInput.position() + targetInput.position());
			}
			return result;
		}

		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep)
				throws DumpException {
			assert value instanceof PUnionValue;
			PUnionValue rsValue = (PUnionValue)value;
			DumpLine line;
			int startOffset = cxt.getOffset();
			//Create Line
			line = createAndAddDumpLine(cxt, value, valueName, deep, 
			        (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			//TopType
			DumpLine orgPrtlLine = cxt.getCurrentTopType();
			if (line instanceof TopTypeDumpLine) {
				cxt.setCurrentTopType(line);
			}
			//当前字段
			int selfLength = 0;
			PValue variantValue = rsValue.pGetPresentVariant();
			if (variantValue != null) {
				PFieldExt fieldMeta = variantValue.pFieldMeta();
				int fieldLength = 0;
				//使用字段的信息来调用字段类型的操作
				fieldLength = fieldMeta.dump(cxt, variantValue, deep + 1);
				selfLength += fieldLength;
			}
			//ValueRegion
			BitRegion valueRegion = new BitRegionImpl(startOffset, selfLength);
			line.setValueRegion(valueRegion);
			//恢复Protocol
			cxt.setCurrentTopType(orgPrtlLine);
			return selfLength;
		}
		
		private boolean processSelectedField(DecodeContext cxt, DecodeParameters paras,
				DecodeResult result, IReadableBitBuffer targetInput,
				PUnionValue unionValue, PFieldExt fieldMeta)
				throws DecodeException {
			//前置处理
			preDecodeField(cxt, targetInput, paras, result, fieldMeta);
			//decode
			DecodeResult fieldResult = fieldMeta.decode(cxt, targetInput, result, 
			        paras.getByteOrder());
			PValue fieldValue = fieldResult.getValue();
			if (fieldValue != null) {
				//设置Field
				unionValue.pSetFieldByID(fieldMeta.getFieldID(), fieldValue);
			}
			//后续处理
			postDecodeField(cxt, targetInput, paras, result, fieldResult, 
					fieldMeta);
			if (fieldValue != null) {
				//长度累计
				result.setValueLength(result.getValueLength() + fieldResult.getValueLength());
				return true;
			}
			return false;
		}
		
	}
	
}
