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

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.value.PContainerValue;
import com.fineqt.fpb.lib.value.PValue;

public class SimpleContainerDecodeResult extends SimpleDecodeResult 
implements ContainerDecodeResult{
	FieldSettedReaction firstReaction;
	
	@Override
	public void addFieldSettedReaction(FieldSettedReaction reaction) {
		reaction.setOwner(this);
		if (firstReaction == null) {
			firstReaction = reaction;
		} else {
			FieldSettedReaction lastReaction = firstReaction;
			while(lastReaction.getNext() != null) {
				lastReaction = lastReaction.getNext();
			}
			lastReaction.setNext(reaction);
		}
	}

	@Override
	public PValue getFieldByID(int fieldId) {
		PContainerValue containerValue = (PContainerValue)value;
		if (containerValue == null)
			throw new IllegalStateException();
		return containerValue.pGetFieldByID(fieldId);
	}

	@Override
	public void setFieldByID(int fieldId, PValue fieldValue) throws DecodeException {
		PContainerValue containerValue = (PContainerValue)value;
		if (containerValue == null)
			throw new IllegalStateException();
		containerValue.pSetFieldByID(fieldId, fieldValue);
		//响应动作
		if (firstReaction != null) {
			FieldSettedReaction prevReaction = null;
			FieldSettedReaction curReaction = firstReaction;
			while(curReaction != null) {
				//匹配
				if (curReaction.getTargetFieldID() == fieldId) {
					//执行匹配的动作
					curReaction.fieldSetted(fieldId, fieldValue);
					//删除该动作
					if (prevReaction != null) {
						prevReaction.setNext(curReaction.getNext());
					}
					FieldSettedReaction tmpReaction = curReaction;
					curReaction = curReaction.getNext();
					tmpReaction.setNext(null);
					tmpReaction.setOwner(null);
				//不匹配，取得下一个
				} else {
					prevReaction = curReaction;
					curReaction = curReaction.getNext();
				}
			}
		}
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
		builder.appendSuper(super.toString());
		if (firstReaction == null) {
			builder.append("firstReaction", (String)null);
		} else {
			FieldSettedReaction action = firstReaction;
			int i = 0;
			while(action != null) {
				builder.append("firstReaction["+i+"]", action);
				action = action.getNext();
				i++;
			}
		}
		return builder.toString();
	}

}
