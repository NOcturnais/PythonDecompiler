package fr.noctu.pycdecompiler.utils;

public enum CoFlagEnum {
    CO_OPTIMIZED(0x0001),
    CO_NEWLOCALS(0x0002),
    CO_VARARGS(0x0004),
    CO_VARKEYWORDS(0x0008),
    CO_NESTED(0x0010),
    CO_GENERATOR(0x0020),
    CO_COROUTINE(0x0080),
    CO_ITERABLE_COROUTINE(0x0100),
    CO_ASYNC_GENERATOR(0x0200),
    CO_FUTURE_DIVISION(0x20000),
    CO_FUTURE_ABSOLUTE_IMPORT(0x40000),
    CO_FUTURE_WITH_STATEMENT(0x80000),
    CO_FUTURE_PRINT_FUNCTION(0x100000),
    CO_FUTURE_UNICODE_LITERALS(0x200000),
    CO_FUTURE_BARRY_AS_BDFL(0x400000),
    CO_FUTURE_GENERATOR_STOP(0x800000),
    CO_FUTURE_ANNOTATIONS(0x1000000),
    UNKNOWN_FLAG(0x0);

    private final long flagValue;
    CoFlagEnum(int version){
        this.flagValue = version;
    }

    public long getFlagValue(){
        return flagValue;
    }

    @Override
    public String toString() {
        return "Flag: " + name() + " | value: " + getFlagValue();
    }

    //STATICS//

    public static CoFlagEnum getFlagByValue(long flag){
        for (CoFlagEnum flagEnum : CoFlagEnum.values()){
            if(flagEnum.flagValue == flag)
                return flagEnum;
        }
        return CoFlagEnum.UNKNOWN_FLAG;
    }
}
