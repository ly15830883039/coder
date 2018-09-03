package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class IsValidSudokuTest {
    private IsValidSudoku isValidSudoku = new IsValidSudoku();

    private boolean flag;
    private String source;


    @Nested
    class Case {
        @Test
        void case1() {
            source = "[\n" +
                    "  [\"5\",\"3\",\".\",\".\",\"5\",\".\",\".\",\".\",\".\"],\n" +
                    "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                    "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                    "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                    "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                    "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                    "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                    "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                    "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                    "]";
            flag = true;
        }

        @AfterEach
        void tearDown() {
//            assertEquals(flag, isValidSudoku.isValidSudoku(toBoard(source)));
            assertEquals(flag, isValidSudoku.isValidSudoku2(toBoard(source)));
        }
    }

    private char[][] toBoard(String source) {
        char[][] board = new char[9][9];
        source = source.replace(" ", "");
        source = source.replace(",", "");
        source = source.replace("[", "");
        source = source.replace("]", "");
        source = source.replace("\"", "");
        String[] sources = source.split("\n");


        int index = 0;
        while (index < 9) {
            String temp = sources[index + 1].replace(",", "");

            board[index++] = temp.toCharArray();
        }

        return board;
    }


    @Test
    void isSame() {
        char[] chars = new char[]{'5', '.', '2', '4', '5', '1', '3', '7', '9'};
//        assertFalse(isValidSudoku.isSame(chars));

        assertFalse(isValidSudoku.isSame(new char[]{'.','.'}));
    }


    @Test
    void name() {
        System.out.println(0&16);
        System.out.println(16&4);
        System.out.println(20&16);
    }
}