package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.StringOneLine;

public class StringOneLineImpl extends PRecordSetValueBase implements StringOneLine {
	private PCharstringValue token1;
	private PCharstringValue ws1;
	private PCharstringValue token2;
	private POctetstringValue crlf;
	
	public static StringOneLine createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitStringOneLine(meta);
		} else {
			return new StringOneLineImpl(meta, false);
		}
	}
	
	public static StringOneLine createEmptyValue(PTypeElementMeta meta) {
		return new StringOneLineImpl(meta, true);
	}

	protected StringOneLineImpl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//设置初始值
			token1 = (PCharstringValue)createDefaultFieldValue(BuiltintestModule.STRING_ONE_LINE__TOKEN1);

			ws1 = (PCharstringValue)createDefaultFieldValue(BuiltintestModule.STRING_ONE_LINE__WS1);

			token2 = (PCharstringValue)createDefaultFieldValue(BuiltintestModule.STRING_ONE_LINE__TOKEN2);
			
			crlf = (POctetstringValue)createDefaultFieldValue(BuiltintestModule.STRING_ONE_LINE__CRLF);
		}
	}


	@Override
	public PValue pGetFieldByID(int fieldId) {
		//取得值
		switch(fieldId) {
		case BuiltintestModule.STRING_ONE_LINE__TOKEN1:
			return token1;
		case BuiltintestModule.STRING_ONE_LINE__WS1:
			return ws1;
		case BuiltintestModule.STRING_ONE_LINE__TOKEN2:
			return token2;
        case BuiltintestModule.STRING_ONE_LINE__CRLF:
            return crlf;
		}
		return null;
	}

	@Override
	public void pSetFieldByID(int fieldId, PValue newValue) {
		//赋值
		switch(fieldId) {
		case BuiltintestModule.STRING_ONE_LINE__TOKEN1:
			token1 = (PCharstringValue)assignNewFieldValue(fieldId, token1, newValue);
			break;
		case BuiltintestModule.STRING_ONE_LINE__WS1:
			ws1 = (PCharstringValue)assignNewFieldValue(fieldId, ws1, newValue);
			break;
		case BuiltintestModule.STRING_ONE_LINE__TOKEN2:
			token2 = (PCharstringValue)assignNewFieldValue(fieldId, token2, newValue);
			break;
        case BuiltintestModule.STRING_ONE_LINE__CRLF:
            crlf = (POctetstringValue)assignNewFieldValue(fieldId, crlf, newValue);
            break;
		}
	}

	public PCharstringValue getToken1() {
		return token1;
	}

	public PCharstringValue getWs1() {
		return ws1;
	}

	public PCharstringValue getToken2() {
		return token2;
	}
	
	@Override
    public IOctetstringValue getCrlf() {
        return crlf;
    }

    protected static class OmitStringOneLine extends OmitPRecordSetValueBase 
	implements StringOneLine {

		public OmitStringOneLine(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public PCharstringValue getToken1() {
			throw new OmitValueException();
		}

		@Override
		public PCharstringValue getToken2() {
			throw new OmitValueException();
		}

		@Override
		public PCharstringValue getWs1() {
			throw new OmitValueException();
		}

        @Override
        public IOctetstringValue getCrlf() {
            throw new OmitValueException();
        }
		
	}

}
