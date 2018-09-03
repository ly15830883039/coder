package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import java.util.*;
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

        Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(0, nums.length).forEachOrdered(i -> {
            int num = nums[i];
            if (map.get(num) == null) {
                map.put(num, Collections.singletonList(i));
            } else {
                map.put(num, Arrays.asList(map.get(num).get(0), i));
            }
        });


        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
            int diff = target - integer;
            if (keySet.contains(diff)) {

                if (diff == integer) {
                    return new int[]{map.get(integer).get(0), map.get(diff).get(1)};
                }

                return new int[]{map.get(integer).get(0), map.get(diff).get(0)};
            }
        }
        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);

        int small = 0;
        int bigger = nums.length - 1;

        while (small < bigger) {
            int sumTemp = sortNums[small] + sortNums[bigger];
            if (sumTemp == target) {

                break;
            } else if (sumTemp < target) {
                small++;
            } else {
                bigger--;
            }
        }

        int first = sortNums[small];
        int last = sortNums[bigger];

        int[] result=new int[2];

        int i=0;
        int j=0;
        while(i<=nums.length-1){
            int num=nums[i];
            if(num==first||num==last){
                result[j++]=i;
            }
            i++;
            if(j==2){
                break;
            }
        }
        return result;


    }
}
