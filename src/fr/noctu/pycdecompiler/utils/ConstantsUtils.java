package fr.noctu.pycdecompiler.utils;

import fr.noctu.pycdecompiler.PycFile;
import fr.noctu.pycdecompiler.pyobjects.PyObject;
import fr.noctu.pycdecompiler.pyobjects.constants.*;

public class ConstantsUtils {
    public static String getConstantValueAsString(PycFile holder, PyObject object){
        if(object instanceof BooleanConstant)
            return Boolean.toString(((BooleanConstant) object).getValue());
        else if(object instanceof FloatConstant)
            return Float.toString(((FloatConstant) object).getValue());
        else if(object instanceof IntConstant)
            return Integer.toString(((IntConstant) object).getValue());
        else if(object instanceof InternedStringConstant)
            return ((InternedStringConstant) object).getText();
        else if(object instanceof LongConstant)
            return Long.toString(((LongConstant) object).getValue());
        else if(object instanceof NoneConstant)
            return "none";
        else if(object instanceof StringConstant)
            return ((StringConstant) object).getText();
        else if(object instanceof StringRefConstant)
            return getStringOfStringRef(holder, (StringRefConstant) object);
        else
            return "Unknown constant type";
    }

    public static String getStringOfStringRef(PycFile holder, StringRefConstant stringRefConstant){
        return ((StringConstant)holder.getBody().getConsts().getObjects().get(stringRefConstant.getInternedListIndex())).getText();
    }
}
