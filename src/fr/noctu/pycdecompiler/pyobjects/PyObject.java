package fr.noctu.pycdecompiler.pyobjects;

import java.nio.ByteBuffer;

public class PyObject {
    private byte type;

    public PyObject(byte type, ByteBuffer buffer) {
        this.type = type;
        decompile(buffer);
    }

    protected void decompile(ByteBuffer buffer){}

    public byte getType() {
        return type;
    }
}
