#ifdef WIN32
#include<winsock2.h>
#endif /* for WIN32 */

#ifndef WIN32
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#endif /* for Linux */

#include <pcap.h>
#include <iostream>
#include <string>
#include <cassert>

#include "TextBitset.h"
#include "AutotestUtil.h"

using namespace std;

#define MAX_PACKET_SIZE 1600

/**
 * 現在時刻の取得。timevalをミリ秒に転換
 * Windowsの場合はマシン起動からの時間である。
 */
#ifdef WIN32	
DWORD getsystime() {
  	return GetTickCount();
#else
long getsystime() {  	
  	timeval tv;
  	long rst = gettimeofday(&tv, NULL);
  	assert(rst == 0);
  	return tv.tv_sec * 1000 + tv.tv_usec / 1000;
#endif
}

string getDeviceName(int index) {
	pcap_if_t *alldevs;
	pcap_if_t *d;
	char errbuf[PCAP_ERRBUF_SIZE];
	int i=0;
    
	if (pcap_findalldevs(&alldevs, errbuf) == -1) {
    	assert(false);
    }

    for(i=0,d=alldevs; d != NULL && i < index; d=d->next,i++);
	
    string rst = d->name;
	return rst;
}

void testGetDeviceList() {
	cout << "testGetDeviceList" << endl;
	pcap_if_t *alldevs;
	pcap_if_t *d;
	char errbuf[PCAP_ERRBUF_SIZE];
	int i=0;
	//device listの取得
    if (pcap_findalldevs(&alldevs, errbuf) == -1) {
    	assert(false);
    }
	//device名の取得
    for(i=0,d=alldevs;d;d=d->next,i++) {
    	cout << d->name << endl;
    }
    //device listのリリース
    pcap_freealldevs(alldevs);
}

void testSendRecvPacket() {
	cout << "testSendRecvPacket" << endl;
//	const char * LOCAL_MAC = "00:16:cf:2d:ce:e4";
	const char * REMOTE_MAC = "00:16:01:15:a4:88";
	
	pcap_t * handleWrite;
	pcap_t * handleRead;
	char errbuf[PCAP_ERRBUF_SIZE];
	int snaplen = MAX_PACKET_SIZE;
	int promisc = 1;
	int to_ms = 1;
	string dev = getDeviceName(0);
    cout << "device:" << dev << endl;
	struct bpf_program program;
	int rst;
	struct pcap_pkthdr *header;
  	const u_char * data;
	string rawData;
	//open pcap
  	handleWrite = pcap_open_live(dev.c_str(), snaplen, promisc, to_ms, errbuf);
	assert(handleWrite != NULL);
  	handleRead = pcap_open_live(dev.c_str(), snaplen, promisc, to_ms, errbuf);
	assert(handleRead != NULL);
	
#ifdef WIN32
	//set min copy size
	rst = pcap_setmintocopy(handleWrite, 1);
	assert(rst == 0);
    cout << "pcap_setmintocopy:" << rst << endl;
	rst = pcap_setmintocopy(handleRead, 1);
	assert(rst == 0);
    cout << "pcap_setmintocopy:" << rst << endl;
#else
	rst = pcap_setnonblock(handleRead, 1, errbuf);
	assert(rst == 0);
#endif
	//set filter
	string filter;
	filter = filter + "ether dst " + REMOTE_MAC;
	//条件のコンパイル
	rst = pcap_compile(handleRead, &program, const_cast<char *>(filter.c_str()), 1U, 0);
//	cout << pcap_geterr(handleRead) << endl;
	assert(rst == 0);
	//フィルタの設定
	rst = pcap_setfilter(handleRead, &program);
	assert(rst == 0);
	//send packet
//	TextBitset sets;
//	TextBitset sets = TextBitset("0016CF2DCEE40016CF2DCEE5000000000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001000000010000000100000001", TextBitset::HEX);
	TextBitset sets = TextBitset("00160115a4880016cf2dcee408004500003c78b5000080012ab5c0a80b05c0a80b010800165c020035006162636465666768696a6b6c6d6e6f7071727374757677616263646566676869", TextBitset::HEX);
	rawData = sets.getRaw();
#ifdef WIN32	
	DWORD startms;
	DWORD totalstartms;
#else
	long startms;
	long totalstartms;
#endif
	int cnt = 1000;
	totalstartms = getsystime();
#ifndef WIN32
#endif
	for(int i = 0; i < cnt; i++) {
		//write
//		cout << "sent:" << i << endl;
	  	startms = getsystime();
		rst = pcap_sendpacket(handleWrite, (const unsigned char *)rawData.data(), rawData.size());
//	  	cout << "sendms: " << (int)(getsystime() - startms) << endl;
		assert(rst == 0);
		//read
		startms = getsystime();
#ifndef WIN32
		fd_set fd_wait;
		int sel;
		struct timeval st;
	    FD_ZERO(&fd_wait);
	//	    FD_SET(pcap_fileno(handleRead), &fd_wait);
	    FD_SET(pcap_get_selectable_fd(handleRead), &fd_wait);
	    st.tv_sec = 5;
	    st.tv_usec = 0;
	    sel = select(FD_SETSIZE, &fd_wait, NULL, NULL, &st);
		assert(sel > 0);	    
#endif
	  	cout << "readms1: " << (int)(getsystime() - startms) << endl;
		rst = pcap_next_ex(handleRead, &header, &data);
		assert(rst == 1);
	  	cout << "readms2: " << (int)(getsystime() - startms) << endl;
		rawData = string((char *)data, header->caplen);
		sets.setRaw(rawData);
//		cout << "recved:" << sets.get(TextBitset::HEX) << endl;
	}
	cout << "totalms:" << getsystime() - totalstartms << endl;
	//recv packet
//	for(int i = 0; i < cnt; i++) {
//#ifndef WIN32
//		fd_set fd_wait;
//		int sel;
//		struct timeval st;
//	    FD_ZERO(&fd_wait);
//	    FD_SET(pcap_fileno(handleWrite), &fd_wait);
//	    st.tv_sec	 = 5;
//	    st.tv_usec = 0;
//	    sel = select(FD_SETSIZE, &fd_wait, NULL, NULL, &st);
//	    cout << "sel:" << sel << endl;
//		assert(sel > 0)	    
//#endif
//		rst = pcap_next_ex(handleWrite, &header, &data);
//		assert(rst == 1);
//		rawData = string((char *)data, header->caplen);
//		sets.setRaw(rawData);
//		cout << "recved:" << sets.get(TextBitset::HEX) << endl;
//
//	}
	//close pcap
	pcap_close(handleWrite);
}
