package fr.noctu.pycdecompiler.pyobjects.constants;

import fr.noctu.pycdecompiler.pyobjects.PyObject;

import java.nio.ByteBuffer;

//type: 78(0x4e)
public class NoneConstant extends PyObject {
    public NoneConstant(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }
}
