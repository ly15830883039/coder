package rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型.b_练习;

/**
 * 打印的算法实现
 */
public class Practice {

    public String printBooleanArray(boolean[][] booleans) {
        int length = booleans.length;
        int large = booleans[0].length;

        StringBuilder builder = new StringBuilder();
        appendRowNumber(length, builder);
        appendRowBarrier(length, builder);
        for (int i = 0; i < large; i++) {
            builder.append(i+1)
                    .append("|");
            for (int j = 0; j < length; j++) {
                builder.append(booleanToString(booleans[i][j]))
                        .append("  ");
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }

    private String booleanToString(boolean flag){
        if(flag){
            return "*";
        }else{
            return " ";
        }

    }

    private void appendRowBarrier(int length, StringBuilder builder) {
        for (int i = 0; i < length; i++) {
            builder.append("  -");
        }
        builder.append("\r\n");
    }
    private void appendRowNumber(int length, StringBuilder builder) {
        for (int j = 1; j <= length; j++) {
            builder.append("  ")
                    .append(j);
        }
        builder.append("\r\n");
    }
}
