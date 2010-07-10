package fpbtest.module.builtintest.impl;

import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.meta.exception.OmitValueException;
import com.fineqt.fpb.lib.value.PRecordSetValueBase;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

import fpbtest.module.builtintest.BuiltintestModule;
import fpbtest.module.builtintest.StringBlock;
import fpbtest.module.builtintest.StringOneLine;

public class StringBlockImpl extends PRecordSetValueBase implements StringBlock {
	private StringOneLine lines1Count;
	private IListValue<StringOneLine> first3line;
	private IListValue<StringOneLine> lines1;
	private IListValue<StringOneLine> lines2;
	
	public static StringBlock createValue(PTypeElementMeta meta, boolean notPresent) {
		if (notPresent) {
			return new OmitStringBlock(meta);
		} else {
			return new StringBlockImpl(meta, false);
		}
	}

	public static StringBlock createEmptyValue(PTypeElementMeta meta) {
		return new StringBlockImpl(meta, true);
	}
	
	@SuppressWarnings("unchecked")
	protected StringBlockImpl(PTypeElementMeta valueMeta, boolean empty) {
		super(valueMeta);
		if (!empty) {
			//候设置初始值
			lines1Count = (StringOneLine)createDefaultFieldValue(
					BuiltintestModule.STRING_BLOCK__LINES1_COUNT);

			first3line = (IListValue<StringOneLine>)createDefaultFieldValue(
					BuiltintestModule.STRING_BLOCK__FIRST3_LINE);
			
			lines1 = (IListValue<StringOneLine>)createDefaultFieldValue(
					BuiltintestModule.STRING_BLOCK__LINES1);
			
			lines2 = (IListValue<StringOneLine>)createDefaultFieldValue(
					BuiltintestModule.STRING_BLOCK__LINES2);
		}
		
	}
	
	
	@Override
	public PValue pGetFieldByID(int fieldId) {
		switch(fieldId) {
		case BuiltintestModule.STRING_BLOCK__LINES1_COUNT:
			return (PValue)lines1Count;
		case BuiltintestModule.STRING_BLOCK__FIRST3_LINE:
			return (PValue)first3line;
		case BuiltintestModule.STRING_BLOCK__LINES1:
			return (PValue)lines1;
		case BuiltintestModule.STRING_BLOCK__LINES2:
			return (PValue)lines2;
		}
		return null;
	}


	@Override
	@SuppressWarnings("unchecked")
	public void pSetFieldByID(int fieldId, PValue newValue) {
		switch(fieldId) {
		case BuiltintestModule.STRING_BLOCK__LINES1_COUNT:
			lines1Count = (StringOneLine)assignNewFieldValue(fieldId, (PValue)lines1Count, newValue);
			break;
		case BuiltintestModule.STRING_BLOCK__FIRST3_LINE:
			first3line = (IListValue<StringOneLine>)assignNewFieldValue(fieldId, (PValue)first3line, newValue);
			break;
		case BuiltintestModule.STRING_BLOCK__LINES1:
			lines1 = (IListValue<StringOneLine>)assignNewFieldValue(fieldId, (PValue)lines1, newValue);
			break;
		case BuiltintestModule.STRING_BLOCK__LINES2:
			lines2 = (IListValue<StringOneLine>)assignNewFieldValue(fieldId, (PValue)lines2, newValue);
			break;
		}
	}


	public StringOneLine getLines1Count() {
		return lines1Count;
	}
	public IListValue<StringOneLine> getFirst3line() {
		return first3line;
	}
	public IListValue<StringOneLine> getLines1() {
		return lines1;
	}
	public IListValue<StringOneLine> getLines2() {
		return lines2;
	}
	
	protected static class OmitStringBlock extends OmitPRecordSetValueBase 
	implements StringBlock {

		public OmitStringBlock(PTypeElementMeta valueMeta) {
			super(valueMeta);
		}

		@Override
		public IListValue<StringOneLine> getFirst3line() {
			throw new OmitValueException();
		}

		@Override
		public IListValue<StringOneLine> getLines1() {
			throw new OmitValueException();
		}

		@Override
		public StringOneLine getLines1Count() {
			throw new OmitValueException();
		}

		@Override
		public IListValue<StringOneLine> getLines2() {
			throw new OmitValueException();
		}
		
	}
	
}
