package fr.noctu.pycdecompiler.pyobjects.constants;

import fr.noctu.pycdecompiler.pyobjects.PyObject;

import java.nio.ByteBuffer;

//type = 1O5 (0x69)
public class IntConstant extends PyObject {
    private int value;

    public IntConstant(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }

    @Override
    protected void decompile(ByteBuffer buffer) {
        this.value = buffer.getInt();
    }

    //GETTERS AND SETTERS//
    public int getValue(){
        return value;
    }
}
