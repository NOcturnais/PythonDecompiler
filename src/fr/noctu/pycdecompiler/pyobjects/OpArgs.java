package fr.noctu.pycdecompiler.pyobjects;

import fr.noctu.pycdecompiler.PycFile;
import fr.noctu.pycdecompiler.pyobjects.constants.InternedStringConstant;
import fr.noctu.pycdecompiler.utils.BytecodeEnum;
import fr.noctu.pycdecompiler.utils.ConstantsUtils;

public class OpArgs {
    private PycFile holder;
    private BytecodeEnum bytecode;
    private short arg;

    public OpArgs(PycFile holder, BytecodeEnum bytecode, short arg) {
        this.holder = holder;
        this.bytecode = bytecode;
        this.arg = arg;
    }

    public BytecodeEnum getBytecode() {
        return bytecode;
    }

    public short getArg() {
        return arg;
    }

    //OTHERS//

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(bytecode.name());

        TupleObject names = holder.getBody().getNames();
        TupleObject consts = holder.getBody().getConsts();
        if(bytecode.hasArg()){
            switch (bytecode){
                case STORE_ATTR:
                case DELETE_ATTR:
                case STORE_GLOBAL:
                case DELETE_GLOBAL:
                case DELETE_NAME:
                case LOAD_NAME:
                case LOAD_ATTR:
                case LOAD_GLOBAL:
                case IMPORT_NAME:
                case IMPORT_FROM:
                case STORE_NAME:
                    stringBuilder.append(" ").append(ConstantsUtils.getConstantValueAsString(holder, names.getObjects().get(getArg()))).append(" (").append(getArg()).append(")");
                    break;
                case LOAD_CONST:
                    stringBuilder.append(" ").append(ConstantsUtils.getConstantValueAsString(holder, consts.getObjects().get(getArg()))).append(" (").append(getArg()).append(")");
                    break;
                case DUP_TOPX:
                case BUILD_TUPLE:
                case BUILD_SET:
                case BUILD_LIST:
                case BUILD_MAP:
                case COMPARE_OP:
                case JUMP_FORWARD:
                case JUMP_IF_TRUE_OR_POP:
                case JUMP_IL_FALSE_OR_POP:
                case JUMP_ABSOLUTE:
                case POP_JUMP_IF_FALSE:
                case POP_JUMP_IF_TRUE:
                case UNPACK_SEQUENCE:
                case CONTINUE_LOOP:
                case SETUP_LOOP:
                case SETUP_EXCEPT:
                case SETUP_FINALLY:
                case LOAD_FAST:
                case STORE_FAST:
                case DELETE_FAST:
                case RAISE_VARARGS:
                case CALL_FUNCTION:
                case MAKE_FUNCTION:
                case BUILD_SLICE:
                case CALL_FUNCTION_KW:
                case CALL_FUNCTION_VAR:
                case CALL_FUNCTION_VAR_KW:
                    stringBuilder.append(" ").append(getArg());
            }
        }
        return stringBuilder.toString();
    }
}
