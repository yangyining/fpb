package com.fineqt.fpb.lib.meta.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.fineqt.fpb.lib.meta.PElementExt;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.util.PElementExtFactory;
import com.fineqt.fpb.lib.model.fpbcommon.PModelElement;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.util.IllegalLiteralFormatException;

public abstract class PElementExtBase implements PElementExt {
	public final static String LN = System.getProperty("line.separator");
	public final static String TAB = "  ";
	protected static PElementExtFactory extFactory = PElementExtFactory.INSTANCE;
	
	protected PModelElement pmodel;
	protected boolean inited;
	protected PModuleExt pmoduleExt;

	public PElementExtBase(PModelElement pmodel, PModuleExt pmoduleExt) {
		this.pmodel = pmodel;
		this.pmoduleExt = pmoduleExt;
	}

	@Override
	public PModuleExt getPModule() {
		return pmoduleExt;
	}

	@Override
	public void init() throws InitMetaException {
		if (!inited) {
			//防止重入
			//例如由于类型初始化通过字段的引用可能会发生循环调用，所以在初始化之前改变初始化结束标志，来
			//防止初始化执行中通过间接引用来重新调用自己而发生的死循环
			inited = true;
			doInit();
//			//清空模型对象（释放内存） 
			//TODO 清空模型对象因该在专门的afterInit事件中进行（所有元素的初始化都完成后）。
//			pmodel = null;
		}
	}
	
	protected void doInit() throws InitMetaException {
	}	
	
	protected BigInteger parseBigInteger(String literal) throws IllegalLiteralFormatException {
		literal = literal.toLowerCase().trim();
		try {
			if (literal.startsWith(FpbConstants.HEX_INT_PREFIX)) {
				return new BigInteger(literal.substring(2), 16);
			} else {
				return new BigInteger(literal);
			}
		} catch (RuntimeException e) {
			throw new IllegalLiteralFormatException(e);
		}
	}
	
	protected BigDecimal parseBigDecimal(String literal) throws IllegalLiteralFormatException {
		try {
			return new BigDecimal(literal);
		} catch (NumberFormatException e) {
			throw new IllegalLiteralFormatException(e);
		}
	}
	
}
