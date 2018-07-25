package rui.coder.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {
    private InsertSort insertSort=new InsertSort();

    @Test
    void sort() {
        int[] nums;
        nums=new int[]{ 3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        insertSort.sort(nums);
        assertArrayEquals(new int[]{2,3,4,5,15,19,26,27,36,38,44,46,47,48,50},nums);
    }
}