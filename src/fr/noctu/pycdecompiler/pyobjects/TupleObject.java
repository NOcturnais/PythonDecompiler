package fr.noctu.pycdecompiler.pyobjects;

import fr.noctu.pycdecompiler.pyobjects.constants.*;
import fr.noctu.pycdecompiler.utils.decomp.UnsignedUtils;

import java.nio.ByteBuffer;
import java.util.ArrayList;

//type = 40
public class TupleObject extends PyObject {
    private int count;
    private ArrayList<Byte> types;
    private ArrayList<PyObject> objects;

    public TupleObject(byte type, ByteBuffer buffer) {
        super(type, buffer);
    }

    @Override
    protected void decompile(ByteBuffer buffer){
        this.count = buffer.getInt();

        this.types = new ArrayList<>();
        this.objects = new ArrayList<>();
        for(int i = 0; i<count; i++){
            byte type = buffer.get();
            types.add(type);
            switch (type){
                case 0x69:
                    objects.add(new IntConstant(type, buffer));
                    break;
                case 0x73:
                    objects.add(new StringConstant(type, buffer));
                    break;
                case 0x74:
                    objects.add(new InternedStringConstant(type, buffer));
                    break;
                case 0x54:
                case 0x46:
                    objects.add(new BooleanConstant(type, buffer));
                    break;
                case 0x6c:
                    objects.add(new LongConstant(type, buffer));
                    break;
                case 0x4e:
                    objects.add(new NoneConstant(type, buffer));
                    break;
                case 0x52:
                    objects.add(new StringRefConstant(type, buffer));
                    break;
                default:
                    System.out.println("Unknown constant: " + type + " ! (stopping)");
                    return;
            }
        }
    }

    //GETTERS AND SETTERS//
    public long getCount(){
        return UnsignedUtils.intToUnsignedInt(count);
    }

    public ArrayList<PyObject> getObjects(){
        return objects;
    }

    public ArrayList<Byte> getTypes(){
        return types;
    }
}
