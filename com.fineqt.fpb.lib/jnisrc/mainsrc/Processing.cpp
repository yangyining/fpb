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
#include "Processing.h"

void 
Processing::processData(u_char *user, struct pcap_pkthdr *h, jbyte *sp) {
	jmethodID mid = 0;
	jclass cls = NULL;
	jbyteArray jba = NULL;
	int seconds;
	int useconds;
	register const struct timeval *tvp = NULL;

	//timestamp
	tvp = &h->ts;
	seconds = tvp->tv_sec;
	useconds = tvp->tv_usec;
	
	//check jvm error
	if(javaEnvironment->ExceptionOccurred()) {
	  	javaEnvironment->ExceptionDescribe();
	    return;
	}
	//get method id
	cls = javaEnvironment->GetObjectClass(javaObject);
	javaEnvironment->ExceptionDescribe();
	mid = javaEnvironment->GetMethodID(cls, "handlePacket", "(IIII[B)V");

	if(mid == 0) {
	    fprintf(stderr, "jni method lookup failure\n");
	    fflush(stdout); fflush(stderr);
	    return;
	}
	//create data array
	jba = javaEnvironment->NewByteArray(h->caplen);
	javaEnvironment->SetByteArrayRegion(jba, 0, h->caplen, sp);
	//call java method
	javaEnvironment->CallVoidMethod(javaObject, mid,
				     h->len, h->caplen, seconds, useconds,
				     jba);
	javaEnvironment->DeleteLocalRef(jba);
}


