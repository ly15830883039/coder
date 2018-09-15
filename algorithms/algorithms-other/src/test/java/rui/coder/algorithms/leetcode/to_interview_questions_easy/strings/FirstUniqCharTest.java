package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqCharTest {


    private FirstUniqChar firstUniqChar = new FirstUniqChar();

    private String source;
    private int expect;

    @Test
    void case1() {
        source = "leetcode";
        expect = 0;
    }

    @Test
    void case2() {
        source = "loveleetcode";
        expect = 2;
    }

    @Test
    void case3() {
        source = "中国";
        expect = 0;
    }

    @Test
    void case4() {
        source = "";
        expect = -1;
    }

    @Test
    void case5() {
        source="z";
        expect=0;
    }

    @Test
    void case6() {
        source="cc";
        expect=-1;
    }

    @Test
    void case7() {
        source="aadadaad";
        expect=-1;
    }

    @AfterEach
    void tearDown() {
        assertEquals(expect, firstUniqChar.firstUniqChar(source));
    }
}