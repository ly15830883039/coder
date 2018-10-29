package rui.coder.algorithms.interview.alibaba;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RemoveDuplicateTest {

    private String str;
    private String result;

    private RemoveDuplicate removeDuplicate = new RemoveDuplicate();

    @Test
    void case1() {
        str = "sbbbsssbccdds";
        result = "bs";
    }

    @AfterEach
    void tearDown() {
        assertEquals(result, removeDuplicate.alg(str));

    }
}