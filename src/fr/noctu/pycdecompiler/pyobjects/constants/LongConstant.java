package fr.noctu.pycdecompiler.pyobjects.constants;

import fr.noctu.pycdecompiler.pyobjects.PyObject;

import java.nio.ByteBuffer;

//type: 108(0x6c)
public class LongConstant extends PyObject {
    private long value;

    public LongConstant(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }

    @Override
    protected void decompile(ByteBuffer buffer) {
        this.value = buffer.getLong();
    }

    //GETTERS AND SETTERS//
    public long getValue() {
        return value;
    }
}
