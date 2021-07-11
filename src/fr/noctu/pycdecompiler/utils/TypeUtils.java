package fr.noctu.pycdecompiler.utils;

public class TypeUtils {
    public static String getTypeFromByte(byte type){
        switch (type){
            case 0x54:
                return "BOOL_TRUE";
            case 0x46:
                return "BOOL_FALSE";
            case 0x66:
                return "FLOAT";
            case 0x69:
                return "INTEGER";
            case 0x74:
                return "INTERNED_STRING";
            case 0x6c:
                return "LONG";
            case 0x4e:
                return "NONE";
            case 0x73:
                return "STRING";
            case 0x52:
                return "STRING_REF";
            default:
                System.out.println("Unknown type: " + type + " !");
                return "NO";
        }
    }
}
