#include "stdafx.h"
#include "TestAutotestUtil.h"
#include "AutotestUtil.h";
#include <boost/dynamic_bitset.hpp>

#include <iostream>
using namespace boost;

void dump(std::string & bin) {
	cout << "size:" << bin.size() << endl;
	string outBuf;
	for (int i=0; i < bin.size(); i++) {
		AutotestUtil::getByteHexStr(bin[i], outBuf);
		cout << outBuf.c_str() << " ";
	}
	cout << endl;
}

TestAutotestUtil::TestAutotestUtil()
{
}

TestAutotestUtil::~TestAutotestUtil()
{
}
void 
TestAutotestUtil::testAutoUtilIntBin()
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
TestAutotestUtil::testAutoUtilHexBin()
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
	 * 		ssa	-	"6F8B3C6F8B3C6F8B3C6F8B3C"
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
	 * 		ssb	-	[0X6F 8B 3C 6F 8B 3C 6F 8B 3C 6F 8B 3C]
	 * 		ssc	-	std::string
	 * 		type	-	HEX
	 * Return:
	 * 		ssc	-	std::string
	 */	
	AutotestUtil::binToText(ssb,ssc,type);
	cout << "bin -> hex : " << ssc.c_str() << endl;
}
void 
TestAutotestUtil::testAutoUtilAsciiBin()
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

//void 
//TestAutotestUtil::testNumberCast() {
//    //十進法
//    string str = "10";
//    int nValue;
//    AutotestUtil::stringTo(str, nValue);
//    CPPUNIT_ASSERT_EQUAL(10, nValue);
//    str = "abc";
//    try {
//        AutotestUtil::stringTo(str, nValue);
//        CPPUNIT_ASSERT(false);
//    }
//    catch (InvalidCastException &ex){
//    }
//    nValue = 100;
//    str = AutotestUtil::toString(nValue);
//    CPPUNIT_ASSERT_EQUAL(string("100"), str);
//    //十六進法
//    str = "10";
//    AutotestUtil::stringTo(str, nValue, hex);
//    CPPUNIT_ASSERT_EQUAL(16, nValue);
//    nValue = 255;
//    str = AutotestUtil::toString(nValue, hex);
//    CPPUNIT_ASSERT_EQUAL(string("ff"), str);
//}

//void
//TestAutotestUtil::testBitSet() {
//	//stringバッファーの構築
//	string buf;
//	buf.resize(4);
//	buf[0] = 0x42;
//	buf[1] = 0xFF;
//	buf[2] = 0xFF;
//	buf[3] = 0xFF;
//    ACE_HEX_DUMP((LM_DEBUG, &buf[0], buf.size(), "buf1:"));
//    
//	//stringバッファーからbitsetへ
//	dynamic_bitset<unsigned char> bitbuf; 
//	bitbuf.append(buf.rbegin(), buf.rend());
//	cout << "bitbuf:" << bitbuf << endl;	
//	cout << "bitbuf << 1:" << (bitbuf<<1) << endl;	
//	cout << "bitbuf >> 1:" << (bitbuf>>1) << endl;	
//	
//	//bitsetからstringバッファーへ
//	string buf2;
//	buf2.resize(4);
//	to_block_range(bitbuf, buf2.rbegin());
//    ACE_HEX_DUMP((LM_DEBUG, &buf2[0], buf2.size(), "buf2:"));
//    
//    //バッファーの合併
//    //0x4ff(12ビット)
//    string slice1;
//    slice1.resize(2);
//    slice1[0] = 0x04;
//    slice1[1] = 0xFF;
//    ACE_HEX_DUMP((LM_DEBUG, &slice1[0], slice1.size(), "slice1:"));
//    //0x6 (0110)
//    string slice2;
//    slice2.resize(1);
//    slice2[0] = 0x6;
//    ACE_HEX_DUMP((LM_DEBUG, &slice2[0], slice2.size(), "slice2:"));
//    //slice1+slice2
//    dynamic_bitset<unsigned char> sets;
//    sets.append(slice1.rbegin(), slice1.rend());
//    sets.resize(12);
//	cout << "sets 1:" << sets << endl;	
//    sets.append(slice2.rbegin(), slice2.rend());
//	sets.resize(12+4);
//	cout << "sets 2:" << sets << endl;	
//}
