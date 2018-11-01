package rui.coder.algorithms.interview.alibaba;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RemoveDuplicateTest {

    private String str;
    private String result;

    private RemoveDuplicate removeDuplicate = new RemoveDuplicate();


    @Test
    void case1() {
        str = "";
        result = "";
    }

    @Test
    void case2() {
        str = "s";
        result = "s";
    }


    @Test
    void case3() {
        str = "sb";
        result = "sb";
    }

    @Test
    @DisplayName("最后一位特殊需要消除")
    void case4() {
        str = "asbbs";
        result = "a";
    }

    @Test
    void case5() {
        str = "sbbs";
        result = "";
    }

    @Test
    void case6() {
        str = "bsaasb";
        result = "";
    }

    @Test
    void case7() {
        str = "sssb";
        result = "b";
    }

    @Test
    void case8() {
        str = "sbbbsssbccdds";
        result = "bs";
    }

    @Test
    void case9() {
        str="ssb";
        result="b";
    }

    @Test
    void case10() {
        str="ssbbss";
        result="";
    }

    @AfterEach
    void tearDown() {
        assertEquals(result, removeDuplicate.alg(str));
        assertEquals(result, removeDuplicate.alg2(str));

    }
}