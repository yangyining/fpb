package com.fineqt.fpb.lib.meta.context;

import java.util.List;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;

public interface PModuleInitContext {
    List<PModule> getModelsForInit();
    
    PModule getModelForInit(String moduleName);
    
//    void pushModuleInInit(PModuleExt moduleInInit);
//    
//    PModuleExt popModuleInInit();
//    
//    PModuleExt peekModuleInInit();
//    
//    PModuleExt findModuleInInit(String moduleName);

    PModuleExt getCreatedModule(String moduleName);
    
    List<PModuleExt> getResultList();
    
    PModuleExt getResult(String moduleName);
}
