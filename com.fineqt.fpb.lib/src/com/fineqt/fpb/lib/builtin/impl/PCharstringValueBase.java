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
package com.fineqt.fpb.lib.builtin.impl;

import java.util.Arrays;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

abstract public class PCharstringValueBase extends PStringValueBase {
	protected char[] value = new char[0];

	protected PCharstringValueBase(PTypeElementMeta valueMeta) {
		super(valueMeta);
	}

	/**
	 * 不做TTCN-3的Escape处理
	 */
	@Override
	public String getText() {
		return new String(value);
	}

	/**
	 * 不做TTCN-3的Escape处理
	 */
	@Override
	public void setText(String text) {
		//复制字符串
		value = text.toCharArray();
	}

	public char[] getValue() {
		return value;
	}

	public void setValue(char[] chars) {
		if (chars == null) {
			throw new IllegalArgumentException();
		}
		this.value = chars;
	}

	public char getChar(int position) {
		return value[position];
	}

	public void setChar(int position, char newValue) {
		value[position] = newValue;
	}

	public int getLength() {
		return value.length;
	}

	public void setLength(int len) {
		char[] newValue = new char[len];
		if (len > value.length) {
			System.arraycopy(value, 0, newValue, 0, value.length);
		} else {
			System.arraycopy(value, 0, newValue, 0, len);
		}
		value = newValue;
	}

	public void setString(String literal) {
		//检查格式
		if (literal.length() < 2) {
			throw new IllegalArgumentException();
		}
		char quotationChar;
		if (literal.charAt(0) == DOUBLE_QUOTATION_MARK && 
			literal.charAt(literal.length()-1) == DOUBLE_QUOTATION_MARK ) {
			quotationChar = DOUBLE_QUOTATION_MARK;
		} else if (literal.charAt(0) == SINGLE_QUOTATION_MARK && 
				literal.charAt(literal.length()-1) == SINGLE_QUOTATION_MARK ) {
			quotationChar = SINGLE_QUOTATION_MARK;
		} else {
			throw new IllegalArgumentException();
		}
		char[] buf = new char[literal.length() - 2];
		int index = 0;
		//处理文本
		for (int i = 1; i < literal.length() - 1; i++) {
			char ch = literal.charAt(i);
			//处理""
			if (ch == quotationChar) {
				i++;
				if (i >= literal.length() - 1) {
					throw new IllegalLiteralFormatException(literal);
				}
				ch = literal.charAt(i);
				if (ch != quotationChar) {
					throw new IllegalLiteralFormatException(literal);
				}
			}
			buf[index++] = ch;
		}
		//复制字符串
		if (value.length != index) {
			value = new char[index];
		}
		System.arraycopy(buf, 0, value, 0, index);
	}

	@Override
	public void assignPValue(PValue srcValue) throws IncompatibleValueException {
		super.assignPValue(srcValue);
		PCharstringValueBase entity = (PCharstringValueBase)srcValue;
		this.value = new char[entity.getLength()];
		System.arraycopy(entity.value, 0, value, 0, entity.getLength());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(value);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		final PCharstringValueBase other = (PCharstringValueBase) obj;
		if (!Arrays.equals(value, other.value))
			return false;
		return true;
	}

	@Override
	public String getString() {
		StringBuilder builder = new StringBuilder();
		//开头引号
		builder.append(DOUBLE_QUOTATION_MARK);
		for (int i = 0; i < value.length; i++) {
			char ch = value[i];
			builder.append(ch);
			//处理""
			if (ch == DOUBLE_QUOTATION_MARK) {
				builder.append(DOUBLE_QUOTATION_MARK);
			}
		}
		//结尾引号
		builder.append(DOUBLE_QUOTATION_MARK);
		return builder.toString();
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		builder.append("value", new String(value));
		return builder.toString();
	}
	
}
