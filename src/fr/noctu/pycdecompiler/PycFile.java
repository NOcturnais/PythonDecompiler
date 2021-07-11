package fr.noctu.pycdecompiler;

import fr.noctu.pycdecompiler.pyobjects.CodeObject;
import fr.noctu.pycdecompiler.utils.decomp.UnsignedUtils;
import fr.noctu.pycdecompiler.utils.VersionEnum;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.util.Date;

public class PycFile {
    private File file;
    private byte[] buf;
    private final ByteBuffer buffer;

    //Pyc file datas
    private short version;
    private short crlf; //equivalent to a line return (yeah idk why this shit is here)
    private int modificationTimeStamp;
    private CodeObject body;

    public PycFile(String path){
        this.file = new File(path);
        try {
            this.buf = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            System.err.println("Failed to read file !");
            e.printStackTrace();
        }
        this.buffer = ByteBuffer.wrap(buf).order(ByteOrder.LITTLE_ENDIAN);

        try {
            decompile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void decompile() throws IOException {
        version = buffer.getShort();
        crlf = buffer.getShort();
        modificationTimeStamp = buffer.getInt();
        body = new CodeObject(this, buffer.get(), buffer);
    }

    //GETTERS AND SETTERS//
    public VersionEnum getVersion(){
        return VersionEnum.getVersionByInt(UnsignedUtils.shortToUnsignedShort(version));
    }

    public int getCRLF(){
        return UnsignedUtils.shortToUnsignedShort(crlf);
    }

    public Date getLastModificationTime(){
        return new Date(UnsignedUtils.intToUnsignedInt(modificationTimeStamp)*1000);
    }

    public CodeObject getBody() {
        return body;
    }
}
