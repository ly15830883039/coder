package rui.coder.algorithms.interview.alibaba;

/**
 * 删除重复相邻的字符串
 */
public class RemoveDuplicate {


    public String alg(String str) {
        char[] chars = str.toCharArray();

        int size = 0; //这个填入上一个index
        int[] ints = new int[chars.length];


        //游标
        int index = 0;
        //右移动长度
        int right = 0;
        //跨度
        int span = 1;


        while (index < chars.length) {
            if (chars[index] == chars[index + right + span]) {
                //相同右移
                right++;
            } else {//已经无相同数据
                if (right > 0) {//存在相同的位数，需要消除
                    if (span == 1) {//跨度未变化。没有左移的事情发生
                        index = ints[size - 1];// 后退一位
                        right = 0;
                        span = span + right + 1;//原始跨度+左移动的位数+右移动的位数

                    } else {//跨度出现变化,存在左移的情况，且左移动的这个位数和后面的可以相消
                        index = index + span + right;
                        right = 0;
                        span = 1;
                        size--;
                        ints[size] = 0;//后退一位，置空
                    }
                } else {//不存在相同的位数，无需消除
                    if (span == 1) {//跨度没有变化。没有左移的事情的发生
                        index = index + span + right;
                        ints[size++] = index;//存储这个位置
                        right = 0;
                    } else {//跨度出现变化。但是且不存在相同
                        ints[size++] = index;
                        index = index + size + right;
                        span = 1;
                        right = 0;

                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(chars[ints[i]]);
        }

        return stringBuilder.toString();

    }
}
