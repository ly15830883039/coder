package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author 赵睿
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int index=length-1;

        while(index>=1){
            int temp=digits[index]+1;
            if(temp==10){
                digits[index]=0;
                index--;
            }else {
                digits[index]=temp;
                break;
            }
        }

        //1. 尾数+1；不为10
        // 2. 尾数+1 之后为10
        // 然后顺位增加,执行上面的操作
        // 1. 最后一位处理，是否需要扩展位数
        if(index==0){
            IntStream.Builder builder;
            if(digits[0]==9){
                builder=IntStream.builder()
                        .add(1)
                        .add(0);
            }else{
                builder=IntStream.builder()
                        .add(digits[0]+1);
            }

            int[] finalDigits = digits;
            if(1<=length-1){
                Arrays.stream(finalDigits, 1, length)
                        .forEachOrdered(builder::add);
            }

            digits=builder.build().toArray();
        }
        return digits;
    }
}
