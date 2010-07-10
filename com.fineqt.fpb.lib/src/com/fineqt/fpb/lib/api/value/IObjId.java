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
package com.fineqt.fpb.lib.api.value;

public interface IObjId {
	/**
	 * Returns the size of this Object Id in TciObjIdElements.
	 * @return
	 */
	public int size() ;
	/**
	 * Sets this ObjId to the list of objElements.
	 * @param objElemens
	 */
	public void setObjElement(IObjIdElement[] objElemens) ;
	/**
	 * Return the TciObjIdElement at position index.
	 * @param index
	 * @return
	 */
	public IObjIdElement getObjElement(int index) ;
}
