package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RotateArraysTest {


    private RotateArrays rotateArrays=new RotateArrays();

    private String source;
    private String target;
    @Test
    void case1() {

         source = "  [1,2,3],\n" +
                "  [4,5,6],\n" +
                "  [7,8,9]";

         target="  [7,4,1],\n" +
                "  [8,5,2],\n" +
                "  [9,6,3]";
    }

    @Test
    void case2() {
        source=" [ 5, 1, 9,11],\n" +
                "  [ 2, 4, 8,10],\n" +
                "  [13, 3, 6, 7],\n" +
                "  [15,14,12,16]";

        target="  [15,13, 2, 5],\n" +
                "  [14, 3, 4, 1],\n" +
                "  [12, 6, 8, 9],\n" +
                "  [16, 7,10,11]";
    }

    @AfterEach
    void tearDown() {
        int[][] matrix =parseArrays(source);
        rotateArrays.rotate(matrix);
        assertEquals(target.replace(" ",""),toStrings(matrix));
    }

    private int[][] parseArrays(String source){
        source=source.replace(" ","");
        source=source.replace("[","");
        source=source.replace("]","");

        String[] ones=source.split("\n");

        int lineNum=ones.length;

        int[][] ints=new int[lineNum][lineNum];

        for (int i = 0; i < lineNum; i++) {
            String  one = ones[i];

            String[] numbers=one.split(",");

            for (int j = 0; j <lineNum; j++) {
                ints[i][j]=Integer.parseInt(numbers[j]);
            }
        }
        return ints;
    }

    private String  toStrings(int[][] ints){

        int length=ints.length;

        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(Arrays.toString(ints[i]));

            if(i<length-1){
                     builder.append(",\n");
            }
        }
        return builder.toString().replace(" ","");
    }


}