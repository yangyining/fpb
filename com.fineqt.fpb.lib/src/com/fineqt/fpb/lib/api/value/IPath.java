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
package com.fineqt.fpb.lib.api.value;

import com.fineqt.fpb.lib.api.module.IType;

/**
 * 字段路径类。使用该路经对象并调用IValue的findField方法就可以取得容器或列表内的指定子字段或列表元素。
 * 路径由多个片断组成，每个片断都可以指定容器类型的字段或列表的元素。以下是路径的书写格式：
 *   [ fieldName ] [ '[' itemIndex ']' ] { '/' [ fieldName ] [ '[' itemIndex ']' ] } 
 * filedName是容器类型的子字段名称，itemIndex是列表元素的索引。他们两个至少需要指定一个，也可以同时存在。
 *   eg1: lines1Count/token1
 *   eg2: first3Line[2]/token1 
 *   eg3: [2]/token1
 *   eg4: lines1Count
 *   eg5: [2]
 *   
 * @author JiangMin
 *
 */
public interface IPath {
	/**
	 * 取得运用目标类型，即所在路径根元素的类型。
	 * @return
	 */
	IType getTargetType();
	/**
	 * 取得引用字段的类型，即所在路径末端元素的类型。
	 * @return
	 */
	IType getRefFieldType();
	/**
	 * 取得targetValue中该路径所指定的元素。
	 * @param targetValue 目标值对象。
	 * @return 路径指定值对象。
	 */
	IValue findField(IValue targetValue);
	/**
	 * 取得targetValue中该路径所指定的元素。
	 * 当指定路径上的字段不存在或是omit时，如果fillPath参数为true，则生成成这些字段的默认值来填充路径。
	 * @param targetValue 目标值对象。
	 * @param fillPath 是否填充路径。
	 * @return 路径指定值对象。
	 */
	IValue findField(IValue targetValue, boolean fillPath);
	/**
	 * 取得该路径的所有片断。
	 * @return
	 */
	IPathFragment[] getFragments();
}
