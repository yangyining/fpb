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
package com.fineqt.fpb.lib.comm.pcap;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import com.fineqt.fpb.lib.api.comm.CommTimeoutException;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapPacketListener;
import com.fineqt.fpb.lib.api.comm.pcap.NetworkInterface;
import com.fineqt.fpb.lib.api.comm.pcap.PcapPacket;


/**
 * @author sho-b
 */
public class PcapSocketImpl implements PcapSocket {
	final static private String NATIVE_TIMEOUT_ERROR_MSG = "Timeout.";
	final static private String EOF_ERROR_MSG = "EOF.";
	final static private String SESSION_NOT_OPENNED_MSG = "Session is not openned.";
	final static private String SESSION_IS_OPENNING_MSG = "Session is openning.";
	final static private int OPEN_LIVE = 1;
	final static private int OPEN_OFFLINE = 2;
	final static private int OPEN_DUMP = 3;
	
	private long handle;
	private long dumpHandle;
	
	private static native void nativeInitIDs();
	
	public static native NetworkInterface[] getDeviceList() throws SocketException;
	
	private native String nativeOpenLive(String device, int snaplen,  int promisc, int timeoutMs);
	
	private native void nativeClose();
	/**
	 * 
	 * @param packet 受信パケット。受信したパケットデータが格納される。
	 * @param ms　タイムアウト（ミリ秒）。
	 * @param status　状態（OPEN_LIVE, OPEN_OFFLINE)
	 * @return
	 */
	private native String nativeRecvPacket(PcapPacket packet, int ms, int status);
	
	private native String nativeSendPacket(byte[] b, int off, int len);
	
	private native String nativeSetFilter(String condition, boolean optimize);
	
//	private native String nativeGetErrMsg();

	private native String nativeOpenOffline(String fileName);
	
	private native String nativeCapture(int count);
	
	private native void nativeEndCapture();
	
	private native String nativeOpenDump(String fileName);
	
	private native String nativeDump(PcapPacket packet);
	
	private native String nativeFlushDump();
	
	private native void nativeCloseDump();
	
	static {
		nativeInitIDs();
	}
	
	private String device;
	private int snaplen;
	private int promisc;
	private int pcapTimeout;
	private int timeout= DEFAULT_TIMEOUT;
	private Object readLock = new Object();
	private List<IPcapPacketListener> listeners = new ArrayList<IPcapPacketListener>();
	private int status = 0;
	
	public PcapSocketImpl(){
		this(null, DEFAULT_SNAPLEN, DEFAULT_PROMISC, DEFAULT_PCAP_TIMEOUT);
	}
	
	public PcapSocketImpl(String device) {
		setPcapSetting(device, DEFAULT_SNAPLEN, DEFAULT_PROMISC, DEFAULT_PCAP_TIMEOUT);
	}
	public PcapSocketImpl(String device, int snaplen, boolean promisc, int pcapTimeout) {
		setPcapSetting(device, snaplen, promisc, pcapTimeout);
	}

	public void setPcapSetting(String device, int snaplen, boolean promisc, int pcapTimeout) {
		this.device = device;
		this.snaplen = snaplen;
		this.promisc = promisc?1:0;
		this.pcapTimeout = pcapTimeout;
	}

	public void close() throws IOException {
		//OPEN_DUMPに対するclose
		if ((status & OPEN_DUMP) != 0) {
			nativeCloseDump();
		}
		//OPEN_LIVE或いはOPEN_OFFLINEに対するclose
		nativeClose();
		//クリア
		status = 0;
		handle = 0;
		dumpHandle = 0;
	}
	
	public void open() throws IOException {
		if (handle != 0) {
			throw new IOException(SESSION_IS_OPENNING_MSG);
		}
		if (device == null) {
			throw new IllegalArgumentException("device is null.");
		}
		String errstr;
		synchronized(PcapSocketImpl.class) {
			errstr = nativeOpenLive(device, snaplen, promisc, pcapTimeout);
		}
		if (errstr != null) {
			throw new IOException(errstr);
		}
		status |= OPEN_LIVE;
	}

	public void setFilter(String condition, boolean optimize) 
	throws SocketException {
		if (handle == 0) {
			throw new SocketException(SESSION_NOT_OPENNED_MSG);
		}
		//WinPcapはpcap_compile或はpcap_setfilterメソッドが非同期実行をサッポートしてないみたい、
		//外部から同期させないと、VMがcrashしてしまう.特にOS起動後の一回目の時
		synchronized(PcapSocketImpl.class) {
			String errstr;
			errstr = nativeSetFilter(condition, optimize);
			if (errstr != null) {
				throw new SocketException(errstr);
			}
		}
	}

	public int getTimeout() throws SocketException {
		return timeout;
	}
	/**
	 * EOFなら、戻り値のcaplenとlenが0である。
	 */
	public PcapPacket readPacket() throws IOException {
		if (handle == 0) {
			throw new SocketException(SESSION_NOT_OPENNED_MSG);
		}
		PcapPacket packet = new PcapPacket();
		String errstr;
		//WinPcapのpcap_next_exメソッドには外部メモリを使ってるので、同期が必要かもしれない。
		synchronized(readLock) {
			errstr = nativeRecvPacket(packet, timeout, status);
		}
		if (errstr != null) {
			if (NATIVE_TIMEOUT_ERROR_MSG.equals(errstr)) {
				throw new CommTimeoutException(errstr);
			} else if (EOF_ERROR_MSG.equals(errstr)) {
				//何もしない、lenが0で戻す
			} else {
				throw new IOException(errstr);
			}
		}
		return packet;
	}
	/**
	 * offlineのEOFの場合に0を戻す。
	 */
	public int read(byte[] b, int off, int len) throws IOException {
		PcapPacket packet = readPacket();
		if (packet.caplen > 0) {
			//長さは短いほうが優先
			if (packet.caplen < len) {
				len = packet.caplen;
			}
			//コピー
			System.arraycopy(packet.data, 0, b, off, len);
		}
		//EOFの場合
		else {
			return 0;
		}
		return len;
	}

	public int read(byte[] b) throws IOException {
		return read(b, 0, b.length);
	}

	public void setTimeout(int milliSec) throws SocketException {
		timeout = milliSec;
	}

	public void write(byte[] b, int off, int len) throws IOException {
		if (handle == 0) {
			throw new SocketException(SESSION_NOT_OPENNED_MSG);
		}
		String errstr;
		errstr = nativeSendPacket(b, off, len);
		if (errstr != null) {
			throw new IOException(errstr);
		}
	}

	public void write(byte[] b) throws IOException {
		write(b, 0, b.length);
	}

	synchronized public void dump(PcapPacket packet) throws IOException {
		if (dumpHandle == 0) {
			throw new SocketException(SESSION_NOT_OPENNED_MSG);
		}
		//thread safeじゃないみたいので、外部で同期
		String errstr = nativeDump(packet);
		if (errstr != null) {
			throw new IOException(errstr);
		}
	}

	synchronized public void flushDump() throws IOException {
		if (dumpHandle == 0) {
			throw new SocketException(SESSION_NOT_OPENNED_MSG);
		}
		//thread safeじゃないみたいので、外部で同期
		String errstr = nativeFlushDump();
		if (errstr != null) {
			throw new IOException(errstr);
		}
	}

	public void openDump(String device, String fileName) throws IOException {
		//设置设备
		setDevice(device);
		//打开Pcap连接
		open();
		if (dumpHandle != 0) {
			throw new IOException(SESSION_IS_OPENNING_MSG);
		}
		//dumpでopen
		String errstr = nativeOpenDump(fileName);
		if (errstr != null) {
			throw new IOException(errstr);
		}
		status |= OPEN_DUMP;
	}

	public void capture(int count) throws IOException {
		if (handle == 0) {
			throw new SocketException(SESSION_NOT_OPENNED_MSG);
		}
		String errstr = nativeCapture(count);
		if (errstr != null) {
			throw new IOException(errstr);
		}
	}

	public void endCapture() {
		if (handle == 0) {
			return;
		}
		nativeEndCapture();
	}

	public void openOffline(String fileName) throws IOException {
		if (handle != 0) {
			throw new IOException(SESSION_IS_OPENNING_MSG);
		}
		String errstr = nativeOpenOffline(fileName);
		if (errstr != null) {
			throw new IOException(errstr);
		}
		status |= OPEN_OFFLINE;
	}

	public void addPacketListener(IPcapPacketListener l) {
		listeners.add(l);
	}

	public void removePacketListener(IPcapPacketListener l) {
		listeners.remove(l);
	}
	
	public void handlePacket(int length, int caplen, int seconds, int useconds, byte[] data) {
		if (listeners.size() > 0) {
			PcapPacket packet = new PcapPacket();
			packet.sec = seconds;
			packet.usec = useconds;
			packet.caplen = caplen;
			packet.len = length;
			packet.data = data;
			for (int i = 0; i < listeners.size(); i++) {
				IPcapPacketListener l = listeners.get(i);
				l.packetArrived(packet);
			}
		}
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public int getSnaplen() {
		return snaplen;
	}

	public void setSnaplen(int snaplen) {
		this.snaplen = snaplen;
	}

	public int getPcapTimeout() {
		return pcapTimeout;
	}

	public void setPcapTimeout(int pcapTimeout) {
		this.pcapTimeout = pcapTimeout;
	}

	public boolean getPromisc() {
		return promisc==1;
	}

	public void setPromisc(boolean promisc) {
		this.promisc = promisc?1:0;
	}

}
