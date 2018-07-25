package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    private PlusOne plusOne=new PlusOne();

    @Test
    void plusOne() {
        int[] digits;

        digits=new int[]{1,2,3};
        assertArrayEquals(new int[]{1,2,4}, plusOne.plusOne(digits));

        digits=new int[]{4,3,2,1};
        assertArrayEquals(new int[]{4,3,2,2}, plusOne.plusOne(digits));

        digits=new int[]{9};
        assertArrayEquals(new int[]{1,0}, plusOne.plusOne(digits));

        digits=new int[]{0};
        assertArrayEquals(new int[]{1}, plusOne.plusOne(digits));

        digits=new int[]{9,9};
        assertArrayEquals(new int[]{1,0,0}, plusOne.plusOne(digits));

        digits=new int[]{2,4,9,3,9};
        assertArrayEquals(new int[]{2,4,9,4,0}, plusOne.plusOne(digits));


    }
}