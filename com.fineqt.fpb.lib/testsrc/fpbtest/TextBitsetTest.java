package fpbtest;
import junit.framework.TestCase;

import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;


public class TextBitsetTest extends TestCase {
public void _testCreate() throws Exception {
	TextBitset bitset = new NativeTextBitset();
	bitset = null;
	System.gc();
}
public void _testCreateNewInstance() throws Exception {
	TextBitset bitset = TextBitset.class.newInstance();
	bitset = null;
	System.gc();
}
public void _testGet() throws Exception {
    //0F,AA,F0
    byte[] binbuf = new byte[3];
    binbuf[0] = (byte)0x0F;
    binbuf[1] = (byte)0xAA;
    binbuf[2] = (byte)0xF0;
    TextBitset bits = new NativeTextBitset(binbuf);
    String txtRst;
    //off:4, len:16
    txtRst = bits.get(4, 16, TextBitset.BIN);
    assertEquals("1111101010101111", txtRst);
    txtRst = bits.get(4, 16, TextBitset.HEX);
    assertEquals("FAAF", txtRst);
    txtRst = bits.get(4, 16, TextBitset.INTEGER);
    assertEquals("64175", txtRst);
    txtRst = bits.get(4, 16, TextBitset.ASCII);
    assertEquals("\\xFA\\xAF", txtRst);
    //off:4, len:8
    txtRst = bits.get(4, 8, TextBitset.HEX);
    assertEquals("FA", txtRst);
    //off:0, len:24
    txtRst = bits.get(0, 24, TextBitset.HEX);
    assertEquals("0FAAF0", txtRst);
    //off:1 len:1
    boolean bit =  bits.getBit(1);
    assertTrue(bit == false);
    //off:4, len:16 raw
    byte[] rawRst;
    rawRst = bits.getRaw(4, 16);
    assertEquals(2, rawRst.length);
    assertEquals((byte)0xFA, rawRst[0]);
    assertEquals((byte)0xAF, rawRst[1]);
    //off:0, len:24
    rawRst = bits.getRaw();
    assertEquals(3, rawRst.length);
    assertEquals((byte)0x0F, rawRst[0]);
    assertEquals((byte)0xAA, rawRst[1]);
    assertEquals((byte)0xF0, rawRst[2]);
}

public void _testSet() throws Exception {
    //コンストラクタ
    TextBitset bits = new NativeTextBitset("0FAAF0", TextBitset.HEX);
    String txtRst;
    txtRst = bits.get(0, 24, TextBitset.HEX);
    assertEquals("0FAAF0", txtRst);
    //off:4 len:16
    bits.set(4, 16, "AFFA", TextBitset.HEX);
    txtRst = bits.get(0, 24, TextBitset.HEX);
    assertEquals("0AFFA0", txtRst);
    //off:4 len:16 Integer
    bits.set(4, 16, "64175", TextBitset.INTEGER);
    txtRst = bits.get(0, 24, TextBitset.HEX);
    assertEquals("0FAAF0", txtRst);
    //off:4 len:8
    bits.set(4, 8, "BB", TextBitset.HEX);
    txtRst = bits.get(0, 24, TextBitset.HEX);
    assertEquals("0BBAF0", txtRst);
    //off:0 len:24
    bits.set(0, 24, "FAFFAF", TextBitset.HEX);
    txtRst = bits.get(0, 24, TextBitset.HEX);
    assertEquals("FAFFAF", txtRst);
    //off:1 len:1
    bits.setBit(0, false);
    txtRst = bits.get(TextBitset.HEX);
    assertEquals("7AFFAF", txtRst);
    //off:4 len:8 Raw
    bits.setRaw(4, 8, new byte[]{(byte)0xCC});
    txtRst = bits.get(0, 24, TextBitset.HEX);
    assertEquals("7CCFAF", txtRst);
    //off:0 len:24
    bits.setRaw(0, 24, new byte[]{(byte)0xFA, (byte)0xFF, (byte)0xAF});
    txtRst = bits.get(0, 24, TextBitset.HEX);
    assertEquals("FAFFAF", txtRst);
    //コンストラクタ
    bits = new NativeTextBitset();
    //1文字不足（２バイト）
    bits.set("123", TextBitset.HEX);
    assertEquals("0123", bits.get(TextBitset.HEX));
    //1文字不足（１バイト）
    bits.set("1", TextBitset.HEX);
    assertEquals("01", bits.get(TextBitset.HEX));
}

public void _testRaw() {
    byte[] binbuf = new byte[3];
    byte[] binrst;
    //setRaw then getRaw
    binbuf[0] = (byte)0x0F;
    binbuf[1] = (byte)0xAA;
    binbuf[2] = (byte)0xF0;
    TextBitset bits = new NativeTextBitset();
    bits.setRaw(binbuf);
    binrst = bits.getRaw();
    assertEquals(3, binrst.length);
    assertEquals((byte)0x0F, binrst[0]);
    assertEquals((byte)0xAA, binrst[1]);
    assertEquals((byte)0xF0, binrst[2]);
    //append then getRaw
    binbuf[0] = (byte)0xCC;
    binbuf[1] = (byte)0xDD;
    binbuf[2] = (byte)0xEE;
    bits.append(binbuf);
    binrst = bits.getRaw();
    assertEquals(6, binrst.length);
    assertEquals((byte)0x0F, binrst[0]);
    assertEquals((byte)0xAA, binrst[1]);
    assertEquals((byte)0xF0, binrst[2]);
    assertEquals((byte)0xCC, binrst[3]);
    assertEquals((byte)0xDD, binrst[4]);
    assertEquals((byte)0xEE, binrst[5]);
}

public void _testAccessNumber() throws Exception{
	TextBitset bits;
	//get int
    bits = new NativeTextBitset();
    bits.set("0001FFFF", TextBitset.HEX);
    assertEquals(32, bits.size());
    assertEquals("0001FFFF", bits.get(TextBitset.HEX));
    assertEquals(0x0001FFFF, bits.getAsInteger());
	
    //set int
    bits = new NativeTextBitset();
    bits.resize(TextBitset.INTEGER_LENGTH);
    bits.setAsInteger(0x0001FFFF);
    assertEquals("0001FFFF", bits.get(TextBitset.HEX));
    assertEquals(0x0001FFFF, bits.getAsInteger());
    
    //int set->get 32bit
    bits = new NativeTextBitset();
    bits.resize(TextBitset.INTEGER_LENGTH);
    bits.setAsInteger(216);
    assertEquals("000000D8", bits.get(TextBitset.HEX));
    assertEquals(216, bits.getAsInteger());
    
    //int set->get 16bit
    bits = new NativeTextBitset();
    bits.resize(16);
    bits.setAsInteger(216);
    assertEquals("00D8", bits.get(TextBitset.HEX));
    assertEquals(216, bits.getAsInteger());
    
    //int set->get 1bit
    bits = new NativeTextBitset();
	bits.resize(1);
	bits.setAsInteger(1);
	assertEquals("80", bits.get(TextBitset.HEX));
	assertEquals("1", bits.get(TextBitset.INTEGER));
    assertEquals(1, bits.getAsInteger());

    //int set->get 4bit
    bits = new NativeTextBitset();
	bits.resize(4);
	bits.setAsInteger(10);
	assertEquals("A0", bits.get(TextBitset.HEX));
	assertEquals("10", bits.get(TextBitset.INTEGER));
    assertEquals(10, bits.getAsInteger());
    
    //intの最大値
    bits = new NativeTextBitset();
	bits.resize(32);
	bits.setAsInteger(0xFFFFFFFF);
	assertEquals("FFFFFFFF", bits.get(TextBitset.HEX));
	assertEquals("4294967295", bits.get(TextBitset.INTEGER));
	assertEquals(0xFFFFFFFFL, bits.getAsInteger());

	//0x2f30(12 bit, LittleEndian) ->2 byte -> 0x2f, 0x03 
	//Little Endianの数字に対して一番右のバイトが不完全の場合に、そのバイトを右シフトすることで
	//このバイトの真の値を取得できる。
    bits = new NativeTextBitset();
	bits.resize(12);
	bits.set("2f30", TextBitset.HEX);
	assertEquals("2F30", bits.get(TextBitset.HEX));
	byte[] bytes = bits.getRaw();
	assertEquals(2, bytes.length);
	assertEquals((byte)0x2f, bytes[0]);
	assertEquals((byte)0x03, bytes[1] >> 4);
	
}

public void _testAppend() throws Exception {
	//3byte+4byte
    TextBitset set1 = new NativeTextBitset("0FAAF0", TextBitset.HEX);
    TextBitset set2 = new NativeTextBitset("BBCCDDEE", TextBitset.HEX);
    set1.append(set2);
    String txtRst;
    txtRst = set1.get(TextBitset.HEX);
    assertEquals("0FAAF0BBCCDDEE", txtRst);
    //4bit+8bit
    set1 = new NativeTextBitset("1001", TextBitset.BIN);
    assertEquals(4, set1.size());
    set2 = new NativeTextBitset("11110000", TextBitset.BIN);
    assertEquals(8, set2.size());
    set1.append(set2);
    assertEquals(12, set1.size());
    txtRst = set1.get(TextBitset.BIN);
    assertEquals("100111110000", txtRst);
    txtRst = set1.get(TextBitset.HEX);
    assertEquals("9F00", txtRst);
    //push back
    set1.pushBack(true);
    txtRst = set1.get(TextBitset.BIN);
    assertEquals(13, set1.size());
    assertEquals("1001111100001", txtRst);
    //resize
    set1.resize(8);
    txtRst = set1.get(TextBitset.BIN);
    assertEquals("10011111", txtRst);
//	    System.out.println("txtRst:"+txtRst);
}
public void _testAppendBug() {
	//boostのdynamic_bitsetのバッグのせいで0000000010101000+1は01111111101010001になるバッグがある
	TextBitset set1 = new NativeTextBitset("1", TextBitset.BIN);
	TextBitset set2;
	set2 = new NativeTextBitset("00A8", TextBitset.HEX);
	set1.append(set2);
	assertEquals("00000000101010001", set1.get(TextBitset.BIN));
}

public void _testSubset() {
    TextBitset bits = new NativeTextBitset("0FAAF0", TextBitset.HEX);
    String txtRst;
    txtRst = bits.get(TextBitset.HEX);
    assertEquals("0FAAF0", txtRst);
    //subset offset:0 len:24
    TextBitset sub = bits.subset(0, 24);
    txtRst = bits.get(TextBitset.HEX);
    assertEquals("0FAAF0", txtRst);
    //subset offset:0 len:12
    sub = bits.subset(0, 12);
    txtRst = sub.get(TextBitset.HEX);
    assertEquals(12, sub.size());
    assertEquals("0FA0", txtRst);    
    //subset offset:12 len:12
    sub = bits.subset(12, 12);
    assertEquals(12, sub.size());
    txtRst = sub.get(TextBitset.HEX);
    assertEquals("AF00", txtRst); 
    //
    bits = new NativeTextBitset("01FF", TextBitset.HEX);
    sub = bits.subset(3, 13);
    assertEquals("0FF8", sub.get(TextBitset.HEX));
    sub = bits.subset(4, 12);
    assertEquals("1FF0", sub.get(TextBitset.HEX));
}

public void _testShift() throws Exception {
    TextBitset set = new NativeTextBitset("BBCCDDEF", TextBitset.HEX);
    assertEquals("10111011110011001101110111101111", set.get(TextBitset.BIN));
    set.shiftRight(1);
    assertEquals("01011101111001100110111011110111", set.get(TextBitset.BIN));
    set.shiftLeft(1);
    assertEquals("10111011110011001101110111101110", set.get(TextBitset.BIN));
}

public void _testResize() throws Exception {
    TextBitset set = new NativeTextBitset("BBCCDDEF", TextBitset.HEX);
    assertEquals("10111011110011001101110111101111", set.get(TextBitset.BIN));
    set.resize(12);
    assertEquals("101110111100", set.get(TextBitset.BIN));
}

public void _testAppendByte() throws Exception {
    TextBitset set = new NativeTextBitset("FFFF", TextBitset.HEX);
    set.append((byte)0xAA);
    assertEquals("FFFFAA", set.get(TextBitset.HEX));
    set = new NativeTextBitset("FFFF", TextBitset.HEX);    
    set.append(new byte[]{(byte)0xCC, (byte)0xDD});
    assertEquals("FFFFCCDD", set.get(TextBitset.HEX));
}

//public void _testScript() {
//    PythonInterpreter interp = new PythonInterpreter(); 
//    interp.exec("import autotestTest");
////    interp.exec("bitset = autotest.TextBitset()");
////    interp.exec("print 'bitset size:', bitset.size()");
//    PyCode codeGet = __builtin__.compile("autotestTest.testTextBitsetGet()", "<>", "exec");
//    PyCode codeSet = __builtin__.compile("autotestTest.testTextBitsetSet()", "<>", "exec");
//    PyCode codeAppend = __builtin__.compile("autotestTest.testTextBitsetAppend()", "<>", "exec");
//    
//    for (int i = 0; i < 10000; i++) {
//        interp.exec(codeGet);
//        interp.exec(codeSet);
//        interp.exec(codeAppend);
//    }
//}

public void testJavaAll() throws Exception {
	_testGet();
	_testSet();
	_testAppend();
	_testAccessNumber();
	_testRaw();
	_testSubset();
	_testShift();
	_testResize();
}

public void _testPerformance() throws Exception {
    for (int i = 0; i < 10000; i++) {
    	_testGet();
    	_testSet();
    	_testAppend();
    }
}
public void _testJavaThread() throws Exception {
	class ThreadTest extends Thread {
		TextBitsetTest parent;
		ThreadTest(TextBitsetTest parent) {
			this.parent = parent;
		}
		public void run() {
			System.out.println("start java thread");
			try {
			    for (int i = 0; i < 2000; i++) {
					parent._testGet();
					parent._testSet();
					parent._testAppend();
			    }
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("end thread");
		}
	}
	final int cnt = 10;
	ThreadTest[] tests = new ThreadTest[cnt];
	//開始
	for (int i = 0; i < tests.length; i++) {
		tests[i] = new ThreadTest(this);
		tests[i].start();
		Thread.sleep(100);
	}
	//終了待ち
	for (int i = 0; i < tests.length; i++) {
		tests[i].join();
	}
}
//public void _testScriptThread() throws Exception {
//	class ThreadTest extends Thread {
//		TextBitsetTest parent;
//		ThreadTest(TextBitsetTest parent) {
//			this.parent = parent;
//		}
//		public void run() {
//			System.out.println("start script thread");
//		    PythonInterpreter interp = new PythonInterpreter(); 
//		    interp.exec("import autotest");
//		    PyCode codeGet = __builtin__.compile("autotest.testTextBitsetGet()", "<>", "exec");
//		    PyCode codeSet = __builtin__.compile("autotest.testTextBitsetSet()", "<>", "exec");
//		    PyCode codeAppend = __builtin__.compile("autotest.testTextBitsetAppend()", "<>", "exec");
//			try {
//			    for (int i = 0; i < 2000; i++) {
//			        interp.exec(codeGet);
//			        interp.exec(codeSet);
//			        interp.exec(codeAppend);
//			    }
//			}
//			catch (Exception ex) {
//				ex.printStackTrace();
//			}
//			System.out.println("end thread");
//		}
//	}
//	final int cnt = 10;
//	ThreadTest[] tests = new ThreadTest[cnt];
//	//開始
//	for (int i = 0; i < tests.length; i++) {
//		tests[i] = new ThreadTest(this);
//		tests[i].start();
//		Thread.sleep(100);
//	}
//	//終了待ち
//	for (int i = 0; i < tests.length; i++) {
//		tests[i].join();
//	}
//}
}
