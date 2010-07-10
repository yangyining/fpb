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
package com.fineqt.fpb.protocol;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import com.fineqt.fpb.lib.api.module.IFactory;
import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.buffer.IBitBuffer;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.api.value.IBooleanValue;
import com.fineqt.fpb.lib.api.value.ICharstringValue;
import com.fineqt.fpb.lib.api.value.IContainerValue;
import com.fineqt.fpb.lib.api.value.IIntegerValue;
import com.fineqt.fpb.lib.api.value.IListValue;
import com.fineqt.fpb.lib.api.value.IOctetstringValue;
import com.fineqt.fpb.lib.api.value.IRecordSetValue;
import com.fineqt.fpb.lib.api.value.IValue;
import com.fineqt.fpb.lib.codec.DecodeParameters;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.meta.context.CommonContext;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.meta.user.PUserTypeEVExtFactoryBase;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.PFpbTypeEV;
import com.fineqt.fpb.lib.type.PContainerTypeExt;
import com.fineqt.fpb.lib.type.PFieldExt;
import com.fineqt.fpb.lib.type.PFpbTypeEVExt;
import com.fineqt.fpb.lib.type.PListItemExt;
import com.fineqt.fpb.lib.type.PTypeExt;
import com.fineqt.fpb.lib.type.impl.PRecordOfTypeExtBase.PFpbRecordOfEVExt;
import com.fineqt.fpb.lib.type.impl.PRecordTypeExtBase.PFpbRecordEVExt;
import com.fineqt.fpb.lib.util.FpbConstants;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public class HttpTypeEVExtFactory extends PUserTypeEVExtFactoryBase {

    public static int HTTP_MESSAGE;
    public static int HTTP_MESSAGE__HEADERS;
    public static int HTTP_MESSAGE__HTTP_BODY;
    public static int HTTP_MESSAGE__TRAILERS;
    
    public static int HTTP_HEADER;
    public static int HTTP_HEADER__NAME;
    public static int HTTP_HEADER__VALUE;
    
    public static int HTTP_CHUNK;
    public static int HTTP_CHUNK__LENGTH_LINE;
    public static int HTTP_CHUNK__CHUNK_DATA;
    
    public static int HTTP_CHUNK_LENGTH_LINE;
    public static int HTTP_CHUNK_LENGTH_LINE__CHUNK_LENGTH;
    
    public static int HTTP_CHUNK_DATA;
    public static int HTTP_CHUNK_DATA__DATA;
    
    public static int HTTP_BODY;
    public static int HTTP_BODY__DATA;
    public static int HTTP_BODY__CHUNKS;
    
    public static int HTTP_HEADER_LIST;
    
    public static int HTTP_CHUNK_LIST;
    
    @Override
    public void postInitModule(PModuleExt module) throws InitMetaException {
        PContainerTypeExt containerType;
        //取得类型和字段的ID
        containerType = (PContainerTypeExt)module.pPType(Names.HTTP_MESSAGE);
        HTTP_MESSAGE = containerType.getID();
        HTTP_MESSAGE__HEADERS = containerType.getFieldID(Names.HTTP_MESSAGE__HEADERS);
        HTTP_MESSAGE__HTTP_BODY = containerType.getFieldID(Names.HTTP_MESSAGE__HTTP_BODY);
        HTTP_MESSAGE__TRAILERS = containerType.getFieldID(Names.HTTP_MESSAGE__TRAILERS);
        
        containerType = (PContainerTypeExt)module.pPType(Names.HTTP_HEADER);
        HTTP_HEADER = containerType.getID();
        HTTP_HEADER__NAME = containerType.getFieldID(Names.HTTP_HEADER__NAME);
        HTTP_HEADER__VALUE = containerType.getFieldID(Names.HTTP_HEADER__VALUE);
        
        containerType = (PContainerTypeExt)module.pPType(Names.HTTP_CHUNK);
        HTTP_CHUNK = containerType.getID();
        HTTP_CHUNK__LENGTH_LINE = containerType.getFieldID(Names.HTTP_CHUNK__LENGTH_LINE);
        HTTP_CHUNK__CHUNK_DATA = containerType.getFieldID(Names.HTTP_CHUNK__CHUNK_DATA);
        
        containerType = (PContainerTypeExt)module.pPType(Names.HTTP_CHUNK_LENGTH_LINE);
        HTTP_CHUNK_LENGTH_LINE = containerType.getID();
        HTTP_CHUNK_LENGTH_LINE__CHUNK_LENGTH = containerType.getFieldID(
                Names.HTTP_CHUNK_LENGTH_LINE__CHUNK_LENGTH);
        
        containerType = (PContainerTypeExt)module.pPType(Names.HTTP_CHUNK_DATA);
        HTTP_CHUNK_DATA__DATA = containerType.getFieldID(Names.HTTP_CHUNK_DATA__DATA);
        
        containerType = (PContainerTypeExt)module.pPType(Names.HTTP_BODY);
        HTTP_BODY__DATA = containerType.getFieldID(Names.HTTP_BODY__DATA);
        HTTP_BODY__CHUNKS = containerType.getFieldID(Names.HTTP_BODY__CHUNKS);
        
        HTTP_HEADER_LIST = module.pPType(Names.HTTP_HEADER_LIST).getID();
        
        HTTP_CHUNK_LIST = module.pPType(Names.HTTP_CHUNK_LIST).getID();
    }

    @Override
    protected PFpbTypeEVExt createTypeEVExt4FPB(PTypeExt typeMeta,
            PFpbTypeEV evModel) {
        String typeName = typeMeta.getName();
        if (typeName.equals(Names.HTTP_MESSAGE)) {
            return new HttpMessageTypeEVExt(evModel);
        } else if (typeName.equals(Names.HTTP_CHUNK)) {
            return new HttpChunkTypeEVExt(evModel);
        } else if (typeName.equals(Names.HTTP_HEADER)) {
            return new HttpHeaderTypeEVExt(evModel);
        } else if (typeName.equals(Names.HTTP_HEADER_LIST)) {
            return new HttpHeaderListTypeEVExt(evModel);
        } else if (typeName.equals(Names.HTTP_CHUNK_LIST)) {
            return new HttpChunkListTypeEVExt(evModel);
        } else if (typeName.equals(Names.HTTP_CHUNK_LENGTH_LINE)) {
            return new HttpChunkLengthLineTypeEVExt(evModel);
        } 
        return super.createTypeEVExt4FPB(typeMeta, evModel);
    }
    
    private static class HttpMessageTypeEVExt extends PFpbRecordEVExt {

        public HttpMessageTypeEVExt(PFpbTypeEV model) {
            super(model);
        }

        @Override
        protected void preEncode(EncodeContext cxt, PValue value, int parentLength,
                PTypeElementMeta elementMeta, ByteOrder byteOrder) {
            //父亲方法
            super.preEncode(cxt, value, parentLength, elementMeta, byteOrder);
            if (cxt.withCalculateAction()) {
                //更新Content-Length首部字段
                updateContentLength(value);
            }
        }

        private void updateContentLength(PValue value) {
            IContainerValue msgValue = (IContainerValue)value;
            //取得Content-Length首部字段
            @SuppressWarnings("unchecked")
            IListValue<IRecordSetValue> headers = (IListValue<IRecordSetValue>)
                    msgValue.getField(HTTP_MESSAGE__HEADERS);
            IValue contentLengthValue = null;
            if (headers != null) {
                for (int i = 0; i < headers.getLength(); i++) {
                    IRecordSetValue header = headers.getItem(i);
                    if (header == null) {
                        continue;                            
                    }
                    IValue name = header.getField(HTTP_HEADER__NAME);
                    if (name == null) {
                        continue;
                    }
                    if (HeaderNames.CONTENT_LENGTH.equals(name.getText())) {
                        contentLengthValue = header.getField(HTTP_HEADER__VALUE);
                    }
                }
            }
            //根据httpBody/data来更新
            if (contentLengthValue != null) {
                IContainerValue httpBody = (IContainerValue)msgValue.getField(
                        HTTP_MESSAGE__HTTP_BODY);
                if (httpBody != null && !httpBody.notPresent()) {
                    IOctetstringValue data = (IOctetstringValue)httpBody.getField(
                            HTTP_BODY__DATA);
                    if (data != null) {
                        String text = Integer.toString(data.getLength());
                        contentLengthValue.setText(text);
                    }
                }
            }
        }

    }    
    
    private static class HttpChunkTypeEVExt extends PFpbRecordEVExt {

        public HttpChunkTypeEVExt(PFpbTypeEV model) {
            super(model);
        }
        
        @Override
        protected void preEncode(EncodeContext cxt, PValue value, int parentLength,
                PTypeElementMeta elementMeta, ByteOrder byteOrder) {
            //父亲方法
            super.preEncode(cxt, value, parentLength, elementMeta, byteOrder);
            if (cxt.withCalculateAction()) {
                //更新chunkLength字段
                updateChunkLength(value);
            }
        }

        private void updateChunkLength(PValue value) {
            IContainerValue chunkValue = (IContainerValue)value;
            //取得chunkLength字段
            IValue chunkLength = null;
            IContainerValue lengthLine = (IContainerValue)chunkValue.getField(
                    HTTP_CHUNK__LENGTH_LINE);
            if (lengthLine != null) {
                chunkLength = lengthLine.getField(HTTP_CHUNK_LENGTH_LINE__CHUNK_LENGTH);
            }
            //根据chunkData/data来更新
            if (chunkLength != null) {
                IContainerValue chunkData = (IContainerValue)chunkValue.getField(
                        HTTP_CHUNK__CHUNK_DATA);
                //默认为0
                String text = "0";
                if (chunkData != null && !chunkData.notPresent()) {
                    IOctetstringValue data = (IOctetstringValue)chunkData.getField(
                            HTTP_CHUNK_DATA__DATA);
                    if (data != null) {
                        text = Integer.toString(data.getLength(), 16);
                    }
                }
                chunkLength.setText(text);
            }
        }


        @Override
        protected boolean postDecodeField(DecodeContext cxt, IReadableBitBuffer input,
                DecodeParameters paras, DecodeResult parentResult,
                DecodeResult fieldResult, PFieldExt fieldMeta) throws DecodeException {
            boolean ret = super.postDecodeField(cxt, input, paras, parentResult, 
                    fieldResult, fieldMeta);
            if (fieldMeta.getFieldID() == HTTP_CHUNK__LENGTH_LINE) {
                IFactory factory = getPModule().getFactory();
                IContainerValue lengthLine = (IContainerValue)fieldResult.getValue();
                if (lengthLine != null) {
                    ICharstringValue lenValue = (ICharstringValue)lengthLine.getField(
                            HTTP_CHUNK_LENGTH_LINE__CHUNK_LENGTH);
                    IBooleanValue chunked = factory.createBoolean();
                    if (lenValue != null && !lenValue.getText().equals("0")){
                        //hasChunkData
                        chunked.setBoolean(true);
                    } else {
                        //hasChunkData
                        chunked.setBoolean(false);
                    }
                    cxt.getFieldStackMap().setTopField(StackFields.HAS_CHUNK_DATA, 
                            chunked);
                }
            }
            return ret;
        }
        
        
    }    
    
    private static class HttpHeaderTypeEVExt extends PFpbRecordEVExt {

        public HttpHeaderTypeEVExt(PFpbTypeEV model) {
            super(model);
        }

        @Override
        protected boolean preDecode(DecodeContext cxt, IReadableBitBuffer input,
                PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult result) 
        throws DecodeException {
            boolean ret = super.preDecode(cxt, input, elementMeta, paras, result);
            if (!ret) {
                return ret;
            }
            //排除空行的情况
            return paras.getHypFixedLength() > CRLF_BITS;
        }
        
    }
    
    private static class HttpHeaderListTypeEVExt extends PFpbRecordOfEVExt {

        public HttpHeaderListTypeEVExt(PFpbTypeEV model) {
            super(model);
        }

        @Override
        protected DecodeResult postDecode(DecodeContext cxt, IReadableBitBuffer input,
                PTypeElementMeta elementMeta, DecodeParameters paras, 
                DecodeResult result) throws DecodeException {
            DecodeResult ret = super.postDecode(cxt, input, elementMeta, paras, result);
            PFieldExt fieldMeta = (PFieldExt)elementMeta.asFieldMeta();
            //已解码Header的处理
            if (fieldMeta != null && fieldMeta.getFieldID() == HTTP_MESSAGE__HEADERS) {
                IFactory factory = getPModule().getFactory();
                CommonContext.FieldStackMap fieldStack = cxt.getFieldStackMap();
                @SuppressWarnings("unchecked")
                IListValue<IRecordSetValue> headers = 
                    (IListValue<IRecordSetValue>)result.getValue();
                if (headers != null) {
                    for (int i = 0; i < headers.getLength(); i++) {
                        IRecordSetValue header = headers.getItem(i);
                        assert header != null;
                        processHeadersItem(factory, fieldStack, header);
                    }
                }
            }
            return ret;
        }
        
        @Override
        protected boolean postDecodeItem(DecodeContext cxt, IBitBuffer input,
                PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult parentResult,
                DecodeResult itemResult, PListItemExt itemMeta) {
            boolean ret = super.postDecodeItem(cxt, input, elementMeta, paras, parentResult, 
                    itemResult, itemMeta);
            if (!ret) {
                return ret;
            }
            PFieldExt fieldMeta = (PFieldExt)elementMeta.asFieldMeta();
            CommonContext.FieldStackMap fieldStack = cxt.getFieldStackMap();
            if (fieldMeta != null && fieldMeta.getFieldID() == HTTP_MESSAGE__TRAILERS) {
                @SuppressWarnings("unchecked")
                Set<String> nameSet = (Set<String>)fieldStack.peekField(
                        StackFields.TRAILER_NAMES);
                assert nameSet != null;
                IRecordSetValue trailer = (IRecordSetValue)itemResult.getValue();
                if (trailer == null) {
                    return ret;
                }
                ICharstringValue name = (ICharstringValue)trailer.getField(HTTP_HEADER__NAME);
                ICharstringValue value = (ICharstringValue)trailer.getField(HTTP_HEADER__VALUE);
                if (name == null || value == null) {
                    return false;
                }
                nameSet.remove(name.getText());
                //仍然有未处理的Trailer才继续List的循环
                return nameSet.size() > 0;
            }
            return ret;
        }

        private void processHeadersItem(IFactory factory,
                CommonContext.FieldStackMap fieldStack, IRecordSetValue header) {
            ICharstringValue name = (ICharstringValue)header.getField(HTTP_HEADER__NAME);
            ICharstringValue value = (ICharstringValue)header.getField(HTTP_HEADER__VALUE);
            if (name != null && value != null) {
                String nameText = name.getText();
                //Transfer-Encoding
                if (HeaderNames.TRANSFER_ENCODING.equals(nameText)) {
                    if (HeaderValues.CHUNKED.equals(value.getText())) {
                        //chunked
                        IBooleanValue chunked = factory.createBoolean();
                        chunked.setBoolean(true);
                        fieldStack.setTopField(StackFields.CHUNCKED, chunked);
                        //hasBody
                        IBooleanValue hasBody = factory.createBoolean();
                        hasBody.setBoolean(true);
                        fieldStack.setTopField(StackFields.HAS_BODY, hasBody);
                    }
                //Content-Length
                } else if (HeaderNames.CONTENT_LENGTH.equals(nameText)) {
                    try {
                        int contentLength = Integer.parseInt(value.getText());
                        if (contentLength > 0) {
                            //hasBody
                            IBooleanValue hasBody = factory.createBoolean();
                            hasBody.setBoolean(true);
                            fieldStack.setTopField(StackFields.HAS_BODY, hasBody);
                            //contentLength
                            IIntegerValue lenValue = factory.createInteger();
                            lenValue.setInteger(contentLength);
                            fieldStack.setTopField(StackFields.CONTENT_LENGTH, lenValue);
                        }
                    } catch (NumberFormatException e) {
                        //忽略错误长度
                    }
                //Trailer
                } else if (HeaderNames.TRAILER.equals(nameText)) {
                    String[] names = SPACE_DELIMITER.split(value.getText());
                    Set<String> nameSet = new TreeSet<String>();
                    for (int i = 0; i < names.length; i++) {
                        String trailerName = names[i].trim();
                        if (trailerName.length() > 0) {
                            nameSet.add(trailerName);
                        }
                    }
                    if (nameSet.size() > 0) {
                        //hasTrailers
                        IBooleanValue hasTrailers = factory.createBoolean();
                        hasTrailers.setBoolean(true);
                        fieldStack.setTopField(StackFields.HAS_TRAILERS, hasTrailers);
                        //trailerNames
                        fieldStack.setTopField(StackFields.TRAILER_NAMES, nameSet);
                    }
                }
            }
        }
        
    }
    
    private static class HttpChunkListTypeEVExt extends PFpbRecordOfEVExt {

        public HttpChunkListTypeEVExt(PFpbTypeEV model) {
            super(model);
        }

        @Override
        protected boolean postDecodeItem(DecodeContext cxt, IBitBuffer input,
                PTypeElementMeta elementMeta, DecodeParameters paras, DecodeResult parentResult,
                DecodeResult itemResult, PListItemExt itemMeta) {
            boolean ret = super.postDecodeItem(cxt, input, elementMeta, paras, parentResult, 
                    itemResult, itemMeta);
            if (!ret) {
                return ret;
            }
            IBooleanValue hasValue = (IBooleanValue)cxt.getFieldStackMap().peekField(
                    StackFields.HAS_CHUNK_DATA);
            if (hasValue == null || !hasValue.getBoolean()) {
                return false;
            }
            return true;
        }
        
    }    
    
    private static class HttpChunkLengthLineTypeEVExt extends PFpbRecordEVExt {

        public HttpChunkLengthLineTypeEVExt(PFpbTypeEV model) {
            super(model);
        }

        @Override
        protected DecodeResult postDecode(DecodeContext cxt, IReadableBitBuffer input,
                PTypeElementMeta elementMeta, DecodeParameters paras, 
                DecodeResult result) throws DecodeException {
            DecodeResult ret = super.postDecode(cxt, input, elementMeta, paras, result);
            if (ret.getValue() != null) {
                //设置chunkLength
                IContainerValue value = (IContainerValue)ret.getValue();
                IValue lenValue = value.getField(HTTP_CHUNK_LENGTH_LINE__CHUNK_LENGTH);
                IIntegerValue intValue = (IIntegerValue)cxt.getFieldStackMap().peekField(
                        StackFields.CHUNK_LENGTH);
                if (intValue == null) {
                    intValue = getPModule().getFactory().createInteger();
                    cxt.getFieldStackMap().setTopField(StackFields.CHUNK_LENGTH, intValue);
                }
                try {
                    intValue.setInteger(Integer.parseInt(lenValue.getText(), 16));
                } catch (NumberFormatException e) {
                    //有错误时认为是0
                    intValue.setInteger(0);
                }
            }
            return ret;
        }
        
    }
    
    interface Names {
        String HTTP_MESSAGE = "HttpMessage";
        String HTTP_MESSAGE__HEADERS = "headers";
        String HTTP_MESSAGE__HTTP_BODY = "httpBody";
        String HTTP_MESSAGE__TRAILERS = "trailers";
        
        String HTTP_HEADER = "HttpHeader";
        String HTTP_HEADER__NAME = "name";
        String HTTP_HEADER__VALUE = "value";
        
        String HTTP_CHUNK = "HttpChunk";
        String HTTP_CHUNK__LENGTH_LINE = "lengthLine";
        String HTTP_CHUNK__CHUNK_DATA = "chunkData";
        
        String HTTP_CHUNK_LENGTH_LINE = "HttpChunkLengthLine";
        String HTTP_CHUNK_LENGTH_LINE__CHUNK_LENGTH = "chunkLength";
        
        String HTTP_CHUNK_DATA = "HttpChunkData";
        String HTTP_CHUNK_DATA__DATA = "data";
        
        String HTTP_BODY = "HttpBody";
        String HTTP_BODY__DATA = "data";
        String HTTP_BODY__CHUNKS = "chunks";
        
        String HTTP_HEADER_LIST = "HttpHeaderList";
        
        String HTTP_CHUNK_LIST = "HttpChunkList";
    }
    
    interface HeaderNames {
        String CONTENT_LENGTH = "Content-Length";
        String TRANSFER_ENCODING = "Transfer-Encoding";
        String TRAILER = "Trailer";
    }
    
    interface StackFields {
        String CHUNCKED = "chunked";
        String CONTENT_LENGTH = "contentLength";
        String HAS_BODY = "hasBody";
        String HAS_TRAILERS = "hasTrailers";
        String TRAILER_NAMES = "trailerNames";
        String HAS_CHUNK_DATA = "hasChunkData";
        String CHUNK_LENGTH = "chunkLength";
    }
    
    interface HeaderValues {
        String CHUNKED = "chunked";
    }
    
    final private static int CRLF_BITS = 4 * FpbConstants.OCTET_BITS;
    final private static Pattern SPACE_DELIMITER = Pattern.compile(",");
}
