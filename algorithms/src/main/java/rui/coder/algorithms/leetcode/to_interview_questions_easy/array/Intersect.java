package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 两个数组的交集 II
 * <p>
 * 给定两个数组，写一个方法来计算它们的交集。
 * <p>
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 * <p>
 * 注意：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 跟进:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author 赵睿
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numMap1 = toMap(nums1);
        Map<Integer, Integer> numMap2 = toMap(nums2);

        IntStream.Builder builder = IntStream.builder();

        for (Integer integer : numMap2.keySet()) {
            try {
                int temp = numMap1.get(integer);

                int thisSize = numMap2.get(integer);
                if (thisSize >= temp) {
                    //temp
                    collectedMergeElementToIntStreamBuilder(builder, integer, temp);

                } else {
                    //thisSize
                    collectedMergeElementToIntStreamBuilder(builder, integer, thisSize);
                }

            } catch (Exception ignored) {
            }
        }

        return builder.build().toArray();
    }

    private void collectedMergeElementToIntStreamBuilder(IntStream.Builder builder, Integer integer
            , int thisSize) {
        IntStream.range(0, thisSize)
                .map(i -> integer)
                .forEachOrdered(builder::add);
    }

    private HashMap<Integer, Integer> toMap(int[] nums1) {
        HashMap<Integer, Integer> numsMap = new HashMap<>(nums1.length);
        for (int i : nums1) {
            int temp = 0;
            try {
                temp = numsMap.get(i);
            } catch (Exception e) {
                numsMap.put(i, 1);
            }
            numsMap.put(i, ++temp);
        }
        return numsMap;
    }

}
