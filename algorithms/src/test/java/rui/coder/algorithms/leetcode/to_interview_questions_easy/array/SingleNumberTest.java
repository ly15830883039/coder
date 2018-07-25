package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class SingleNumberTest {

    private SingleNumber singleNumber = new SingleNumber();

    @Test
    void singleNumber() {
        int[] nums;
        nums = new int[]{2, 2, 1};
        assertSame(1, singleNumber.singleNumber(nums));

        nums = new int[]{4, 1, 2, 1, 2};
        assertSame(4, singleNumber.singleNumber(nums));
    }

    //异或 位运算
    @Test
    void xor() {
        // 0 0 --> 0
        System.out.println(0^0);
        // 1 -1 ---> 0
        System.out.println(1^1);
        // 0 -1  ---> 1
        System.out.println(0^1);
        // 0 -55 ---> 55
        System.out.println(0^55);
        // 1 --55  ---> 55=2^5+2^4+2^2+2^1+2^0 -->  00001  11010111  -> 11010110  -> 54
        System.out.println(1^55);
    }
}