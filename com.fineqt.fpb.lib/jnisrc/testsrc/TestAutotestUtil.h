#ifndef TESTAUTOTESTUTIL_H_
#define TESTAUTOTESTUTIL_H_

#include <cppunit/extensions/HelperMacros.h>
using namespace std;
class TestAutotestUtil : public CppUnit::TestFixture
{
	CPPUNIT_TEST_SUITE( TestAutotestUtil );
//	CPPUNIT_TEST( testAutoUtilIntBin );
//    CPPUNIT_TEST( testAutoUtilHexBin );
//    CPPUNIT_TEST( testAutoUtilAsciiBin );
//    CPPUNIT_TEST( testNumberCast );
//    CPPUNIT_TEST( testBitSet );
    CPPUNIT_TEST_SUITE_END();
public:
	TestAutotestUtil();
	virtual ~TestAutotestUtil();
public:
    void testAutoUtilIntBin();
    void testAutoUtilHexBin();
    void testAutoUtilAsciiBin();
//    void testNumberCast();
//    void testBitSet();
private:
};
#endif /*TESTAUTOTESTUTIL_H_*/
