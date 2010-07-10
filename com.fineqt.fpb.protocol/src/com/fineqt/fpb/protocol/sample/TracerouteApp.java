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

import com.fineqt.fpb.lib.api.comm.CommTimeoutException;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocket;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IValueTextStyle;
import com.fineqt.fpb.protocol.ProtocolUtils;

/**
 * 使用ICMPv4协议实现的Traceroute应用。 使用ICMPv4协议的Echo Request和Echo
 * Reply报文和IPv4的TTL字段来实现Traceroute应用。
 */
public class TracerouteApp extends PingApp {
    public final static int DEFAULT_MAX_HOPS = 40;
    private int maxHops = DEFAULT_MAX_HOPS;

    public TracerouteApp(IPcapSocket socket, String srcMac, String dstMac,
            String srcIp) {
        super(socket, srcMac, dstMac, srcIp);
    }

    public void trace(String dstIp) throws Exception {
        byte[] resData = new byte[1514];
        socket.setTimeout(timeout);
        // 打开套接字
        socket.open();
        try {
            // 设置Pcap套接字的过滤条件。（过滤条件的书写规则可以参考WinPcap的用户手册）
            socket.setFilter("ip dst " + srcIp + " and icmp", true);
            // 生成随机的ICMP Echo请求的标识符
            int icmpId = (int) (Math.random() * 0xFFFF);
            boolean reachedDst = false;
            // 持续尝试直到到达了最大的HOP数
            for (int i = 1; i <= maxHops; i++) {
                // sequence NO. of ICMP
                int seqNo = i;
                // field of TTL in IP, increase 1 each time
                int ttl = i;
                // 生成ICMP Echo请求报文
                IRecordSetValue pingRequest = createPingRequest(dstIp, icmpId,
                        seqNo);
                pingRequest.findField("payload/ipv4/header/timeToLive")
                        .setText(Integer.toString(ttl));
                // 对报文数据包内的可计算字段进行自动计算（这里是IP协议的HeaderLength和TotalLength字段）
                ser.calculate(pingRequest);
                // 打印报文内容
                if (dumpPacket) {
                    IValueDumper.INSTANCE.dump(pingRequest);
                }
                // 编码
                byte data[] = ser.encode(pingRequest, false);
                // 发送编码数据
                socket.write(data);
                // 起始时间
                long startTime = System.currentTimeMillis();
                // 已花费时间（计算超时）
                long totalTime = 0;
                // 循环接收数据包直到超时
                while (totalTime < timeout) {
                    // 接收数据
                    int len;
                    try {
                        len = socket.read(resData);
                    } catch (CommTimeoutException e) {
                        totalTime = timeout;
                        break;
                    }
                    // 解码（底层协议为Ethernet所以使用EtherProtocol作为推测类型）
                    IRecordSetValue pingResponse = (IRecordSetValue) ProtocolUtils
                            .decode(resData, 0, len, module
                                    .getType("EtherProtocol"));
                    // 打印报文
                    if (dumpPacket) {
                        IValueDumper.INSTANCE.dump(pingResponse);
                    }
                    // 取得花费时间
                    totalTime = System.currentTimeMillis() - startTime;
                    // 从Icmpv4Protocol中取出EchoReply字段
                    IRecordSetValue echoReply = (IRecordSetValue) pingResponse
                            .findField("payload/ipv4/payload/icmpv4/echoReply");
                    if (echoReply != null) {
                        // 判断EchoReply的标识符和序号是否与EchoRequest的一致
                        if (((IIntegerValue) echoReply.getField("identifier"))
                                .getInteger() != icmpId
                                || ((IIntegerValue) echoReply
                                        .getField("sequenceNumber"))
                                        .getInteger() != seqNo) {
                            continue;
                        }
                        reachedDst = true;
                    }
                    if (echoReply != null
                            || pingResponse
                                    .findField("payload/ipv4/payload/icmpv4/timeExceeded") != null) {
                        // 取得目标设备的IP地址
                        IRecordSetValue ipv4Header = (IRecordSetValue) pingResponse
                                .findField("payload/ipv4/header");
                        String tempIp = ipv4Header.getField("sourceAddress")
                                .getTextAs(IValueTextStyle.IPV4_ADDRESS);
                        String newTtl = ipv4Header.getField("timeToLive")
                                .getText();
                        // 打印检验结果
                        String msg = "(" + i + ") from " + tempIp + ", "
                                + totalTime + "(ms), " + " ttl=" + newTtl + ".";
                        System.out.println(msg);
                        break;
                    }
                }
                // 判断是否超时
                if (totalTime >= timeout) {
                    System.out.println("timeout");
                }
                // 判断是否到达了目标点
                if (!reachedDst) {
                    continue;
                } else {
                    break;
                }
            }
            // 打印统计信息
            String msg = "Traceroute completed. ";
            if (reachedDst) {
                msg += dstIp + " reached.";
            } else {
                msg += dstIp + " didn't reach.";
            }
            System.out.println(msg);

        } finally {
            // 关闭套接字
            socket.close();
        }

    }

    public int getMaxHops() {
        return maxHops;
    }

    public void setMaxHops(int maxHops) {
        this.maxHops = maxHops;
    }
}
