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
package com.fineqt.fpb.lib.type;

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.DumpException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.constraint.DiagnosticChain;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PModuleElementExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.DumpContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeEV;
import com.fineqt.fpb.lib.modelview.TypeMV;
import com.fineqt.fpb.lib.value.PValue;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public interface PTypeExt extends PModuleElementExt, IType, PTypeElementMeta, TypeMV {
	/**
	 * 取得上位类型。
	 * @return
	 */
	PTypeExt getSuperType();
	/**
	 * 设置上位类型。
	 * @param type
	 */
	void setSuperType(PTypeExt type);
	/**
	 * 取得根（最上位）类型。
	 * @return
	 */
	PEntityTypeExt getRootType();
//	boolean isCompatible(PValue dstValue, PValue srcValue);
	/**
	 * 类型是否兼容。
	 * @param dstType
	 * @return
	 */
	boolean isCompatible(PTypeExt dstType);
	/**
	 * 取得该Type的编码属性Meta对象。
	 * @return
	 */
	PTypeEVExt getEVMeta();
	/**
	 * 解码数据包。
	 * 根据输入数据解码生成对应数据包。
	 * @param cxt 上下文
	 * @param input 输入数据，目标数据包的数据。
	 * @param elementMeta 类型、字段或列表项目的配置信息
	 * @param byteOrder 字节顺序。动态传递的属性，可以是上层类型执行时所用的值。
	 * 中的属性。优先EV属性集合通常在PFieldEV的overrideWhole被设置成false时被设置。
	 * @return
	 */
	DecodeResult decode(DecodeContext cxt, IReadableBitBuffer input, 
	        PTypeElementMeta elementMeta, DecodeParameters paras) 
	throws DecodeException;
	/**
	 * 编码数据包。（getSize, calculate动作也用该方法）
	 * 根据输入数据包对象进行编码，将编码数据写入缓存中。
	 * @param cxt 上下文。
	 * @param value 目标数据包。
	 * @param parentLength 父亲节点的当前计算所得长度。该长度并不一定是父亲节点的实际长度，而是当前处理
	 * 子节点前的所有子节点的长度和。
     * @param elementMeta 类型、字段或列表项目的配置信息
	 * @param byteOrder 字节顺序。动态传递的属性，可以是上层类型执行时所用的值。
	 * @return 返回value的长度。比特为单位。
	 */
	int encode(EncodeContext cxt, PValue value, int parentLength, 
	        PTypeElementMeta elementMeta, ByteOrder byteOrder)
	throws EncodeException;
	/**
	 * 收集数据包的Dump信息。
	 * @param cxt 上下文。
	 * @param value 目标数据包。
	 * @param valueName 目标数据包的名称，可以是null。
     * @param elementMeta 类型、字段或列表项目的配置信息
	 * @param deep 调用深度
	 * @return 返回value的长度。比特为单位。
	 * @throws DumpException
	 */
	int dump(DumpContext cxt, PValue value, String valueName, PTypeElementMeta elementMeta, int deep) 
	throws DumpException;
	/**
	 * 验证值是否正确。
	 * @param value 目标值对象。类型必须与该类型一致或者是其派生类型。
	 * @param chain 诊断链。
	 * @param constraint 类型限制。可以是Type自己的或者所在Field的。不可为Null。
	 * @return 字段值是是否正确。
	 */
	boolean validate(PValue value, DiagnosticChain chain, PTypeConstraintStorage constraint);
	/**
	 * 验证值是否正确。
	 * 使用类型自己的类型限制信息。
	 * @param value 目标值对象。类型必须与该类型一致或者是其派生类型。
	 * @param chain 诊断链。
	 * @return 字段值是是否正确。
	 */
	boolean validate(PValue value, DiagnosticChain chain);
	/**
	 * 使用包含字段自己的限制条件来验证它们的正确性。
	 * 只对Record, Union, Set, RecordOf, SetOf类型有效。
	 * @param value 目标值对象。类型必须与该类型一致或者是其派生类型。
	 * @param chain 诊断链。
	 * @return 所有包含字段值是是否正确。
	 */
	boolean validateFields(PValue value, DiagnosticChain chain);
	/**
	 * 根据编码属性模型来生成他的Meta对象。
	 * 默认状态下通过所在模块内登记的PTypeEVExtFactory来间接生成。
	 * @param typeEV 编码属性模型对象。类型必须与该PTypeExt的类型相对应。
	 * @return
	 */
	PTypeEVExt createTypeEVExt(PTypeEV typeEV);
	/**
	 * 生成该类型的Omit对象。
	 * @return
	 */
	PValue createOmitValue();
	/**
	 * 生成该类型的一般对象。
	 * 使用类型自己的初始化参数。
	 */
	PValue createNormalValue();
	/**
	 * 生成该类型的一般对象。
	 * 使用类型外部的初始化参数。主要用于字段的生成。
	 */
	PValue createNormalValue(CreatePTypeValueParamaters paras);
	/**
	 * 生成空值，不使用初始化参数。
	 * @return
	 */
	PValue createEmptyValue();
	/**
	 * 用于库内部创建与类型相对应的值对象，主要用在PTypeExt的createOmitValue()、createNormalValue()、
	 * createEmptyValue()中。
	 * 用户级别的值对象创建应使用PFactoryExt接口。
	 */
	interface InternalValueFactory {
		//创建模式
		enum CreationMode {NORMAL, OMIT, EMPTY}
		/**
		 * 创建值对象。
		 * @param type 目标类型
		 * @param mode 模式
		 * @return
		 */
		PValue createValue(PTypeExt type, CreationMode mode);
	}
	
}
