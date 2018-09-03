package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private TwoSum twoSum = new TwoSum();

    private int[] nums;
    private int target;

    private int[] result;

    @Test
    void case1() {
        nums = new int[]{2, 7, 11, 15};
        target = 9;
        result = new int[]{0, 1};
    }

    @Test
    void case2() {
        nums = new int[]{-1, -2, -3, -4, -5};
        target = -8;
        result = new int[]{2, 4};
    }

    @Test
    void case3() {
        nums = new int[]{3, 2, 4};
        target = 6;
        result = new int[]{1, 2};
    }

    @Test
    void case4() {
        nums = new int[]{3, 2, 3};
        target = 6;
        result = new int[]{0, 2};
    }

    @Test
    void case5() {
        nums = new int[]{3, 3};
        target = 6;
        result = new int[]{0, 1};
    }

    @AfterEach
    void tearDown() {
        assertArrayEquals(result, twoSum.twoSum(nums, target));
        assertArrayEquals(result, twoSum.twoSum2(nums, target));
    }

    /*
    [230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789]
542
     */
}