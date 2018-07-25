package rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型.BinarySearch;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("二分查找算法")
class BinarySearchTest {

    private int[] a;

    private int length = 1000;

    private BinarySearch binarySearch = new BinarySearch();

    @BeforeEach
    void setUp() {
        a = new Random().ints().limit(length).sorted().toArray();
    }

    @Test
    @DisplayName("查找key所在索引地址")
    void rank() {
        int randomIndex = (int) (Math.random() * length);
        int key = a[randomIndex];
        assertEquals(randomIndex, binarySearch.rank(key, a));
    }

    @Test
    @DisplayName("批量测试")
    void moreTest() {
        for (int i = 0; i < 1000; i++) {
            rank();
        }
    }
}

