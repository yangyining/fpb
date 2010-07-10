package com.fineqt.fpb.lib.meta;

import com.fineqt.fpb.lib.value.PValue;

public interface FieldRefStack {
	/**
	 * 压入字段引用。
	 * @param fieldValue 字段值。getFieldMeta()必须返回有效FieldMeta对象。
	 * @return
	 */
	FieldRef push(PValue fieldValue);
	/**
	 * 压入字段引用回调引用。
	 * 当下一次的压入将会激发该回调引用对象的ValueSetted事件。
	 * @param fieldName 字段名称。
	 * @param rootTypeName 字段所在类型的根类型名称。可以为null。
	 * @param moduleName 字段所在类型的根类型的模型名称。可以为null。
	 * @return
	 */
	FieldRef pushHook(String fieldName, String rootTypeName, String moduleName);
	/**
	 * 弹出字段引用（包括回调引用）。
	 * @param fieldName 字段名称。
	 * @param rootTypeName 字段所在类型的根类型名称。可以为null。
	 * @param moduleName 字段所在类型的根类型的模型名称。可以为null。
	 * @return
	 */
	FieldRef pop(String fieldName, String rootTypeName, String moduleName);

}
