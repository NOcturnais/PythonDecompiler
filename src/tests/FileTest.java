package tests;

import fr.noctu.pycdecompiler.PycFile;
import fr.noctu.pycdecompiler.pyobjects.OpArgs;
import fr.noctu.pycdecompiler.pyobjects.PyObject;
import fr.noctu.pycdecompiler.pyobjects.constants.InternedStringConstant;
import fr.noctu.pycdecompiler.utils.TypeUtils;

import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) {
        PycFile file = new PycFile("/root/Documents/testprog.pyc");
        System.out.println("--BASIC FILE INFOS--");
        System.out.println(file.getVersion());
        System.out.println(file.getCRLF());
        System.out.println(file.getLastModificationTime());

        System.out.println("--BYTECODE--");
        for(OpArgs opcode : file.getBody().getCode().getCode()){
            System.out.println(opcode);
        }

        System.out.println("--CONSTANT TYPES--");
        for(byte b : file.getBody().getConsts().getTypes())
            System.out.println(TypeUtils.getTypeFromByte(b));

        System.out.println("--NAMES--");
        for (PyObject object : file.getBody().getNames().getObjects()) {
            if(object instanceof InternedStringConstant)
                System.out.println(((InternedStringConstant) object).getText());
        }

        System.out.println("--OTHER INFOS--");
        System.out.println(file.getBody().getFileName().getText());
        System.out.println(file.getBody().getName().getText());
    }
}
