package rui.coder.algorithms.interview.alibaba;

/**
 * 删除重复相邻的字符串
 */
public class RemoveDuplicate {

    private int size = 0; //这个填入上一个index

    //游标
    private int index = 0;
    private int right = 1; //右浮动，相同的跳过的位数； 跳位
    private int left = 0; //左浮动，从不能消除的列表中获得上一个不重复的游标；退位

    String alg(String str) {
        char[] chars = str.toCharArray();
        int maxIndex = chars.length - 1;

        //非同游标列表
        int[] noSame = new int[chars.length];
        if (maxIndex <= 1) {
            return str;
        }

        //跨度
        int span;
        while (index + (span = right - left) <= maxIndex) {
            if (chars[index] == chars[index + span]) {
                if (index + span == maxIndex) {
                    if (size != 0) {
                        noSame[--size] = 0;
                    }
                    break;
                }
                //相同右移
                right++;
            } else {//已经无相同数据
                if (left == 0 && right == 1) {//无退位，无跳位
                    //存储index。
                    noSame[size++] = index;//存储这个位置
                    if ((index = index + span) == maxIndex) {//游标漂移
                        noSame[size++] = index;//放入非同游标列表中
                        break;//终止当前循环
                    }
                } else if (left == 0 && right > 1) {//无退位，有跳位
                    if (size != 0) { //继续退位
                        int temp = noSame[size - 1];//从非同游标列表取出上一个非同游标
                        left = temp - index - right + 1;//获得退位位数
                        index = temp;//游标置为非同游标
                        right = 1;
                    } else {
                        if ((index = index + span) == maxIndex) {//重置游标
                            noSame[size++] = index;//放入非同游标列表中
                            break;//终止当前循环
                        } else {
                            right = 1;
                        }
                    }
                } else if (left < 0 && right == 1) {//有退位，无跳位
                    //退位值和原比较对应值不同
                    if ((index = index + span) == maxIndex) {//游标漂移
                        noSame[size++] = index;
                    }
                    left = 0;//回置退位
                    right = 1;
                } else if (left < 0 && right > 1) {//有退位，有跳位
                    //清理非同游标列表
                    noSame[--size] = 0;
                    if (size != 0) { //继续退位
                        int temp = noSame[size - 1];//从非同游标列表取出上一个非同游标
                        left = temp - index - right + left + 1;//获得退位位数
                        index = temp;//游标置为非同游标
                        right = 1;
                    } else {
                        index = index + span;//重置游标
                        left = 0;
                        right = 1;
                    }
                }
            }
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(chars[noSame[i]]);
        }
        return stringBuilder.toString();
    }


    String alg2(String str) {
        int start = 0, size;
        while ((size = findContinuous(str, start)) == 0 && start < str.length()) {
            start++;
        }
        if (size != 0) {
            String temp = continuousCharsToString(str.charAt(start), size);
            str = str.replaceAll(temp, "");
            return alg2(str);
        }
        return str;
    }

    private int findContinuous(String string, int start) {
        int size = 0;
        while (start + size + 1 < string.length() && string.charAt(start) == string.charAt(start + size + 1)) {
            size++;
        }
        return size;
    }

    private String continuousCharsToString(char c, int size) {
        if (size == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= size; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
