package fr.noctu.pycdecompiler.utils.decomp;

public class UnsignedUtils {
    public static int byteToUnsignedByte(byte value){
        return value & 0xFF;
    }

    public static int shortToUnsignedShort(short value){
        return value & 0xFFFF;
    }

    public static long intToUnsignedInt(int value){
        return value & 0xFFFFFFFFL;
    }
}