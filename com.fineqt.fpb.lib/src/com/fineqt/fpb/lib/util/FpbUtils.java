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
package com.fineqt.fpb.lib.util;


public class FpbUtils implements FpbConstants {
	//用于取得小于32位的固定长度INT值得掩码数组（数组的索引+1是固定长度的比特数）
	public final static long[] FIX_LENGTH_INT_MASKS;
	
	static {
		FIX_LENGTH_INT_MASKS = new long[INT_BITS];
		for (int i = 1; i <= INT_BITS; i++) {
			FIX_LENGTH_INT_MASKS[i-1] = 0xFFFFFFFFL >> (INT_BITS - i);
		}
	}

	public static String getMacDesc(byte[] macs) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < macs.length; i++) {
			int intByte = macs[i] & 0xFF;
			String hex = Integer.toString(intByte, 16).toUpperCase();
			if (hex.length() == 1) {
				hex = "0"+hex;
			}
			buf.append(hex);
			if (i != macs.length -1) {
				buf.append(':');
			}
		}
		return buf.toString();
	}

	
	static public String[] splitBySpace(String str) {
		return str.split("[ ]+");
	}
	
	static public String slip(String str) {
		str = str.replaceFirst("^[ ]+", "");
		str = str.replaceFirst("[ ]+$", "");
		return str;
	}
	/**
	 * TODO reverseパラメータの意味不明、源は要調査
	 * @param data
	 * @param reverse false:左→右　true:左←右
	 * @return 2バイトのChecksum
	 */
//	static public byte[] internetChecksum(byte[] data, boolean reverse) {
//		long result = 0;
//		byte[] resultArray = new byte[2];
//		boolean low;
//		if (!reverse) {
//			low = false;
//			for (int i = 0; i < data.length; i++) {
//				//highバイト
//				if (low) {
//					result += 0xFF & data[i];
//				}
//				//lowバイト(1から)
//				else {
//					result += (0xFF & data[i]) << 8;
//				}
//				low = !low;
//			}
//		}
//		else {
//			low = true;
//			for (int i = data.length - 1; i >= 0; i--) {
//				//highバイト
//				if (low) {
//					result += 0xFF & data[i];
//				}
//				//lowバイト(1から)
//				else {
//					result += (0xFF & data[i]) << 8;
//				}
//				low = !low;
//			}
//		}
//		//桁上がりの加算（1回目）
//		result = (result & 0xFFFF) + (result >> 16);
//		//桁上がりの加算（2回目）
//		result = (result & 0xFFFF) + (result >> 16);
//		//１補数
//		result = ~result;
//		resultArray[0] = (byte)((result & 0xFF00) >> 8);
//		resultArray[1] = (byte)(result & 0xFF);
//		return resultArray;
//	}
	
	static public byte[] internetChecksum(byte[] data) {
		long result = 0;
		byte[] resultArray = new byte[2];
		int off = 0;
		while(data.length - off >= 2) {
			result += (0xFF & data[off]) << 8;
			result += (0xFF & data[off+1]);
			off += 2;
		}
		//奇数バイトの場合に
		if (data.length - off == 1) {
			result += (0xFF & data[off]) << 8;
		}
		//桁上がりの加算（1回目）
		result = (result & 0xFFFF) + (result >> 16);
		//桁上がりの加算（2回目）
		result = (result & 0xFFFF) + (result >> 16);
		//１補数
		result = ~result;
		resultArray[0] = (byte)((result & 0xFF00) >> 8);
		resultArray[1] = (byte)(result & 0xFF);
		return resultArray;
	}
	
	static public void printBytes(String msg, byte[] bytes, int off, int len) {
		System.out.print(msg);
		for (int i = off; i < off+len; i++) {
			System.out.print(Integer.toHexString((0xFF & bytes[i]))+",");
		}
		System.out.println("n:"+len);
	}
	
	static public String getDumpStr(byte[] bytes, int off, int len) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("len:"+len);
		int end = off+len;
		buffer.append('[');
		int i;
		for (i = off; i < end && i < off+100; i++) {
			buffer.append(bytes[i]);
			if (i != end -1) {
				buffer.append(',');
			}
		}
		if (i != end) {
			buffer.append(",...");
		}
		buffer.append(']');
		return buffer.toString();
	}
	
	private final static int MIN_BYTE_PERLINE = 4;
	private final static String LN = System.getProperty("line.separator");

	public static String getHexDump(byte[] rawData, int offset, int len, int bytePerLine) {
		byte[] data = new byte[len];
		System.arraycopy(rawData, offset, data, 0, len);
		return getHexDump(data, bytePerLine);
	}
	
	public static String getHexDump(byte[] rawData, int bytePerLine) {
		StringBuilder buf = new StringBuilder();
		if (bytePerLine < MIN_BYTE_PERLINE) {
			bytePerLine = MIN_BYTE_PERLINE;
		}
		int off = 0;
		while(off < rawData.length) {
			int len = bytePerLine;
			if (rawData.length - off < len) {
				len = rawData.length - off;
			}
			//offset
			String offStr = Integer.toHexString(off);
			while (offStr.length() < 4) {
				offStr = '0' + offStr;
			}
			buf.append(offStr);
			buf.append(' ');
			//data
			for (int i = off; i < off+len; i++) {
				String hex = Integer.toHexString(0xFF & rawData[i]);
				if (hex.length() < 2) {
					buf.append('0');
				}
				buf.append(hex);
				buf.append(' ');
			}
			//dataが行長さより足りない部分
			if (len < bytePerLine) {
				for (int i = 0; i < bytePerLine - len; i++) {
					buf.append("   ");
				}
			}
			//ascii
			buf.append(' ');
			for (int i = off; i < off+len; i++) {
				//可視文字
				if (rawData[i] >= 32 && rawData[i] <= 126) {
					buf.append((char)(0xFF & rawData[i]));
				//非可視文字
				} else {
					buf.append('.');
				}
			}
			//改行
			buf.append(LN);
			//offsetの移動
			off += len;
		}
		return buf.toString();
	}
		

}
