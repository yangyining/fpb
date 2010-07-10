package com.fineqt.fpb.lib.type;

import java.util.List;

import com.fineqt.fpb.lib.api.util.DecodeException;
import com.fineqt.fpb.lib.api.util.EncodeException;
import com.fineqt.fpb.lib.api.util.buffer.IReadableBitBuffer;
import com.fineqt.fpb.lib.codec.DecodeResult;
import com.fineqt.fpb.lib.meta.PEnumItemExt;
import com.fineqt.fpb.lib.meta.context.DecodeContext;
import com.fineqt.fpb.lib.meta.context.EncodeContext;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.ByteOrder;
import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.value.PTypeElementMeta;
import com.fineqt.fpb.lib.value.PValue;

public interface PItemFieldExt extends PTypeElementMeta {
    void setType(PTypeExt typeMeta);
    PTypeExt getType();
    PTypeExt getOwner();
    /**
     * 编码
     * @return
     */
    EncodingType getEncodingType();
    /**
     * 初始化
     * @throws InitMetaException
     */
    void init() throws InitMetaException;
    /**
     * 取得该字段的编码属性Meta对象,可能为空。
     */
    PItemFieldEVExt getEVMeta();
    /**
     * 取得EnumItem的定义。
     * 可以是根据enumRef属性而引用的PEnumSet的值，也可以是自己定义的PEnumItem。
     */
    List<PEnumItemExt> getEnumItems();
    /**
     * 生成该字段的默认值。
     * @return
     */
    PValue createDefaultValue();
    /**
     * 生成该字段的默认值。
     * @param forcePresent 确保创建非omit对象。
     * @return
     */
    PValue createDefaultValue(boolean forcePresent);
    /**
     * 
     */
    PValue createOmitValue();
    /**
     * 
     */
    PValue createEmptyValue();
    
    int encode(EncodeContext cxt, PValue value, int parentLength, ByteOrder byteOrder) 
    throws EncodeException;
    
    DecodeResult decode(DecodeContext cxt, IReadableBitBuffer input, DecodeResult parentResult, 
            ByteOrder byteOrder) throws DecodeException; 
}
