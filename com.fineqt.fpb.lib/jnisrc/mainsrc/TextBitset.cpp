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
#include "TextBitset.h"
#include "AutotestUtil.h"
#include <cassert>
#include <iostream>
#include <algorithm>

using namespace std;
using namespace boost;

TextBitset::TextBitset(const std::string & rawValue) {
    setRaw(rawValue);
}

TextBitset::TextBitset(const std::string & textValue, TextValueType type) {
    set(textValue, type);
}

void 
TextBitset::set(const std::string & textValue, TextValueType type) {
    string binBuf;    
    switch(type) {
        case BIN:
        	{
	        	string binTextValue;
	        	binTextValue.resize(textValue.size());
	        	reverse_copy(textValue.begin(), textValue.end(), binTextValue.begin()); 
	            bitset_ = BoostBitset(binTextValue);
        	}
            return;
        case INTEGER:
            AutotestUtil::textToBin(textValue, binBuf, AutotestUtil::INTEGER);
            break;
        case HEX:
            AutotestUtil::textToBin(textValue, binBuf, AutotestUtil::HEX);
            break;
        case ASCII:
            AutotestUtil::textToBin(textValue, binBuf, AutotestUtil::ASCII);
            break;
    }
    //ネットワーク順のようにビットを設定する
    bitset_.clear();
    switch(type) {
        case INTEGER:
        	appendNetByte(binBuf, bitset_, false);
        	break;
        case HEX:
        case ASCII:
        	appendNetByte(binBuf, bitset_, false);
        	break;
        default:
        	assert(false);
        	break;
    }
}

void 
TextBitset::set(SizeType offset, SizeType len, const std::string & textValue, TextValueType type) {
    assert(offset+len <= bitset_.size());
    TextBitset tempSet(textValue, type);
    if (type == INTEGER) {
    	//不足の場合にIntegerの下位のみコピー
    	SizeType subOff = (tempSet.size() > len)?tempSet.size() - len:0;
//    	cout << "tempSet:" << tempSet.get(BIN) << endl;
//    	cout << "subOff:" << subOff << endl;
	    for (SizeType i = 0; i < tempSet.size() && i < len; i++) {
			bitset_[i+offset] = tempSet.get(i+subOff);
	    }
    }
    else {
	    for (SizeType i = 0; i < tempSet.size() && i < len; i++) {
			bitset_[i+offset] = tempSet.get(i);
	    }
    }
}

void 
TextBitset::setRaw(const std::string & rawValue) {
    //ネットワーク順のようにビットを設定する
    bitset_.clear();
	appendNetByte(rawValue, bitset_, false);
}

void 
TextBitset::setRaw(SizeType offset, SizeType len, const std::string & rawValue) {
    assert(offset+len <= bitset_.size());
	TextBitset tempSet(rawValue);
    for (SizeType i = 0; i < tempSet.size() && i < len; i++) {
        bitset_[i+offset] = tempSet.get(i);
    }
}


std::string 
TextBitset::get(TextValueType type) {
    return getText(bitset_, type);
}

std::string 
TextBitset::get(SizeType offset, SizeType len, TextValueType type) {
    assert(offset+len <= bitset_.size());
    //バッファーのコピー
    BoostBitset tempset = bitset_;
    //頭部bitの解消
    if (offset > 0) {
        tempset = tempset >> offset;
    }
    //長さの再設定(後部bitの解消)
    tempset.resize(len);
    return getText(tempset, type);
}

std::string 
TextBitset::getRaw(SizeType offset, SizeType len) {
    assert(offset+len <= bitset_.size());
    //バイト列の取得
    string bitbuf;
    getLocalByte(bitset_, bitbuf, offset, len, false);
    return bitbuf;
}

std::string 
TextBitset::getRaw() {
    //バイト列の取得
    string bitbuf;
    getLocalByte(bitset_, bitbuf, false);
    return bitbuf;
}

std::string 
TextBitset::getText(const BoostBitset & srcset, TextValueType type) {
    string bitbuf;
    string txtResult;
    //バイナリ文字の場合直ちに戻す 
    if (type == BIN) {
        to_string(srcset, txtResult);
        reverse(txtResult.begin(), txtResult.end());
    }
    //その他文字の場合
    else {
		//ローカルバイトビット順セットの取得
       	int mod = srcset.size() % 8;
		//Integer且つ下位にビット補充が必要の場合
	    if (type == INTEGER && mod != 0) {
    		BoostBitset intset = srcset;
    		intset.resize(srcset.size() + 8 - mod);
    		//補充によって数字が拡大されたから、縮小させる
    		intset = intset << (8 - mod);
    		getLocalByte(intset, bitbuf, false);
	    }
	    //その他場合
	    else {
	        //Byte列の取得
	        switch(type) {
	            case INTEGER:
    				getLocalByte(srcset, bitbuf, false);
	            	break;
	            case HEX:
	            case ASCII:
    				getLocalByte(srcset, bitbuf, false);
	            	break;
	            default:
	                assert(false);
	        }
	    }
//	    string tmpstr;
//	    to_string(srcset, tmpstr);
//	    cout << "srcset:" << tmpstr << endl;
//	    cout << "bitbuf size:" << bitbuf.size() << endl;
        //テキストの取得
        switch(type) {
            case INTEGER:
                //ちょうど,4バイト
                if (bitbuf.size() == 4) {
                    AutotestUtil::binToText(bitbuf, txtResult, AutotestUtil::INTEGER);
                }
                else {
                    string tempBuf;
                    if (bitbuf.size() > 4) {
                        tempBuf = bitbuf.substr(0, 4);
                    }
                    else {
                        tempBuf.resize(4, 0);
                        //下位バイトにコピー
                        unsigned int bOff = tempBuf.size() - bitbuf.size();
                        for (unsigned int i = 0; i < bitbuf.size(); i++) {
                            tempBuf[i+bOff] = bitbuf[i];
                        }
                    }
                    AutotestUtil::binToText(tempBuf, txtResult, AutotestUtil::INTEGER);
                }
                break;
            case HEX:
                AutotestUtil::binToText(bitbuf, txtResult, AutotestUtil::HEX);
                break;
            case ASCII:
                AutotestUtil::binToText(bitbuf, txtResult, AutotestUtil::ASCII);
                break;
            default:
                assert(false);
        }
    }
    return txtResult;
}
