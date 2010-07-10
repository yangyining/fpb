package com.fineqt.fpb.lib.meta.context;

import java.util.Collection;
import java.util.List;

import com.fineqt.fpb.lib.grammer.mv.ModuleSymbol;
import com.fineqt.fpb.lib.meta.exception.InitMetaException;
import com.fineqt.fpb.lib.model.fpbmodule.PModule;
import com.fineqt.fpb.lib.modelview.ModuleMV;

public interface PModuleParsingContext {
    /**
     * 压入但前正在编译的模块，用于检测是否有循环引用。
     * @param moduleInInit
     */
    void pushModuleInParsing(ModuleSymbol moduleInParsing);
    ModuleSymbol popModuleInParsing();
    ModuleSymbol peekModuleParsing();
    ModuleSymbol findModuleInParsing(String moduleName);
    Collection<String> getModuleInParsingStack();
    /**
     * 取得所有这次编译已生成的模块符号对象。由于有引入关系，所以有可能有多个。
     * @return
     */
    List<ModuleSymbol> getResultList();
    /**
     * 取得指定的已生成模块符号对象。
     * @param moduleName
     * @return
     */
    ModuleSymbol getResult(String moduleName);
    /**
     * 取得所有被生成的模块模型对象，由于有引入关系，所以有可能有多个。
     * @return
     */
    List<PModule> getAllResultModel();
    /**
     * 取得已生成视图。按照如下顺序取得：
     *   PModuleExt.Registry.PINSTANCE.getResolvedPModule()
     *   getResult()
     *   没有找到
     * @param name
     * @return
     * @throws InitMetaException
     */
    ModuleMV getCreatedModule(String name);
}
