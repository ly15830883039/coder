package rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型.a_答疑;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerOverflowTest {

    @Test
    void abs() {
        assertEquals(-2147483648,Math.abs(-2147483648));
        System.out.println("Math.abs 是取这个值的绝对值");
        System.out.println("因为最大值为2147483647，而绝对值为2147483648已经溢出，+1后变为最小值");
    }

    @Test
    void maxInteger() {
        int i= (int) (Math.pow(2,31)-2);
        System.out.println(i+" 这个是int 类型内的值");
        i= (int) (Math.pow(2,31)-1);
        System.out.println(i+" 临界");
        i= (int) (Math.pow(2,31));
        System.out.println(i+" 超过了，损失精度");
        i= (int) (Math.pow(2,31)+1);
        System.out.println(i+ "超过了，损失精度");
    }

    @Test
    void name() {
        System.out.println(Integer.toBinaryString(-1));
    }

    @Test
    @DisplayName("无符号右移：低位溢出，高位补0")
    void unsignedRightShift(){
        System.out.println(Integer.toBinaryString(-1));
        assertEquals(Integer.MAX_VALUE,-1>>>1);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(-1>>>31);
    }
}