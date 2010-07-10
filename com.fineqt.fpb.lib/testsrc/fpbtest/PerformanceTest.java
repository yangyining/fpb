package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.codec.SimpleDecodeResult;
import com.fineqt.fpb.lib.codec.SimpleDeocdeParameters;
import com.fineqt.fpb.lib.constraint.PTypeConstraintStorage;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.type.PFpbTypeEVAttrs;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeEVAttrs;
import com.fineqt.fpb.lib.type.PTypeEVExt;

import fpbtest.module.builtintest.BuiltintestFactory;

public class PerformanceTest extends TestCase {
	PModuleExt module = PModuleExt.Registry.PINSTANCE.resolvePModule("builtintest");
	BuiltintestFactory factory = (BuiltintestFactory)module.pPFactory();

	public void testPassByParaOrByObject() throws Exception {
		long start;
		int cnt = 10000 * 1;
		Thread.sleep(1000);
		System.gc();
		Thread.sleep(1000);
		
//		start = System.currentTimeMillis();
//		doPassByObject(cnt);
//		System.out.println("doPassByObject spend:"+(System.currentTimeMillis()-start));
		
		
		start = System.currentTimeMillis();
		doPassByParameter(cnt);
		System.out.println("doPassByParameter spend:"+(System.currentTimeMillis()-start));
	}
	
	public void doPassByObject(int cnt) throws Exception {
		for (int i = 0; i < cnt; i++) {
			DecodeResult parentResult = new SimpleDecodeResult();
//			parentResult.setValue((PValue)factory.createInteger());
			ByteOrder byteOrder = ByteOrder.BIGENDIAN;
			
			DecodeParameters paras = new SimpleDeocdeParameters();
			paras.setParentResult(parentResult);
			paras.setByteOrder(byteOrder);
			decode1_0(null, null, paras);
		}
	}
	
	public void doPassByParameter(int cnt) throws Exception{
		for (int i = 0; i < cnt; i++) {
			boolean optional = false;
			DecodeResult parentResult = new SimpleDecodeResult();
//			parentResult.setValue((PValue)factory.createInteger());
			PFpbTypeEVExt variant = (PFpbTypeEVExt)module.getBitstring().getEVMeta();
			PTypeConstraintStorage constraint = module.getBitstring().getConstraints();
			ByteOrder byteOrder = ByteOrder.BIGENDIAN;
			PFpbTypeEVAttrs priorityAttrs = variant.getFpbTypeEVAttrs();
			
			decode2_0(null, null, optional, parentResult, variant, constraint, byteOrder, priorityAttrs);
		}
	}
	
	DecodeResult decode1_0(DecodeContext cxt, IBitBuffer input, DecodeParameters paras) 
	throws DecodeException {
		return decode1_1(cxt, input, paras);
	}
	DecodeResult decode1_1(DecodeContext cxt, IBitBuffer input, DecodeParameters paras) 
	throws DecodeException {
		return decode1_2(cxt, input, paras);
	}
	DecodeResult decode1_2(DecodeContext cxt, IBitBuffer input, DecodeParameters paras) 
	throws DecodeException {
		return decode1_3(cxt, input, paras);
	}
	DecodeResult decode1_3(DecodeContext cxt, IBitBuffer input, DecodeParameters paras) 
	throws DecodeException {
		return decode1_4(cxt, input, paras);
	}
	DecodeResult decode1_4(DecodeContext cxt, IBitBuffer input, DecodeParameters paras) 
	throws DecodeException {
//		DecodeResult result = new SimpleDecodeResult();
//		result.setValue((PValue)factory.createBitstring());
//		return result;
		return null;
	}
	
	
	DecodeResult decode2_0(DecodeContext cxt, IBitBuffer input, boolean optional, DecodeResult parentResult, 
			PTypeEVExt variant, PTypeConstraintStorage constraint, ByteOrder byteOrder,
			PTypeEVAttrs priorityAttrs)
	throws DecodeException {
		return decode2_1(cxt, input, optional, parentResult, variant, constraint, byteOrder, priorityAttrs);
	}

	DecodeResult decode2_1(DecodeContext cxt, IBitBuffer input, boolean optional, DecodeResult parentResult, 
			PTypeEVExt variant, PTypeConstraintStorage constraint, ByteOrder byteOrder,
			PTypeEVAttrs priorityAttrs)
	throws DecodeException {
		return decode2_2(cxt, input, optional, parentResult, variant, constraint, byteOrder, priorityAttrs);
	}
	
	DecodeResult decode2_2(DecodeContext cxt, IBitBuffer input, boolean optional, DecodeResult parentResult, 
			PTypeEVExt variant, PTypeConstraintStorage constraint, ByteOrder byteOrder,
			PTypeEVAttrs priorityAttrs)
	throws DecodeException {
		return decode2_3(cxt, input, optional, parentResult, variant, constraint, byteOrder, priorityAttrs);
	}

	DecodeResult decode2_3(DecodeContext cxt, IBitBuffer input, boolean optional, DecodeResult parentResult, 
			PTypeEVExt variant, PTypeConstraintStorage constraint, ByteOrder byteOrder,
			PTypeEVAttrs priorityAttrs)
	throws DecodeException {
		return decode2_4(cxt, input, optional, parentResult, variant, constraint, byteOrder, priorityAttrs);
	}

	DecodeResult decode2_4(DecodeContext cxt, IBitBuffer input, boolean optional, DecodeResult parentResult, 
			PTypeEVExt variant, PTypeConstraintStorage constraint, ByteOrder byteOrder,
			PTypeEVAttrs priorityAttrs)
	throws DecodeException {
//		DecodeResult result = new SimpleDecodeResult();
//		result.setValue((PValue)factory.createBitstring());
//		return result;
		return null;
	}
	
}
