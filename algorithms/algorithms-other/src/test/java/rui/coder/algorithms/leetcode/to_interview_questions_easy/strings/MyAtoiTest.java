package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyAtoiTest {

    private String str;
    private int expect;
    private MyAtoi myAtoi = new MyAtoi();

    @Test
    void case1() {
        str = "42";
        expect = 42;
    }

    @Test
    void case2() {
        str = "   -42";
        expect = -42;
    }


    @Test
    void case3() {
        str = "4193 with words";
        expect = 4193;
    }


    @Test
    void case4() {
        str = "words and 987";
        expect = 0;
    }

    @Test
    void case5() {
        str = "-91283472332";
        expect = -2147483648;
    }

    @Test
    void case6() {
        str = "-";
        expect = 0;
    }

    @Test
    void case7() {
        str = "+1";
        expect = 1;
    }

    @Test
    void case8() {
        str="3.14159";
        expect=3;
    }

    @Test
    void case9() {
        str="+";
        expect=0;
    }

    @Test
    void case10() {
        str="2147483648";
        expect=2147483647;
    }

    @AfterEach
    void tearDown() {
        assertEquals(expect, myAtoi.myAtoi(str));
    }
}