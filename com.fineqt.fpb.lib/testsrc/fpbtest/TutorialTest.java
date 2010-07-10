package fpbtest;

import junit.framework.TestCase;

import com.fineqt.fpb.lib.api.module.IConstant;
import com.fineqt.fpb.lib.api.module.IModule;
import com.fineqt.fpb.lib.api.module.IType;
import com.fineqt.fpb.lib.api.util.IModuleRegistry;
import com.fineqt.fpb.lib.api.util.IValueDumper;
import com.fineqt.fpb.lib.type.PListTypeExt;

public class TutorialTest extends TestCase {

    public void testLoad() {
        IModule module = IModuleRegistry.INSTANCE.resolveModule("tutorial");
        assertNotNull(module);
//        System.out.println(module);

//        IConstant constant;
//        IType type;
//        constant = module.getConstant("boolFieldValue");
//        System.out.println(constant.getValue());
//        IValueDumper.INSTANCE.dump(constant.getValue());
//        assertFalse(constant.getValue().validate(null));
        
//        type = module.getType("StringArray");
//        System.out.println(type);
//        System.out.println(((PListTypeExt)type).getItemMeta());
    }
    
}
