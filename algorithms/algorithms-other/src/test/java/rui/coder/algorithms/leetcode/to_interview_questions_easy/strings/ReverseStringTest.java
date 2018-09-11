package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseStringTest {

    private ReverseString reverseString = new ReverseString();


    private String source;
    private String expect;

    @Test
    void case1() {
        source = "hello";
        expect = "olleh";
    }

    @Test
    void case2() {
        source="A man, a plan, a canal: Panama";
        expect="amanaP :lanac a ,nalp a ,nam A";
    }

    @AfterEach
    void tearDown() {
        assertEquals(expect, reverseString.reverseString(source));
    }
}