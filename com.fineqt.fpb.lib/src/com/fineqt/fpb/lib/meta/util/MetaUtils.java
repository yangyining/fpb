package com.fineqt.fpb.lib.meta.util;

import com.fineqt.fpb.lib.model.fpbmodule.EncodingType;
import com.fineqt.fpb.lib.type.PTypeEVExt;
import com.fineqt.fpb.lib.type.PTypeExt;

public class MetaUtils {
    /**
     * 取得优先类型编码变量(在派生关系中找到第一个有效的EV)
     * @param currentType
     * @return
     */
    public static PTypeEVExt findValidTypeEVMeta(PTypeExt currentType, PTypeEVExt defaultResult) {
        PTypeEVExt result = defaultResult;
        PTypeEVExt tempEV = currentType.getEVMeta();
        EncodingType prevEnode = currentType.getEncodingType();
        while(true) {
            //外部有效用外部
            if (tempEV != null && tempEV.hasSettedAttr()) {
                //与底层编码一致
                if (!prevEnode.equals(EncodingType.NONE) && 
                        tempEV.getEncodingType().equals(prevEnode)) {
                    result = tempEV;
                    break;
                //不一致则结束检索
                } else {
                    break;
                }
            //使用无效非空（当前为空时,且targetEnode一定为空）
            } else if (tempEV != null && result == null) {
                //与底层编码一致
                if (!prevEnode.equals(EncodingType.NONE) && 
                        tempEV.getEncodingType().equals(prevEnode)) {
                    result = tempEV;
                //不一致则结束检索
                } else {
                    break;
                }
            }
            //底层类编码
            prevEnode = currentType.getEncodingType();
            //上层类
            currentType = currentType.getSuperType();
            if (currentType == null) {
                break;
            }
            tempEV = currentType.getEVMeta();
        }
        return result;
    }

}
