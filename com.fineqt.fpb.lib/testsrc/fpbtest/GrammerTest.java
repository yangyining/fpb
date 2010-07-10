package fpbtest;

import java.io.IOException;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.ecore.resource.Resource;

import com.fineqt.fpb.lib.expression.PExpressionExt;
import com.fineqt.fpb.lib.grammer.T34fpbLexer;
import com.fineqt.fpb.lib.grammer.T34fpbParser;
import com.fineqt.fpb.lib.grammer.mv.ModuleSymbol;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.PModuleInitContext;
import com.fineqt.fpb.lib.meta.context.PModuleInitContextImpl;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContext;
import com.fineqt.fpb.lib.meta.context.PModuleParsingContextImpl;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.system.ResourceManager;
import com.fineqt.fpb.lib.util.ParserException;
import com.fineqt.fpb.lib.util.T34fpbLiteralParser;
import com.fineqt.fpb.lib.value.PPrimitiveValue;
import com.fineqt.fpb.lib.value.PValue;

import fpbtest.module.builtintest.BuiltintestModule;

public class GrammerTest extends TestCase {
	
	public void _testSimple() throws Exception {
		String str = "template charstring tmp1 := pattern \"abc\"";
		CharStream input = new ANTLRStringStream(str);
		T34fpbLexer lexer = new T34fpbLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		T34fpbParser paser = new T34fpbParser(tokens);
//		paser.templateDef();
	}
	
	public void _testParseExpression() throws Exception {
		BuiltintestModule module = BuiltintestModule.INSTANCE;
		T34fpbLiteralParser parser = T34fpbLiteralParser.INSTANCE;
		String literal;
		PExpressionExt exp;
		PValue resultValue;		
		//bitstring
		literal = "'1101'B";
		exp = parser.parseExpression(literal, module.getBitstring());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.BITSTRING, resultValue.pTypeMeta().getTypeClass());
		assertEquals("1101", ((PPrimitiveValue)resultValue).getText());
		//hexstring
		literal = "'1ab'H";
		exp = parser.parseExpression(literal, module.getHexstring());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.HEXSTRING, resultValue.pTypeMeta().getTypeClass());
		assertEquals("1AB", ((PPrimitiveValue)resultValue).getText());
		//octetstring
		literal = "'11FF'O";
		exp = parser.parseExpression(literal, module.getOctetstring());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.OCTETSTRING, resultValue.pTypeMeta().getTypeClass());
		assertEquals("11FF", ((PPrimitiveValue)resultValue).getText());
		//charstring
		literal = "\"xy\"\"z\"";
		exp = parser.parseExpression(literal, module.getCharstring());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.CHARSTRING, resultValue.pTypeMeta().getTypeClass());
		assertEquals("xy\"z", ((PPrimitiveValue)resultValue).getText());
		//boolean
		literal = "true";
		exp = parser.parseExpression(literal, module.getBoolean());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.BOOLEAN, resultValue.pTypeMeta().getTypeClass());
		assertEquals("true", ((PPrimitiveValue)resultValue).getText());
		//integer
		literal = "123";
		exp = parser.parseExpression(literal, module.getInteger());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.INTEGER, resultValue.pTypeMeta().getTypeClass());
		assertEquals("123", ((PPrimitiveValue)resultValue).getText());
		//float
		literal = "123.1";
		exp = parser.parseExpression(literal, module.getFloat());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.FLOAT, resultValue.pTypeMeta().getTypeClass());
		assertEquals("123.1", ((PPrimitiveValue)resultValue).getText());
		//verdict
		literal = "fail";
		exp = parser.parseExpression(literal, module.getVerdict());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.VERDICT, resultValue.pTypeMeta().getTypeClass());
		assertEquals("fail", ((PPrimitiveValue)resultValue).getText());
		//enumerated
		literal = "FIELD1";
		exp = parser.parseExpression(literal, module.getFieldName());
		assertNotNull(exp);
		resultValue = exp.valueOf();
		assertEquals(TypeClass.ENUMERATED, resultValue.pTypeMeta().getTypeClass());
		assertEquals("FIELD1", ((PPrimitiveValue)resultValue).getText());
		
	}
	
//	private static void printGrammerError(T34fpbHelper helper) {
//		List<String> msgs = helper.getGrammerErrorMsgs();
//		for (int i = 0; i < msgs.size(); i++) {
//			System.out.println("["+i+"]"+msgs.get(i));
//		}
//	}
	
	public void testParseModuleFile() throws Exception {
//		PModule module1 = T34fpbLiteralParser.INSTANCE.parseModuleModel(FpbTestUtil.TEST_PROTOCOL_PATH 
//				+ "langtest1.module");
//		printModule(module1);
//		PModule module2 = T34fpbLiteralParser.INSTANCE.parseModuleModel(FpbTestUtil.TEST_PROTOCOL_PATH 
//				+ "langtest2.module");
//		printModule(module2);
//		PModule module3 = T34fpbLiteralParser.INSTANCE.parseModuleModel(FpbTestUtil.TEST_PROTOCOL_PATH 
//				+ "langtest3.module");
//		printModule(module3);
	    PModuleParsingContext parsingCxt = new PModuleParsingContextImpl();
	    ModuleSymbol symbol = T34fpbLiteralParser.INSTANCE.parseModuleModel("tutorial", parsingCxt);
		PModule module4 = symbol.getModel();
		printModule(module4);
	}

	public void _testParseModule() throws Exception {
//		PModuleExt module = T34fpbLiteralParser.INSTANCE.parseModule(FpbTestUtil.TEST_PROTOCOL_PATH 
//				+ "builtintest.module");
//		System.out.println(module);
        PModuleExt module = parseModule("compacttest");
		System.out.println(module);
	}

    public static PModuleExt parseModule(String moduleName) throws ParserException {
        PModuleParsingContext parsingCxt = new PModuleParsingContextImpl();
	    T34fpbLiteralParser.INSTANCE.parseModuleModel(moduleName, parsingCxt);
        PModuleInitContext initCxt = new PModuleInitContextImpl();
        initCxt.getModelsForInit().addAll(parsingCxt.getAllResultModel());
        T34fpbLiteralParser.INSTANCE.createModuleExt(initCxt);
        return initCxt.getResultList().get(0);
    }
	
	private void printModule(PModule module) throws IOException {
		ResourceManager.INSTANCE.saveModule(module);
		Resource resource = ResourceManager.INSTANCE.getModuleResource(module.getName());
		resource.save(System.out, null);
	}
}
