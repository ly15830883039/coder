package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
class IsValidSudoku {


    boolean isValidSudoku(char[][] board) {

        for (char[] chars : board) {
            if (isSame(chars)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            char[] lineChars = toLine(board, i);
            if (isSame(lineChars)) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[] moduleChars = toModule(board, i, j);
                if (isSame(moduleChars)) {
                    return false;
                }

            }
        }
        return true;
    }


    boolean isValidSudoku2(char[][] board) {
        int[][] signs = new int[3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int n = 1 << (board[i][j] - '1');
                int cubeIndex = i / 3 * 3 + j / 3;
                if ((signs[0][i] & n) != 0 || (signs[1][j] & n) != 0 || (signs[2][cubeIndex] & n) != 0)
                    return false;
                signs[0][i] |= n;
                signs[1][j] |= n;
                signs[2][cubeIndex] |= n;
            }
        }
        return true;
    }

    private int[] toIntArrays(char[] chars) {
        int[] ints = new int[9];
        int i = 0;
        for (char aChar : chars) {
            if (aChar != '.') {
                ints[i++] = aChar;
            }
        }
        return ints;
    }

    private char[] toLine(char[][] chars, int lineNum) {
        char[] line = new char[9];
        int i = 0;
        for (char[] aChar : chars) {
            line[i++] = aChar[lineNum];
        }
        return line;
    }

    private char[] toModule(char[][] chars, int rowIndex, int lineIndex) {
        char[] moduleChars = new char[9];
        int i = 0;

        int rowStart = rowIndex * 3;
        int lineStart = lineIndex * 3;

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                moduleChars[i++] = chars[rowStart + j][lineStart + k];
            }
        }
        return moduleChars;

    }

    boolean isSame(char[] chars) {
        int[] ints = toIntArrays(chars);
        return containsDuplicate(ints);
    }

    private boolean containsDuplicate(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //j 从0 开始
            int j = i - 1;
            //从i开始的索引取值
            int k = nums[j + 1];
            if(k==0){
                return false;
            }
            // 这里进行了插入排序
            while (j > -1 && nums[j] > k) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = k;
            if (j > -1) {
                if (nums[j] == nums[j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
