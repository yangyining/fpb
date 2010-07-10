// autotesttest.cpp : Defines the entry point for the console application.
//
#ifdef WIN32
#include <winsock2.h>
#endif /* for WIN32 */

#ifndef WIN32
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#endif /* for Linux */

#include "TextBitset.h"
#include "AutotestUtil.h"
#include <iostream>
#include <string>
#include <vector>

using namespace std;

#define CPPUNIT_ASSERT_EQUAL(left, right) assert(left == right)

extern void testGetDeviceList();
extern void testSendRecvPacket();
void 
dump(std::string & bin) {
	cout << "size:" << bin.size() << endl;
	string outBuf;
	for (unsigned int i=0; i < bin.size(); i++) {
		AutotestUtil::getByteHexStr(bin[i], outBuf);
		cout << outBuf.c_str() << " ";
	}
	cout << endl;
}

void 
testAutoUtilIntBin()
{    
	cout <<"-------------------" << __LINE__<< endl;
	AutotestUtil::TextBinType type;
	std::string ssa;
	std::string ssb;
	std::string ssc;
	std::string dst;
		
	//BYTE,SHORT,INTEGER <-> BIN;
	type = AutotestUtil::INTEGER;

	//byte,short,integer -> bin;
	//display input;
	ssa = "666535";
	cout << "integer : " << ssa << endl;
	/**
	 * Parameter:
	 * 		ssa	-	"666535"
	 * 		ssb	-	std::string
	 * 		type	-	INTEGER
	 * Return:
	 * 		ssb	-	std::string
	 */	
	AutotestUtil::textToBin(ssa,ssb,type);
	
	//confirm test;
	dst.resize(4);
	dst[0] = 0x00;
	dst[1] = 0x0A;
	dst[2] = 0x2B;
	dst[3] = 0xA7;
	CPPUNIT_ASSERT_EQUAL(4U, ssb.size());
	CPPUNIT_ASSERT_EQUAL(dst, ssb);
//    ACE_HEX_DUMP((LM_DEBUG, static_cast<const char *>(&dst[0]), dst.size()));

	//bin -> byte,short,integer;	
	/**
	 * Parameter:
	 * 		dst	-	[0x00 0x0A 0x2B 0xA7]
	 * 		ssc	-	std::string
	 * 		type	-	INTEGER
	 * Return:
	 * 		ssc	-	std::string
	 */	
	AutotestUtil::binToText(ssb, ssc, type);
	//confirm test;
	cout << "bin -> integer : " << ssc.c_str() << endl;		
}
void 
testAutoUtilHexBin()
{
	cout <<"-------------------" << __LINE__<< endl;
	AutotestUtil::TextBinType type;
	std::string ssa;
	std::string ssb;
	std::string ssc;
	std::string dst;
	
	//HEX <-> BIN;
	type = AutotestUtil::HEX;
	ssa = "F8B3C6F8B3C6F8B3C6F8B3C";

	//hex -> bin;
	//display input;
	cout << "hex : " << ssa << endl;
	/**
	 * Parameter:
	 * 		ssa	-	"F8B3C6F8B3C6F8B3C6F8B3C"
	 * 		ssb	-	std::string
	 * 		type	-	HEX
	 * Return:
	 * 		ssb	-	std::string
	 */	
	AutotestUtil::textToBin(ssa,ssb,type);
//	dump(ssb);
	//confirm test;
	dst.resize(12);
	dst[0] = 0x0F;
	dst[1] = 0x8B;
	dst[2] = 0x3C;
	dst[3] = 0x6F;
	dst[4] = 0x8B;
	dst[5] = 0x3C;
	dst[6] = 0x6F;
	dst[7] = 0x8B;
	dst[8] = 0x3C;
	dst[9] = 0x6F;
	dst[10] = 0x8B;
	dst[11] = 0x3C;
	CPPUNIT_ASSERT_EQUAL(12U, ssb.size());
	CPPUNIT_ASSERT_EQUAL(dst, ssb);
//    ACE_HEX_DUMP((LM_DEBUG, static_cast<const char *>(&dst[0]), dst.size()));

	//bin -> hex;
	/**
	 * Parameter:
	 * 		ssb	-	[0X0F 8B 3C 6F 8B 3C 6F 8B 3C 6F 8B 3C]
	 * 		ssc	-	std::string
	 * 		type	-	HEX
	 * Return:
	 * 		ssc	-	std::string
	 */	
	AutotestUtil::binToText(ssb,ssc,type);
	cout << "bin -> hex : " << ssc.c_str() << endl;
}
void 
testAutoUtilAsciiBin()
{
	cout <<"-------------------" <<  __LINE__<<endl;	
	AutotestUtil::TextBinType type;
	std::string ssa;
	std::string ssb;
	std::string ssc;
	std::string dst;

	//ASCII <-> BIN;
	type = AutotestUtil::ASCII;
	ssa = "\\x03Tb\\x02 a c \\\\122";	
	//ascii -> bin;	
	//display input;
	cout << "ascii : " << ssa << endl;
	/**
	 * Parameter:
	 * 		ssa	-	"\x03Tb\x02 a c \\122"
	 * 		ssb	-	std::string
	 * 		type	-	ASCII
	 * Return:
	 * 		ssb	-	std::string
	 */	
	AutotestUtil::textToBin(ssa,ssb,type);
	dump(ssb);		
	//confirm test;
	dst.resize(13);
	dst[0] = 0x03;
	dst[1] = 0x54;
	dst[2] = 0x62;
	dst[3] = 0x02;
	dst[4] = 0x20;
	dst[5] = 0x61;
	dst[6] = 0x20;
	dst[7] = 0x63;
	dst[8] = 0x20;
	dst[9] = 0x5C;
	dst[10] = 0x31;
	dst[11] = 0x32;
	dst[12] = 0x32;
	CPPUNIT_ASSERT_EQUAL(13U, ssb.size());
	CPPUNIT_ASSERT_EQUAL(dst, ssb);

	//bin -> ascii;
	/**
	 * Parameter:
	 * 		ssb	-		dst[0] = 0x03;
						dst[1] = 0x54;
						dst[2] = 0x62;
						dst[3] = 0x02;
						dst[4] = 0x20;
						dst[5] = 0x61;
						dst[6] = 0x20;
						dst[7] = 0x63;
						dst[8] = 0x20;
						dst[9] = 0x5C;
						dst[10] = 0x31;
						dst[11] = 0x32;
						dst[12] = 0x32;
	 * 		ssc	-	std::string
	 * 		type	-	ASCII
	 * Return:
	 * 		ssc	-	std::string
	 */	
	AutotestUtil::binToText(ssb,ssc,type);
	cout << "bin -> ascii : " << ssc.c_str() << endl;	
}
void
testMath() {
	char ch = 5;
	cout << "ch 1:" << hex << (0xFF & ch) << endl;
	ch ^= 0xFFU;
	cout << "ch 2:" << hex << (0xFF & ch) << endl;
	
	unsigned int intv = 0x88U;
	cout << "intv 1:" << hex << intv << endl;
	intv ^= 0xFFU;
//	intv = ~intv;
	cout << "intv 2:" << hex << intv << endl;
}

void 
testGet() {
    //0F,AA,F0
    string binbuf;
    binbuf.resize(3);
    binbuf[0] = 0x0F;
    binbuf[1] = 0xAA;
    binbuf[2] = 0xF0;
	//0FAAF0
    TextBitset bits(binbuf);
    string txtRst;
    txtRst = bits.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("000011111010101011110000"), txtRst);
    //off:4, len:16
    txtRst = bits.get(4, 16, TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("1111101010101111"), txtRst);
    txtRst = bits.get(4, 16, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("FAAF"), txtRst);
    txtRst = bits.get(4, 16, TextBitset::INTEGER);
    CPPUNIT_ASSERT_EQUAL(string("64175"), txtRst);
    txtRst = bits.get(4, 16, TextBitset::ASCII);
    CPPUNIT_ASSERT_EQUAL(string("\\xFA\\xAF"), txtRst);
    //off:4, len:8
    txtRst = bits.get(4, 8, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("FA"), txtRst);
    //off:0, len:24
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0FAAF0"), txtRst);
    //off:1 len:1
    bool bit =  bits.get(1);
    CPPUNIT_ASSERT_EQUAL(false, bit);
    //off:4, len:16 raw
	txtRst = bits.getRaw(4, 16);
	CPPUNIT_ASSERT_EQUAL(2U, txtRst.size());
	cout << "txtRst[0]:" << hex << (0xFF & txtRst[0]) << endl;
	cout << "txtRst[1]:" << hex << (0xFF & txtRst[1]) << endl;
	CPPUNIT_ASSERT_EQUAL((char)0xFAU, txtRst[0]);
	CPPUNIT_ASSERT_EQUAL((char)0xAFU, txtRst[1]);
	//off:0, len:24 raw
	txtRst = bits.getRaw();
	CPPUNIT_ASSERT_EQUAL(3U, txtRst.size());
	CPPUNIT_ASSERT_EQUAL((char)0x0FU, txtRst[0]);
	CPPUNIT_ASSERT_EQUAL((char)0xAAU, txtRst[1]);
	CPPUNIT_ASSERT_EQUAL((char)0xF0U, txtRst[2]);
}

void 
testSet() {
    //コンストラクタ
    TextBitset bits(string("0FAAF0"), TextBitset::HEX);
    string txtRst;
    string binbuf;
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0FAAF0"), txtRst);
    //off:4 len:16
    bits.set(4, 16, "AFFA", TextBitset::HEX);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("FFAAFF"), txtRst);
    //off:4 len:16 Integer
    bits.set(4, 16, "2720", TextBitset::INTEGER);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0FAAF0"), txtRst);
    //off:4 len:8
    bits.set(4, 8, "BB", TextBitset::HEX);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0FBAFB"), txtRst);
    //off:0 len:24
    bits.set(0, 24, "FAFFAF", TextBitset::HEX);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("FAFFAF"), txtRst);
    //off:4 len:8 raw
    binbuf.resize(1);
    binbuf[0] = (char)0xCCU;
    bits.setRaw(4, 8, binbuf);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("FACFAC"), txtRst);
    //off:0 len:24
    binbuf.resize(3);
    binbuf[0] = (char)0xFAU;
    binbuf[1] = (char)0xFFU;
    binbuf[2] = (char)0xAFU;
    bits.setRaw(0, 24, binbuf);
    txtRst = bits.get(0, 24, TextBitset::HEX);
//    cout << "txtRst:" << txtRst << endl;
    CPPUNIT_ASSERT_EQUAL(string("FAFFAF"), txtRst);
}

void 
testReverse() {
	TextBitset bits(false);
    string rawRst;
    string txtRst;
    string binbuf;
    //off:0 len:24 set
    binbuf.resize(3);
    binbuf[0] = (char)0x0FU;
    binbuf[1] = (char)0xAAU;
    binbuf[2] = (char)0xF0U;
    bits.setRaw(binbuf);
    txtRst = bits.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("000011111010101011110000"), txtRst);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0FAAF0"), txtRst);
    //off:0 len:24 get
	rawRst = bits.getRaw();
	CPPUNIT_ASSERT_EQUAL(3U, rawRst.size());
	CPPUNIT_ASSERT_EQUAL((char)0x0FU, rawRst[0]);
	CPPUNIT_ASSERT_EQUAL((char)0xAAU, rawRst[1]);
	CPPUNIT_ASSERT_EQUAL((char)0xF0U, rawRst[2]);
	//off:4 len:16 set
    binbuf.resize(2);
    binbuf[0] = (char)0xBBU;
    binbuf[1] = (char)0xCCU;
    bits.setRaw(4, 16, binbuf);
    txtRst = bits.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("000010111011110011000000"), txtRst);
    txtRst = bits.get(0, 24, TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0BBCC0"), txtRst);
	//off:4 len:16 get
	rawRst = bits.getRaw(4, 16);
	CPPUNIT_ASSERT_EQUAL(2U, rawRst.size());
	CPPUNIT_ASSERT_EQUAL((char)0xBBU, rawRst[0]);
	CPPUNIT_ASSERT_EQUAL((char)0xCCU, rawRst[1]);
	//off:4 len:8 set bin
	bits.set(4, 8, "00001111", TextBitset::BIN);
	txtRst = bits.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("000000001111110011000000"), txtRst);
	
	//append
    //3byte+4byte
    TextBitset set1("0FAAF0", TextBitset::HEX);
    TextBitset set2("BBCCDDEE", TextBitset::HEX);
    set1.append(set2);
    txtRst = set1.get(TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("0FAAF0BBCCDDEE"), txtRst);
}

void 
testAppend() {
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
    CPPUNIT_ASSERT_EQUAL(string("F090"), txtRst);
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
testAppendBug() {
    TextBitset set1("1", TextBitset::BIN);
    TextBitset set2("00A8", TextBitset::HEX);
    string txtRst;
    set1.append(set2);
    txtRst = set1.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("00000000000101011"), txtRst);
    
}
void
testSetBug() {
    string txtRst;
    string rawRst;
	//Integerを8以下長さのフィールドに設定
	//1bit
	TextBitset binbuf("0", TextBitset::BIN);
	binbuf.set(0, 1, "1", TextBitset::INTEGER);
    txtRst = binbuf.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("1"), txtRst);
    txtRst = binbuf.get(TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("80"), txtRst);
    txtRst = binbuf.get(TextBitset::INTEGER);
    CPPUNIT_ASSERT_EQUAL(string("1"), txtRst);
    
    //4bit
    binbuf.set("0000", TextBitset::BIN);
	binbuf.set(0, 4, "10", TextBitset::INTEGER);
    txtRst = binbuf.get(TextBitset::BIN);
    CPPUNIT_ASSERT_EQUAL(string("1010"), txtRst);
    txtRst = binbuf.get(TextBitset::HEX);
    CPPUNIT_ASSERT_EQUAL(string("A0"), txtRst);
    txtRst = binbuf.get(TextBitset::INTEGER);
    CPPUNIT_ASSERT_EQUAL(string("10"), txtRst);
}

int main(int , char* [])
{
//testAutoUtilIntBin();
//testAutoUtilHexBin();
//testAutoUtilAsciiBin();
//testGet();
//testSet();
//testReverse();
//testAppend();
//testAppendBug();
//testSetBug();
//    CppUnit::TextUi::TestRunner runner;
//    runner.addTest( TestAutotestUtil::suite() );
//    runner.addTest( TestTextBitset::suite() );
//    runner.run();
	
	//pcap test
	testGetDeviceList();
	testSendRecvPacket();
	return 0;
}

