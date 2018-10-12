package rui.coder.algorithms.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountSortTest {

    private CountSort countSort = new CountSort();


    private int[] nums;

    private int[] expect;


    @Test
    void case1() {
        nums = new int[]{4, 6, 5, 6, 4, 5, 6, 1, 4, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8};
        expect = new int[]{1, 1, 2, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 10};
    }

    @AfterEach
    void tearDown() {
        assertArrayEquals(expect, countSort.sort(nums));
    }
}