package fpbtest;

import java.net.SocketException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.comm.pcap.IPcapSocketFactory;
import com.fineqt.fpb.lib.api.comm.pcap.NetworkInterface;
import com.fineqt.fpb.lib.comm.pcap.PcapSocket;
import com.fineqt.fpb.lib.comm.pcap.PcapSocketImpl;
import com.fineqt.fpb.lib.util.NativeTextBitset;
import com.fineqt.fpb.lib.util.TextBitset;

public class PcapSocketImplTest2 extends TestCase {
	static final int REQUEST_LOOP_CNT = 5;
	static final int SOCKET_TIMEOUT = 10000;
	static final int TEST_LOOP_CNT = 1000;
	
	long currentId = 0;
	TextBitset pingRequest;
	TextBitset pingResponse;
//	PacketEncoder encoder = new PacketEncoderImpl();
	String LOCAL_MAC = "00:16:CF:2D:CE:E4";
	String REMOTE_MAC = "00:16:CF:2D:CE:E5";
	String LOCAL_MAC_HEX = "0016CF2DCEE4";
	String REMOTE_MAC_HEX = "0016CF2DCEE5";
	String LOCAL_IP = "172.168.0.1";
	String REMOTE_IP = "172.168.0.2";
	boolean TEST_WITH_PPPOE = true;
	String device;
	{
		try {
			NetworkInterface[] ifs = PcapSocketImpl.getDeviceList();
			device = ifs[1].name;
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void setUp() throws Exception {
		createPPPoEPacket();
	}

	private void createPPPoEPacket() throws Exception {
//		byte data[] = new byte[]{0x31, 0x32, 0x33, 0x34};
//        //PingRequest
//		Packet packet = new PacketImpl(new String[]{"Ethernet", "PPPoE_Session", "IPv4", "ICMP"});
//        packet.setIntValue("Ethernet", "ether_type", 0x8864);
//        packet.setIntValue("PPPoE_Session", "protocol", 0x0021);
//        packet.setIntValue("IPv4", "protocol", 0x01);
//        packet.setTextValue("Ethernet", "destination_address", REMOTE_MAC);
//        packet.setTextValue("Ethernet", "source_address", LOCAL_MAC);
//        packet.setIntValue("PPPoE_Session", "sessionid", 1);
//        packet.setIntValue("IPv4", "identification", 1);
//        packet.setTextValue("IPv4", "source_address", LOCAL_IP);
//        packet.setTextValue("IPv4", "destination_address", REMOTE_IP);
//        packet.setIntValue("ICMP", "identifier", 1);
//        packet.setIntValue("ICMP", "sequence_number", 1);
//        packet.setByteArrayValue("ICMP", "data", data);
//        pingRequest = encoder.encodePacket(packet);
//        //PingResponse
//        packet = new PacketImpl(new String[]{"Ethernet", "PPPoE_Session", "IPv4", "ICMP"});
//        packet.setIntValue("Ethernet", "ether_type", 0x8864);
//        packet.setIntValue("PPPoE_Session", "protocol", 0x0021);
//        packet.select("ICMP", "icmp_root", "echo_reply");
//        packet.setIntValue("IPv4", "protocol", 0x01);
//        packet.setTextValue("Ethernet", "destination_address", LOCAL_MAC);
//        packet.setTextValue("Ethernet", "source_address", REMOTE_MAC);
//        packet.setIntValue("PPPoE_Session", "sessionid", 1);
//        packet.setIntValue("IPv4", "identification", 1);
//        packet.setTextValue("IPv4", "source_address", REMOTE_IP);
//        packet.setTextValue("IPv4", "destination_address", LOCAL_IP);
//        packet.setIntValue("ICMP", "identifier", 1);
//        packet.setIntValue("ICMP", "sequence_number", 1);
//        packet.setByteArrayValue("ICMP", "data", data);
//        pingResponse = encoder.encodePacket(packet);
	}
	
	private TextBitset createClientRequest() throws Exception {
		TextBitset dst = new NativeTextBitset(REMOTE_MAC_HEX, TextBitset.HEX);
		TextBitset source = new NativeTextBitset(LOCAL_MAC_HEX, TextBitset.HEX);
		TextBitset protocol = new NativeTextBitset("0000", TextBitset.HEX);
		TextBitset data = new NativeTextBitset(Long.toString(++currentId), TextBitset.INTEGER);
		dst.append(source);
		dst.append(protocol);
		dst.append(data);
		for (int i = 0; i < 60; i++) {
			dst.append(data);
		}
		return dst;
	}
	
	private TextBitset createResponse(byte[] request, int len) {
		assertTrue(len >= 18);
		TextBitset dst = new NativeTextBitset(LOCAL_MAC_HEX, TextBitset.HEX);
		TextBitset source = new NativeTextBitset(REMOTE_MAC_HEX, TextBitset.HEX);
		TextBitset protocol = new NativeTextBitset("0000", TextBitset.HEX);
		TextBitset data = new NativeTextBitset(request, 14, 4);
		dst.append(source);
		dst.append(protocol);
		dst.append(data);
		for (int i = 0; i < 60; i++) {
			dst.append(data);
		}
		return dst;
	}
	
	private Semaphore serverStartSem = new Semaphore(0);
	
	class ClientJob implements Callable<Integer> {
		PcapSocket socket;
		
		byte[] data = new byte[1600];
		public ClientJob() {
			socket = createSocket();
		}
		
		public Integer call() throws Exception {
			socket.setTimeout(SOCKET_TIMEOUT);
			socket.open();
			socket.setFilter("ether dst "+LOCAL_MAC, true);
			//Server Socketのopenを待つ
			serverStartSem.acquire();
			for (int i = 0; i < REQUEST_LOOP_CNT; i++) {
				//PPPoE
				if (TEST_WITH_PPPOE) {
					//送信
					socket.write(pingRequest.getRaw());
					//受信
					int len = socket.read(data);
					System.out.println("id:"+i);
				//Pure Ethernet
				} else {
					//送信
					TextBitset total = createClientRequest();
					socket.write(total.getRaw());
//					System.out.println("write:"+total.get(TextBitset.HEX));
					//受信
					int len = socket.read(data);
					assertTrue(len >= 18);
					//IDのチェック
					TextBitset idData = new NativeTextBitset(data, 14, 4);
//					System.out.println("read:"+new NativeTextBitset(data, 0, len).get(TextBitset.HEX));
					long id = idData.getAsInteger();
					System.out.println("id:"+id);
					assertEquals(currentId, id);
				}
				
			}
			socket.close();
			return 0;
		}
	}
	
	class ServerJob implements Callable<Integer> {
		PcapSocket socket;
		byte[] data = new byte[1600];
		public boolean stop;
		
		public ServerJob() {
			this.socket = createSocket();
		}
		
		public Integer call() throws Exception {
			socket.setTimeout(SOCKET_TIMEOUT);
			socket.open();
			socket.setFilter("ether dst "+REMOTE_MAC, true);
			serverStartSem.release();
			int len;
			for (int i = 0; i < REQUEST_LOOP_CNT && !stop; i++) {
				//PPPoE
				if (TEST_WITH_PPPOE) {
					len = socket.read(data);
					socket.write(pingResponse.getRaw());
				//Pure Ethernet
				} else {
					len = socket.read(data);
					TextBitset result = createResponse(data, len);
//					System.out.println("Server Write:"+result.get(TextBitset.HEX));
					socket.write(result.getRaw());
				}
			}
			socket.close();
			return 0;
		}
	}

	public void testReadWriteSeperate2Thread() throws Exception {
		ExecutorService service = Executors.newCachedThreadPool();

		ClientJob client = new ClientJob();
		ServerJob server = new ServerJob();

		for (int i = 0; i < TEST_LOOP_CNT; i++) {
			Future<Integer> fClient = service.submit(client);
			Future<Integer> fServer = service.submit(server);
			
			fClient.get();
//			reader.stop = true;
			fServer.get();
		}
		
		service.shutdown();
	}

	private PcapSocket createSocket() {
		IPcapSocketFactory factory = IPcapSocketFactory.INSTANCE;
		PcapSocket socket = (PcapSocket)factory.createPcapSocket();
		socket.setPcapSetting(device, 1600, false, 5);
		return socket;
	}
	
}
