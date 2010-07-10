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

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.fineqt.fpb.lib.api.util.IFpbSystem;

public class ContextPoolImpl implements ContextPool {
	private Queue<DecodeContext> decodeCxtQueue = 
		new ConcurrentLinkedQueue<DecodeContext>();
    private Queue<EncodeContext> encodeCxtQueue = 
        new ConcurrentLinkedQueue<EncodeContext>();
    private Queue<DumpContext> dumpCxtQueue = 
        new ConcurrentLinkedQueue<DumpContext>();
	
    
	@Override
	public DecodeContext borrowDecodeContext() {
		DecodeContext cxt = decodeCxtQueue.poll();
		if (cxt == null) {
			cxt = createDecodeContext();
		}
//		System.out.println("borrowDecodeContext:"+decodeCxtQueue.size());
		return cxt;
	}

	private DecodeContext createDecodeContext() {
		if (IFpbSystem.INSTANCE.isDebug()) {
			return new DebugDecodeContextImpl();
		} else {
			return new DecodeContextImpl();
		}
	}

	@Override
	public EncodeContext borrowEncodeContext() {
	    EncodeContext cxt = encodeCxtQueue.poll();
	    if (cxt == null) {
	        cxt = new EncodeContextImpl();
	    }
		return cxt;
	}

	@Override
	public DumpContext borrowDumpContext() {
	    DumpContext cxt = dumpCxtQueue.poll();
	    if (cxt == null) {
	        cxt = new DumpContextImpl();
	    }
		return cxt;
	}

	@Override
	public void returnDecodeContext(DecodeContext cxt) {
		cxt.passivate();
		decodeCxtQueue.add(cxt);
//		System.out.println("returnDecodeContext:"+decodeCxtQueue.size());
	}

    @Override
    public void returnDumpContext(DumpContext cxt) {
        cxt.passivate();
        dumpCxtQueue.add(cxt);
    }

    @Override
    public void returnEncodeContext(EncodeContext cxt) {
        cxt.passivate();
        encodeCxtQueue.add(cxt);
    }
	
}
