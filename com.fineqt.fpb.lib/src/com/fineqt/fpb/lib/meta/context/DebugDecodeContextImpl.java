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
package com.fineqt.fpb.lib.meta.context;

import java.util.ArrayList;
import java.util.List;

import com.fineqt.fpb.lib.codec.DecodeResult;

public class DebugDecodeContextImpl extends DecodeContextImpl 
implements DebugDecodeContext {
	private List<DecodeResult> results = new ArrayList<DecodeResult>();
	
	@Override
	public void addResult(DecodeResult result) {
		results.add(result);
	}

	@Override
	public List<DecodeResult> getAllResults() {
		return results;
	}

	@Override
	public List<DecodeResult> getNotChainedResults() {
		List<DecodeResult> list = new ArrayList<DecodeResult>();
		for (DecodeResult decodeResult : results) {
			if (decodeResult.getValue() == null || decodeResult.getValue().pParent() == null) {
				list.add(decodeResult);
			}
		}
		return list;
	}

	@Override
	public void passivate() {
		results.clear();
		super.passivate();
	}

}
