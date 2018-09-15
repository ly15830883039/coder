package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class IsAnagramTest {

    private String s;
    private String t;

    private boolean result;
    private IsAnagram isAnagram = new IsAnagram();

    @Test
    void case1() {
        s = "anagram";
        t = "nagaram";
        result=true;
    }

    @Test
    void case2() {
        s = "rat";
        t = "car";
        result=false;
    }


    /**
     * 出现了问题，这个问题是源于 aa这个才执行 &操作到最后，必然还是&；
     */
    @Test
    void case3() {
        s="aa";
        t="a";
        result=false;
    }

    @AfterEach
    void tearDown() {
        assertSame(result, isAnagram.isAnagram(s, t));
    }
}