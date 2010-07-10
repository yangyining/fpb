package com.fineqt.fpb.lib.type;

import com.fineqt.fpb.lib.value.PValue;

public interface PFpbItemFieldEVExt extends PItemFieldEVExt {
    PValue getDefaultValue();
    /**
     * 
     * @return -1代表无效
     */
    int getDefaultLength();
    boolean isOverrideWhole();
}
