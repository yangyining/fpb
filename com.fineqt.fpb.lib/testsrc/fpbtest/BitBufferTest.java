package fpbtest;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.util.buffer.BitBufferException;
import com.fineqt.fpb.lib.api.util.buffer.BufferOverflowException;
import com.fineqt.fpb.lib.api.util.buffer.BufferUnderflowException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IEnsurableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IWritableBitBuffer;
import com.fineqt.fpb.lib.util.buffer.SimpleBitBuffer;
import com.fineqt.fpb.lib.util.buffer.SimpleEnsurableBitBuffer;

public class BitBufferTest extends TestCase {
	public void testSimplePutAndGet() throws Exception {
		final int CAPACITY = 16*8;
		IReadWritableBitBuffer buf = new SimpleBitBuffer(CAPACITY);
		byte[] byteBuf = buf.array();
		byte[] tmpbuf = new byte[16];
		assertEquals(0, buf.arrayOffset());
		assertEquals(0, buf.position());
		assertEquals(16*8, buf.limit());
		assertEquals(16*8, buf.capacity());
		//Bit
		//put 4bit 0x30
		tmpbuf[0] = 0x30;
		buf.putBit(tmpbuf, 4);
		assertEquals(4, buf.position());
		assertEquals(0x30, byteBuf[0]);
		//put 12bit 0x4560
		tmpbuf[0] = 0x45;
		tmpbuf[1] = 0x60;
		buf.putBit(tmpbuf, 12);
		assertEquals(16, buf.position());
		assertEquals(0x34, byteBuf[0]);
		assertEquals(0x56, byteBuf[1]);
		//put 8bit 0x78
		tmpbuf[0] = 0x78;
		buf.putBit(tmpbuf, 8);
		assertEquals(24, buf.position());
		assertEquals(0x34, byteBuf[0]);
		assertEquals(0x56, byteBuf[1]);
		assertEquals(0x78, byteBuf[2]);
		//Byte
		//put 1byte 0x98
		tmpbuf[0] = (byte)0x98;
		buf.putByte(tmpbuf[0]);
		assertEquals(32, buf.position());
		assertEquals(0x34, byteBuf[0]);
		assertEquals(0x56, byteBuf[1]);
		assertEquals(0x78, byteBuf[2]);
		assertEquals((byte)0x98, byteBuf[3]);
		//put 2byte 0x7654
		tmpbuf[0] = (byte)0x76;
		tmpbuf[1] = (byte)0x54;
		buf.putByte(tmpbuf, 0, 2);
		assertEquals(48, buf.position());
		assertEquals(0x34, byteBuf[0]);
		assertEquals(0x56, byteBuf[1]);
		assertEquals(0x78, byteBuf[2]);
		assertEquals((byte)0x98, byteBuf[3]);
		assertEquals((byte)0x76, byteBuf[4]);
		assertEquals((byte)0x54, byteBuf[5]);
		//Bit by Byte
		//put 1bit 0x80
		tmpbuf[0] = (byte)0x80;
		buf.putBit(tmpbuf, 1);
		assertEquals(49, buf.position());
		assertEquals((byte)0x80, byteBuf[6]);
		//put 1byte 0xFF
		tmpbuf[0] = (byte)0xFF;
		buf.putByte(tmpbuf[0]);
		assertEquals(57, buf.position());
		assertEquals((byte)0xFF, byteBuf[6]);
		assertEquals((byte)0x80, byteBuf[7]);
		//put 2bit 0x40
		tmpbuf[0] = (byte)0x40;
		buf.putBit(tmpbuf, 2);
		assertEquals(59, buf.position());
		assertEquals((byte)0xA0, byteBuf[7]);
		//put 2byte 0xFFFF
		tmpbuf[0] = (byte)0xFF;
		tmpbuf[1] = (byte)0xFF;
		buf.putByte(tmpbuf, 0, 2);
		assertEquals(75, buf.position());
		assertEquals((byte)0xBF, byteBuf[7]);
		assertEquals((byte)0xFF, byteBuf[8]);
		assertEquals((byte)0xE0, byteBuf[9]);
		//put 1bit 0
		buf.putBit(false);
		assertEquals(76, buf.position());
		assertEquals((byte)0xE0, byteBuf[9]);
		//put 1bit 1
		buf.putBit(true);
		assertEquals(77, buf.position());
		assertEquals((byte)0xE8, byteBuf[9]);
		
		//get
		tmpbuf = new byte[16];		
		buf.flip();
		assertEquals(0, buf.position());
		assertEquals(77, buf.limit());
		assertEquals(CAPACITY, buf.capacity());
		//Bit
		//get 4bit 0x30
		buf.getBit(tmpbuf, 4);
		assertEquals(4, buf.position());
		assertEquals(0x30, tmpbuf[0]);
		//get 12bit 0x4560
		buf.getBit(tmpbuf, 12);
		assertEquals(16, buf.position());
		assertEquals(0x45, tmpbuf[0]);
		assertEquals(0x60, tmpbuf[1]);
		//get 8bit 0x78
		buf.getBit(tmpbuf, 8);
		assertEquals(24, buf.position());
		assertEquals(0x78, tmpbuf[0]);
		//Byte
		//get 1byte 0x98
		tmpbuf[0] = buf.getByte();
		assertEquals(32, buf.position());
		assertEquals((byte)0x98, tmpbuf[0]);
		//get 2byte 0x7654
		buf.getByte(tmpbuf, 0, 2);
		assertEquals(48, buf.position());
		assertEquals(0x76, tmpbuf[0]);
		assertEquals(0x54, tmpbuf[1]);
		
		//Bit by Byte
		//get 1bit 0x80
		buf.getBit(tmpbuf, 1);
		assertEquals(49, buf.position());
		assertEquals((byte)0x80, tmpbuf[0]);
		//get 1byte 0xFF
		buf.getByte(tmpbuf, 0, 1);
		assertEquals(57, buf.position());
		assertEquals((byte)0xFF, tmpbuf[0]);
		//get 2bit 0x40
		buf.getBit(tmpbuf, 2);
		assertEquals(59, buf.position());
		assertEquals((byte)0x40, tmpbuf[0]);
		//get 2byte 0xFFFF
		buf.getByte(tmpbuf, 0, 2);
		assertEquals(75, buf.position());
		assertEquals((byte)0xFF, tmpbuf[0]);
		assertEquals((byte)0xFF, tmpbuf[1]);
		
		//get bit false
		assertFalse(buf.getBit());
		//get bit true
		assertTrue(buf.getBit());
	}
	
	public void testSimpleOther() throws Exception {
		final int CAPACITY = 4*8;
		IReadWritableBitBuffer buf = new SimpleBitBuffer(CAPACITY, true);
		//mark & reset
		assertEquals(0, buf.position());
		buf.position(16);
		assertEquals(16, buf.position());
		buf.mark();
		buf.position(30);
		assertEquals(30, buf.position());
		buf.reset();
		buf.position(16);
		//rewind
		buf.clear();
		assertEquals(0, buf.position());
		assertEquals(CAPACITY, buf.limit());
		assertEquals(CAPACITY, buf.capacity());
		buf.limit(20);
		buf.position(10);
		buf.rewind();
		assertEquals(0, buf.position());
		assertEquals(20, buf.limit());
		//unlimitedPut
		byte[] bytes = new byte[]{1, 2, 3, 4};
		buf.putByte(bytes);
		assertEquals(32, buf.position());
		assertEquals(32, buf.limit());
		buf.putByte((byte)1);
		assertEquals(40, buf.position());
		assertEquals(64, buf.limit());
		assertEquals(32*2, buf.capacity());
		for (int i = 0; i < 5; i++) {
			buf.array()[i] = (byte)(i + 1);
		}
	}
	
	public void testSubBuffer() throws Exception{
		final int CAPACITY = 4*8;
		IReadWritableBitBuffer buf = new SimpleBitBuffer(CAPACITY, true);
		byte[] bytes = new byte[]{1, 2, 3, 4};
		buf.putByte(bytes);
		//sub1 2,3
		IReadableBitBuffer subBuf1 = buf.subBitBuffer(8, 16);
		assertEquals(8, subBuf1.arrayOffset());
		assertEquals(0, subBuf1.position());
		assertEquals(16, subBuf1.limit());
		assertEquals(16, subBuf1.capacity());
		assertEquals(2, subBuf1.getByte());
		assertEquals(3, subBuf1.getByte());
		
		//sub1-1 2
		IReadableBitBuffer subBuf1_1 = subBuf1.subBitBuffer(0, 8);		
		assertEquals(8, subBuf1_1.arrayOffset());
		assertEquals(0, subBuf1_1.position());
		assertEquals(8, subBuf1_1.limit());
		assertEquals(8, subBuf1_1.capacity());
		assertEquals(2, subBuf1_1.getByte());
		
		//sub1-2 3
		IReadableBitBuffer subBuf1_2 = subBuf1.subBitBuffer(8, 8);		
		assertEquals(16, subBuf1_2.arrayOffset());
		assertEquals(0, subBuf1_2.position());
		assertEquals(8, subBuf1_2.limit());
		assertEquals(8, subBuf1_2.capacity());
		assertEquals(3, subBuf1_2.getByte());
		
		//sub2 2,3,4
		IReadableBitBuffer subBuf2 = buf.subBitBuffer(8, IBitBuffer.GET_LEN_BY_SUPER_POSITION);
		assertEquals(8, subBuf2.arrayOffset());
		assertEquals(0, subBuf2.position());
		assertEquals(24, subBuf2.limit());
		assertEquals(24, subBuf2.capacity());
		assertEquals(2, subBuf2.getByte());
		assertEquals(3, subBuf2.getByte());
		assertEquals(4, subBuf2.getByte());
		
		//sub2-1 3, 4
		IReadableBitBuffer subBuf2_1 = subBuf2.subBitBuffer(8, IBitBuffer.GET_LEN_BY_SUPER_CAPACITY);		
		assertEquals(16, subBuf2_1.arrayOffset());
		assertEquals(0, subBuf2_1.position());
		assertEquals(16, subBuf2_1.limit());
		assertEquals(16, subBuf2_1.capacity());
		assertEquals(3, subBuf2_1.getByte());
		assertEquals(4, subBuf2_1.getByte());
		
		//加入超过容量的2个字节
		bytes = new byte[]{5, 6};
		buf.putByte(bytes);
		
		//buf
		assertEquals(48, buf.position());
		assertEquals(64, buf.limit());
		assertEquals(64, buf.capacity());
		
		//sub2 2,3,4,| 5,6
		assertEquals(8, subBuf2.arrayOffset());
		assertEquals(24, subBuf2.position());
		assertEquals(40, subBuf2.limit());
		assertEquals(40, subBuf2.capacity());
		assertEquals(5, subBuf2.getByte());
		assertEquals(6, subBuf2.getByte());
		
		//sub2-1 3,4, | 5,6
		assertEquals(16, subBuf2_1.arrayOffset());
		assertEquals(16, subBuf2_1.position());
		assertEquals(32, subBuf2_1.limit());
		assertEquals(32, subBuf2_1.capacity());
		assertEquals(5, subBuf2_1.getByte());
		assertEquals(6, subBuf2_1.getByte());
		
		
		//underflow exception
		try {
			subBuf2.getByte();
			fail();
		} catch(BufferUnderflowException ex) {
		}
		
		//overflow exception
		buf = new SimpleBitBuffer(CAPACITY, false);
		bytes = new byte[]{1, 2, 3, 4};
		buf.putByte(bytes);		
		try {
			buf.putByte((byte)5);
			fail();
		} catch(BufferOverflowException ex) {
		}
		
	}
	
	public void testCharSequence() throws Exception {
		String str = "0123456789";
		IReadableBitBuffer buffer = new SimpleBitBuffer(str.getBytes());
		assertEquals(0, buffer.position());
		assertEquals(10*8, buffer.limit());
		assertEquals(10*8, buffer.capacity());
		//sequence1-8
		buffer.position(1*8);
		buffer.limit(9*8);
		CharSequence seq1 = buffer.getAsCharSequence();
		assertEquals(8, seq1.length());
		for (int i = 0; i < 8; i++) {
			assertEquals(str.charAt(i+1), seq1.charAt(i));
		}
		//subsequence 1-4
		CharSequence subseq1 = seq1.subSequence(1, 4);
		for (int i = 0; i < 3; i++) {
			assertEquals(str.charAt(i+2), subseq1.charAt(i));
		}
	}
	
	public void testEnsurableBitBufferSingleThread() throws Exception {
	    IWritableBitBuffer writeBuf = new SimpleEnsurableBitBuffer();
        byte[] byteBuf = writeBuf.array();
        byte[] tmpbuf = new byte[16];
	    //put
        //Bit
        //put 4bit 0x30
        tmpbuf[0] = 0x30;
        writeBuf.putBit(tmpbuf, 4);
        assertEquals(4, writeBuf.position());
        assertEquals(0x30, byteBuf[0]);
        //put 12bit 0x4560
        tmpbuf[0] = 0x45;
        tmpbuf[1] = 0x60;
        writeBuf.putBit(tmpbuf, 12);
        assertEquals(16, writeBuf.position());
        assertEquals(0x34, byteBuf[0]);
        assertEquals(0x56, byteBuf[1]);
        //put 8bit 0x78
        tmpbuf[0] = 0x78;
        writeBuf.putBit(tmpbuf, 8);
        assertEquals(24, writeBuf.position());
        assertEquals(0x34, byteBuf[0]);
        assertEquals(0x56, byteBuf[1]);
        assertEquals(0x78, byteBuf[2]);
        //Byte
        //put 1byte 0x98
        tmpbuf[0] = (byte)0x98;
        writeBuf.putByte(tmpbuf[0]);
        assertEquals(32, writeBuf.position());
        assertEquals(0x34, byteBuf[0]);
        assertEquals(0x56, byteBuf[1]);
        assertEquals(0x78, byteBuf[2]);
        assertEquals((byte)0x98, byteBuf[3]);
        //put 2byte 0x7654
        tmpbuf[0] = (byte)0x76;
        tmpbuf[1] = (byte)0x54;
        writeBuf.putByte(tmpbuf, 0, 2);
        assertEquals(48, writeBuf.position());
        assertEquals(0x34, byteBuf[0]);
        assertEquals(0x56, byteBuf[1]);
        assertEquals(0x78, byteBuf[2]);
        assertEquals((byte)0x98, byteBuf[3]);
        assertEquals((byte)0x76, byteBuf[4]);
        assertEquals((byte)0x54, byteBuf[5]);
        //Bit by Byte
        //put 1bit 0x80
        tmpbuf[0] = (byte)0x80;
        writeBuf.putBit(tmpbuf, 1);
        assertEquals(49, writeBuf.position());
        assertEquals((byte)0x80, byteBuf[6]);
        //put 1byte 0xFF
        tmpbuf[0] = (byte)0xFF;
        writeBuf.putByte(tmpbuf[0]);
        assertEquals(57, writeBuf.position());
        assertEquals((byte)0xFF, byteBuf[6]);
        assertEquals((byte)0x80, byteBuf[7]);
        //put 2bit 0x40
        tmpbuf[0] = (byte)0x40;
        writeBuf.putBit(tmpbuf, 2);
        assertEquals(59, writeBuf.position());
        assertEquals((byte)0xA0, byteBuf[7]);
        //put 2byte 0xFFFF
        tmpbuf[0] = (byte)0xFF;
        tmpbuf[1] = (byte)0xFF;
        writeBuf.putByte(tmpbuf, 0, 2);
        assertEquals(75, writeBuf.position());
        assertEquals((byte)0xBF, byteBuf[7]);
        assertEquals((byte)0xFF, byteBuf[8]);
        assertEquals((byte)0xE0, byteBuf[9]);
        //put 1bit 0
        writeBuf.putBit(false);
        assertEquals(76, writeBuf.position());
        assertEquals((byte)0xE0, byteBuf[9]);
        //put 1bit 1
        writeBuf.putBit(true);
        assertEquals(77, writeBuf.position());
        assertEquals((byte)0xE8, byteBuf[9]);
	    
	   
        //get通过SubBuffer
	    IReadableBitBuffer buf = writeBuf.subBitBuffer(0, IBitBuffer.GET_LEN_BY_SUPER_POSITION);
        tmpbuf = new byte[16];      
        assertEquals(writeBuf.position(), buf.capacity());
        //Bit
        //get 4bit 0x30
        buf.getBit(tmpbuf, 4);
        assertEquals(4, buf.position());
        assertEquals(0x30, tmpbuf[0]);
        //get 12bit 0x4560
        buf.getBit(tmpbuf, 12);
        assertEquals(16, buf.position());
        assertEquals(0x45, tmpbuf[0]);
        assertEquals(0x60, tmpbuf[1]);
        //get 8bit 0x78
        buf.getBit(tmpbuf, 8);
        assertEquals(24, buf.position());
        assertEquals(0x78, tmpbuf[0]);
        //Byte
        //get 1byte 0x98
        tmpbuf[0] = buf.getByte();
        assertEquals(32, buf.position());
        assertEquals((byte)0x98, tmpbuf[0]);
        //get 2byte 0x7654
        buf.getByte(tmpbuf, 0, 2);
        assertEquals(48, buf.position());
        assertEquals(0x76, tmpbuf[0]);
        assertEquals(0x54, tmpbuf[1]);
        
        //Bit by Byte
        //get 1bit 0x80
        buf.getBit(tmpbuf, 1);
        assertEquals(49, buf.position());
        assertEquals((byte)0x80, tmpbuf[0]);
        //get 1byte 0xFF
        buf.getByte(tmpbuf, 0, 1);
        assertEquals(57, buf.position());
        assertEquals((byte)0xFF, tmpbuf[0]);
        //get 2bit 0x40
        buf.getBit(tmpbuf, 2);
        assertEquals(59, buf.position());
        assertEquals((byte)0x40, tmpbuf[0]);
        //get 2byte 0xFFFF
        buf.getByte(tmpbuf, 0, 2);
        assertEquals(75, buf.position());
        assertEquals((byte)0xFF, tmpbuf[0]);
        assertEquals((byte)0xFF, tmpbuf[1]);
        
        //get bit false
        assertFalse(buf.getBit());
        //get bit true
        assertTrue(buf.getBit());       
        
        
	    //CharSequence
        writeBuf.clear();
        String str = "0123456789";
        writeBuf.putByte(str.getBytes());
        IReadableBitBuffer buffer = writeBuf.subBitBuffer(0, IBitBuffer.GET_LEN_BY_SUPER_POSITION);
        assertEquals(0, buffer.position());
        assertEquals(10*8, buffer.limit());
        assertEquals(10*8, buffer.capacity());
        //sequence1-8
        buffer.position(1*8);
        buffer.limit(9*8);
        CharSequence seq1 = buffer.getAsCharSequence();
        assertEquals(8, seq1.length());
        for (int i = 0; i < 8; i++) {
            assertEquals(str.charAt(i+1), seq1.charAt(i));
        }
        //subsequence 1-4
        CharSequence subseq1 = seq1.subSequence(1, 4);
        for (int i = 0; i < 3; i++) {
            assertEquals(str.charAt(i+2), subseq1.charAt(i));
        }
	}
    
	public void testCompactSpace() throws Exception {
	    IEnsurableBitBuffer writeBuf = new SimpleEnsurableBitBuffer();
	    //FFFF80
	    writeBuf.putByte((byte)0xFF);
        writeBuf.putByte((byte)0xFF);
        writeBuf.putBit(true);
        assertEquals(17, writeBuf.position());
        byte[] arrayBytes = writeBuf.array();
        assertEquals((byte)0xFF, arrayBytes[0]);
        assertEquals((byte)0xFF, arrayBytes[1]);
        assertEquals((byte)0x80, arrayBytes[2]);
        //compact [0, 8]
        writeBuf.compactSpace(8);
        assertEquals(9, writeBuf.position());
        assertEquals((byte)0xFF, arrayBytes[0]);
        assertEquals((byte)0x80, arrayBytes[1]);
	}
	
	public void testEnsurableBitBufferMultiThread() throws Exception {
	    ExecutorService service = Executors.newCachedThreadPool();
        final IEnsurableBitBuffer writeBuf = new SimpleEnsurableBitBuffer();
        writeBuf.setEnsureTimeout(1000);
        
        //测试ensureSpace(两次)
        writeBuf.clear();
        checkEnsureSpace(service, writeBuf);

        writeBuf.clear();
        checkEnsureSpace(service, writeBuf);
	    
	    //测试ensureBytes(两次)
        writeBuf.clear();
        checkEnsureBytes(service, writeBuf);

        writeBuf.clear();
        checkEnsureBytes(service, writeBuf);
	    
	    service.shutdown();
    }
    
	private void checkEnsureBytes(ExecutorService service,
            final IEnsurableBitBuffer writeBuf) throws InterruptedException,
            ExecutionException {
	    int lineCnt = 10;
        final String deliStr = "xy";
        String srcStr = "";
        for (int i = 0; i < lineCnt; i++) {
            srcStr += "line" + i + deliStr;
        }
        final byte[] orgBytes= srcStr.getBytes();
        final int charCnt = orgBytes.length;  
        final ByteBuffer gotBytes = ByteBuffer.allocate(orgBytes.length);
        Future<?> job1 = service.submit(
                new FpbTestUtil.IncrementPutDataJob(orgBytes, writeBuf));
        
        Future<?> job2 = service.submit(new Runnable(){
            @Override
            public void run() {
                IReadableBitBuffer readBuffer = writeBuf.subBitBuffer(0, 
                        IBitBuffer.GET_LEN_BY_SUPER_POSITION);
                int allCnt = 0;
                byte[] matchs = deliStr.getBytes(); 
                while(allCnt < charCnt) {
                    try {
                        int ensureOffset = 
                            (readBuffer.position() + readBuffer.arrayOffset()) / 8;
                        int getCnt = writeBuf.ensureBytes(ensureOffset, matchs);
                        assertTrue(getCnt > 0);
                        assertTrue(readBuffer.remaining() >= getCnt * 8);
                        byte[] readBuf = new byte[getCnt];
                        //读取
                        readBuffer.getByte(readBuf);
//                        System.out.println("got:"+new String(readBuf));
                        //加入缓存
                        gotBytes.put(readBuf);
                        //加索引
                        allCnt += getCnt;
                    } catch (BitBufferException e) {
                        e.printStackTrace();
                        fail();
                    }
                }
            }
        });
        
        
        job1.get();
        job2.get();
        assertTrue(Arrays.equals(orgBytes, gotBytes.array()));
//        System.out.println(new String(gotBytes.array()));
        
    }

    private void checkEnsureSpace(ExecutorService service,
            final IEnsurableBitBuffer writeBuf) throws InterruptedException,
            ExecutionException {
        String srcStr = "";
        final int charCnt = 300;  
        for (int i = 0; i < charCnt; i++) {
            srcStr += i % 10;
        }
        final byte[] orgBytes= srcStr.getBytes();
        final ByteBuffer gotBytes = ByteBuffer.allocate(orgBytes.length);
        
        Future<?> job1 = service.submit(
                new FpbTestUtil.IncrementPutDataJob(orgBytes, writeBuf));
	    
        Future<?> job2 = service.submit(new Runnable(){
            @Override
            public void run() {
                IReadableBitBuffer readBuffer = writeBuf.subBitBuffer(0, 
                        IBitBuffer.GET_LEN_BY_SUPER_POSITION);
                int allCnt = 0;
                while(allCnt < charCnt) {
                    //每次取随机个
                    int getCnt = (int)(Math.random() * 10);
                    if (allCnt + getCnt > charCnt ) {
                        getCnt = charCnt - allCnt;
                    }
                    try {
                        int ensureOffset = allCnt * 8;
                        int ensureBits = getCnt * 8;
                        assertTrue(writeBuf.ensureSpace(ensureOffset, ensureBits));
                        assertTrue(readBuffer.remaining() >= ensureBits);
                        byte[] readBuf = new byte[getCnt];
                        //读取
                        readBuffer.getByte(readBuf);
                        //加入缓存
                        gotBytes.put(readBuf);
                        //加索引
                        allCnt += getCnt;
                    } catch (BitBufferException e) {
                        e.printStackTrace();
                        fail();
                    }
                }
            }
        });
        
        
	    job1.get();
	    job2.get();
	    assertTrue(Arrays.equals(orgBytes, gotBytes.array()));
//	    System.out.println(new String(gotBytes.array()));
    }	
}
