#ifndef TESTTEXTBITSET_H_
#define TESTTEXTBITSET_H_
#include <cppunit/extensions/HelperMacros.h>

class TestTextBitset : public CppUnit::TestFixture {
    CPPUNIT_TEST_SUITE( TestTextBitset );
    CPPUNIT_TEST( testGet );
//    CPPUNIT_TEST( testSet );
//   CPPUNIT_TEST( testAppend );
//    CPPUNIT_TEST( testPerformance );
//    CPPUNIT_TEST( testAppendBug );
    CPPUNIT_TEST_SUITE_END();
public:
	TestTextBitset();
	virtual ~TestTextBitset();
    void testGet();
    void testSet();
    void testAppend();
    void testAppendBug();
    void testPerformance();
};

#endif /*TESTTEXTBITSET_H_*/
