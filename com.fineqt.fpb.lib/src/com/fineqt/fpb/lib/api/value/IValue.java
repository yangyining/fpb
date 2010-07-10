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
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.meta.exception.IncompatibleValueException;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.lib.value.UnsupportedTextStyleException;
/**
 * 值对象类。
 * 
 * @author JiangMin
 *
 */
public interface IValue extends Cloneable {
	/**
	 * 取得该值对象的类型。
	 * @return
	 */
	IType getType();
	/**
	 * 给值对象赋值，赋值后本值对象与用于值复制的value参数仍然保持互相对立。如果参数value与该值对象的类型
	 * 是兼容的，他的的内容（除了类型信息外）将会被完全复制，并且以后对参数value或对本对象的修改都不会互相影响。
	 * @param value
	 * @throws IncompatibleValueException 当值对象之间不兼容时抛出该例外。
	 */
	void assignValue(IValue value) throws IncompatibleValueException;
	/**
	 * 以文本形式来设置值。
	 * 文本基本同TTCN规格的文本格式相同，但是省略了引号和B、O等后缀。
	 * @param text
	 * @throws RuntimeException 当文本格式不正确是抛出该类型例外。
	 */
	void setText(String text);
	/**
	 * 取得值的文本形式。
	 * 文本基本同TTCN规格的文本格式相同，但是省略了引号和B、O等后缀。
	 * @return
	 */
	String getText();
	/**
	 * 按照指定样式的文本形式来设置值。
	 * @param text 文本形式的描述
	 * @param style 指定样式
	 * @throws UnsupportedTextStyleException 如果该类型不支持指定样式则抛出该例外。
	 */
	void setTextAs(String text, IValueTextStyle style);
	/**
	 * 按照指定样式的文本形式来取得值。
	 * @param style 指定样式
	 * @return 值得文本形式
	 * @throws UnsupportedTextStyleException 如果该类型不支持指定样式则抛出该例外。
	 */
	String getTextAs(IValueTextStyle style);
	/**
	 * 取得TTCN格式的文本表示。
	 * 只对于integer, float等简单类型有效。
	 * @return
	 */
	String getLiteral();
    /**
     * 如果该值对象是omit状态的话返回true。
     * @return
     */
    public boolean  notPresent();
	/**
	 * 验证值是否正确。
	 * 使用类型或字段的限制信息进行验证，错误信息将被加入诊断链chain中。
	 * @param chain 诊断链，可以为null。
	 * @return 字段值是是否正确。
	 */
	boolean validate(DiagnosticChain chain);
	/**
	 * 根据路径描述取得对应子字段, 包括容器值(Record, Set, Union)和列表值(RecordOf, SetOf)的成员。
	 * 当指定路径上有成员不存在是则返回null。
	 * @param pathDesc 路径描述。当路经描述内容不正确是，会抛出例外。
	 * @return
	 */
	IValue findField(String pathDesc) throws MetaException;
	/**
	 * 根据路径对象取得对应子字段, 包括容器值(Record, Set, Union)和列表值(RecordOf, SetOf)的成员。
	 * 当指定路径上的字段不存在或是omit时，如果fillPath参数为true，则生成成这些字段的默认值来填充路径。
	 * @param pathDesc 路径描述。当路经描述内容不正确是，会抛出例外。
	 * @param fillPath 是否填充路径。
	 * @return
	 */
	IValue findField(String pathDesc, boolean fillPath) throws MetaException;
	/**
	 * 根据路径对象取得对应子字段, 包括容器值(Record, Set, Union)和列表值(RecordOf, SetOf)的成员。
	 * 当指定路径上有成员不存在是则返回null。
	 * @param path 路径描述对象。可以通过IType.createPath()方法来生成。
	 * @return
	 */
	IValue findField(IPath path);
	/**
	 * 根据路径对象取得对应子字段, 包括容器值(Record, Set, Union)和列表值(RecordOf, SetOf)的成员。
	 * 当指定路径上的字段不存在或是omit时，如果fillPath参数为true，则生成成这些字段的默认值来填充路径。
	 * @param path 路径描述对象。可以通过IType.createPath()方法来生成。
	 * @param fillPath 是否填充路径。
	 * @return
	 */
	IValue findField(IPath path, boolean fillPath);
	int hashCode();
	/**
	 * 两个值对象是否一致。一致性判断只比较值内容是否一致，对于他们的类型信息并不关心。对于容器或列表类型的
	 * 值对象将对他们的所有子字段或元素进行比较。其中SetOf类型的列表在比较时将不关心元素之间的顺序，即以
	 * 集合方式来比较。
	 * @param obj
	 * @return
	 */
	boolean equals(Object obj);
	/**
	 * 生成该值对象的拷贝，被生成对象将保持独立。
	 * @return
	 */
	Object clone();
}
