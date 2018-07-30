package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

/**
 * 存在重复
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
 *
 * @author 赵睿
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean faster(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            //j 从0 开始
            int j = i - 1;
            //从i开始的索引取值
            int k = nums[j + 1];
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
