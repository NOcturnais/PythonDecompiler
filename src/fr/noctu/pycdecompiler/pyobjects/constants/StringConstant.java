package fr.noctu.pycdecompiler.pyobjects.constants;

import fr.noctu.pycdecompiler.pyobjects.PyObject;
import fr.noctu.pycdecompiler.utils.decomp.BufferUtils;

import java.nio.ByteBuffer;

//type = 115 (0x73)
public class StringConstant extends PyObject {
    private int length;
    private String text;

    public StringConstant(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }

    @Override
    protected void decompile(ByteBuffer buffer) {
        this.length = buffer.getInt();
        this.text = new String(BufferUtils.readBytes(buffer, length));
    }

    //GETTERS AND SETTERS//
    public int getLength() {
        return length;
    }

    public String getText() {
        return text;
    }
}
