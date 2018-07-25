package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

/**
 *
 * 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明： 你的算法应该具有线性时间复杂度。即时间复杂度为 O(n)， 你可以不使用额外空间来实现吗 O(1)？

 * @author 赵睿
 */
public class SingleNumber {


    public int singleNumber(int[] nums){
        // 利用XOR运算 ，即异或运算，如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result^=nums[i];
        }
        return result;
    }
}
