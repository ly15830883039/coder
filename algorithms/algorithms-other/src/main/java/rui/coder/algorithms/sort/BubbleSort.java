package rui.coder.algorithms.sort;

/**
 * 冒泡排序
 * @author 赵睿
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        int length=nums.length;
//        nums[temp] 和 nums[temp+1]比较

        int interchangeCount=1;

        //第一次循环为找出最大
        //第二次循环为找出第二大
        //第三次循环为找出第三大
        //...
        //第n此循环找出第n大
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    interchange(nums,j,j+1);
                    interchangeCount++;
                }
            }

        }
        return nums;
    }

    /**
     * 互换
     */
    private void interchange(int [] arr,int first,int last){
        int temp=arr[first];
        arr[first]=arr[last];
        arr[last]=temp;
    }
}
