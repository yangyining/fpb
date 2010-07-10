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
#ifndef PROCESSING_H
#define PROCESSING_H

extern "C" {
#include <pcap.h>
}
#include <jni.h>

/**
 * パケット処理用ホッククラス
 */
class Processing {
public:
	void processData(u_char *user, struct pcap_pkthdr *h, jbyte *sp);
	/**
	 * Java Handler
	 */
	jobject javaObject;	
	/**
	 * Java VM
	 */
	JNIEnv *javaEnvironment; 
};

#endif
