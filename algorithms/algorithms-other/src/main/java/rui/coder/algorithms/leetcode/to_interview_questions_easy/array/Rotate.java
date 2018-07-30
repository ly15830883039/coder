package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

/**
 * 将包含 n 个元素的数组向右旋转 k 步。
 * <p>
 * 例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 * <p>
 * 要求: 空间复杂度为 O(1)
 *
 *
 * 向右旋转1步就是说把初始数组的最高位上的数字放置在数组的最低位置，让后其他位置上的数字都把自身的位置提高1位。
 *
 * @author 赵睿
 */
public class Rotate {


    /*
        从这个规则上说，如果比较长的数组，我们可以考虑那些需要动，
            1. 如果超过长度的，每长度次之后，恢复为源数组
     */
    public void rotate(int[] ints, int k) {
        if(k<=0) return ;


        int length=ints.length;
        k=k%length;

        while(k!=0){
            int i=0;
            int temp=ints[length-1];
            while(i!=length-1){
                int a=ints[i];
                ints[i++]=temp;
                temp=a;
            }
            ints[length-1]=temp;
            k--;
        }
    }

    /**
     *  通过 nums.length - k 找出移动策略相同的数据。
     *  1. 左边的数据都是向右移动k位，故无论采取什么方式只要最终目标达到即可
     *  2. 又边的数据都是向左移动n-k位，故无论采取什么方式只要最终目标达到即可
     *  3. 所以左边和右边可以局部翻转，再整体翻转。
     *      1. 左边局部翻转 算式 为 新坐标 j= k-i,再 全局翻转，变成了 n-1-(n-1-k-i)= i+k;
     *      2, 右边局部翻转，算式为  新坐标 j= 2n-i-1-k 再 全局翻转，变成了 n-1-(2n-i-1-k)= n-1-2n+i+1+k=i-n+k=i-(n-k);
     *              5: 4 ->6   4+0 -> 4+2 (n-k)+( (k-1)-(i-(n-k)))= n-k +(k-1-i+n-k)=n-k-1-i+n=2n-i-1-k;
     *              6: 5 ->5   4+1 -> 4+1
     *              7: 6 ->4
     */
    public void mostFast(int[] nums, int k){
            //取余 ，保证倍数同样数据返回，减少操作时间。
            k %= nums.length;
            // 右侧翻转
            swap(nums, nums.length - k, nums.length - 1);
            // 左侧翻转
            swap(nums, 0, nums.length - k - 1);
            // 总翻转
            swap(nums, 0, nums.length - 1);
        }


    private void swap(int[] nums, int begin, int end) {
        while (end > begin) {
            int t = nums[begin];
            nums[begin] = nums[end];
            nums[end] = t;
            begin++;
            end--;
        }
    }
}
