package fr.noctu.pycdecompiler.pyobjects;

import fr.noctu.pycdecompiler.PycFile;
import fr.noctu.pycdecompiler.pyobjects.constants.InternedStringConstant;
import fr.noctu.pycdecompiler.pyobjects.constants.StringConstant;
import fr.noctu.pycdecompiler.pystructs.Assembly;
import fr.noctu.pycdecompiler.utils.decomp.UnsignedUtils;

import java.nio.ByteBuffer;

//type = 99 (0x63)
public class CodeObject {
    private PycFile holder;
    private byte type;

    private int argCount, localCount, stackSize, flags;
    private Assembly code;
    private TupleObject consts, names, varNames, freeVars, cellVars;
    private StringConstant fileName;
    private InternedStringConstant name;
    private int firstLineNo;
    private StringConstant tabText;

    public CodeObject(PycFile holder, byte type, ByteBuffer buffer) {
        this.type = type;
        this.holder = holder;
        decompile(buffer);
    }

    protected void decompile(ByteBuffer buffer) {
        this.argCount = buffer.getInt();
        this.localCount = buffer.getInt();
        this.stackSize = buffer.getInt();
        this.flags = buffer.getInt();
        this.code = new Assembly(holder, buffer);
        this.consts = new TupleObject(buffer.get(), buffer);
        this.names = new TupleObject(buffer.get(), buffer);
        this.varNames = new TupleObject(buffer.get(), buffer);
        this.freeVars = new TupleObject(buffer.get(), buffer);
        this.cellVars = new TupleObject(buffer.get(), buffer);
        this.fileName = new StringConstant(buffer.get(), buffer);
        this.name = new InternedStringConstant(buffer.get(), buffer);
        this.firstLineNo = buffer.getInt();
        this.tabText = new StringConstant(buffer.get(), buffer);
    }

    //GETTERS AND SETTERS//
    public long getArgCount(){
        return UnsignedUtils.intToUnsignedInt(argCount);
    }

    public long getLocalCount(){
        return UnsignedUtils.intToUnsignedInt(localCount);
    }

    public long getStackSize(){
        return UnsignedUtils.intToUnsignedInt(stackSize);
    }

    public long getFlags(){
        return UnsignedUtils.intToUnsignedInt(flags);
    }

    public Assembly getCode(){
        return code;
    }

    public TupleObject getConsts(){
        return consts;
    }

    public TupleObject getNames(){
        return names;
    }

    public TupleObject getVarNames(){
        return varNames;
    }

    public TupleObject getFreeVars() {
        return freeVars;
    }

    public TupleObject getCellVars() {
        return cellVars;
    }

    public StringConstant getFileName(){
        return fileName;
    }

    public InternedStringConstant getName(){
        return name;
    }

    public long getFirstLineNo() {
        return UnsignedUtils.intToUnsignedInt(firstLineNo);
    }

    public StringConstant getTabText(){
        return tabText;
    }
}
