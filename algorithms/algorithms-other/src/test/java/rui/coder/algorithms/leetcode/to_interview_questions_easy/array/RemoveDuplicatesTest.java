package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * 我的思路是将相同的移除，剩下的就是不重复的。
 * 而速度最快的那个思路是 将相同的用不同的替换掉，就可以完成。人家思路巧妙啊。
 */
class RemoveDuplicatesTest {


    private RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    @Test
    @DisplayName("边界")
    void frontier() {
        assertSame(0, removeDuplicates.get_deleteRepeat_afterElementCount(null));
        assertSame(0, removeDuplicates.get_deleteRepeat_afterElementCount(new int[]{}));
        assertSame(1, removeDuplicates.get_deleteRepeat_afterElementCount(new int[]{0}));
    }

    @Test
    @DisplayName("常规")
    void general() {
        int[] nums = new int[]{1, 2};
        assertSame(2, removeDuplicates.get_deleteRepeat_afterElementCount(nums));
        assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, 2));

        nums = new int[]{1, 1};
        assertSame(1, removeDuplicates.get_deleteRepeat_afterElementCount(nums));
        assertArrayEquals(new int[]{1}, Arrays.copyOf(nums, 1));

        nums = new int[]{1, 1, 2};
        assertSame(2, removeDuplicates.get_deleteRepeat_afterElementCount(nums));
        assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, 2));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertSame(5, removeDuplicates.get_deleteRepeat_afterElementCount(nums));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, Arrays.copyOf(nums, 5));
    }

    @Test
    @DisplayName("常规")
    void others() {
        int[] nums;
        nums = new int[]{1, 2};
        assertSame(2, removeDuplicates.removeDuplicates(nums));
        assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, 2));

        nums = new int[]{1, 1};
        assertSame(1, removeDuplicates.removeDuplicates(nums));
        assertArrayEquals(new int[]{1}, Arrays.copyOf(nums, 1));

        nums = new int[]{1, 1, 2};
        assertSame(2, removeDuplicates.removeDuplicates(nums));
        assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, 2));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertSame(5, removeDuplicates.removeDuplicates(nums));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, Arrays.copyOf(nums, 5));
    }

}