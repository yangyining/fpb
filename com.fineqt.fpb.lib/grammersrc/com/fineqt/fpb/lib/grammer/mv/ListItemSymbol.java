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
package com.fineqt.fpb.lib.grammer.mv;

import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbListItemEV;
import com.fineqt.fpb.lib.model.fpbmodule.PListItem;
import com.fineqt.fpb.lib.model.fpbmodule.PPropertyList;
import com.fineqt.fpb.lib.modelview.ListItemMV;
import com.fineqt.fpb.lib.modelview.TypeMV;

public class ListItemSymbol extends SymbolElement implements ListItemMV {
	private TypeMV ownerTypeMV;
	private String itemTypeName;
	private TypeMV itemTypeMV;
	private PListItem model;
	private PPropertyList propertyList;
	
	public ListItemSymbol(TypeMV ownerTypeMV, String itemTypeName) {
		this.ownerTypeMV = ownerTypeMV;
		this.itemTypeName = itemTypeName;
	}
	
	@Override
	public TypeMV getItemTypeMV() {
		return itemTypeMV;
	}
	@Override
	public String getItemTypeName() {
		return itemTypeName;
	}
	@Override
	public TypeMV getOwnerTypeMV() {
		return ownerTypeMV;
	}

	public PListItem getModel() {
		return model;
	}

	public void setModel(PListItem model) {
		this.model = model;
	}

	public PPropertyList getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(PPropertyList propertyList) {
		this.propertyList = propertyList;
	}

	@Override
	protected void doInitModel(ParserHelper cxt) {
		ListTypeSymbol listType = (ListTypeSymbol)ownerTypeMV;
		//加入类
		listType.getModel().setItem(model);
		//根据Field自己->Type来取得EncodingType
		if (!model.isSetEncode()) {
			EncodingType typeEncode = listType.getEncodingType();
			if (typeEncode != null && typeEncode != EncodingType.NONE) {
				model.setEncode(typeEncode);
			}
		}
		//初始EncodeVariant
		if (model.getEncode() == EncodingType.FPB) {
			PFpbListItemEV itemEv;
			if (model.getVariant() instanceof PFpbListItemEV) {
				itemEv = (PFpbListItemEV)model.getVariant();
			} else {
				itemEv = mfactory.createPFpbListItemEV();
				model.setVariant(itemEv);
			}
			//PropertyList
			PPropertyList prpList;
			if (propertyList == null) {
				prpList = mfactory.createPPropertyList();
			} else {
				//在ListItem中直接使用
				prpList = propertyList;
			}
			itemEv.setPrpList(prpList);
		}
	}

	public void setItemTypeMV(TypeMV itemTypeMV) {
		this.itemTypeMV = itemTypeMV;
	}
	
}
