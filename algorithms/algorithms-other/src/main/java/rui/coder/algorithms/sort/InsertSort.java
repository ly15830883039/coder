package rui.coder.algorithms.sort;

/**
 * 插入排序
 * @author 赵睿
 */
public class InsertSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int insertIndex = i;
            for (int j = i - 1; j > -1; j--) {
                if (temp < nums[j]) {
                    nums[j + 1] = nums[j];
                    insertIndex = j;
                }
            }
            if (insertIndex != i) {
                nums[insertIndex] = temp;
            }
        }
        return nums;
    }
}
