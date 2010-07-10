/*************************************************************************
Protocol Meter, copyright (C) 2007-2008 fineqt.com

Protocol Meter is free software; you can redistribute it and/or modify it 
under the terms of version 2.1 of the GNU Lesser General Public License as 
published by the Free Software Foundation.

Protocol Meter is distributed in the hope that it will be useful, but WITHOUT 
ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
License for more details at gnu.org.
**************************************************************************/
package com.fineqt.fpb.lib.api.comm;

import java.io.IOException;
/**
 * 
 * @author JiangMin
 *
 */
public class CommClosedException extends IOException{
    public final static long serialVersionUID = 0;

	public CommClosedException() {
		super();
	}

	public CommClosedException(String message) {
		super(message);
	}

}
