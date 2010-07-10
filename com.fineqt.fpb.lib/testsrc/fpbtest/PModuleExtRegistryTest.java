package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.builtin.BuiltinModule;
import com.fineqt.fpb.lib.meta.PModuleExt;

import fpbtest.module.builtintest.BuiltintestModule;

public class PModuleExtRegistryTest extends TestCase {

	public void testRegister() {
//		System.out.println(PModuleExt.Registry.INSTANCE.allModuleNames());
		PModuleExt meta = PModuleExt.Registry.PINSTANCE.resolvePModule(BuiltinModule.BUILTIN_MODULE_NAME);
//		System.out.println(meta);
		assertEquals(BuiltinModule.BUILTIN_MODULE_NAME, meta.getModuleName());
		assertNotNull(meta);
		meta = PModuleExt.Registry.PINSTANCE.resolvePModule(BuiltintestModule.MODULE_NAME);
		assertNotNull(meta);
		assertEquals(BuiltintestModule.MODULE_NAME, meta.getModuleName());
//		System.out.println(meta);
	}
	
	public void _testElse() throws Exception {
//		 double[] limits = {1,2,3,4,5,6,7};
//		 String[] dayOfWeekNames = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
//		 ChoiceFormat form = new ChoiceFormat(limits, dayOfWeekNames);
//		 ParsePosition status = new ParsePosition(0);
//		 for (double i = 0.0; i <= 8.0; ++i) {
//		     status.setIndex(0);
//		     System.out.println(i + " -> " + form.format(i) + " -> "
//		                              + form.parse(form.format(i),status));
//		 }
		
//		throw new MetaException(MetaException.CODE.UNKOWN_ERROR, null, "arg1");
	}
}
