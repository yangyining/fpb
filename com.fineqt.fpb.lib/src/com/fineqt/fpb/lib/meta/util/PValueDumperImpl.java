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
package com.fineqt.fpb.lib.meta.util;

import java.util.ArrayList;
import java.util.List;

import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.dump.DumpLine;
import com.fineqt.fpb.lib.dump.FieldDumpLine;
import com.fineqt.fpb.lib.dump.TopTypeDumpLine;
import com.fineqt.fpb.lib.meta.context.ContextPool;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.util.BitRegion;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.FpbUtils;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.lib.value.PPrimitiveValue;
import com.fineqt.fpb.lib.value.PValue;

public class PValueDumperImpl implements PValueDumper {
	private final static String LN = System.getProperty("line.separator");
	private final static String TAB = "  ";
	private final static int MAX_VALUE_COLUMN_SIZE = 50;
	private final static int DEFAULT_HEX_DUMP_BYTE_PER_LINE = 16;
	private final static String EXT_VALUE_MARK = "{}";
	
	@Override
	public String getDumpStr(PValue value) throws DumpException {
		DumpContext cxt = ContextPool.INSTANCE.borrowDumpContext();
        PTypeExt typeMeta = value.pTypeMeta();
		try {
            //取得有效编码变量
            typeMeta.getRootType().dump(cxt, value, null, typeMeta, 0);
        } catch (DumpException e) {
            e.setDumpContext(cxt);
            throw e;
        }
//		System.out.println(cxt);
		TextLineGenerator generator = new TextLineGenerator(cxt);
		String result = generator.generate();
		//回收Context
		ContextPool.INSTANCE.returnDumpContext(cxt);
		return result;
	}

	@Override
	public void dump(PValue value) {
		try {
			System.out.println(getDumpStr(value));
		} catch (DumpException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void dump(IValue value) {
		dump((PValue)value);
	}

	@Override
	public String getDumpStr(IValue value) throws DumpException {
		return getDumpStr((PValue)value);
	}

	protected static class TextLineGenerator {
		private DumpContext dumpContext;
		private int posColumnSize;
		private int nameColumnSize;
		private int maxValueColumnSize = MAX_VALUE_COLUMN_SIZE;
		private StringBuilder buffer = new StringBuilder();
		private int flagLength;
		private int flagOffset;
		
		public TextLineGenerator(DumpContext dumpContext) {
			super();
			this.dumpContext = dumpContext;
		}
		public int getPosColumnSize() {
			return posColumnSize;
		}
		public int getNameColumnSize() {
			return nameColumnSize;
		}
		public int getMaxValueColumnSize() {
			return maxValueColumnSize;
		}
		public void setMaxValueColumnSize(int maxValueColumnSize) {
			this.maxValueColumnSize = maxValueColumnSize;
		}
		public StringBuilder getBuffer() {
			return buffer;
		}
		public int getFlagLength() {
			return flagLength;
		}
		public int getFlagOffset() {
			return flagOffset;
		}
		public void incFlagOffset(int inc) {
			flagOffset += inc;
		}
		public DumpContext getDumpContext() {
			return dumpContext;
		}

		public String generate() {
			List<TextLine> textLines = new ArrayList<TextLine>();
			//生成所有TextLine
			for (DumpLine dumpLine : dumpContext.getAllDumpLines()) {
				TextLine line = new TextLine(dumpLine);
				textLines.add(line);
			}
			//第一次循环（Position, Name）
			for (TextLine textLine : textLines) {
				DumpLine dumpLine = textLine.getDumpLine();
				//设置Flag
				if (dumpLine.getType() == DumpLine.Type.FIELD) {
					FieldDumpLine fdLine = (FieldDumpLine)dumpLine;
					if (fdLine.getFlagType() != null && 
							fdLine.getFlagType() != FlagFieldType.NONE 
							&& flagOffset >= flagLength) {
						switch(fdLine.getFlagType()) {
						case OCTET:
							flagLength = FpbConstants.OCTET_BITS;
							break;
						case OCTET2:
							flagLength = 2 * FpbConstants.OCTET_BITS;
							break;
						case OCTET4:
							flagLength = 4 * FpbConstants.OCTET_BITS;
							break;
						}
						flagOffset = 0;
					}
				}
				textLine.firstIterate(this);
				//清空Flag
				if (flagOffset > 0 && flagOffset >= flagLength) {
					flagLength = 0;
					flagOffset = 0;
				}
			}
			//取得PosText和NameText的最大长度
			for (TextLine textLine : textLines) {
				int posSize = textLine.getPosText().length();
				if (posSize > posColumnSize) {
					posColumnSize = posSize;
				}
				if (textLine.getDumpLine().getType() == DumpLine.Type.FIELD) {
					int nameSize = textLine.getNameText().length();
					if (nameSize > nameColumnSize) {
						nameColumnSize = nameSize;
					}
				}
			}
			//第二次循环(Value, Description)
			for (TextLine textLine : textLines) {
				textLine.secondIterate(this);
			}
			return buffer.toString();
		}
	}
	
	protected static class TextLine {
		private DumpLine dumpLine;
		private StringBuilder posText = new StringBuilder();
		private StringBuilder nameText = new StringBuilder();
		private boolean isFlag;
		private TextBitset flagMask;
		
		public TextLine(DumpLine dumpLine) {
			this.dumpLine = dumpLine;
		}

		//第一次循环，生成PosText和NameText
		public void firstIterate(TextLineGenerator generator) {
			//PosText
			BitRegion region = dumpLine.getValueRegion();
			int byteOff = region.getByteOffset();
			int byteLen = region.getByteLen();
			posText.append(Integer.toString(byteOff) + ":" + byteLen);
			//NameText
			//Field
			if (dumpLine.getType() == DumpLine.Type.FIELD) {
				FieldDumpLine fieldLine = (FieldDumpLine)dumpLine;
				TopTypeDumpLine topType = fieldLine.getTopTypeLine();
				//Indent
				int deep = fieldLine.getDeep() - topType.getDeep();
				nameText.append(getTabs(deep));
				//Name
				//Flag
				if (generator.getFlagLength() > 0) {
					isFlag = true;
					flagMask = new NativeTextBitset();
					flagMask.resize(generator.getFlagLength());
					for (int i = 0; i < generator.getFlagOffset(); i++) {
						nameText.append("-");
					}
					for (int i = generator.getFlagOffset(); 
						i < generator.getFlagOffset() + fieldLine.getValueRegion().getLen(); i++) {
						nameText.append("0");
						flagMask.setBit(i, true);
					}
					generator.incFlagOffset(fieldLine.getValueRegion().getLen());
					for (int i = generator.getFlagOffset(); i < generator.getFlagLength(); i++) {
						nameText.append("-");
					}
				//FileldName
				} else {
					nameText.append(fieldLine.getName());
				}
			//TopType
			} else {
				nameText.append(dumpLine.getName());
			}
		}
		
		private String getTabs(int deep) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < deep; i++) {
				builder.append(TAB);
			}
			return builder.toString();
		}
		//第二次循环，确定Value和Description并生成整个行
		public void secondIterate(TextLineGenerator generator) {
			//Position
			if (posText.length() < generator.getPosColumnSize()) {
				int cnt = generator.getPosColumnSize() - posText.length();
				for (int i = 0; i < cnt; i++) {
					posText.append(" ");
				}
			}
			//Name
			if (nameText.length() < generator.getNameColumnSize()) {
				int cnt = generator.getNameColumnSize() - nameText.length();
				for (int i = 0; i < cnt; i++) {
					nameText.append(" ");
				}
			}
			//Value
			String value = "";
			StringBuilder extValue = null;
			int maxValueSize = generator.getMaxValueColumnSize();
			if (dumpLine.getValue() == null) {
				value = "-";
			} else if (dumpLine.getValue().notPresent()) {
				value = "omit";
			} else if (dumpLine.isPrimitive()) {
				switch(dumpLine.getValue().pTypeMeta().getTypeClass()) {
				case BITSTRING:
				case CHARSTRING:
				case UNIVERSAL_CHARSTRING:
				case HEXSTRING:
					value = ((PPrimitiveValue)dumpLine.getValue()).getLiteral();
					if (value.length() > maxValueSize) {
						extValue = getValueExtLines(value, maxValueSize);
						value = EXT_VALUE_MARK;
					}
					break;
				case OCTETSTRING:
					POctetstringValue ovalue = (POctetstringValue)dumpLine.getValue();
					//特殊格式
					if (dumpLine.getFormat() != null) {
						switch(dumpLine.getFormat()){
						case IPV4_ADDRESS:
							if (ovalue.getLength() == POctetstringValue.IPV4_ADDRESS_BYTES) {
								value = ovalue.getTextAs(IValueTextStyle.IPV4_ADDRESS);
							}
							break;
						case IPV6_ADDRESS:
							if (ovalue.getLength() == POctetstringValue.IPV6_ADDRESS_BYTES) {
								value = ovalue.getTextAs(IValueTextStyle.IPV6_ADDRESS);
							}
							break;
						case MAC_ADDRESS:
							if (ovalue.getLength() == POctetstringValue.MAC_ADDRESS_BYTES) {
								value = ovalue.getTextAs(IValueTextStyle.MAC_ADDRESS);
							}
							break;
						}
					} 
					if (value.length() > 0) {
						break;
					}
					//正常格式
					if (ovalue.getLength() > maxValueSize / 2) {
						extValue = new StringBuilder();
						String hexDump = FpbUtils.getHexDump(ovalue.getValue(), 
								DEFAULT_HEX_DUMP_BYTE_PER_LINE );
						String[] lines = hexDump.split(LN);
						for (int i = 0; i < lines.length; i++) {
							for (int j = 0; j < posText.length(); j++) {
								extValue.append(" ");
							}
							extValue.append(" ");
							extValue.append(lines[i]);
							extValue.append(LN);
						}
						value = EXT_VALUE_MARK;
					} else {
						value = ((PPrimitiveValue)dumpLine.getValue()).getLiteral();
					}
					break;
				default:
					value = ((PPrimitiveValue)dumpLine.getValue()).getLiteral();
					break;
				}
			}
			//Description
			StringBuilder desc = new StringBuilder();
			//Flag Field Name
			if (isFlag) {
				desc.append(dumpLine.getName());
				desc.append(" ");
			}
			//BitMask
			if (flagMask != null) {
				desc.append("0x").append(flagMask.get(TextBitset.HEX));
				desc.append(" ");
			} else {
				BitRegion region = dumpLine.getValueRegion();
				int leftMaskBits = region.getLeftMaskBits();
				int byteLen = region.getByteLen();
				int rightMaskBits = region.getRightMaskBits();
				if (leftMaskBits > 0 || rightMaskBits > 0) {
					byte[] bytes = new byte[byteLen];
					for (int i = 0; i < bytes.length; i++) {
						bytes[i] = (byte)0xFF;
					}
					TextBitset bitset = new NativeTextBitset(bytes);
					//Left Mask
					bitset.shiftLeft(leftMaskBits);
					bitset.shiftRight(leftMaskBits);
					//Right Mask
					bitset.shiftRight(rightMaskBits);
					bitset.shiftLeft(rightMaskBits);
					desc.append("0x").append(bitset.get(TextBitset.HEX));
					desc.append(" ");
				}
			}
			//EnumName
			if (dumpLine.getType() == DumpLine.Type.FIELD) {
				FieldDumpLine fieldLine = (FieldDumpLine)dumpLine;
				if (fieldLine.getEnumName() != null) {
					desc.append(fieldLine.getEnumName());
				}
			}
			//Create Line
			StringBuilder buffer = generator.getBuffer();
			buffer.append(posText);
			buffer.append(" ");
			buffer.append(nameText);
			buffer.append(" ");
			if (value.length() > 0) {
				buffer.append(value);
				buffer.append(" ");
			}
			buffer.append(desc);
			buffer.append(LN);
			if (extValue != null) {
				buffer.append(extValue);
			}
		}

		private StringBuilder getValueExtLines(String value, int maxValueSize) {
			StringBuilder extLines = new StringBuilder();
			int cnt = (value.length() + maxValueSize) / maxValueSize;
			for (int i = 0; i < cnt; i++) {
				for (int j = 0; j < posText.length(); j++) {
					extLines.append(" ");
				}
				extLines.append(" ");
				int endIndex = (i + 1) * maxValueSize;
				if (endIndex >= value.length()) {
					extLines.append(value.substring(i * maxValueSize));
				} else {
					extLines.append(value.substring(i * maxValueSize, endIndex));
				}
				extLines.append(LN);
			}
			return extLines;
		}

		public DumpLine getDumpLine() {
			return dumpLine;
		}

		public StringBuilder getNameText() {
			return nameText;
		}

		public StringBuilder getPosText() {
			return posText;
		}
		
	}
	
}
