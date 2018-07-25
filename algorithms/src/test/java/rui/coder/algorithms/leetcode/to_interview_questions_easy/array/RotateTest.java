package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rui.coder.algorithms.leetcode.to_interview_questions_easy.Array;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class RotateTest {

    private Rotate rotate=new Rotate();


    private int[] ints;

    @Test
    void frontier() {
        ints=new int[]{1};
        rotate.rotate(ints,1);
        assertArrayEquals(new int[]{1},ints);

        ints=new int[]{1,2};
        rotate.rotate(ints,3);
        assertArrayEquals(new int[]{2,1},ints);

        ints=new int[]{1,2};
        rotate.rotate(ints,2);
        assertArrayEquals(new int[]{1,2},ints);

        ints=new int[]{1,2,3};
        rotate.rotate(ints,1);
        assertArrayEquals(new int[]{3,1,2},ints);
    }

    @Test
    void rotate() {
        ints=new int[]{1,2,3,4,5,6,7};
        rotate.rotate(ints,3);
        assertArrayEquals(new int[]{5,6,7,1,2,3,4},ints);

        ints=new int[]{1,2,3,4,5,6};
        rotate.rotate(ints,2);
        System.out.println(Arrays.toString(ints));
        assertArrayEquals(new int[]{5,6,1,2,3,4},ints);
    }

    @Test
    @DisplayName("优化")
    void optimize() {
        ints=new int[]{1,2,3,4,5,6,7};
        IntStream.rangeClosed(0,20)
                .forEach(value -> {
                    rotate.mostFast(ints, value);
                    System.out.println(value+"--->"+Arrays.toString(ints));
                    ints=new int[]{1,2,3,4,5,6,7};
                });

    }
}