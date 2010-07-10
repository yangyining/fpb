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

import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase.PFpbRecordEVExt;
import com.fineqt.fpb.lib.type.impl.PUnionTypeExtBase.PFpbUnionEVExt;
import com.fineqt.fpb.lib.value.PTypeElementMeta;

public class Ipv6TypeEVExtFactory extends PUserTypeEVExtFactoryBase {
	public final static String HEADER_FIELD = "Ipv6Protocol.header";
    private final static String NEXT_HEADER_FIELD = "nextHeader";
    private final static String IS_FRAGMENT_FIELD = "isFragment";
	
	public static int IPV6_HEADER;
	public static int IPV6_HEADER_SOURCE_ADDRESS;
	public static int IPV6_HEADER_DESTINATION_ADDRESS;
	public static int FRAGMENT_HEADER;
	public static int FRAGMENT_HEADER__FRAGMENT_OFFSET;
	public static int FRAGMENT_HEADER__MORE_FRAGS;
	public static int IPV6_DATA;

	@Override
	public void postInitModule(PModuleExt module) throws InitMetaException {
        //取得类型和字段的ID
		PContainerTypeExt containerType = (PContainerTypeExt)module.pPType(
				Names.IPV6_HEADER);
		IPV6_HEADER = containerType.getID();
		IPV6_HEADER_SOURCE_ADDRESS = containerType.getFieldID(
				Names.IPV6_HEADER_SOURCE_ADDRESS);
		IPV6_HEADER_DESTINATION_ADDRESS = containerType.getFieldID(
				Names.IPV6_HEADER_DESTINATION_ADDRESS);

		containerType = (PContainerTypeExt)module.pPType(
                Names.FRAGMENT_HEADER);
		FRAGMENT_HEADER = containerType.getID();
		FRAGMENT_HEADER__FRAGMENT_OFFSET = containerType.getFieldID(
		        Names.FRAGMENT_HEADER__FRAGMENT_OFFSET);
        FRAGMENT_HEADER__MORE_FRAGS = containerType.getFieldID(
                Names.FRAGMENT_HEADER__MORE_FRAGS);
        
        IType unionType = module.pPType(Names.IPV6_DATA);
        IPV6_DATA = unionType.getID();
	}
	
    @Override
    protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta,
            PFpbTypeEV evModel) {
        String typeName = typeMeta.getName();
        if (typeName.equals(Names.FRAGMENT_HEADER)) {
            return new FragmentHeaderEVExt(evModel);
        } else if (typeName.equals(Names.IPV6_DATA)) {
            return new Ipv6DataEVExt(evModel);
        }
        return super.createTypeEVExt4FPB(typeMeta, evModel);
    }
	
    private static class FragmentHeaderEVExt extends PFpbRecordEVExt {
        
        public FragmentHeaderEVExt(PFpbTypeEV model) {
            super(model);
        }

        @Override
        protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer orgInput,
                PTypeElementMeta elementMeta, DecodeParameters paras, 
                DecodeResult selfResult) throws DecodeException {
            //父方法
            DecodeResult rst = super.doDecode(cxt, orgInput, elementMeta, paras, selfResult);
            IRecordSetValue header = (IRecordSetValue)rst.getValue();
            if (header != null) {
                //判断是否为断片
                boolean isFragment = false;
                IBooleanValue moreFrags = (IBooleanValue)header.getField(
                        FRAGMENT_HEADER__MORE_FRAGS);
                if (moreFrags != null && moreFrags.getBoolean()) {
                    isFragment = true;
                } else {
                    IIntegerValue fragOffset = (IIntegerValue)header.getField(
                            FRAGMENT_HEADER__FRAGMENT_OFFSET);
                    if (fragOffset != null && fragOffset.getInteger() > 0) {
                        isFragment = true;
                    }
                }
                //设置isFragment字段
                if (isFragment) {
                    IBooleanValue boolValue = getPModule().getFactory().createBoolean();
                    boolValue.setBoolean(true);
                    cxt.getFieldStackMap().setTopField(IS_FRAGMENT_FIELD, boolValue);
                }
            }
            return rst;
        }
        
    }

    private static class Ipv6DataEVExt extends PFpbUnionEVExt {
        
        public Ipv6DataEVExt(PFpbTypeEV model) {
            super(model);
        }

        @Override
        protected DecodeResult doDecode(DecodeContext cxt, IReadableBitBuffer orgInput,
                PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult result)
        throws DecodeException {
            //判断是否是断片
            IBooleanValue isFragment = (IBooleanValue)cxt.getFieldStackMap().peekField(
                    IS_FRAGMENT_FIELD);
            if (isFragment != null && isFragment.getBoolean()) {
                //清除nextHeader堆栈字段,保证上层协议不被解释
                cxt.getFieldStackMap().setTopField(NEXT_HEADER_FIELD, null);
            }
            //父方法
            return super.doDecode(cxt, orgInput, elementMeta, paras, result);
        }
        
    }
    
	interface Names {
		String IPV6_HEADER = "Ipv6Header";
		String IPV6_HEADER_SOURCE_ADDRESS = "sourceAddress";
		String IPV6_HEADER_DESTINATION_ADDRESS = "destinationAddress";
		String FRAGMENT_HEADER = "FragmentHeader";
		String FRAGMENT_HEADER__FRAGMENT_OFFSET = "fragmentOffset";
		String FRAGMENT_HEADER__MORE_FRAGS = "moreFlags";
		String IPV6_DATA = "Ipv6Data";
	}
	
}
