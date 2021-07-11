package fr.noctu.pycdecompiler.pyobjects.constants;

import fr.noctu.pycdecompiler.pyobjects.PyObject;

import java.nio.ByteBuffer;

//type: 82(0x52)
public class StringRefConstant extends PyObject {
    private int internedListIndex;

    public StringRefConstant(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }

    @Override
    protected void decompile(ByteBuffer buffer) {
        this.internedListIndex = buffer.getInt();
    }

    //GETTERS AND SETTERS//

    public int getInternedListIndex() {
        return internedListIndex;
    }
}
