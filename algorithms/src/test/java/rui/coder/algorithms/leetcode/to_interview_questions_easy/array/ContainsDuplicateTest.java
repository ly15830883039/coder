package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    private ContainsDuplicate containsDuplicate=new ContainsDuplicate();

    @Test
    void faster() {
        int[] nums;

        nums=new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        assertFalse(containsDuplicate.faster(nums));
    }


}