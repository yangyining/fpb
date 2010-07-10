package com.fineqt.fpb.lib.codec;

import org.apache.commons.pool.impl.SoftReferenceObjectPool;

import com.fineqt.fpb.lib.meta.impl.PPoolableObjectFactoryBase;

public class DecodeParametersPool extends SoftReferenceObjectPool {
	private static DecodeParametersPool instance;
	
	synchronized static public DecodeParametersPool getInstance() {
		if (instance == null) {
			instance = new DecodeParametersPool();
		}
		return instance;
	}
	
	@Override
	public synchronized DecodeParameters borrowObject() {
		try {
			return (DecodeParameters)super.borrowObject();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized void returnObject(Object obj) {
		assert obj instanceof DecodeParameters;
		try {
			super.returnObject(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private DecodeParametersPool() {
		super(new DecodeParametersFactory());
	}
	
	private static class DecodeParametersFactory extends PPoolableObjectFactoryBase {
		
		@Override
		public DecodeParameters makeObject() throws Exception {
			return new SimpleDeocdeParameters();
		}

	}
	
}
