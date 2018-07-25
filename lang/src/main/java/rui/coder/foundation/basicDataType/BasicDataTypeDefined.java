package rui.coder.foundation.basicDataType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


@DisplayName("基本数据类型-定义")
class BasicDataTypeDefined {

    @DisplayName("int 类型")
    @Nested
    class IntType {
        @Test
        @DisplayName("长度限制为 4个（字节）byte，一个字节为8个bit（位）")
        void length() {
        }

        @Test
        @DisplayName("8进制")
        void int8() {
            @SuppressWarnings("OctalInteger")
            int j = 01;
            assertSame(1, j, "0为前置，表示此数值为8进制");
        }

        @Test
        @DisplayName("16进制")
        void int16() {
            int i = 0xffffffff;
            assertSame(-1, i, "0x 表示这个数值为16进制，" +
                    "首尾为符号位，即为1，负数！" +
                    "8个f，一个f表示 2的4次方，8个，表示2的32次方，即为标准的-1");
        }

        @Test
        @DisplayName("char 类型转化为 int 类型")
        void int_char() {
            int d = 'a';
            assertSame(97, d, "'a' 为一个char " +
                    "a 在ASCII中为97");
        }
    }

    @DisplayName("char 类型")
    @Nested
    class CharType {
        @Test
        @DisplayName("长度限制为 2byte  16bit")
        void length() {
        }

        @Test
        @DisplayName("\\u 为转义 , 即为 Unicode 编码；Unicode 范围为 “U+0000”到“U+10FFFF”（共1114112个码位）")
        void unicodeDesc() {
            char c = '\u0571';
            assertEquals('ձ', c);
        }
    }

    @DisplayName("byte 类型")
    @Nested
    class ByteType {

        @Test
        @DisplayName("长度限制为 1个byte ，从-128到127")
        void length() {
        }

        @Test
        @DisplayName("使用int 类型 给byte 赋值")
        void intToByte() {
            @SuppressWarnings("OctalInteger") byte b = 01;
            assertEquals(1, b);
        }
    }


    @DisplayName("long 类型")
    @Nested
    class LongType {
        @Test
        @DisplayName("长度限制为 8byte，即64bit")
        void length() {
        }

        @Test
        @DisplayName("位数为L 表示为一个long 类型的数据")
        void desc() {
            long l = 455555666666L;
            assertEquals(455555666666L, l);
        }
    }
}
