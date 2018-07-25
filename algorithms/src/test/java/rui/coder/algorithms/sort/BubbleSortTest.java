package rui.coder.algorithms.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private BubbleSort bubbleSort=new BubbleSort();

    @Test
    void sort() {
        int [] arr= IntStream
                .of(0,2,6,3,9,3,5,8,4,7)
                .toArray();
        arr=bubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}