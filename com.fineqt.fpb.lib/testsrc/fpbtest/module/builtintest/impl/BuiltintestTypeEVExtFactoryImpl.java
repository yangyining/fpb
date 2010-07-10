package fpbtest.module.builtintest.impl;

import java.math.BigInteger;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.SimpleEnumeratedType;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.SerializeUtil;
import com.fineqt.fpb.lib.value.PEnumeratedValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.StringBlock;
import fpbtest.module.builtintest.StringOneLine;

public class BuiltintestTypeEVExtFactoryImpl extends PUserTypeEVExtFactoryBase {
	
	@Override
	protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta,
			PFpbTypeEV evModel) {
		switch (typeMeta.getID()) {
		case BuiltintestModule.FIELD_NAME:
			return new FieldNameEVExt(evModel);
		case BuiltintestModule.STRING_BLOCK:
			return new StringBlockTypeEVExt(evModel);
		}
		return super.createTypeEVExt4FPB(typeMeta, evModel);
	}

	protected static class FieldNameEVExt extends SimpleEnumeratedType.PEnumeratedEVExt {
		static private int VALUE_LENGT = FpbConstants.OCTET_BITS;
		
		public FieldNameEVExt(PFpbTypeEV model) {
			super(model);
		}
		
		@Override
		protected int doEncode(EncodeContext cxt, PValue value,
				int parentLength, PTypeElementMeta elementMeta,
				ByteOrder byteOrder) throws EncodeException {
			assert value instanceof PEnumeratedValue;
			PEnumeratedValue enumValue = (PEnumeratedValue)value;
			int resultLength = VALUE_LENGT;
			//Encode
			if (cxt.withEncodeAction()) {
				try {
					SerializeUtil.encodeInt4fpb(cxt.getBuffer(), BigInteger.valueOf(enumValue.getEnumValue()), 
							resultLength, byteOrder);
				} catch (BitBufferException e) {
					throw new EncodeException(targetTypeMeta, 
							MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
				}
			}
			return resultLength;
		}
		
		@Override
		protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer input, 
		        PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult result)
		throws DecodeException {
			//Decode
			BigInteger value;
			try {
				value = SerializeUtil.decodeInt4fpb(input, false, VALUE_LENGT, 
						paras.getByteOrder());
			} catch (BitBufferException e) {
				throw new DecodeException(targetTypeMeta, 
						MetaException.CODE.BIT_BUFFER_EXCEPTION_ERROR, e);
			}
			PEnumeratedValue enumValue = (PEnumeratedValue)targetTypeMeta.createEmptyValue();
			enumValue.setEnumByValue(value.intValue());
			result.setValueLength(VALUE_LENGT);
			result.setValue(enumValue);
			return result;
		}
		
		
		@Override
		protected int doDump(DumpContext cxt, PValue value, String valueName,
		        PTypeElementMeta elementMeta, int deep) 
		throws DumpException {
			int resultLength = VALUE_LENGT;
			if (value.notPresent()) {
				resultLength = 0;
			}
			//dump
			dumpPrimitive(cxt, value, valueName, elementMeta.getConstraints(), deep, 
			        resultLength, (PFpbTypeEVAttrs)elementMeta.getPriorityAttrs());
			return resultLength;
		}
		
	}
	
	public static class StringBlockTypeEVExt extends StringBlockType.PFpbRecordEVExt {

		public StringBlockTypeEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		protected int postEncodeField(EncodeContext cxt,
				PValue fieldValue, int parentLength, int fieldLength, PFieldExt fieldMeta,
				ByteOrder byteOrder) throws EncodeException {
			//父类方法
			super.postEncodeField(cxt, fieldValue, parentLength, fieldLength, 
					fieldMeta, byteOrder);
			//根据lines1的长度更新lines1Count.token1
			if (cxt.withCalculateAction()) {
				if (fieldMeta.getFieldID() == BuiltintestModule.STRING_BLOCK__LINES1_COUNT) {
					StringOneLine lines1Count = (StringOneLine)fieldValue;
					StringBlock parentValue = (StringBlock)((PValue)lines1Count).pParent();
					int orgToken1Length = lines1Count.getToken1().getLength() * FpbConstants.CHAR_BITS; 
					int size = parentValue.getLines1().getLength();
					lines1Count.getToken1().setValue(Integer.toString(size).toCharArray());
					//取得字段新的长度并更新lines1Count的长度
					int newToken1Length = lines1Count.getToken1().getLength() * FpbConstants.CHAR_BITS;
					fieldLength += newToken1Length - orgToken1Length;
				}
			}
			return fieldLength;
		}

		
	}
	
}
