#include "TestTextBitset.h"
#include "TextBitset.h"
#include <iostream>
#include <string>

using namespace std;

TestTextBitset::TestTextBitset()
{
}

TestTextBitset::~TestTextBitset()
{
}

void 
TestTextBitset::testGet() {
    //0F,AA,F0
    string binbuf;
    binbuf.resize(3);
    binbuf[0] = 0x0F;
    binbuf[1] = 0xAA;
    binbuf[2] = 0xF0;
    TextBitset bits(binbuf);
    string txtRst;
    //off:4, len:16
    txtRst = bits.get(4, 16, TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("1111101010101111"), txtRst);
    txtRst = bits.get(4, 16, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("FAAF"), txtRst);
    txtRst = bits.get(4, 16, TextBitset::INTEGER);
    CPPUNIT_ASSERT_EQUAL(string("64175"), txtRst);
    txtRst = bits.get(4, 16, TextBitset::ASCII);
    CPPUNIT_ASSERT_EQUAL(string("\\Xfa\\Xaf"), txtRst);
    //off:4, len:8
    txtRst = bits.get(4, 8, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("AF"), txtRst);
    //off:0, len:24
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0FAAF0"), txtRst);
//    cout << "txtRst:" << txtRst << endl;
    //off:4, len:16 raw
	txtRst = bits.getRaw(4, 16);
	CPPUNIT_ASSERT_EQUAL(2U, txtRst.size());
	CPPUNIT_ASSERT_EQUAL((char)0xAFU, txtRst[0]);
	CPPUNIT_ASSERT_EQUAL((char)0xFAU, txtRst[1]);
}

void 
TestTextBitset::testSet() {
    //コンストラクタ
    TextBitset bits(string("0FAAF0"), TextBitset::HEX);
    string txtRst;
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0FAAF0"), txtRst);
//    cout << "txtRst:" << txtRst << endl;
    //off:4 len:16
    bits.set(4, 16, "AFFA", TextBitset::HEX);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0AFFA0"), txtRst);
    //off:4 len:8
    bits.set(4, 8, "BB", TextBitset::HEX);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0AFBB0"), txtRst);
    //off:0 len:24
    bits.set(0, 24, "FAFFAF", TextBitset::HEX);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("FAFFAF"), txtRst);
}

void 
TestTextBitset::testAppend() {
    //3byte+4byte
    TextBitset set1("0FAAF0", TextBitset::HEX);
    TextBitset set2("BBCCDDEE", TextBitset::HEX);
    set1.append(set2);
    string txtRst;
    txtRst = set1.get(TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("BBCCDDEE0FAAF0"), txtRst);
    //4bit+8bit
    set1 = TextBitset("1001", TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(4U, set1.size());
    set2 = TextBitset("11110000", TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(8U, set2.size());
    set1.append(set2);
    CPPUNIT_ASSERT_EQUAL(12U, set1.size());
    txtRst = set1.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("111100001001"), txtRst);
    txtRst = set1.get(TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0F09"), txtRst);
    //push back
    set1.pushBack(true);
    txtRst = set1.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(13U, set1.size());
    CPPUNIT_ASSERT_EQUAL(string("1111100001001"), txtRst);
    //resize
    set1.resize(8);
    txtRst = set1.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("00001001"), txtRst);
}

void 
TestTextBitset::testAppendBug() {
    TextBitset set1("1", TextBitset::BIN);
    TextBitset set2("00A8", TextBitset::HEX);
    string txtRst;
    set1.append(set2);
    txtRst = set1.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("00000000101010001"), txtRst);
}

void 
TestTextBitset::testPerformance() {
    for (int i =0; i < 10000; i++) {
        testGet();
        testSet();
        testAppend();
    }
}
