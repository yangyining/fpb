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
package com.fineqt.fpb.protocol.sample;

import java.io.IOException;

import com.fineqt.fpb.lib.api.comm.ICommonSocket;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocket;
import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.protocol.ProtocolUtils;

/**
 * 模拟TCP协议连接的三向握手开始和终了。
 * 
 * @author JiangMin
 * 
 */
public class TcpConnectionSample {
    protected static IModule module = IModuleRegistry.INSTANCE
            .resolveModule("EtherProtocol");
    protected static IFactory factory = module.getFactory();
    protected static IValueSerializer ser = IValueSerializer.INSTANCE;

    protected String srcMac;
    protected String dstMac;
    protected String srcIp;
    protected IPcapSocket socket;
    protected int timeout = ICommonSocket.DEFAULT_TIMEOUT;
    protected boolean dumpPacket;
    protected String dstIp;
    protected int srcPort;
    protected int dstPort;

    private long lastRemoteSeqNo;
    private long currentLocalSeqNo;

    /**
     * 生成用于发送的TCP数据包。协议栈为Ethernet/IPv4/TCP。
     * @return TcpProtocol类型的Record对象
     */
    protected IRecordSetValue createTcpPacket() throws MetaException {
        // Ethernet
        IRecordSetValue etherPrtl = (IRecordSetValue) factory
                .createValue("EtherProtocol");
        etherPrtl.getField("dstAddress").setTextAs(dstMac, IValueTextStyle.MAC_ADDRESS);
        etherPrtl.getField("srcAddress").setTextAs(srcMac, IValueTextStyle.MAC_ADDRESS);
        etherPrtl.getField("etherType").setText("0x0800");
        // Ipv4
        IRecordSetValue ipv4Prtl = (IRecordSetValue) etherPrtl.findField("payload/ipv4",
                true);
        IRecordSetValue header = (IRecordSetValue) ipv4Prtl.getField("header");
        header.getField("identification").setText("1");
        header.getField("timeToLive").setText("255");
        header.getField("protocol").setText("6");
        header.getField("sourceAddress").setTextAs(srcIp, IValueTextStyle.IPV4_ADDRESS);
        header.getField("destinationAddress").setTextAs(dstIp,
                IValueTextStyle.IPV4_ADDRESS);
        // Tcp
        IRecordSetValue tcpPrtl = (IRecordSetValue) ipv4Prtl.findField("payload/tcp",
                true);
        ((IIntegerValue) tcpPrtl.findField("header/sourcePort")).setInteger(srcPort);
        ((IIntegerValue) tcpPrtl.findField("header/destinationPort")).setInteger(dstPort);
        return etherPrtl;
    }

    /**
     * 构造函数
     * @param socket PCAP套接字
     * @param srcMac 源设备的MAC地址
     * @param dstMac 目标设备的MAC地址
     * @param srcIp 源设备的IP地址
     */
    public TcpConnectionSample(IPcapSocket socket, String srcMac, String dstMac,
            String srcIp) {
        this.socket = socket;
        this.srcMac = srcMac;
        this.dstMac = dstMac;
        this.srcIp = srcIp;
    }

    /**
     * 使用三向握手的连接建立,非三向的握手将返回失败。
     * @param dstIp
     * @param localPort
     * @param remotePort
     * @return
     * @throws Exception
     */
    public boolean openConnection(String dstIp, int localPort, int remotePort)
            throws Exception {
        srcPort = localPort;
        dstPort = remotePort;
        this.dstIp = dstIp;
        socket.setTimeout(timeout);
        // 打开套接字
        socket.open();
        // 设置Pcap套接字的过滤条件。（过滤条件的书写规则可以参考WinPcap的用户手册）
        socket.setFilter("ip dst " + srcIp + " and ip src " + dstIp
                + " and tcp dst port " + srcPort + " and tcp src port " + dstPort, true);
        // 生成随机的TCP序号
        currentLocalSeqNo = (int) (Math.random() * 0xFFFF);

        // send syn
        IRecordSetValue etherPrtl = createTcpPacket();
        IRecordSetValue tcpPrtl = (IRecordSetValue) etherPrtl
                .findField("payload/ipv4/payload/tcp");
        ((IIntegerValue) tcpPrtl.findField("header/sequenceNumber"))
                .setLong(currentLocalSeqNo);
        ((IBooleanValue) tcpPrtl.findField("header/syn")).setBoolean(true);
        // Maximum Segment Size Option
        tcpPrtl.findField("header/options[0]/maxSs/value", true).setText("1460");
        encodeAndWrite(etherPrtl);

        // receive syn + ack
        etherPrtl = readAndDecode();
        tcpPrtl = (IRecordSetValue) etherPrtl.findField("payload/ipv4/payload/tcp");
        boolean reset = ((IBooleanValue) tcpPrtl.findField("header/reset")).getBoolean();
        lastRemoteSeqNo = ((IIntegerValue) tcpPrtl.findField("header/sequenceNumber"))
                .getLong();
        boolean syn = ((IBooleanValue) tcpPrtl.findField("header/syn")).getBoolean();
        if (reset || !syn) {
            return false;
        }

        // send ack
        etherPrtl = createTcpPacket();
        tcpPrtl = (IRecordSetValue) etherPrtl.findField("payload/ipv4/payload/tcp");
        ((IIntegerValue) tcpPrtl.findField("header/sequenceNumber"))
                .setLong(currentLocalSeqNo);
        ((IIntegerValue) tcpPrtl.findField("header/ackNumber"))
                .setLong(lastRemoteSeqNo + 1);
        ((IBooleanValue) tcpPrtl.findField("header/ack")).setBoolean(true);
        ((IIntegerValue) tcpPrtl.findField("header/windowSize")).setInteger(65535);
        encodeAndWrite(etherPrtl);

        return true;
    }

    private IRecordSetValue readAndDecode() throws Exception {
        IRecordSetValue etherPrtl;
        byte[] resData = new byte[1514];
        int len = socket.read(resData);
        // 解码（底层协议为Ethernet所以使用EtherProtocol作为推测类型）
        etherPrtl = (IRecordSetValue) ProtocolUtils.decode(resData, 0, len, module
                .getType("EtherProtocol"));
        // 打印报文内容
        if (dumpPacket) {
            IValueDumper.INSTANCE.dump(etherPrtl);
        }
        return etherPrtl;
    }

    private void encodeAndWrite(IRecordSetValue etherPrtl) throws EncodeException,
            IOException {
        // 对报文数据包内的可计算字段进行自动计算（这里是IP协议的HeaderLength和TotalLength和
        // TCP协议的dataOffset等字段）
        ser.calculate(etherPrtl);
        // 打印报文内容
        if (dumpPacket) {
            IValueDumper.INSTANCE.dump(etherPrtl);
        }
        // 编码
        byte data[] = ser.encode(etherPrtl, false);
        // 发送编码数据
        socket.write(data);
    }

    /**
     * 使用三向握手的连接终止, 如果是半关闭将直接终止。
     * @return
     * @throws Exception
     */
    public void closeConnection() throws Exception {
        // send RST
        IRecordSetValue etherPrtl = createTcpPacket();
        IRecordSetValue tcpPrtl = (IRecordSetValue) etherPrtl
                .findField("payload/ipv4/payload/tcp");
        ((IIntegerValue) tcpPrtl.findField("header/sequenceNumber"))
                .setLong(++currentLocalSeqNo);
        ((IIntegerValue) tcpPrtl.findField("header/ackNumber"))
                .setLong(lastRemoteSeqNo + 1);
        ((IBooleanValue) tcpPrtl.findField("header/fin")).setBoolean(true);
        encodeAndWrite(etherPrtl);

        // receive RST+ACK
        etherPrtl = readAndDecode();
        tcpPrtl = (IRecordSetValue) etherPrtl.findField("payload/ipv4/payload/tcp");
        boolean fin = ((IBooleanValue) tcpPrtl.findField("header/fin")).getBoolean();
        lastRemoteSeqNo = ((IIntegerValue) tcpPrtl.findField("header/sequenceNumber"))
                .getLong();

        if (fin) {
            // send ACK
            etherPrtl = createTcpPacket();
            tcpPrtl = (IRecordSetValue) etherPrtl.findField("payload/ipv4/payload/tcp");
            ((IIntegerValue) tcpPrtl.findField("header/sequenceNumber"))
                    .setLong(currentLocalSeqNo);
            ((IIntegerValue) tcpPrtl.findField("header/ackNumber"))
                    .setLong(lastRemoteSeqNo + 1);
            ((IBooleanValue) tcpPrtl.findField("header/ack")).setBoolean(true);
            encodeAndWrite(etherPrtl);
        }
        // 关闭套接字
        socket.close();
    }

    public boolean isDumpPacket() {
        return dumpPacket;
    }

    public void setDumpPacket(boolean dumpPacket) {
        this.dumpPacket = dumpPacket;
    }

}
