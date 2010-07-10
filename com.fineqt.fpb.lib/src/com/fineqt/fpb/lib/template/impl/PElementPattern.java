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
package com.fineqt.fpb.lib.template.impl;

import java.util.Map;

import com.fineqt.fpb.lib.builtin.PBitstringValue;
import com.fineqt.fpb.lib.builtin.PCharstringValue;
import com.fineqt.fpb.lib.builtin.PHexstringValue;
import com.fineqt.fpb.lib.builtin.POctetstringValue;
import com.fineqt.fpb.lib.builtin.PStringValue;
import com.fineqt.fpb.lib.template.PMatcherExt;
import com.fineqt.fpb.lib.template.PTemplateParIns;
import com.fineqt.fpb.lib.template.TemplateMatchingExption;
import com.fineqt.fpb.lib.value.PListValue;
import com.fineqt.fpb.lib.value.PValue;


abstract public class PElementPattern {
	public static final char ANY = '?';
	public static final char ANY_OR_NONE = '*';
	
	public enum Type{
		Any, 
		AnyOrNone, 
		Value
	};
	
	abstract public Type getType();

//	public void init() throws InitMetaException {
//		
//	}
	
	abstract public static class PValueElementPattern extends PElementPattern {
		/**
		 * 
		 * @param value  匹配目标值
		 * @param offset 匹配开始位置
		 * @return 成功：返回匹配长度，失败：-1
		 */
		public abstract int match(PValue value, int offset, Map<String, PTemplateParIns> paras)
		throws TemplateMatchingExption;
		
		/**
		 * 取得匹配条件值的固定长度。
		 * @return
		 */
		public abstract int getFixedLength();
		
		@Override
		public Type getType() {
			return Type.Value;
		}


	}
	
	public abstract static class PStringElementPattern<T extends PStringValue> 
	extends PValueElementPattern {
		protected T partValue;

		public PStringElementPattern(T partValue) {
			this.partValue = partValue;
		}
	
		@Override
		public int match(PValue value, int offset, Map<String, PTemplateParIns> paras) {
			int partLen = partValue.getLength();
			PStringValue srcValue = (PStringValue)value;
			if (offset +  partLen > srcValue.getLength()) {
				return -1;
			}
			for (int i = 0; i < partLen; i++) {
				if (!isEqualElement(i, value, i + offset)) {
					return -1;
				}
			}
			return partLen;
		}

		protected abstract boolean isEqualElement(int partOffset, PValue value, int srcOffset);
		
		
		@Override
		public int getFixedLength() {
			return partValue.getLength();
		}
	}
	
	public static class PBValueElementPattern extends PStringElementPattern<PBitstringValue> {
		
		public PBValueElementPattern(PBitstringValue value) {
			super(value);
		}

		protected boolean isEqualElement(int partOffset, PValue srcValue, int srcOffset) {
			PBitstringValue srcBValue = (PBitstringValue)srcValue;
			return partValue.getBit(partOffset) == srcBValue.getBit(srcOffset);
		}

	}
	
	public static class PHValueElementPattern extends PStringElementPattern<PHexstringValue> {
		
		public PHValueElementPattern(PHexstringValue value) {
			super(value);
		}

		protected boolean isEqualElement(int partOffset, PValue srcValue, int srcOffset) {
			PHexstringValue srcHValue = (PHexstringValue)srcValue;
			return partValue.getHex(partOffset) == srcHValue.getHex(srcOffset);
		}

	}
	
	public static class POValueElementPattern extends PStringElementPattern<POctetstringValue> {

		public POValueElementPattern(POctetstringValue value) {
			super(value);
		}

		protected boolean isEqualElement(int partOffset, PValue srcValue, int srcOffset) {
			POctetstringValue srcHValue = (POctetstringValue)srcValue;
			return partValue.getOctet(partOffset) == srcHValue.getOctet(srcOffset);
		}

	}
	
	public static class PCValueElementPattern extends PStringElementPattern<PCharstringValue> {
		
		public PCValueElementPattern(PCharstringValue value) {
			super(value);
		}

		protected boolean isEqualElement(int partOffset, PValue srcValue, int srcOffset) {
			PCharstringValue srcHValue = (PCharstringValue)srcValue;
			return partValue.getChar(partOffset) == srcHValue.getChar(srcOffset);
		}
	}
	
	public static class PListValueElementPattern extends PValueElementPattern {
		private PMatcherExt partValue;
		
		public PListValueElementPattern(PMatcherExt value) {
			this.partValue = value;
		}

		@Override
		public int match(PValue value, int offset, Map<String, PTemplateParIns> paras) 
		throws TemplateMatchingExption {
			@SuppressWarnings("unchecked")
			PListValue<PValue> listValue = (PListValue<PValue>)value;
			if (offset >= listValue.getLength()) {
				return -1;
			}
			PValue itemValue = listValue.getItem(offset);
			if (partValue.match(itemValue, paras)) {
				return 1;
			}
			return -1;
		}

		@Override
		public int getFixedLength() {
			return 1;
		}

		public PMatcherExt getPartValue() {
			return partValue;
		}

//		public void init() throws InitMetaException {
//			partValue.init();
//		}
//		
	}
	
	public static class PAnyElementPattern extends PElementPattern {

		@Override
		public Type getType() {
			return Type.Any;
		}
		
	}
	
	public static class PAnyOrNoneElementPattern extends PElementPattern {

		@Override
		public Type getType() {
			return Type.AnyOrNone;
		}
		
	}
	
}
