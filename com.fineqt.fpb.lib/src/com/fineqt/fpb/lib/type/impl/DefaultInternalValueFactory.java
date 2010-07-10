package com.fineqt.fpb.lib.type.impl;

import com.fineqt.fpb.lib.builtin.impl.PBitstringValueImpl;
import com.fineqt.fpb.lib.builtin.impl.PBooleanValueImpl;
import com.fineqt.fpb.lib.builtin.impl.PCharstringValueImpl;
import com.fineqt.fpb.lib.builtin.impl.PFloatValueImpl;
import com.fineqt.fpb.lib.builtin.impl.PHexstringValueImpl;
import com.fineqt.fpb.lib.builtin.impl.PIntegerValueImpl;
import com.fineqt.fpb.lib.builtin.impl.POctetstringValueImpl;
import com.fineqt.fpb.lib.builtin.impl.PUCharstringValueImpl;
import com.fineqt.fpb.lib.builtin.impl.PVerdictValueImpl;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PRecordSetOfValue;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.SimpleEnumeratedValue;
import com.fineqt.fpb.lib.value.SimpleRecordSetValue;
import com.fineqt.fpb.lib.value.SimpleUnionValue;

public class DefaultInternalValueFactory implements PTypeExt.InternalValueFactory {

	@Override
	public PValue createValue(PTypeExt type, CreationMode mode) {
		switch(mode) {
		case OMIT:
			return createOmitValue(type);
		case EMPTY:
			return createEmptyValue(type);
		case NORMAL:
			return createNormalValue(type);
		}
		assert false;
		return null;
	}

	private PValue createOmitValue(PTypeExt type) {
		switch(type.getTypeClass()) {
		case ADDRESS:
			assert false;
			return null;
		case BITSTRING:
			return PBitstringValueImpl.createValue(type, true);
		case BOOLEAN:
			return PBooleanValueImpl.createValue(type, true);
		case CHARSTRING:
			return PCharstringValueImpl.createValue(type, true);
		case ENUMERATED:
			return SimpleEnumeratedValue.createValue(type, true);
		case FLOAT:
			return PFloatValueImpl.createValue(type, true);
		case HEXSTRING:
			return PHexstringValueImpl.createValue(type, true);
		case INTEGER:
			return PIntegerValueImpl.createValue(type, true);
		case OBJID:
			assert false;
			return null;
		case OCTETSTRING:
			return POctetstringValueImpl.createValue(type, true);
		case RECORD:
			return SimpleRecordSetValue.createValue(type, true);
		case RECORDOF:
			return PRecordSetOfValue.createValue(PValue.class, type, true);
		case SET:
			return SimpleRecordSetValue.createValue(type, true);
		case SETOF:
			return PRecordSetOfValue.createValue(PValue.class, type, true);
		case UNION:
			return SimpleUnionValue.createValue(type, true);
		case UNIVERSAL_CHARSTRING:
			return PUCharstringValueImpl.createValue(type, true);
		case VERDICT:
			return PVerdictValueImpl.createValue(type, true);
		}
		assert false;
		return null;
	}

	private PValue createEmptyValue(PTypeExt type) {
		switch(type.getTypeClass()) {
		case ADDRESS:
			assert false;
			return null;
		case BITSTRING:
			return PBitstringValueImpl.createValue(type, false);
		case BOOLEAN:
			return PBooleanValueImpl.createValue(type, false);
		case CHARSTRING:
			return PCharstringValueImpl.createValue(type, false);
		case ENUMERATED:
			return SimpleEnumeratedValue.createValue(type, false);
		case FLOAT:
			return PFloatValueImpl.createValue(type, false);
		case HEXSTRING:
			return PHexstringValueImpl.createValue(type, false);
		case INTEGER:
			return PIntegerValueImpl.createValue(type, false);
		case OBJID:
			assert false;
			return null;
		case OCTETSTRING:
			return POctetstringValueImpl.createValue(type, false);
		case RECORD:
			return SimpleRecordSetValue.createEmptyValue(type);
		case RECORDOF:
			return PRecordSetOfValue.createValue(type, false);
		case SET:
			return SimpleRecordSetValue.createEmptyValue(type);
		case SETOF:
			return PRecordSetOfValue.createValue(type, false);
		case UNION:
			return SimpleUnionValue.createEmptyValue(type);
		case UNIVERSAL_CHARSTRING:
			return PUCharstringValueImpl.createValue(type, false);
		case VERDICT:
			return PVerdictValueImpl.createValue(type, false);
		}
		assert false;
		return null;
	}
	
	private PValue createNormalValue(PTypeExt type) {
		switch(type.getTypeClass()) {
		case ADDRESS:
			assert false;
			return null;
		case BITSTRING:
			return PBitstringValueImpl.createValue(type, false);
		case BOOLEAN:
			return PBooleanValueImpl.createValue(type, false);
		case CHARSTRING:
			return PCharstringValueImpl.createValue(type, false);
		case ENUMERATED:
			return SimpleEnumeratedValue.createValue(type, false);
		case FLOAT:
			return PFloatValueImpl.createValue(type, false);
		case HEXSTRING:
			return PHexstringValueImpl.createValue(type, false);
		case INTEGER:
			return PIntegerValueImpl.createValue(type, false);
		case OBJID:
			assert false;
			return null;
		case OCTETSTRING:
			return POctetstringValueImpl.createValue(type, false);
		case RECORD:
			return SimpleRecordSetValue.createValue(type, false);
		case RECORDOF:
			return PRecordSetOfValue.createValue(PValue.class, type, false);
		case SET:
			return SimpleRecordSetValue.createValue(type, false);
		case SETOF:
			return PRecordSetOfValue.createValue(PValue.class, type, false);
		case UNION:
			return SimpleUnionValue.createValue(type, false);
		case UNIVERSAL_CHARSTRING:
			return PUCharstringValueImpl.createValue(type, false);
		case VERDICT:
			return PVerdictValueImpl.createValue(type, false);
		}
		assert false;
		return null;
	}
	
}
