/****************************************************************
Fine Packet Builder, copyright (C) 2007-2009 fineqt.com

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
GNU General Public License for more details at gnu.org.
******************************************************************/
#ifndef AUTOTESTUTIL_H_
#define AUTOTESTUTIL_H_
#include <exception>
#include <sstream>
#include "AutotestExp.h"
class AutotestUtil {
public:
    enum TextBinType {
        INTEGER,
        HEX,
        ASCII
    };
//    typedef std::ios_base & (*BaseFunction)(std::ios_base&);
//    char BOOST_FILE_DLM = '/';
public:
//    template<typename T>
//    static void stringTo(const std::string & str, T & value, BaseFunction base = std::dec) throw(InvalidCastException) {
//        std::istringstream stm(str);
//        stm >> base >> value;
//        if (!stm) {
//            throw InvalidCastException();
//        }
//    }
//    template<typename T>
//    static std::string toString(const T& value, BaseFunction base = std::dec) throw(InvalidCastException) {
//        std::ostringstream stm;
//        stm << base << value;
//        if (!stm) {
//            throw InvalidCastException();
//        }
//        return stm.str();
//    }
    static void textToBin(const std::string & str, std::string & binBuf, TextBinType type) 
            throw(InvalidCastException);
    static void binToText(const std::string & binBuf, std::string & str, TextBinType type) 
            throw(InvalidCastException);
	/**
	 * @param outBuf 出力フォーマット[low, high, 0]
	 */
	static void getByteHexStr(unsigned char byte, std::string & outBuf);
	static void getByteAsciiStr(unsigned char byte, std::string & outBuf);            
//    static std::string binToText(const std::string binBuf, TextBinType type) 
//            throw(InvalidCastException);
private:
private:
	static char HEX_STR[];
};
#endif /*AUTOTESTUTIL_H_*/
