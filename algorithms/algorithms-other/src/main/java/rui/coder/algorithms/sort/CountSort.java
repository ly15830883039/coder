package rui.coder.algorithms.sort;

/**
 * <p>计数排序</p>
 * <a href="https://mp.weixin.qq.com/s/Tq-hUeNv-wrF-hjKoA4nfw">漫画：什么是计数排序？</a>
 *
 */
public class CountSort implements Sort {


    /**
     * 0 -10 范围内的计数排序,然后顺序输出
     */
    @Override
    public int[] sort(int[] nums) {
        int[] ints = new int[11];

        for (int i = 0; i < nums.length; i++) {
            ints[nums[i]]++;
        }

        int[] sorts = new int[nums.length];
        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i]; j++) {
                sorts[index++] = i;
            }
        }
        return sorts;


    }
}
