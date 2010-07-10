// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 ./grammer/T34fpb.g 2009-08-25 16:58:09
 package com.fineqt.fpb.lib.grammer;
import com.fineqt.fpb.lib.model.fpbtemplate.PMatcher;
import com.fineqt.fpb.lib.model.fpbtemplate.PExpressionMatcher;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.model.fpbmodule.TypeClass;
import com.fineqt.fpb.lib.model.fpbmodule.PType;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.model.fpbmodule.PProperty;
import com.fineqt.fpb.lib.model.fpbmodule.PArgumentGroup;
import com.fineqt.fpb.lib.model.fpbmodule.PArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PListArgument;
import com.fineqt.fpb.lib.model.fpbmodule.PTypeConstraint;
import com.fineqt.fpb.lib.model.fpbmodule.PEnumItem;
import com.fineqt.fpb.lib.grammer.mv.EnumeratedTypeSymbol;
import com.fineqt.fpb.lib.grammer.mv.ContainerTypeSymbol;
import com.fineqt.fpb.lib.grammer.mv.ListTypeSymbol;
import com.fineqt.fpb.lib.grammer.mv.ValueReferenceSymbol;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class T34fpbParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNMENT_CHAR", "OMIT", "TRUE", "FALSE", "PASS", "FAIL", "INCONC", "NONE", "ERROR", "CHAR", "TEMPLATE", "BIT_STRING", "BOOLEAN", "INTEGER", "OCTET_STRING", "HEX_STRING", "VERDICT_TYPE", "FLOAT", "CHAR_STRING", "UNIVERSAL", "OBJECT_IDENTIFIER", "MODIFIES", "COMPLEMENT", "SUBSET", "SUPERSET", "IF_PRESENT", "LENGTH", "INFINITY", "PATTERN", "MODULE", "WITH", "ENCODE", "VARIANT", "RUNTIME", "TYPE", "CONST", "MODULE_PAR", "ALL", "EXCEPT", "IMPORT", "FROM", "RECORD", "UNION", "SET", "ENUMERATED", "OF", "OPTIONAL", "ENUM_SET", "ENUM", "ENUM_SET_REF", "THREAD", "SEMI_COLON", "UNDER_SCORE", "DOT", "MINUS", "COLON", "ANY_VALUE", "ANY_OR_OMIT", "COMMA", "RANGE_OP", "VALUE_REF_ARG_PREFIX", "TYPE_REF_ARG_PREFIX", "ML_COMMENT", "SL_COMMENT", "WS", "IDENTIFIER", "GeneralTextCharacter", "Special", "CSTRING", "Alphanumeric", "OtherCharacter", "Space", "Letter", "Num", "UppercaseLetter", "LowercaseLetter", "OtherSpecial", "Zero", "NonzeroNum", "NonzeroNumber", "DecimalNumber", "Bin", "BSTRING", "Hex", "HSTRING", "Oct", "OSTRING", "BSTRING_MATCH", "HSTRING_MATCH", "OSTRING_MATCH", "NUMBER", "HexPrefix", "INTEGER_VALUE", "Exponential", "FLOAT_VALUE", "'{'", "'}'", "'('", "')'", "'['", "']'", "'='", "'+'"
    };
    public static final int CHAR_STRING=22;
    public static final int Special=71;
    public static final int INCONC=10;
    public static final int CONST=39;
    public static final int CHAR=13;
    public static final int ENUM_SET=51;
    public static final int MODIFIES=25;
    public static final int EXCEPT=42;
    public static final int EOF=-1;
    public static final int PASS=8;
    public static final int TYPE=38;
    public static final int PATTERN=32;
    public static final int OBJECT_IDENTIFIER=24;
    public static final int IMPORT=43;
    public static final int Num=77;
    public static final int Oct=89;
    public static final int ANY_OR_OMIT=61;
    public static final int UppercaseLetter=78;
    public static final int ANY_VALUE=60;
    public static final int VALUE_REF_ARG_PREFIX=64;
    public static final int T__99=99;
    public static final int HEX_STRING=19;
    public static final int HexPrefix=95;
    public static final int RECORD=45;
    public static final int ASSIGNMENT_CHAR=4;
    public static final int NUMBER=94;
    public static final int OSTRING_MATCH=93;
    public static final int SEMI_COLON=55;
    public static final int DecimalNumber=84;
    public static final int VARIANT=36;
    public static final int OCTET_STRING=18;
    public static final int ERROR=12;
    public static final int OF=49;
    public static final int FAIL=9;
    public static final int RUNTIME=37;
    public static final int SUBSET=27;
    public static final int WS=68;
    public static final int BSTRING=86;
    public static final int IF_PRESENT=29;
    public static final int NONE=11;
    public static final int SL_COMMENT=67;
    public static final int COMPLEMENT=26;
    public static final int Hex=87;
    public static final int FLOAT_VALUE=98;
    public static final int CSTRING=72;
    public static final int FROM=44;
    public static final int UNIVERSAL=23;
    public static final int FALSE=7;
    public static final int ENCODE=35;
    public static final int Letter=76;
    public static final int BIT_STRING=15;
    public static final int OtherSpecial=80;
    public static final int VERDICT_TYPE=20;
    public static final int NonzeroNum=82;
    public static final int Zero=81;
    public static final int TYPE_REF_ARG_PREFIX=65;
    public static final int FLOAT=21;
    public static final int BSTRING_MATCH=91;
    public static final int RANGE_OP=63;
    public static final int LENGTH=30;
    public static final int Space=75;
    public static final int ML_COMMENT=66;
    public static final int Alphanumeric=73;
    public static final int BOOLEAN=16;
    public static final int OtherCharacter=74;
    public static final int COMMA=62;
    public static final int IDENTIFIER=69;
    public static final int SUPERSET=28;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int ALL=41;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int Bin=85;
    public static final int DOT=57;
    public static final int HSTRING_MATCH=92;
    public static final int WITH=34;
    public static final int INTEGER=17;
    public static final int NonzeroNumber=83;
    public static final int Exponential=97;
    public static final int THREAD=54;
    public static final int UNDER_SCORE=56;
    public static final int HSTRING=88;
    public static final int SET=47;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int MINUS=58;
    public static final int MODULE=33;
    public static final int TRUE=6;
    public static final int MODULE_PAR=40;
    public static final int UNION=46;
    public static final int GeneralTextCharacter=70;
    public static final int OPTIONAL=50;
    public static final int COLON=59;
    public static final int ENUMERATED=48;
    public static final int OMIT=5;
    public static final int ENUM=52;
    public static final int TEMPLATE=14;
    public static final int INFINITY=31;
    public static final int LowercaseLetter=79;
    public static final int ENUM_SET_REF=53;
    public static final int OSTRING=90;
    public static final int INTEGER_VALUE=96;

    // delegates
    // delegators

    protected static class TypeScope_scope {
        String typeName;
    }
    protected Stack TypeScope_stack = new Stack();
    protected static class ConstScope_scope {
        boolean dummy;
    }
    protected Stack ConstScope_stack = new Stack();


        public T34fpbParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public T34fpbParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return T34fpbParser.tokenNames; }
    public String getGrammarFileName() { return "./grammer/T34fpb.g"; }


    private T34fpbHelper helper;

    public void setHelper(T34fpbHelper helper) {
    	this.helper = helper;
    }

    public T34fpbHelper getHelper() {
    	return helper;
    }

    public void reset() {
    	super.reset();
    	if (helper != null) {
    		helper.reset();
    	}
    }

    public void emitErrorMessage(String msg) {
    	if (helper != null) {
    		helper.addErrorMsg(msg);
    	} else {
    		System.err.println(msg);
    	}
    }

    public void pushTypeScope(String typeName) {
    	TypeScope_scope scope = new TypeScope_scope();
    	scope.typeName = typeName;
    	TypeScope_stack.push(scope);
    }

    public String popTypeScope() {
    	TypeScope_scope scope = (TypeScope_scope)TypeScope_stack.pop();
    	return scope.typeName;
    }

    public String peekTypeScope() {
    	if (TypeScope_stack.empty())
    		return null;
    	TypeScope_scope scope = (TypeScope_scope)TypeScope_stack.peek();
    	if (scope == null)
    		return null;
    	return scope.typeName;
    }

    public boolean setTopTypeScope(String typeName) {
    	TypeScope_scope scope = (TypeScope_scope)TypeScope_stack.peek();
    	if (scope == null)
    		return false;
    	scope.typeName = typeName;
    	return true;
    }

    /**
     * @param deep from 0
     * @return
     */
    public String peekTypeScope(int deep) {
    	if (deep + 1 > TypeScope_stack.size()) {
    		return null;
    	}
    	TypeScope_scope scope = (TypeScope_scope)TypeScope_stack.get(
    			TypeScope_stack.size() - 1 - deep);
    	if (scope == null)
    		return null;
    	return scope.typeName;
    }

    public boolean inConstScope() {
    	return !ConstScope_stack.empty();
    }




    // $ANTLR start "module"
    // ./grammer/T34fpb.g:375:1: module : MODULE moduleId '{' ( moduleDefinitionsPart )? '}' ( withStatement[helper.getModuleSymbol()] )? ( SEMI_COLON )? ;
    public final void module() throws RecognitionException {
        Token MODULE1=null;
        T34fpbParser.moduleId_return moduleId2 = null;


        try {
            // ./grammer/T34fpb.g:376:5: ( MODULE moduleId '{' ( moduleDefinitionsPart )? '}' ( withStatement[helper.getModuleSymbol()] )? ( SEMI_COLON )? )
            // ./grammer/T34fpb.g:376:9: MODULE moduleId '{' ( moduleDefinitionsPart )? '}' ( withStatement[helper.getModuleSymbol()] )? ( SEMI_COLON )?
            {
            MODULE1=(Token)match(input,MODULE,FOLLOW_MODULE_in_module2114); if (state.failed) return ;
            pushFollow(FOLLOW_moduleId_in_module2116);
            moduleId2=moduleId();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              helper.moduleRule(MODULE1, (moduleId2!=null?input.toString(moduleId2.start,moduleId2.stop):null));
            }
            match(input,99,FOLLOW_99_in_module2129); if (state.failed) return ;
            // ./grammer/T34fpb.g:378:9: ( moduleDefinitionsPart )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=TYPE && LA1_0<=MODULE_PAR)||LA1_0==IMPORT||LA1_0==ENUM_SET||LA1_0==THREAD) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ./grammer/T34fpb.g:378:11: moduleDefinitionsPart
                    {
                    pushFollow(FOLLOW_moduleDefinitionsPart_in_module2142);
                    moduleDefinitionsPart();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            match(input,100,FOLLOW_100_in_module2156); if (state.failed) return ;
            // ./grammer/T34fpb.g:380:9: ( withStatement[helper.getModuleSymbol()] )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==WITH) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./grammer/T34fpb.g:380:11: withStatement[helper.getModuleSymbol()]
                    {
                    pushFollow(FOLLOW_withStatement_in_module2168);
                    withStatement(helper.getModuleSymbol());

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // ./grammer/T34fpb.g:381:9: ( SEMI_COLON )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==SEMI_COLON) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./grammer/T34fpb.g:381:11: SEMI_COLON
                    {
                    match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_module2185); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "module"

    public static class moduleId_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "moduleId"
    // ./grammer/T34fpb.g:384:1: moduleId : globalModuleId ;
    public final T34fpbParser.moduleId_return moduleId() throws RecognitionException {
        T34fpbParser.moduleId_return retval = new T34fpbParser.moduleId_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:385:5: ( globalModuleId )
            // ./grammer/T34fpb.g:385:9: globalModuleId
            {
            pushFollow(FOLLOW_globalModuleId_in_moduleId2212);
            globalModuleId();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moduleId"


    // $ANTLR start "moduleDefinitionsPart"
    // ./grammer/T34fpb.g:388:1: moduleDefinitionsPart : moduleDefinitionsList ;
    public final void moduleDefinitionsPart() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:389:5: ( moduleDefinitionsList )
            // ./grammer/T34fpb.g:389:9: moduleDefinitionsList
            {
            pushFollow(FOLLOW_moduleDefinitionsList_in_moduleDefinitionsPart2231);
            moduleDefinitionsList();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "moduleDefinitionsPart"


    // $ANTLR start "moduleDefinitionsList"
    // ./grammer/T34fpb.g:392:1: moduleDefinitionsList : moduleDefinition ( SEMI_COLON )? ( moduleDefinition ( SEMI_COLON )? )* ;
    public final void moduleDefinitionsList() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:393:5: ( moduleDefinition ( SEMI_COLON )? ( moduleDefinition ( SEMI_COLON )? )* )
            // ./grammer/T34fpb.g:393:9: moduleDefinition ( SEMI_COLON )? ( moduleDefinition ( SEMI_COLON )? )*
            {
            pushFollow(FOLLOW_moduleDefinition_in_moduleDefinitionsList2254);
            moduleDefinition();

            state._fsp--;
            if (state.failed) return ;
            // ./grammer/T34fpb.g:393:26: ( SEMI_COLON )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==SEMI_COLON) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./grammer/T34fpb.g:393:28: SEMI_COLON
                    {
                    match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_moduleDefinitionsList2258); if (state.failed) return ;

                    }
                    break;

            }

            // ./grammer/T34fpb.g:394:9: ( moduleDefinition ( SEMI_COLON )? )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=TYPE && LA6_0<=MODULE_PAR)||LA6_0==IMPORT||LA6_0==ENUM_SET||LA6_0==THREAD) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ./grammer/T34fpb.g:394:13: moduleDefinition ( SEMI_COLON )?
            	    {
            	    pushFollow(FOLLOW_moduleDefinition_in_moduleDefinitionsList2275);
            	    moduleDefinition();

            	    state._fsp--;
            	    if (state.failed) return ;
            	    // ./grammer/T34fpb.g:394:30: ( SEMI_COLON )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==SEMI_COLON) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // ./grammer/T34fpb.g:394:32: SEMI_COLON
            	            {
            	            match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_moduleDefinitionsList2279); if (state.failed) return ;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "moduleDefinitionsList"


    // $ANTLR start "moduleDefinition"
    // ./grammer/T34fpb.g:398:1: moduleDefinition : ( typeDef ( withStatement[$typeDef.newType] )? | enumSetDef ( withStatement[$enumSetDef.newSet] )? | constDef ( withStatement[$constDef.newConstList] )? | moduleParDef ( withStatement[$moduleParDef.newMparList] )? | importDef ( withStatement[$importDef.newImportList] )? ) ;
    public final void moduleDefinition() throws RecognitionException {
        Object typeDef3 = null;

        Object enumSetDef4 = null;

        List<Object> constDef5 = null;

        List<Object> moduleParDef6 = null;

        List<Object> importDef7 = null;


        try {
            // ./grammer/T34fpb.g:399:5: ( ( typeDef ( withStatement[$typeDef.newType] )? | enumSetDef ( withStatement[$enumSetDef.newSet] )? | constDef ( withStatement[$constDef.newConstList] )? | moduleParDef ( withStatement[$moduleParDef.newMparList] )? | importDef ( withStatement[$importDef.newImportList] )? ) )
            // ./grammer/T34fpb.g:399:9: ( typeDef ( withStatement[$typeDef.newType] )? | enumSetDef ( withStatement[$enumSetDef.newSet] )? | constDef ( withStatement[$constDef.newConstList] )? | moduleParDef ( withStatement[$moduleParDef.newMparList] )? | importDef ( withStatement[$importDef.newImportList] )? )
            {
            // ./grammer/T34fpb.g:399:9: ( typeDef ( withStatement[$typeDef.newType] )? | enumSetDef ( withStatement[$enumSetDef.newSet] )? | constDef ( withStatement[$constDef.newConstList] )? | moduleParDef ( withStatement[$moduleParDef.newMparList] )? | importDef ( withStatement[$importDef.newImportList] )? )
            int alt12=5;
            switch ( input.LA(1) ) {
            case TYPE:
                {
                alt12=1;
                }
                break;
            case ENUM_SET:
                {
                alt12=2;
                }
                break;
            case CONST:
                {
                alt12=3;
                }
                break;
            case MODULE_PAR:
            case THREAD:
                {
                alt12=4;
                }
                break;
            case IMPORT:
                {
                alt12=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ./grammer/T34fpb.g:399:11: typeDef ( withStatement[$typeDef.newType] )?
                    {
                    pushFollow(FOLLOW_typeDef_in_moduleDefinition2318);
                    typeDef3=typeDef();

                    state._fsp--;
                    if (state.failed) return ;
                    // ./grammer/T34fpb.g:399:19: ( withStatement[$typeDef.newType] )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==WITH) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./grammer/T34fpb.g:399:21: withStatement[$typeDef.newType]
                            {
                            pushFollow(FOLLOW_withStatement_in_moduleDefinition2322);
                            withStatement(typeDef3);

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:400:13: enumSetDef ( withStatement[$enumSetDef.newSet] )?
                    {
                    pushFollow(FOLLOW_enumSetDef_in_moduleDefinition2341);
                    enumSetDef4=enumSetDef();

                    state._fsp--;
                    if (state.failed) return ;
                    // ./grammer/T34fpb.g:400:24: ( withStatement[$enumSetDef.newSet] )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==WITH) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ./grammer/T34fpb.g:400:26: withStatement[$enumSetDef.newSet]
                            {
                            pushFollow(FOLLOW_withStatement_in_moduleDefinition2345);
                            withStatement(enumSetDef4);

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:401:11: constDef ( withStatement[$constDef.newConstList] )?
                    {
                    pushFollow(FOLLOW_constDef_in_moduleDefinition2362);
                    constDef5=constDef();

                    state._fsp--;
                    if (state.failed) return ;
                    // ./grammer/T34fpb.g:401:20: ( withStatement[$constDef.newConstList] )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==WITH) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ./grammer/T34fpb.g:401:22: withStatement[$constDef.newConstList]
                            {
                            pushFollow(FOLLOW_withStatement_in_moduleDefinition2366);
                            withStatement(constDef5);

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:402:11: moduleParDef ( withStatement[$moduleParDef.newMparList] )?
                    {
                    pushFollow(FOLLOW_moduleParDef_in_moduleDefinition2383);
                    moduleParDef6=moduleParDef();

                    state._fsp--;
                    if (state.failed) return ;
                    // ./grammer/T34fpb.g:402:24: ( withStatement[$moduleParDef.newMparList] )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==WITH) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ./grammer/T34fpb.g:402:26: withStatement[$moduleParDef.newMparList]
                            {
                            pushFollow(FOLLOW_withStatement_in_moduleDefinition2387);
                            withStatement(moduleParDef6);

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:403:11: importDef ( withStatement[$importDef.newImportList] )?
                    {
                    pushFollow(FOLLOW_importDef_in_moduleDefinition2404);
                    importDef7=importDef();

                    state._fsp--;
                    if (state.failed) return ;
                    // ./grammer/T34fpb.g:403:21: ( withStatement[$importDef.newImportList] )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==WITH) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ./grammer/T34fpb.g:403:23: withStatement[$importDef.newImportList]
                            {
                            pushFollow(FOLLOW_withStatement_in_moduleDefinition2408);
                            withStatement(importDef7);

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "moduleDefinition"


    // $ANTLR start "importDef"
    // ./grammer/T34fpb.g:411:1: importDef returns [List<Object> newImportList] : IMPORT importFromSpec importSpec[$importFromSpec.moduleName] ;
    public final List<Object> importDef() throws RecognitionException {
        List<Object> newImportList = null;

        String importFromSpec8 = null;

        T34fpbParser.importSpec_return importSpec9 = null;


        try {
            // ./grammer/T34fpb.g:412:5: ( IMPORT importFromSpec importSpec[$importFromSpec.moduleName] )
            // ./grammer/T34fpb.g:412:9: IMPORT importFromSpec importSpec[$importFromSpec.moduleName]
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_importDef2456); if (state.failed) return newImportList;
            pushFollow(FOLLOW_importFromSpec_in_importDef2458);
            importFromSpec8=importFromSpec();

            state._fsp--;
            if (state.failed) return newImportList;
            pushFollow(FOLLOW_importSpec_in_importDef2466);
            importSpec9=importSpec(importFromSpec8);

            state._fsp--;
            if (state.failed) return newImportList;
            if ( state.backtracking==0 ) {
               newImportList = (importSpec9!=null?importSpec9.newImportList:null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newImportList;
    }
    // $ANTLR end "importDef"


    // $ANTLR start "importFromSpec"
    // ./grammer/T34fpb.g:416:1: importFromSpec returns [String moduleName] : FROM moduleId ;
    public final String importFromSpec() throws RecognitionException {
        String moduleName = null;

        T34fpbParser.moduleId_return moduleId10 = null;


        try {
            // ./grammer/T34fpb.g:417:5: ( FROM moduleId )
            // ./grammer/T34fpb.g:417:9: FROM moduleId
            {
            match(input,FROM,FOLLOW_FROM_in_importFromSpec2497); if (state.failed) return moduleName;
            pushFollow(FOLLOW_moduleId_in_importFromSpec2499);
            moduleId10=moduleId();

            state._fsp--;
            if (state.failed) return moduleName;
            if ( state.backtracking==0 ) {
               moduleName = (moduleId10!=null?input.toString(moduleId10.start,moduleId10.stop):null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return moduleName;
    }
    // $ANTLR end "importFromSpec"

    public static class importSpec_return extends ParserRuleReturnScope {
        public List<Object> newImportList;
    };

    // $ANTLR start "importSpec"
    // ./grammer/T34fpb.g:420:1: importSpec[String moduleName] returns [List<Object> newImportList] : ( ALL | '{' ( importElement[$moduleName, $newImportList] ( SEMI_COLON )? )* '}' );
    public final T34fpbParser.importSpec_return importSpec(String moduleName) throws RecognitionException {
        T34fpbParser.importSpec_return retval = new T34fpbParser.importSpec_return();
        retval.start = input.LT(1);


        	retval.newImportList = new ArrayList<Object>();

        try {
            // ./grammer/T34fpb.g:424:5: ( ALL | '{' ( importElement[$moduleName, $newImportList] ( SEMI_COLON )? )* '}' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ALL) ) {
                alt15=1;
            }
            else if ( (LA15_0==99) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ./grammer/T34fpb.g:424:9: ALL
                    {
                    match(input,ALL,FOLLOW_ALL_in_importSpec2535); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       helper.importSpecRule1(((Token)retval.start), moduleName, retval.newImportList); 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:425:8: '{' ( importElement[$moduleName, $newImportList] ( SEMI_COLON )? )* '}'
                    {
                    match(input,99,FOLLOW_99_in_importSpec2546); if (state.failed) return retval;
                    // ./grammer/T34fpb.g:426:7: ( importElement[$moduleName, $newImportList] ( SEMI_COLON )? )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==TEMPLATE||(LA14_0>=TYPE && LA14_0<=MODULE_PAR)||LA14_0==ENUM_SET) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ./grammer/T34fpb.g:426:10: importElement[$moduleName, $newImportList] ( SEMI_COLON )?
                    	    {
                    	    pushFollow(FOLLOW_importElement_in_importSpec2558);
                    	    importElement(moduleName, retval.newImportList);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    // ./grammer/T34fpb.g:426:54: ( SEMI_COLON )?
                    	    int alt13=2;
                    	    int LA13_0 = input.LA(1);

                    	    if ( (LA13_0==SEMI_COLON) ) {
                    	        alt13=1;
                    	    }
                    	    switch (alt13) {
                    	        case 1 :
                    	            // ./grammer/T34fpb.g:426:56: SEMI_COLON
                    	            {
                    	            match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_importSpec2564); if (state.failed) return retval;

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match(input,100,FOLLOW_100_in_importSpec2590); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "importSpec"


    // $ANTLR start "importElement"
    // ./grammer/T34fpb.g:431:1: importElement[String moduleName, List<Object> newImportList] : ( importModuleParSpec[$moduleName, $newImportList] | importTypeDefSpec[$moduleName, $newImportList] | importTemplateSpec[$moduleName, $newImportList] | importConstSpec[$moduleName, $newImportList] | importEnumSetSpec[$moduleName, $newImportList] );
    public final void importElement(String moduleName, List<Object> newImportList) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:432:5: ( importModuleParSpec[$moduleName, $newImportList] | importTypeDefSpec[$moduleName, $newImportList] | importTemplateSpec[$moduleName, $newImportList] | importConstSpec[$moduleName, $newImportList] | importEnumSetSpec[$moduleName, $newImportList] )
            int alt16=5;
            switch ( input.LA(1) ) {
            case MODULE_PAR:
                {
                alt16=1;
                }
                break;
            case TYPE:
                {
                alt16=2;
                }
                break;
            case TEMPLATE:
                {
                alt16=3;
                }
                break;
            case CONST:
                {
                alt16=4;
                }
                break;
            case ENUM_SET:
                {
                alt16=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ./grammer/T34fpb.g:432:9: importModuleParSpec[$moduleName, $newImportList]
                    {
                    pushFollow(FOLLOW_importModuleParSpec_in_importElement2615);
                    importModuleParSpec(moduleName, newImportList);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:433:13: importTypeDefSpec[$moduleName, $newImportList]
                    {
                    pushFollow(FOLLOW_importTypeDefSpec_in_importElement2631);
                    importTypeDefSpec(moduleName, newImportList);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:434:13: importTemplateSpec[$moduleName, $newImportList]
                    {
                    pushFollow(FOLLOW_importTemplateSpec_in_importElement2647);
                    importTemplateSpec(moduleName, newImportList);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:435:13: importConstSpec[$moduleName, $newImportList]
                    {
                    pushFollow(FOLLOW_importConstSpec_in_importElement2663);
                    importConstSpec(moduleName, newImportList);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:436:11: importEnumSetSpec[$moduleName, $newImportList]
                    {
                    pushFollow(FOLLOW_importEnumSetSpec_in_importElement2677);
                    importEnumSetSpec(moduleName, newImportList);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "importElement"

    public static class importModuleParSpec_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "importModuleParSpec"
    // ./grammer/T34fpb.g:439:1: importModuleParSpec[String moduleName, List<Object> newImportList] : MODULE_PAR ( identifierRefList | ALL ) ;
    public final T34fpbParser.importModuleParSpec_return importModuleParSpec(String moduleName, List<Object> newImportList) throws RecognitionException {
        T34fpbParser.importModuleParSpec_return retval = new T34fpbParser.importModuleParSpec_return();
        retval.start = input.LT(1);

        List<String> identifierRefList11 = null;


        try {
            // ./grammer/T34fpb.g:440:5: ( MODULE_PAR ( identifierRefList | ALL ) )
            // ./grammer/T34fpb.g:440:9: MODULE_PAR ( identifierRefList | ALL )
            {
            match(input,MODULE_PAR,FOLLOW_MODULE_PAR_in_importModuleParSpec2704); if (state.failed) return retval;
            // ./grammer/T34fpb.g:441:9: ( identifierRefList | ALL )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IDENTIFIER) ) {
                alt17=1;
            }
            else if ( (LA17_0==ALL) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ./grammer/T34fpb.g:441:13: identifierRefList
                    {
                    pushFollow(FOLLOW_identifierRefList_in_importModuleParSpec2719);
                    identifierRefList11=identifierRefList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                              		helper.importModuleParSpecRule1(((Token)retval.start), moduleName, identifierRefList11, newImportList); 
                              	
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:444:17: ALL
                    {
                    match(input,ALL,FOLLOW_ALL_in_importModuleParSpec2739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       helper.importModuleParSpecRule2(((Token)retval.start), moduleName, newImportList); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "importModuleParSpec"

    public static class importConstSpec_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "importConstSpec"
    // ./grammer/T34fpb.g:448:1: importConstSpec[String moduleName, List<Object> newImportList] : CONST ( identifierRefList | ALL ) ;
    public final T34fpbParser.importConstSpec_return importConstSpec(String moduleName, List<Object> newImportList) throws RecognitionException {
        T34fpbParser.importConstSpec_return retval = new T34fpbParser.importConstSpec_return();
        retval.start = input.LT(1);

        List<String> identifierRefList12 = null;


        try {
            // ./grammer/T34fpb.g:449:5: ( CONST ( identifierRefList | ALL ) )
            // ./grammer/T34fpb.g:449:9: CONST ( identifierRefList | ALL )
            {
            match(input,CONST,FOLLOW_CONST_in_importConstSpec2772); if (state.failed) return retval;
            // ./grammer/T34fpb.g:450:9: ( identifierRefList | ALL )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDENTIFIER) ) {
                alt18=1;
            }
            else if ( (LA18_0==ALL) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ./grammer/T34fpb.g:450:13: identifierRefList
                    {
                    pushFollow(FOLLOW_identifierRefList_in_importConstSpec2787);
                    identifierRefList12=identifierRefList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                              		helper.importConstSpecRule1(((Token)retval.start), moduleName, identifierRefList12, newImportList); 
                              	
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:453:17: ALL
                    {
                    match(input,ALL,FOLLOW_ALL_in_importConstSpec2807); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       helper.importConstSpecRule2(((Token)retval.start), moduleName, newImportList); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "importConstSpec"

    public static class importTypeDefSpec_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "importTypeDefSpec"
    // ./grammer/T34fpb.g:457:1: importTypeDefSpec[String moduleName, List<Object> newImportList] : TYPE ( identifierRefList | ALL ) ;
    public final T34fpbParser.importTypeDefSpec_return importTypeDefSpec(String moduleName, List<Object> newImportList) throws RecognitionException {
        T34fpbParser.importTypeDefSpec_return retval = new T34fpbParser.importTypeDefSpec_return();
        retval.start = input.LT(1);

        List<String> identifierRefList13 = null;


        try {
            // ./grammer/T34fpb.g:458:5: ( TYPE ( identifierRefList | ALL ) )
            // ./grammer/T34fpb.g:458:9: TYPE ( identifierRefList | ALL )
            {
            match(input,TYPE,FOLLOW_TYPE_in_importTypeDefSpec2848); if (state.failed) return retval;
            // ./grammer/T34fpb.g:459:9: ( identifierRefList | ALL )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENTIFIER) ) {
                alt19=1;
            }
            else if ( (LA19_0==ALL) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./grammer/T34fpb.g:459:13: identifierRefList
                    {
                    pushFollow(FOLLOW_identifierRefList_in_importTypeDefSpec2863);
                    identifierRefList13=identifierRefList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                              		helper.importTypeDefSpecRule1(((Token)retval.start), moduleName, identifierRefList13, newImportList); 
                              	
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:462:17: ALL
                    {
                    match(input,ALL,FOLLOW_ALL_in_importTypeDefSpec2883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       helper.importTypeDefSpecRule2(((Token)retval.start), moduleName, newImportList); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "importTypeDefSpec"

    public static class importTemplateSpec_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "importTemplateSpec"
    // ./grammer/T34fpb.g:466:1: importTemplateSpec[String moduleName, List<Object> newImportList] : TEMPLATE ( identifierRefList | ALL ) ;
    public final T34fpbParser.importTemplateSpec_return importTemplateSpec(String moduleName, List<Object> newImportList) throws RecognitionException {
        T34fpbParser.importTemplateSpec_return retval = new T34fpbParser.importTemplateSpec_return();
        retval.start = input.LT(1);

        List<String> identifierRefList14 = null;


        try {
            // ./grammer/T34fpb.g:467:5: ( TEMPLATE ( identifierRefList | ALL ) )
            // ./grammer/T34fpb.g:467:9: TEMPLATE ( identifierRefList | ALL )
            {
            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_importTemplateSpec2924); if (state.failed) return retval;
            // ./grammer/T34fpb.g:468:9: ( identifierRefList | ALL )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IDENTIFIER) ) {
                alt20=1;
            }
            else if ( (LA20_0==ALL) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ./grammer/T34fpb.g:468:13: identifierRefList
                    {
                    pushFollow(FOLLOW_identifierRefList_in_importTemplateSpec2938);
                    identifierRefList14=identifierRefList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {

                              		helper.importTemplateSpecRule1(((Token)retval.start), moduleName, identifierRefList14, newImportList); 
                              	
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:471:17: ALL
                    {
                    match(input,ALL,FOLLOW_ALL_in_importTemplateSpec2958); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       helper.importTemplateSpecRule2(((Token)retval.start), moduleName, newImportList); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "importTemplateSpec"

    public static class importEnumSetSpec_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "importEnumSetSpec"
    // ./grammer/T34fpb.g:476:1: importEnumSetSpec[String moduleName, List<Object> newImportList] : ENUM_SET ( identifierRefList | ALL ) ;
    public final T34fpbParser.importEnumSetSpec_return importEnumSetSpec(String moduleName, List<Object> newImportList) throws RecognitionException {
        T34fpbParser.importEnumSetSpec_return retval = new T34fpbParser.importEnumSetSpec_return();
        retval.start = input.LT(1);

        List<String> identifierRefList15 = null;


        try {
            // ./grammer/T34fpb.g:477:2: ( ENUM_SET ( identifierRefList | ALL ) )
            // ./grammer/T34fpb.g:477:4: ENUM_SET ( identifierRefList | ALL )
            {
            match(input,ENUM_SET,FOLLOW_ENUM_SET_in_importEnumSetSpec2995); if (state.failed) return retval;
            // ./grammer/T34fpb.g:478:9: ( identifierRefList | ALL )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==IDENTIFIER) ) {
                alt21=1;
            }
            else if ( (LA21_0==ALL) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ./grammer/T34fpb.g:478:13: identifierRefList
                    {
                    pushFollow(FOLLOW_identifierRefList_in_importEnumSetSpec3009);
                    identifierRefList15=identifierRefList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       
                              		helper.importEnumSetSpecRule1(((Token)retval.start), moduleName, identifierRefList15, newImportList); 
                              	
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:481:17: ALL
                    {
                    match(input,ALL,FOLLOW_ALL_in_importEnumSetSpec3029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       helper.importEnumSetSpecRule2(((Token)retval.start), moduleName, newImportList); 
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "importEnumSetSpec"


    // $ANTLR start "identifierRefList"
    // ./grammer/T34fpb.g:485:1: identifierRefList returns [List<String> idList] : i1= identifier ( COMMA i2= identifier )* ;
    public final List<String> identifierRefList() throws RecognitionException {
        List<String> idList = null;

        T34fpbParser.identifier_return i1 = null;

        T34fpbParser.identifier_return i2 = null;



        	idList = new ArrayList<String>();

        try {
            // ./grammer/T34fpb.g:489:5: (i1= identifier ( COMMA i2= identifier )* )
            // ./grammer/T34fpb.g:489:9: i1= identifier ( COMMA i2= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_identifierRefList3071);
            i1=identifier();

            state._fsp--;
            if (state.failed) return idList;
            if ( state.backtracking==0 ) {
               idList.add((i1!=null?input.toString(i1.start,i1.stop):null)); 
            }
            // ./grammer/T34fpb.g:490:6: ( COMMA i2= identifier )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==COMMA) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ./grammer/T34fpb.g:490:8: COMMA i2= identifier
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_identifierRefList3082); if (state.failed) return idList;
            	    pushFollow(FOLLOW_identifier_in_identifierRefList3088);
            	    i2=identifier();

            	    state._fsp--;
            	    if (state.failed) return idList;
            	    if ( state.backtracking==0 ) {
            	       idList.add((i2!=null?input.toString(i2.start,i2.stop):null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return idList;
    }
    // $ANTLR end "identifierRefList"


    // $ANTLR start "constDef"
    // ./grammer/T34fpb.g:497:1: constDef returns [List<Object> newConstList] : CONST type constList ;
    public final List<Object> constDef() throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        List<Object> newConstList = null;

        T34fpbParser.type_return type16 = null;

        List<Object> constList17 = null;


        try {
            // ./grammer/T34fpb.g:499:5: ( CONST type constList )
            // ./grammer/T34fpb.g:499:9: CONST type constList
            {
            match(input,CONST,FOLLOW_CONST_in_constDef3129); if (state.failed) return newConstList;
            pushFollow(FOLLOW_type_in_constDef3131);
            type16=type();

            state._fsp--;
            if (state.failed) return newConstList;
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = (type16!=null?input.toString(type16.start,type16.stop):null); 
            }
            pushFollow(FOLLOW_constList_in_constDef3140);
            constList17=constList();

            state._fsp--;
            if (state.failed) return newConstList;
            if ( state.backtracking==0 ) {
               newConstList = constList17; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return newConstList;
    }
    // $ANTLR end "constDef"


    // $ANTLR start "constList"
    // ./grammer/T34fpb.g:503:1: constList returns [List<Object> newConstList] : c1= singleConstDef ( COMMA c2= singleConstDef )* ;
    public final List<Object> constList() throws RecognitionException {
        List<Object> newConstList = null;

        T34fpbParser.singleConstDef_return c1 = null;

        T34fpbParser.singleConstDef_return c2 = null;



        	newConstList = new ArrayList<Object>();

        try {
            // ./grammer/T34fpb.g:507:5: (c1= singleConstDef ( COMMA c2= singleConstDef )* )
            // ./grammer/T34fpb.g:507:9: c1= singleConstDef ( COMMA c2= singleConstDef )*
            {
            pushFollow(FOLLOW_singleConstDef_in_constList3178);
            c1=singleConstDef();

            state._fsp--;
            if (state.failed) return newConstList;
            if ( state.backtracking==0 ) {
               newConstList.add((c1!=null?c1.newConst:null)); 
            }
            // ./grammer/T34fpb.g:508:9: ( COMMA c2= singleConstDef )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==COMMA) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ./grammer/T34fpb.g:508:11: COMMA c2= singleConstDef
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_constList3192); if (state.failed) return newConstList;
            	    pushFollow(FOLLOW_singleConstDef_in_constList3198);
            	    c2=singleConstDef();

            	    state._fsp--;
            	    if (state.failed) return newConstList;
            	    if ( state.backtracking==0 ) {
            	       newConstList.add((c2!=null?c2.newConst:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newConstList;
    }
    // $ANTLR end "constList"

    public static class singleConstDef_return extends ParserRuleReturnScope {
        public Object newConst;
    };

    // $ANTLR start "singleConstDef"
    // ./grammer/T34fpb.g:512:1: singleConstDef returns [Object newConst] : constIdentifer ASSIGNMENT_CHAR constExpression ;
    public final T34fpbParser.singleConstDef_return singleConstDef() throws RecognitionException {
        T34fpbParser.singleConstDef_return retval = new T34fpbParser.singleConstDef_return();
        retval.start = input.LT(1);

        T34fpbParser.constIdentifer_return constIdentifer18 = null;

        PMatcher constExpression19 = null;


        try {
            // ./grammer/T34fpb.g:513:5: ( constIdentifer ASSIGNMENT_CHAR constExpression )
            // ./grammer/T34fpb.g:513:9: constIdentifer ASSIGNMENT_CHAR constExpression
            {
            pushFollow(FOLLOW_constIdentifer_in_singleConstDef3238);
            constIdentifer18=constIdentifer();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               
                  		retval.newConst = helper.singleConstDefRule1(((Token)retval.start), ((TypeScope_scope)TypeScope_stack.peek()).typeName, (constIdentifer18!=null?input.toString(constIdentifer18.start,constIdentifer18.stop):null));
                  	
            }
            match(input,ASSIGNMENT_CHAR,FOLLOW_ASSIGNMENT_CHAR_in_singleConstDef3247); if (state.failed) return retval;
            pushFollow(FOLLOW_constExpression_in_singleConstDef3249);
            constExpression19=constExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

                  		helper.singleConstDefRule2(((Token)retval.start), constExpression19, retval.newConst);
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "singleConstDef"

    public static class constIdentifer_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "constIdentifer"
    // ./grammer/T34fpb.g:521:1: constIdentifer : identifier ;
    public final T34fpbParser.constIdentifer_return constIdentifer() throws RecognitionException {
        T34fpbParser.constIdentifer_return retval = new T34fpbParser.constIdentifer_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:522:5: ( identifier )
            // ./grammer/T34fpb.g:522:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_constIdentifer3270);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constIdentifer"


    // $ANTLR start "modulePar"
    // ./grammer/T34fpb.g:529:1: modulePar[boolean isThread] returns [List<Object> newMparList] : type moduleParList[isThread] ;
    public final List<Object> modulePar(boolean isThread) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        List<Object> newMparList = null;

        T34fpbParser.type_return type20 = null;

        List<Object> moduleParList21 = null;


        try {
            // ./grammer/T34fpb.g:531:5: ( type moduleParList[isThread] )
            // ./grammer/T34fpb.g:531:9: type moduleParList[isThread]
            {
            pushFollow(FOLLOW_type_in_modulePar3304);
            type20=type();

            state._fsp--;
            if (state.failed) return newMparList;
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = (type20!=null?input.toString(type20.start,type20.stop):null); 
            }
            pushFollow(FOLLOW_moduleParList_in_modulePar3313);
            moduleParList21=moduleParList(isThread);

            state._fsp--;
            if (state.failed) return newMparList;
            if ( state.backtracking==0 ) {
               newMparList = moduleParList21; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return newMparList;
    }
    // $ANTLR end "modulePar"


    // $ANTLR start "moduleParDef"
    // ./grammer/T34fpb.g:534:1: moduleParDef returns [List<Object> newMparList] : ( THREAD )? MODULE_PAR ( modulePar[ ($THREAD != null) ] | '{' multitypedModuleParList[ ($THREAD != null) ] '}' ) ;
    public final List<Object> moduleParDef() throws RecognitionException {
        List<Object> newMparList = null;

        Token THREAD22=null;
        List<Object> modulePar23 = null;

        List<Object> multitypedModuleParList24 = null;


        try {
            // ./grammer/T34fpb.g:535:5: ( ( THREAD )? MODULE_PAR ( modulePar[ ($THREAD != null) ] | '{' multitypedModuleParList[ ($THREAD != null) ] '}' ) )
            // ./grammer/T34fpb.g:535:9: ( THREAD )? MODULE_PAR ( modulePar[ ($THREAD != null) ] | '{' multitypedModuleParList[ ($THREAD != null) ] '}' )
            {
            // ./grammer/T34fpb.g:535:9: ( THREAD )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==THREAD) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ./grammer/T34fpb.g:535:11: THREAD
                    {
                    THREAD22=(Token)match(input,THREAD,FOLLOW_THREAD_in_moduleParDef3341); if (state.failed) return newMparList;

                    }
                    break;

            }

            match(input,MODULE_PAR,FOLLOW_MODULE_PAR_in_moduleParDef3351); if (state.failed) return newMparList;
            // ./grammer/T34fpb.g:537:6: ( modulePar[ ($THREAD != null) ] | '{' multitypedModuleParList[ ($THREAD != null) ] '}' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=BIT_STRING && LA25_0<=UNIVERSAL)||LA25_0==IDENTIFIER) ) {
                alt25=1;
            }
            else if ( (LA25_0==99) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return newMparList;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ./grammer/T34fpb.g:537:8: modulePar[ ($THREAD != null) ]
                    {
                    pushFollow(FOLLOW_modulePar_in_moduleParDef3361);
                    modulePar23=modulePar((THREAD22 != null));

                    state._fsp--;
                    if (state.failed) return newMparList;
                    if ( state.backtracking==0 ) {
                       newMparList = modulePar23; 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:538:13: '{' multitypedModuleParList[ ($THREAD != null) ] '}'
                    {
                    match(input,99,FOLLOW_99_in_moduleParDef3379); if (state.failed) return newMparList;
                    pushFollow(FOLLOW_multitypedModuleParList_in_moduleParDef3381);
                    multitypedModuleParList24=multitypedModuleParList((THREAD22 != null));

                    state._fsp--;
                    if (state.failed) return newMparList;
                    if ( state.backtracking==0 ) {
                       
                              			newMparList = multitypedModuleParList24; 
                              		
                    }
                    match(input,100,FOLLOW_100_in_moduleParDef3396); if (state.failed) return newMparList;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newMparList;
    }
    // $ANTLR end "moduleParDef"


    // $ANTLR start "moduleParList"
    // ./grammer/T34fpb.g:546:1: moduleParList[boolean isThread] returns [List<Object> newMparList] : m1= singleModuleParDef[isThread] ( COMMA m2= singleModuleParDef[isThread] )* ;
    public final List<Object> moduleParList(boolean isThread) throws RecognitionException {
        List<Object> newMparList = null;

        T34fpbParser.singleModuleParDef_return m1 = null;

        T34fpbParser.singleModuleParDef_return m2 = null;



        	newMparList = new ArrayList<Object>();

        try {
            // ./grammer/T34fpb.g:550:5: (m1= singleModuleParDef[isThread] ( COMMA m2= singleModuleParDef[isThread] )* )
            // ./grammer/T34fpb.g:550:9: m1= singleModuleParDef[isThread] ( COMMA m2= singleModuleParDef[isThread] )*
            {
            pushFollow(FOLLOW_singleModuleParDef_in_moduleParList3449);
            m1=singleModuleParDef(isThread);

            state._fsp--;
            if (state.failed) return newMparList;
            if ( state.backtracking==0 ) {
               newMparList.add((m1!=null?m1.newMpar:null)); 
            }
            // ./grammer/T34fpb.g:551:9: ( COMMA m2= singleModuleParDef[isThread] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==COMMA) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ./grammer/T34fpb.g:551:12: COMMA m2= singleModuleParDef[isThread]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_moduleParList3466); if (state.failed) return newMparList;
            	    pushFollow(FOLLOW_singleModuleParDef_in_moduleParList3472);
            	    m2=singleModuleParDef(isThread);

            	    state._fsp--;
            	    if (state.failed) return newMparList;
            	    if ( state.backtracking==0 ) {
            	       newMparList.add((m2!=null?m2.newMpar:null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newMparList;
    }
    // $ANTLR end "moduleParList"

    public static class singleModuleParDef_return extends ParserRuleReturnScope {
        public Object newMpar;
    };

    // $ANTLR start "singleModuleParDef"
    // ./grammer/T34fpb.g:555:1: singleModuleParDef[boolean isThread] returns [Object newMpar] : moduleParIdentifier ( ASSIGNMENT_CHAR constExpression )? ;
    public final T34fpbParser.singleModuleParDef_return singleModuleParDef(boolean isThread) throws RecognitionException {
        T34fpbParser.singleModuleParDef_return retval = new T34fpbParser.singleModuleParDef_return();
        retval.start = input.LT(1);

        T34fpbParser.moduleParIdentifier_return moduleParIdentifier25 = null;

        PMatcher constExpression26 = null;


        try {
            // ./grammer/T34fpb.g:556:2: ( moduleParIdentifier ( ASSIGNMENT_CHAR constExpression )? )
            // ./grammer/T34fpb.g:556:4: moduleParIdentifier ( ASSIGNMENT_CHAR constExpression )?
            {
            pushFollow(FOLLOW_moduleParIdentifier_in_singleModuleParDef3511);
            moduleParIdentifier25=moduleParIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

                  		retval.newMpar = helper.singleModuleParDefRule1(((Token)retval.start), isThread, ((TypeScope_scope)TypeScope_stack.peek()).typeName, 
                  			(moduleParIdentifier25!=null?input.toString(moduleParIdentifier25.start,moduleParIdentifier25.stop):null));
              			
              		
            }
            // ./grammer/T34fpb.g:561:3: ( ASSIGNMENT_CHAR constExpression )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ASSIGNMENT_CHAR) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ./grammer/T34fpb.g:561:5: ASSIGNMENT_CHAR constExpression
                    {
                    match(input,ASSIGNMENT_CHAR,FOLLOW_ASSIGNMENT_CHAR_in_singleModuleParDef3519); if (state.failed) return retval;
                    pushFollow(FOLLOW_constExpression_in_singleModuleParDef3521);
                    constExpression26=constExpression();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                  		helper.singleModuleParDefRule2(((Token)retval.start), constExpression26, retval.newMpar);
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "singleModuleParDef"

    public static class moduleParIdentifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "moduleParIdentifier"
    // ./grammer/T34fpb.g:567:1: moduleParIdentifier : identifier ;
    public final T34fpbParser.moduleParIdentifier_return moduleParIdentifier() throws RecognitionException {
        T34fpbParser.moduleParIdentifier_return retval = new T34fpbParser.moduleParIdentifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:568:5: ( identifier )
            // ./grammer/T34fpb.g:568:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_moduleParIdentifier3548);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "moduleParIdentifier"


    // $ANTLR start "multitypedModuleParList"
    // ./grammer/T34fpb.g:571:1: multitypedModuleParList[boolean isThread] returns [List<Object> newMparList] : ( modulePar[isThread] ( SEMI_COLON )? )* ;
    public final List<Object> multitypedModuleParList(boolean isThread) throws RecognitionException {
        List<Object> newMparList = null;

        List<Object> modulePar27 = null;



        	newMparList = new ArrayList<Object>();

        try {
            // ./grammer/T34fpb.g:575:5: ( ( modulePar[isThread] ( SEMI_COLON )? )* )
            // ./grammer/T34fpb.g:575:9: ( modulePar[isThread] ( SEMI_COLON )? )*
            {
            // ./grammer/T34fpb.g:575:9: ( modulePar[isThread] ( SEMI_COLON )? )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=BIT_STRING && LA29_0<=UNIVERSAL)||LA29_0==IDENTIFIER) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ./grammer/T34fpb.g:575:12: modulePar[isThread] ( SEMI_COLON )?
            	    {
            	    pushFollow(FOLLOW_modulePar_in_multitypedModuleParList3588);
            	    modulePar27=modulePar(isThread);

            	    state._fsp--;
            	    if (state.failed) return newMparList;
            	    // ./grammer/T34fpb.g:575:33: ( SEMI_COLON )?
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==SEMI_COLON) ) {
            	        alt28=1;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // ./grammer/T34fpb.g:575:35: SEMI_COLON
            	            {
            	            match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_multitypedModuleParList3594); if (state.failed) return newMparList;

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	       newMparList.addAll(modulePar27); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newMparList;
    }
    // $ANTLR end "multitypedModuleParList"


    // $ANTLR start "typeDef"
    // ./grammer/T34fpb.g:582:1: typeDef returns [Object newType] : TYPE typeDefBody ;
    public final Object typeDef() throws RecognitionException {
        Object newType = null;

        Object typeDefBody28 = null;


        try {
            // ./grammer/T34fpb.g:583:5: ( TYPE typeDefBody )
            // ./grammer/T34fpb.g:583:9: TYPE typeDefBody
            {
            match(input,TYPE,FOLLOW_TYPE_in_typeDef3633); if (state.failed) return newType;
            pushFollow(FOLLOW_typeDefBody_in_typeDef3635);
            typeDefBody28=typeDefBody();

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {
               newType = typeDefBody28; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "typeDef"


    // $ANTLR start "typeDefBody"
    // ./grammer/T34fpb.g:586:1: typeDefBody returns [Object newType] : ( structuredTypeDef | subTypeDef );
    public final Object typeDefBody() throws RecognitionException {
        Object newType = null;

        Object structuredTypeDef29 = null;

        Object subTypeDef30 = null;


        try {
            // ./grammer/T34fpb.g:587:5: ( structuredTypeDef | subTypeDef )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RECORD && LA30_0<=ENUMERATED)) ) {
                alt30=1;
            }
            else if ( ((LA30_0>=BIT_STRING && LA30_0<=UNIVERSAL)||LA30_0==IDENTIFIER) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return newType;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ./grammer/T34fpb.g:587:9: structuredTypeDef
                    {
                    pushFollow(FOLLOW_structuredTypeDef_in_typeDefBody3664);
                    structuredTypeDef29=structuredTypeDef();

                    state._fsp--;
                    if (state.failed) return newType;
                    if ( state.backtracking==0 ) {
                       newType = structuredTypeDef29; 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:588:13: subTypeDef
                    {
                    pushFollow(FOLLOW_subTypeDef_in_typeDefBody3680);
                    subTypeDef30=subTypeDef();

                    state._fsp--;
                    if (state.failed) return newType;
                    if ( state.backtracking==0 ) {
                       newType = subTypeDef30; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "typeDefBody"


    // $ANTLR start "structuredTypeDef"
    // ./grammer/T34fpb.g:591:1: structuredTypeDef returns [Object newType] : ( recordDef | unionDef | setDef | recordOfDef | setOfDef | enumDef );
    public final Object structuredTypeDef() throws RecognitionException {
        Object newType = null;

        ContainerTypeSymbol recordDef31 = null;

        ContainerTypeSymbol unionDef32 = null;

        ContainerTypeSymbol setDef33 = null;

        ListTypeSymbol recordOfDef34 = null;

        ListTypeSymbol setOfDef35 = null;

        EnumeratedTypeSymbol enumDef36 = null;


        try {
            // ./grammer/T34fpb.g:592:5: ( recordDef | unionDef | setDef | recordOfDef | setOfDef | enumDef )
            int alt31=6;
            switch ( input.LA(1) ) {
            case RECORD:
                {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==IDENTIFIER) ) {
                    alt31=1;
                }
                else if ( (LA31_1==LENGTH||LA31_1==OF) ) {
                    alt31=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return newType;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
                }
                break;
            case UNION:
                {
                alt31=2;
                }
                break;
            case SET:
                {
                int LA31_3 = input.LA(2);

                if ( (LA31_3==IDENTIFIER) ) {
                    alt31=3;
                }
                else if ( (LA31_3==LENGTH||LA31_3==OF) ) {
                    alt31=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return newType;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 3, input);

                    throw nvae;
                }
                }
                break;
            case ENUMERATED:
                {
                alt31=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return newType;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ./grammer/T34fpb.g:592:9: recordDef
                    {
                    pushFollow(FOLLOW_recordDef_in_structuredTypeDef3709);
                    recordDef31=recordDef();

                    state._fsp--;
                    if (state.failed) return newType;
                    if ( state.backtracking==0 ) {
                       newType = recordDef31; 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:593:13: unionDef
                    {
                    pushFollow(FOLLOW_unionDef_in_structuredTypeDef3727);
                    unionDef32=unionDef();

                    state._fsp--;
                    if (state.failed) return newType;
                    if ( state.backtracking==0 ) {
                       newType = unionDef32; 
                    }

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:594:13: setDef
                    {
                    pushFollow(FOLLOW_setDef_in_structuredTypeDef3744);
                    setDef33=setDef();

                    state._fsp--;
                    if (state.failed) return newType;
                    if ( state.backtracking==0 ) {
                       newType = setDef33; 
                    }

                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:595:13: recordOfDef
                    {
                    pushFollow(FOLLOW_recordOfDef_in_structuredTypeDef3762);
                    recordOfDef34=recordOfDef();

                    state._fsp--;
                    if (state.failed) return newType;
                    if ( state.backtracking==0 ) {
                       newType = recordOfDef34; 
                    }

                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:596:13: setOfDef
                    {
                    pushFollow(FOLLOW_setOfDef_in_structuredTypeDef3778);
                    setOfDef35=setOfDef();

                    state._fsp--;
                    if (state.failed) return newType;
                    if ( state.backtracking==0 ) {
                       newType = setOfDef35; 
                    }

                    }
                    break;
                case 6 :
                    // ./grammer/T34fpb.g:597:13: enumDef
                    {
                    pushFollow(FOLLOW_enumDef_in_structuredTypeDef3794);
                    enumDef36=enumDef();

                    state._fsp--;
                    if (state.failed) return newType;
                    if ( state.backtracking==0 ) {
                       newType = enumDef36; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "structuredTypeDef"


    // $ANTLR start "recordDef"
    // ./grammer/T34fpb.g:600:1: recordDef returns [ContainerTypeSymbol newType] : RECORD structDefBody[TypeClass.RECORD] ;
    public final ContainerTypeSymbol recordDef() throws RecognitionException {
        ContainerTypeSymbol newType = null;

        ContainerTypeSymbol structDefBody37 = null;


        try {
            // ./grammer/T34fpb.g:601:5: ( RECORD structDefBody[TypeClass.RECORD] )
            // ./grammer/T34fpb.g:601:9: RECORD structDefBody[TypeClass.RECORD]
            {
            match(input,RECORD,FOLLOW_RECORD_in_recordDef3824); if (state.failed) return newType;
            pushFollow(FOLLOW_structDefBody_in_recordDef3826);
            structDefBody37=structDefBody(TypeClass.RECORD);

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {
               newType = structDefBody37; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "recordDef"


    // $ANTLR start "structDefBody"
    // ./grammer/T34fpb.g:604:1: structDefBody[TypeClass typeClass] returns [ContainerTypeSymbol newType] : structTypeIdentifier '{' ( structFieldDef[$newType] ( COMMA structFieldDef[$newType] )* )? '}' ;
    public final ContainerTypeSymbol structDefBody(TypeClass typeClass) throws RecognitionException {
        ContainerTypeSymbol newType = null;

        T34fpbParser.structTypeIdentifier_return structTypeIdentifier38 = null;


        try {
            // ./grammer/T34fpb.g:605:5: ( structTypeIdentifier '{' ( structFieldDef[$newType] ( COMMA structFieldDef[$newType] )* )? '}' )
            // ./grammer/T34fpb.g:605:9: structTypeIdentifier '{' ( structFieldDef[$newType] ( COMMA structFieldDef[$newType] )* )? '}'
            {
            pushFollow(FOLLOW_structTypeIdentifier_in_structDefBody3858);
            structTypeIdentifier38=structTypeIdentifier();

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {

                  			newType = helper.structDefBodyRule((structTypeIdentifier38!=null?((Token)structTypeIdentifier38.start):null), typeClass, (structTypeIdentifier38!=null?input.toString(structTypeIdentifier38.start,structTypeIdentifier38.stop):null));
                  		
            }
            match(input,99,FOLLOW_99_in_structDefBody3867); if (state.failed) return newType;
            // ./grammer/T34fpb.g:609:9: ( structFieldDef[$newType] ( COMMA structFieldDef[$newType] )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=BIT_STRING && LA33_0<=UNIVERSAL)||LA33_0==IDENTIFIER) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ./grammer/T34fpb.g:609:13: structFieldDef[$newType] ( COMMA structFieldDef[$newType] )*
                    {
                    pushFollow(FOLLOW_structFieldDef_in_structDefBody3882);
                    structFieldDef(newType);

                    state._fsp--;
                    if (state.failed) return newType;
                    // ./grammer/T34fpb.g:609:38: ( COMMA structFieldDef[$newType] )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==COMMA) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ./grammer/T34fpb.g:609:40: COMMA structFieldDef[$newType]
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_structDefBody3887); if (state.failed) return newType;
                    	    pushFollow(FOLLOW_structFieldDef_in_structDefBody3889);
                    	    structFieldDef(newType);

                    	    state._fsp--;
                    	    if (state.failed) return newType;

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,100,FOLLOW_100_in_structDefBody3915); if (state.failed) return newType;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "structDefBody"

    public static class structTypeIdentifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "structTypeIdentifier"
    // ./grammer/T34fpb.g:614:1: structTypeIdentifier : identifier ;
    public final T34fpbParser.structTypeIdentifier_return structTypeIdentifier() throws RecognitionException {
        T34fpbParser.structTypeIdentifier_return retval = new T34fpbParser.structTypeIdentifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:615:5: ( identifier )
            // ./grammer/T34fpb.g:615:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_structTypeIdentifier3935);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "structTypeIdentifier"


    // $ANTLR start "structFieldDef"
    // ./grammer/T34fpb.g:618:1: structFieldDef[Object ownerType] : type structFieldIdentifier ( subTypeSpec )? ( OPTIONAL )? ;
    public final void structFieldDef(Object ownerType) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        T34fpbParser.type_return type39 = null;

        T34fpbParser.structFieldIdentifier_return structFieldIdentifier40 = null;

        T34fpbParser.subTypeSpec_return subTypeSpec41 = null;



        boolean optional = false;

        try {
            // ./grammer/T34fpb.g:623:5: ( type structFieldIdentifier ( subTypeSpec )? ( OPTIONAL )? )
            // ./grammer/T34fpb.g:623:9: type structFieldIdentifier ( subTypeSpec )? ( OPTIONAL )?
            {
            pushFollow(FOLLOW_type_in_structFieldDef3969);
            type39=type();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = (type39!=null?input.toString(type39.start,type39.stop):null); 
            }
            pushFollow(FOLLOW_structFieldIdentifier_in_structFieldDef3978);
            structFieldIdentifier40=structFieldIdentifier();

            state._fsp--;
            if (state.failed) return ;
            // ./grammer/T34fpb.g:625:9: ( subTypeSpec )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==LENGTH||LA34_0==101) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ./grammer/T34fpb.g:625:11: subTypeSpec
                    {
                    pushFollow(FOLLOW_subTypeSpec_in_structFieldDef3990);
                    subTypeSpec41=subTypeSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            // ./grammer/T34fpb.g:626:9: ( OPTIONAL )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==OPTIONAL) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ./grammer/T34fpb.g:626:11: OPTIONAL
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_structFieldDef4006); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       optional = true; 
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
                      	helper.structFieldDefRule((type39!=null?((Token)type39.start):null), ownerType, (type39!=null?input.toString(type39.start,type39.stop):null), (structFieldIdentifier40!=null?input.toString(structFieldIdentifier40.start,structFieldIdentifier40.stop):null), 
                      		optional, (subTypeSpec41!=null?subTypeSpec41.typeCons:null)); 
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return ;
    }
    // $ANTLR end "structFieldDef"


    // $ANTLR start "unionDef"
    // ./grammer/T34fpb.g:633:1: unionDef returns [ContainerTypeSymbol newType] : UNION unionDefBody ;
    public final ContainerTypeSymbol unionDef() throws RecognitionException {
        ContainerTypeSymbol newType = null;

        ContainerTypeSymbol unionDefBody42 = null;


        try {
            // ./grammer/T34fpb.g:634:5: ( UNION unionDefBody )
            // ./grammer/T34fpb.g:634:9: UNION unionDefBody
            {
            match(input,UNION,FOLLOW_UNION_in_unionDef4052); if (state.failed) return newType;
            pushFollow(FOLLOW_unionDefBody_in_unionDef4054);
            unionDefBody42=unionDefBody();

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {
               newType = unionDefBody42; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "unionDef"


    // $ANTLR start "unionDefBody"
    // ./grammer/T34fpb.g:637:1: unionDefBody returns [ContainerTypeSymbol newType] : structTypeIdentifier '{' ( unionFieldDef[ $newType ] ( COMMA unionFieldDef[ $newType ] )* )? '}' ;
    public final ContainerTypeSymbol unionDefBody() throws RecognitionException {
        ContainerTypeSymbol newType = null;

        T34fpbParser.structTypeIdentifier_return structTypeIdentifier43 = null;


        try {
            // ./grammer/T34fpb.g:638:5: ( structTypeIdentifier '{' ( unionFieldDef[ $newType ] ( COMMA unionFieldDef[ $newType ] )* )? '}' )
            // ./grammer/T34fpb.g:638:9: structTypeIdentifier '{' ( unionFieldDef[ $newType ] ( COMMA unionFieldDef[ $newType ] )* )? '}'
            {
            pushFollow(FOLLOW_structTypeIdentifier_in_unionDefBody4083);
            structTypeIdentifier43=structTypeIdentifier();

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {

                  			newType = helper.unionDefBodyRule((structTypeIdentifier43!=null?((Token)structTypeIdentifier43.start):null), (structTypeIdentifier43!=null?input.toString(structTypeIdentifier43.start,structTypeIdentifier43.stop):null));
                  		
            }
            match(input,99,FOLLOW_99_in_unionDefBody4092); if (state.failed) return newType;
            // ./grammer/T34fpb.g:642:9: ( unionFieldDef[ $newType ] ( COMMA unionFieldDef[ $newType ] )* )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=BIT_STRING && LA37_0<=UNIVERSAL)||LA37_0==IDENTIFIER) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ./grammer/T34fpb.g:642:13: unionFieldDef[ $newType ] ( COMMA unionFieldDef[ $newType ] )*
                    {
                    pushFollow(FOLLOW_unionFieldDef_in_unionDefBody4106);
                    unionFieldDef(newType);

                    state._fsp--;
                    if (state.failed) return newType;
                    // ./grammer/T34fpb.g:642:39: ( COMMA unionFieldDef[ $newType ] )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==COMMA) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ./grammer/T34fpb.g:642:41: COMMA unionFieldDef[ $newType ]
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_unionDefBody4111); if (state.failed) return newType;
                    	    pushFollow(FOLLOW_unionFieldDef_in_unionDefBody4113);
                    	    unionFieldDef(newType);

                    	    state._fsp--;
                    	    if (state.failed) return newType;

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,100,FOLLOW_100_in_unionDefBody4138); if (state.failed) return newType;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "unionDefBody"


    // $ANTLR start "unionFieldDef"
    // ./grammer/T34fpb.g:647:1: unionFieldDef[Object ownerType] : type structFieldIdentifier ( subTypeSpec )? ;
    public final void unionFieldDef(Object ownerType) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        T34fpbParser.type_return type44 = null;

        T34fpbParser.structFieldIdentifier_return structFieldIdentifier45 = null;

        T34fpbParser.subTypeSpec_return subTypeSpec46 = null;


        try {
            // ./grammer/T34fpb.g:649:5: ( type structFieldIdentifier ( subTypeSpec )? )
            // ./grammer/T34fpb.g:649:9: type structFieldIdentifier ( subTypeSpec )?
            {
            pushFollow(FOLLOW_type_in_unionFieldDef4168);
            type44=type();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = (type44!=null?input.toString(type44.start,type44.stop):null); 
            }
            pushFollow(FOLLOW_structFieldIdentifier_in_unionFieldDef4177);
            structFieldIdentifier45=structFieldIdentifier();

            state._fsp--;
            if (state.failed) return ;
            // ./grammer/T34fpb.g:651:9: ( subTypeSpec )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==LENGTH||LA38_0==101) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ./grammer/T34fpb.g:651:11: subTypeSpec
                    {
                    pushFollow(FOLLOW_subTypeSpec_in_unionFieldDef4189);
                    subTypeSpec46=subTypeSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
                      	helper.unionFieldDefRule((type44!=null?((Token)type44.start):null), ownerType, (type44!=null?input.toString(type44.start,type44.stop):null), (structFieldIdentifier45!=null?input.toString(structFieldIdentifier45.start,structFieldIdentifier45.stop):null), 
                      		(subTypeSpec46!=null?subTypeSpec46.typeCons:null)); 
                      
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return ;
    }
    // $ANTLR end "unionFieldDef"


    // $ANTLR start "setDef"
    // ./grammer/T34fpb.g:658:1: setDef returns [ContainerTypeSymbol newType] : SET structDefBody[TypeClass.SET] ;
    public final ContainerTypeSymbol setDef() throws RecognitionException {
        ContainerTypeSymbol newType = null;

        ContainerTypeSymbol structDefBody47 = null;


        try {
            // ./grammer/T34fpb.g:659:5: ( SET structDefBody[TypeClass.SET] )
            // ./grammer/T34fpb.g:659:9: SET structDefBody[TypeClass.SET]
            {
            match(input,SET,FOLLOW_SET_in_setDef4230); if (state.failed) return newType;
            pushFollow(FOLLOW_structDefBody_in_setDef4232);
            structDefBody47=structDefBody(TypeClass.SET);

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {
               newType = structDefBody47; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "setDef"


    // $ANTLR start "recordOfDef"
    // ./grammer/T34fpb.g:662:1: recordOfDef returns [ListTypeSymbol newType] : RECORD ( stringLength )? OF structOfDefBody[ TypeClass.RECORDOF, $stringLength.typeCons ] ;
    public final ListTypeSymbol recordOfDef() throws RecognitionException {
        ListTypeSymbol newType = null;

        PTypeConstraint stringLength48 = null;

        ListTypeSymbol structOfDefBody49 = null;


        try {
            // ./grammer/T34fpb.g:663:5: ( RECORD ( stringLength )? OF structOfDefBody[ TypeClass.RECORDOF, $stringLength.typeCons ] )
            // ./grammer/T34fpb.g:663:9: RECORD ( stringLength )? OF structOfDefBody[ TypeClass.RECORDOF, $stringLength.typeCons ]
            {
            match(input,RECORD,FOLLOW_RECORD_in_recordOfDef4263); if (state.failed) return newType;
            // ./grammer/T34fpb.g:664:6: ( stringLength )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==LENGTH) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ./grammer/T34fpb.g:664:8: stringLength
                    {
                    pushFollow(FOLLOW_stringLength_in_recordOfDef4273);
                    stringLength48=stringLength();

                    state._fsp--;
                    if (state.failed) return newType;

                    }
                    break;

            }

            match(input,OF,FOLLOW_OF_in_recordOfDef4287); if (state.failed) return newType;
            pushFollow(FOLLOW_structOfDefBody_in_recordOfDef4289);
            structOfDefBody49=structOfDefBody(TypeClass.RECORDOF, stringLength48);

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {
               newType = structOfDefBody49; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "recordOfDef"


    // $ANTLR start "structOfDefBody"
    // ./grammer/T34fpb.g:668:1: structOfDefBody[TypeClass typeClass, PTypeConstraint lenCons] returns [ListTypeSymbol newType] : type structTypeIdentifier ( subTypeSpec )? ;
    public final ListTypeSymbol structOfDefBody(TypeClass typeClass, PTypeConstraint lenCons) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        ListTypeSymbol newType = null;

        T34fpbParser.type_return type50 = null;

        T34fpbParser.structTypeIdentifier_return structTypeIdentifier51 = null;

        T34fpbParser.subTypeSpec_return subTypeSpec52 = null;


        try {
            // ./grammer/T34fpb.g:670:5: ( type structTypeIdentifier ( subTypeSpec )? )
            // ./grammer/T34fpb.g:670:9: type structTypeIdentifier ( subTypeSpec )?
            {
            pushFollow(FOLLOW_type_in_structOfDefBody4327);
            type50=type();

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = (type50!=null?input.toString(type50.start,type50.stop):null); 
            }
            pushFollow(FOLLOW_structTypeIdentifier_in_structOfDefBody4336);
            structTypeIdentifier51=structTypeIdentifier();

            state._fsp--;
            if (state.failed) return newType;
            // ./grammer/T34fpb.g:672:6: ( subTypeSpec )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==LENGTH||LA40_0==101) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ./grammer/T34fpb.g:672:8: subTypeSpec
                    {
                    pushFollow(FOLLOW_subTypeSpec_in_structOfDefBody4346);
                    subTypeSpec52=subTypeSpec();

                    state._fsp--;
                    if (state.failed) return newType;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                  		newType = helper.structOfDefBodyRule((type50!=null?((Token)type50.start):null), typeClass, (structTypeIdentifier51!=null?input.toString(structTypeIdentifier51.start,structTypeIdentifier51.stop):null), 
                  			(type50!=null?input.toString(type50.start,type50.stop):null), lenCons, (subTypeSpec52!=null?subTypeSpec52.typeCons:null));
                  	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return newType;
    }
    // $ANTLR end "structOfDefBody"


    // $ANTLR start "setOfDef"
    // ./grammer/T34fpb.g:679:1: setOfDef returns [ListTypeSymbol newType] : SET ( stringLength )? OF structOfDefBody[ TypeClass.SETOF, $stringLength.typeCons ] ;
    public final ListTypeSymbol setOfDef() throws RecognitionException {
        ListTypeSymbol newType = null;

        PTypeConstraint stringLength53 = null;

        ListTypeSymbol structOfDefBody54 = null;


        try {
            // ./grammer/T34fpb.g:680:5: ( SET ( stringLength )? OF structOfDefBody[ TypeClass.SETOF, $stringLength.typeCons ] )
            // ./grammer/T34fpb.g:680:9: SET ( stringLength )? OF structOfDefBody[ TypeClass.SETOF, $stringLength.typeCons ]
            {
            match(input,SET,FOLLOW_SET_in_setOfDef4384); if (state.failed) return newType;
            // ./grammer/T34fpb.g:680:13: ( stringLength )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==LENGTH) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ./grammer/T34fpb.g:680:15: stringLength
                    {
                    pushFollow(FOLLOW_stringLength_in_setOfDef4388);
                    stringLength53=stringLength();

                    state._fsp--;
                    if (state.failed) return newType;

                    }
                    break;

            }

            match(input,OF,FOLLOW_OF_in_setOfDef4401); if (state.failed) return newType;
            pushFollow(FOLLOW_structOfDefBody_in_setOfDef4403);
            structOfDefBody54=structOfDefBody(TypeClass.SETOF, stringLength53);

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {
               newType = structOfDefBody54; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "setOfDef"


    // $ANTLR start "enumDef"
    // ./grammer/T34fpb.g:684:1: enumDef returns [EnumeratedTypeSymbol newType] : ENUMERATED enumTypeIdentifier '{' enumerationList[newType] '}' ;
    public final EnumeratedTypeSymbol enumDef() throws RecognitionException {
        EnumeratedTypeSymbol newType = null;

        Token ENUMERATED55=null;
        T34fpbParser.enumTypeIdentifier_return enumTypeIdentifier56 = null;


        try {
            // ./grammer/T34fpb.g:685:5: ( ENUMERATED enumTypeIdentifier '{' enumerationList[newType] '}' )
            // ./grammer/T34fpb.g:685:9: ENUMERATED enumTypeIdentifier '{' enumerationList[newType] '}'
            {
            ENUMERATED55=(Token)match(input,ENUMERATED,FOLLOW_ENUMERATED_in_enumDef4434); if (state.failed) return newType;
            pushFollow(FOLLOW_enumTypeIdentifier_in_enumDef4442);
            enumTypeIdentifier56=enumTypeIdentifier();

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {

                  			newType = helper.enumDefBodyRule(ENUMERATED55, (enumTypeIdentifier56!=null?input.toString(enumTypeIdentifier56.start,enumTypeIdentifier56.stop):null));
                  	
            }
            match(input,99,FOLLOW_99_in_enumDef4451); if (state.failed) return newType;
            pushFollow(FOLLOW_enumerationList_in_enumDef4453);
            enumerationList(newType);

            state._fsp--;
            if (state.failed) return newType;
            match(input,100,FOLLOW_100_in_enumDef4457); if (state.failed) return newType;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return newType;
    }
    // $ANTLR end "enumDef"

    public static class enumTypeIdentifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "enumTypeIdentifier"
    // ./grammer/T34fpb.g:692:1: enumTypeIdentifier : identifier ;
    public final T34fpbParser.enumTypeIdentifier_return enumTypeIdentifier() throws RecognitionException {
        T34fpbParser.enumTypeIdentifier_return retval = new T34fpbParser.enumTypeIdentifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:693:5: ( identifier )
            // ./grammer/T34fpb.g:693:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_enumTypeIdentifier4480);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumTypeIdentifier"


    // $ANTLR start "enumerationList"
    // ./grammer/T34fpb.g:696:1: enumerationList[EnumeratedTypeSymbol newType] : enumeration[newType] ( COMMA enumeration[newType] )* ;
    public final void enumerationList(EnumeratedTypeSymbol newType) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:697:5: ( enumeration[newType] ( COMMA enumeration[newType] )* )
            // ./grammer/T34fpb.g:697:9: enumeration[newType] ( COMMA enumeration[newType] )*
            {
            pushFollow(FOLLOW_enumeration_in_enumerationList4505);
            enumeration(newType);

            state._fsp--;
            if (state.failed) return ;
            // ./grammer/T34fpb.g:697:31: ( COMMA enumeration[newType] )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==COMMA) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ./grammer/T34fpb.g:697:33: COMMA enumeration[newType]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_enumerationList4511); if (state.failed) return ;
            	    pushFollow(FOLLOW_enumeration_in_enumerationList4513);
            	    enumeration(newType);

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "enumerationList"

    public static class enumeration_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "enumeration"
    // ./grammer/T34fpb.g:700:1: enumeration[EnumeratedTypeSymbol newType] : enumerationIdentifier ( '(' ( MINUS )? INTEGER_VALUE ')' )? ;
    public final T34fpbParser.enumeration_return enumeration(EnumeratedTypeSymbol newType) throws RecognitionException {
        T34fpbParser.enumeration_return retval = new T34fpbParser.enumeration_return();
        retval.start = input.LT(1);

        Token MINUS58=null;
        Token INTEGER_VALUE59=null;
        T34fpbParser.enumerationIdentifier_return enumerationIdentifier57 = null;


        try {
            // ./grammer/T34fpb.g:701:5: ( enumerationIdentifier ( '(' ( MINUS )? INTEGER_VALUE ')' )? )
            // ./grammer/T34fpb.g:701:9: enumerationIdentifier ( '(' ( MINUS )? INTEGER_VALUE ')' )?
            {
            pushFollow(FOLLOW_enumerationIdentifier_in_enumeration4543);
            enumerationIdentifier57=enumerationIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            // ./grammer/T34fpb.g:702:9: ( '(' ( MINUS )? INTEGER_VALUE ')' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==101) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ./grammer/T34fpb.g:702:13: '(' ( MINUS )? INTEGER_VALUE ')'
                    {
                    match(input,101,FOLLOW_101_in_enumeration4558); if (state.failed) return retval;
                    // ./grammer/T34fpb.g:702:17: ( MINUS )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==MINUS) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ./grammer/T34fpb.g:702:19: MINUS
                            {
                            MINUS58=(Token)match(input,MINUS,FOLLOW_MINUS_in_enumeration4562); if (state.failed) return retval;

                            }
                            break;

                    }

                    INTEGER_VALUE59=(Token)match(input,INTEGER_VALUE,FOLLOW_INTEGER_VALUE_in_enumeration4567); if (state.failed) return retval;
                    match(input,102,FOLLOW_102_in_enumeration4569); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              	helper.enumerationRule(((Token)retval.start), (enumerationIdentifier57!=null?input.toString(enumerationIdentifier57.start,enumerationIdentifier57.stop):null), (MINUS58!=null?MINUS58.getText():null), (INTEGER_VALUE59!=null?INTEGER_VALUE59.getText():null), newType);
                      
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumeration"


    // $ANTLR start "subTypeDef"
    // ./grammer/T34fpb.g:708:1: subTypeDef returns [Object newType] : type subTypeIdentifier ( subTypeSpec )? ;
    public final Object subTypeDef() throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        Object newType = null;

        T34fpbParser.type_return type60 = null;

        T34fpbParser.subTypeIdentifier_return subTypeIdentifier61 = null;

        T34fpbParser.subTypeSpec_return subTypeSpec62 = null;


        try {
            // ./grammer/T34fpb.g:710:5: ( type subTypeIdentifier ( subTypeSpec )? )
            // ./grammer/T34fpb.g:710:9: type subTypeIdentifier ( subTypeSpec )?
            {
            pushFollow(FOLLOW_type_in_subTypeDef4626);
            type60=type();

            state._fsp--;
            if (state.failed) return newType;
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = (type60!=null?input.toString(type60.start,type60.stop):null); 
            }
            pushFollow(FOLLOW_subTypeIdentifier_in_subTypeDef4635);
            subTypeIdentifier61=subTypeIdentifier();

            state._fsp--;
            if (state.failed) return newType;
            // ./grammer/T34fpb.g:712:6: ( subTypeSpec )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==LENGTH||LA45_0==101) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ./grammer/T34fpb.g:712:8: subTypeSpec
                    {
                    pushFollow(FOLLOW_subTypeSpec_in_subTypeDef4645);
                    subTypeSpec62=subTypeSpec();

                    state._fsp--;
                    if (state.failed) return newType;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
                  		newType = helper.subTypeDefRule((type60!=null?((Token)type60.start):null), (subTypeIdentifier61!=null?input.toString(subTypeIdentifier61.start,subTypeIdentifier61.stop):null), (type60!=null?input.toString(type60.start,type60.stop):null), 
                  			(subTypeSpec62!=null?subTypeSpec62.typeCons:null));
                  	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return newType;
    }
    // $ANTLR end "subTypeDef"

    public static class subTypeIdentifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "subTypeIdentifier"
    // ./grammer/T34fpb.g:719:1: subTypeIdentifier : identifier ;
    public final T34fpbParser.subTypeIdentifier_return subTypeIdentifier() throws RecognitionException {
        T34fpbParser.subTypeIdentifier_return retval = new T34fpbParser.subTypeIdentifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:720:5: ( identifier )
            // ./grammer/T34fpb.g:720:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_subTypeIdentifier4678);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subTypeIdentifier"

    public static class subTypeSpec_return extends ParserRuleReturnScope {
        public PTypeConstraint typeCons;
    };

    // $ANTLR start "subTypeSpec"
    // ./grammer/T34fpb.g:723:1: subTypeSpec returns [PTypeConstraint typeCons] : ( allowedValues ( stringLength )? | stringLength );
    public final T34fpbParser.subTypeSpec_return subTypeSpec() throws RecognitionException {
        T34fpbParser.subTypeSpec_return retval = new T34fpbParser.subTypeSpec_return();
        retval.start = input.LT(1);

        T34fpbParser.allowedValues_return allowedValues63 = null;

        PTypeConstraint stringLength64 = null;

        PTypeConstraint stringLength65 = null;


        try {
            // ./grammer/T34fpb.g:724:5: ( allowedValues ( stringLength )? | stringLength )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==101) ) {
                alt47=1;
            }
            else if ( (LA47_0==LENGTH) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ./grammer/T34fpb.g:724:9: allowedValues ( stringLength )?
                    {
                    pushFollow(FOLLOW_allowedValues_in_subTypeSpec4705);
                    allowedValues63=allowedValues();

                    state._fsp--;
                    if (state.failed) return retval;
                    // ./grammer/T34fpb.g:724:23: ( stringLength )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==LENGTH) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // ./grammer/T34fpb.g:724:25: stringLength
                            {
                            pushFollow(FOLLOW_stringLength_in_subTypeSpec4709);
                            stringLength64=stringLength();

                            state._fsp--;
                            if (state.failed) return retval;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       
                          		retval.typeCons = helper.subTypeSpecRule(((Token)retval.start), (allowedValues63!=null?allowedValues63.typeCons:null), stringLength64); 
                          	
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:727:8: stringLength
                    {
                    pushFollow(FOLLOW_stringLength_in_subTypeSpec4723);
                    stringLength65=stringLength();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.typeCons = stringLength65; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subTypeSpec"

    public static class allowedValues_return extends ParserRuleReturnScope {
        public PTypeConstraint typeCons;
    };

    // $ANTLR start "allowedValues"
    // ./grammer/T34fpb.g:730:1: allowedValues returns [PTypeConstraint typeCons] : '(' ( (v1= valueOrRange ( COMMA v2= valueOrRange )* ) | charStringMatch ) ')' ;
    public final T34fpbParser.allowedValues_return allowedValues() throws RecognitionException {
        T34fpbParser.allowedValues_return retval = new T34fpbParser.allowedValues_return();
        retval.start = input.LT(1);

        PMatcher v1 = null;

        PMatcher v2 = null;

        T34fpbParser.charStringMatch_return charStringMatch66 = null;



        	List<PMatcher> matcherList = new ArrayList<PMatcher>();

        try {
            // ./grammer/T34fpb.g:734:5: ( '(' ( (v1= valueOrRange ( COMMA v2= valueOrRange )* ) | charStringMatch ) ')' )
            // ./grammer/T34fpb.g:734:9: '(' ( (v1= valueOrRange ( COMMA v2= valueOrRange )* ) | charStringMatch ) ')'
            {
            match(input,101,FOLLOW_101_in_allowedValues4756); if (state.failed) return retval;
            // ./grammer/T34fpb.g:734:13: ( (v1= valueOrRange ( COMMA v2= valueOrRange )* ) | charStringMatch )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=OMIT && LA49_0<=CHAR)||LA49_0==MINUS||LA49_0==IDENTIFIER||LA49_0==CSTRING||LA49_0==BSTRING||LA49_0==HSTRING||LA49_0==OSTRING||LA49_0==INTEGER_VALUE||(LA49_0>=FLOAT_VALUE && LA49_0<=99)||LA49_0==106) ) {
                alt49=1;
            }
            else if ( (LA49_0==PATTERN) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ./grammer/T34fpb.g:734:16: (v1= valueOrRange ( COMMA v2= valueOrRange )* )
                    {
                    // ./grammer/T34fpb.g:734:16: (v1= valueOrRange ( COMMA v2= valueOrRange )* )
                    // ./grammer/T34fpb.g:734:19: v1= valueOrRange ( COMMA v2= valueOrRange )*
                    {
                    pushFollow(FOLLOW_valueOrRange_in_allowedValues4768);
                    v1=valueOrRange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       matcherList.add(v1); 
                    }
                    // ./grammer/T34fpb.g:735:9: ( COMMA v2= valueOrRange )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==COMMA) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ./grammer/T34fpb.g:735:11: COMMA v2= valueOrRange
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_allowedValues4782); if (state.failed) return retval;
                    	    pushFollow(FOLLOW_valueOrRange_in_allowedValues4788);
                    	    v2=valueOrRange();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	       matcherList.add(v2); 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {
                       retval.typeCons = helper.allowedValuesRule1(((Token)retval.start), matcherList); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:738:11: charStringMatch
                    {
                    pushFollow(FOLLOW_charStringMatch_in_allowedValues4825);
                    charStringMatch66=charStringMatch();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       retval.typeCons = helper.allowedValuesRule2(((Token)retval.start), (charStringMatch66!=null?charStringMatch66.matcher:null)); 
                    }

                    }
                    break;

            }

            match(input,102,FOLLOW_102_in_allowedValues4851); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "allowedValues"


    // $ANTLR start "valueOrRange"
    // ./grammer/T34fpb.g:743:1: valueOrRange returns [PMatcher matcher] : ( ( lowerBound RANGE_OP )=> rangeDef | constExpression );
    public final PMatcher valueOrRange() throws RecognitionException {
        PMatcher matcher = null;

        T34fpbParser.rangeDef_return rangeDef67 = null;

        PMatcher constExpression68 = null;


        try {
            // ./grammer/T34fpb.g:744:5: ( ( lowerBound RANGE_OP )=> rangeDef | constExpression )
            int alt50=2;
            alt50 = dfa50.predict(input);
            switch (alt50) {
                case 1 :
                    // ./grammer/T34fpb.g:744:9: ( lowerBound RANGE_OP )=> rangeDef
                    {
                    pushFollow(FOLLOW_rangeDef_in_valueOrRange4886);
                    rangeDef67=rangeDef();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = (rangeDef67!=null?rangeDef67.matcher:null); 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:745:13: constExpression
                    {
                    pushFollow(FOLLOW_constExpression_in_valueOrRange4902);
                    constExpression68=constExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = constExpression68; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "valueOrRange"

    public static class rangeDef_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "rangeDef"
    // ./grammer/T34fpb.g:748:1: rangeDef returns [PMatcher matcher] : lowerBound RANGE_OP upperBound ;
    public final T34fpbParser.rangeDef_return rangeDef() throws RecognitionException {
        T34fpbParser.rangeDef_return retval = new T34fpbParser.rangeDef_return();
        retval.start = input.LT(1);

        PMatcher lowerBound69 = null;

        PMatcher upperBound70 = null;


        try {
            // ./grammer/T34fpb.g:749:5: ( lowerBound RANGE_OP upperBound )
            // ./grammer/T34fpb.g:749:9: lowerBound RANGE_OP upperBound
            {
            pushFollow(FOLLOW_lowerBound_in_rangeDef4931);
            lowerBound69=lowerBound();

            state._fsp--;
            if (state.failed) return retval;
            match(input,RANGE_OP,FOLLOW_RANGE_OP_in_rangeDef4933); if (state.failed) return retval;
            pushFollow(FOLLOW_upperBound_in_rangeDef4935);
            upperBound70=upperBound();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

                  		retval.matcher = helper.rangeDefRule(((Token)retval.start), lowerBound69, upperBound70); 
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rangeDef"


    // $ANTLR start "stringLength"
    // ./grammer/T34fpb.g:754:1: stringLength returns [PTypeConstraint typeCons] : LENGTH '(' singleConstExpression ( RANGE_OP upperBound )? ')' ;
    public final PTypeConstraint stringLength() throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        PTypeConstraint typeCons = null;

        Token LENGTH71=null;
        PMatcher singleConstExpression72 = null;

        PMatcher upperBound73 = null;



        	boolean hasUpperBound = false;

        try {
            // ./grammer/T34fpb.g:759:5: ( LENGTH '(' singleConstExpression ( RANGE_OP upperBound )? ')' )
            // ./grammer/T34fpb.g:759:9: LENGTH '(' singleConstExpression ( RANGE_OP upperBound )? ')'
            {
            LENGTH71=(Token)match(input,LENGTH,FOLLOW_LENGTH_in_stringLength4974); if (state.failed) return typeCons;
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = "integer"; 
            }
            match(input,101,FOLLOW_101_in_stringLength4986); if (state.failed) return typeCons;
            pushFollow(FOLLOW_singleConstExpression_in_stringLength4988);
            singleConstExpression72=singleConstExpression();

            state._fsp--;
            if (state.failed) return typeCons;
            // ./grammer/T34fpb.g:761:10: ( RANGE_OP upperBound )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RANGE_OP) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ./grammer/T34fpb.g:761:12: RANGE_OP upperBound
                    {
                    match(input,RANGE_OP,FOLLOW_RANGE_OP_in_stringLength5002); if (state.failed) return typeCons;
                    pushFollow(FOLLOW_upperBound_in_stringLength5004);
                    upperBound73=upperBound();

                    state._fsp--;
                    if (state.failed) return typeCons;
                    if ( state.backtracking==0 ) {
                       hasUpperBound = true; 
                    }

                    }
                    break;

            }

            match(input,102,FOLLOW_102_in_stringLength5019); if (state.failed) return typeCons;
            if ( state.backtracking==0 ) {
               typeCons = helper.stringLengthRule(LENGTH71, singleConstExpression72, upperBound73, hasUpperBound); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return typeCons;
    }
    // $ANTLR end "stringLength"

    public static class charStringMatch_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "charStringMatch"
    // ./grammer/T34fpb.g:766:1: charStringMatch returns [PMatcher matcher] : PATTERN freeText ;
    public final T34fpbParser.charStringMatch_return charStringMatch() throws RecognitionException {
        T34fpbParser.charStringMatch_return retval = new T34fpbParser.charStringMatch_return();
        retval.start = input.LT(1);

        String freeText74 = null;


        try {
            // ./grammer/T34fpb.g:767:5: ( PATTERN freeText )
            // ./grammer/T34fpb.g:767:9: PATTERN freeText
            {
            match(input,PATTERN,FOLLOW_PATTERN_in_charStringMatch5057); if (state.failed) return retval;
            pushFollow(FOLLOW_freeText_in_charStringMatch5059);
            freeText74=freeText();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.matcher = helper.charStringMatchRule(((Token)retval.start), freeText74); 
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "charStringMatch"


    // $ANTLR start "lowerBound"
    // ./grammer/T34fpb.g:770:1: lowerBound returns [PMatcher matcher] : ( singleConstExpression | ( MINUS INFINITY ) ) ;
    public final PMatcher lowerBound() throws RecognitionException {
        PMatcher matcher = null;

        PMatcher singleConstExpression75 = null;


        try {
            // ./grammer/T34fpb.g:771:5: ( ( singleConstExpression | ( MINUS INFINITY ) ) )
            // ./grammer/T34fpb.g:771:9: ( singleConstExpression | ( MINUS INFINITY ) )
            {
            // ./grammer/T34fpb.g:771:9: ( singleConstExpression | ( MINUS INFINITY ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==MINUS) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==INFINITY) ) {
                    alt52=2;
                }
                else if ( ((LA52_1>=OMIT && LA52_1<=CHAR)||LA52_1==IDENTIFIER||LA52_1==CSTRING||LA52_1==BSTRING||LA52_1==HSTRING||LA52_1==OSTRING||LA52_1==INTEGER_VALUE||LA52_1==FLOAT_VALUE) ) {
                    alt52=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return matcher;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA52_0>=OMIT && LA52_0<=CHAR)||LA52_0==IDENTIFIER||LA52_0==CSTRING||LA52_0==BSTRING||LA52_0==HSTRING||LA52_0==OSTRING||LA52_0==INTEGER_VALUE||LA52_0==FLOAT_VALUE||LA52_0==106) ) {
                alt52=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return matcher;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ./grammer/T34fpb.g:771:11: singleConstExpression
                    {
                    pushFollow(FOLLOW_singleConstExpression_in_lowerBound5086);
                    singleConstExpression75=singleConstExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = singleConstExpression75; 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:772:13: ( MINUS INFINITY )
                    {
                    // ./grammer/T34fpb.g:772:13: ( MINUS INFINITY )
                    // ./grammer/T34fpb.g:772:15: MINUS INFINITY
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_lowerBound5104); if (state.failed) return matcher;
                    match(input,INFINITY,FOLLOW_INFINITY_in_lowerBound5106); if (state.failed) return matcher;

                    }

                    if ( state.backtracking==0 ) {
                       matcher = null; 
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "lowerBound"


    // $ANTLR start "upperBound"
    // ./grammer/T34fpb.g:776:1: upperBound returns [PMatcher matcher] : ( singleConstExpression | INFINITY ) ;
    public final PMatcher upperBound() throws RecognitionException {
        PMatcher matcher = null;

        PMatcher singleConstExpression76 = null;


        try {
            // ./grammer/T34fpb.g:777:5: ( ( singleConstExpression | INFINITY ) )
            // ./grammer/T34fpb.g:777:9: ( singleConstExpression | INFINITY )
            {
            // ./grammer/T34fpb.g:777:9: ( singleConstExpression | INFINITY )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=OMIT && LA53_0<=CHAR)||LA53_0==MINUS||LA53_0==IDENTIFIER||LA53_0==CSTRING||LA53_0==BSTRING||LA53_0==HSTRING||LA53_0==OSTRING||LA53_0==INTEGER_VALUE||LA53_0==FLOAT_VALUE||LA53_0==106) ) {
                alt53=1;
            }
            else if ( (LA53_0==INFINITY) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return matcher;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ./grammer/T34fpb.g:777:11: singleConstExpression
                    {
                    pushFollow(FOLLOW_singleConstExpression_in_upperBound5150);
                    singleConstExpression76=singleConstExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = singleConstExpression76; 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:778:13: INFINITY
                    {
                    match(input,INFINITY,FOLLOW_INFINITY_in_upperBound5166); if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = null; 
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "upperBound"


    // $ANTLR start "withStatement"
    // ./grammer/T34fpb.g:785:1: withStatement[Object targetElement] : WITH withAttribList[targetElement] ;
    public final void withStatement(Object targetElement) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:786:5: ( WITH withAttribList[targetElement] )
            // ./grammer/T34fpb.g:786:9: WITH withAttribList[targetElement]
            {
            match(input,WITH,FOLLOW_WITH_in_withStatement5206); if (state.failed) return ;
            pushFollow(FOLLOW_withAttribList_in_withStatement5208);
            withAttribList(targetElement);

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "withStatement"


    // $ANTLR start "withAttribList"
    // ./grammer/T34fpb.g:789:1: withAttribList[Object targetElement] : '{' multiWithAttrib[targetElement] '}' ;
    public final void withAttribList(Object targetElement) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:790:5: ( '{' multiWithAttrib[targetElement] '}' )
            // ./grammer/T34fpb.g:790:9: '{' multiWithAttrib[targetElement] '}'
            {
            match(input,99,FOLLOW_99_in_withAttribList5235); if (state.failed) return ;
            pushFollow(FOLLOW_multiWithAttrib_in_withAttribList5237);
            multiWithAttrib(targetElement);

            state._fsp--;
            if (state.failed) return ;
            match(input,100,FOLLOW_100_in_withAttribList5241); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "withAttribList"


    // $ANTLR start "multiWithAttrib"
    // ./grammer/T34fpb.g:793:1: multiWithAttrib[Object targetElement] : ( singleWithAttrib[targetElement] ( SEMI_COLON )? )* ;
    public final void multiWithAttrib(Object targetElement) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:794:5: ( ( singleWithAttrib[targetElement] ( SEMI_COLON )? )* )
            // ./grammer/T34fpb.g:794:9: ( singleWithAttrib[targetElement] ( SEMI_COLON )? )*
            {
            // ./grammer/T34fpb.g:794:9: ( singleWithAttrib[targetElement] ( SEMI_COLON )? )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=ENCODE && LA55_0<=RUNTIME)||(LA55_0>=ENUM && LA55_0<=ENUM_SET_REF)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ./grammer/T34fpb.g:794:11: singleWithAttrib[targetElement] ( SEMI_COLON )?
            	    {
            	    pushFollow(FOLLOW_singleWithAttrib_in_multiWithAttrib5268);
            	    singleWithAttrib(targetElement);

            	    state._fsp--;
            	    if (state.failed) return ;
            	    // ./grammer/T34fpb.g:794:44: ( SEMI_COLON )?
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( (LA54_0==SEMI_COLON) ) {
            	        alt54=1;
            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // ./grammer/T34fpb.g:794:46: SEMI_COLON
            	            {
            	            match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_multiWithAttrib5274); if (state.failed) return ;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "multiWithAttrib"


    // $ANTLR start "singleWithAttrib"
    // ./grammer/T34fpb.g:797:1: singleWithAttrib[Object targetElement] : ( encodeAttrib[targetElement] | variantAttrib[targetElement] | enumAttrib[targetElement] | enumRefAttrib[targetElement] | runtimeAttrib[targetElement] );
    public final void singleWithAttrib(Object targetElement) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:798:5: ( encodeAttrib[targetElement] | variantAttrib[targetElement] | enumAttrib[targetElement] | enumRefAttrib[targetElement] | runtimeAttrib[targetElement] )
            int alt56=5;
            switch ( input.LA(1) ) {
            case ENCODE:
                {
                alt56=1;
                }
                break;
            case VARIANT:
                {
                alt56=2;
                }
                break;
            case ENUM:
                {
                alt56=3;
                }
                break;
            case ENUM_SET_REF:
                {
                alt56=4;
                }
                break;
            case RUNTIME:
                {
                alt56=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ./grammer/T34fpb.g:798:9: encodeAttrib[targetElement]
                    {
                    pushFollow(FOLLOW_encodeAttrib_in_singleWithAttrib5301);
                    encodeAttrib(targetElement);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:799:13: variantAttrib[targetElement]
                    {
                    pushFollow(FOLLOW_variantAttrib_in_singleWithAttrib5317);
                    variantAttrib(targetElement);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:800:13: enumAttrib[targetElement]
                    {
                    pushFollow(FOLLOW_enumAttrib_in_singleWithAttrib5333);
                    enumAttrib(targetElement);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:801:13: enumRefAttrib[targetElement]
                    {
                    pushFollow(FOLLOW_enumRefAttrib_in_singleWithAttrib5349);
                    enumRefAttrib(targetElement);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:802:11: runtimeAttrib[targetElement]
                    {
                    pushFollow(FOLLOW_runtimeAttrib_in_singleWithAttrib5363);
                    runtimeAttrib(targetElement);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "singleWithAttrib"


    // $ANTLR start "encodeAttrib"
    // ./grammer/T34fpb.g:805:1: encodeAttrib[Object targetElement] : ENCODE ( attribQualifier )? freeText ;
    public final void encodeAttrib(Object targetElement) throws RecognitionException {
        Token ENCODE77=null;
        List<String> attribQualifier78 = null;

        String freeText79 = null;


        try {
            // ./grammer/T34fpb.g:806:5: ( ENCODE ( attribQualifier )? freeText )
            // ./grammer/T34fpb.g:806:9: ENCODE ( attribQualifier )? freeText
            {
            ENCODE77=(Token)match(input,ENCODE,FOLLOW_ENCODE_in_encodeAttrib5390); if (state.failed) return ;
            // ./grammer/T34fpb.g:806:16: ( attribQualifier )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==101) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ./grammer/T34fpb.g:806:18: attribQualifier
                    {
                    pushFollow(FOLLOW_attribQualifier_in_encodeAttrib5394);
                    attribQualifier78=attribQualifier();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_freeText_in_encodeAttrib5399);
            freeText79=freeText();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

                  		helper.encodeAttribRule(ENCODE77, targetElement, attribQualifier78, freeText79);
                  	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "encodeAttrib"


    // $ANTLR start "variantAttrib"
    // ./grammer/T34fpb.g:811:1: variantAttrib[Object targetElement] : VARIANT ( attribQualifier )? propertyList ;
    public final void variantAttrib(Object targetElement) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        Token VARIANT80=null;
        List<String> attribQualifier81 = null;

        PPropertyList propertyList82 = null;


        try {
            // ./grammer/T34fpb.g:813:5: ( VARIANT ( attribQualifier )? propertyList )
            // ./grammer/T34fpb.g:813:9: VARIANT ( attribQualifier )? propertyList
            {
            VARIANT80=(Token)match(input,VARIANT,FOLLOW_VARIANT_in_variantAttrib5431); if (state.failed) return ;
            // ./grammer/T34fpb.g:813:17: ( attribQualifier )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==101) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ./grammer/T34fpb.g:813:19: attribQualifier
                    {
                    pushFollow(FOLLOW_attribQualifier_in_variantAttrib5435);
                    attribQualifier81=attribQualifier();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
                  		helper.variantAttribRule1(VARIANT80, targetElement, attribQualifier81);
                  	
            }
            pushFollow(FOLLOW_propertyList_in_variantAttrib5447);
            propertyList82=propertyList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {

                  		helper.variantAttribRule2(VARIANT80, targetElement, attribQualifier81, propertyList82);
                  	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return ;
    }
    // $ANTLR end "variantAttrib"

    public static class runtimeAttrib_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "runtimeAttrib"
    // ./grammer/T34fpb.g:821:1: runtimeAttrib[Object targetElement] : RUNTIME ( attribQualifier )? simplePropertyList ;
    public final T34fpbParser.runtimeAttrib_return runtimeAttrib(Object targetElement) throws RecognitionException {
        T34fpbParser.runtimeAttrib_return retval = new T34fpbParser.runtimeAttrib_return();
        retval.start = input.LT(1);

        List<String> attribQualifier83 = null;

        SimplePropertyList simplePropertyList84 = null;


        try {
            // ./grammer/T34fpb.g:822:2: ( RUNTIME ( attribQualifier )? simplePropertyList )
            // ./grammer/T34fpb.g:822:4: RUNTIME ( attribQualifier )? simplePropertyList
            {
            match(input,RUNTIME,FOLLOW_RUNTIME_in_runtimeAttrib5466); if (state.failed) return retval;
            // ./grammer/T34fpb.g:822:12: ( attribQualifier )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==101) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ./grammer/T34fpb.g:822:14: attribQualifier
                    {
                    pushFollow(FOLLOW_attribQualifier_in_runtimeAttrib5470);
                    attribQualifier83=attribQualifier();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_simplePropertyList_in_runtimeAttrib5475);
            simplePropertyList84=simplePropertyList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			helper.runtimeAttribRule(((Token)retval.start), targetElement, attribQualifier83, simplePropertyList84);
              		
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "runtimeAttrib"

    public static class enumAttrib_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "enumAttrib"
    // ./grammer/T34fpb.g:827:1: enumAttrib[Object targetElement] : ENUM '(' defOrFieldRef ')' '{' enumItemList '}' ;
    public final T34fpbParser.enumAttrib_return enumAttrib(Object targetElement) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        T34fpbParser.enumAttrib_return retval = new T34fpbParser.enumAttrib_return();
        retval.start = input.LT(1);

        T34fpbParser.defOrFieldRef_return defOrFieldRef85 = null;

        List<PEnumItem> enumItemList86 = null;


        try {
            // ./grammer/T34fpb.g:829:5: ( ENUM '(' defOrFieldRef ')' '{' enumItemList '}' )
            // ./grammer/T34fpb.g:829:9: ENUM '(' defOrFieldRef ')' '{' enumItemList '}'
            {
            match(input,ENUM,FOLLOW_ENUM_in_enumAttrib5504); if (state.failed) return retval;
            match(input,101,FOLLOW_101_in_enumAttrib5506); if (state.failed) return retval;
            pushFollow(FOLLOW_defOrFieldRef_in_enumAttrib5508);
            defOrFieldRef85=defOrFieldRef();

            state._fsp--;
            if (state.failed) return retval;
            match(input,102,FOLLOW_102_in_enumAttrib5510); if (state.failed) return retval;
            if ( state.backtracking==0 ) {

                  		helper.enumAttribRule1(((Token)retval.start), targetElement, (defOrFieldRef85!=null?input.toString(defOrFieldRef85.start,defOrFieldRef85.stop):null));
                  	
            }
            match(input,99,FOLLOW_99_in_enumAttrib5519); if (state.failed) return retval;
            pushFollow(FOLLOW_enumItemList_in_enumAttrib5521);
            enumItemList86=enumItemList();

            state._fsp--;
            if (state.failed) return retval;
            match(input,100,FOLLOW_100_in_enumAttrib5523); if (state.failed) return retval;
            if ( state.backtracking==0 ) {

                  		helper.enumAttribRule2(((Token)retval.start), targetElement, (defOrFieldRef85!=null?input.toString(defOrFieldRef85.start,defOrFieldRef85.stop):null), enumItemList86);
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "enumAttrib"

    public static class enumRefAttrib_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "enumRefAttrib"
    // ./grammer/T34fpb.g:837:1: enumRefAttrib[Object targetElement] : ENUM_SET_REF '(' defOrFieldRef ')' enumSetReference ;
    public final T34fpbParser.enumRefAttrib_return enumRefAttrib(Object targetElement) throws RecognitionException {
        T34fpbParser.enumRefAttrib_return retval = new T34fpbParser.enumRefAttrib_return();
        retval.start = input.LT(1);

        T34fpbParser.defOrFieldRef_return defOrFieldRef87 = null;

        T34fpbParser.enumSetReference_return enumSetReference88 = null;


        try {
            // ./grammer/T34fpb.g:838:5: ( ENUM_SET_REF '(' defOrFieldRef ')' enumSetReference )
            // ./grammer/T34fpb.g:838:9: ENUM_SET_REF '(' defOrFieldRef ')' enumSetReference
            {
            match(input,ENUM_SET_REF,FOLLOW_ENUM_SET_REF_in_enumRefAttrib5550); if (state.failed) return retval;
            match(input,101,FOLLOW_101_in_enumRefAttrib5552); if (state.failed) return retval;
            pushFollow(FOLLOW_defOrFieldRef_in_enumRefAttrib5554);
            defOrFieldRef87=defOrFieldRef();

            state._fsp--;
            if (state.failed) return retval;
            match(input,102,FOLLOW_102_in_enumRefAttrib5556); if (state.failed) return retval;
            pushFollow(FOLLOW_enumSetReference_in_enumRefAttrib5558);
            enumSetReference88=enumSetReference();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

                  		helper.enumRefAttribRule(((Token)retval.start), targetElement, (defOrFieldRef87!=null?input.toString(defOrFieldRef87.start,defOrFieldRef87.stop):null), (enumSetReference88!=null?input.toString(enumSetReference88.start,enumSetReference88.stop):null));
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumRefAttrib"

    public static class enumSetReference_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "enumSetReference"
    // ./grammer/T34fpb.g:843:1: enumSetReference : ( globalModuleId DOT )? enumSetIdentifier ;
    public final T34fpbParser.enumSetReference_return enumSetReference() throws RecognitionException {
        T34fpbParser.enumSetReference_return retval = new T34fpbParser.enumSetReference_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:844:2: ( ( globalModuleId DOT )? enumSetIdentifier )
            // ./grammer/T34fpb.g:844:4: ( globalModuleId DOT )? enumSetIdentifier
            {
            // ./grammer/T34fpb.g:844:4: ( globalModuleId DOT )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==IDENTIFIER) ) {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==DOT) ) {
                    alt60=1;
                }
            }
            switch (alt60) {
                case 1 :
                    // ./grammer/T34fpb.g:844:6: globalModuleId DOT
                    {
                    pushFollow(FOLLOW_globalModuleId_in_enumSetReference5580);
                    globalModuleId();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,DOT,FOLLOW_DOT_in_enumSetReference5582); if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_enumSetIdentifier_in_enumSetReference5587);
            enumSetIdentifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumSetReference"


    // $ANTLR start "attribQualifier"
    // ./grammer/T34fpb.g:847:1: attribQualifier returns [List<String> ids] : '(' defOrFieldRefList ')' ;
    public final List<String> attribQualifier() throws RecognitionException {
        List<String> ids = null;

        List<String> defOrFieldRefList89 = null;


        try {
            // ./grammer/T34fpb.g:848:5: ( '(' defOrFieldRefList ')' )
            // ./grammer/T34fpb.g:848:9: '(' defOrFieldRefList ')'
            {
            match(input,101,FOLLOW_101_in_attribQualifier5608); if (state.failed) return ids;
            pushFollow(FOLLOW_defOrFieldRefList_in_attribQualifier5610);
            defOrFieldRefList89=defOrFieldRefList();

            state._fsp--;
            if (state.failed) return ids;
            match(input,102,FOLLOW_102_in_attribQualifier5612); if (state.failed) return ids;
            if ( state.backtracking==0 ) {
               ids = defOrFieldRefList89;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ids;
    }
    // $ANTLR end "attribQualifier"


    // $ANTLR start "defOrFieldRefList"
    // ./grammer/T34fpb.g:851:1: defOrFieldRefList returns [List<String> ids] : d1= defOrFieldRef ( COMMA d2= defOrFieldRef )* ;
    public final List<String> defOrFieldRefList() throws RecognitionException {
        List<String> ids = null;

        T34fpbParser.defOrFieldRef_return d1 = null;

        T34fpbParser.defOrFieldRef_return d2 = null;



        ids = new ArrayList<String>();

        try {
            // ./grammer/T34fpb.g:855:5: (d1= defOrFieldRef ( COMMA d2= defOrFieldRef )* )
            // ./grammer/T34fpb.g:855:9: d1= defOrFieldRef ( COMMA d2= defOrFieldRef )*
            {
            pushFollow(FOLLOW_defOrFieldRef_in_defOrFieldRefList5649);
            d1=defOrFieldRef();

            state._fsp--;
            if (state.failed) return ids;
            if ( state.backtracking==0 ) {
               ids.add((d1!=null?input.toString(d1.start,d1.stop):null)); 
            }
            // ./grammer/T34fpb.g:856:9: ( COMMA d2= defOrFieldRef )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==COMMA) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ./grammer/T34fpb.g:856:11: COMMA d2= defOrFieldRef
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_defOrFieldRefList5663); if (state.failed) return ids;
            	    pushFollow(FOLLOW_defOrFieldRef_in_defOrFieldRefList5669);
            	    d2=defOrFieldRef();

            	    state._fsp--;
            	    if (state.failed) return ids;
            	    if ( state.backtracking==0 ) {
            	       ids.add((d2!=null?input.toString(d2.start,d2.stop):null)); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ids;
    }
    // $ANTLR end "defOrFieldRefList"

    public static class defOrFieldRef_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "defOrFieldRef"
    // ./grammer/T34fpb.g:860:1: defOrFieldRef : identifier ;
    public final T34fpbParser.defOrFieldRef_return defOrFieldRef() throws RecognitionException {
        T34fpbParser.defOrFieldRef_return retval = new T34fpbParser.defOrFieldRef_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:861:5: ( identifier )
            // ./grammer/T34fpb.g:861:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_defOrFieldRef5705);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defOrFieldRef"


    // $ANTLR start "freeText"
    // ./grammer/T34fpb.g:864:1: freeText returns [String strText] : CSTRING ;
    public final String freeText() throws RecognitionException {
        String strText = null;

        Token CSTRING90=null;

        try {
            // ./grammer/T34fpb.g:865:5: ( CSTRING )
            // ./grammer/T34fpb.g:865:9: CSTRING
            {
            CSTRING90=(Token)match(input,CSTRING,FOLLOW_CSTRING_in_freeText5733); if (state.failed) return strText;
            if ( state.backtracking==0 ) {
               strText = helper.freeTextRule(CSTRING90);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return strText;
    }
    // $ANTLR end "freeText"


    // $ANTLR start "propertyList"
    // ./grammer/T34fpb.g:872:1: propertyList returns [PPropertyList prpList] options {k=2; } : property[prpList] ( ';' property[prpList] )* ;
    public final PPropertyList propertyList() throws RecognitionException {
        PPropertyList prpList = null;

        try {
            // ./grammer/T34fpb.g:876:5: ( property[prpList] ( ';' property[prpList] )* )
            // ./grammer/T34fpb.g:876:9: property[prpList] ( ';' property[prpList] )*
            {
            if ( state.backtracking==0 ) {
               prpList = helper.propertyListRule(); 
            }
            pushFollow(FOLLOW_property_in_propertyList5778);
            property(prpList);

            state._fsp--;
            if (state.failed) return prpList;
            // ./grammer/T34fpb.g:877:25: ( ';' property[prpList] )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==SEMI_COLON) ) {
                    int LA62_1 = input.LA(2);

                    if ( (LA62_1==IDENTIFIER) ) {
                        alt62=1;
                    }


                }


                switch (alt62) {
            	case 1 :
            	    // ./grammer/T34fpb.g:877:27: ';' property[prpList]
            	    {
            	    match(input,SEMI_COLON,FOLLOW_SEMI_COLON_in_propertyList5784); if (state.failed) return prpList;
            	    pushFollow(FOLLOW_property_in_propertyList5786);
            	    property(prpList);

            	    state._fsp--;
            	    if (state.failed) return prpList;

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return prpList;
    }
    // $ANTLR end "propertyList"


    // $ANTLR start "property"
    // ./grammer/T34fpb.g:880:1: property[PPropertyList prpList] returns [PProperty prp] : propertyIdentifier argumentGroupList[$prp] ;
    public final PProperty property(PPropertyList prpList) throws RecognitionException {
        PProperty prp = null;

        T34fpbParser.propertyIdentifier_return propertyIdentifier91 = null;


        try {
            // ./grammer/T34fpb.g:881:5: ( propertyIdentifier argumentGroupList[$prp] )
            // ./grammer/T34fpb.g:881:9: propertyIdentifier argumentGroupList[$prp]
            {
            pushFollow(FOLLOW_propertyIdentifier_in_property5820);
            propertyIdentifier91=propertyIdentifier();

            state._fsp--;
            if (state.failed) return prp;
            if ( state.backtracking==0 ) {
               prp = helper.propertyRule((propertyIdentifier91!=null?((Token)propertyIdentifier91.start):null), (propertyIdentifier91!=null?input.toString(propertyIdentifier91.start,propertyIdentifier91.stop):null), prpList); 
            }
            pushFollow(FOLLOW_argumentGroupList_in_property5829);
            argumentGroupList(prp);

            state._fsp--;
            if (state.failed) return prp;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return prp;
    }
    // $ANTLR end "property"

    public static class propertyIdentifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "propertyIdentifier"
    // ./grammer/T34fpb.g:885:1: propertyIdentifier : identifier ;
    public final T34fpbParser.propertyIdentifier_return propertyIdentifier() throws RecognitionException {
        T34fpbParser.propertyIdentifier_return retval = new T34fpbParser.propertyIdentifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:886:5: ( identifier )
            // ./grammer/T34fpb.g:886:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_propertyIdentifier5854);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "propertyIdentifier"


    // $ANTLR start "argumentGroupList"
    // ./grammer/T34fpb.g:889:1: argumentGroupList[PProperty prp] : argumentGroup[$prp] ( argumentGroup[$prp] )* ;
    public final void argumentGroupList(PProperty prp) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:890:5: ( argumentGroup[$prp] ( argumentGroup[$prp] )* )
            // ./grammer/T34fpb.g:890:9: argumentGroup[$prp] ( argumentGroup[$prp] )*
            {
            pushFollow(FOLLOW_argumentGroup_in_argumentGroupList5880);
            argumentGroup(prp);

            state._fsp--;
            if (state.failed) return ;
            // ./grammer/T34fpb.g:890:30: ( argumentGroup[$prp] )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==101) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ./grammer/T34fpb.g:890:32: argumentGroup[$prp]
            	    {
            	    pushFollow(FOLLOW_argumentGroup_in_argumentGroupList5886);
            	    argumentGroup(prp);

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "argumentGroupList"


    // $ANTLR start "argumentGroup"
    // ./grammer/T34fpb.g:893:1: argumentGroup[PProperty prp] returns [PArgumentGroup argGroup] : '(' argumentList[$argGroup] ')' ;
    public final PArgumentGroup argumentGroup(PProperty prp) throws RecognitionException {
        PArgumentGroup argGroup = null;

        try {
            // ./grammer/T34fpb.g:894:5: ( '(' argumentList[$argGroup] ')' )
            // ./grammer/T34fpb.g:894:9: '(' argumentList[$argGroup] ')'
            {
            if ( state.backtracking==0 ) {
               argGroup = helper.argumentGroupRule(prp); 
            }
            match(input,101,FOLLOW_101_in_argumentGroup5927); if (state.failed) return argGroup;
            pushFollow(FOLLOW_argumentList_in_argumentGroup5929);
            argumentList(argGroup);

            state._fsp--;
            if (state.failed) return argGroup;
            match(input,102,FOLLOW_102_in_argumentGroup5933); if (state.failed) return argGroup;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return argGroup;
    }
    // $ANTLR end "argumentGroup"


    // $ANTLR start "argumentList"
    // ./grammer/T34fpb.g:898:1: argumentList[PArgumentGroup argGroup] : argument[argGroup] ( ',' argument[argGroup] )* ;
    public final void argumentList(PArgumentGroup argGroup) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:899:5: ( argument[argGroup] ( ',' argument[argGroup] )* )
            // ./grammer/T34fpb.g:899:9: argument[argGroup] ( ',' argument[argGroup] )*
            {
            pushFollow(FOLLOW_argument_in_argumentList5958);
            argument(argGroup);

            state._fsp--;
            if (state.failed) return ;
            // ./grammer/T34fpb.g:899:29: ( ',' argument[argGroup] )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==COMMA) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ./grammer/T34fpb.g:899:31: ',' argument[argGroup]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_argumentList5964); if (state.failed) return ;
            	    pushFollow(FOLLOW_argument_in_argumentList5966);
            	    argument(argGroup);

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "argumentList"


    // $ANTLR start "argument"
    // ./grammer/T34fpb.g:902:1: argument[PArgumentGroup argGroup] : ( singleArgument[argGroup] | listArgument[argGroup] );
    public final void argument(PArgumentGroup argGroup) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:903:5: ( singleArgument[argGroup] | listArgument[argGroup] )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( ((LA65_0>=TRUE && LA65_0<=FALSE)||LA65_0==CHAR||(LA65_0>=BIT_STRING && LA65_0<=UNIVERSAL)||LA65_0==MINUS||(LA65_0>=VALUE_REF_ARG_PREFIX && LA65_0<=TYPE_REF_ARG_PREFIX)||LA65_0==IDENTIFIER||LA65_0==CSTRING||LA65_0==INTEGER_VALUE||LA65_0==101) ) {
                alt65=1;
            }
            else if ( (LA65_0==103) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ./grammer/T34fpb.g:903:9: singleArgument[argGroup]
                    {
                    pushFollow(FOLLOW_singleArgument_in_argument5996);
                    singleArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:904:13: listArgument[argGroup]
                    {
                    pushFollow(FOLLOW_listArgument_in_argument6012);
                    listArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "argument"


    // $ANTLR start "singleArgument"
    // ./grammer/T34fpb.g:907:1: singleArgument[PArgumentGroup argGroup] : ( integerArgument[argGroup] | booleanArgument[argGroup] | charStringArgument[argGroup] | identifierArgument[argGroup] | conditionArgument[argGroup] | valueRefArgument[argGroup] | typeRefArgument[argGroup] );
    public final void singleArgument(PArgumentGroup argGroup) throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:908:5: ( integerArgument[argGroup] | booleanArgument[argGroup] | charStringArgument[argGroup] | identifierArgument[argGroup] | conditionArgument[argGroup] | valueRefArgument[argGroup] | typeRefArgument[argGroup] )
            int alt66=7;
            switch ( input.LA(1) ) {
            case MINUS:
            case INTEGER_VALUE:
                {
                alt66=1;
                }
                break;
            case TRUE:
            case FALSE:
                {
                alt66=2;
                }
                break;
            case CHAR:
            case CSTRING:
                {
                alt66=3;
                }
                break;
            case IDENTIFIER:
                {
                int LA66_4 = input.LA(2);

                if ( (LA66_4==DOT||LA66_4==101) ) {
                    alt66=5;
                }
                else if ( (LA66_4==COMMA||LA66_4==102||LA66_4==104) ) {
                    alt66=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 4, input);

                    throw nvae;
                }
                }
                break;
            case BIT_STRING:
            case BOOLEAN:
            case INTEGER:
            case OCTET_STRING:
            case HEX_STRING:
            case VERDICT_TYPE:
            case FLOAT:
            case CHAR_STRING:
            case UNIVERSAL:
            case 101:
                {
                alt66=5;
                }
                break;
            case VALUE_REF_ARG_PREFIX:
                {
                alt66=6;
                }
                break;
            case TYPE_REF_ARG_PREFIX:
                {
                alt66=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ./grammer/T34fpb.g:908:9: integerArgument[argGroup]
                    {
                    pushFollow(FOLLOW_integerArgument_in_singleArgument6039);
                    integerArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:909:13: booleanArgument[argGroup]
                    {
                    pushFollow(FOLLOW_booleanArgument_in_singleArgument6055);
                    booleanArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:910:13: charStringArgument[argGroup]
                    {
                    pushFollow(FOLLOW_charStringArgument_in_singleArgument6071);
                    charStringArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:911:13: identifierArgument[argGroup]
                    {
                    pushFollow(FOLLOW_identifierArgument_in_singleArgument6087);
                    identifierArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:912:13: conditionArgument[argGroup]
                    {
                    pushFollow(FOLLOW_conditionArgument_in_singleArgument6103);
                    conditionArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // ./grammer/T34fpb.g:913:11: valueRefArgument[argGroup]
                    {
                    pushFollow(FOLLOW_valueRefArgument_in_singleArgument6117);
                    valueRefArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // ./grammer/T34fpb.g:914:11: typeRefArgument[argGroup]
                    {
                    pushFollow(FOLLOW_typeRefArgument_in_singleArgument6131);
                    typeRefArgument(argGroup);

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "singleArgument"


    // $ANTLR start "integerArgument"
    // ./grammer/T34fpb.g:917:1: integerArgument[PArgumentGroup argGroup] : ( MINUS )? integerValue ;
    public final void integerArgument(PArgumentGroup argGroup) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        Token MINUS93=null;
        T34fpbParser.integerValue_return integerValue92 = null;


        try {
            // ./grammer/T34fpb.g:919:5: ( ( MINUS )? integerValue )
            // ./grammer/T34fpb.g:919:9: ( MINUS )? integerValue
            {
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = "integer"; 
            }
            // ./grammer/T34fpb.g:920:6: ( MINUS )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==MINUS) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ./grammer/T34fpb.g:920:8: MINUS
                    {
                    MINUS93=(Token)match(input,MINUS,FOLLOW_MINUS_in_integerArgument6172); if (state.failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_integerValue_in_integerArgument6183);
            integerValue92=integerValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               helper.integerArgumentRule((integerValue92!=null?((Token)integerValue92.start):null), MINUS93, (integerValue92!=null?integerValue92.matcher:null), argGroup); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return ;
    }
    // $ANTLR end "integerArgument"


    // $ANTLR start "booleanArgument"
    // ./grammer/T34fpb.g:924:1: booleanArgument[PArgumentGroup argGroup] : booleanValue ;
    public final void booleanArgument(PArgumentGroup argGroup) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        T34fpbParser.booleanValue_return booleanValue94 = null;


        try {
            // ./grammer/T34fpb.g:926:5: ( booleanValue )
            // ./grammer/T34fpb.g:926:9: booleanValue
            {
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = "boolean"; 
            }
            pushFollow(FOLLOW_booleanValue_in_booleanArgument6222);
            booleanValue94=booleanValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               helper.booleanArgumentRule((booleanValue94!=null?((Token)booleanValue94.start):null), (booleanValue94!=null?booleanValue94.matcher:null), argGroup); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return ;
    }
    // $ANTLR end "booleanArgument"


    // $ANTLR start "charStringArgument"
    // ./grammer/T34fpb.g:930:1: charStringArgument[PArgumentGroup argGroup] : charStringValue ;
    public final void charStringArgument(PArgumentGroup argGroup) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        T34fpbParser.charStringValue_return charStringValue95 = null;


        try {
            // ./grammer/T34fpb.g:932:5: ( charStringValue )
            // ./grammer/T34fpb.g:932:9: charStringValue
            {
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = "charstring"; 
            }
            pushFollow(FOLLOW_charStringValue_in_charStringArgument6261);
            charStringValue95=charStringValue();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               helper.charStringArgumentRule((charStringValue95!=null?((Token)charStringValue95.start):null), (charStringValue95!=null?charStringValue95.matcher:null), argGroup); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return ;
    }
    // $ANTLR end "charStringArgument"


    // $ANTLR start "identifierArgument"
    // ./grammer/T34fpb.g:936:1: identifierArgument[PArgumentGroup argGroup] : identifier ;
    public final void identifierArgument(PArgumentGroup argGroup) throws RecognitionException {
        T34fpbParser.identifier_return identifier96 = null;


        try {
            // ./grammer/T34fpb.g:937:2: ( identifier )
            // ./grammer/T34fpb.g:937:4: identifier
            {
            pushFollow(FOLLOW_identifier_in_identifierArgument6283);
            identifier96=identifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               helper.identifierArgumentRule((identifier96!=null?((Token)identifier96.start):null), (identifier96!=null?input.toString(identifier96.start,identifier96.stop):null), argGroup); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "identifierArgument"

    public static class conditionArgument_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "conditionArgument"
    // ./grammer/T34fpb.g:940:1: conditionArgument[PArgumentGroup argGroup] : ( conditionType )? allowedValues ;
    public final T34fpbParser.conditionArgument_return conditionArgument(PArgumentGroup argGroup) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        T34fpbParser.conditionArgument_return retval = new T34fpbParser.conditionArgument_return();
        retval.start = input.LT(1);

        T34fpbParser.conditionType_return conditionType97 = null;

        T34fpbParser.allowedValues_return allowedValues98 = null;


        try {
            // ./grammer/T34fpb.g:942:5: ( ( conditionType )? allowedValues )
            // ./grammer/T34fpb.g:942:9: ( conditionType )? allowedValues
            {
            // ./grammer/T34fpb.g:942:9: ( conditionType )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( ((LA68_0>=BIT_STRING && LA68_0<=UNIVERSAL)||LA68_0==IDENTIFIER) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ./grammer/T34fpb.g:942:11: conditionType
                    {
                    pushFollow(FOLLOW_conditionType_in_conditionArgument6310);
                    conditionType97=conditionType();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                  		helper.conditionArgumentRule1(((Token)retval.start), (conditionType97!=null?input.toString(conditionType97.start,conditionType97.stop):null));
                  	
            }
            pushFollow(FOLLOW_allowedValues_in_conditionArgument6322);
            allowedValues98=allowedValues();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

                  		helper.conditionArgumentRule2(((Token)retval.start), (conditionType97!=null?input.toString(conditionType97.start,conditionType97.stop):null), (allowedValues98!=null?allowedValues98.typeCons:null), argGroup);
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "conditionArgument"

    public static class conditionType_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "conditionType"
    // ./grammer/T34fpb.g:950:1: conditionType : type ;
    public final T34fpbParser.conditionType_return conditionType() throws RecognitionException {
        T34fpbParser.conditionType_return retval = new T34fpbParser.conditionType_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:951:5: ( type )
            // ./grammer/T34fpb.g:951:9: type
            {
            pushFollow(FOLLOW_type_in_conditionType6343);
            type();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "conditionType"


    // $ANTLR start "listArgument"
    // ./grammer/T34fpb.g:954:1: listArgument[PArgumentGroup argGroup] returns [PListArgument listArg] : '[' ( argumentList[$listArg == null ? null : $listArg.getGroup()] )? ']' ;
    public final PListArgument listArgument(PArgumentGroup argGroup) throws RecognitionException {
        PListArgument listArg = null;

        try {
            // ./grammer/T34fpb.g:955:5: ( '[' ( argumentList[$listArg == null ? null : $listArg.getGroup()] )? ']' )
            // ./grammer/T34fpb.g:955:9: '[' ( argumentList[$listArg == null ? null : $listArg.getGroup()] )? ']'
            {
            if ( state.backtracking==0 ) {
               listArg = helper.listArgumentRule(argGroup); 
            }
            match(input,103,FOLLOW_103_in_listArgument6379); if (state.failed) return listArg;
            // ./grammer/T34fpb.g:956:10: ( argumentList[$listArg == null ? null : $listArg.getGroup()] )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( ((LA69_0>=TRUE && LA69_0<=FALSE)||LA69_0==CHAR||(LA69_0>=BIT_STRING && LA69_0<=UNIVERSAL)||LA69_0==MINUS||(LA69_0>=VALUE_REF_ARG_PREFIX && LA69_0<=TYPE_REF_ARG_PREFIX)||LA69_0==IDENTIFIER||LA69_0==CSTRING||LA69_0==INTEGER_VALUE||LA69_0==101||LA69_0==103) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ./grammer/T34fpb.g:956:12: argumentList[$listArg == null ? null : $listArg.getGroup()]
                    {
                    pushFollow(FOLLOW_argumentList_in_listArgument6383);
                    argumentList(listArg == null ? null : listArg.getGroup());

                    state._fsp--;
                    if (state.failed) return listArg;

                    }
                    break;

            }

            match(input,104,FOLLOW_104_in_listArgument6390); if (state.failed) return listArg;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return listArg;
    }
    // $ANTLR end "listArgument"

    public static class valueRefArgument_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "valueRefArgument"
    // ./grammer/T34fpb.g:959:1: valueRefArgument[PArgumentGroup argGroup] : VALUE_REF_ARG_PREFIX valueReference ( extendedFieldReference[refSymbol] )? ;
    public final T34fpbParser.valueRefArgument_return valueRefArgument(PArgumentGroup argGroup) throws RecognitionException {
        T34fpbParser.valueRefArgument_return retval = new T34fpbParser.valueRefArgument_return();
        retval.start = input.LT(1);

        T34fpbParser.valueReference_return valueReference99 = null;



        	ValueReferenceSymbol refSymbol = null;;

        try {
            // ./grammer/T34fpb.g:963:2: ( VALUE_REF_ARG_PREFIX valueReference ( extendedFieldReference[refSymbol] )? )
            // ./grammer/T34fpb.g:963:4: VALUE_REF_ARG_PREFIX valueReference ( extendedFieldReference[refSymbol] )?
            {
            match(input,VALUE_REF_ARG_PREFIX,FOLLOW_VALUE_REF_ARG_PREFIX_in_valueRefArgument6415); if (state.failed) return retval;
            pushFollow(FOLLOW_valueReference_in_valueRefArgument6423);
            valueReference99=valueReference();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               refSymbol = helper.valueRefArgumentRule1(((Token)retval.start), (valueReference99!=null?input.toString(valueReference99.start,valueReference99.stop):null)); 
            }
            // ./grammer/T34fpb.g:965:6: ( extendedFieldReference[refSymbol] )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==DOT||LA70_0==103) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ./grammer/T34fpb.g:965:8: extendedFieldReference[refSymbol]
                    {
                    pushFollow(FOLLOW_extendedFieldReference_in_valueRefArgument6434);
                    extendedFieldReference(refSymbol);

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                  		helper.valueRefArgumentRule2(((Token)retval.start), refSymbol, argGroup);
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "valueRefArgument"

    public static class typeRefArgument_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "typeRefArgument"
    // ./grammer/T34fpb.g:971:1: typeRefArgument[PArgumentGroup argGroup] : TYPE_REF_ARG_PREFIX type ;
    public final T34fpbParser.typeRefArgument_return typeRefArgument(PArgumentGroup argGroup) throws RecognitionException {
        T34fpbParser.typeRefArgument_return retval = new T34fpbParser.typeRefArgument_return();
        retval.start = input.LT(1);

        T34fpbParser.type_return type100 = null;


        try {
            // ./grammer/T34fpb.g:972:2: ( TYPE_REF_ARG_PREFIX type )
            // ./grammer/T34fpb.g:972:4: TYPE_REF_ARG_PREFIX type
            {
            match(input,TYPE_REF_ARG_PREFIX,FOLLOW_TYPE_REF_ARG_PREFIX_in_typeRefArgument6466); if (state.failed) return retval;
            pushFollow(FOLLOW_type_in_typeRefArgument6468);
            type100=type();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               helper.typeRefArgumentRule(((Token)retval.start), (type100!=null?input.toString(type100.start,type100.stop):null), argGroup); 
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeRefArgument"


    // $ANTLR start "simplePropertyList"
    // ./grammer/T34fpb.g:978:1: simplePropertyList returns [SimplePropertyList prpList] : simpleProperty[prpList] ( simpleProperty[prpList] )* ;
    public final SimplePropertyList simplePropertyList() throws RecognitionException {
        SimplePropertyList prpList = null;

        try {
            // ./grammer/T34fpb.g:979:2: ( simpleProperty[prpList] ( simpleProperty[prpList] )* )
            // ./grammer/T34fpb.g:979:4: simpleProperty[prpList] ( simpleProperty[prpList] )*
            {
            if ( state.backtracking==0 ) {
               prpList = new SimplePropertyList(); 
            }
            pushFollow(FOLLOW_simpleProperty_in_simplePropertyList6492);
            simpleProperty(prpList);

            state._fsp--;
            if (state.failed) return prpList;
            // ./grammer/T34fpb.g:980:28: ( simpleProperty[prpList] )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==IDENTIFIER) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ./grammer/T34fpb.g:980:30: simpleProperty[prpList]
            	    {
            	    pushFollow(FOLLOW_simpleProperty_in_simplePropertyList6498);
            	    simpleProperty(prpList);

            	    state._fsp--;
            	    if (state.failed) return prpList;

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return prpList;
    }
    // $ANTLR end "simplePropertyList"

    public static class simpleProperty_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "simpleProperty"
    // ./grammer/T34fpb.g:983:1: simpleProperty[SimplePropertyList prpList] : simplePropertyIdentifier '=' freeText ;
    public final T34fpbParser.simpleProperty_return simpleProperty(SimplePropertyList prpList) throws RecognitionException {
        T34fpbParser.simpleProperty_return retval = new T34fpbParser.simpleProperty_return();
        retval.start = input.LT(1);

        T34fpbParser.simplePropertyIdentifier_return simplePropertyIdentifier101 = null;

        String freeText102 = null;


        try {
            // ./grammer/T34fpb.g:984:2: ( simplePropertyIdentifier '=' freeText )
            // ./grammer/T34fpb.g:984:5: simplePropertyIdentifier '=' freeText
            {
            pushFollow(FOLLOW_simplePropertyIdentifier_in_simpleProperty6518);
            simplePropertyIdentifier101=simplePropertyIdentifier();

            state._fsp--;
            if (state.failed) return retval;
            match(input,105,FOLLOW_105_in_simpleProperty6520); if (state.failed) return retval;
            pushFollow(FOLLOW_freeText_in_simpleProperty6522);
            freeText102=freeText();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {

              			helper.simplePropertyRule(((Token)retval.start), (simplePropertyIdentifier101!=null?input.toString(simplePropertyIdentifier101.start,simplePropertyIdentifier101.stop):null), freeText102, prpList);
              		
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simpleProperty"

    public static class simplePropertyIdentifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "simplePropertyIdentifier"
    // ./grammer/T34fpb.g:989:1: simplePropertyIdentifier : identifier ;
    public final T34fpbParser.simplePropertyIdentifier_return simplePropertyIdentifier() throws RecognitionException {
        T34fpbParser.simplePropertyIdentifier_return retval = new T34fpbParser.simplePropertyIdentifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:990:2: ( identifier )
            // ./grammer/T34fpb.g:990:4: identifier
            {
            pushFollow(FOLLOW_identifier_in_simplePropertyIdentifier6536);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simplePropertyIdentifier"


    // $ANTLR start "enumSetDef"
    // ./grammer/T34fpb.g:997:1: enumSetDef returns [Object newSet] : ENUM_SET type enumSetIdentifier '{' enumItemList '}' ;
    public final Object enumSetDef() throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        Object newSet = null;

        T34fpbParser.type_return type103 = null;

        T34fpbParser.enumSetIdentifier_return enumSetIdentifier104 = null;

        List<PEnumItem> enumItemList105 = null;


        try {
            // ./grammer/T34fpb.g:999:2: ( ENUM_SET type enumSetIdentifier '{' enumItemList '}' )
            // ./grammer/T34fpb.g:999:6: ENUM_SET type enumSetIdentifier '{' enumItemList '}'
            {
            match(input,ENUM_SET,FOLLOW_ENUM_SET_in_enumSetDef6563); if (state.failed) return newSet;
            pushFollow(FOLLOW_type_in_enumSetDef6565);
            type103=type();

            state._fsp--;
            if (state.failed) return newSet;
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = (type103!=null?input.toString(type103.start,type103.stop):null); 
            }
            pushFollow(FOLLOW_enumSetIdentifier_in_enumSetDef6571);
            enumSetIdentifier104=enumSetIdentifier();

            state._fsp--;
            if (state.failed) return newSet;
            match(input,99,FOLLOW_99_in_enumSetDef6576); if (state.failed) return newSet;
            pushFollow(FOLLOW_enumItemList_in_enumSetDef6578);
            enumItemList105=enumItemList();

            state._fsp--;
            if (state.failed) return newSet;
            match(input,100,FOLLOW_100_in_enumSetDef6581); if (state.failed) return newSet;
            if ( state.backtracking==0 ) {

              			newSet = helper.enumSetDefRule((type103!=null?((Token)type103.start):null), (enumSetIdentifier104!=null?input.toString(enumSetIdentifier104.start,enumSetIdentifier104.stop):null), (type103!=null?input.toString(type103.start,type103.stop):null), 
              				enumItemList105);
              		
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return newSet;
    }
    // $ANTLR end "enumSetDef"

    public static class enumSetIdentifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "enumSetIdentifier"
    // ./grammer/T34fpb.g:1008:1: enumSetIdentifier : identifier ;
    public final T34fpbParser.enumSetIdentifier_return enumSetIdentifier() throws RecognitionException {
        T34fpbParser.enumSetIdentifier_return retval = new T34fpbParser.enumSetIdentifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1009:5: ( identifier )
            // ./grammer/T34fpb.g:1009:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_enumSetIdentifier6610);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumSetIdentifier"


    // $ANTLR start "enumItemList"
    // ./grammer/T34fpb.g:1012:1: enumItemList returns [List<PEnumItem> enumList] : enumItem[$enumList] ( COMMA enumItem[$enumList] )* ;
    public final List<PEnumItem> enumItemList() throws RecognitionException {
        List<PEnumItem> enumList = null;


        	if (helper.isCreatingModel()) {
        		enumList = new ArrayList<PEnumItem>();
        	}

        try {
            // ./grammer/T34fpb.g:1018:5: ( enumItem[$enumList] ( COMMA enumItem[$enumList] )* )
            // ./grammer/T34fpb.g:1018:9: enumItem[$enumList] ( COMMA enumItem[$enumList] )*
            {
            pushFollow(FOLLOW_enumItem_in_enumItemList6642);
            enumItem(enumList);

            state._fsp--;
            if (state.failed) return enumList;
            // ./grammer/T34fpb.g:1018:30: ( COMMA enumItem[$enumList] )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==COMMA) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // ./grammer/T34fpb.g:1018:32: COMMA enumItem[$enumList]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_enumItemList6648); if (state.failed) return enumList;
            	    pushFollow(FOLLOW_enumItem_in_enumItemList6650);
            	    enumItem(enumList);

            	    state._fsp--;
            	    if (state.failed) return enumList;

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return enumList;
    }
    // $ANTLR end "enumItemList"

    public static class enumItem_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "enumItem"
    // ./grammer/T34fpb.g:1021:1: enumItem[List<PEnumItem> enumList] : allowedValues enumItemName ;
    public final T34fpbParser.enumItem_return enumItem(List<PEnumItem> enumList) throws RecognitionException {
        T34fpbParser.enumItem_return retval = new T34fpbParser.enumItem_return();
        retval.start = input.LT(1);

        String enumItemName106 = null;

        T34fpbParser.allowedValues_return allowedValues107 = null;


        try {
            // ./grammer/T34fpb.g:1022:5: ( allowedValues enumItemName )
            // ./grammer/T34fpb.g:1022:9: allowedValues enumItemName
            {
            pushFollow(FOLLOW_allowedValues_in_enumItem6680);
            allowedValues107=allowedValues();

            state._fsp--;
            if (state.failed) return retval;
            pushFollow(FOLLOW_enumItemName_in_enumItem6682);
            enumItemName106=enumItemName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               
                  		helper.enumItemRule(((Token)retval.start), enumList, enumItemName106, (allowedValues107!=null?allowedValues107.typeCons:null) ); 
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumItem"


    // $ANTLR start "enumItemName"
    // ./grammer/T34fpb.g:1027:1: enumItemName returns [String strText] : freeText ;
    public final String enumItemName() throws RecognitionException {
        String strText = null;

        String freeText108 = null;


        try {
            // ./grammer/T34fpb.g:1028:5: ( freeText )
            // ./grammer/T34fpb.g:1028:9: freeText
            {
            pushFollow(FOLLOW_freeText_in_enumItemName6711);
            freeText108=freeText();

            state._fsp--;
            if (state.failed) return strText;
            if ( state.backtracking==0 ) {
               strText = freeText108; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return strText;
    }
    // $ANTLR end "enumItemName"


    // $ANTLR start "enumItemIdentifier"
    // ./grammer/T34fpb.g:1031:1: enumItemIdentifier : identifier ;
    public final void enumItemIdentifier() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1032:5: ( identifier )
            // ./grammer/T34fpb.g:1032:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_enumItemIdentifier6736);
            identifier();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "enumItemIdentifier"


    // $ANTLR start "singleConstExpression"
    // ./grammer/T34fpb.g:1040:1: singleConstExpression returns [PMatcher matcher] : singleExpression ;
    public final PMatcher singleConstExpression() throws RecognitionException {
        ConstScope_stack.push(new ConstScope_scope());

        PMatcher matcher = null;

        T34fpbParser.singleExpression_return singleExpression109 = null;


        try {
            // ./grammer/T34fpb.g:1042:5: ( singleExpression )
            // ./grammer/T34fpb.g:1042:8: singleExpression
            {
            pushFollow(FOLLOW_singleExpression_in_singleConstExpression6776);
            singleExpression109=singleExpression();

            state._fsp--;
            if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
               matcher = (singleExpression109!=null?singleExpression109.matcher:null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            ConstScope_stack.pop();

        }
        return matcher;
    }
    // $ANTLR end "singleConstExpression"


    // $ANTLR start "constExpression"
    // ./grammer/T34fpb.g:1045:1: constExpression returns [PMatcher matcher] : ( singleConstExpression | compoundConstExpression );
    public final PMatcher constExpression() throws RecognitionException {
        PMatcher matcher = null;

        PMatcher singleConstExpression110 = null;

        PMatcher compoundConstExpression111 = null;


        try {
            // ./grammer/T34fpb.g:1046:5: ( singleConstExpression | compoundConstExpression )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=OMIT && LA73_0<=CHAR)||LA73_0==MINUS||LA73_0==IDENTIFIER||LA73_0==CSTRING||LA73_0==BSTRING||LA73_0==HSTRING||LA73_0==OSTRING||LA73_0==INTEGER_VALUE||LA73_0==FLOAT_VALUE||LA73_0==106) ) {
                alt73=1;
            }
            else if ( (LA73_0==99) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return matcher;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ./grammer/T34fpb.g:1046:9: singleConstExpression
                    {
                    pushFollow(FOLLOW_singleConstExpression_in_constExpression6805);
                    singleConstExpression110=singleConstExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = singleConstExpression110; 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1047:13: compoundConstExpression
                    {
                    pushFollow(FOLLOW_compoundConstExpression_in_constExpression6821);
                    compoundConstExpression111=compoundConstExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = compoundConstExpression111; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "constExpression"


    // $ANTLR start "expression"
    // ./grammer/T34fpb.g:1050:1: expression returns [PMatcher matcher] : ( singleExpression | compoundExpression );
    public final PMatcher expression() throws RecognitionException {
        PMatcher matcher = null;

        T34fpbParser.singleExpression_return singleExpression112 = null;

        PMatcher compoundExpression113 = null;


        try {
            // ./grammer/T34fpb.g:1051:5: ( singleExpression | compoundExpression )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=OMIT && LA74_0<=CHAR)||LA74_0==MINUS||LA74_0==IDENTIFIER||LA74_0==CSTRING||LA74_0==BSTRING||LA74_0==HSTRING||LA74_0==OSTRING||LA74_0==INTEGER_VALUE||LA74_0==FLOAT_VALUE||LA74_0==106) ) {
                alt74=1;
            }
            else if ( (LA74_0==99) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return matcher;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // ./grammer/T34fpb.g:1051:9: singleExpression
                    {
                    pushFollow(FOLLOW_singleExpression_in_expression6846);
                    singleExpression112=singleExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = (singleExpression112!=null?singleExpression112.matcher:null); 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1052:13: compoundExpression
                    {
                    pushFollow(FOLLOW_compoundExpression_in_expression6862);
                    compoundExpression113=compoundExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = compoundExpression113; 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "expression"


    // $ANTLR start "compoundConstExpression"
    // ./grammer/T34fpb.g:1054:1: compoundConstExpression returns [PMatcher matcher] : ( fieldExpressionList | arrayExpression );
    public final PMatcher compoundConstExpression() throws RecognitionException {
        ConstScope_stack.push(new ConstScope_scope());

        PMatcher matcher = null;

        T34fpbParser.fieldExpressionList_return fieldExpressionList114 = null;

        T34fpbParser.arrayExpression_return arrayExpression115 = null;


        try {
            // ./grammer/T34fpb.g:1056:5: ( fieldExpressionList | arrayExpression )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==99) ) {
                switch ( input.LA(2) ) {
                case OMIT:
                case TRUE:
                case FALSE:
                case PASS:
                case FAIL:
                case INCONC:
                case NONE:
                case ERROR:
                case CHAR:
                case MINUS:
                case CSTRING:
                case BSTRING:
                case HSTRING:
                case OSTRING:
                case INTEGER_VALUE:
                case FLOAT_VALUE:
                case 99:
                case 100:
                case 106:
                    {
                    alt75=2;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA75_3 = input.LA(3);

                    if ( (LA75_3==DOT||LA75_3==COMMA||LA75_3==100||LA75_3==103) ) {
                        alt75=2;
                    }
                    else if ( (LA75_3==ASSIGNMENT_CHAR) ) {
                        alt75=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return matcher;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 103:
                    {
                    alt75=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return matcher;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return matcher;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ./grammer/T34fpb.g:1056:9: fieldExpressionList
                    {
                    pushFollow(FOLLOW_fieldExpressionList_in_compoundConstExpression6891);
                    fieldExpressionList114=fieldExpressionList();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = (fieldExpressionList114!=null?fieldExpressionList114.matcher:null); 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1057:13: arrayExpression
                    {
                    pushFollow(FOLLOW_arrayExpression_in_compoundConstExpression6907);
                    arrayExpression115=arrayExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = (arrayExpression115!=null?arrayExpression115.matcher:null); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            ConstScope_stack.pop();

        }
        return matcher;
    }
    // $ANTLR end "compoundConstExpression"

    public static class singleExpression_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "singleExpression"
    // ./grammer/T34fpb.g:1060:1: singleExpression returns [PMatcher matcher] : unaryExpression ;
    public final T34fpbParser.singleExpression_return singleExpression() throws RecognitionException {
        T34fpbParser.singleExpression_return retval = new T34fpbParser.singleExpression_return();
        retval.start = input.LT(1);

        T34fpbParser.unaryExpression_return unaryExpression116 = null;


        try {
            // ./grammer/T34fpb.g:1061:5: ( unaryExpression )
            // ./grammer/T34fpb.g:1061:9: unaryExpression
            {
            pushFollow(FOLLOW_unaryExpression_in_singleExpression6936);
            unaryExpression116=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               
                  		retval.matcher = helper.singleExpressionRule(((Token)retval.start), (unaryExpression116!=null?unaryExpression116.matcher:null)); 
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "singleExpression"

    public static class unaryExpression_return extends ParserRuleReturnScope {
        public PExpressionMatcher matcher;
    };

    // $ANTLR start "unaryExpression"
    // ./grammer/T34fpb.g:1066:1: unaryExpression returns [PExpressionMatcher matcher] : ( unaryOp )? primary ;
    public final T34fpbParser.unaryExpression_return unaryExpression() throws RecognitionException {
        T34fpbParser.unaryExpression_return retval = new T34fpbParser.unaryExpression_return();
        retval.start = input.LT(1);

        T34fpbParser.unaryOp_return unaryOp117 = null;

        PMatcher primary118 = null;


        try {
            // ./grammer/T34fpb.g:1067:2: ( ( unaryOp )? primary )
            // ./grammer/T34fpb.g:1067:4: ( unaryOp )? primary
            {
            // ./grammer/T34fpb.g:1067:4: ( unaryOp )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==MINUS||LA76_0==106) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ./grammer/T34fpb.g:1067:6: unaryOp
                    {
                    pushFollow(FOLLOW_unaryOp_in_unaryExpression6958);
                    unaryOp117=unaryOp();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            pushFollow(FOLLOW_primary_in_unaryExpression6963);
            primary118=primary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               
              			retval.matcher = helper.unaryExpressionRule(((Token)retval.start), (unaryOp117!=null?input.toString(unaryOp117.start,unaryOp117.stop):null), primary118); 
              		
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryExpression"

    public static class unaryOp_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "unaryOp"
    // ./grammer/T34fpb.g:1072:1: unaryOp : ( '+' | '-' );
    public final T34fpbParser.unaryOp_return unaryOp() throws RecognitionException {
        T34fpbParser.unaryOp_return retval = new T34fpbParser.unaryOp_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1073:2: ( '+' | '-' )
            // ./grammer/T34fpb.g:
            {
            if ( input.LA(1)==MINUS||input.LA(1)==106 ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryOp"


    // $ANTLR start "primary"
    // ./grammer/T34fpb.g:1076:1: primary returns [PMatcher matcher] : value ;
    public final PMatcher primary() throws RecognitionException {
        PMatcher matcher = null;

        PMatcher value119 = null;


        try {
            // ./grammer/T34fpb.g:1077:2: ( value )
            // ./grammer/T34fpb.g:1077:4: value
            {
            pushFollow(FOLLOW_value_in_primary6999);
            value119=value();

            state._fsp--;
            if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
               matcher = value119; 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "primary"


    // $ANTLR start "value"
    // ./grammer/T34fpb.g:1080:1: value returns [PMatcher matcher] options {k=2; } : ( predefinedValue | referencedValue );
    public final PMatcher value() throws RecognitionException {
        PMatcher matcher = null;

        PMatcher predefinedValue120 = null;

        T34fpbParser.referencedValue_return referencedValue121 = null;


        try {
            // ./grammer/T34fpb.g:1082:5: ( predefinedValue | referencedValue )
            int alt77=2;
            alt77 = dfa77.predict(input);
            switch (alt77) {
                case 1 :
                    // ./grammer/T34fpb.g:1082:9: predefinedValue
                    {
                    pushFollow(FOLLOW_predefinedValue_in_value7030);
                    predefinedValue120=predefinedValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = predefinedValue120; 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1083:13: referencedValue
                    {
                    pushFollow(FOLLOW_referencedValue_in_value7046);
                    referencedValue121=referencedValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = (referencedValue121!=null?referencedValue121.matcher:null); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "value"


    // $ANTLR start "predefinedValue"
    // ./grammer/T34fpb.g:1086:1: predefinedValue returns [PMatcher matcher] : ( hexStringValue | bitStringValue | octetStringValue | booleanValue | charStringValue | integerValue | verdictTypeValue | {...}? enumeratedValue | floatValue | omitValue );
    public final PMatcher predefinedValue() throws RecognitionException {
        PMatcher matcher = null;

        PMatcher hexStringValue122 = null;

        PMatcher bitStringValue123 = null;

        PMatcher octetStringValue124 = null;

        T34fpbParser.booleanValue_return booleanValue125 = null;

        T34fpbParser.charStringValue_return charStringValue126 = null;

        T34fpbParser.integerValue_return integerValue127 = null;

        PMatcher verdictTypeValue128 = null;

        PMatcher enumeratedValue129 = null;

        PMatcher floatValue130 = null;

        PMatcher omitValue131 = null;


        try {
            // ./grammer/T34fpb.g:1087:5: ( hexStringValue | bitStringValue | octetStringValue | booleanValue | charStringValue | integerValue | verdictTypeValue | {...}? enumeratedValue | floatValue | omitValue )
            int alt78=10;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // ./grammer/T34fpb.g:1087:9: hexStringValue
                    {
                    pushFollow(FOLLOW_hexStringValue_in_predefinedValue7071);
                    hexStringValue122=hexStringValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = hexStringValue122;
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1088:13: bitStringValue
                    {
                    pushFollow(FOLLOW_bitStringValue_in_predefinedValue7087);
                    bitStringValue123=bitStringValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = bitStringValue123;
                    }

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:1089:13: octetStringValue
                    {
                    pushFollow(FOLLOW_octetStringValue_in_predefinedValue7103);
                    octetStringValue124=octetStringValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = octetStringValue124;
                    }

                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:1090:13: booleanValue
                    {
                    pushFollow(FOLLOW_booleanValue_in_predefinedValue7119);
                    booleanValue125=booleanValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = (booleanValue125!=null?booleanValue125.matcher:null);
                    }

                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:1091:13: charStringValue
                    {
                    pushFollow(FOLLOW_charStringValue_in_predefinedValue7135);
                    charStringValue126=charStringValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = (charStringValue126!=null?charStringValue126.matcher:null);
                    }

                    }
                    break;
                case 6 :
                    // ./grammer/T34fpb.g:1092:13: integerValue
                    {
                    pushFollow(FOLLOW_integerValue_in_predefinedValue7151);
                    integerValue127=integerValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = (integerValue127!=null?integerValue127.matcher:null);
                    }

                    }
                    break;
                case 7 :
                    // ./grammer/T34fpb.g:1093:13: verdictTypeValue
                    {
                    pushFollow(FOLLOW_verdictTypeValue_in_predefinedValue7167);
                    verdictTypeValue128=verdictTypeValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = verdictTypeValue128;
                    }

                    }
                    break;
                case 8 :
                    // ./grammer/T34fpb.g:1094:13: {...}? enumeratedValue
                    {
                    if ( !(( helper.nextTokenIsEnumeratedItemId() )) ) {
                        if (state.backtracking>0) {state.failed=true; return matcher;}
                        throw new FailedPredicateException(input, "predefinedValue", " helper.nextTokenIsEnumeratedItemId() ");
                    }
                    pushFollow(FOLLOW_enumeratedValue_in_predefinedValue7185);
                    enumeratedValue129=enumeratedValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {

                              		matcher = enumeratedValue129; 
                    }

                    }
                    break;
                case 9 :
                    // ./grammer/T34fpb.g:1096:13: floatValue
                    {
                    pushFollow(FOLLOW_floatValue_in_predefinedValue7201);
                    floatValue130=floatValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = floatValue130;
                    }

                    }
                    break;
                case 10 :
                    // ./grammer/T34fpb.g:1098:13: omitValue
                    {
                    pushFollow(FOLLOW_omitValue_in_predefinedValue7218);
                    omitValue131=omitValue();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                      matcher = omitValue131;
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "predefinedValue"


    // $ANTLR start "bitStringValue"
    // ./grammer/T34fpb.g:1103:1: bitStringValue returns [PMatcher matcher] : BSTRING ;
    public final PMatcher bitStringValue() throws RecognitionException {
        PMatcher matcher = null;

        Token BSTRING132=null;

        try {
            // ./grammer/T34fpb.g:1104:5: ( BSTRING )
            // ./grammer/T34fpb.g:1104:9: BSTRING
            {
            BSTRING132=(Token)match(input,BSTRING,FOLLOW_BSTRING_in_bitStringValue7253); if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
              matcher = helper.createBitStringValue(BSTRING132);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "bitStringValue"


    // $ANTLR start "octetStringValue"
    // ./grammer/T34fpb.g:1107:1: octetStringValue returns [PMatcher matcher] : OSTRING ;
    public final PMatcher octetStringValue() throws RecognitionException {
        PMatcher matcher = null;

        Token OSTRING133=null;

        try {
            // ./grammer/T34fpb.g:1108:5: ( OSTRING )
            // ./grammer/T34fpb.g:1108:9: OSTRING
            {
            OSTRING133=(Token)match(input,OSTRING,FOLLOW_OSTRING_in_octetStringValue7282); if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
              matcher = helper.createOctetStringValue(OSTRING133);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "octetStringValue"


    // $ANTLR start "hexStringValue"
    // ./grammer/T34fpb.g:1111:1: hexStringValue returns [PMatcher matcher] : HSTRING ;
    public final PMatcher hexStringValue() throws RecognitionException {
        PMatcher matcher = null;

        Token HSTRING134=null;

        try {
            // ./grammer/T34fpb.g:1112:5: ( HSTRING )
            // ./grammer/T34fpb.g:1112:9: HSTRING
            {
            HSTRING134=(Token)match(input,HSTRING,FOLLOW_HSTRING_in_hexStringValue7311); if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
              matcher = helper.createHexStringValue(HSTRING134);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "hexStringValue"

    public static class booleanValue_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "booleanValue"
    // ./grammer/T34fpb.g:1115:1: booleanValue returns [PMatcher matcher] : (b= TRUE | b= FALSE ) ;
    public final T34fpbParser.booleanValue_return booleanValue() throws RecognitionException {
        T34fpbParser.booleanValue_return retval = new T34fpbParser.booleanValue_return();
        retval.start = input.LT(1);

        Token b=null;

        try {
            // ./grammer/T34fpb.g:1116:5: ( (b= TRUE | b= FALSE ) )
            // ./grammer/T34fpb.g:1116:9: (b= TRUE | b= FALSE )
            {
            // ./grammer/T34fpb.g:1116:9: (b= TRUE | b= FALSE )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==TRUE) ) {
                alt79=1;
            }
            else if ( (LA79_0==FALSE) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // ./grammer/T34fpb.g:1116:11: b= TRUE
                    {
                    b=(Token)match(input,TRUE,FOLLOW_TRUE_in_booleanValue7346); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1117:13: b= FALSE
                    {
                    b=(Token)match(input,FALSE,FOLLOW_FALSE_in_booleanValue7364); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              retval.matcher = helper.createBooleanValue(b);
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "booleanValue"

    public static class integerValue_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "integerValue"
    // ./grammer/T34fpb.g:1120:1: integerValue returns [PMatcher matcher] : INTEGER_VALUE ;
    public final T34fpbParser.integerValue_return integerValue() throws RecognitionException {
        T34fpbParser.integerValue_return retval = new T34fpbParser.integerValue_return();
        retval.start = input.LT(1);

        Token INTEGER_VALUE135=null;

        try {
            // ./grammer/T34fpb.g:1121:5: ( INTEGER_VALUE )
            // ./grammer/T34fpb.g:1121:9: INTEGER_VALUE
            {
            INTEGER_VALUE135=(Token)match(input,INTEGER_VALUE,FOLLOW_INTEGER_VALUE_in_integerValue7390); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              retval.matcher = helper.createIntegerValue(INTEGER_VALUE135);
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integerValue"


    // $ANTLR start "verdictTypeValue"
    // ./grammer/T34fpb.g:1124:1: verdictTypeValue returns [PMatcher matcher] : (v= PASS | v= FAIL | v= INCONC | v= NONE | v= ERROR ) ;
    public final PMatcher verdictTypeValue() throws RecognitionException {
        PMatcher matcher = null;

        Token v=null;

        try {
            // ./grammer/T34fpb.g:1125:5: ( (v= PASS | v= FAIL | v= INCONC | v= NONE | v= ERROR ) )
            // ./grammer/T34fpb.g:1125:9: (v= PASS | v= FAIL | v= INCONC | v= NONE | v= ERROR )
            {
            // ./grammer/T34fpb.g:1125:9: (v= PASS | v= FAIL | v= INCONC | v= NONE | v= ERROR )
            int alt80=5;
            switch ( input.LA(1) ) {
            case PASS:
                {
                alt80=1;
                }
                break;
            case FAIL:
                {
                alt80=2;
                }
                break;
            case INCONC:
                {
                alt80=3;
                }
                break;
            case NONE:
                {
                alt80=4;
                }
                break;
            case ERROR:
                {
                alt80=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return matcher;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }

            switch (alt80) {
                case 1 :
                    // ./grammer/T34fpb.g:1125:11: v= PASS
                    {
                    v=(Token)match(input,PASS,FOLLOW_PASS_in_verdictTypeValue7425); if (state.failed) return matcher;

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1126:13: v= FAIL
                    {
                    v=(Token)match(input,FAIL,FOLLOW_FAIL_in_verdictTypeValue7443); if (state.failed) return matcher;

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:1127:13: v= INCONC
                    {
                    v=(Token)match(input,INCONC,FOLLOW_INCONC_in_verdictTypeValue7461); if (state.failed) return matcher;

                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:1128:13: v= NONE
                    {
                    v=(Token)match(input,NONE,FOLLOW_NONE_in_verdictTypeValue7479); if (state.failed) return matcher;

                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:1129:13: v= ERROR
                    {
                    v=(Token)match(input,ERROR,FOLLOW_ERROR_in_verdictTypeValue7497); if (state.failed) return matcher;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              matcher = helper.createVerdictValue(v);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "verdictTypeValue"


    // $ANTLR start "enumeratedValue"
    // ./grammer/T34fpb.g:1132:1: enumeratedValue returns [PMatcher matcher] : enumerationIdentifier ;
    public final PMatcher enumeratedValue() throws RecognitionException {
        PMatcher matcher = null;

        T34fpbParser.enumerationIdentifier_return enumerationIdentifier136 = null;


        try {
            // ./grammer/T34fpb.g:1133:5: ( enumerationIdentifier )
            // ./grammer/T34fpb.g:1133:9: enumerationIdentifier
            {
            pushFollow(FOLLOW_enumerationIdentifier_in_enumeratedValue7527);
            enumerationIdentifier136=enumerationIdentifier();

            state._fsp--;
            if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
              matcher = helper.createEnumeratedValue((enumerationIdentifier136!=null?enumerationIdentifier136.id:null));
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "enumeratedValue"

    public static class enumerationIdentifier_return extends ParserRuleReturnScope {
        public Token id;
    };

    // $ANTLR start "enumerationIdentifier"
    // ./grammer/T34fpb.g:1136:1: enumerationIdentifier returns [Token id] : identifier ;
    public final T34fpbParser.enumerationIdentifier_return enumerationIdentifier() throws RecognitionException {
        T34fpbParser.enumerationIdentifier_return retval = new T34fpbParser.enumerationIdentifier_return();
        retval.start = input.LT(1);

        T34fpbParser.identifier_return identifier137 = null;


        try {
            // ./grammer/T34fpb.g:1137:5: ( identifier )
            // ./grammer/T34fpb.g:1137:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_enumerationIdentifier7554);
            identifier137=identifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              retval.id = (identifier137!=null?identifier137.id:null);
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "enumerationIdentifier"

    public static class charStringValue_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "charStringValue"
    // ./grammer/T34fpb.g:1140:1: charStringValue returns [PMatcher matcher] : ( CSTRING | quadruple );
    public final T34fpbParser.charStringValue_return charStringValue() throws RecognitionException {
        T34fpbParser.charStringValue_return retval = new T34fpbParser.charStringValue_return();
        retval.start = input.LT(1);

        Token CSTRING138=null;

        try {
            // ./grammer/T34fpb.g:1141:5: ( CSTRING | quadruple )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==CSTRING) ) {
                alt81=1;
            }
            else if ( (LA81_0==CHAR) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ./grammer/T34fpb.g:1141:9: CSTRING
                    {
                    CSTRING138=(Token)match(input,CSTRING,FOLLOW_CSTRING_in_charStringValue7579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      retval.matcher = helper.createCharStringValueNormal(CSTRING138);
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1142:13: quadruple
                    {
                    pushFollow(FOLLOW_quadruple_in_charStringValue7595);
                    quadruple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                      assert false; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "charStringValue"


    // $ANTLR start "quadruple"
    // ./grammer/T34fpb.g:1145:1: quadruple : CHAR '(' INTEGER_VALUE COMMA INTEGER_VALUE COMMA INTEGER_VALUE COMMA INTEGER_VALUE ')' ;
    public final void quadruple() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1146:5: ( CHAR '(' INTEGER_VALUE COMMA INTEGER_VALUE COMMA INTEGER_VALUE COMMA INTEGER_VALUE ')' )
            // ./grammer/T34fpb.g:1146:9: CHAR '(' INTEGER_VALUE COMMA INTEGER_VALUE COMMA INTEGER_VALUE COMMA INTEGER_VALUE ')'
            {
            match(input,CHAR,FOLLOW_CHAR_in_quadruple7620); if (state.failed) return ;
            match(input,101,FOLLOW_101_in_quadruple7622); if (state.failed) return ;
            match(input,INTEGER_VALUE,FOLLOW_INTEGER_VALUE_in_quadruple7624); if (state.failed) return ;
            match(input,COMMA,FOLLOW_COMMA_in_quadruple7626); if (state.failed) return ;
            match(input,INTEGER_VALUE,FOLLOW_INTEGER_VALUE_in_quadruple7628); if (state.failed) return ;
            match(input,COMMA,FOLLOW_COMMA_in_quadruple7630); if (state.failed) return ;
            match(input,INTEGER_VALUE,FOLLOW_INTEGER_VALUE_in_quadruple7632); if (state.failed) return ;
            match(input,COMMA,FOLLOW_COMMA_in_quadruple7634); if (state.failed) return ;
            match(input,INTEGER_VALUE,FOLLOW_INTEGER_VALUE_in_quadruple7636); if (state.failed) return ;
            match(input,102,FOLLOW_102_in_quadruple7638); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "quadruple"


    // $ANTLR start "floatValue"
    // ./grammer/T34fpb.g:1149:1: floatValue returns [PMatcher matcher] : FLOAT_VALUE ;
    public final PMatcher floatValue() throws RecognitionException {
        PMatcher matcher = null;

        Token FLOAT_VALUE139=null;

        try {
            // ./grammer/T34fpb.g:1150:5: ( FLOAT_VALUE )
            // ./grammer/T34fpb.g:1150:9: FLOAT_VALUE
            {
            FLOAT_VALUE139=(Token)match(input,FLOAT_VALUE,FOLLOW_FLOAT_VALUE_in_floatValue7665); if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
              matcher = helper.createFloatValue(FLOAT_VALUE139);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "floatValue"


    // $ANTLR start "omitValue"
    // ./grammer/T34fpb.g:1153:1: omitValue returns [PMatcher matcher] : OMIT ;
    public final PMatcher omitValue() throws RecognitionException {
        PMatcher matcher = null;

        Token OMIT140=null;

        try {
            // ./grammer/T34fpb.g:1154:5: ( OMIT )
            // ./grammer/T34fpb.g:1154:9: OMIT
            {
            OMIT140=(Token)match(input,OMIT,FOLLOW_OMIT_in_omitValue7694); if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
              matcher = helper.createOmitValue(OMIT140);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "omitValue"

    public static class referencedValue_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "referencedValue"
    // ./grammer/T34fpb.g:1157:1: referencedValue returns [PMatcher matcher] : valueReference ( extendedFieldReference[refSymbol] )? ;
    public final T34fpbParser.referencedValue_return referencedValue() throws RecognitionException {
        T34fpbParser.referencedValue_return retval = new T34fpbParser.referencedValue_return();
        retval.start = input.LT(1);

        T34fpbParser.valueReference_return valueReference141 = null;



        	ValueReferenceSymbol refSymbol = null;;

        try {
            // ./grammer/T34fpb.g:1161:5: ( valueReference ( extendedFieldReference[refSymbol] )? )
            // ./grammer/T34fpb.g:1161:9: valueReference ( extendedFieldReference[refSymbol] )?
            {
            pushFollow(FOLLOW_valueReference_in_referencedValue7728);
            valueReference141=valueReference();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               refSymbol = helper.referencedValueRule(((Token)retval.start), (valueReference141!=null?input.toString(valueReference141.start,valueReference141.stop):null)); 
            }
            // ./grammer/T34fpb.g:1162:6: ( extendedFieldReference[refSymbol] )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==DOT||LA82_0==103) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ./grammer/T34fpb.g:1162:8: extendedFieldReference[refSymbol]
                    {
                    pushFollow(FOLLOW_extendedFieldReference_in_referencedValue7739);
                    extendedFieldReference(refSymbol);

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                  		if (refSymbol != null)  {
                  			retval.matcher = refSymbol.getModel();
                  		}
                  	
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "referencedValue"

    public static class valueReference_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "valueReference"
    // ./grammer/T34fpb.g:1170:1: valueReference : ( ( globalModuleId DOT )=> ( globalModuleId DOT ) )? identifier ;
    public final T34fpbParser.valueReference_return valueReference() throws RecognitionException {
        T34fpbParser.valueReference_return retval = new T34fpbParser.valueReference_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1171:5: ( ( ( globalModuleId DOT )=> ( globalModuleId DOT ) )? identifier )
            // ./grammer/T34fpb.g:1171:9: ( ( globalModuleId DOT )=> ( globalModuleId DOT ) )? identifier
            {
            // ./grammer/T34fpb.g:1171:9: ( ( globalModuleId DOT )=> ( globalModuleId DOT ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==IDENTIFIER) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==DOT) ) {
                    int LA83_2 = input.LA(3);

                    if ( (LA83_2==IDENTIFIER) ) {
                        int LA83_4 = input.LA(4);

                        if ( (synpred2_T34fpb()) ) {
                            alt83=1;
                        }
                    }
                }
            }
            switch (alt83) {
                case 1 :
                    // ./grammer/T34fpb.g:1171:11: ( globalModuleId DOT )=> ( globalModuleId DOT )
                    {
                    // ./grammer/T34fpb.g:1171:35: ( globalModuleId DOT )
                    // ./grammer/T34fpb.g:1171:36: globalModuleId DOT
                    {
                    pushFollow(FOLLOW_globalModuleId_in_valueReference7785);
                    globalModuleId();

                    state._fsp--;
                    if (state.failed) return retval;
                    match(input,DOT,FOLLOW_DOT_in_valueReference7787); if (state.failed) return retval;

                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_identifier_in_valueReference7792);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "valueReference"

    public static class extendedFieldReference_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "extendedFieldReference"
    // ./grammer/T34fpb.g:1174:1: extendedFieldReference[ValueReferenceSymbol refSymbol] : ( ( DOT structFieldIdetifier ) | arrayOrBitRef )+ ;
    public final T34fpbParser.extendedFieldReference_return extendedFieldReference(ValueReferenceSymbol refSymbol) throws RecognitionException {
        T34fpbParser.extendedFieldReference_return retval = new T34fpbParser.extendedFieldReference_return();
        retval.start = input.LT(1);

        T34fpbParser.structFieldIdetifier_return structFieldIdetifier142 = null;

        PMatcher arrayOrBitRef143 = null;


        try {
            // ./grammer/T34fpb.g:1175:5: ( ( ( DOT structFieldIdetifier ) | arrayOrBitRef )+ )
            // ./grammer/T34fpb.g:1175:9: ( ( DOT structFieldIdetifier ) | arrayOrBitRef )+
            {
            // ./grammer/T34fpb.g:1175:9: ( ( DOT structFieldIdetifier ) | arrayOrBitRef )+
            int cnt84=0;
            loop84:
            do {
                int alt84=3;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==DOT) ) {
                    alt84=1;
                }
                else if ( (LA84_0==103) ) {
                    alt84=2;
                }


                switch (alt84) {
            	case 1 :
            	    // ./grammer/T34fpb.g:1175:13: ( DOT structFieldIdetifier )
            	    {
            	    // ./grammer/T34fpb.g:1175:13: ( DOT structFieldIdetifier )
            	    // ./grammer/T34fpb.g:1175:15: DOT structFieldIdetifier
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_extendedFieldReference7831); if (state.failed) return retval;
            	    pushFollow(FOLLOW_structFieldIdetifier_in_extendedFieldReference7833);
            	    structFieldIdetifier142=structFieldIdetifier();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	          			helper.extendedFieldReferenceRule1(((Token)retval.start), refSymbol, (structFieldIdetifier142!=null?input.toString(structFieldIdetifier142.start,structFieldIdetifier142.stop):null)); 
            	          		
            	    }

            	    }
            	    break;
            	case 2 :
            	    // ./grammer/T34fpb.g:1178:13: arrayOrBitRef
            	    {
            	    pushFollow(FOLLOW_arrayOrBitRef_in_extendedFieldReference7850);
            	    arrayOrBitRef143=arrayOrBitRef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {

            	              		helper.extendedFieldReferenceRule2(((Token)retval.start), refSymbol, arrayOrBitRef143);
            	              	
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt84 >= 1 ) break loop84;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(84, input);
                        throw eee;
                }
                cnt84++;
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "extendedFieldReference"

    public static class structFieldIdetifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "structFieldIdetifier"
    // ./grammer/T34fpb.g:1184:1: structFieldIdetifier : identifier ;
    public final T34fpbParser.structFieldIdetifier_return structFieldIdetifier() throws RecognitionException {
        T34fpbParser.structFieldIdetifier_return retval = new T34fpbParser.structFieldIdetifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1185:2: ( identifier )
            // ./grammer/T34fpb.g:1185:4: identifier
            {
            pushFollow(FOLLOW_identifier_in_structFieldIdetifier7881);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "structFieldIdetifier"


    // $ANTLR start "arrayOrBitRef"
    // ./grammer/T34fpb.g:1188:1: arrayOrBitRef returns [PMatcher matcher] : '[' singleExpression ']' ;
    public final PMatcher arrayOrBitRef() throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        PMatcher matcher = null;

        T34fpbParser.singleExpression_return singleExpression144 = null;


        try {
            // ./grammer/T34fpb.g:1190:5: ( '[' singleExpression ']' )
            // ./grammer/T34fpb.g:1190:9: '[' singleExpression ']'
            {
            if ( state.backtracking==0 ) {
               ((TypeScope_scope)TypeScope_stack.peek()).typeName = "integer"; 
            }
            match(input,103,FOLLOW_103_in_arrayOrBitRef7914); if (state.failed) return matcher;
            pushFollow(FOLLOW_singleExpression_in_arrayOrBitRef7916);
            singleExpression144=singleExpression();

            state._fsp--;
            if (state.failed) return matcher;
            if ( state.backtracking==0 ) {
               matcher = (singleExpression144!=null?singleExpression144.matcher:null); 
            }
            match(input,104,FOLLOW_104_in_arrayOrBitRef7926); if (state.failed) return matcher;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return matcher;
    }
    // $ANTLR end "arrayOrBitRef"

    public static class identifier_return extends ParserRuleReturnScope {
        public Token id;
    };

    // $ANTLR start "identifier"
    // ./grammer/T34fpb.g:1195:1: identifier returns [Token id] : IDENTIFIER ;
    public final T34fpbParser.identifier_return identifier() throws RecognitionException {
        T34fpbParser.identifier_return retval = new T34fpbParser.identifier_return();
        retval.start = input.LT(1);

        Token IDENTIFIER145=null;

        try {
            // ./grammer/T34fpb.g:1196:5: ( IDENTIFIER )
            // ./grammer/T34fpb.g:1196:9: IDENTIFIER
            {
            IDENTIFIER145=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier7952); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              retval.id = IDENTIFIER145;
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"


    // $ANTLR start "anyValue"
    // ./grammer/T34fpb.g:1199:1: anyValue : ANY_VALUE ;
    public final void anyValue() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1200:5: ( ANY_VALUE )
            // ./grammer/T34fpb.g:1200:9: ANY_VALUE
            {
            match(input,ANY_VALUE,FOLLOW_ANY_VALUE_in_anyValue7973); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "anyValue"


    // $ANTLR start "anyOrOmit"
    // ./grammer/T34fpb.g:1203:1: anyOrOmit : ANY_OR_OMIT ;
    public final void anyOrOmit() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1204:5: ( ANY_OR_OMIT )
            // ./grammer/T34fpb.g:1204:9: ANY_OR_OMIT
            {
            match(input,ANY_OR_OMIT,FOLLOW_ANY_OR_OMIT_in_anyOrOmit7996); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "anyOrOmit"


    // $ANTLR start "compoundExpression"
    // ./grammer/T34fpb.g:1207:1: compoundExpression returns [PMatcher matcher] : ( fieldExpressionList | arrayExpression );
    public final PMatcher compoundExpression() throws RecognitionException {
        PMatcher matcher = null;

        T34fpbParser.fieldExpressionList_return fieldExpressionList146 = null;

        T34fpbParser.arrayExpression_return arrayExpression147 = null;


        try {
            // ./grammer/T34fpb.g:1208:5: ( fieldExpressionList | arrayExpression )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==99) ) {
                switch ( input.LA(2) ) {
                case OMIT:
                case TRUE:
                case FALSE:
                case PASS:
                case FAIL:
                case INCONC:
                case NONE:
                case ERROR:
                case CHAR:
                case MINUS:
                case CSTRING:
                case BSTRING:
                case HSTRING:
                case OSTRING:
                case INTEGER_VALUE:
                case FLOAT_VALUE:
                case 99:
                case 100:
                case 106:
                    {
                    alt85=2;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA85_3 = input.LA(3);

                    if ( (LA85_3==DOT||LA85_3==COMMA||LA85_3==100||LA85_3==103) ) {
                        alt85=2;
                    }
                    else if ( (LA85_3==ASSIGNMENT_CHAR) ) {
                        alt85=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return matcher;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 85, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 103:
                    {
                    alt85=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return matcher;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 85, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return matcher;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // ./grammer/T34fpb.g:1208:9: fieldExpressionList
                    {
                    pushFollow(FOLLOW_fieldExpressionList_in_compoundExpression8023);
                    fieldExpressionList146=fieldExpressionList();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = (fieldExpressionList146!=null?fieldExpressionList146.matcher:null); 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1209:13: arrayExpression
                    {
                    pushFollow(FOLLOW_arrayExpression_in_compoundExpression8039);
                    arrayExpression147=arrayExpression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = (arrayExpression147!=null?arrayExpression147.matcher:null); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "compoundExpression"

    public static class fieldExpressionList_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "fieldExpressionList"
    // ./grammer/T34fpb.g:1212:1: fieldExpressionList returns [PMatcher matcher] : '{' fieldExpressionSpec[$matcher, $TypeScope::typeName] ( COMMA fieldExpressionSpec[$matcher, $TypeScope::typeName] )* '}' ;
    public final T34fpbParser.fieldExpressionList_return fieldExpressionList() throws RecognitionException {
        T34fpbParser.fieldExpressionList_return retval = new T34fpbParser.fieldExpressionList_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1213:5: ( '{' fieldExpressionSpec[$matcher, $TypeScope::typeName] ( COMMA fieldExpressionSpec[$matcher, $TypeScope::typeName] )* '}' )
            // ./grammer/T34fpb.g:1214:6: '{' fieldExpressionSpec[$matcher, $TypeScope::typeName] ( COMMA fieldExpressionSpec[$matcher, $TypeScope::typeName] )* '}'
            {
            match(input,99,FOLLOW_99_in_fieldExpressionList8070); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.matcher = helper.fieldExpressionListRule(((Token)retval.start)); 
            }
            pushFollow(FOLLOW_fieldExpressionSpec_in_fieldExpressionList8080);
            fieldExpressionSpec(retval.matcher, ((TypeScope_scope)TypeScope_stack.peek()).typeName);

            state._fsp--;
            if (state.failed) return retval;
            // ./grammer/T34fpb.g:1216:9: ( COMMA fieldExpressionSpec[$matcher, $TypeScope::typeName] )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==COMMA) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ./grammer/T34fpb.g:1216:13: COMMA fieldExpressionSpec[$matcher, $TypeScope::typeName]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_fieldExpressionList8096); if (state.failed) return retval;
            	    pushFollow(FOLLOW_fieldExpressionSpec_in_fieldExpressionList8098);
            	    fieldExpressionSpec(retval.matcher, ((TypeScope_scope)TypeScope_stack.peek()).typeName);

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);

            match(input,100,FOLLOW_100_in_fieldExpressionList8121); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fieldExpressionList"

    public static class fieldExpressionSpec_return extends ParserRuleReturnScope {
        public Object fieldItem;
    };

    // $ANTLR start "fieldExpressionSpec"
    // ./grammer/T34fpb.g:1221:1: fieldExpressionSpec[PMatcher parentMatcher, String parentTypeName] returns [Object fieldItem] : fieldReference[$fieldItem, parentTypeName] ASSIGNMENT_CHAR notUsedOrExpression ;
    public final T34fpbParser.fieldExpressionSpec_return fieldExpressionSpec(PMatcher parentMatcher, String parentTypeName) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        T34fpbParser.fieldExpressionSpec_return retval = new T34fpbParser.fieldExpressionSpec_return();
        retval.start = input.LT(1);

        PMatcher notUsedOrExpression148 = null;


        try {
            // ./grammer/T34fpb.g:1223:5: ( fieldReference[$fieldItem, parentTypeName] ASSIGNMENT_CHAR notUsedOrExpression )
            // ./grammer/T34fpb.g:1223:9: fieldReference[$fieldItem, parentTypeName] ASSIGNMENT_CHAR notUsedOrExpression
            {
            if ( state.backtracking==0 ) {
               retval.fieldItem = helper.fieldExpressionSpecRule1(((Token)retval.start), parentMatcher); 
            }
            pushFollow(FOLLOW_fieldReference_in_fieldExpressionSpec8158);
            fieldReference(retval.fieldItem, parentTypeName);

            state._fsp--;
            if (state.failed) return retval;
            match(input,ASSIGNMENT_CHAR,FOLLOW_ASSIGNMENT_CHAR_in_fieldExpressionSpec8167); if (state.failed) return retval;
            pushFollow(FOLLOW_notUsedOrExpression_in_fieldExpressionSpec8175);
            notUsedOrExpression148=notUsedOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
                helper.fieldExpressionSpecRule2(((Token)retval.start), notUsedOrExpression148, retval.fieldItem); 
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "fieldExpressionSpec"

    public static class fieldReference_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "fieldReference"
    // ./grammer/T34fpb.g:1230:1: fieldReference[Object fieldItem, String parentTypeName] : ( structFieldRef | arrayOrBitRef );
    public final T34fpbParser.fieldReference_return fieldReference(Object fieldItem, String parentTypeName) throws RecognitionException {
        T34fpbParser.fieldReference_return retval = new T34fpbParser.fieldReference_return();
        retval.start = input.LT(1);

        T34fpbParser.structFieldRef_return structFieldRef149 = null;

        PMatcher arrayOrBitRef150 = null;


        try {
            // ./grammer/T34fpb.g:1231:5: ( structFieldRef | arrayOrBitRef )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==IDENTIFIER) ) {
                alt87=1;
            }
            else if ( (LA87_0==103) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ./grammer/T34fpb.g:1231:9: structFieldRef
                    {
                    pushFollow(FOLLOW_structFieldRef_in_fieldReference8207);
                    structFieldRef149=structFieldRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       helper.fieldReferenceRule1(((Token)retval.start), (structFieldRef149!=null?input.toString(structFieldRef149.start,structFieldRef149.stop):null), parentTypeName, fieldItem); 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1232:13: arrayOrBitRef
                    {
                    pushFollow(FOLLOW_arrayOrBitRef_in_fieldReference8223);
                    arrayOrBitRef150=arrayOrBitRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                       helper.fieldReferenceRule2(((Token)retval.start), arrayOrBitRef150, parentTypeName, fieldItem); 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fieldReference"

    public static class structFieldRef_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "structFieldRef"
    // ./grammer/T34fpb.g:1235:1: structFieldRef : structFieldIdentifier ;
    public final T34fpbParser.structFieldRef_return structFieldRef() throws RecognitionException {
        T34fpbParser.structFieldRef_return retval = new T34fpbParser.structFieldRef_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1236:5: ( structFieldIdentifier )
            // ./grammer/T34fpb.g:1236:9: structFieldIdentifier
            {
            pushFollow(FOLLOW_structFieldIdentifier_in_structFieldRef8248);
            structFieldIdentifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "structFieldRef"

    public static class structFieldIdentifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "structFieldIdentifier"
    // ./grammer/T34fpb.g:1239:1: structFieldIdentifier : identifier ;
    public final T34fpbParser.structFieldIdentifier_return structFieldIdentifier() throws RecognitionException {
        T34fpbParser.structFieldIdentifier_return retval = new T34fpbParser.structFieldIdentifier_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1240:5: ( identifier )
            // ./grammer/T34fpb.g:1240:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_structFieldIdentifier8271);
            identifier();

            state._fsp--;
            if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "structFieldIdentifier"


    // $ANTLR start "notUsedOrExpression"
    // ./grammer/T34fpb.g:1243:1: notUsedOrExpression returns [PMatcher matcher] : ( expression | MINUS );
    public final PMatcher notUsedOrExpression() throws RecognitionException {
        PMatcher matcher = null;

        PMatcher expression151 = null;


        try {
            // ./grammer/T34fpb.g:1244:5: ( expression | MINUS )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==MINUS) ) {
                int LA88_1 = input.LA(2);

                if ( ((LA88_1>=OMIT && LA88_1<=CHAR)||LA88_1==IDENTIFIER||LA88_1==CSTRING||LA88_1==BSTRING||LA88_1==HSTRING||LA88_1==OSTRING||LA88_1==INTEGER_VALUE||LA88_1==FLOAT_VALUE) ) {
                    alt88=1;
                }
                else if ( (LA88_1==COMMA||LA88_1==100) ) {
                    alt88=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return matcher;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA88_0>=OMIT && LA88_0<=CHAR)||LA88_0==IDENTIFIER||LA88_0==CSTRING||LA88_0==BSTRING||LA88_0==HSTRING||LA88_0==OSTRING||LA88_0==INTEGER_VALUE||(LA88_0>=FLOAT_VALUE && LA88_0<=99)||LA88_0==106) ) {
                alt88=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return matcher;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ./grammer/T34fpb.g:1244:9: expression
                    {
                    pushFollow(FOLLOW_expression_in_notUsedOrExpression8298);
                    expression151=expression();

                    state._fsp--;
                    if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = expression151; 
                    }

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1245:12: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_notUsedOrExpression8313); if (state.failed) return matcher;
                    if ( state.backtracking==0 ) {
                       matcher = helper.createNotUseMatcher(); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return matcher;
    }
    // $ANTLR end "notUsedOrExpression"

    public static class arrayExpression_return extends ParserRuleReturnScope {
        public PMatcher matcher;
    };

    // $ANTLR start "arrayExpression"
    // ./grammer/T34fpb.g:1248:1: arrayExpression returns [PMatcher matcher] : '{' ( arrayElementExpressionList[$matcher] )? '}' ;
    public final T34fpbParser.arrayExpression_return arrayExpression() throws RecognitionException {
        T34fpbParser.arrayExpression_return retval = new T34fpbParser.arrayExpression_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1249:5: ( '{' ( arrayElementExpressionList[$matcher] )? '}' )
            // ./grammer/T34fpb.g:1249:9: '{' ( arrayElementExpressionList[$matcher] )? '}'
            {
            match(input,99,FOLLOW_99_in_arrayExpression8342); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               retval.matcher = helper.arrayExpressionRule(((Token)retval.start)); 
            }
            // ./grammer/T34fpb.g:1250:7: ( arrayElementExpressionList[$matcher] )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( ((LA89_0>=OMIT && LA89_0<=CHAR)||LA89_0==MINUS||LA89_0==IDENTIFIER||LA89_0==CSTRING||LA89_0==BSTRING||LA89_0==HSTRING||LA89_0==OSTRING||LA89_0==INTEGER_VALUE||(LA89_0>=FLOAT_VALUE && LA89_0<=99)||LA89_0==106) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ./grammer/T34fpb.g:1251:8: arrayElementExpressionList[$matcher]
                    {
                    pushFollow(FOLLOW_arrayElementExpressionList_in_arrayExpression8362);
                    arrayElementExpressionList(retval.matcher);

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }

            match(input,100,FOLLOW_100_in_arrayExpression8381); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayExpression"


    // $ANTLR start "arrayElementExpressionList"
    // ./grammer/T34fpb.g:1256:1: arrayElementExpressionList[PMatcher parentMatcher] : arrayElementExpressionSpec[$parentMatcher, $TypeScope::typeName, elementIndex] ( COMMA arrayElementExpressionSpec[$parentMatcher, $TypeScope::typeName, elementIndex] )* ;
    public final void arrayElementExpressionList(PMatcher parentMatcher) throws RecognitionException {

        	int elementIndex = 0;

        try {
            // ./grammer/T34fpb.g:1260:5: ( arrayElementExpressionSpec[$parentMatcher, $TypeScope::typeName, elementIndex] ( COMMA arrayElementExpressionSpec[$parentMatcher, $TypeScope::typeName, elementIndex] )* )
            // ./grammer/T34fpb.g:1260:9: arrayElementExpressionSpec[$parentMatcher, $TypeScope::typeName, elementIndex] ( COMMA arrayElementExpressionSpec[$parentMatcher, $TypeScope::typeName, elementIndex] )*
            {
            pushFollow(FOLLOW_arrayElementExpressionSpec_in_arrayElementExpressionList8410);
            arrayElementExpressionSpec(parentMatcher, ((TypeScope_scope)TypeScope_stack.peek()).typeName, elementIndex);

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               elementIndex++; 
            }
            // ./grammer/T34fpb.g:1261:9: ( COMMA arrayElementExpressionSpec[$parentMatcher, $TypeScope::typeName, elementIndex] )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==COMMA) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // ./grammer/T34fpb.g:1261:13: COMMA arrayElementExpressionSpec[$parentMatcher, $TypeScope::typeName, elementIndex]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_arrayElementExpressionList8428); if (state.failed) return ;
            	    pushFollow(FOLLOW_arrayElementExpressionSpec_in_arrayElementExpressionList8442);
            	    arrayElementExpressionSpec(parentMatcher, ((TypeScope_scope)TypeScope_stack.peek()).typeName, elementIndex);

            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	       elementIndex++; 
            	    }

            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "arrayElementExpressionList"

    public static class arrayElementExpressionSpec_return extends ParserRuleReturnScope {
        public Object fieldItem;
    };

    // $ANTLR start "arrayElementExpressionSpec"
    // ./grammer/T34fpb.g:1266:1: arrayElementExpressionSpec[PMatcher parentMatcher, String parentTypeName, int elementIndex] returns [Object fieldItem] : notUsedOrExpression ;
    public final T34fpbParser.arrayElementExpressionSpec_return arrayElementExpressionSpec(PMatcher parentMatcher, String parentTypeName, int elementIndex) throws RecognitionException {
        TypeScope_stack.push(new TypeScope_scope());

        T34fpbParser.arrayElementExpressionSpec_return retval = new T34fpbParser.arrayElementExpressionSpec_return();
        retval.start = input.LT(1);

        PMatcher notUsedOrExpression152 = null;


        try {
            // ./grammer/T34fpb.g:1268:2: ( notUsedOrExpression )
            // ./grammer/T34fpb.g:1268:4: notUsedOrExpression
            {
            if ( state.backtracking==0 ) {
               retval.fieldItem = helper.arrayElementExpressionSpecRule1(((Token)retval.start), parentMatcher, parentTypeName, elementIndex); 
            }
            pushFollow(FOLLOW_notUsedOrExpression_in_arrayElementExpressionSpec8486);
            notUsedOrExpression152=notUsedOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) {
               
              			helper.arrayElementExpressionSpecRule2(((Token)retval.start), notUsedOrExpression152, retval.fieldItem); 
              		
            }

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            TypeScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "arrayElementExpressionSpec"

    public static class type_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "type"
    // ./grammer/T34fpb.g:1277:1: type : ( predefinedType | referencedType );
    public final T34fpbParser.type_return type() throws RecognitionException {
        T34fpbParser.type_return retval = new T34fpbParser.type_return();
        retval.start = input.LT(1);

        try {
            // ./grammer/T34fpb.g:1278:5: ( predefinedType | referencedType )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( ((LA91_0>=BIT_STRING && LA91_0<=UNIVERSAL)) ) {
                alt91=1;
            }
            else if ( (LA91_0==IDENTIFIER) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ./grammer/T34fpb.g:1278:9: predefinedType
                    {
                    pushFollow(FOLLOW_predefinedType_in_type8508);
                    predefinedType();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1279:13: referencedType
                    {
                    pushFollow(FOLLOW_referencedType_in_type8523);
                    referencedType();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"


    // $ANTLR start "predefinedType"
    // ./grammer/T34fpb.g:1282:1: predefinedType : ( BIT_STRING | HEX_STRING | OCTET_STRING | BOOLEAN | CHAR_STRING | UNIVERSAL CHAR_STRING | INTEGER | VERDICT_TYPE | FLOAT );
    public final void predefinedType() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1283:5: ( BIT_STRING | HEX_STRING | OCTET_STRING | BOOLEAN | CHAR_STRING | UNIVERSAL CHAR_STRING | INTEGER | VERDICT_TYPE | FLOAT )
            int alt92=9;
            switch ( input.LA(1) ) {
            case BIT_STRING:
                {
                alt92=1;
                }
                break;
            case HEX_STRING:
                {
                alt92=2;
                }
                break;
            case OCTET_STRING:
                {
                alt92=3;
                }
                break;
            case BOOLEAN:
                {
                alt92=4;
                }
                break;
            case CHAR_STRING:
                {
                alt92=5;
                }
                break;
            case UNIVERSAL:
                {
                alt92=6;
                }
                break;
            case INTEGER:
                {
                alt92=7;
                }
                break;
            case VERDICT_TYPE:
                {
                alt92=8;
                }
                break;
            case FLOAT:
                {
                alt92=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // ./grammer/T34fpb.g:1283:9: BIT_STRING
                    {
                    match(input,BIT_STRING,FOLLOW_BIT_STRING_in_predefinedType8547); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:1284:13: HEX_STRING
                    {
                    match(input,HEX_STRING,FOLLOW_HEX_STRING_in_predefinedType8561); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:1285:13: OCTET_STRING
                    {
                    match(input,OCTET_STRING,FOLLOW_OCTET_STRING_in_predefinedType8575); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:1286:13: BOOLEAN
                    {
                    match(input,BOOLEAN,FOLLOW_BOOLEAN_in_predefinedType8589); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:1287:13: CHAR_STRING
                    {
                    match(input,CHAR_STRING,FOLLOW_CHAR_STRING_in_predefinedType8603); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // ./grammer/T34fpb.g:1288:13: UNIVERSAL CHAR_STRING
                    {
                    match(input,UNIVERSAL,FOLLOW_UNIVERSAL_in_predefinedType8617); if (state.failed) return ;
                    match(input,CHAR_STRING,FOLLOW_CHAR_STRING_in_predefinedType8619); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // ./grammer/T34fpb.g:1289:13: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_predefinedType8633); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // ./grammer/T34fpb.g:1290:13: VERDICT_TYPE
                    {
                    match(input,VERDICT_TYPE,FOLLOW_VERDICT_TYPE_in_predefinedType8647); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // ./grammer/T34fpb.g:1291:13: FLOAT
                    {
                    match(input,FLOAT,FOLLOW_FLOAT_in_predefinedType8661); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "predefinedType"


    // $ANTLR start "referencedType"
    // ./grammer/T34fpb.g:1297:1: referencedType : ( globalModuleId DOT )? typeReference ;
    public final void referencedType() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1298:5: ( ( globalModuleId DOT )? typeReference )
            // ./grammer/T34fpb.g:1298:9: ( globalModuleId DOT )? typeReference
            {
            // ./grammer/T34fpb.g:1298:9: ( globalModuleId DOT )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==IDENTIFIER) ) {
                int LA93_1 = input.LA(2);

                if ( (LA93_1==DOT) ) {
                    alt93=1;
                }
            }
            switch (alt93) {
                case 1 :
                    // ./grammer/T34fpb.g:1298:11: globalModuleId DOT
                    {
                    pushFollow(FOLLOW_globalModuleId_in_referencedType8691);
                    globalModuleId();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,DOT,FOLLOW_DOT_in_referencedType8693); if (state.failed) return ;

                    }
                    break;

            }

            pushFollow(FOLLOW_typeReference_in_referencedType8698);
            typeReference();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "referencedType"


    // $ANTLR start "globalModuleId"
    // ./grammer/T34fpb.g:1301:1: globalModuleId : identifier ;
    public final void globalModuleId() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1302:5: ( identifier )
            // ./grammer/T34fpb.g:1302:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_globalModuleId8722);
            identifier();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "globalModuleId"


    // $ANTLR start "typeReference"
    // ./grammer/T34fpb.g:1305:1: typeReference : typeReferenceId ;
    public final void typeReference() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1306:5: ( typeReferenceId )
            // ./grammer/T34fpb.g:1306:9: typeReferenceId
            {
            pushFollow(FOLLOW_typeReferenceId_in_typeReference8746);
            typeReferenceId();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "typeReference"


    // $ANTLR start "typeReferenceId"
    // ./grammer/T34fpb.g:1309:1: typeReferenceId : identifier ;
    public final void typeReferenceId() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:1310:5: ( identifier )
            // ./grammer/T34fpb.g:1310:9: identifier
            {
            pushFollow(FOLLOW_identifier_in_typeReferenceId8770);
            identifier();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "typeReferenceId"

    // $ANTLR start synpred1_T34fpb
    public final void synpred1_T34fpb_fragment() throws RecognitionException {   
        // ./grammer/T34fpb.g:744:9: ( lowerBound RANGE_OP )
        // ./grammer/T34fpb.g:744:10: lowerBound RANGE_OP
        {
        pushFollow(FOLLOW_lowerBound_in_synpred1_T34fpb4879);
        lowerBound();

        state._fsp--;
        if (state.failed) return ;
        match(input,RANGE_OP,FOLLOW_RANGE_OP_in_synpred1_T34fpb4881); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_T34fpb

    // $ANTLR start synpred2_T34fpb
    public final void synpred2_T34fpb_fragment() throws RecognitionException {   
        // ./grammer/T34fpb.g:1171:11: ( globalModuleId DOT )
        // ./grammer/T34fpb.g:1171:12: globalModuleId DOT
        {
        pushFollow(FOLLOW_globalModuleId_in_synpred2_T34fpb7777);
        globalModuleId();

        state._fsp--;
        if (state.failed) return ;
        match(input,DOT,FOLLOW_DOT_in_synpred2_T34fpb7779); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_T34fpb

    // Delegated rules

    public final boolean synpred2_T34fpb() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_T34fpb_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_T34fpb() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_T34fpb_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA50 dfa50 = new DFA50(this);
    protected DFA77 dfa77 = new DFA77(this);
    protected DFA78 dfa78 = new DFA78(this);
    static final String DFA50_eotS =
        "\25\uffff";
    static final String DFA50_eofS =
        "\25\uffff";
    static final String DFA50_minS =
        "\1\5\22\0\2\uffff";
    static final String DFA50_maxS =
        "\1\152\22\0\2\uffff";
    static final String DFA50_acceptS =
        "\23\uffff\1\2\1\1";
    static final String DFA50_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\2\uffff}>";
    static final String[] DFA50_transitionS = {
            "\1\21\1\5\1\6\1\12\1\13\1\14\1\15\1\16\1\10\54\uffff\1\1\12"+
            "\uffff\1\17\2\uffff\1\7\15\uffff\1\3\1\uffff\1\2\1\uffff\1\4"+
            "\5\uffff\1\11\1\uffff\1\20\1\23\6\uffff\1\22",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA50_eot = DFA.unpackEncodedString(DFA50_eotS);
    static final short[] DFA50_eof = DFA.unpackEncodedString(DFA50_eofS);
    static final char[] DFA50_min = DFA.unpackEncodedStringToUnsignedChars(DFA50_minS);
    static final char[] DFA50_max = DFA.unpackEncodedStringToUnsignedChars(DFA50_maxS);
    static final short[] DFA50_accept = DFA.unpackEncodedString(DFA50_acceptS);
    static final short[] DFA50_special = DFA.unpackEncodedString(DFA50_specialS);
    static final short[][] DFA50_transition;

    static {
        int numStates = DFA50_transitionS.length;
        DFA50_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA50_transition[i] = DFA.unpackEncodedString(DFA50_transitionS[i]);
        }
    }

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = DFA50_eot;
            this.eof = DFA50_eof;
            this.min = DFA50_min;
            this.max = DFA50_max;
            this.accept = DFA50_accept;
            this.special = DFA50_special;
            this.transition = DFA50_transition;
        }
        public String getDescription() {
            return "743:1: valueOrRange returns [PMatcher matcher] : ( ( lowerBound RANGE_OP )=> rangeDef | constExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA50_1 = input.LA(1);

                         
                        int index50_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA50_2 = input.LA(1);

                         
                        int index50_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA50_3 = input.LA(1);

                         
                        int index50_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA50_4 = input.LA(1);

                         
                        int index50_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA50_5 = input.LA(1);

                         
                        int index50_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA50_6 = input.LA(1);

                         
                        int index50_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA50_7 = input.LA(1);

                         
                        int index50_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA50_8 = input.LA(1);

                         
                        int index50_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA50_9 = input.LA(1);

                         
                        int index50_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA50_10 = input.LA(1);

                         
                        int index50_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA50_11 = input.LA(1);

                         
                        int index50_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA50_12 = input.LA(1);

                         
                        int index50_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA50_13 = input.LA(1);

                         
                        int index50_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA50_14 = input.LA(1);

                         
                        int index50_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA50_15 = input.LA(1);

                         
                        int index50_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (((synpred1_T34fpb()&&( helper.nextTokenIsEnumeratedItemId() ))||synpred1_T34fpb())) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA50_16 = input.LA(1);

                         
                        int index50_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA50_17 = input.LA(1);

                         
                        int index50_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA50_18 = input.LA(1);

                         
                        int index50_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_T34fpb()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index50_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 50, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA77_eotS =
        "\53\uffff";
    static final String DFA77_eofS =
        "\53\uffff";
    static final String DFA77_minS =
        "\1\5\15\uffff\1\0\34\uffff";
    static final String DFA77_maxS =
        "\1\142\15\uffff\1\0\34\uffff";
    static final String DFA77_acceptS =
        "\1\uffff\1\1\50\uffff\1\2";
    static final String DFA77_specialS =
        "\16\uffff\1\0\34\uffff}>";
    static final String[] DFA77_transitionS = {
            "\11\1\67\uffff\1\16\2\uffff\1\1\15\uffff\1\1\1\uffff\1\1\1"+
            "\uffff\1\1\5\uffff\1\1\1\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA77_eot = DFA.unpackEncodedString(DFA77_eotS);
    static final short[] DFA77_eof = DFA.unpackEncodedString(DFA77_eofS);
    static final char[] DFA77_min = DFA.unpackEncodedStringToUnsignedChars(DFA77_minS);
    static final char[] DFA77_max = DFA.unpackEncodedStringToUnsignedChars(DFA77_maxS);
    static final short[] DFA77_accept = DFA.unpackEncodedString(DFA77_acceptS);
    static final short[] DFA77_special = DFA.unpackEncodedString(DFA77_specialS);
    static final short[][] DFA77_transition;

    static {
        int numStates = DFA77_transitionS.length;
        DFA77_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA77_transition[i] = DFA.unpackEncodedString(DFA77_transitionS[i]);
        }
    }

    class DFA77 extends DFA {

        public DFA77(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 77;
            this.eot = DFA77_eot;
            this.eof = DFA77_eof;
            this.min = DFA77_min;
            this.max = DFA77_max;
            this.accept = DFA77_accept;
            this.special = DFA77_special;
            this.transition = DFA77_transition;
        }
        public String getDescription() {
            return "1080:1: value returns [PMatcher matcher] options {k=2; } : ( predefinedValue | referencedValue );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA77_14 = input.LA(1);

                         
                        int index77_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (( helper.nextTokenIsEnumeratedItemId() )) ) {s = 1;}

                        else if ( (true) ) {s = 42;}

                         
                        input.seek(index77_14);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 77, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA78_eotS =
        "\13\uffff";
    static final String DFA78_eofS =
        "\13\uffff";
    static final String DFA78_minS =
        "\1\5\12\uffff";
    static final String DFA78_maxS =
        "\1\142\12\uffff";
    static final String DFA78_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12";
    static final String DFA78_specialS =
        "\13\uffff}>";
    static final String[] DFA78_transitionS = {
            "\1\12\2\4\5\7\1\5\67\uffff\1\10\2\uffff\1\5\15\uffff\1\2\1"+
            "\uffff\1\1\1\uffff\1\3\5\uffff\1\6\1\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA78_eot = DFA.unpackEncodedString(DFA78_eotS);
    static final short[] DFA78_eof = DFA.unpackEncodedString(DFA78_eofS);
    static final char[] DFA78_min = DFA.unpackEncodedStringToUnsignedChars(DFA78_minS);
    static final char[] DFA78_max = DFA.unpackEncodedStringToUnsignedChars(DFA78_maxS);
    static final short[] DFA78_accept = DFA.unpackEncodedString(DFA78_acceptS);
    static final short[] DFA78_special = DFA.unpackEncodedString(DFA78_specialS);
    static final short[][] DFA78_transition;

    static {
        int numStates = DFA78_transitionS.length;
        DFA78_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA78_transition[i] = DFA.unpackEncodedString(DFA78_transitionS[i]);
        }
    }

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = DFA78_eot;
            this.eof = DFA78_eof;
            this.min = DFA78_min;
            this.max = DFA78_max;
            this.accept = DFA78_accept;
            this.special = DFA78_special;
            this.transition = DFA78_transition;
        }
        public String getDescription() {
            return "1086:1: predefinedValue returns [PMatcher matcher] : ( hexStringValue | bitStringValue | octetStringValue | booleanValue | charStringValue | integerValue | verdictTypeValue | {...}? enumeratedValue | floatValue | omitValue );";
        }
    }
 

    public static final BitSet FOLLOW_MODULE_in_module2114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_moduleId_in_module2116 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_module2129 = new BitSet(new long[]{0x004809C000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_moduleDefinitionsPart_in_module2142 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_module2156 = new BitSet(new long[]{0x0080000400000002L});
    public static final BitSet FOLLOW_withStatement_in_module2168 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_SEMI_COLON_in_module2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalModuleId_in_moduleId2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleDefinitionsList_in_moduleDefinitionsPart2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleDefinition_in_moduleDefinitionsList2254 = new BitSet(new long[]{0x00C809C000000002L});
    public static final BitSet FOLLOW_SEMI_COLON_in_moduleDefinitionsList2258 = new BitSet(new long[]{0x004809C000000002L});
    public static final BitSet FOLLOW_moduleDefinition_in_moduleDefinitionsList2275 = new BitSet(new long[]{0x00C809C000000002L});
    public static final BitSet FOLLOW_SEMI_COLON_in_moduleDefinitionsList2279 = new BitSet(new long[]{0x004809C000000002L});
    public static final BitSet FOLLOW_typeDef_in_moduleDefinition2318 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_withStatement_in_moduleDefinition2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumSetDef_in_moduleDefinition2341 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_withStatement_in_moduleDefinition2345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constDef_in_moduleDefinition2362 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_withStatement_in_moduleDefinition2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_moduleParDef_in_moduleDefinition2383 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_withStatement_in_moduleDefinition2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importDef_in_moduleDefinition2404 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_withStatement_in_moduleDefinition2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDef2456 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_importFromSpec_in_importDef2458 = new BitSet(new long[]{0x0000020000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_importSpec_in_importDef2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_importFromSpec2497 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_moduleId_in_importFromSpec2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_importSpec2535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_importSpec2546 = new BitSet(new long[]{0x000801C000004000L,0x0000001000000000L});
    public static final BitSet FOLLOW_importElement_in_importSpec2558 = new BitSet(new long[]{0x008801C000004000L,0x0000001000000000L});
    public static final BitSet FOLLOW_SEMI_COLON_in_importSpec2564 = new BitSet(new long[]{0x000801C000004000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_importSpec2590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importModuleParSpec_in_importElement2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importTypeDefSpec_in_importElement2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importTemplateSpec_in_importElement2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importConstSpec_in_importElement2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_importEnumSetSpec_in_importElement2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MODULE_PAR_in_importModuleParSpec2704 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_identifierRefList_in_importModuleParSpec2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_importModuleParSpec2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_importConstSpec2772 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_identifierRefList_in_importConstSpec2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_importConstSpec2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_importTypeDefSpec2848 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_identifierRefList_in_importTypeDefSpec2863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_importTypeDefSpec2883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEMPLATE_in_importTemplateSpec2924 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_identifierRefList_in_importTemplateSpec2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_importTemplateSpec2958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUM_SET_in_importEnumSetSpec2995 = new BitSet(new long[]{0x0000020000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_identifierRefList_in_importEnumSetSpec3009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_importEnumSetSpec3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_identifierRefList3071 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_identifierRefList3082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_identifier_in_identifierRefList3088 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_CONST_in_constDef3129 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_constDef3131 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_constList_in_constDef3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleConstDef_in_constList3178 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_constList3192 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_singleConstDef_in_constList3198 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_constIdentifer_in_singleConstDef3238 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ASSIGNMENT_CHAR_in_singleConstDef3247 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040D05400120L});
    public static final BitSet FOLLOW_constExpression_in_singleConstDef3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_constIdentifer3270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_modulePar3304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_moduleParList_in_modulePar3313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THREAD_in_moduleParDef3341 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_MODULE_PAR_in_moduleParDef3351 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000800000020L});
    public static final BitSet FOLLOW_modulePar_in_moduleParDef3361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_moduleParDef3379 = new BitSet(new long[]{0x0000000000FF8000L,0x0000001000000020L});
    public static final BitSet FOLLOW_multitypedModuleParList_in_moduleParDef3381 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_moduleParDef3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleModuleParDef_in_moduleParList3449 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_moduleParList3466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_singleModuleParDef_in_moduleParList3472 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_moduleParIdentifier_in_singleModuleParDef3511 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ASSIGNMENT_CHAR_in_singleModuleParDef3519 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040D05400120L});
    public static final BitSet FOLLOW_constExpression_in_singleModuleParDef3521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_moduleParIdentifier3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modulePar_in_multitypedModuleParList3588 = new BitSet(new long[]{0x0080000000FF8002L,0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_COLON_in_multitypedModuleParList3594 = new BitSet(new long[]{0x0000000000FF8002L,0x0000000000000020L});
    public static final BitSet FOLLOW_TYPE_in_typeDef3633 = new BitSet(new long[]{0x0001E00000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_typeDefBody_in_typeDef3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structuredTypeDef_in_typeDefBody3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subTypeDef_in_typeDefBody3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recordDef_in_structuredTypeDef3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unionDef_in_structuredTypeDef3727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setDef_in_structuredTypeDef3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recordOfDef_in_structuredTypeDef3762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setOfDef_in_structuredTypeDef3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDef_in_structuredTypeDef3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORD_in_recordDef3824 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structDefBody_in_recordDef3826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structTypeIdentifier_in_structDefBody3858 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_structDefBody3867 = new BitSet(new long[]{0x0000000000FF8000L,0x0000001000000020L});
    public static final BitSet FOLLOW_structFieldDef_in_structDefBody3882 = new BitSet(new long[]{0x4000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_COMMA_in_structDefBody3887 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structFieldDef_in_structDefBody3889 = new BitSet(new long[]{0x4000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_structDefBody3915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_structTypeIdentifier3935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_structFieldDef3969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structFieldIdentifier_in_structFieldDef3978 = new BitSet(new long[]{0x0004000040000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_subTypeSpec_in_structFieldDef3990 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_structFieldDef4006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_unionDef4052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_unionDefBody_in_unionDef4054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structTypeIdentifier_in_unionDefBody4083 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_unionDefBody4092 = new BitSet(new long[]{0x0000000000FF8000L,0x0000001000000020L});
    public static final BitSet FOLLOW_unionFieldDef_in_unionDefBody4106 = new BitSet(new long[]{0x4000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_COMMA_in_unionDefBody4111 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_unionFieldDef_in_unionDefBody4113 = new BitSet(new long[]{0x4000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_unionDefBody4138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_unionFieldDef4168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structFieldIdentifier_in_unionFieldDef4177 = new BitSet(new long[]{0x0000000040000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_subTypeSpec_in_unionFieldDef4189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_setDef4230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structDefBody_in_setDef4232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORD_in_recordOfDef4263 = new BitSet(new long[]{0x0002000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_stringLength_in_recordOfDef4273 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_OF_in_recordOfDef4287 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structOfDefBody_in_recordOfDef4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_structOfDefBody4327 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structTypeIdentifier_in_structOfDefBody4336 = new BitSet(new long[]{0x0000000040000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_subTypeSpec_in_structOfDefBody4346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_setOfDef4384 = new BitSet(new long[]{0x0002000040000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_stringLength_in_setOfDef4388 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_OF_in_setOfDef4401 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structOfDefBody_in_setOfDef4403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUMERATED_in_enumDef4434 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_enumTypeIdentifier_in_enumDef4442 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_enumDef4451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_enumerationList_in_enumDef4453 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_enumDef4457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_enumTypeIdentifier4480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeration_in_enumerationList4505 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_enumerationList4511 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_enumeration_in_enumerationList4513 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_enumerationIdentifier_in_enumeration4543 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_enumeration4558 = new BitSet(new long[]{0x0400000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_MINUS_in_enumeration4562 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_INTEGER_VALUE_in_enumeration4567 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_enumeration4569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_subTypeDef4626 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_subTypeIdentifier_in_subTypeDef4635 = new BitSet(new long[]{0x0000000040000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_subTypeSpec_in_subTypeDef4645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_subTypeIdentifier4678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_allowedValues_in_subTypeSpec4705 = new BitSet(new long[]{0x0000000040000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_stringLength_in_subTypeSpec4709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringLength_in_subTypeSpec4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_allowedValues4756 = new BitSet(new long[]{0x0400000100003FE0L,0x0000040D05400120L});
    public static final BitSet FOLLOW_valueOrRange_in_allowedValues4768 = new BitSet(new long[]{0x4000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_COMMA_in_allowedValues4782 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040D05400120L});
    public static final BitSet FOLLOW_valueOrRange_in_allowedValues4788 = new BitSet(new long[]{0x4000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_charStringMatch_in_allowedValues4825 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_allowedValues4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rangeDef_in_valueOrRange4886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constExpression_in_valueOrRange4902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lowerBound_in_rangeDef4931 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_RANGE_OP_in_rangeDef4933 = new BitSet(new long[]{0x0400000080003FE0L,0x0000040505400120L});
    public static final BitSet FOLLOW_upperBound_in_rangeDef4935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LENGTH_in_stringLength4974 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_stringLength4986 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040505400120L});
    public static final BitSet FOLLOW_singleConstExpression_in_stringLength4988 = new BitSet(new long[]{0x8000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_RANGE_OP_in_stringLength5002 = new BitSet(new long[]{0x0400000080003FE0L,0x0000040505400120L});
    public static final BitSet FOLLOW_upperBound_in_stringLength5004 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_stringLength5019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATTERN_in_charStringMatch5057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_freeText_in_charStringMatch5059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleConstExpression_in_lowerBound5086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_lowerBound5104 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_INFINITY_in_lowerBound5106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleConstExpression_in_upperBound5150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INFINITY_in_upperBound5166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_withStatement5206 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_withAttribList_in_withStatement5208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_withAttribList5235 = new BitSet(new long[]{0x0030003800000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_multiWithAttrib_in_withAttribList5237 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_withAttribList5241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleWithAttrib_in_multiWithAttrib5268 = new BitSet(new long[]{0x00B0003800000002L});
    public static final BitSet FOLLOW_SEMI_COLON_in_multiWithAttrib5274 = new BitSet(new long[]{0x0030003800000002L});
    public static final BitSet FOLLOW_encodeAttrib_in_singleWithAttrib5301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variantAttrib_in_singleWithAttrib5317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumAttrib_in_singleWithAttrib5333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumRefAttrib_in_singleWithAttrib5349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_runtimeAttrib_in_singleWithAttrib5363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENCODE_in_encodeAttrib5390 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000100L});
    public static final BitSet FOLLOW_attribQualifier_in_encodeAttrib5394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_freeText_in_encodeAttrib5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIANT_in_variantAttrib5431 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000020L});
    public static final BitSet FOLLOW_attribQualifier_in_variantAttrib5435 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000020L});
    public static final BitSet FOLLOW_propertyList_in_variantAttrib5447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RUNTIME_in_runtimeAttrib5466 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000020L});
    public static final BitSet FOLLOW_attribQualifier_in_runtimeAttrib5470 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000020L});
    public static final BitSet FOLLOW_simplePropertyList_in_runtimeAttrib5475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUM_in_enumAttrib5504 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_enumAttrib5506 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_defOrFieldRef_in_enumAttrib5508 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_enumAttrib5510 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_enumAttrib5519 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_enumItemList_in_enumAttrib5521 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_enumAttrib5523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUM_SET_REF_in_enumRefAttrib5550 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_enumRefAttrib5552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_defOrFieldRef_in_enumRefAttrib5554 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_enumRefAttrib5556 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_enumSetReference_in_enumRefAttrib5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalModuleId_in_enumSetReference5580 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_DOT_in_enumSetReference5582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_enumSetIdentifier_in_enumSetReference5587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_attribQualifier5608 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_defOrFieldRefList_in_attribQualifier5610 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_attribQualifier5612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defOrFieldRef_in_defOrFieldRefList5649 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_defOrFieldRefList5663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_defOrFieldRef_in_defOrFieldRefList5669 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_identifier_in_defOrFieldRef5705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CSTRING_in_freeText5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_propertyList5778 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_SEMI_COLON_in_propertyList5784 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000020L});
    public static final BitSet FOLLOW_property_in_propertyList5786 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_propertyIdentifier_in_property5820 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_argumentGroupList_in_property5829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_propertyIdentifier5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argumentGroup_in_argumentGroupList5880 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_argumentGroup_in_argumentGroupList5886 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_argumentGroup5927 = new BitSet(new long[]{0x0400000000FFA0C0L,0x000000A100000123L});
    public static final BitSet FOLLOW_argumentList_in_argumentGroup5929 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_argumentGroup5933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_argumentList5958 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_argumentList5964 = new BitSet(new long[]{0x0400000000FFA0C0L,0x000000A100000123L});
    public static final BitSet FOLLOW_argument_in_argumentList5966 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_singleArgument_in_argument5996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listArgument_in_argument6012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerArgument_in_singleArgument6039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanArgument_in_singleArgument6055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charStringArgument_in_singleArgument6071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierArgument_in_singleArgument6087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionArgument_in_singleArgument6103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueRefArgument_in_singleArgument6117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRefArgument_in_singleArgument6131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_integerArgument6172 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_integerValue_in_integerArgument6183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValue_in_booleanArgument6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charStringValue_in_charStringArgument6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_identifierArgument6283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionType_in_conditionArgument6310 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_allowedValues_in_conditionArgument6322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_conditionType6343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_listArgument6379 = new BitSet(new long[]{0x0400000000FFA0C0L,0x000001A100000123L});
    public static final BitSet FOLLOW_argumentList_in_listArgument6383 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_listArgument6390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_REF_ARG_PREFIX_in_valueRefArgument6415 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040505400120L});
    public static final BitSet FOLLOW_valueReference_in_valueRefArgument6423 = new BitSet(new long[]{0x0200000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_extendedFieldReference_in_valueRefArgument6434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_REF_ARG_PREFIX_in_typeRefArgument6466 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_typeRefArgument6468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleProperty_in_simplePropertyList6492 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000020L});
    public static final BitSet FOLLOW_simpleProperty_in_simplePropertyList6498 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000020L});
    public static final BitSet FOLLOW_simplePropertyIdentifier_in_simpleProperty6518 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_simpleProperty6520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_freeText_in_simpleProperty6522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_simplePropertyIdentifier6536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUM_SET_in_enumSetDef6563 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_type_in_enumSetDef6565 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_enumSetIdentifier_in_enumSetDef6571 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_enumSetDef6576 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_enumItemList_in_enumSetDef6578 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_enumSetDef6581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_enumSetIdentifier6610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumItem_in_enumItemList6642 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_enumItemList6648 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_enumItem_in_enumItemList6650 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_allowedValues_in_enumItem6680 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_enumItemName_in_enumItem6682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_freeText_in_enumItemName6711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_enumItemIdentifier6736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleExpression_in_singleConstExpression6776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleConstExpression_in_constExpression6805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundConstExpression_in_constExpression6821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleExpression_in_expression6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundExpression_in_expression6862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldExpressionList_in_compoundConstExpression6891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayExpression_in_compoundConstExpression6907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_singleExpression6936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryOp_in_unaryExpression6958 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040505400120L});
    public static final BitSet FOLLOW_primary_in_unaryExpression6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unaryOp0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_primary6999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedValue_in_value7030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referencedValue_in_value7046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hexStringValue_in_predefinedValue7071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bitStringValue_in_predefinedValue7087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_octetStringValue_in_predefinedValue7103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValue_in_predefinedValue7119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_charStringValue_in_predefinedValue7135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerValue_in_predefinedValue7151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_verdictTypeValue_in_predefinedValue7167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumeratedValue_in_predefinedValue7185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatValue_in_predefinedValue7201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_omitValue_in_predefinedValue7218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BSTRING_in_bitStringValue7253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OSTRING_in_octetStringValue7282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HSTRING_in_hexStringValue7311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_booleanValue7346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_booleanValue7364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_VALUE_in_integerValue7390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PASS_in_verdictTypeValue7425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FAIL_in_verdictTypeValue7443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCONC_in_verdictTypeValue7461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NONE_in_verdictTypeValue7479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERROR_in_verdictTypeValue7497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumerationIdentifier_in_enumeratedValue7527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_enumerationIdentifier7554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CSTRING_in_charStringValue7579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quadruple_in_charStringValue7595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_quadruple7620 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_quadruple7622 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_INTEGER_VALUE_in_quadruple7624 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_COMMA_in_quadruple7626 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_INTEGER_VALUE_in_quadruple7628 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_COMMA_in_quadruple7630 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_INTEGER_VALUE_in_quadruple7632 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_COMMA_in_quadruple7634 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_INTEGER_VALUE_in_quadruple7636 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_quadruple7638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_VALUE_in_floatValue7665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OMIT_in_omitValue7694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_valueReference_in_referencedValue7728 = new BitSet(new long[]{0x0200000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_extendedFieldReference_in_referencedValue7739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalModuleId_in_valueReference7785 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_DOT_in_valueReference7787 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_identifier_in_valueReference7792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_extendedFieldReference7831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_structFieldIdetifier_in_extendedFieldReference7833 = new BitSet(new long[]{0x0200000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_arrayOrBitRef_in_extendedFieldReference7850 = new BitSet(new long[]{0x0200000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_identifier_in_structFieldIdetifier7881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_arrayOrBitRef7914 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040505400120L});
    public static final BitSet FOLLOW_singleExpression_in_arrayOrBitRef7916 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_arrayOrBitRef7926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifier7952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_VALUE_in_anyValue7973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_OR_OMIT_in_anyOrOmit7996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldExpressionList_in_compoundExpression8023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayExpression_in_compoundExpression8039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_fieldExpressionList8070 = new BitSet(new long[]{0x0200000000000000L,0x0000008000000020L});
    public static final BitSet FOLLOW_fieldExpressionSpec_in_fieldExpressionList8080 = new BitSet(new long[]{0x4000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_COMMA_in_fieldExpressionList8096 = new BitSet(new long[]{0x0200000000000000L,0x0000008000000020L});
    public static final BitSet FOLLOW_fieldExpressionSpec_in_fieldExpressionList8098 = new BitSet(new long[]{0x4000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_fieldExpressionList8121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldReference_in_fieldExpressionSpec8158 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ASSIGNMENT_CHAR_in_fieldExpressionSpec8167 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040D05400120L});
    public static final BitSet FOLLOW_notUsedOrExpression_in_fieldExpressionSpec8175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structFieldRef_in_fieldReference8207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayOrBitRef_in_fieldReference8223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structFieldIdentifier_in_structFieldRef8248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_structFieldIdentifier8271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_notUsedOrExpression8298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_notUsedOrExpression8313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_arrayExpression8342 = new BitSet(new long[]{0x0400000000003FE0L,0x0000041D05400120L});
    public static final BitSet FOLLOW_arrayElementExpressionList_in_arrayExpression8362 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_arrayExpression8381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayElementExpressionSpec_in_arrayElementExpressionList8410 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_arrayElementExpressionList8428 = new BitSet(new long[]{0x0400000000003FE0L,0x0000040D05400120L});
    public static final BitSet FOLLOW_arrayElementExpressionSpec_in_arrayElementExpressionList8442 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_notUsedOrExpression_in_arrayElementExpressionSpec8486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predefinedType_in_type8508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_referencedType_in_type8523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIT_STRING_in_predefinedType8547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEX_STRING_in_predefinedType8561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTET_STRING_in_predefinedType8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_predefinedType8589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_STRING_in_predefinedType8603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIVERSAL_in_predefinedType8617 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_CHAR_STRING_in_predefinedType8619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_predefinedType8633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VERDICT_TYPE_in_predefinedType8647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_predefinedType8661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalModuleId_in_referencedType8691 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_DOT_in_referencedType8693 = new BitSet(new long[]{0x0000000000FF8000L,0x0000000000000020L});
    public static final BitSet FOLLOW_typeReference_in_referencedType8698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_globalModuleId8722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeReferenceId_in_typeReference8746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_typeReferenceId8770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lowerBound_in_synpred1_T34fpb4879 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_RANGE_OP_in_synpred1_T34fpb4881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalModuleId_in_synpred2_T34fpb7777 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_DOT_in_synpred2_T34fpb7779 = new BitSet(new long[]{0x0000000000000002L});

}