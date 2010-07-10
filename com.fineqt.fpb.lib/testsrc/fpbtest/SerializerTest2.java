package fpbtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.api.util.IValueSerializer;
import com.fineqt.fpb.lib.api.util.buffer.IBitBufferFactory;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IWritableBitBuffer;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.meta.exception.MetaException;

public class SerializerTest2 extends TestCase {
    static IValueSerializer ser = IValueSerializer.INSTANCE;
    
    public void testTextMessageInFixedBuffer() throws Exception {
        IModule module = IModuleRegistry.INSTANCE.resolveModule("builtintest2");
        assertNotNull(module);
//        System.out.println(module);
        byte[] data;
        IValue message = createMessageType2();
        ser.calculate(message);
//        IValueDumper.INSTANCE.dump(message);
        //encode
        data = ser.encode(message, false);
        //固定长度缓存
        IValue resultMessage;
        resultMessage = ser.decode(data, module.getType("MessageType2"));
//        IValueDumper.INSTANCE.dump(resultMessage);
        assertEquals(message, resultMessage);
        
    }
    
    public void testTextMessageInEnsurableBuffer() throws Exception {
        IModule module = IModuleRegistry.INSTANCE.resolveModule("builtintest2");
        byte[] data;
        IValue message = createMessageType2();
        ser.calculate(message);
//        IValueDumper.INSTANCE.dump(message);
        //encode
        data = ser.encode(message, false);
        //固定长度缓存
        IValue resultMessage;
        Future<?> job1;
        ExecutorService service = Executors.newCachedThreadPool();
        IEnsurableBitBuffer eBuffer = IBitBufferFactory.INSTANCE.createEnsurableBuffer();
        //提交发送任务(第一次)
        job1 = service.submit(new FpbTestUtil.IncrementPutDataJob(data, eBuffer));
        resultMessage = FpbTestUtil.incrementDecode(eBuffer, 
                module.getType("MessageType2"));
//        IValueDumper.INSTANCE.dump(resultMessage);
        assertEquals(message, resultMessage);
        job1.get();

        //提交发送任务(第二次)
        eBuffer.clear();
        job1 = service.submit(new FpbTestUtil.IncrementPutDataJob(data, eBuffer));
        resultMessage = FpbTestUtil.incrementDecode(eBuffer, 
                module.getType("MessageType2"));
//        IValueDumper.INSTANCE.dump(resultMessage);
        assertEquals(message, resultMessage);
        job1.get();
        
        service.shutdown();
    }

    private IValue createMessageType2() throws MetaException,
            EncodeException {
        IFactory factory = IModuleRegistry.INSTANCE.resolveFactory("builtintest2");
        IValue message;
        IValue header;
        message = factory.createValue("MessageType2");
        //header 0
        header = message.findField("msg1/headers[0]", true);
        header.findField("name").setText("header0");
        header.findField("space").setText(" ");
        header.findField("value").setText("value0");
        //header 1
        header = message.findField("msg1/headers[1]", true);
        header.findField("name").setText("header1");
        header.findField("space").setText(" ");
        header.findField("value").setText("value1");
        //header21
        header = message.findField("header21");
        header.findField("name").setText("header21");
        header.findField("space").setText(" ");
        header.findField("value").setText("value21");
        //header22
        header = message.findField("header22");
        header.findField("name").setText("header22");
        header.findField("space").setText(" ");
        header.findField("value").setText("value22");
        return message;
    }
    
    
}
