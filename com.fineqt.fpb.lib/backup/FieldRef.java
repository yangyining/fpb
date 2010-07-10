package com.fineqt.fpb.lib.meta;

import com.fineqt.fpb.lib.value.PValue;

public interface FieldRef {
	String getFieldName();
	String getRootTypeName();
	String getModuleName();
	/**
	 * 取得引用字段的值。
	 * @return
	 */
	PValue getValue();
	/**
	 * 引用字段的值是否已经被设置了。
	 * @return
	 */
	boolean isValueSetted();
	/**
	 * 取得引用字段长度。
	 * @return
	 */
	int getLength();
	/**
	 * 设置引用字段长度。
	 * @param length
	 */
	void setLength(int length);
	/**
	 * 引用字段长度是否已经被设置了。
	 * @return
	 */
	boolean isLengthSetted();
	/**
	 * 引用字段的值设置事件监听器。
	 * 用于+方向的引用。
	 * @author JiangMin
	 *
	 */
	interface ValueSettedListener {
		/**
		 * 值设置事件。
		 * @param ref
		 * @param value
		 */
		void setted(FieldRef ref, PValue value);
		/**
		 * 事件发生后是否自动删除该监听器。
		 * @return
		 */
		boolean shouldRemovedAfterCalled();
	}
	/**
	 * 引用字段的长度设置事件监听器。
	 * @author JiangMin
	 *
	 */
	interface LengthSettedListener {
		/**
		 * 长度设置事件。
		 * @param ref
		 * @param length
		 */
		void setted(FieldRef ref, int length);
		/**
		 * 事件发生后是否自动删除该监听器。
		 * @return
		 */
		boolean shouldRemovedAfterCalled();
	}
	void addValueSettedListener(ValueSettedListener lsn);
	boolean removeValueSettedListener(ValueSettedListener lsn);
	void addLengthSettedListener(LengthSettedListener lsn);
	boolean removeLengthSettedListener(LengthSettedListener lsn);
}
