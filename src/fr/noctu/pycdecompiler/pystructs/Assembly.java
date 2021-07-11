package fr.noctu.pycdecompiler.pystructs;

import fr.noctu.pycdecompiler.PycFile;
import fr.noctu.pycdecompiler.pyobjects.OpArgs;
import fr.noctu.pycdecompiler.utils.BytecodeEnum;
import fr.noctu.pycdecompiler.utils.decomp.BufferUtils;
import fr.noctu.pycdecompiler.utils.decomp.UnsignedUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

public class Assembly {
    private PycFile holder;
    private ByteBuffer buffer;

    private byte stringType;
    private int length;
    private byte[] codeBuffer;
    private ArrayList<OpArgs> code;

    public Assembly(PycFile holder, ByteBuffer buffer){
        this.holder = holder;
        this.buffer = buffer;
        decompile(buffer);
    }

    private void decompile(ByteBuffer buffer){
        this.stringType = buffer.get();
        this.length = buffer.getInt();
        this.codeBuffer = BufferUtils.readBytes(buffer, length);
        this.code = new ArrayList<>();
        parseCode();
    }

    private void parseCode(){
        for(int i = 0; i<codeBuffer.length; i++){
            BytecodeEnum bc = BytecodeEnum.getBytecodeByValue(UnsignedUtils.byteToUnsignedByte(codeBuffer[i]));
            short arg = -1;
            if(bc.hasArg()) {
                byte[] argBuf = {codeBuffer[i+1], codeBuffer[i+2]};
                arg = ByteBuffer.wrap(argBuf).order(ByteOrder.LITTLE_ENDIAN).getShort();
                i+=2;
            }
            code.add(new OpArgs(holder, bc, arg));
        }
    }

    //GETTERS AND SETTERS//

    public byte getStringType() {
        return stringType;
    }

    public long getLength(){
        return UnsignedUtils.intToUnsignedInt(length);
    }

    public byte[] getCodeBuffer() {
        return codeBuffer;
    }

    public ArrayList<OpArgs> getCode() {
        return code;
    }
}
