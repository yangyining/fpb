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

import com.fineqt.fpb.lib.api.comm.ICommonSocket;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocket;
import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.protocol.ProtocolUtils;

/**
 * Arp协议的实现。 使用ARP协议根据目标设备的IP地址来取得目标设备的MAC地址。
 */
public class ArpApp {
    private static IModule module = IModuleRegistry.INSTANCE
            .resolveModule("EtherProtocol");
    private static IFactory factory = module.getFactory();
    private static IValueSerializer ser = IValueSerializer.INSTANCE;
    private String srcMac;
    private String srcIp;
    private IPcapSocket socket;
    private int timeout = ICommonSocket.DEFAULT_TIMEOUT;
    private boolean dumpPacket;

    /**
     * 构造函数
     * @param socket Pcap套接字。
     * @param srcMac 源设备的MAC地址。
     * @param srcIp 源设备的IP地址。
     */
    public ArpApp(IPcapSocket socket, String srcMac, String srcIp) {
        this.socket = socket;
        this.srcMac = srcMac;
        this.srcIp = srcIp;
    }

    /**
     * 生成ARP请求报文。协议栈为Ehternet/Arp.
     * @param dstIp
     * @return
     */
    private IRecordSetValue createArpRequest(String dstIp) throws MetaException {
        // Ethernet
        IRecordSetValue etherPrtl = (IRecordSetValue) factory
                .createValue("EtherProtocol");
        etherPrtl.getField("dstAddress").setTextAs("ff:ff:ff:ff:ff:ff",
                IValueTextStyle.MAC_ADDRESS);
        etherPrtl.getField("srcAddress").setTextAs(srcMac, IValueTextStyle.MAC_ADDRESS);
        etherPrtl.getField("etherType").setText("0x0806");
        // Arp
        IRecordSetValue arpPrtl = (IRecordSetValue) etherPrtl.findField("payload/arp",
                true);
        arpPrtl.getField("operation").setText("1");
        arpPrtl.getField("senderHwAddress")
                .setTextAs(srcMac, IValueTextStyle.MAC_ADDRESS);
        arpPrtl.getField("senderProtocolAddress").setTextAs(srcIp,
                IValueTextStyle.IPV4_ADDRESS);
        arpPrtl.getField("targetHwAddress").setTextAs("00:00:00:00:00:00",
                IValueTextStyle.MAC_ADDRESS);
        arpPrtl.getField("targetProtocolAddress").setTextAs(dstIp,
                IValueTextStyle.IPV4_ADDRESS);
        return etherPrtl;
    }

    /**
     * 根据目标设备的IP地址来取得目标设备的MAC地址。
     * @param dstIp 目标设备的IP地址。
     * @return 目标设备的MAC地址文本描述。
     * @throws Exception
     */
    public String askMac(String dstIp) throws Exception {
        byte[] resData = new byte[1514];
        socket.setTimeout(timeout);
        // 打开套接字
        socket.open();
        try {
            // 设置Pcap套接字的过滤条件。（过滤条件的书写规则可以参考WinPcap的用户手册）
            socket.setFilter("ether dst " + srcMac + " and arp", true);
            // 生成ARP请求报文
            IRecordSetValue arpRequest = createArpRequest(dstIp);
            // 对报文数据包内的可计算字段进行自动计算（这里是Arp协议的Hlen和Plen字段）
            ser.calculate(arpRequest);
            if (dumpPacket) {
                IValueDumper.INSTANCE.dump(arpRequest);
            }
            // 编码
            byte data[] = ser.encode(arpRequest, false);
            // 发送编码数据
            socket.write(data);
            // 接收应答数据
            int len = socket.read(resData);
            // 解码（底层协议为Ethernet所以使用EtherProtocol作为推测类型）
            IRecordSetValue arpResponse = (IRecordSetValue) ProtocolUtils.decode(resData,
                    0, len, module.getType("EtherProtocol"));
            // 打印解码后的ARP应答报文对象
            if (dumpPacket) {
                IValueDumper.INSTANCE.dump(arpResponse);
            }
            // 从EthernetProtocol的Payload字段取得ARP协议字段
            IRecordSetValue arpPrtl = (IRecordSetValue) arpResponse
                    .findField("payload/arp");
            // 取得ARP协议的SenderHwAddress从而得到目标设备的MAC地址
            return arpPrtl.getField("senderHwAddress").getTextAs(
                    IValueTextStyle.MAC_ADDRESS);
        } finally {
            // 关闭套接字
            socket.close();
        }
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getSrcMac() {
        return srcMac;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public boolean isDumpPacket() {
        return dumpPacket;
    }

    public void setDumpPacket(boolean dumpPacket) {
        this.dumpPacket = dumpPacket;
    }

}