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

import java.net.SocketException;

import com.fineqt.fpb.lib.api.comm.pcap.IPcapPacketCapture;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapPacketDumper;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocket;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocketFactory;
import com.fineqt.fpb.lib.api.comm.pcap.NetworkInterface;

public class PcapSocketFactoryImpl implements IPcapSocketFactory {
	
	public NetworkInterface[] getDeviceList() throws SocketException {
		return PcapSocketImpl.getDeviceList();
	}

	private PcapSocket createSocket() {
		return new PcapSocketImpl();
	}

	@Override
	public IPcapPacketCapture createPacketCapture() {
		return createSocket();
	}

	@Override
	public IPcapPacketDumper createPacketDumper() {
		return createSocket();
	}

	@Override
	public IPcapSocket createPcapSocket() {
		return createSocket();
	}

}
