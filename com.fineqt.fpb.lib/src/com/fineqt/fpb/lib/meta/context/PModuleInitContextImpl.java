package com.fineqt.fpb.lib.meta.context;

import java.util.ArrayList;
import java.util.List;

import com.fineqt.fpb.lib.meta.PModuleExt;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;

public class PModuleInitContextImpl implements PModuleInitContext{
    private List<PModule> modelList = new ArrayList<PModule>();
    private List<PModuleExt> resultList = new ArrayList<PModuleExt>();
    
    @Override
    public PModule getModelForInit(String moduleName) {
        for (PModule model : modelList) {
            if (model.getName().equals(moduleName)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public List<PModule> getModelsForInit() {
        return modelList;
    }

    @Override
    public PModuleExt getCreatedModule(String moduleName) {
        //已生成未注册的模型
        PModuleExt result = getResult(moduleName);
        if (result != null) {
            return result;
        }
        //已注册的模型
        result = PModuleExt.Registry.PINSTANCE.getResolvedPModule(moduleName);
        return result;
    }

    @Override
    public PModuleExt getResult(String moduleName) {
        for (PModuleExt meta : resultList) {
            if (meta.getModuleName().equals(moduleName)) {
                return meta;
            }
        }
        return null;
    }

    @Override
    public List<PModuleExt> getResultList() {
        return resultList;
    }

}
