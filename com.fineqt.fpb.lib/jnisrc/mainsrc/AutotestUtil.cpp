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
#include "AutotestUtil.h"
#include <cstdlib>
#include <iostream>
#include <bitset>
#include <math.h>
#include <vector>
#include <cassert>
using namespace std;

char AutotestUtil::HEX_STR[] = {
	'0',
	'1',
	'2',
	'3',
	'4',
	'5',
	'6',
	'7',
	'8',
	'9',
	'A',
	'B',
	'C',
	'D',
	'E',
	'F'
};

unsigned char getHexCharValue(unsigned char hexChar) {
	if (hexChar >= '0' && hexChar <= '9') {
		return hexChar - '0';
	}
	else if (hexChar >= 'A' && hexChar <= 'F') {
		return hexChar - 'A' + 10;
	}
	else if (hexChar >= 'a' && hexChar <= 'f') {
		return hexChar - 'a' + 10;
	}
	//到達しないはず
	assert(false);
	return 0;
}

void 
AutotestUtil::getByteHexStr(unsigned char byte, std::string & outBuf) {
	outBuf.resize(2);
	unsigned char temp = byte & 0x0F;
	outBuf[1] = HEX_STR[temp];
	temp = byte & 0xF0;
	temp >>= 4;
	outBuf[0] = HEX_STR[temp];
}

void 
AutotestUtil::getByteAsciiStr(unsigned char byte, std::string & outBuf) {
	//可視文字
	if (byte <= 126 &&  byte >= 32) {
		//Escapeではない
		if (byte != '\\') {
			outBuf.resize(1);
			outBuf[0] = byte;
		}
		//Escapeである
		else {
			outBuf.resize(2);
			outBuf[0] = '\\';
			outBuf[1] = '\\';
		}
	}
	//不可視文字
	else {
		outBuf.resize(4);
		getByteHexStr(byte, outBuf);
		outBuf.insert(0, "\\x");
	}
}

unsigned char 
getHexStrByte(const std::string & strBuf, unsigned int offset, unsigned int len) {
	assert(offset+len <= strBuf.size());
	assert(len == 1 || len == 2);
	unsigned char resultChar = 0;
	resultChar = getHexCharValue(strBuf[offset]);
	//二文字の場合
	if (len == 2) {
		resultChar <<= 4;
		resultChar += getHexCharValue(strBuf[offset+1]);
	}
	return resultChar;
}

unsigned char
getAsciiStrByte(const std::string & strBuf, unsigned int offset, unsigned int & usedLen) {
	unsigned char resultByte = 0;
	usedLen = 1;
	//1文字
	if (offset < strBuf.size()) {
		//Escape
		if (strBuf[offset] == '\\') {
			//2文字
			if (offset + 1 < strBuf.size()) {
				offset++;
				//Escape
				if (strBuf[offset] == '\\') {
					usedLen = 2;
					resultByte = '\\';
				}
				//x等
				else {
					offset++;
					if (offset + 2 < strBuf.size()) {
						usedLen = 4;
						resultByte = getHexStrByte(strBuf, offset, 2);
					}
					//文字足りない
					else {
						assert(false);
					}
				}
			}
			//文字足りない
			else {
				assert(false);
			}
		}
		//可視文字
		else {
			resultByte = strBuf[offset];
		}
	}
	return resultByte;
}

void 
AutotestUtil::textToBin(const std::string & str, std::string & binBuf, TextBinType type) 
            throw(InvalidCastException) {
	std::istringstream stm(str);
	unsigned int intResult = 0;
	unsigned char byte;
	int i;
	switch(type) {
	case INTEGER:
		binBuf.resize(4);
		stm >> std::dec >> intResult;
		intResult = intResult;
		//byte 0
		byte = intResult & 0x000000FF;
		binBuf[3] = byte;
		//byte 1
		byte = (intResult & 0x0000FF00) >> 8;
		binBuf[2] = byte;
		//byte 2
		byte = (intResult & 0x00FF0000) >> 16;
		binBuf[1] = byte;
		//byte 3
		byte = (intResult & 0xFF000000) >> 24;
		binBuf[0] = byte;
		break;
	case HEX:
		for (i = str.size() - 2; i >= 0; ) {
			byte = getHexStrByte(str, i, 2);
			binBuf.insert(0U, 1U, static_cast<char>(byte));
			i -= 2;
		}
		//最後の１文字でも有効
		if (i == -1) {
			byte = getHexStrByte(str, 0, 1);
			binBuf.insert(0U, 1U, static_cast<char>(byte));
		}
		break;
	case ASCII:
		for (i = 0; i < static_cast<int>(str.size());) {
			unsigned int usedLen;
			byte = getAsciiStrByte(str, i, usedLen);
			binBuf.append(1, byte);
			i+=usedLen;
		}
		break;
	}
}

void 
AutotestUtil::binToText(const std::string & binBuf, std::string & str, TextBinType type) 
            throw(InvalidCastException) {
	std::ostringstream stm;
	unsigned int intResult = 0;
	string tempStr;
	int i; 
	switch(type) {
	case INTEGER:
		//4バイトまで一バイトずつIntで計算する
		for (i = 0; i < static_cast<int>(binBuf.size()) && i < 4; i++) {
			unsigned char byte = binBuf[i];
			unsigned int intTemp = byte;
			intTemp <<= (3 - i) * 8;
			intResult += intTemp;
		}
		stm << std::dec << intResult;
		str = stm.str();
		break;
	case HEX:
		str = "";
		for (i = 0; i < static_cast<int>(binBuf.size()); i++) {
			unsigned char byte = binBuf[i];
			getByteHexStr(byte, tempStr);
			str += tempStr;
		}
		break;
	case ASCII:
		str = "";
		for (i = 0; i < static_cast<int>(binBuf.size()); i++) {
			unsigned char byte = binBuf[i];
			getByteAsciiStr(byte, tempStr);
			str += tempStr;
		}
		break;
	}
}

//std::string 
//AutotestUtil::binToText(const std::string binBuf, TextBinType type) 
//            throw(InvalidCastException) {
//	std::ostringstream stm;
//	unsigned int intResult = 0;
//	string tempStr;
//	string resultStr;
//	int i; 
//	switch(type) {
//	case INTEGER:
//		//4バイトまで一バイトずつIntで計算する
//		for (i = 0; i < binBuf.size() && i < 4; i++) {
//			unsigned char byte = binBuf[i];
//			unsigned int intTemp = byte;
//			intTemp <<= (3 - i) * 8;
//			cout << std::hex << intTemp << endl;
//			intResult += intTemp;
//		}
////		cout << "binToText:" << std::dec << intResult << endl;
//		stm << std::dec << intResult;
////		resultStr = stm.str();
////		cout << "str:" << str << endl;
//		break;
//	case HEX:
//		for (i = 0; i < binBuf.size(); i++) {
//			unsigned char byte = binBuf[i];
//			getByteHexStr(byte, tempStr);
//			resultStr += tempStr;
//		}
//		break;
//	case ASCII:
//		for (i = 0; i < binBuf.size(); i++) {
//			unsigned char byte = binBuf[i];
//			getByteAsciiStr(byte, tempStr);
//			resultStr += tempStr;
//		}
//		break;
//	}
//	return resultStr;
//}
