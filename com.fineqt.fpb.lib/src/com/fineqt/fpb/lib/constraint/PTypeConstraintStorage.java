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
package com.fineqt.fpb.lib.constraint;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fineqt.fpb.lib.value.PValue;

/**
 * 类型限制仓库类。
 * @author JiangMin
 *
 */
public interface PTypeConstraintStorage {
	/**
	 * 返回固定长度限制。如果没有则返回-1。
	 * @return
	 */
	int getFixedLength();
	/**
	 * 返回固定值（当List的选项只有一个固定值时）。如果没有则返回null。
	 * @return
	 */
	PValue getFixedValue();
	/**
	 * 返回规定文字列内容的模式（如有多个取最后加入的一个）。如果没有则返回null。
	 * @return
	 */
	Pattern getStringPattern();
	/**
	 * 根据StringPattern的模式生成Matcher，每个线程都只有唯一的Matcher对象。
	 * @return
	 */
	Matcher getThreadStringMatcher();
	/**
	 * 追加限制
	 * @param constraint
	 */
	void addConstraint(PTypeConstraintExt constraint);
	/**
	 * 追加限制列表
	 * @param constraints
	 */
	void addConstraint(List<PTypeConstraintExt> constraints);
	/**
	 * 取得包含的所有的类型限制。
	 * @return
	 */
	List<PTypeConstraintExt> getAll();
	
	boolean validate(PValue value);

	boolean validate(PValue value, DiagnosticChain chain);
}
