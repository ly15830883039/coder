package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectTest {

    private Intersect intersect=new Intersect();
    @Test
    void intersect() {
        int[] nums1;
        int[] nums2;

        nums1 = new int[]{1,2,2,1};
        nums2 = new int[]{2,2};
        assertArrayEquals(new int[]{2,2},intersect.intersect(nums1,nums2));

        nums1 = new int[]{1};
        nums2 = new int[]{1};
        assertArrayEquals(new int[]{1},intersect.intersect(nums1,nums2));

        nums1 = new int[]{1,2};
        nums2 = new int[]{1,1};
        assertArrayEquals(new int[]{1},intersect.intersect(nums1,nums2));

        nums1 = new int[]{3,1,2};
        nums2 = new int[]{1,1};
        assertArrayEquals(new int[]{1},intersect.intersect(nums1,nums2));

    }
}