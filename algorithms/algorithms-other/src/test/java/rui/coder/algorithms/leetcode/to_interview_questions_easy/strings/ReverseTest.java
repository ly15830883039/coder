package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseTest {

    private int source;
    private int expect;

    private Reverse reverse = new Reverse();

    @Test
    void case1() {
        source = 123;
        expect = 321;
    }

    @Test
    void case2() {
        source=-123;
        expect=-321;
    }

    @Test
    void case3() {
        source=120;
        expect=21;
    }

    @AfterEach
    void tearDown() {
        assertEquals(expect, reverse.reverse(source));
    }
}