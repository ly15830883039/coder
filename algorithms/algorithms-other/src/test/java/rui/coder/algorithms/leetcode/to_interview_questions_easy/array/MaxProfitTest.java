package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

    private MaxProfit profit =new MaxProfit();

    @Test
    @DisplayName("边界")
    void frontier() {
        assertSame(0, profit.maxProfit(null));
        assertSame(0, profit.maxProfit(new int[]{}));
        assertSame(0, profit.maxProfit(new int[]{1}));
    }

    @Test
    void maxProfit(){
        int[] nums;

        nums=new int[]{2,4,1};
        assertSame(2,profit.maxProfit(nums));

        nums=new int[]{7,1,5,3,6,4};
        assertSame(7,profit.maxProfit(nums));

        nums=new int[]{1,2,3,4,5};
        assertSame(4,profit.maxProfit(nums));

        nums=new int[]{7,6,4,3,1};
        assertSame(0,profit.maxProfit(nums));

        nums=new int[]{1,2,4,2,5,7,2,4,9,0};
        assertSame(15,profit.maxProfit(nums));
    }

    @Test
    void maxProfit1(){
        int[] nums;

        nums=new int[]{2,4,1};
        assertSame(2,profit.maxProfit1(nums));

        nums=new int[]{7,1,5,3,6,4};
        assertSame(7,profit.maxProfit1(nums));

        nums=new int[]{1,2,3,4,5};
        assertSame(4,profit.maxProfit1(nums));

        nums=new int[]{7,6,4,3,1};
        assertSame(0,profit.maxProfit1(nums));

        nums=new int[]{1,2,4,2,5,7,2,4,9,0};
        assertSame(15,profit.maxProfit1(nums));
    }
}