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
package com.fineqt.fpb.lib.codec;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


abstract public class FieldSettedReactionBase implements FieldSettedReaction {
	protected FieldSettedReaction next;
	protected ContainerDecodeResult owner;
	protected int targetFieldID;
	
	public FieldSettedReactionBase(int targetFieldID) {
		this.targetFieldID = targetFieldID;
	}

	@Override
	public FieldSettedReaction getNext() {
		return next;
	}

	@Override
	public ContainerDecodeResult getOwner() {
		return owner;
	}

	@Override
	public void setOwner(ContainerDecodeResult owner) {
		this.owner = owner;
	}

	@Override
	public int getTargetFieldID() {
		return targetFieldID;
	}

	@Override
	public void setNext(FieldSettedReaction next) {
		this.next = next;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("targetFieldID", targetFieldID)
		.toString();
	}
}
