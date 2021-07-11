package fr.noctu.pycdecompiler.pyobjects.constants;

import fr.noctu.pycdecompiler.pyobjects.PyObject;

import java.nio.ByteBuffer;

//true: 84 (0x54)
//false: 70 (0x46)
public class BooleanConstant extends PyObject {
    private boolean value;

    public BooleanConstant(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }

    @Override
    protected void decompile(ByteBuffer buffer) {
        if(getType() == 'T')
            value = true;
        else if(getType() == 'F')
            value = false;
    }

    //GETTERS AND SETTERS//
    public boolean getValue(){
        return value;
    }
}
