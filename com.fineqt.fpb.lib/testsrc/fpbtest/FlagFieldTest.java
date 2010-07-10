package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.util.buffer.IReadWritableBitBuffer;
import com.fineqt.fpb.lib.codec.FlagFieldReader;
import com.fineqt.fpb.lib.codec.FlagFieldReaderImpl;
import com.fineqt.fpb.lib.codec.FlagFieldWriter;
import com.fineqt.fpb.lib.codec.FlagFieldWriterImpl;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.FlagFieldType;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;
import com.fineqt.fpb.lib.util.buffer.SimpleBitBuffer;

public class FlagFieldTest extends TestCase {

	public void testNormal() throws Exception {
		IReadWritableBitBuffer buffer;
		//short big_endian
		buffer = new SimpleBitBuffer(16);
		FlagFieldWriter writer = new FlagFieldWriterImpl(buffer, FlagFieldType.OCTET2, ByteOrder.BIGENDIAN);
		assertFalse(writer.isFinished());
		//write int1 1B
		writer.writeInteger(1, 1);
		assertEquals(0x8000, writer.getFlagValue());
		assertEquals(1, writer.getOffset());
		//write int3 011B
		writer.writeInteger(3, 3);
		assertEquals(0xB000, writer.getFlagValue());
		assertEquals(4, writer.getOffset());
		//write bit3 110B
		TextBitset bits = new NativeTextBitset("110", TextBitset.BIN);
		writer.writeBits(bits);
		assertEquals(0xBC00, writer.getFlagValue());
		assertEquals(7, writer.getOffset());
		//write boolean 1B
		writer.writeBoolean(true);
		assertEquals(0xBD00, writer.getFlagValue());
		assertEquals(8, writer.getOffset());
		//write int 8 0xCD signed
		writer.writeInteger(0xCD, 8);
		assertEquals(0xBDCD, writer.getFlagValue());
		assertEquals(16, writer.getOffset());
		assertTrue(writer.isFinished());
		assertEquals((byte)0xBD, buffer.array()[0]);
		assertEquals((byte)0xCD, buffer.array()[1]);
		assertEquals(16, buffer.position());
		
		buffer.flip();
		assertEquals(16, buffer.limit());
		assertEquals(0, buffer.position());
		FlagFieldReader reader = new FlagFieldReaderImpl(buffer, FlagFieldType.OCTET2, ByteOrder.BIGENDIAN);
		assertFalse(reader.isFinished());
		assertEquals(0xBDCD, reader.getFlagValue());
		//read int 1B
		assertEquals(1, reader.readInteger(false, 1));
		assertEquals(3, reader.readInteger(false, 3));
		assertEquals("110", reader.readBits(3).get(TextBitset.BIN));
		assertEquals(true, reader.readBoolean());
		assertEquals((byte)0xCD, reader.readInteger(true, 8));
		assertTrue(reader.isFinished());
	}
}
