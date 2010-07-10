// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 ./grammer/T34fpb.g 2009-08-25 16:58:11
 package com.fineqt.fpb.lib.grammer;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class T34fpbLexer extends Lexer {
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
    public static final int WS=68;
    public static final int SUBSET=27;
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

    public T34fpbLexer() {;} 
    public T34fpbLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public T34fpbLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./grammer/T34fpb.g"; }

    // $ANTLR start "ASSIGNMENT_CHAR"
    public final void mASSIGNMENT_CHAR() throws RecognitionException {
        try {
            int _type = ASSIGNMENT_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:5:17: ( ':=' )
            // ./grammer/T34fpb.g:5:19: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGNMENT_CHAR"

    // $ANTLR start "OMIT"
    public final void mOMIT() throws RecognitionException {
        try {
            int _type = OMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:6:6: ( 'omit' )
            // ./grammer/T34fpb.g:6:8: 'omit'
            {
            match("omit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OMIT"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:7:6: ( 'true' )
            // ./grammer/T34fpb.g:7:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:8:7: ( 'false' )
            // ./grammer/T34fpb.g:8:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "PASS"
    public final void mPASS() throws RecognitionException {
        try {
            int _type = PASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:9:6: ( 'pass' )
            // ./grammer/T34fpb.g:9:8: 'pass'
            {
            match("pass"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PASS"

    // $ANTLR start "FAIL"
    public final void mFAIL() throws RecognitionException {
        try {
            int _type = FAIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:10:6: ( 'fail' )
            // ./grammer/T34fpb.g:10:8: 'fail'
            {
            match("fail"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FAIL"

    // $ANTLR start "INCONC"
    public final void mINCONC() throws RecognitionException {
        try {
            int _type = INCONC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:11:8: ( 'inconc' )
            // ./grammer/T34fpb.g:11:10: 'inconc'
            {
            match("inconc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCONC"

    // $ANTLR start "NONE"
    public final void mNONE() throws RecognitionException {
        try {
            int _type = NONE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:12:6: ( 'none' )
            // ./grammer/T34fpb.g:12:8: 'none'
            {
            match("none"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NONE"

    // $ANTLR start "ERROR"
    public final void mERROR() throws RecognitionException {
        try {
            int _type = ERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:13:7: ( 'error' )
            // ./grammer/T34fpb.g:13:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ERROR"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:14:6: ( 'char' )
            // ./grammer/T34fpb.g:14:8: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "TEMPLATE"
    public final void mTEMPLATE() throws RecognitionException {
        try {
            int _type = TEMPLATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:15:10: ( 'template' )
            // ./grammer/T34fpb.g:15:12: 'template'
            {
            match("template"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEMPLATE"

    // $ANTLR start "BIT_STRING"
    public final void mBIT_STRING() throws RecognitionException {
        try {
            int _type = BIT_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:16:12: ( 'bitstring' )
            // ./grammer/T34fpb.g:16:14: 'bitstring'
            {
            match("bitstring"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BIT_STRING"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:17:9: ( 'boolean' )
            // ./grammer/T34fpb.g:17:11: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:18:9: ( 'integer' )
            // ./grammer/T34fpb.g:18:11: 'integer'
            {
            match("integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "OCTET_STRING"
    public final void mOCTET_STRING() throws RecognitionException {
        try {
            int _type = OCTET_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:19:14: ( 'octetstring' )
            // ./grammer/T34fpb.g:19:16: 'octetstring'
            {
            match("octetstring"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OCTET_STRING"

    // $ANTLR start "HEX_STRING"
    public final void mHEX_STRING() throws RecognitionException {
        try {
            int _type = HEX_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:20:12: ( 'hexstring' )
            // ./grammer/T34fpb.g:20:14: 'hexstring'
            {
            match("hexstring"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HEX_STRING"

    // $ANTLR start "VERDICT_TYPE"
    public final void mVERDICT_TYPE() throws RecognitionException {
        try {
            int _type = VERDICT_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:21:14: ( 'verdicttype' )
            // ./grammer/T34fpb.g:21:16: 'verdicttype'
            {
            match("verdicttype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VERDICT_TYPE"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:22:7: ( 'float' )
            // ./grammer/T34fpb.g:22:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "CHAR_STRING"
    public final void mCHAR_STRING() throws RecognitionException {
        try {
            int _type = CHAR_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:23:13: ( 'charstring' )
            // ./grammer/T34fpb.g:23:15: 'charstring'
            {
            match("charstring"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR_STRING"

    // $ANTLR start "UNIVERSAL"
    public final void mUNIVERSAL() throws RecognitionException {
        try {
            int _type = UNIVERSAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:24:11: ( 'universal' )
            // ./grammer/T34fpb.g:24:13: 'universal'
            {
            match("universal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNIVERSAL"

    // $ANTLR start "OBJECT_IDENTIFIER"
    public final void mOBJECT_IDENTIFIER() throws RecognitionException {
        try {
            int _type = OBJECT_IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:25:19: ( 'objid' )
            // ./grammer/T34fpb.g:25:21: 'objid'
            {
            match("objid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OBJECT_IDENTIFIER"

    // $ANTLR start "MODIFIES"
    public final void mMODIFIES() throws RecognitionException {
        try {
            int _type = MODIFIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:26:10: ( 'modifies' )
            // ./grammer/T34fpb.g:26:12: 'modifies'
            {
            match("modifies"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MODIFIES"

    // $ANTLR start "COMPLEMENT"
    public final void mCOMPLEMENT() throws RecognitionException {
        try {
            int _type = COMPLEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:27:12: ( 'complement' )
            // ./grammer/T34fpb.g:27:14: 'complement'
            {
            match("complement"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMPLEMENT"

    // $ANTLR start "SUBSET"
    public final void mSUBSET() throws RecognitionException {
        try {
            int _type = SUBSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:28:8: ( 'subset' )
            // ./grammer/T34fpb.g:28:10: 'subset'
            {
            match("subset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUBSET"

    // $ANTLR start "SUPERSET"
    public final void mSUPERSET() throws RecognitionException {
        try {
            int _type = SUPERSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:29:10: ( 'superset' )
            // ./grammer/T34fpb.g:29:12: 'superset'
            {
            match("superset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUPERSET"

    // $ANTLR start "IF_PRESENT"
    public final void mIF_PRESENT() throws RecognitionException {
        try {
            int _type = IF_PRESENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:30:12: ( 'if present' )
            // ./grammer/T34fpb.g:30:14: 'if present'
            {
            match("if present"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF_PRESENT"

    // $ANTLR start "LENGTH"
    public final void mLENGTH() throws RecognitionException {
        try {
            int _type = LENGTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:31:8: ( 'length' )
            // ./grammer/T34fpb.g:31:10: 'length'
            {
            match("length"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LENGTH"

    // $ANTLR start "INFINITY"
    public final void mINFINITY() throws RecognitionException {
        try {
            int _type = INFINITY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:32:10: ( 'infinity' )
            // ./grammer/T34fpb.g:32:12: 'infinity'
            {
            match("infinity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INFINITY"

    // $ANTLR start "PATTERN"
    public final void mPATTERN() throws RecognitionException {
        try {
            int _type = PATTERN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:33:9: ( 'pattern' )
            // ./grammer/T34fpb.g:33:11: 'pattern'
            {
            match("pattern"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PATTERN"

    // $ANTLR start "MODULE"
    public final void mMODULE() throws RecognitionException {
        try {
            int _type = MODULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:34:8: ( 'module' )
            // ./grammer/T34fpb.g:34:10: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MODULE"

    // $ANTLR start "WITH"
    public final void mWITH() throws RecognitionException {
        try {
            int _type = WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:35:6: ( 'with' )
            // ./grammer/T34fpb.g:35:8: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WITH"

    // $ANTLR start "ENCODE"
    public final void mENCODE() throws RecognitionException {
        try {
            int _type = ENCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:36:8: ( 'encode' )
            // ./grammer/T34fpb.g:36:10: 'encode'
            {
            match("encode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENCODE"

    // $ANTLR start "VARIANT"
    public final void mVARIANT() throws RecognitionException {
        try {
            int _type = VARIANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:37:9: ( 'variant' )
            // ./grammer/T34fpb.g:37:11: 'variant'
            {
            match("variant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIANT"

    // $ANTLR start "RUNTIME"
    public final void mRUNTIME() throws RecognitionException {
        try {
            int _type = RUNTIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:38:9: ( 'runtime' )
            // ./grammer/T34fpb.g:38:11: 'runtime'
            {
            match("runtime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RUNTIME"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:39:6: ( 'type' )
            // ./grammer/T34fpb.g:39:8: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "CONST"
    public final void mCONST() throws RecognitionException {
        try {
            int _type = CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:40:7: ( 'const' )
            // ./grammer/T34fpb.g:40:9: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONST"

    // $ANTLR start "MODULE_PAR"
    public final void mMODULE_PAR() throws RecognitionException {
        try {
            int _type = MODULE_PAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:41:12: ( 'modulepar' )
            // ./grammer/T34fpb.g:41:14: 'modulepar'
            {
            match("modulepar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MODULE_PAR"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:42:5: ( 'all' )
            // ./grammer/T34fpb.g:42:7: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "EXCEPT"
    public final void mEXCEPT() throws RecognitionException {
        try {
            int _type = EXCEPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:43:8: ( 'except' )
            // ./grammer/T34fpb.g:43:10: 'except'
            {
            match("except"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCEPT"

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:44:8: ( 'import' )
            // ./grammer/T34fpb.g:44:10: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:45:6: ( 'from' )
            // ./grammer/T34fpb.g:45:8: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "RECORD"
    public final void mRECORD() throws RecognitionException {
        try {
            int _type = RECORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:46:8: ( 'record' )
            // ./grammer/T34fpb.g:46:10: 'record'
            {
            match("record"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RECORD"

    // $ANTLR start "UNION"
    public final void mUNION() throws RecognitionException {
        try {
            int _type = UNION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:47:7: ( 'union' )
            // ./grammer/T34fpb.g:47:9: 'union'
            {
            match("union"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNION"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:48:5: ( 'set' )
            // ./grammer/T34fpb.g:48:7: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "ENUMERATED"
    public final void mENUMERATED() throws RecognitionException {
        try {
            int _type = ENUMERATED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:49:12: ( 'enumerated' )
            // ./grammer/T34fpb.g:49:14: 'enumerated'
            {
            match("enumerated"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENUMERATED"

    // $ANTLR start "OF"
    public final void mOF() throws RecognitionException {
        try {
            int _type = OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:50:4: ( 'of' )
            // ./grammer/T34fpb.g:50:6: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OF"

    // $ANTLR start "OPTIONAL"
    public final void mOPTIONAL() throws RecognitionException {
        try {
            int _type = OPTIONAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:51:10: ( 'optional' )
            // ./grammer/T34fpb.g:51:12: 'optional'
            {
            match("optional"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPTIONAL"

    // $ANTLR start "ENUM_SET"
    public final void mENUM_SET() throws RecognitionException {
        try {
            int _type = ENUM_SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:52:10: ( 'enumset' )
            // ./grammer/T34fpb.g:52:12: 'enumset'
            {
            match("enumset"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENUM_SET"

    // $ANTLR start "ENUM"
    public final void mENUM() throws RecognitionException {
        try {
            int _type = ENUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:53:6: ( 'enum' )
            // ./grammer/T34fpb.g:53:8: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENUM"

    // $ANTLR start "ENUM_SET_REF"
    public final void mENUM_SET_REF() throws RecognitionException {
        try {
            int _type = ENUM_SET_REF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:54:14: ( 'enumref' )
            // ./grammer/T34fpb.g:54:16: 'enumref'
            {
            match("enumref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENUM_SET_REF"

    // $ANTLR start "THREAD"
    public final void mTHREAD() throws RecognitionException {
        try {
            int _type = THREAD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:55:8: ( 'thread' )
            // ./grammer/T34fpb.g:55:10: 'thread'
            {
            match("thread"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "THREAD"

    // $ANTLR start "SEMI_COLON"
    public final void mSEMI_COLON() throws RecognitionException {
        try {
            int _type = SEMI_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:56:12: ( ';' )
            // ./grammer/T34fpb.g:56:14: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI_COLON"

    // $ANTLR start "UNDER_SCORE"
    public final void mUNDER_SCORE() throws RecognitionException {
        try {
            int _type = UNDER_SCORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:57:13: ( '_' )
            // ./grammer/T34fpb.g:57:15: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNDER_SCORE"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:58:5: ( '.' )
            // ./grammer/T34fpb.g:58:7: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:59:7: ( '-' )
            // ./grammer/T34fpb.g:59:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:60:7: ( ':' )
            // ./grammer/T34fpb.g:60:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "ANY_VALUE"
    public final void mANY_VALUE() throws RecognitionException {
        try {
            int _type = ANY_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:61:11: ( '?' )
            // ./grammer/T34fpb.g:61:13: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANY_VALUE"

    // $ANTLR start "ANY_OR_OMIT"
    public final void mANY_OR_OMIT() throws RecognitionException {
        try {
            int _type = ANY_OR_OMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:62:13: ( '*' )
            // ./grammer/T34fpb.g:62:15: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANY_OR_OMIT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:63:7: ( ',' )
            // ./grammer/T34fpb.g:63:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "RANGE_OP"
    public final void mRANGE_OP() throws RecognitionException {
        try {
            int _type = RANGE_OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:64:10: ( '..' )
            // ./grammer/T34fpb.g:64:12: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE_OP"

    // $ANTLR start "VALUE_REF_ARG_PREFIX"
    public final void mVALUE_REF_ARG_PREFIX() throws RecognitionException {
        try {
            int _type = VALUE_REF_ARG_PREFIX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:65:22: ( '$' )
            // ./grammer/T34fpb.g:65:24: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VALUE_REF_ARG_PREFIX"

    // $ANTLR start "TYPE_REF_ARG_PREFIX"
    public final void mTYPE_REF_ARG_PREFIX() throws RecognitionException {
        try {
            int _type = TYPE_REF_ARG_PREFIX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:66:21: ( '#' )
            // ./grammer/T34fpb.g:66:23: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE_REF_ARG_PREFIX"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:67:7: ( '{' )
            // ./grammer/T34fpb.g:67:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:68:8: ( '}' )
            // ./grammer/T34fpb.g:68:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:69:8: ( '(' )
            // ./grammer/T34fpb.g:69:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:70:8: ( ')' )
            // ./grammer/T34fpb.g:70:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:71:8: ( '[' )
            // ./grammer/T34fpb.g:71:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:72:8: ( ']' )
            // ./grammer/T34fpb.g:72:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:73:8: ( '=' )
            // ./grammer/T34fpb.g:73:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:74:8: ( '+' )
            // ./grammer/T34fpb.g:74:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:175:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ./grammer/T34fpb.g:175:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ./grammer/T34fpb.g:175:14: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./grammer/T34fpb.g:175:41: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("*/"); 


                    skip();
                    

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:182:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' ) | '//' (~ ( '\\n' | '\\r' ) )* )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ./grammer/T34fpb.g:182:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' )
                    {
                    match("//"); 

                    // ./grammer/T34fpb.g:182:14: (~ ( '\\n' | '\\r' ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ./grammer/T34fpb.g:182:14: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    // ./grammer/T34fpb.g:182:29: ( '\\r\\n' | '\\r' | '\\n' )
                    int alt3=3;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        int LA3_1 = input.LA(2);

                        if ( (LA3_1=='\n') ) {
                            alt3=1;
                        }
                        else {
                            alt3=2;}
                    }
                    else if ( (LA3_0=='\n') ) {
                        alt3=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ./grammer/T34fpb.g:182:30: '\\r\\n'
                            {
                            match("\r\n"); 


                            }
                            break;
                        case 2 :
                            // ./grammer/T34fpb.g:182:39: '\\r'
                            {
                            match('\r'); 

                            }
                            break;
                        case 3 :
                            // ./grammer/T34fpb.g:182:46: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                                skip();
                                

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:186:9: '//' (~ ( '\\n' | '\\r' ) )*
                    {
                    match("//"); 

                    // ./grammer/T34fpb.g:186:14: (~ ( '\\n' | '\\r' ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ./grammer/T34fpb.g:186:14: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                                skip();
                                

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:193:5: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\r\\n' ) )
            // ./grammer/T34fpb.g:193:9: ( ' ' | '\\t' | '\\n' | '\\r' | '\\r\\n' )
            {
            // ./grammer/T34fpb.g:193:9: ( ' ' | '\\t' | '\\n' | '\\r' | '\\r\\n' )
            int alt6=5;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt6=1;
                }
                break;
            case '\t':
                {
                alt6=2;
                }
                break;
            case '\n':
                {
                alt6=3;
                }
                break;
            case '\r':
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4=='\n') ) {
                    alt6=5;
                }
                else {
                    alt6=4;}
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ./grammer/T34fpb.g:193:13: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:193:18: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:193:24: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 4 :
                    // ./grammer/T34fpb.g:193:30: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 5 :
                    // ./grammer/T34fpb.g:193:36: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;

            }

             
                        skip();
                        

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:200:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ./grammer/T34fpb.g:200:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ./grammer/T34fpb.g:200:29: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./grammer/T34fpb.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "CSTRING"
    public final void mCSTRING() throws RecognitionException {
        try {
            int _type = CSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:204:5: ( '\"' ( GeneralTextCharacter | Special | '\\'' | ( '\"' '\"' ) )* '\"' )
            // ./grammer/T34fpb.g:204:9: '\"' ( GeneralTextCharacter | Special | '\\'' | ( '\"' '\"' ) )* '\"'
            {
            match('\"'); 
            // ./grammer/T34fpb.g:211:9: ( GeneralTextCharacter | Special | '\\'' | ( '\"' '\"' ) )*
            loop8:
            do {
                int alt8=5;
                switch ( input.LA(1) ) {
                case '\"':
                    {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='\"') ) {
                        alt8=4;
                    }


                    }
                    break;
                case '\u0000':
                case '\u0001':
                case '\u0002':
                case '\u0003':
                case '\u0004':
                case '\u0005':
                case '\u0006':
                case '\u0007':
                case '\b':
                case '\t':
                case '\n':
                case '\u000B':
                case '\f':
                case '\r':
                case '\u000E':
                case '\u000F':
                case '\u0010':
                case '\u0011':
                case '\u0012':
                case '\u0013':
                case '\u0014':
                case '\u0015':
                case '\u0016':
                case '\u0017':
                case '\u0018':
                case '\u0019':
                case '\u001A':
                case '\u001B':
                case '\u001C':
                case '\u001D':
                case '\u001E':
                case '\u001F':
                case ' ':
                case '$':
                case '%':
                case '&':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '?':
                case '@':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '\\':
                case '^':
                case '_':
                case '`':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case '|':
                case '~':
                    {
                    alt8=1;
                    }
                    break;
                case '!':
                case '#':
                case '(':
                case ')':
                case '*':
                case '+':
                case ',':
                case '-':
                case '.':
                case '/':
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '[':
                case ']':
                case '{':
                case '}':
                    {
                    alt8=2;
                    }
                    break;
                case '\'':
                    {
                    alt8=3;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // ./grammer/T34fpb.g:212:9: GeneralTextCharacter
            	    {
            	    mGeneralTextCharacter(); 

            	    }
            	    break;
            	case 2 :
            	    // ./grammer/T34fpb.g:213:13: Special
            	    {
            	    mSpecial(); 

            	    }
            	    break;
            	case 3 :
            	    // ./grammer/T34fpb.g:214:13: '\\''
            	    {
            	    match('\''); 

            	    }
            	    break;
            	case 4 :
            	    // ./grammer/T34fpb.g:215:13: ( '\"' '\"' )
            	    {
            	    // ./grammer/T34fpb.g:215:13: ( '\"' '\"' )
            	    // ./grammer/T34fpb.g:215:14: '\"' '\"'
            	    {
            	    match('\"'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CSTRING"

    // $ANTLR start "GeneralTextCharacter"
    public final void mGeneralTextCharacter() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:222:5: ( Alphanumeric | OtherCharacter | Space )
            int alt9=3;
            switch ( input.LA(1) ) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt9=1;
                }
                break;
            case '$':
            case '%':
            case '&':
            case '?':
            case '@':
            case '\\':
            case '^':
            case '_':
            case '`':
            case '|':
            case '~':
                {
                alt9=2;
                }
                break;
            case '\u0000':
            case '\u0001':
            case '\u0002':
            case '\u0003':
            case '\u0004':
            case '\u0005':
            case '\u0006':
            case '\u0007':
            case '\b':
            case '\t':
            case '\n':
            case '\u000B':
            case '\f':
            case '\r':
            case '\u000E':
            case '\u000F':
            case '\u0010':
            case '\u0011':
            case '\u0012':
            case '\u0013':
            case '\u0014':
            case '\u0015':
            case '\u0016':
            case '\u0017':
            case '\u0018':
            case '\u0019':
            case '\u001A':
            case '\u001B':
            case '\u001C':
            case '\u001D':
            case '\u001E':
            case '\u001F':
            case ' ':
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ./grammer/T34fpb.g:222:9: Alphanumeric
                    {
                    mAlphanumeric(); 

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:223:13: OtherCharacter
                    {
                    mOtherCharacter(); 

                    }
                    break;
                case 3 :
                    // ./grammer/T34fpb.g:224:13: Space
                    {
                    mSpace(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "GeneralTextCharacter"

    // $ANTLR start "Alphanumeric"
    public final void mAlphanumeric() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:229:5: ( Letter | Num )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>='A' && LA10_0<='Z')||(LA10_0>='a' && LA10_0<='z')) ) {
                alt10=1;
            }
            else if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ./grammer/T34fpb.g:229:9: Letter
                    {
                    mLetter(); 

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:230:13: Num
                    {
                    mNum(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "Alphanumeric"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:235:5: ( UppercaseLetter | LowercaseLetter )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>='A' && LA11_0<='Z')) ) {
                alt11=1;
            }
            else if ( ((LA11_0>='a' && LA11_0<='z')) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ./grammer/T34fpb.g:235:9: UppercaseLetter
                    {
                    mUppercaseLetter(); 

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:236:13: LowercaseLetter
                    {
                    mLowercaseLetter(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "UppercaseLetter"
    public final void mUppercaseLetter() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:241:5: ( ( 'A' .. 'Z' ) )
            // ./grammer/T34fpb.g:241:9: ( 'A' .. 'Z' )
            {
            // ./grammer/T34fpb.g:241:9: ( 'A' .. 'Z' )
            // ./grammer/T34fpb.g:241:11: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "UppercaseLetter"

    // $ANTLR start "LowercaseLetter"
    public final void mLowercaseLetter() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:246:5: ( ( 'a' .. 'z' ) )
            // ./grammer/T34fpb.g:246:9: ( 'a' .. 'z' )
            {
            // ./grammer/T34fpb.g:246:9: ( 'a' .. 'z' )
            // ./grammer/T34fpb.g:246:11: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "LowercaseLetter"

    // $ANTLR start "Special"
    public final void mSpecial() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:251:5: ( '/' | '*' | OtherSpecial )
            // ./grammer/T34fpb.g:
            {
            if ( input.LA(1)=='!'||input.LA(1)=='#'||(input.LA(1)>='(' && input.LA(1)<='/')||(input.LA(1)>=':' && input.LA(1)<='>')||input.LA(1)=='['||input.LA(1)==']'||input.LA(1)=='{'||input.LA(1)=='}' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Special"

    // $ANTLR start "OtherSpecial"
    public final void mOtherSpecial() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:258:5: ( '!' | '#' | '(' | ')' | '+' | ',' | '-' | '.' | ':' | ';' | '<' | '=' | '>' | '[' | ']' | '{' | '}' )
            // ./grammer/T34fpb.g:
            {
            if ( input.LA(1)=='!'||input.LA(1)=='#'||(input.LA(1)>='(' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='.')||(input.LA(1)>=':' && input.LA(1)<='>')||input.LA(1)=='['||input.LA(1)==']'||input.LA(1)=='{'||input.LA(1)=='}' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "OtherSpecial"

    // $ANTLR start "OtherCharacter"
    public final void mOtherCharacter() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:265:5: ( '$' | '%' | '&' | '?' | '@' | '\\\\' | '^' | '_' | '`' | '|' | '~' )
            // ./grammer/T34fpb.g:
            {
            if ( (input.LA(1)>='$' && input.LA(1)<='&')||(input.LA(1)>='?' && input.LA(1)<='@')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='`')||input.LA(1)=='|'||input.LA(1)=='~' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "OtherCharacter"

    // $ANTLR start "Space"
    public final void mSpace() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:271:5: ( '\\u0000' .. '\\u0009' | '\\n' | '\\u000b' .. '\\u001f' | ' ' )
            // ./grammer/T34fpb.g:
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<=' ') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Space"

    // $ANTLR start "Num"
    public final void mNum() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:279:5: ( Zero | NonzeroNum )
            // ./grammer/T34fpb.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Num"

    // $ANTLR start "Zero"
    public final void mZero() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:285:5: ( '0' )
            // ./grammer/T34fpb.g:285:9: '0'
            {
            match('0'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Zero"

    // $ANTLR start "NonzeroNum"
    public final void mNonzeroNum() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:290:5: ( '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' )
            // ./grammer/T34fpb.g:
            {
            if ( (input.LA(1)>='1' && input.LA(1)<='9') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NonzeroNum"

    // $ANTLR start "NonzeroNumber"
    public final void mNonzeroNumber() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:295:5: ( NonzeroNum ( Num )* )
            // ./grammer/T34fpb.g:295:9: NonzeroNum ( Num )*
            {
            mNonzeroNum(); 
            // ./grammer/T34fpb.g:296:9: ( Num )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./grammer/T34fpb.g:296:13: Num
            	    {
            	    mNum(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "NonzeroNumber"

    // $ANTLR start "DecimalNumber"
    public final void mDecimalNumber() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:302:5: ( ( Num )* )
            // ./grammer/T34fpb.g:302:9: ( Num )*
            {
            // ./grammer/T34fpb.g:302:9: ( Num )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ./grammer/T34fpb.g:302:13: Num
            	    {
            	    mNum(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "DecimalNumber"

    // $ANTLR start "BSTRING"
    public final void mBSTRING() throws RecognitionException {
        try {
            int _type = BSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:307:5: ( '\\'' ( Bin )* '\\'' 'B' )
            // ./grammer/T34fpb.g:307:9: '\\'' ( Bin )* '\\'' 'B'
            {
            match('\''); 
            // ./grammer/T34fpb.g:307:14: ( Bin )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>='0' && LA14_0<='1')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ./grammer/T34fpb.g:307:16: Bin
            	    {
            	    mBin(); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match('\''); 
            match('B'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BSTRING"

    // $ANTLR start "HSTRING"
    public final void mHSTRING() throws RecognitionException {
        try {
            int _type = HSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:311:5: ( ( '\\'' ( Hex )* '\\'' 'H' ) )
            // ./grammer/T34fpb.g:311:9: ( '\\'' ( Hex )* '\\'' 'H' )
            {
            // ./grammer/T34fpb.g:311:9: ( '\\'' ( Hex )* '\\'' 'H' )
            // ./grammer/T34fpb.g:311:11: '\\'' ( Hex )* '\\'' 'H'
            {
            match('\''); 
            // ./grammer/T34fpb.g:311:16: ( Hex )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')||(LA15_0>='A' && LA15_0<='F')||(LA15_0>='a' && LA15_0<='f')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ./grammer/T34fpb.g:311:18: Hex
            	    {
            	    mHex(); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match('\''); 
            match('H'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HSTRING"

    // $ANTLR start "OSTRING"
    public final void mOSTRING() throws RecognitionException {
        try {
            int _type = OSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:315:5: ( ( '\\'' ( Oct )* '\\'' 'O' ) )
            // ./grammer/T34fpb.g:315:9: ( '\\'' ( Oct )* '\\'' 'O' )
            {
            // ./grammer/T34fpb.g:315:9: ( '\\'' ( Oct )* '\\'' 'O' )
            // ./grammer/T34fpb.g:315:11: '\\'' ( Oct )* '\\'' 'O'
            {
            match('\''); 
            // ./grammer/T34fpb.g:315:16: ( Oct )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='0' && LA16_0<='9')||(LA16_0>='A' && LA16_0<='F')||(LA16_0>='a' && LA16_0<='f')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ./grammer/T34fpb.g:315:18: Oct
            	    {
            	    mOct(); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            match('\''); 
            match('O'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OSTRING"

    // $ANTLR start "BSTRING_MATCH"
    public final void mBSTRING_MATCH() throws RecognitionException {
        try {
            int _type = BSTRING_MATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:319:5: ( ( '\\'' ( Bin | '?' | '*' )* '\\'' 'B' ) )
            // ./grammer/T34fpb.g:319:9: ( '\\'' ( Bin | '?' | '*' )* '\\'' 'B' )
            {
            // ./grammer/T34fpb.g:319:9: ( '\\'' ( Bin | '?' | '*' )* '\\'' 'B' )
            // ./grammer/T34fpb.g:319:11: '\\'' ( Bin | '?' | '*' )* '\\'' 'B'
            {
            match('\''); 
            // ./grammer/T34fpb.g:319:16: ( Bin | '?' | '*' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='*'||(LA17_0>='0' && LA17_0<='1')||LA17_0=='?') ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ./grammer/T34fpb.g:
            	    {
            	    if ( input.LA(1)=='*'||(input.LA(1)>='0' && input.LA(1)<='1')||input.LA(1)=='?' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            match('\''); 
            match('B'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BSTRING_MATCH"

    // $ANTLR start "HSTRING_MATCH"
    public final void mHSTRING_MATCH() throws RecognitionException {
        try {
            int _type = HSTRING_MATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:323:5: ( ( '\\'' ( Hex | '?' | '*' )* '\\'' 'H' ) )
            // ./grammer/T34fpb.g:323:9: ( '\\'' ( Hex | '?' | '*' )* '\\'' 'H' )
            {
            // ./grammer/T34fpb.g:323:9: ( '\\'' ( Hex | '?' | '*' )* '\\'' 'H' )
            // ./grammer/T34fpb.g:323:11: '\\'' ( Hex | '?' | '*' )* '\\'' 'H'
            {
            match('\''); 
            // ./grammer/T34fpb.g:323:16: ( Hex | '?' | '*' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='*'||(LA18_0>='0' && LA18_0<='9')||LA18_0=='?'||(LA18_0>='A' && LA18_0<='F')||(LA18_0>='a' && LA18_0<='f')) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ./grammer/T34fpb.g:
            	    {
            	    if ( input.LA(1)=='*'||(input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='?'||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match('\''); 
            match('H'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HSTRING_MATCH"

    // $ANTLR start "OSTRING_MATCH"
    public final void mOSTRING_MATCH() throws RecognitionException {
        try {
            int _type = OSTRING_MATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:327:5: ( ( '\\'' ( Oct | '?' | '*' )* '\\'' 'O' ) )
            // ./grammer/T34fpb.g:327:9: ( '\\'' ( Oct | '?' | '*' )* '\\'' 'O' )
            {
            // ./grammer/T34fpb.g:327:9: ( '\\'' ( Oct | '?' | '*' )* '\\'' 'O' )
            // ./grammer/T34fpb.g:327:11: '\\'' ( Oct | '?' | '*' )* '\\'' 'O'
            {
            match('\''); 
            // ./grammer/T34fpb.g:327:16: ( Oct | '?' | '*' )*
            loop19:
            do {
                int alt19=4;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                    {
                    alt19=1;
                    }
                    break;
                case '?':
                    {
                    alt19=2;
                    }
                    break;
                case '*':
                    {
                    alt19=3;
                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // ./grammer/T34fpb.g:327:18: Oct
            	    {
            	    mOct(); 

            	    }
            	    break;
            	case 2 :
            	    // ./grammer/T34fpb.g:327:24: '?'
            	    {
            	    match('?'); 

            	    }
            	    break;
            	case 3 :
            	    // ./grammer/T34fpb.g:327:30: '*'
            	    {
            	    match('*'); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match('\''); 
            match('O'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OSTRING_MATCH"

    // $ANTLR start "Bin"
    public final void mBin() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:332:5: ( '0' .. '1' )
            // ./grammer/T34fpb.g:332:9: '0' .. '1'
            {
            matchRange('0','1'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Bin"

    // $ANTLR start "Hex"
    public final void mHex() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:337:5: ( Num | 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' )
            // ./grammer/T34fpb.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Hex"

    // $ANTLR start "Oct"
    public final void mOct() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:342:5: ( Hex Hex )
            // ./grammer/T34fpb.g:342:9: Hex Hex
            {
            mHex(); 
            mHex(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Oct"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:347:5: ( NonzeroNumber | Zero )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>='1' && LA20_0<='9')) ) {
                alt20=1;
            }
            else if ( (LA20_0=='0') ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ./grammer/T34fpb.g:347:9: NonzeroNumber
                    {
                    mNonzeroNumber(); 

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:348:13: Zero
                    {
                    mZero(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "HexPrefix"
    public final void mHexPrefix() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:353:5: ( '0x' | '0X' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='0') ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1=='x') ) {
                    alt21=1;
                }
                else if ( (LA21_1=='X') ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ./grammer/T34fpb.g:353:9: '0x'
                    {
                    match("0x"); 


                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:353:16: '0X'
                    {
                    match("0X"); 


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "HexPrefix"

    // $ANTLR start "INTEGER_VALUE"
    public final void mINTEGER_VALUE() throws RecognitionException {
        try {
            int _type = INTEGER_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:357:2: ( NUMBER | HexPrefix ( Hex )+ )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>='1' && LA23_0<='9')) ) {
                alt23=1;
            }
            else if ( (LA23_0=='0') ) {
                int LA23_2 = input.LA(2);

                if ( (LA23_2=='X'||LA23_2=='x') ) {
                    alt23=2;
                }
                else {
                    alt23=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ./grammer/T34fpb.g:357:4: NUMBER
                    {
                    mNUMBER(); 

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:358:5: HexPrefix ( Hex )+
                    {
                    mHexPrefix(); 
                    // ./grammer/T34fpb.g:358:15: ( Hex )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( ((LA22_0>='0' && LA22_0<='9')||(LA22_0>='A' && LA22_0<='F')||(LA22_0>='a' && LA22_0<='f')) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ./grammer/T34fpb.g:358:15: Hex
                    	    {
                    	    mHex(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER_VALUE"

    // $ANTLR start "FLOAT_VALUE"
    public final void mFLOAT_VALUE() throws RecognitionException {
        try {
            int _type = FLOAT_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./grammer/T34fpb.g:362:5: ( NUMBER ( DOT DecimalNumber | ( DOT DecimalNumber )? Exponential ( MINUS )? NUMBER ) )
            // ./grammer/T34fpb.g:362:9: NUMBER ( DOT DecimalNumber | ( DOT DecimalNumber )? Exponential ( MINUS )? NUMBER )
            {
            mNUMBER(); 
            // ./grammer/T34fpb.g:363:6: ( DOT DecimalNumber | ( DOT DecimalNumber )? Exponential ( MINUS )? NUMBER )
            int alt26=2;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // ./grammer/T34fpb.g:363:9: DOT DecimalNumber
                    {
                    mDOT(); 
                    mDecimalNumber(); 

                    }
                    break;
                case 2 :
                    // ./grammer/T34fpb.g:364:12: ( DOT DecimalNumber )? Exponential ( MINUS )? NUMBER
                    {
                    // ./grammer/T34fpb.g:364:12: ( DOT DecimalNumber )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='.') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ./grammer/T34fpb.g:364:14: DOT DecimalNumber
                            {
                            mDOT(); 
                            mDecimalNumber(); 

                            }
                            break;

                    }

                    mExponential(); 
                    // ./grammer/T34fpb.g:364:47: ( MINUS )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='-') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // ./grammer/T34fpb.g:364:49: MINUS
                            {
                            mMINUS(); 

                            }
                            break;

                    }

                    mNUMBER(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT_VALUE"

    // $ANTLR start "Exponential"
    public final void mExponential() throws RecognitionException {
        try {
            // ./grammer/T34fpb.g:370:5: ( 'E' )
            // ./grammer/T34fpb.g:370:9: 'E'
            {
            match('E'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponential"

    public void mTokens() throws RecognitionException {
        // ./grammer/T34fpb.g:1:8: ( ASSIGNMENT_CHAR | OMIT | TRUE | FALSE | PASS | FAIL | INCONC | NONE | ERROR | CHAR | TEMPLATE | BIT_STRING | BOOLEAN | INTEGER | OCTET_STRING | HEX_STRING | VERDICT_TYPE | FLOAT | CHAR_STRING | UNIVERSAL | OBJECT_IDENTIFIER | MODIFIES | COMPLEMENT | SUBSET | SUPERSET | IF_PRESENT | LENGTH | INFINITY | PATTERN | MODULE | WITH | ENCODE | VARIANT | RUNTIME | TYPE | CONST | MODULE_PAR | ALL | EXCEPT | IMPORT | FROM | RECORD | UNION | SET | ENUMERATED | OF | OPTIONAL | ENUM_SET | ENUM | ENUM_SET_REF | THREAD | SEMI_COLON | UNDER_SCORE | DOT | MINUS | COLON | ANY_VALUE | ANY_OR_OMIT | COMMA | RANGE_OP | VALUE_REF_ARG_PREFIX | TYPE_REF_ARG_PREFIX | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | ML_COMMENT | SL_COMMENT | WS | IDENTIFIER | CSTRING | BSTRING | HSTRING | OSTRING | BSTRING_MATCH | HSTRING_MATCH | OSTRING_MATCH | INTEGER_VALUE | FLOAT_VALUE )
        int alt27=83;
        alt27 = dfa27.predict(input);
        switch (alt27) {
            case 1 :
                // ./grammer/T34fpb.g:1:10: ASSIGNMENT_CHAR
                {
                mASSIGNMENT_CHAR(); 

                }
                break;
            case 2 :
                // ./grammer/T34fpb.g:1:26: OMIT
                {
                mOMIT(); 

                }
                break;
            case 3 :
                // ./grammer/T34fpb.g:1:31: TRUE
                {
                mTRUE(); 

                }
                break;
            case 4 :
                // ./grammer/T34fpb.g:1:36: FALSE
                {
                mFALSE(); 

                }
                break;
            case 5 :
                // ./grammer/T34fpb.g:1:42: PASS
                {
                mPASS(); 

                }
                break;
            case 6 :
                // ./grammer/T34fpb.g:1:47: FAIL
                {
                mFAIL(); 

                }
                break;
            case 7 :
                // ./grammer/T34fpb.g:1:52: INCONC
                {
                mINCONC(); 

                }
                break;
            case 8 :
                // ./grammer/T34fpb.g:1:59: NONE
                {
                mNONE(); 

                }
                break;
            case 9 :
                // ./grammer/T34fpb.g:1:64: ERROR
                {
                mERROR(); 

                }
                break;
            case 10 :
                // ./grammer/T34fpb.g:1:70: CHAR
                {
                mCHAR(); 

                }
                break;
            case 11 :
                // ./grammer/T34fpb.g:1:75: TEMPLATE
                {
                mTEMPLATE(); 

                }
                break;
            case 12 :
                // ./grammer/T34fpb.g:1:84: BIT_STRING
                {
                mBIT_STRING(); 

                }
                break;
            case 13 :
                // ./grammer/T34fpb.g:1:95: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 14 :
                // ./grammer/T34fpb.g:1:103: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 15 :
                // ./grammer/T34fpb.g:1:111: OCTET_STRING
                {
                mOCTET_STRING(); 

                }
                break;
            case 16 :
                // ./grammer/T34fpb.g:1:124: HEX_STRING
                {
                mHEX_STRING(); 

                }
                break;
            case 17 :
                // ./grammer/T34fpb.g:1:135: VERDICT_TYPE
                {
                mVERDICT_TYPE(); 

                }
                break;
            case 18 :
                // ./grammer/T34fpb.g:1:148: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 19 :
                // ./grammer/T34fpb.g:1:154: CHAR_STRING
                {
                mCHAR_STRING(); 

                }
                break;
            case 20 :
                // ./grammer/T34fpb.g:1:166: UNIVERSAL
                {
                mUNIVERSAL(); 

                }
                break;
            case 21 :
                // ./grammer/T34fpb.g:1:176: OBJECT_IDENTIFIER
                {
                mOBJECT_IDENTIFIER(); 

                }
                break;
            case 22 :
                // ./grammer/T34fpb.g:1:194: MODIFIES
                {
                mMODIFIES(); 

                }
                break;
            case 23 :
                // ./grammer/T34fpb.g:1:203: COMPLEMENT
                {
                mCOMPLEMENT(); 

                }
                break;
            case 24 :
                // ./grammer/T34fpb.g:1:214: SUBSET
                {
                mSUBSET(); 

                }
                break;
            case 25 :
                // ./grammer/T34fpb.g:1:221: SUPERSET
                {
                mSUPERSET(); 

                }
                break;
            case 26 :
                // ./grammer/T34fpb.g:1:230: IF_PRESENT
                {
                mIF_PRESENT(); 

                }
                break;
            case 27 :
                // ./grammer/T34fpb.g:1:241: LENGTH
                {
                mLENGTH(); 

                }
                break;
            case 28 :
                // ./grammer/T34fpb.g:1:248: INFINITY
                {
                mINFINITY(); 

                }
                break;
            case 29 :
                // ./grammer/T34fpb.g:1:257: PATTERN
                {
                mPATTERN(); 

                }
                break;
            case 30 :
                // ./grammer/T34fpb.g:1:265: MODULE
                {
                mMODULE(); 

                }
                break;
            case 31 :
                // ./grammer/T34fpb.g:1:272: WITH
                {
                mWITH(); 

                }
                break;
            case 32 :
                // ./grammer/T34fpb.g:1:277: ENCODE
                {
                mENCODE(); 

                }
                break;
            case 33 :
                // ./grammer/T34fpb.g:1:284: VARIANT
                {
                mVARIANT(); 

                }
                break;
            case 34 :
                // ./grammer/T34fpb.g:1:292: RUNTIME
                {
                mRUNTIME(); 

                }
                break;
            case 35 :
                // ./grammer/T34fpb.g:1:300: TYPE
                {
                mTYPE(); 

                }
                break;
            case 36 :
                // ./grammer/T34fpb.g:1:305: CONST
                {
                mCONST(); 

                }
                break;
            case 37 :
                // ./grammer/T34fpb.g:1:311: MODULE_PAR
                {
                mMODULE_PAR(); 

                }
                break;
            case 38 :
                // ./grammer/T34fpb.g:1:322: ALL
                {
                mALL(); 

                }
                break;
            case 39 :
                // ./grammer/T34fpb.g:1:326: EXCEPT
                {
                mEXCEPT(); 

                }
                break;
            case 40 :
                // ./grammer/T34fpb.g:1:333: IMPORT
                {
                mIMPORT(); 

                }
                break;
            case 41 :
                // ./grammer/T34fpb.g:1:340: FROM
                {
                mFROM(); 

                }
                break;
            case 42 :
                // ./grammer/T34fpb.g:1:345: RECORD
                {
                mRECORD(); 

                }
                break;
            case 43 :
                // ./grammer/T34fpb.g:1:352: UNION
                {
                mUNION(); 

                }
                break;
            case 44 :
                // ./grammer/T34fpb.g:1:358: SET
                {
                mSET(); 

                }
                break;
            case 45 :
                // ./grammer/T34fpb.g:1:362: ENUMERATED
                {
                mENUMERATED(); 

                }
                break;
            case 46 :
                // ./grammer/T34fpb.g:1:373: OF
                {
                mOF(); 

                }
                break;
            case 47 :
                // ./grammer/T34fpb.g:1:376: OPTIONAL
                {
                mOPTIONAL(); 

                }
                break;
            case 48 :
                // ./grammer/T34fpb.g:1:385: ENUM_SET
                {
                mENUM_SET(); 

                }
                break;
            case 49 :
                // ./grammer/T34fpb.g:1:394: ENUM
                {
                mENUM(); 

                }
                break;
            case 50 :
                // ./grammer/T34fpb.g:1:399: ENUM_SET_REF
                {
                mENUM_SET_REF(); 

                }
                break;
            case 51 :
                // ./grammer/T34fpb.g:1:412: THREAD
                {
                mTHREAD(); 

                }
                break;
            case 52 :
                // ./grammer/T34fpb.g:1:419: SEMI_COLON
                {
                mSEMI_COLON(); 

                }
                break;
            case 53 :
                // ./grammer/T34fpb.g:1:430: UNDER_SCORE
                {
                mUNDER_SCORE(); 

                }
                break;
            case 54 :
                // ./grammer/T34fpb.g:1:442: DOT
                {
                mDOT(); 

                }
                break;
            case 55 :
                // ./grammer/T34fpb.g:1:446: MINUS
                {
                mMINUS(); 

                }
                break;
            case 56 :
                // ./grammer/T34fpb.g:1:452: COLON
                {
                mCOLON(); 

                }
                break;
            case 57 :
                // ./grammer/T34fpb.g:1:458: ANY_VALUE
                {
                mANY_VALUE(); 

                }
                break;
            case 58 :
                // ./grammer/T34fpb.g:1:468: ANY_OR_OMIT
                {
                mANY_OR_OMIT(); 

                }
                break;
            case 59 :
                // ./grammer/T34fpb.g:1:480: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 60 :
                // ./grammer/T34fpb.g:1:486: RANGE_OP
                {
                mRANGE_OP(); 

                }
                break;
            case 61 :
                // ./grammer/T34fpb.g:1:495: VALUE_REF_ARG_PREFIX
                {
                mVALUE_REF_ARG_PREFIX(); 

                }
                break;
            case 62 :
                // ./grammer/T34fpb.g:1:516: TYPE_REF_ARG_PREFIX
                {
                mTYPE_REF_ARG_PREFIX(); 

                }
                break;
            case 63 :
                // ./grammer/T34fpb.g:1:536: T__99
                {
                mT__99(); 

                }
                break;
            case 64 :
                // ./grammer/T34fpb.g:1:542: T__100
                {
                mT__100(); 

                }
                break;
            case 65 :
                // ./grammer/T34fpb.g:1:549: T__101
                {
                mT__101(); 

                }
                break;
            case 66 :
                // ./grammer/T34fpb.g:1:556: T__102
                {
                mT__102(); 

                }
                break;
            case 67 :
                // ./grammer/T34fpb.g:1:563: T__103
                {
                mT__103(); 

                }
                break;
            case 68 :
                // ./grammer/T34fpb.g:1:570: T__104
                {
                mT__104(); 

                }
                break;
            case 69 :
                // ./grammer/T34fpb.g:1:577: T__105
                {
                mT__105(); 

                }
                break;
            case 70 :
                // ./grammer/T34fpb.g:1:584: T__106
                {
                mT__106(); 

                }
                break;
            case 71 :
                // ./grammer/T34fpb.g:1:591: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 72 :
                // ./grammer/T34fpb.g:1:602: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 73 :
                // ./grammer/T34fpb.g:1:613: WS
                {
                mWS(); 

                }
                break;
            case 74 :
                // ./grammer/T34fpb.g:1:616: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 75 :
                // ./grammer/T34fpb.g:1:627: CSTRING
                {
                mCSTRING(); 

                }
                break;
            case 76 :
                // ./grammer/T34fpb.g:1:635: BSTRING
                {
                mBSTRING(); 

                }
                break;
            case 77 :
                // ./grammer/T34fpb.g:1:643: HSTRING
                {
                mHSTRING(); 

                }
                break;
            case 78 :
                // ./grammer/T34fpb.g:1:651: OSTRING
                {
                mOSTRING(); 

                }
                break;
            case 79 :
                // ./grammer/T34fpb.g:1:659: BSTRING_MATCH
                {
                mBSTRING_MATCH(); 

                }
                break;
            case 80 :
                // ./grammer/T34fpb.g:1:673: HSTRING_MATCH
                {
                mHSTRING_MATCH(); 

                }
                break;
            case 81 :
                // ./grammer/T34fpb.g:1:687: OSTRING_MATCH
                {
                mOSTRING_MATCH(); 

                }
                break;
            case 82 :
                // ./grammer/T34fpb.g:1:701: INTEGER_VALUE
                {
                mINTEGER_VALUE(); 

                }
                break;
            case 83 :
                // ./grammer/T34fpb.g:1:715: FLOAT_VALUE
                {
                mFLOAT_VALUE(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA5_eotS =
        "\2\uffff\2\4\2\uffff";
    static final String DFA5_eofS =
        "\6\uffff";
    static final String DFA5_minS =
        "\2\57\2\0\2\uffff";
    static final String DFA5_maxS =
        "\2\57\2\uffff\2\uffff";
    static final String DFA5_acceptS =
        "\4\uffff\1\2\1\1";
    static final String DFA5_specialS =
        "\2\uffff\1\1\1\0\2\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\2",
            "\12\3\1\5\2\3\1\5\ufff2\3",
            "\12\3\1\5\2\3\1\5\ufff2\3",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "181:1: SL_COMMENT : ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' ) | '//' (~ ( '\\n' | '\\r' ) )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_3 = input.LA(1);

                        s = -1;
                        if ( ((LA5_3>='\u0000' && LA5_3<='\t')||(LA5_3>='\u000B' && LA5_3<='\f')||(LA5_3>='\u000E' && LA5_3<='\uFFFF')) ) {s = 3;}

                        else if ( (LA5_3=='\n'||LA5_3=='\r') ) {s = 5;}

                        else s = 4;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_2 = input.LA(1);

                        s = -1;
                        if ( ((LA5_2>='\u0000' && LA5_2<='\t')||(LA5_2>='\u000B' && LA5_2<='\f')||(LA5_2>='\u000E' && LA5_2<='\uFFFF')) ) {s = 3;}

                        else if ( (LA5_2=='\n'||LA5_2=='\r') ) {s = 5;}

                        else s = 4;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA26_eotS =
        "\1\uffff\1\3\2\uffff\1\3";
    static final String DFA26_eofS =
        "\5\uffff";
    static final String DFA26_minS =
        "\1\56\1\60\2\uffff\1\60";
    static final String DFA26_maxS =
        "\2\105\2\uffff\1\105";
    static final String DFA26_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA26_specialS =
        "\5\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1\26\uffff\1\2",
            "\12\4\13\uffff\1\2",
            "",
            "",
            "\12\4\13\uffff\1\2"
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "363:6: ( DOT DecimalNumber | ( DOT DecimalNumber )? Exponential ( MINUS )? NUMBER )";
        }
    }
    static final String DFA27_eotS =
        "\1\uffff\1\55\22\47\2\uffff\1\123\23\uffff\2\133\2\uffff\3\47\1"+
        "\141\40\47\12\uffff\1\133\1\uffff\3\47\1\uffff\16\47\1\uffff\22"+
        "\47\1\u00ba\4\47\1\u00bf\14\uffff\1\u00cb\3\47\1\u00cf\1\47\1\u00d1"+
        "\2\47\1\u00d4\1\47\1\u00d6\1\u00d7\5\47\1\u00dd\2\47\1\u00e3\1\47"+
        "\1\u00e6\15\47\1\uffff\1\47\1\u00f5\2\47\15\uffff\1\47\1\u00fa\1"+
        "\47\1\uffff\1\47\1\uffff\1\47\1\u00fe\1\uffff\1\u00ff\2\uffff\5"+
        "\47\1\uffff\1\u0105\4\47\1\uffff\2\47\1\uffff\1\47\1\u010d\6\47"+
        "\1\u0114\5\47\1\uffff\2\47\1\uffff\1\47\1\uffff\2\47\1\u011f\2\uffff"+
        "\1\47\1\u0121\2\47\1\u0124\1\uffff\1\u0125\3\47\1\u0129\2\47\1\uffff"+
        "\6\47\1\uffff\1\47\1\u0134\1\u0135\1\47\1\u0137\1\47\1\u0139\3\47"+
        "\1\uffff\1\u013d\1\uffff\1\u013e\1\47\2\uffff\1\47\1\u0141\1\u0142"+
        "\1\uffff\3\47\1\u0146\2\47\1\u0149\3\47\2\uffff\1\47\1\uffff\1\u014e"+
        "\1\uffff\1\47\1\u0150\1\u0151\2\uffff\1\u0152\1\47\2\uffff\3\47"+
        "\1\uffff\2\47\1\uffff\1\47\1\u015a\1\47\1\u015c\1\uffff\1\47\3\uffff"+
        "\3\47\1\u0161\1\u0162\1\47\1\u0164\1\uffff\1\u0165\1\uffff\1\47"+
        "\1\u0167\1\u0168\1\u0169\2\uffff\1\47\2\uffff\1\u016b\3\uffff\1"+
        "\u016c\2\uffff";
    static final String DFA27_eofS =
        "\u016d\uffff";
    static final String DFA27_minS =
        "\1\11\1\75\1\142\1\145\2\141\1\146\1\157\1\156\1\150\1\151\1\145"+
        "\1\141\1\156\1\157\2\145\1\151\1\145\1\154\2\uffff\1\56\16\uffff"+
        "\1\52\3\uffff\1\47\2\56\2\uffff\1\151\1\164\1\152\1\60\1\164\1\165"+
        "\1\155\1\160\1\162\1\151\2\157\1\163\1\143\1\40\1\160\1\156\1\162"+
        "\2\143\1\141\1\155\1\164\1\157\1\170\2\162\1\151\1\144\1\142\1\164"+
        "\1\156\1\164\1\156\1\143\1\154\4\uffff\1\47\1\102\3\47\1\uffff\1"+
        "\56\1\uffff\1\164\1\145\1\151\1\uffff\1\151\1\145\1\160\2\145\1"+
        "\163\1\154\1\141\1\155\1\163\1\164\1\157\1\145\1\151\1\uffff\1\157"+
        "\1\145\2\157\1\155\1\145\1\162\1\160\2\163\1\154\1\163\1\144\1\151"+
        "\1\157\1\151\1\163\1\145\1\60\1\147\1\150\1\164\1\157\1\60\1\102"+
        "\3\47\3\uffff\1\102\2\47\1\110\1\uffff\1\60\1\164\1\144\1\157\1"+
        "\60\1\154\1\60\1\141\1\145\1\60\1\164\2\60\1\145\1\156\1\147\1\156"+
        "\1\162\1\60\1\162\1\144\1\60\1\160\1\60\1\154\2\164\1\145\1\164"+
        "\1\151\1\141\1\145\1\156\1\146\1\154\1\145\1\162\1\uffff\1\164\1"+
        "\60\1\151\1\162\1\uffff\1\102\1\110\2\47\5\uffff\2\47\1\uffff\1"+
        "\163\1\60\1\156\1\uffff\1\141\1\uffff\1\144\1\60\1\uffff\1\60\2"+
        "\uffff\1\162\1\143\1\145\1\151\1\164\1\uffff\1\60\1\145\1\162\2"+
        "\145\1\uffff\2\164\1\uffff\1\145\1\60\1\162\1\141\1\162\1\143\1"+
        "\156\1\162\1\60\1\151\1\145\1\164\1\163\1\150\1\uffff\1\155\1\144"+
        "\1\110\1\164\1\uffff\1\141\1\164\1\60\2\uffff\1\156\1\60\1\162\1"+
        "\164\1\60\1\uffff\1\60\1\141\1\164\1\146\1\60\1\162\1\155\1\uffff"+
        "\1\151\1\156\1\151\2\164\1\163\1\uffff\1\145\2\60\1\145\1\60\1\145"+
        "\1\60\1\162\1\154\1\145\1\uffff\1\60\1\uffff\1\60\1\171\2\uffff"+
        "\1\164\2\60\1\uffff\1\151\1\145\1\156\1\60\1\156\1\164\1\60\1\141"+
        "\1\163\1\141\2\uffff\1\164\1\uffff\1\60\1\uffff\1\151\2\60\2\uffff"+
        "\1\60\1\145\2\uffff\2\156\1\147\1\uffff\1\147\1\171\1\uffff\1\154"+
        "\1\60\1\162\1\60\1\uffff\1\156\3\uffff\1\144\1\147\1\164\2\60\1"+
        "\160\1\60\1\uffff\1\60\1\uffff\1\147\3\60\2\uffff\1\145\2\uffff"+
        "\1\60\3\uffff\1\60\2\uffff";
    static final String DFA27_maxS =
        "\1\175\1\75\1\160\1\171\1\162\1\141\1\156\1\157\1\170\2\157\2\145"+
        "\1\156\1\157\1\165\1\145\1\151\1\165\1\154\2\uffff\1\56\16\uffff"+
        "\1\57\3\uffff\1\146\2\105\2\uffff\1\151\1\164\1\152\1\172\1\164"+
        "\1\165\1\155\1\160\1\162\1\154\2\157\2\164\1\40\1\160\1\156\1\162"+
        "\1\165\1\143\1\141\1\156\1\164\1\157\1\170\2\162\1\151\1\144\1\160"+
        "\1\164\1\156\1\164\1\156\1\143\1\154\4\uffff\1\146\1\117\3\146\1"+
        "\uffff\1\105\1\uffff\1\164\1\145\1\151\1\uffff\1\151\1\145\1\160"+
        "\2\145\1\163\1\154\1\141\1\155\1\163\1\164\1\157\1\145\1\151\1\uffff"+
        "\1\157\1\145\2\157\1\155\1\145\1\162\1\160\2\163\1\154\1\163\1\144"+
        "\1\151\1\166\1\165\1\163\1\145\1\172\1\147\1\150\1\164\1\157\1\172"+
        "\1\110\3\146\3\uffff\1\117\2\146\1\110\1\uffff\1\172\1\164\1\144"+
        "\1\157\1\172\1\154\1\172\1\141\1\145\1\172\1\164\2\172\1\145\1\156"+
        "\1\147\1\156\1\162\1\172\1\162\1\144\1\172\1\160\1\172\1\154\2\164"+
        "\1\145\1\164\1\151\1\141\1\145\1\156\1\146\1\154\1\145\1\162\1\uffff"+
        "\1\164\1\172\1\151\1\162\1\uffff\1\110\1\117\2\146\5\uffff\2\146"+
        "\1\uffff\1\163\1\172\1\156\1\uffff\1\141\1\uffff\1\144\1\172\1\uffff"+
        "\1\172\2\uffff\1\162\1\143\1\145\1\151\1\164\1\uffff\1\172\1\145"+
        "\1\162\2\145\1\uffff\2\164\1\uffff\1\145\1\172\1\162\1\141\1\162"+
        "\1\143\1\156\1\162\1\172\1\151\1\145\1\164\1\163\1\150\1\uffff\1"+
        "\155\1\144\1\117\1\164\1\uffff\1\141\1\164\1\172\2\uffff\1\156\1"+
        "\172\1\162\1\164\1\172\1\uffff\1\172\1\141\1\164\1\146\1\172\1\162"+
        "\1\155\1\uffff\1\151\1\156\1\151\2\164\1\163\1\uffff\1\145\2\172"+
        "\1\145\1\172\1\145\1\172\1\162\1\154\1\145\1\uffff\1\172\1\uffff"+
        "\1\172\1\171\2\uffff\1\164\2\172\1\uffff\1\151\1\145\1\156\1\172"+
        "\1\156\1\164\1\172\1\141\1\163\1\141\2\uffff\1\164\1\uffff\1\172"+
        "\1\uffff\1\151\2\172\2\uffff\1\172\1\145\2\uffff\2\156\1\147\1\uffff"+
        "\1\147\1\171\1\uffff\1\154\1\172\1\162\1\172\1\uffff\1\156\3\uffff"+
        "\1\144\1\147\1\164\2\172\1\160\1\172\1\uffff\1\172\1\uffff\1\147"+
        "\3\172\2\uffff\1\145\2\uffff\1\172\3\uffff\1\172\2\uffff";
    static final String DFA27_acceptS =
        "\24\uffff\1\64\1\65\1\uffff\1\67\1\71\1\72\1\73\1\75\1\76\1\77"+
        "\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\uffff\1\111\1\112\1"+
        "\113\3\uffff\1\1\1\70\44\uffff\1\74\1\66\1\107\1\110\5\uffff\1\122"+
        "\1\uffff\1\123\3\uffff\1\56\16\uffff\1\32\34\uffff\1\114\1\116\1"+
        "\115\4\uffff\1\120\45\uffff\1\54\4\uffff\1\46\4\uffff\1\114\1\116"+
        "\1\115\1\121\1\117\2\uffff\1\2\3\uffff\1\3\1\uffff\1\43\2\uffff"+
        "\1\6\1\uffff\1\51\1\5\5\uffff\1\10\5\uffff\1\61\2\uffff\1\12\16"+
        "\uffff\1\37\4\uffff\1\25\3\uffff\1\4\1\22\5\uffff\1\11\7\uffff\1"+
        "\44\6\uffff\1\53\12\uffff\1\63\1\uffff\1\7\2\uffff\1\50\1\40\3\uffff"+
        "\1\47\12\uffff\1\36\1\30\1\uffff\1\33\1\uffff\1\52\3\uffff\1\35"+
        "\1\16\2\uffff\1\60\1\62\3\uffff\1\15\2\uffff\1\41\4\uffff\1\42\1"+
        "\uffff\1\57\1\13\1\34\7\uffff\1\26\1\uffff\1\31\4\uffff\1\14\1\20"+
        "\1\uffff\1\24\1\45\1\uffff\1\55\1\23\1\27\1\uffff\1\17\1\21";
    static final String DFA27_specialS =
        "\u016d\uffff}>";
    static final String[] DFA27_transitionS = {
            "\2\46\2\uffff\1\46\22\uffff\1\46\1\uffff\1\50\1\34\1\33\2\uffff"+
            "\1\51\1\37\1\40\1\31\1\44\1\32\1\27\1\26\1\45\1\53\11\52\1\1"+
            "\1\24\1\uffff\1\43\1\uffff\1\30\1\uffff\32\47\1\41\1\uffff\1"+
            "\42\1\uffff\1\25\1\uffff\1\23\1\12\1\11\1\47\1\10\1\4\1\47\1"+
            "\13\1\6\2\47\1\20\1\16\1\7\1\2\1\5\1\47\1\22\1\17\1\3\1\15\1"+
            "\14\1\21\3\47\1\35\1\uffff\1\36",
            "\1\54",
            "\1\60\1\57\2\uffff\1\61\6\uffff\1\56\2\uffff\1\62",
            "\1\64\2\uffff\1\66\11\uffff\1\63\6\uffff\1\65",
            "\1\67\12\uffff\1\70\5\uffff\1\71",
            "\1\72",
            "\1\74\6\uffff\1\75\1\73",
            "\1\76",
            "\1\100\3\uffff\1\77\5\uffff\1\101",
            "\1\102\6\uffff\1\103",
            "\1\104\5\uffff\1\105",
            "\1\106",
            "\1\110\3\uffff\1\107",
            "\1\111",
            "\1\112",
            "\1\114\17\uffff\1\113",
            "\1\115",
            "\1\116",
            "\1\120\17\uffff\1\117",
            "\1\121",
            "",
            "",
            "\1\122",
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
            "\1\124\4\uffff\1\125",
            "",
            "",
            "",
            "\1\127\2\uffff\1\132\5\uffff\2\126\10\131\5\uffff\1\130\1"+
            "\uffff\6\131\32\uffff\6\131",
            "\1\135\1\uffff\12\134\13\uffff\1\135",
            "\1\135\26\uffff\1\135",
            "",
            "",
            "\1\136",
            "\1\137",
            "\1\140",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\150\2\uffff\1\147",
            "\1\151",
            "\1\152",
            "\1\153\1\154",
            "\1\155\2\uffff\1\157\15\uffff\1\156",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164\21\uffff\1\165",
            "\1\166",
            "\1\167",
            "\1\170\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081\15\uffff\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "",
            "",
            "",
            "",
            "\1\u0089\2\uffff\1\u008b\5\uffff\2\u008a\10\u008c\5\uffff"+
            "\1\u008b\1\uffff\6\u008c\32\uffff\6\u008c",
            "\1\u008d\5\uffff\1\u008f\6\uffff\1\u008e",
            "\1\u0090\2\uffff\1\132\5\uffff\2\u0091\10\u0092\5\uffff\1"+
            "\130\1\uffff\6\u0092\32\uffff\6\u0092",
            "\1\u0093\2\uffff\1\u0094\5\uffff\12\u008c\5\uffff\1\u0094"+
            "\1\uffff\6\u008c\32\uffff\6\u008c",
            "\1\u0090\2\uffff\1\132\5\uffff\2\u0091\10\u0092\5\uffff\1"+
            "\130\1\uffff\6\u0092\32\uffff\6\u0092",
            "",
            "\1\135\1\uffff\12\134\13\uffff\1\135",
            "",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b5\6\uffff\1\u00b4",
            "\1\u00b6\13\uffff\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u008d\5\uffff\1\u008f",
            "\1\127\2\uffff\1\132\5\uffff\2\126\10\131\5\uffff\1\130\1"+
            "\uffff\6\131\32\uffff\6\131",
            "\1\u00c0\2\uffff\1\u008b\5\uffff\2\u008b\10\u0094\5\uffff"+
            "\1\u008b\1\uffff\6\u0094\32\uffff\6\u0094",
            "\1\u00c1\2\uffff\1\u00c3\5\uffff\12\131\5\uffff\1\u00c2\1"+
            "\uffff\6\131\32\uffff\6\131",
            "",
            "",
            "",
            "\1\u00c8\5\uffff\1\u0094\6\uffff\1\u00c7",
            "\1\u00c0\2\uffff\1\u008b\5\uffff\2\u00c9\10\u00ca\5\uffff"+
            "\1\u008b\1\uffff\6\u00ca\32\uffff\6\u00ca",
            "\1\u0094\2\uffff\1\u0094\5\uffff\12\u00ca\5\uffff\1\u0094"+
            "\1\uffff\6\u00ca\32\uffff\6\u00ca",
            "\1\u008f",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d0",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d2",
            "\1\u00d3",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d5",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00de",
            "\1\u00df",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\u00e0\14"+
            "\47\1\u00e2\1\u00e1\7\47",
            "\1\u00e4",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\22\47\1\u00e5\7"+
            "\47",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "",
            "\1\u00f4",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00f6",
            "\1\u00f7",
            "",
            "\1\u00c8\5\uffff\1\u0094",
            "\1\u008f\6\uffff\1\u008e",
            "\1\u00f8\2\uffff\1\u00c3\5\uffff\12\u0092\5\uffff\1\u00c2"+
            "\1\uffff\6\u0092\32\uffff\6\u0092",
            "\1\u00f8\2\uffff\1\u00c3\5\uffff\12\u0092\5\uffff\1\u00c2"+
            "\1\uffff\6\u0092\32\uffff\6\u0092",
            "",
            "",
            "",
            "",
            "",
            "\1\u0090\2\uffff\1\132\5\uffff\2\u0091\10\u0092\5\uffff\1"+
            "\130\1\uffff\6\u0092\32\uffff\6\u0092",
            "\1\u00f8\2\uffff\1\u00c3\5\uffff\12\u0092\5\uffff\1\u00c2"+
            "\1\uffff\6\u0092\32\uffff\6\u0092",
            "",
            "\1\u00f9",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00fb",
            "",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "",
            "\1\u010a",
            "\1\u010b",
            "",
            "\1\u010c",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "",
            "\1\u011a",
            "\1\u011b",
            "\1\u0094\6\uffff\1\u00c7",
            "\1\u011c",
            "",
            "\1\u011d",
            "\1\u011e",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u0120",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0122",
            "\1\u0123",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u012a",
            "\1\u012b",
            "",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "",
            "\1\u0132",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\17\47\1\u0133\12"+
            "\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0136",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0138",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u013f",
            "",
            "",
            "\1\u0140",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0147",
            "\1\u0148",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "",
            "",
            "\1\u014d",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u014f",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0153",
            "",
            "",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "",
            "\1\u0157",
            "\1\u0158",
            "",
            "\1\u0159",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u015b",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u015d",
            "",
            "",
            "",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0163",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0166",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u016a",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ASSIGNMENT_CHAR | OMIT | TRUE | FALSE | PASS | FAIL | INCONC | NONE | ERROR | CHAR | TEMPLATE | BIT_STRING | BOOLEAN | INTEGER | OCTET_STRING | HEX_STRING | VERDICT_TYPE | FLOAT | CHAR_STRING | UNIVERSAL | OBJECT_IDENTIFIER | MODIFIES | COMPLEMENT | SUBSET | SUPERSET | IF_PRESENT | LENGTH | INFINITY | PATTERN | MODULE | WITH | ENCODE | VARIANT | RUNTIME | TYPE | CONST | MODULE_PAR | ALL | EXCEPT | IMPORT | FROM | RECORD | UNION | SET | ENUMERATED | OF | OPTIONAL | ENUM_SET | ENUM | ENUM_SET_REF | THREAD | SEMI_COLON | UNDER_SCORE | DOT | MINUS | COLON | ANY_VALUE | ANY_OR_OMIT | COMMA | RANGE_OP | VALUE_REF_ARG_PREFIX | TYPE_REF_ARG_PREFIX | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | ML_COMMENT | SL_COMMENT | WS | IDENTIFIER | CSTRING | BSTRING | HSTRING | OSTRING | BSTRING_MATCH | HSTRING_MATCH | OSTRING_MATCH | INTEGER_VALUE | FLOAT_VALUE );";
        }
    }
 

}