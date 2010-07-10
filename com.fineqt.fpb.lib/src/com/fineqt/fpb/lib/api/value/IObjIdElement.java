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

public interface IObjIdElement {
	/**
	 * Sets the internal representation of this ObjIdElement to string value element.
	 * @param element
	 */
	public void setElementAsAscii(String element) ;
	/**
	 * Set this the internal representation of this ObjIdElement to the
	 * integer value element.
	 * @param element
	 */
	public void setElementAsNumber(int element) ;
	/**
	 * Returns the internal representation of this ObjIdElement as string.
	 * @return
	 */
	public String getElementAsAscii() ;
	/**
	 * Returns the internal representation of this ObjIdElement as integer.
	 * @return
	 */
	public int getElementAsNumber();
}
