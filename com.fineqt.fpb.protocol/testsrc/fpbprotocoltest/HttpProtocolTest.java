package fpbprotocoltest;

import java.nio.ByteBuffer;
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
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.exception.MetaException;
import com.fineqt.fpb.protocol.ProtocolUtils;

import fpbtest.FpbTestUtil;

import junit.framework.TestCase;

public class HttpProtocolTest extends TestCase {
    private static IValueSerializer ser = IValueSerializer.INSTANCE;
    IModule module = IModuleRegistry.INSTANCE.resolveModule("HttpProtocol");
    IFactory factory = module.getFactory();
    IType httpPrtlType =  module.getType("HttpProtocol");

    public void testEncodeDecodeNormal() throws Exception {
        byte[] data;
        //normal
        IValue prtl = createNormalHttpResponse();
        //自动计算
        ser.calculate(prtl);
        assertEquals("10", prtl.findField("response/message/headers[2]/value").getText());
//        IValueDumper.INSTANCE.dump(prtl);
        //encode
        data = ser.encode(prtl, false);
//        System.out.println(new String(data));
  
        //decode
        IValue resultPrtl = ProtocolUtils.decode(data, httpPrtlType);
//        IValueDumper.INSTANCE.dump(resultPrtl);
        assertEquals(prtl, resultPrtl);        
    }

    //chunks(with trailer)
    public void testEncodeDecodeChunks() throws Exception {
        byte[] data;
        IValue prtl = createChunkHttpResponse();
        
        ser.calculate(prtl);
//        IValueDumper.INSTANCE.dump(prtl);
        assertEquals("5", prtl.findField(
                "response/message/httpBody/chunks[0]/lengthLine/chunkLength").getText());
        assertEquals("6", prtl.findField(
                "response/message/httpBody/chunks[1]/lengthLine/chunkLength").getText());
        assertEquals("0", prtl.findField(
        "response/message/httpBody/chunks[2]/lengthLine/chunkLength").getText());

        //encode
        data = ser.encode(prtl, false);
//        System.out.println(new String(data));
  
        //decode
        IValue resultPrtl = ProtocolUtils.decode(data, httpPrtlType);
//        IValueDumper.INSTANCE.dump(resultPrtl);
        assertEquals(prtl, resultPrtl);        
        
    }
    
    public void testEncodeDecodeMulti() throws Exception {
        int[] resultValueLen = new int[1];
        IEnsurableBitBuffer eBuffer = IBitBufferFactory.INSTANCE.createEnsurableBuffer();
        byte[] data1;
        //normal
        IValue prtlNormal = createNormalHttpResponse();
        //自动计算
        ser.calculate(prtlNormal);
        assertEquals("10", prtlNormal.findField("response/message/headers[2]/value").getText());
//        IValueDumper.INSTANCE.dump(prtl);
        //encode
        data1 = ser.encode(prtlNormal, false);
        //chunk
        byte[] data2;
        IValue prtlChunk = createChunkHttpResponse();
        ser.calculate(prtlChunk);
        //encode
        data2 = ser.encode(prtlChunk, false);

        eBuffer.putByte(data1);
        eBuffer.putByte(data2);
        
        //decode
        IValue resultValue = ProtocolUtils.incrementDecode(eBuffer, httpPrtlType, resultValueLen);
        assertEquals(prtlNormal, resultValue);
        assertEquals(data1.length * 8, resultValueLen[0]);
        eBuffer.compactSpace(resultValueLen[0]);
        //decode
        resultValue = ProtocolUtils.incrementDecode(eBuffer, httpPrtlType, resultValueLen);
        assertEquals(data2.length * 8, resultValueLen[0]);
        assertEquals(prtlChunk, resultValue);
    }

    public void testEncodeDecodeMultiThread() throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        int loopCnt = 5;
        //准备数据
        byte[] data1;
        //normal
        IValue prtlNormal = createNormalHttpResponse();
        //自动计算
        ser.calculate(prtlNormal);
//        IValueDumper.INSTANCE.dump(prtlNormal);
        //encode
        data1 = ser.encode(prtlNormal, false);
        //chunk
        byte[] data2;
        IValue prtlChunk = createChunkHttpResponse();
        ser.calculate(prtlChunk);
        //encode
        data2 = ser.encode(prtlChunk, false);
        //合并
        ByteBuffer buffer = ByteBuffer.allocate((data1.length + data2.length) * loopCnt);
        for (int i = 0; i < loopCnt; i++) {
            buffer.put(data1);
            buffer.put(data2);
        }
        Future<?> job1;
        IEnsurableBitBuffer eBuffer = IBitBufferFactory.INSTANCE.createEnsurableBuffer();
        //提交发送任务
        job1 = service.submit(new FpbTestUtil.IncrementPutDataJob(buffer.array(), eBuffer));
        //解码
        int[] resultValueLen = new int[1];
        for (int i = 0; i < loopCnt; i++) {
//            System.out.println("----count["+i+"]-------");
            //decode1
            IValue value1 = ProtocolUtils.incrementDecode(
                    eBuffer, httpPrtlType, resultValueLen);
//            IValueDumper.INSTANCE.dump(value1);
            assertEquals(prtlNormal, value1);
            eBuffer.compactSpace(resultValueLen[0]);
            //decode2
            IValue value2 = ProtocolUtils.incrementDecode(
                    eBuffer, httpPrtlType, resultValueLen);
//            IValueDumper.INSTANCE.dump(value2);
            assertEquals(prtlChunk, value2);
            eBuffer.compactSpace(resultValueLen[0]);
        }
        
        job1.get();
        
        service.shutdown();
    }
    
    private IValue createChunkHttpResponse() throws MetaException {
        IValue prtl = factory.createValue("HttpProtocol");
        IValue response = prtl.findField("response", true);
        response.findField("responseLine/status", true).setText("200");
        response.findField("responseLine/reason", true).setText("OK");
        IValue message = response.findField("message");
        IValue header = message.findField("headers[0]", true);
        header.findField("name").setText("Date");
        header.findField("value").setText("Mon, 22 Mar 2004 11:15:03 GMT");
        header = message.findField("headers[1]", true);
        header.findField("name").setText("Content-Type");
        header.findField("value").setText("text/html");
        header = message.findField("headers[2]", true);
        header.findField("name").setText("Transfer-Encoding");
        header.findField("value").setText("chunked");
        header = message.findField("headers[3]", true);
        header.findField("name").setText("Trailer");
        header.findField("value").setText("Expires1, Expires2");
        
        IValue chunkList = message.findField("httpBody/chunks", true);
        IValue chunk = chunkList.findField("[0]", true);
        chunk.findField("lengthLine/chunkLength", true).setText("");
        chunk.findField("chunkData/data", true).setText("3132333435");
        chunk = chunkList.findField("[1]", true);
        chunk.findField("lengthLine/chunkLength", true).setText("");
        chunk.findField("chunkData/data", true).setText("363738393031");            
        chunk = chunkList.findField("[2]", true);
        chunk.findField("lengthLine/chunkLength", true).setText("");
        
        IValue trailer = message.findField("trailers[0]", true);
        trailer.findField("name").setText("Expires1");
        trailer.findField("value").setText("Sat, 27 Mar 2004 21:12:00 GMT");
        trailer = message.findField("trailers[1]", true);
        trailer.findField("name").setText("Expires2");
        trailer.findField("value").setText("Sat, 28 Mar 2004 21:12:00 GMT");
        return prtl;
    }
    
    private IValue createNormalHttpResponse() throws MetaException {
        IValue prtl = factory.createValue("HttpProtocol");
        IValue response = prtl.findField("response", true);
        response.findField("responseLine/status", true).setText("200");
        response.findField("responseLine/reason", true).setText("OK");
        IValue message = response.findField("message");
        IValue header = message.findField("headers[0]", true);
        header.findField("name").setText("Date");
        header.findField("value").setText("Mon, 22 Mar 2004 11:15:03 GMT");
        header = message.findField("headers[1]", true);
        header.findField("name").setText("Content-Type");
        header.findField("value").setText("text/html");
        header = message.findField("headers[2]", true);
        header.findField("name").setText("Content-Length");
        header.findField("value").setText("0");
        header = message.findField("headers[3]", true);        
        header.findField("name").setText("Expires");
        header.findField("value").setText("Sat, 27 Mar 2004 21:12:00 GMT");
        message.findField("httpBody/data", true).setText("31323334353637383930");
        return prtl;
    }


}
