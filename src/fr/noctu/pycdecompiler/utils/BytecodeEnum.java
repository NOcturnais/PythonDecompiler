package fr.noctu.pycdecompiler.utils;

public enum BytecodeEnum {
    STOP_CODE(0),
    POP_TOP(1),
    ROT_TWO(2),
    ROT_THREE(3),
    DUP_TOP(4),
    ROT_FOUR(5),
    NOP(9),
    UNARY_POSITIVE(10),
    UNARY_NEGATIVE(11),
    UNARY_NOT(12),
    UNARY_CONVERT(13),
    UNARY_INVERT(15),
    BINARY_POWER(19),
    BINARY_MULTIPLY(20),
    BINARY_DIVIDE(21),
    BINARY_MODULO(22),
    BINARY_ADD(23),
    BINARY_SUBTRACT(24),
    BINARY_SUBSCR(25),
    BINARY_FLOOR_DIVIDE(26),
    BINARY_TRUE_DIVIDE(27),
    INPLACE_FLOOR_DIVIDE(28),
    INPLACE_TRUE_DIVIDE(29),
    GET_LEN(30),
    MATCH_MAPPING(31),
    MATCH_SEQUENCE(32),
    MATCH_KEYS(33),
    COPY_DICT_WITHOUT_KEYS(34),
    PUSH_EXC_INFO(35),
    POP_EXCEPT_AND_RERAISE(37),
    WITH_EXCEPT_START(49),
    GET_AITER(50),
    GET_ANEXT(51),
    BEFORE_ASYNC_WITH(52),
    BEFORE_WITH(53),
    END_ASYNC_FOR(54),
    INPLACE_ADD(55),
    INPLACE_SUBTRACT(56),
    INPLACE_MULTIPLY(57),
    INPLACE_DIVIDE(58),
    INPLACE_MODULO(59),
    STORE_SUBSCR(60),
    DELETE_SUBSCR(61),
    BINARY_LSHIFT(62),
    BINARY_RSHIFT(63),
    BINARY_AND(64),
    BINARY_XOR(65),
    BINARY_OR(66),
    INPLACE_POWER(67),
    GET_ITER(68),
    GET_YIELD_FROM_ITER(69),
    PRINT_EXPR(70),
    LOAD_BUILD_CLASS(71),
    YIELD_FROM(72),
    GET_AWAITABLE(73),
    LOAD_ASSERTION_ERROR(74),
    INPLACE_LSHIFT(75),
    INPLACE_RSHIFT(76),
    INPLACE_AND(77),
    INPLACE_XOR(78),
    INPLACE_OR(79),
    LIST_TO_TUPLE(82),
    RETURN_VALUE(83),
    IMPORT_STAR(84),
    SETUP_ANNOTATIONS(85),
    YIELD_VALUE(86),
    POP_BLOCK(87),
    END_FINALLY(88),
    POP_EXCEPT(89),
    STORE_NAME(90, true), //index in names list
    DELETE_NAME(91, true), //index in names list
    UNPACK_SEQUENCE(92, true), //number of tuple items
    FOR_ITER(93, true),
    LIST_APPEND(94, true),
    STORE_ATTR(95, true), //index in names list
    DELETE_ATTR(96, true), //index in names list
    STORE_GLOBAL(97, true), //index in names list
    DELETE_GLOBAL(98, true), //index in names list
    DUP_TOPX(99, true), //number of items to duplicate
    LOAD_CONST(100, true), //index in consts list
    LOAD_NAME(101, true), //index in names list
    BUILD_TUPLE(102, true), //number of items in tuple
    BUILD_LIST(103, true), //number of items in list
    BUILD_SET(104, true), //number of items in set
    BUILD_MAP(105, true), //number of items in map
    LOAD_ATTR(106, true), //index in names list
    COMPARE_OP(107, true), //comparison operator
    IMPORT_NAME(108, true), //index in name list
    IMPORT_FROM(109, true), //index in name list
    JUMP_FORWARD(110, true), //number of bytes to skip
    JUMP_IL_FALSE_OR_POP(111, true), //target byte offset (from the start of bytecode)
    JUMP_IF_TRUE_OR_POP(112, true), //target byte offset (from the start of bytecode)
    JUMP_ABSOLUTE(113, true), //target byte offset (from the start of bytecode)
    POP_JUMP_IF_FALSE(114, true), //target byte offset (from the start of bytecode)
    POP_JUMP_IF_TRUE(115, true), //target byte offset (from the start of bytecode)
    LOAD_GLOBAL(116, true), //index in names list
    CONTINUE_LOOP(119, true), //target address
    SETUP_LOOP(120, true), //distance to target address
    SETUP_EXCEPT(121, true), //distance to target address
    SETUP_FINALLY(122, true), //distance to target address
    LOAD_FAST(124, true), //local variable number
    STORE_FAST(125, true), //local variable number
    DELETE_FAST(126, true), //local variable number
    RAISE_VARARGS(130, true), //number of raise arguments(1, 2 or 3)
    CALL_FUNCTION(131, true), //args + (kwarg << 8)
    MAKE_FUNCTION(132, true), //number of args with default value
    BUILD_SLICE(133, true), //number of items
    MAKE_CLOSURE(134),
    LOAD_CLOSURE(135),
    LOAD_DEREF(136),
    STORE_DEREF(137),
    CALL_FUNCTION_VAR(140, true), //args + (kwarg << 8)
    CALL_FUNCTION_KW(141, true), //args + (kwarg << 8)
    CALL_FUNCTION_VAR_KW(142, true), //args + (kwarg << 8)
    SETUP_WITH(143),
    EXTENDED_ARGS(145),
    SET_ADD(146),
    MAP_ADD(147);

    private final int value;
    private final boolean hasArg;
    BytecodeEnum(int value){
        this.value = value;
        this.hasArg = false;
    }

    BytecodeEnum(int value, boolean hasArg){
        this.value = value;
        this.hasArg = hasArg;
    }

    public int getValue() {
        return value;
    }

    public boolean hasArg() {
        return hasArg;
    }

    //OTHERS//
    public static BytecodeEnum getBytecodeByValue(int value){
        for(BytecodeEnum bc : BytecodeEnum.values()){
            if(bc.getValue() == value)
                return bc;
        }
        return null;
    }
}
