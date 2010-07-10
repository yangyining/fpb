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
package com.fineqt.fpb.lib.util;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fineqt.fpb.lib.codec.builtin.PBitstringValue;
import com.fineqt.fpb.lib.codec.builtin.PBooleanValue;
import com.fineqt.fpb.lib.codec.builtin.PCharstringValue;
import com.fineqt.fpb.lib.codec.builtin.PFloatValue;
import com.fineqt.fpb.lib.codec.builtin.PHexstringValue;
import com.fineqt.fpb.lib.codec.builtin.PIntegerValue;
import com.fineqt.fpb.lib.codec.builtin.POctetstringValue;
import com.fineqt.fpb.lib.codec.builtin.PUCharstringValue;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.value.PEnumeratedValue;
import com.fineqt.fpb.lib.value.PValue;

public class TTCNLiteralParserImpl implements TTCNLiteralParser {
	
	private static TTCNLiteralParserImpl instance;
	
	public static TTCNLiteralParserImpl init() {
		if (instance == null) {
			instance = new TTCNLiteralParserImpl();
		}
		return instance;
	}
	
	private TTCNLiteralParserImpl() {
	}

	
/*	*//**
	 * 约束的解析生成。
	 * 包括Length, List, Charset, Pattern类型
	 * //TODO 未完成
	 *//*
	@Override
	public PTypeConstraint parseConstraint(String ttcnLiteral, PTypeExt type)
			throws IllegalLiteralFormatException {
		List<PTypeConstraint> constraints = new ArrayList<PTypeConstraint>();
		//暂时只实现Primitimve的单个Value的List和Length
		String literal = ttcnLiteral.trim();
		String lengthLiteral;
		//Value List
		if (literal.length() > 0 && literal.charAt(0) == '(') {
			int rightIndex = literal.indexOf(')');
			if (rightIndex < 0)
				throw new IllegalLiteralFormatException();
			//list literal
			String listStr = literal.substring(1, rightIndex).trim();
			//length literal
			if (literal.length() > rightIndex + 1) {
				lengthLiteral = literal.substring(rightIndex + 1).trim();
			} else {
				lengthLiteral = null;
			}
			//string pattern
			if (listStr.startsWith("pattern")) {
				if (type.getTypeClass() == TypeClass.CHARSTRING || 
						type.getTypeClass() == TypeClass.UNIVERSAL_CHARSTRING) {
					IStringValue pattern = BuiltinFactory.BUILTIN_INSTANCE.createCharstring();
					pattern.setString(listStr.substring("pattern".length()).trim());
					PPatternConstraint cons = new PPatternConstraint(type, pattern.getText());
					constraints.add(cons);
				} else {
					throw new IllegalLiteralFormatException();
				}
			//parse list
			} else {
				//range
				if (listStr.contains("..")){
					String[] rangeItems = listStr.split("\\.\\.");
					if (rangeItems.length != 2) {
						throw new IllegalLiteralFormatException();
					}
					PListConstraint cons = new PListConstraint(type);
					//TODO infinity和-infinity具体值应该可以在外部定义
					//Integer
					if (type.getTypeClass() == TypeClass.INTEGER) {
						//minValue
						String desc =rangeItems[0].trim();
						BigInteger minValue;
						if (desc.equals(FpbConstants.MINUS_INFINITY_LITERAL)) {
							minValue = BigInteger.valueOf(Long.MIN_VALUE);
						} else {
							minValue = parseBigInteger(desc);
						}
						//maxValue
						desc =rangeItems[1].trim();
						BigInteger maxValue;
						if (desc.equals(FpbConstants.PLUS_INFINITY_LITERAL)) {
							maxValue = BigInteger.valueOf(Long.MAX_VALUE);
						} else {
							maxValue = parseBigInteger(desc);
						}
						cons.addIntRangeCons(minValue, maxValue);
					//Float
					} else if (type.getTypeClass() == TypeClass.FLOAT) {
						//minValue
						String desc =rangeItems[0].trim();
						BigDecimal minValue;
						if (desc.equals("-infinity")) {
							minValue = BigDecimal.valueOf(Double.MIN_VALUE);
						} else {
							minValue = new BigDecimal(desc);
						}
						//maxValue
						desc =rangeItems[1].trim();
						BigDecimal maxValue;
						if (desc.equals("infinity")) {
							maxValue = BigDecimal.valueOf(Double.MAX_VALUE);
						} else {
							maxValue = new BigDecimal(desc);
						}
						cons.addFloatRangeCons(minValue, maxValue);
					} else {
						throw new IllegalLiteralFormatException();
					}
					constraints.add(cons);
				//single
				} else {
					PValue value = parsePrimitive(listStr, type);
					if (value != null) {
						PListConstraint cons = new PListConstraint(type);
						cons.addValueCons(value);
						constraints.add(cons);
					}
				}
			}
		} else {
			lengthLiteral = literal;
		}
		//Length
		if (lengthLiteral != null && lengthLiteral.length() > 0) {
			if (lengthLiteral.startsWith("length")) {
				//去掉()
				lengthLiteral = lengthLiteral.replaceAll("[()]", "");
				//range
				if (lengthLiteral.contains("..")){
					lengthLiteral = lengthLiteral.substring("length".length()).trim();
					String[] rangeItems = lengthLiteral.split("\\.\\.");
					if (rangeItems.length != 2) {
						throw new IllegalLiteralFormatException();
					}
					String desc =rangeItems[0].trim();
					int minLen = Integer.parseInt(desc);
					desc =rangeItems[0].trim();
					int maxLen;
					if (desc.equals("infinity")) {
						maxLen = Integer.MAX_VALUE;
					} else {
						maxLen = Integer.parseInt(desc);
					}
					PLengthConstraint cons = new PLengthConstraint(type, minLen, maxLen);
					constraints.add(cons);
				//fixed
				} else {
					int len = Integer.parseInt(lengthLiteral.substring("length".length()).trim());
					PLengthConstraint cons = new PLengthConstraint(type, len);
					constraints.add(cons);
				}
			}
 		}
		if (constraints.size() == 0) {
			throw new IllegalLiteralFormatException("Empty Constraint");
		}
		if (constraints.size() == 1) {
			return constraints.get(0);
		}
		CompoundConstraint compoundCons = new CompoundConstraint();
		compoundCons.getChildren().addAll(constraints);
		return compoundCons;
	}
*/
	/**
	 * 解析integer, float, bitstring, hexstring, octetstring, charstring, ucharstring类型
	 * 的TTCN-3的文本描述，生成对应对象。
	 */
	@Override
	public PValue parsePrimitive(String ttcnLiteral, PTypeExt type)
			throws IllegalLiteralFormatException {
		switch(type.getTypeClass()) {
		case INTEGER:
			PIntegerValue intValue = (PIntegerValue)type.createEmptyValue();
			intValue.setBigInteger(parseBigInteger(ttcnLiteral));
			return intValue;
		case FLOAT:
			PFloatValue floatValue = (PFloatValue)type.createEmptyValue();
			floatValue.setBigDecimal(new BigDecimal(ttcnLiteral));
			return floatValue;
		case BITSTRING:
			PBitstringValue bitsValue = (PBitstringValue)type.createEmptyValue();
			bitsValue.setString(ttcnLiteral);
			return bitsValue;
		case HEXSTRING:
			PHexstringValue hexsValue = (PHexstringValue)type.createEmptyValue();
			hexsValue.setString(ttcnLiteral);
			return hexsValue;
		case OCTETSTRING:
			POctetstringValue octetsValue = (POctetstringValue)type.createEmptyValue();
			octetsValue.setString(ttcnLiteral);
			return octetsValue;
		case CHARSTRING:
			PCharstringValue charsValue = (PCharstringValue)type.createEmptyValue();
			charsValue.setString(ttcnLiteral);
			return charsValue;
		case UNIVERSAL_CHARSTRING:
			PUCharstringValue ucharsValue = (PUCharstringValue)type.createEmptyValue();
			ucharsValue.setString(ttcnLiteral);
			return ucharsValue;
		case BOOLEAN:
			PBooleanValue booleanValue = (PBooleanValue)type.createNormalValue();
			booleanValue.setBoolean(Boolean.parseBoolean(ttcnLiteral));
			return booleanValue;
		case ENUMERATED:
			PEnumeratedValue enumValue = (PEnumeratedValue)type.createNormalValue();
			enumValue.setEnumByName(ttcnLiteral);
			return enumValue;
		}
		throw new IllegalArgumentException("Not supportd type "+type.getFullName());
	}

	private BigInteger parseBigInteger(String literal) throws IllegalLiteralFormatException {
		literal = literal.toLowerCase().trim();
		try {
			if (literal.startsWith(FpbConstants.HEX_INT_PREFIX)) {
				return new BigInteger(literal.substring(2), 16);
			} else {
				return new BigInteger(literal);
			}
		} catch (RuntimeException e) {
			throw new IllegalLiteralFormatException(e);
		}
	}
}
