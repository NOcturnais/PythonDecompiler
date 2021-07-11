package fr.noctu.pycdecompiler.utils.decomp;

import java.nio.ByteBuffer;

public class BufferUtils {
    public static byte[] readBytes(ByteBuffer buffer, int length){
        byte[] buf = new byte[length];
        for(int i = 0; i<length; i++){
            buf[i] = buffer.get();
        }
        return buf;
    }
}
