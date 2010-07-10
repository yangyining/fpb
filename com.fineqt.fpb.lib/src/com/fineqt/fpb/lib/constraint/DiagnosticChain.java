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

public interface DiagnosticChain {
	/**
	 * 加入该诊断信息。
	 * @param diagnostic
	 */
	void add(Diagnostic diagnostic);
	/**
	 * 加入该参数diagnostic下的所有子对象。
	 * @param diagnostic
	 */
	void addAll(Diagnostic diagnostic);
	/**
	 * 如果diagnostic下有子对象则加入所有子对象，否则加入本身。
	 * @param diagnostic
	 */
	void merge(Diagnostic diagnostic);
	/**
	 * 是否需要收集所有的错误。
	 * 如果false的话，validate操作在遇到第一个检验错误后就因该退出。true的话则持续检验并收集所有错误的信息。
	 * @return
	 */
	boolean shouldCollectAllError();
	/**
	 * 设置是否需要收集所有的错误标记。
	 * @param should
	 */
	void setShouldCollectAllError(boolean should);
}
