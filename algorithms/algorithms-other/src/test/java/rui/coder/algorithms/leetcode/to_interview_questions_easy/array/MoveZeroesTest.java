package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    private MoveZeroes moveZeroes=new MoveZeroes();

    int[] nums;

    @Test
    void testCase1() {
        nums=new int[]{0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0},nums);
    }
}