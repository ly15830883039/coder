package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * @author 赵睿
 */
class RemoveDuplicates {

    /**
     * 获得删除重复数据 之后的元素个数
     *
     * @param arrays 源数组
     * @return 数组长度
     */
    int get_deleteRepeat_afterElementCount(int[] arrays) {
        //边界条件判断
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        if (arrays.length == 1) {
            return 1;
        }

        int before = arrays[0];
        int temp = arrays[1];
        int length = arrays.length;
        int i = 1;
        //noinspection ConstantConditions
        while (i < length) {
            if (before == temp) {
                deleteElementByIndex_thenMoveForward(arrays, i, length);
                length -= 1;
            } else {
                i++;
            }
            if (i >= length) {
                return length;
            } else {
                before = temp;
                temp = arrays[i];
            }
        }

        return length;
    }

    /**
     * 获得删除重复数据 之后的元素个数
     *
     * @param nums 源数组
     * @return 长度
     */
    int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 通过 游标 删除元素，然后将游标之后的元素前移
     *
     * @param array  源数组
     * @param index  游标
     * @param length 长度
     */
    @SuppressWarnings("ManualArrayCopy")
    private void deleteElementByIndex_thenMoveForward(int[] array, int index, int length) {
        for (int i = index; i < length - 1; i++) {
            array[i] = array[i + 1];
        }
    }
}
