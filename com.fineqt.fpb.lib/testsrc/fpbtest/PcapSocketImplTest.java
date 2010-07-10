package fpbtest;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.comm.CommTimeoutException;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapPacketCapture;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapPacketDumper;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapPacketListener;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocket;
import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocketFactory;
import com.fineqt.fpb.lib.api.comm.pcap.NetworkInterface;
import com.fineqt.fpb.lib.api.comm.pcap.PcapPacket;
import com.fineqt.fpb.lib.comm.pcap.PcapSocket;
import com.fineqt.fpb.lib.comm.pcap.PcapSocketImpl;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;



public class PcapSocketImplTest extends TestCase {
	//32-4バイト
	static final String TAIL_HEX_STR = "65666768696a6b6c6d6e6f7071727374757677616263646566676869";
	//実際ローカルMACと同じであるべき（そうしないとsendのスピードが落ちる）
	static final String LOCAL_MAC = "00:16:cf:2d:ce:e4";
	static final String REMOTE_MAC1 = "00:16:01:15:a4:00";
	static final String REMOTE_MAC2 = "00:16:01:15:a4:11";
	static final String LOCAL_MAC_HEX = LOCAL_MAC.replaceAll(":", "");
	static final String REMOTE_MAC1_HEX = REMOTE_MAC1.replaceAll(":", "");
	static final String REMOTE_MAC2_HEX = REMOTE_MAC2.replaceAll(":", "");
	static final String HEADER_HEX_STR = REMOTE_MAC1_HEX+LOCAL_MAC_HEX+"08004500003c78b5000080012ab5c0a80b05c0a80b010800165c02003500";
	static final String HEADER_HEX_STR2 = REMOTE_MAC2_HEX+LOCAL_MAC_HEX+"08004500003c78b5000080012ab5c0a80b05c0a80b010800165c02003500";
	
	static final int LOOP_CNT = 1000;
	static final int SOCKET_TIMEOUT = 10000;
	
	class WriteJob implements Callable<Integer> {
		IPcapSocket socket;
		String headStr;
		public WriteJob(IPcapSocket socket, String headStr) {
			this.socket = socket;
			this.headStr = headStr;
		}
		
		public Integer call() throws Exception {
			for (int i = 0; i < LOOP_CNT; i++) {
				TextBitset total = createRequest(headStr, i);
				socket.write(total.getRaw(), 0, total.size() / 8);
//				System.out.println("write:"+total.get(TextBitset.HEX));
			}
			return 0;
		}
	}
	
	class ReadJob implements Callable<Integer> {
		IPcapSocket socket;
		byte[] data = new byte[1600];
		public boolean stop;
		
		public ReadJob(IPcapSocket socket) {
			this.socket = socket;
		}
		
		public Integer call() throws Exception {
			for (int i = 0; i < LOOP_CNT && !stop; i++) {
				
				try {
					int len = socket.read(data);
					TextBitset result = new NativeTextBitset(data, 0, len);
					TextBitset noData = new NativeTextBitset(data, 
							HEADER_HEX_STR.length()/2, 4);
					assertEquals(i, noData.getAsInteger());
//					System.out.println("recv:"+result.get(TextBitset.HEX));
				} catch (CommTimeoutException e) {
					//無視
					e.printStackTrace();
					i--;
					continue;
				}
			}
			return 0;
		}
	}
	
	class CaptureJob implements Callable<Integer> {
		IPcapPacketCapture socket;
		
		public CaptureJob(IPcapPacketCapture socket) {
			this.socket = socket;
		}

		public Integer call() throws Exception {
			IPcapPacketListener l = new IPcapPacketListener() {
				int count = 0;
				public void packetArrived(PcapPacket packet) {
					int len = packet.caplen;
					TextBitset result = new NativeTextBitset(packet.data, 0, len);
					TextBitset noData = new NativeTextBitset(packet.data, 
							HEADER_HEX_STR.length()/2, 4);
					assertEquals(count, noData.getAsInteger());
					count++;
//					System.out.println("capt:"+result.get(TextBitset.HEX));
				}
			};
			socket.addPacketListener(l);
			socket.capture(LOOP_CNT);
			return null;
		}
		
	}
	
	public void _testGetDevList() throws Exception{
		NetworkInterface[] ifs = PcapSocketImpl.getDeviceList();
		System.out.println("Interface Count:"+ifs.length);
		for (int i = 0; i < ifs.length; i++) {
			System.out.println(ifs[i]);
		}
	}
	
//	public void testSendPacket() throws Exception {
//		PcapSocketImpl socket = new PcapSocketImpl(ifs[1].name, PcapSocket.DEFAULT_SNAPLEN, 
//				PcapSocket.DEFAULT_PROMISC, 100);
//		socket.open();
//		for (int i = 0; i < 10; i++) {
//			TextBitset sets = new NativeTextBitset(
//					"00160115a4880016cf2dcee408004500003c78b5000080012ab5c0a80b05c0a80b010800165c020035006162636465666768696a6b6c6d6e6f7071727374757677616263646566676869", 
//					TextBitset.HEX);
//			socket.write(sets.getRaw(), 0, sets.size() / 8);
//		}
//		socket.close();
//	}
	
	public void testRecvPacket() throws Exception {
		IPcapSocket socket = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socket.setPcapSetting(FpbTestUtil.getInterface().name, PcapSocket.DEFAULT_SNAPLEN, 
				PcapSocket.DEFAULT_PROMISC, 100);
		IPcapSocket socketRead = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socketRead.setPcapSetting(FpbTestUtil.getInterface().name, PcapSocket.DEFAULT_SNAPLEN, 
				PcapSocket.DEFAULT_PROMISC, 100);
		socket.setTimeout(2000);
		socket.open();
		socketRead.setTimeout(2000);
		socketRead.open();
		socketRead.setFilter("ether dst "+REMOTE_MAC1, true);
		//write
		for (int i = 0; i < 10; i++) {
			TextBitset total = createRequest(HEADER_HEX_STR, i);
			socket.write(total.getRaw(), 0, total.size() / 8);
			PcapPacket packet = socketRead.readPacket();
			byte[] data = packet.data;
			int len = packet.caplen; 
			assertEquals((HEADER_HEX_STR.length()/2+4+TAIL_HEX_STR.length()/2), len);
			TextBitset rstHeader = new NativeTextBitset(data, 0, HEADER_HEX_STR.length()/2);
			assertEquals(HEADER_HEX_STR.toUpperCase(), rstHeader.get(TextBitset.HEX));
			TextBitset rstPayload = new NativeTextBitset(data, HEADER_HEX_STR.length()/2, 4);
			assertEquals(i, rstPayload.getAsInteger());
		}
		socket.close();
		socketRead.close();
	}
	
	public void testTimeout() throws Exception {
		IPcapSocket socket = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socket.setDevice(FpbTestUtil.getInterface().name);
		final int timeout = 200;
		socket.setTimeout(timeout);
		socket.open();
		socket.setFilter("ether dst "+REMOTE_MAC1, true);
		for (int i = 0; i < 10; i++) {
			long startms = System.currentTimeMillis();
			try {
				socket.readPacket();
			} catch(IOException ex) {
				assertTrue(ex instanceof CommTimeoutException);
//				System.out.println(System.currentTimeMillis() - startms);
				assertTrue(Math.abs(System.currentTimeMillis() - startms - timeout) < timeout / 10);
			}
		}
		socket.close();
	}
	
	public void testReadWriteSeperate2Thread() throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		IPcapSocket socket = createPcapSocket();
		IPcapSocket socketRead = createPcapSocket();
		socket.setTimeout(SOCKET_TIMEOUT);
		socketRead.setTimeout(SOCKET_TIMEOUT);
		socket.open();
		socketRead.open();
		socketRead.setFilter("ether dst " + REMOTE_MAC1, true);

		WriteJob writer = new WriteJob(socket, HEADER_HEX_STR);
		ReadJob reader = new ReadJob(socketRead);
		Future<Integer> fReader = service.submit(reader);
		Thread.sleep(100);
		Future<Integer> fWriter = service.submit(writer);
		
		fWriter.get();
//		reader.stop = true;
		fReader.get();
		
		socket.close();
		socketRead.close();
		service.shutdown();
	}

	public void testReadWriteSeperate4Thread() throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		//socket 1
		IPcapSocket socket1 = createPcapSocket();
		IPcapSocket socketRead1 = createPcapSocket();
		socket1.setTimeout(SOCKET_TIMEOUT);
		socket1.open();
		socketRead1.setTimeout(SOCKET_TIMEOUT);
		socketRead1.open();
		socketRead1.setFilter("ether dst " + REMOTE_MAC1, true);

		WriteJob writer1 = new WriteJob(socket1, HEADER_HEX_STR);
		ReadJob reader1 = new ReadJob(socketRead1);
		Future<Integer> fReader1 = service.submit(reader1);
		Thread.sleep(100);
		Future<Integer> fWriter1 = service.submit(writer1);

		//socket 2
		IPcapSocket socket2 = createPcapSocket();
		IPcapSocket socketRead2 = createPcapSocket();
		socket2.setTimeout(SOCKET_TIMEOUT);
		socket2.open();
		socketRead2.setTimeout(SOCKET_TIMEOUT);
		socketRead2.open();
		socketRead2.setFilter("ether dst " + REMOTE_MAC2, true);

		WriteJob writer2 = new WriteJob(socket2, HEADER_HEX_STR2);
		ReadJob reader2 = new ReadJob(socketRead2);
		Future<Integer> fReader2 = service.submit(reader2);
		Thread.sleep(100);
		Future<Integer> fWriter2 = service.submit(writer2);
		
		//write wait
		fWriter1.get();
//		reader1.stop = true;
		fWriter2.get();
//		reader2.stop = true;
		//read wait
		fReader1.get();
		fReader2.get();
		
		socket1.close();
		socketRead1.close();
		socket2.close();
		socketRead2.close();
		service.shutdown();
		
	}
	
	public void testCapture() throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();
		//socket 1
		IPcapSocket socket1 = createPcapSocket();
		IPcapPacketCapture captrue = createCapture();
		socket1.setTimeout(SOCKET_TIMEOUT);
		socket1.open();
		captrue.open();
		captrue.setFilter("ether dst " + REMOTE_MAC1, true);
		
		CaptureJob reader1 = new CaptureJob(captrue);
		Future<Integer> fReader1 = service.submit(reader1);
		Thread.sleep(100);
		WriteJob writer1 = new WriteJob(socket1, HEADER_HEX_STR);
		Future<Integer> fWriter1 = service.submit(writer1);
		
		//write wait
		fWriter1.get();
		fReader1.get();
		
		socket1.close();
		service.shutdown();
	}
	
	public void testDump() throws Exception {
		IPcapPacketDumper dumper = IPcapSocketFactory.INSTANCE.createPacketDumper();
//		dumper.setDevice(FpbTestUtil.getInterface().name);
//		dumper.open();
		dumper.openDump(FpbTestUtil.getInterface().name, "dump.cap");
		for (int i = 0; i < LOOP_CNT; i++) {
			long time = System.currentTimeMillis();
			PcapPacket packet = new PcapPacket();
			TextBitset bitset = createRequest(HEADER_HEX_STR, i);
			packet.data = bitset.getRaw();
			packet.sec =  time / 1000 + i;
			packet.usec = (time % 1000) * 1000;
			packet.len = packet.data.length;
			packet.caplen = packet.data.length;
			dumper.dump(packet);
		}
		dumper.flushDump();
		dumper.close();
	}
	
	public void testOffline() throws Exception {
		IPcapPacketCapture capture = IPcapSocketFactory.INSTANCE.createPacketCapture();
		capture.openOffline("dump.cap");
		for (int i = 0;; i++) {
				PcapPacket packet = capture.readPacket();
				if (packet.caplen == 0) {
					break;
				}
				TextBitset noData = new NativeTextBitset(packet.data, 
						HEADER_HEX_STR.length()/2, 4);
				assertEquals(i, noData.getAsInteger());
//				System.out.println(packet);
		}
		capture.close();
	}
	
	public void testOfflineDump() throws Exception {
		IPcapPacketCapture capture = IPcapSocketFactory.INSTANCE.createPacketCapture();
		IPcapPacketDumper dumper = IPcapSocketFactory.INSTANCE.createPacketDumper();
		capture.openOffline("dump.cap");
		dumper.openDump(FpbTestUtil.getInterface().name, "dump2.cap");
		for (int i = 0;; i++) {
			PcapPacket packet = capture.readPacket();
			if (packet.caplen == 0) {
				break;
			}
			dumper.dump(packet);
		}
		dumper.close();
		capture.close();
	}
	
	private TextBitset createRequest(String headHex, int no) {
		TextBitset header = new NativeTextBitset(headHex, TextBitset.HEX);
		TextBitset payload = new NativeTextBitset();
		payload.resize(32);
		payload.setAsInteger(no);
		TextBitset total = new NativeTextBitset();
		total.append(header);
		total.append(payload);
		total.append(new NativeTextBitset(TAIL_HEX_STR, TextBitset.HEX));
		return total;
	}
	
	private IPcapSocket createPcapSocket() throws Exception {
		IPcapSocket socket = IPcapSocketFactory.INSTANCE.createPcapSocket();
		socket.setPcapSetting(FpbTestUtil.getInterface().name, 1600, false, 50);
		return socket;
	}
	
	private IPcapPacketCapture createCapture() throws Exception {
		IPcapPacketCapture capture = IPcapSocketFactory.INSTANCE.createPacketCapture();
		capture.setPcapSetting(FpbTestUtil.getInterface().name, 1600, false, 50);
		return capture;
	}
}
