package fr.noctu.pycdecompiler.pyobjects.constants;

import fr.noctu.pycdecompiler.pyobjects.PyObject;

import java.nio.ByteBuffer;

//102 (0x66)
public class FloatConstant extends PyObject {
    private float value;

    public FloatConstant(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }

    @Override
    protected void decompile(ByteBuffer buffer) {
        this.value = buffer.getFloat();
    }

    //GETTERS AND SETTERS//
    public float getValue(){
        return value;
    }
}
