package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

/**
 * 颠倒整数
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class Reverse {


    public int reverse(int x) {
        char[] chars = (x + "").toCharArray();
        StringBuilder builder = new StringBuilder();

        if (x < 0) {
            builder.append("-");
        }

        boolean flag=false;
        for (int i = chars.length - 1; i >= 0; i--) {
            int a = chars[i] - 48;

            if(a==0&&flag){
                builder.append(a);
            }
            if (a > 0) {
                flag=true;
                builder.append(a);
            }
        }

        if(builder.length()==0){
            return 0;
        }
        try {
            return Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }


    //利用10倍的特性
    public int reverse2(int x){
        long res=0;
        for(;x!=0;x/=10){
            //取出倒一位，然后乘以10和下一个余数相加
            res=res*10+x%10;
        }
        return res>Integer.MAX_VALUE||res<Integer.MIN_VALUE?0:(int)res;
    }
}
