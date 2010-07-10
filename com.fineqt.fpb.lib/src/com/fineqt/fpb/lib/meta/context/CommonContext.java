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
package com.fineqt.fpb.lib.meta.context;

import com.fineqt.fpb.lib.meta.PPoolableObject;
import com.fineqt.fpb.lib.system.ScopeContext;

public interface CommonContext extends ScopeContext, PPoolableObject {
	FieldStackMap getFieldStackMap();
//	/**
//	 * 清理资源，准备下一次Decode, Encode或Calculate的开始。
//	 */
//	void reset();
	interface FieldStackMap {
		/**
		 * 将字段的值压入堆栈。
		 * @param fieldName 字段名称
		 * @param fieldValue 可以为null
		 */
		void pushField(String fieldName, Object fieldValue);
		/**
		 * 弹出堆栈中字段的最上层项目。没有或值为空时返回null。
		 * @param fieldName 字段名称
		 * @return
		 */
		Object popField(String fieldName);
		/**
		 * 取得堆栈中字段最上层项目的值。没有或值为空时返回null。
		 * @param fieldName 字段名称
		 * @return
		 */
		Object peekField(String fieldName);
		/**
		 * 改变堆栈中最顶层项目的值，如果堆栈为空则返回false.
		 * @param fieldName 字段名称
		 * @param fieldValue
		 * @return
		 */
		boolean setTopField(String fieldName, Object fieldValue);
		/**
		 * 清空所有堆栈
		 */
		void clear();
	}
}
