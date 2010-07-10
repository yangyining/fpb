/*************************************************************************
Protocol Meter, copyright (C) 2007-2008 fineqt.com

Protocol Meter is free software; you can redistribute it and/or modify it 
under the terms of version 2.1 of the GNU Lesser General Public License as 
published by the Free Software Foundation.

Protocol Meter is distributed in the hope that it will be useful, but WITHOUT 
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
License for more details at gnu.org.
**************************************************************************/
package com.fineqt.fpb.protocol.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.util.buffer.IBitBufferFactory;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.value.IContainerValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.protocol.ProtocolUtils;
/**
 * 使用HTTP协议的GET命令来取得网站的资源.通过发送HTTP Reqeust报文，然后接收HTTP Response报文，
 * 从而获得所要得资源。
 * 
 * @author JiangMin
 *
 */
public class HttpGetSample {
    private static String USER_AGENT = 
    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; GTB6; .NET CLR 2.0.50727; .NET CLR 1.1.4322; CIBA)";
    private static IValueSerializer ser = IValueSerializer.INSTANCE;
    private static IModule module = IModuleRegistry.INSTANCE.resolveModule("HttpProtocol");
    private static IFactory factory = module.getFactory();
    private static IType httpPrtlType =  module.getType("HttpProtocol");

    private boolean dumpPacket;
    
    /**
     * 执行HTTP1.1的GET动作，返回HTTP应答报文。
     * @param remoteHost 目标主机名或IP地址
     * @param remotePort 目标主机的端口号
     * @param httpUri 请求资源的URI
     * @param timeout 读取数据的超时时间，毫秒单位。
     * @return 解码后的应答报文对象。
     */
    public IValue doGetAction(String remoteHost, int remotePort, String httpUri, int timeout) 
    throws MetaException, IOException, ExecutionException, InterruptedException {
        //生成Get Request报文
        IValue prtl = factory.createValue("HttpProtocol");
        IValue request = prtl.findField("request", true);
        //uri
        request.findField("requestLine/method").setText("GET");
        request.findField("requestLine/uri").setText(httpUri);
        IValue message = request.findField("message");
        //headers
        setHeader(message, 0, "Accept", "*/*");
        setHeader(message, 1, "Accept-Language", "en_US");
        setHeader(message, 2, "Accept-Encoding", "deflate");
        setHeader(message, 3, "User-Agent", USER_AGENT);
        setHeader(message, 4, "Host", remoteHost);
        setHeader(message, 5, "Connection", "Keep-Alive");
        
        //编码
        byte[] data = ser.encode(prtl, false);
        if (dumpPacket) {
            IValueDumper.INSTANCE.dump(prtl);
        }
        
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(remoteHost, remotePort));
//        socket.setSoTimeout(1000);
        OutputStream outStm = socket.getOutputStream();
        final InputStream inStm = socket.getInputStream();
        final IEnsurableBitBuffer buffer = IBitBufferFactory.INSTANCE.createEnsurableBuffer();
        buffer.setEnsureTimeout(timeout);
        //发送Request
        outStm.write(data);
        //接收数据
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> recvJob = service.submit(new Callable<Integer>() {
            
            @Override
            public Integer call() throws Exception {
                byte[] recvData = new byte[1024];
                try {
                    int len = inStm.read(recvData);
                    while(len >= 0) {
//                        System.out.println("read:"+len);
                        //写数据
                        buffer.putByte(recvData, 0, len);
                        //读数据
                        len = inStm.read(recvData);
                    }
                } catch (IOException e) {
                    //忽略Socket关闭情况
                    if (!"socket closed".equals(e.getMessage())) {
                        throw e;
                    }
                    
                }
                //EOF
                buffer.setEof();
                return 1;
            }
        });
        
       //增量解码 
       IValue response = ProtocolUtils.incrementDecode(buffer, httpPrtlType);
       if (dumpPacket) {
           IValueDumper.INSTANCE.dump(response);
       }
       //关闭Socket
       socket.close();
       //等待接收任务结束
       recvJob.get();
       //停止线程池
       service.shutdown();
       //返回应答报文
       return response;
    }

    private void setHeader(IValue message, int index, String name, String value) throws MetaException {
        IContainerValue header = (IContainerValue)message.findField(
                "headers["+index+"]", true);
        header.getField("name").setText(name);
        header.getField("value").setText(value);
    }

    public boolean isDumpPacket() {
        return dumpPacket;
    }

    public void setDumpPacket(boolean dumpPacket) {
        this.dumpPacket = dumpPacket;
    }
}
