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
package com.fineqt.fpb.protocol;

import com.fineqt.fpb.lib.api.IUnionValue;
import com.fineqt.fpb.lib.api.IValue;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PListTypeExtBase;

public class TcpTypeEVExtFactory extends PUserTypeEVExtFactoryBase {
	public static int TCP_OPTION_LIST;
	public static int LAST_OPTION;
	
	@Override
	public void postInitModule(PModuleExt module) throws InitMetaException {
		//取得类型和字段的ID
		TCP_OPTION_LIST = module.pPType(Names.TCP_OPTION_LIST).getID();
		LAST_OPTION = module.pPType(Names.LAST_OPTION).getID();
	}
	
	@Override
	protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta,
			PFpbTypeEV evModel) {
		String typeName = typeMeta.getName();
		if (Names.TCP_OPTION_LIST.equals(typeName)) {
			return new TcpOptionListEVExt(evModel);
		} else if (Names.TCP_PROTOCOL.equals(typeName)) {
			return new UdpTypeEVExtFactory.UdpTcpProtocolTypeEVExt(evModel, false);
		}
		return super.createTypeEVExt4FPB(typeMeta, evModel);
	}
	
	private static class TcpOptionListEVExt extends PListTypeExtBase.PFpbListEVExt {

		public TcpOptionListEVExt(PFpbTypeEV model) {
			super(model);
		}

		@Override
		protected boolean postDecodeItem(DecodeContext cxt, IBitBuffer input, DecodeParameters paras,
				DecodeResult parentResult, DecodeResult itemResult, PListItemExt itemMeta) {
			if (itemResult.getValue() != null ) {
				IUnionValue listItem = (IUnionValue)itemResult.getValue();
				IValue variant = listItem.getPresentVariant();
				//遇到LastOption后停止列表余下项目的解码
				if (variant != null && variant.getType().getID() == LAST_OPTION) {
					return false;
				}
			}
			return true;
		}
		
	}
	
	interface Names {
		String TCP_OPTION_LIST = "TcpOptionList";
		String LAST_OPTION = "LastOption";
		String TCP_PROTOCOL = "TcpProtocol";
	}
}
