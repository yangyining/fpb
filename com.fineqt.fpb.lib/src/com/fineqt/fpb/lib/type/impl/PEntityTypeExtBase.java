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

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.IFpbSystem;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PIntegerValue;
import com.fineqt.fpb.lib.builtin.PUCharstringValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.codec.SimpleDecodeResult;
import com.fineqt.fpb.lib.constraint.PTypeConstraintExt;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.dump.DumpLine;
import com.fineqt.fpb.lib.dump.FieldDumpLine;
import com.fineqt.fpb.lib.dump.TopTypeDumpLine;
import com.fineqt.fpb.lib.meta.PEnumItemExt;
import com.fineqt.fpb.lib.meta.PFactoryExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.CommonContext;
import com.fineqt.fpb.lib.meta.context.DebugDecodeContext;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.evattr.CxtAttrFieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.FieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.FieldRefOperation;
import com.fineqt.fpb.lib.meta.evattr.OwnerFieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.PFpbTypeEVAttrsImpl;
import com.fineqt.fpb.lib.meta.evattr.RegionRefDesc;
import com.fineqt.fpb.lib.meta.evattr.ResultPrpFieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.StackFieldOperation;
import com.fineqt.fpb.lib.meta.evattr.StackFieldRefDesc;
import com.fineqt.fpb.lib.meta.evattr.TypeFieldRefDesc;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.impl.PElementExtBase;
import com.fineqt.fpb.lib.meta.property.PPropertyListExt;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.OnelineMode;
import com.fineqt.fpb.lib.model.fpbmodule.PEntityType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.TypeDerivativeMode;
import com.fineqt.fpb.lib.system.PFpbSystem;
import com.fineqt.fpb.lib.type.CreatePTypeValueParamaters;
import com.fineqt.fpb.lib.type.PEntityTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbFieldEVExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PItemFieldEVExt;
import com.fineqt.fpb.lib.type.PTypeEVAttrs;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.BitRegionImpl;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.lib.value.PContainerValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

abstract public class PEntityTypeExtBase extends PTypeExtBase implements PEntityTypeExt {
	private String name;
	private TypeClass typeClass;
	
	public PEntityTypeExtBase(PType pmodel, PModuleExt pmoduleExt) {
		super(pmodel, pmoduleExt);
		typeClass = ((PEntityType)pmodel).getTypeClass();
		name = pmodel.getName();
	}

	@Override
	public PTypeExt getSuperType() {
		return null;
	}

	@Override
	public TypeClass getTypeClass() {
		return typeClass;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public TypeDerivativeMode getDerivativeMode() {
		return TypeDerivativeMode.ENTITY;
	}
	
	@Override
	public boolean isContainerType() {
		return false;
	}

	@Override
	public boolean isListType() {
		return false;
	}

	@Override
	public boolean isPrimitiveType() {
		return false;
	}
	
	@Override
	public void setSuperType(PTypeExt type) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PEntityTypeExt getRootType() {
		return this;
	}
	
	@Override
	public boolean isImport() {
		return false;
	}

	@Override
	public PValue createEmptyValue() {
		return PFpbSystem.PINSTANCE.getInternalValueFactory().createValue(this, 
				PTypeExt.InternalValueFactory.CreationMode.EMPTY);
	}

	@Override
	public PValue createNormalValue(CreatePTypeValueParamaters paras) {
		return PFpbSystem.PINSTANCE.getInternalValueFactory().createValue(this, 
				PTypeExt.InternalValueFactory.CreationMode.NORMAL);
	}

	@Override
	public PValue createOmitValue() {
		return PFpbSystem.PINSTANCE.getInternalValueFactory().createValue(this, 
				PTypeExt.InternalValueFactory.CreationMode.OMIT);
	}

	@Override
	protected void doInit() throws InitMetaException {
		//父类方法
		super.doInit();
		PEntityType entityModel = (PEntityType)pmodel;
		//编译自己限制信息
		if (entityModel.getConstraint() != null) {
			PTypeConstraintExt cons = extFactory.createTypeConstraint(this, 
					entityModel.getConstraint());
			pconstraints.addConstraint(cons);
		}
	}

	public static abstract class PFpbEntityEVExt extends PElementExtBase 
	implements PFpbTypeEVExt {
		protected PFpbTypeEVAttrs fpbTypeEVAttrs;
		protected PTypeExt targetTypeMeta;
		protected PTypeExt ownerTypeMeta;
		protected PFpbTypeEV model;
		private PPropertyListExt initPropertyList;
		
		public PFpbEntityEVExt(PFpbTypeEV pmodel) {
			super(pmodel, null);
		}

		@Override
		public PFpbTypeEVAttrs getFpbTypeEVAttrs() {
			return fpbTypeEVAttrs;
		}


		@Override
        public PTypeEVAttrs getTypeEVAttrs() {
            return fpbTypeEVAttrs;
        }

        @Override
		public void setInitPropertyList(PPropertyListExt prpList) {
			initPropertyList = prpList;
		}

		@Override
		public PModuleExt getPModule() {
			return targetTypeMeta.getPModule();
		}

		protected PFpbTypeEV getFpbModel() {
			return (PFpbTypeEV)pmodel;
		}
		
		@Override
		public PTypeExt getTargetTypeMeta() {
			return targetTypeMeta;
		}

		@Override
		public void setTargetTypeMeta(PTypeExt target) {
			targetTypeMeta = target;
		}

		@Override
		public PTypeExt getOnwerTypeMeta() {
			return ownerTypeMeta;
		}

		@Override
		public void setOnwerTypeMeta(PTypeExt owner) {
			ownerTypeMeta = owner;
		}

		@Override
		public EncodingType getEncodingType() {
			return EncodingType.FPB;
		}

		@Override
		public boolean hasSettedAttr() {
			return fpbTypeEVAttrs.hasSettedAttr();
		}

		@Override
		public void init() throws InitMetaException {
			boolean usedExternalPrps = initPropertyList != null;
			//Property List
			if (initPropertyList == null && getFpbModel().getPrpList() != null) {
				initPropertyList = new PPropertyListExt(getFpbModel().getPrpList(), 
						targetTypeMeta); 
				initPropertyList.init();
			}
			//EV Attrs
			fpbTypeEVAttrs = new PFpbTypeEVAttrsImpl(initPropertyList, this);
			//确定是否有没有使用的特性
			if (!usedExternalPrps && initPropertyList != null && 
					initPropertyList.getUnusedProperties().size() != 0) {
				throw new InitMetaException(getPModule(), 
						MetaException.CODE.UNKNOWN_PROPERTIES_ERROR,
						initPropertyList.getUnusedProperties());
			}
			//清空
			initPropertyList = null;
			//DefaultByteOrder
			fpbTypeEVAttrs.setDefaultByteOrder(targetTypeMeta.getPModule().pByteOrder());
		}
		
		@Override
		public int dump(DumpContext cxt, PValue value, String valueName, 
		        PTypeElementMeta elementMeta, int deep)
				throws DumpException {
//			System.out.println("dump:"+targetTypeMeta.getName());
			//null和Omit处理
			if (value == null || value.notPresent()) {
				FieldDumpLine fieldLine = new FieldDumpLine(value, valueName);
				fieldLine.setDeep(deep);
				fieldLine.setTopTypeLine((TopTypeDumpLine)cxt.getCurrentTopType());
				BitRegion valueRegion = new BitRegionImpl(cxt.getOffset(), 0);
				fieldLine.setValueRegion(valueRegion);
				cxt.addDumpLine(fieldLine);
				return 0;
			}
			return doDump(cxt, value, valueName, elementMeta, deep);
		}

		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep)
		throws DumpException {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int encode(EncodeContext cxt, PValue value, int parentLength, 
		        PTypeElementMeta elementMeta, ByteOrder byteOrder) throws EncodeException {
//			System.out.println("encode:"+targetTypeMeta.getName());
			//null
			if (value == null) {
				throw new EncodeException(targetTypeMeta, 
						MetaException.CODE.NULL_VALUE_ERROR); 
			}
			//忽略Omit,检查是否是optional
			if (value.notPresent()) {
				if (value.pFieldMeta() != null && !value.pFieldMeta().isOptional()) {
					throw new EncodeException(targetTypeMeta, 
							MetaException.CODE.OMIT_FIELD_NOT_ALLOWED_ERROR, 
							value.pFieldMeta().getFullFieldName());
				}
				return 0;
			}
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			//byteOrder(自己的优先)
			ByteOrder nextByteOrder = byteOrder;
			if (fpbTypeEVAttrs.getByteorder(priorityAttrs) != ByteOrder.NONE) {
				nextByteOrder = fpbTypeEVAttrs.getByteorder(priorityAttrs);
			}
			//前置处理
			preEncode(cxt, value, parentLength, elementMeta, byteOrder);
			//实质处理
			int len = doEncode(cxt, value, parentLength, elementMeta, nextByteOrder);
			//后置处理
			return postEncode(cxt, value, parentLength, elementMeta, len, nextByteOrder);
		}

		protected int doEncode(EncodeContext cxt, PValue value, int parentLength, 
		        PTypeElementMeta elementMeta, ByteOrder byteOrder) throws EncodeException {
			throw new UnsupportedOperationException();
		}
		
		protected void preEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta, ByteOrder byteOrder) {
		    PFpbTypeEVAttrs priorityAttrs  = 
		        (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			//pushEmptyField
			List<StackFieldOperation> pushEmptField = 
				fpbTypeEVAttrs.getPushEmptyField(priorityAttrs);
			if (pushEmptField != null) {
				for (StackFieldOperation op : pushEmptField) {
					if (op.getTimings().contains(FieldRefOperation.Timing.ENCODE)&& cxt.withEncodeAction() ||
							op.getTimings().contains(FieldRefOperation.Timing.CALCULATE)&& cxt.withCalculateAction() ||
							op.getTimings().contains(FieldRefOperation.Timing.GETSIZE)&& cxt.withGetSizeAction()) {
						cxt.getFieldStackMap().pushField(op.getField(), null);
					}
				}
			}
		}

		protected int postEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta, 
				int selfLength, ByteOrder byteOrder) 
		throws EncodeException {
            PFpbTypeEVAttrs priorityAttrs  = 
                (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			int resultLength = selfLength;
			//作字段值计算
			if (cxt.withCalculateAction()) {
				//lengthRef
				FieldRefDesc lengthRef = fpbTypeEVAttrs.getLengthRef(priorityAttrs);
				if (lengthRef != null) {
					//取得最先找到的引用字段
					PValue refValue = findRefValue(cxt, value, value.pParent(), null, lengthRef);;
					//设置被引用字段的值
					if (refValue != null && fpbTypeEVAttrs.isRefreshLengthRef(priorityAttrs)) {
						int lenFieldValue = calculateRefValueByLength(
								selfLength, fpbTypeEVAttrs.getLengthMultiplier(priorityAttrs), 
								fpbTypeEVAttrs.getLengthIncrement(priorityAttrs));
						setIntValue(refValue, lenFieldValue);
					}
				} else {
					//TODO Warning or Debug
				}
			}
			//pushEmptyField(弹出前置事件中压入的项目)
			List<StackFieldOperation> pushEmptyField = 
					fpbTypeEVAttrs.getPushEmptyField(priorityAttrs);
			if (pushEmptyField != null) {
				for (StackFieldOperation op : pushEmptyField) {
					if (op.getTimings().contains(FieldRefOperation.Timing.ENCODE)&& cxt.withEncodeAction() ||
							op.getTimings().contains(FieldRefOperation.Timing.CALCULATE)&& cxt.withCalculateAction() ||
							op.getTimings().contains(FieldRefOperation.Timing.GETSIZE)&& cxt.withGetSizeAction()) {
						cxt.getFieldStackMap().popField(op.getField());
					}
				}
			}
			return resultLength;
		}
		
		@Override
		public DecodeResult decode(DecodeContext cxt, IReadableBitBuffer input, 
		        PTypeElementMeta elementMeta, DecodeParameters paras)
				throws DecodeException {
//		    System.out.println("decode:"+targetTypeMeta.getName());
			DecodeResult parentResult = paras.getParentResult();
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			//生成Result
			DecodeResult result = createDecodeResult(cxt);
			PValue parentValue = parentResult == null?null:parentResult.getValue();
			//有selectRef或selectRefRegion设置但是没有选中
			try {
				if (!isSelectedFromRefValue(cxt, input, parentValue, result, priorityAttrs)) {
					return result;
				}
			} catch (BitBufferException e) {
				throw new DecodeException(targetTypeMeta, 
						MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
			}
			//Input没有剩余空间的处理(在外部FieldMeta的decode方法中会将值设置为omit)
			if (!cxt.isIncrement() || !input.useCapacityAsLimit()) {
	            if (!input.hasRemaining() && elementMeta.isOptional()) {
	                return result;
	            }
			}
			//byteOrder(自己的优先)
			ByteOrder nextByteOrder = paras.getByteOrder();
			if (fpbTypeEVAttrs.getByteorder(priorityAttrs) != ByteOrder.NONE) {
				nextByteOrder = fpbTypeEVAttrs.getByteorder(priorityAttrs);
			}
			paras.setByteOrder(nextByteOrder);
			//前置处理
			if (preDecode(cxt, input, elementMeta, paras, result)) {
	            //实质处理
	            doDecode(cxt, input, elementMeta, paras, result);
			}
			//后续处理
			result = postDecode(cxt, input, elementMeta, paras, result);
			return result;
		}

		/**
		 * 推断字段的解码固定长度。在增量解码的情况下同时确保有足够的已获得数据。
		 */
		protected void assumeFixedDecodeLength(DecodeContext cxt, 
		        IReadableBitBuffer input, PTypeElementMeta elementMeta, DecodeParameters paras, 
                DecodeResult result) throws DecodeException {
		    //默认没有有效固定长度
		    paras.setHypFixedLength(-1);
		}
		
		protected boolean preDecode(DecodeContext cxt, IReadableBitBuffer input, 
		        PTypeElementMeta elementMeta, DecodeParameters paras, 
				DecodeResult result) 
		throws DecodeException {
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			//推断字段的解码固定长度
			assumeFixedDecodeLength(cxt, input, elementMeta, paras, result);
			//pushEmptyField
			List<StackFieldOperation> pushEmptyField = 
				fpbTypeEVAttrs.getPushEmptyField(priorityAttrs);
			if (pushEmptyField != null) {
				for (StackFieldOperation op : pushEmptyField) {
					if (op.getTimings().contains(FieldRefOperation.Timing.DECODE)) {
						cxt.getFieldStackMap().pushField(op.getField(), null);
					}
				}
			}
			return true;
		}
		
		protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer input, 
		        PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult result)
		throws DecodeException {
			throw new UnsupportedOperationException();
		}
		
		protected DecodeResult postDecode(DecodeContext cxt, IReadableBitBuffer input, 
		        PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult result)
		throws DecodeException {
			PFpbTypeEVAttrs priorityAttrs = (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs();
			//pushEmptyField(弹出前置事件压入项目)
			List<StackFieldOperation> pushEmptyField = 
				fpbTypeEVAttrs.getPushEmptyField(priorityAttrs);
			if (pushEmptyField != null) {
				for (StackFieldOperation op : pushEmptyField) {
					if (op.getTimings().contains(FieldRefOperation.Timing.DECODE)) {
						cxt.getFieldStackMap().popField(op.getField());
					}
				}
			}
			return result;
		}
		
		protected DecodeResult createDecodeResult(DecodeContext cxt) throws DecodeException {
			Class<? extends DecodeResult> resultClass = getDecodeResultClass();
			DecodeResult result;
			try {
				result = resultClass.newInstance();
			} catch (Exception e) {
				throw new DecodeException(targetTypeMeta, 
						MetaException.CODE.DECODE_RESULT_OBJECT_CREATING_ERROR, e);
			}
			if (IFpbSystem.INSTANCE.isDebug()) {
				DebugDecodeContext debugCxt = (DebugDecodeContext)cxt;
				debugCxt.addResult(result);
			}
			return result;
		}
		
		public  Class<? extends DecodeResult> getDecodeResultClass() {
			return SimpleDecodeResult.class;
		}
		
		protected void setIntValue(PValue value, int newValue) {
			switch(value.pTypeMeta().getTypeClass()) {
			case INTEGER:
				PIntegerValue intValue = (PIntegerValue)value;
				intValue.setInteger(newValue);
				break;
			default:
				//由于改变Charstring等类型的值会改变他们的长度，影响已作过的长度计算，所以其他类型不作处理
				break;
			}
		}
		
		protected int getIntValue(PValue value) {
			switch(value.pTypeMeta().getTypeClass()) {
			case INTEGER:
				PIntegerValue intValue = (PIntegerValue)value;
				return intValue.getInteger();
			case CHARSTRING:
				PCharstringValue charValue = (PCharstringValue)value;
				try {
					return Integer.parseInt(new String(charValue.getValue()));
				} catch (NumberFormatException e) {
					return -1;
				}
			case UNIVERSAL_CHARSTRING:
				PUCharstringValue ucharValue = (PUCharstringValue)value;
				try {
					return Integer.parseInt(new String(ucharValue.getValue()));
				} catch (NumberFormatException e) {
					return -1;
				}
			}
			return -1;
		}
		
		protected PValue findRefValue(CommonContext cxt, PValue targetTypeValue, PValue parentValue,
				DecodeResult decodeResult, FieldRefDesc refDesc) {
			PValue refValue = null;
			switch(refDesc.getType()) {
			case CONTEXT_ATTRIBUTE:
				CxtAttrFieldRefDesc caRefDesc = (CxtAttrFieldRefDesc)refDesc;
				refValue = caRefDesc.findRefValue(cxt);
				break;
			case STACK:
				StackFieldRefDesc sfRefDesc = (StackFieldRefDesc)refDesc;
				refValue = sfRefDesc.findRefValue(cxt.getFieldStackMap());
				break;
			case OWNER_FIELD:
				OwnerFieldRefDesc ofRefDesc = (OwnerFieldRefDesc)refDesc;
				if (parentValue != null && (parentValue instanceof PContainerValue)) {
					refValue = ofRefDesc.findRefValue((PContainerValue)parentValue);
				}
				break;
			case TYPE_FIELD:
				TypeFieldRefDesc tfRefDesc = (TypeFieldRefDesc)refDesc;
				if (targetTypeValue != null && (targetTypeValue instanceof PContainerValue)) {
					refValue = tfRefDesc.findRefValue((PContainerValue)targetTypeValue);
				}
				break;
			case RESULT_PROPERTY:
				ResultPrpFieldRefDesc rpRefDesc = (ResultPrpFieldRefDesc)refDesc;
				if (rpRefDesc != null && decodeResult != null) {
					return rpRefDesc.findRefValue(decodeResult);
				}
				break;
			}
			return refValue;
		}

		protected int calculateRefValueByLength(int length, int multiplier, int increment) {
			return (length - increment ) / multiplier ;
		}
		
		protected int calculateLengthValueByRef(int refValue, int multiplier, int increment) {
			return refValue * multiplier + increment;
		}

		//根据fixedLength和input的剩余长度来推测字段的长度
	    protected int getPrimitiveHypLength(IReadableBitBuffer input, int fixedLength) {	    
			//有效固定长度
			if (fixedLength >= 0) {
				return fixedLength;
			//剩余所有长度
			} else {
				return input.remaining();
			}
		}
		
		//根据lengthRef, onelineMode, constraint的fixedLength取得字段的固定长度,如果没有固定长度
		//则返回-1。
		protected int getFixedLength(DecodeContext cxt, IReadableBitBuffer input,
				PValue parentValue, DecodeResult selfResult, PTypeConstraintStorage constraint, 
				int constraintLengthMultiplier, PFpbTypeEVAttrs priorityAttrs)
				throws BitBufferException {
			int fixedLength = -1;
			//根据限制条件
			if (constraint != null) {
			    fixedLength = constraint.getFixedLength();
			}
			if (fixedLength < 0 ) {
				FieldRefDesc lengthRef = fpbTypeEVAttrs.getLengthRef(priorityAttrs);
				//LengthRef
				if (lengthRef != null) {
					PValue lengthRefValue = findRefValue(cxt, selfResult.getValue(), parentValue, selfResult, lengthRef);
					if (lengthRefValue != null) {
						fixedLength = calculateLengthValueByRef(
								getIntValue(lengthRefValue), 
								fpbTypeEVAttrs.getLengthMultiplier(priorityAttrs), 
								fpbTypeEVAttrs.getLengthIncrement(priorityAttrs));
					}
					//增量模式处理
					if (cxt.isIncrement() && fixedLength > 0) {
					    IEnsurableBitBuffer eBuffer = (IEnsurableBitBuffer)cxt.getOrgInput();
					    eBuffer.ensureSpace(input.arrayOffset() + input.position(), 
					            fixedLength);					    
					}
				//OnelineMode
				} else if (fpbTypeEVAttrs.getOnelineMode(priorityAttrs) != OnelineMode.NONE) {
					fixedLength = getOnelineLength(cxt, input, priorityAttrs, fixedLength);
				//RestOfData
				} else if (fpbTypeEVAttrs.isRestOfData(priorityAttrs)) {
				    fixedLength = calculateLengthValueByRef(input.remaining(), 1, 
				            fpbTypeEVAttrs.getLengthIncrement(priorityAttrs));
				}
			} else {
				fixedLength *= constraintLengthMultiplier;
                //增量模式处理
                if (cxt.isIncrement() && fixedLength > 0) {
                    IEnsurableBitBuffer eBuffer = (IEnsurableBitBuffer)cxt.getOrgInput();
                    eBuffer.ensureSpace(input.arrayOffset() + input.position(), 
                            fixedLength);                       
                }
			}
			return fixedLength;
		}

        private int getOnelineLength(DecodeContext cxt, IReadableBitBuffer input,
                PFpbTypeEVAttrs priorityAttrs, int fixedLength) throws BitBufferException {
            OnelineMode mode = fpbTypeEVAttrs.getOnelineMode(priorityAttrs);
            //固定缓存模式
            if (!cxt.isIncrement()) {
                char[] serachChars;
                switch(mode) {
                case CR:
                    serachChars = FpbConstants.CR_CHARS;
                    break;
                case CRLF:
                    serachChars = FpbConstants.CRLF_CHARS;
                    break;
                default:
                    serachChars = FpbConstants.LF_CHARS;
                    break;
                }
                int orgPos = input.position();
                int lineEndPos = -1;
                try {
                    for (int i = input.position(); i < input.limit(); i++) {
                        char ch = (char)input.getByte();
                        //第一个字符
                        if (ch == serachChars[0]) {
                            //只有一个字符
                            if (serachChars.length == 1) {
                                lineEndPos = input.position();
                                break;
                            //第二个字符
                            } else if (i+1 < input.limit()){
                                i++;
                                ch = (char)input.getByte();
                                if (ch == serachChars[1]) {
                                    lineEndPos = input.position();
                                    break;
                                }
                            }
                        }
                    }
                    if (lineEndPos >= 0) {
                        fixedLength = lineEndPos - orgPos;
                    }
                } finally {
                    input.position(orgPos);
                }
            //增量缓存模式
            } else {
                byte[] searchBytes;
                switch(mode) {
                case CR:
                    searchBytes = FpbConstants.CR_BYTES;
                    break;
                case CRLF:
                    searchBytes = FpbConstants.CRLF_BYTES;
                    break;
                default:
                    searchBytes = FpbConstants.LF_BYTES;
                    break;
                }
                IEnsurableBitBuffer eBuffer = (IEnsurableBitBuffer) cxt.getOrgInput();
                assert (input.arrayOffset() + input.position()) % FpbConstants.OCTET_BITS == 0;
                int byteOffset = (input.arrayOffset() + input.position())
                        / FpbConstants.OCTET_BITS;
                fixedLength = eBuffer.ensureBytes(byteOffset, searchBytes);
                if (fixedLength > 0) {
                    fixedLength *= FpbConstants.OCTET_BITS;
                }
            }
            return fixedLength;
        }

		/**
		 * @return 如果有selectRef或selectRefRegion设置但是没有选中则返回false, 否则返回true。
		 */
		protected boolean isSelectedFromRefValue(DecodeContext cxt, IReadableBitBuffer input,
				PValue parentValue, DecodeResult selfResult, PFpbTypeEVAttrs priorityAttrs) 
		throws BitBufferException, DecodeException  {
			boolean selected = false;
			FieldRefDesc selectRef = fpbTypeEVAttrs.getSelectRef(priorityAttrs);
			RegionRefDesc selectRefRegion = fpbTypeEVAttrs.getSelectRefRegion(priorityAttrs);
			List<PTypeConstraintExt> selectCond  = fpbTypeEVAttrs.getSelectCond(priorityAttrs);
			//SelectRef
			if (selectRef != null) {
				if (selectCond == null) {
					throw new DecodeException(getTargetTypeMeta(), 
							MetaException.CODE.NOT_MATCHED_REF_AND_COND_ERROR, 
							"selectRef");
				}
				PValue selectRefValue = findRefValue(cxt, selfResult.getValue(), parentValue, 
						selfResult, selectRef);
				if (selectRefValue != null ) {
					selected = true;
					for (int i = 0; i < selectCond.size(); i++) {
						if (!selectCond.get(i).validate(selectRefValue)) {
							selected = false;
							break;
						}
					}
				}
			//SelectRefRegion
			} else if (selectRefRegion != null) {
				if (selectCond == null) {
					throw new DecodeException(getTargetTypeMeta(), 
							MetaException.CODE.NOT_MATCHED_REF_AND_COND_ERROR, 
							"selectRefRegion");
				}
				PValue refValue = getRefRegionValue(cxt, selectRefRegion, input);
				if (refValue != null) {
					selected = true;
					//验证有效性
					for (int i = 0; i < selectCond.size(); i++) {
						if (!selectCond.get(i).validate(refValue)) {
							selected = false;
							break;
						}
					}
				}
			//没有设置
			} else {
				selected = true;
			}
			return selected;
		}
		
		/**
		 * 
		 * @param refRegion
		 * @param input
		 * @return 没有对应引用值，如Input的剩余数据长度不够，则返回null
		 */
		protected PValue getRefRegionValue(DecodeContext cxt, RegionRefDesc refRegion, 
		        IReadableBitBuffer input) 
		throws BitBufferException {
            //确保增量解码时的空间
            if (cxt.isIncrement()) {
                IEnsurableBitBuffer eBuffer = (IEnsurableBitBuffer)cxt.getOrgInput();
                eBuffer.ensureSpace(input.arrayOffset() + input.position(), 
                        refRegion.getOffset()+refRegion.getLength());
            }
			int orgPos = input.position();
            PValue result;
			//没有足够长度
			if (orgPos + refRegion.getOffset() + refRegion.getLength() > input.limit()) {
				result = null;
			//有足够长度
			} else {
				byte data[] = new byte[refRegion.getLength() + 7 / FpbConstants.OCTET_BITS];
				TextBitset bitset;
				try {
					//取得数据
					input.position(orgPos + refRegion.getOffset());
					input.getBit(data, refRegion.getLength());
					bitset = new NativeTextBitset(data);
					bitset.resize(refRegion.getLength());
				} finally {
					//恢复Input的位置
					input.position(orgPos);
				}
				PFactoryExt factory = getPModule().pPFactory(); 
				switch(refRegion.getRefFieldType().getTypeClass()) {
				case INTEGER:
				    IIntegerValue intValue = factory.createInteger();
				    intValue.setLong(bitset.getAsInteger());
				    result = (PValue)intValue;
				    break;
				case OCTETSTRING:
				    IOctetstringValue octValue = factory.createOctetstring();
				    octValue.setValue(bitset.getRaw());
				    result = (PValue)octValue;
				    break;
				case CHARSTRING:
				    ICharstringValue strValue = factory.createCharstring();
				    byte[] bytes = bitset.getRaw();
				    strValue.setLength(bytes.length);
				    for (int i = 0; i < bytes.length; i++) {
                        strValue.setChar(i, (char)bytes[i]);
                    }
				    result = (PValue)strValue;
				    break;
				default:
				    assert false;
			        result = null;
				    break;
				}
			}
            return result;
		}
		
		/**
		 * 根据推测长度来生成新的Input。
		 * @return 可能就是orgInput本生，没有足够剩余数据时返回null。
		 */
		protected IReadableBitBuffer createTargetInputByFixedLength(IReadableBitBuffer orgInput, 
		        int fixedLength) {
			IReadableBitBuffer targetInput = orgInput;
			//生成Input
			if (fixedLength >= 0) {
				//没有足够剩余数据
				if (fixedLength > orgInput.remaining()) {
					return null;
				}
				targetInput = orgInput.subBitBuffer(orgInput.position(), fixedLength);
			}
			return targetInput;
		}
		
		protected DumpLine createAndAddDumpLine(DumpContext cxt, PValue value, 
				String valueName, int deep, PFpbTypeEVAttrs priorityAttrs) {
			DumpLine line;
			PFieldExt fieldMeta = value.pFieldMeta();
			boolean isProtocol = false;
			if (value.isContainer()) {
				isProtocol = fpbTypeEVAttrs.isProtocol(priorityAttrs);
			}
			//非协议字段类型
			if (cxt.getAllTopTypeLines().size() > 0 && !isProtocol) {
				FieldDumpLine fieldLine = new FieldDumpLine(value, valueName);
				//TopType
				fieldLine.setTopTypeLine((TopTypeDumpLine)cxt.getCurrentTopType());
				//可能是List成员，则fieldMeta为null
				if (fieldMeta != null) {
					//FlagType
					PItemFieldEVExt fieldEVMeta = fieldMeta.getEVMeta();
					if (fieldEVMeta instanceof PFpbFieldEVExt) {
						fieldLine.setFlagType(((PFpbFieldEVExt)fieldEVMeta).getFlagType());
					}
					//EnumName
					List<PEnumItemExt> enums = fieldMeta.getEnumItems();
					for (PEnumItemExt enumItem : enums) {
						if (enumItem.match(value)) {
							fieldLine.setEnumName(enumItem.getName());
							break;
						}
					}
				}
				line = fieldLine;
			//第一个字段或者协议类型
			} else {
				TopTypeDumpLine typeLine = new TopTypeDumpLine(value);
				//Protocol
				typeLine.setProtocol(isProtocol);
				line = typeLine;
				//非第一个子段是同时追加FieldLine
				if (cxt.getAllTopTypeLines().size() > 0) {
					FieldDumpLine fieldLine = new FieldDumpLine(value, valueName);
					//TopType
					if (cxt.getCurrentTopType() != null) {
						fieldLine.setTopTypeLine((TopTypeDumpLine)cxt.getCurrentTopType());
					}
					//TypeName
					fieldLine.setEnumName(typeLine.getName());
					//ValueRange
					fieldLine.setValueRangeRef(typeLine);
					//Deep
					fieldLine.setDeep(deep);
					//Add
					cxt.addDumpLine(fieldLine);
				}
				cxt.getAllTopTypeLines().add(typeLine);
			}
			//Deep
			line.setDeep(deep);
			//Add Line
			cxt.addDumpLine(line);
			return line;
		}
		
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.appendSuper(super.toString())
				.append("fpbTypeEVAttrs", fpbTypeEVAttrs)
				.toString();
		}
	}
}
