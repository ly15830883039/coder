package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author 赵睿
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //使用 hashMap 这个数据结构的原因是 为了保留nums 中的所以顺序。
        HashMap<Integer, Integer> hashMap = IntStream.range(0, nums.length)
                .boxed()
                .collect(Collectors.toMap(i -> nums[i]
                        , i -> i
                        , (a, b) -> b
                        , HashMap::new));


       Set<Integer> keySet=hashMap.keySet();
        for (Integer integer : keySet) {
            int diff=target-integer;
            if(keySet.contains(diff)){
                return new int[]{hashMap.get(integer),hashMap.get(diff)};
            }
        }
        return new int[]{};
    }
}
