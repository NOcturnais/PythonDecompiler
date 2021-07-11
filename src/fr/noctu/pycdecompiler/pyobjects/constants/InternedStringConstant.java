package fr.noctu.pycdecompiler.pyobjects.constants;

import java.nio.ByteBuffer;

//type: 116(0x74)
public class InternedStringConstant extends StringConstant{
    public InternedStringConstant(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }
}
