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
#ifndef TEXTBITSET_H_
#define TEXTBITSET_H_
#include <string>
#include <boost/dynamic_bitset.hpp>

const unsigned char BitReverseTable256[] = 
{
  0x00, 0x80, 0x40, 0xC0, 0x20, 0xA0, 0x60, 0xE0, 0x10, 0x90, 0x50, 0xD0, 0x30, 0xB0, 0x70, 0xF0, 
  0x08, 0x88, 0x48, 0xC8, 0x28, 0xA8, 0x68, 0xE8, 0x18, 0x98, 0x58, 0xD8, 0x38, 0xB8, 0x78, 0xF8, 
  0x04, 0x84, 0x44, 0xC4, 0x24, 0xA4, 0x64, 0xE4, 0x14, 0x94, 0x54, 0xD4, 0x34, 0xB4, 0x74, 0xF4, 
  0x0C, 0x8C, 0x4C, 0xCC, 0x2C, 0xAC, 0x6C, 0xEC, 0x1C, 0x9C, 0x5C, 0xDC, 0x3C, 0xBC, 0x7C, 0xFC, 
  0x02, 0x82, 0x42, 0xC2, 0x22, 0xA2, 0x62, 0xE2, 0x12, 0x92, 0x52, 0xD2, 0x32, 0xB2, 0x72, 0xF2, 
  0x0A, 0x8A, 0x4A, 0xCA, 0x2A, 0xAA, 0x6A, 0xEA, 0x1A, 0x9A, 0x5A, 0xDA, 0x3A, 0xBA, 0x7A, 0xFA,
  0x06, 0x86, 0x46, 0xC6, 0x26, 0xA6, 0x66, 0xE6, 0x16, 0x96, 0x56, 0xD6, 0x36, 0xB6, 0x76, 0xF6, 
  0x0E, 0x8E, 0x4E, 0xCE, 0x2E, 0xAE, 0x6E, 0xEE, 0x1E, 0x9E, 0x5E, 0xDE, 0x3E, 0xBE, 0x7E, 0xFE,
  0x01, 0x81, 0x41, 0xC1, 0x21, 0xA1, 0x61, 0xE1, 0x11, 0x91, 0x51, 0xD1, 0x31, 0xB1, 0x71, 0xF1,
  0x09, 0x89, 0x49, 0xC9, 0x29, 0xA9, 0x69, 0xE9, 0x19, 0x99, 0x59, 0xD9, 0x39, 0xB9, 0x79, 0xF9, 
  0x05, 0x85, 0x45, 0xC5, 0x25, 0xA5, 0x65, 0xE5, 0x15, 0x95, 0x55, 0xD5, 0x35, 0xB5, 0x75, 0xF5,
  0x0D, 0x8D, 0x4D, 0xCD, 0x2D, 0xAD, 0x6D, 0xED, 0x1D, 0x9D, 0x5D, 0xDD, 0x3D, 0xBD, 0x7D, 0xFD,
  0x03, 0x83, 0x43, 0xC3, 0x23, 0xA3, 0x63, 0xE3, 0x13, 0x93, 0x53, 0xD3, 0x33, 0xB3, 0x73, 0xF3, 
  0x0B, 0x8B, 0x4B, 0xCB, 0x2B, 0xAB, 0x6B, 0xEB, 0x1B, 0x9B, 0x5B, 0xDB, 0x3B, 0xBB, 0x7B, 0xFB,
  0x07, 0x87, 0x47, 0xC7, 0x27, 0xA7, 0x67, 0xE7, 0x17, 0x97, 0x57, 0xD7, 0x37, 0xB7, 0x77, 0xF7, 
  0x0F, 0x8F, 0x4F, 0xCF, 0x2F, 0xAF, 0x6F, 0xEF, 0x1F, 0x9F, 0x5F, 0xDF, 0x3F, 0xBF, 0x7F, 0xFF
};

/**
 * Big Endian順でbitを管理する機能があります
 * 入力データ用語：
 *   最上位バイト：入力データの最上位バイト(左から再先頭) (Most Significant Byte)
 *   最下位バイト:入力データの最下位バイト(左から最後尾) (Least Significant Byte)
 *   最上位ビット(MSB)：入力データの最上位ビット(左から再先頭) (Most Significant Bit)
 *   最下位ビット(LSB):入力データの最下位ビット(左から最後尾) (Least Significant Bit)
 *   例：0x1234 最上位: 12 最下位: 34
 * メモリ上配置用語：
 *   Big Endians:最上位が先に並べる 
 *   Little Endians:最下位が先に並べる
 *   例：0x1234 BE:12(00010010) 34(01011000) LE:34(00011010) 12(01001000)
 */
class TextBitset {
public:
    typedef unsigned int SizeType;
    typedef boost::dynamic_bitset<unsigned char> BoostBitset;
    enum TextValueType {
        INTEGER = 1,
        HEX = 2,
        ASCII = 3,
        BIN = 4
    };
public:
    TextBitset() {}
    TextBitset(const std::string & rawValue);
    TextBitset(const std::string & textValue, TextValueType type);
    /**
     * offsetはビット列の右から計算する。
     * textValueは右からバイトに解析され、詰まり0xFFFは(0F,FFとして解析される)。
     */
    void set(SizeType offset, SizeType len, const std::string & textValue, TextValueType type);
    void set(const std::string & textValue, TextValueType type);
    void set(SizeType offset, bool val);
    void setRaw(SizeType offset, SizeType len, const std::string & rawValue);
    void setRaw(const std::string & rawValue);
    /**
     * offsetはビット列の右から計算する。
     */
    std::string get(SizeType offset, SizeType len, TextValueType type);
    std::string get(TextValueType type);
    std::string getRaw(SizeType offset, SizeType len);
    std::string getRaw();
    bool get(SizeType offset);
    SizeType size();
    void resize(SizeType n, bool value=false);
    BoostBitset & getBitset();
    void setBitset(const BoostBitset & src);
    void append(unsigned char block);
    template <typename BlockInputIterator>
    void append(BlockInputIterator first, BlockInputIterator last) {
        //dynamic_bitsetに次のようなバッグがあるから、直接forでloopする
        //0000000010101000+1は01111111101010001になるバッグがある、原因は調査必要
//        tempset.append(first, last);
        for (; first != last; first++) {
            bitset_.append(BitReverseTable256[(*first & 0xFFU)]);
        }
    }
    void pushBack(bool bit);
    void append(TextBitset & srcset);
    void shiftLeft(SizeType n);
    void shiftRight(SizeType n);
private:
    static std::string getText(const BoostBitset & srcset, TextValueType type);
    /**
     * srcsetには8の整数倍のビットが入ってること
     * バイトの順位は変わらないけど、各バイト内のビット順位は逆転する
     */
	static void appendNetByte(const std::string & inbuf, BoostBitset & dstset, bool revertByte);
    static void getLocalByte(const BoostBitset & srcset, std::string & outbuf, 
    		SizeType offset, SizeType len, bool revertByte);
    static void getLocalByte(const BoostBitset & srcset, std::string & outbuf, bool revertByte);
private:
    BoostBitset bitset_;
};

inline void 
TextBitset::appendNetByte(const std::string & inbuf, BoostBitset & dstset, bool revertByte) {
	int size = inbuf.size();
	if (revertByte) {
		for (int i = size - 1; i >= 0; i--) {
			dstset.append(BitReverseTable256[(inbuf[i] & 0xFFU)]);
		}
	}
	else {
		for (int i = 0; i < size; i++) {
			dstset.append(BitReverseTable256[(inbuf[i] & 0xFFU)]);
		}
	}
}

inline void 
TextBitset::getLocalByte(const BoostBitset & srcset, std::string & outbuf, bool revertByte) {
    //バッファーサイズの確保
    outbuf.resize(srcset.num_blocks(), 0);
    //バッファーへのコピー
    if (revertByte) {
    	boost::to_block_range(srcset, outbuf.rbegin());
    }
    else {
    	boost::to_block_range(srcset, outbuf.begin());
    }
    //ビットの逆転
    for (int i = 0; i < static_cast<int>(outbuf.size()); i++) {
    	outbuf[i] = BitReverseTable256[(outbuf[i] & 0xFFU)]; 
    }
}

inline void 
TextBitset::getLocalByte(const BoostBitset & srcset, std::string & outbuf, 
    		SizeType offset, SizeType len, bool revertByte) {
    //バッファーのコピー
    BoostBitset tempset = srcset;
    //頭部bitの解消
    if (offset > 0) {
        tempset = tempset >> offset;
    }
    //長さの再設定(後部bitの解消)
    tempset.resize(len);
    getLocalByte(tempset, outbuf, revertByte);
}

inline void 
TextBitset::set(SizeType offset, bool val) {
    bitset_.set(offset, val);
}

inline bool 
TextBitset::get(SizeType offset) {
    return bitset_[offset];
}

inline TextBitset::BoostBitset & 
TextBitset::getBitset() {
    return bitset_;
}

inline void 
TextBitset::setBitset(const BoostBitset & src) {
    bitset_ = src;
}

inline void 
TextBitset::append(unsigned char block) {
    bitset_.append(BitReverseTable256[(block & 0xFFU)]);
}

inline void
TextBitset::append(TextBitset & srcset) {
    SizeType oldSize = bitset_.size();
    std::string buff = srcset.getRaw();
    append(buff.begin(), buff.end());
    resize(oldSize+srcset.size());
}

inline void 
TextBitset::pushBack(bool bit) {
    bitset_.push_back(bit);
}

inline TextBitset::SizeType 
TextBitset::size() {
    return bitset_.size();
}

inline void 
TextBitset::resize(SizeType n, bool value) {
    bitset_.resize(n, value);
}

inline void 
TextBitset::shiftLeft(SizeType n) {
	//reverce for network order
    bitset_ >>= n;
}

inline void 
TextBitset::shiftRight(SizeType n) {
	//reverce for network order
    bitset_ <<= n;
}

#endif /*TEXTBITSET_H_*/
