package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

/**
 * 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 例如， 定义 nums = [0, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
 * <p>
 * 注意事项:
 * <p>
 * 必须在原数组上操作，不要为一个新数组分配额外空间。
 * 尽量减少操作总数。
 *
 * @author 赵睿
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;

        int index = 0;
        int right = nums.length - 1;
        while (index < right) {
            if (nums[index] == 0) {
                moveToLeft(nums, index, right);
                right--;
            }else{
                index++;
            }

        }
    }

    private void moveToLeft(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            nums[i] = nums[i + 1];
        }
        nums[end] = 0;
    }
}
