package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

/**
 * 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意： 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author 赵睿
 */
public class MaxProfit {

    //顺序输入，值小的时候买入，值高的时候，卖出，求差值的最大值。

    public int maxProfit(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int earn = 0;
        int buy = -1;
        int sell = -1;
        for (int i = 0; i < nums.length; i++) {

            int caseNum = 0;

            int temp=nums[i];
            if(buy == -1 || buy >= temp ){
                //没买，或者买贵了。价格相同，一样了
                if(sell>buy){
                    //看看我如何上一把脱手，赚不赚钱啊。
                    //及时脱手
                    caseNum=3;
                }else{
                    caseNum=1;
                }
            }else {
                //买的价格比这个便宜啊。看看卖不？
                if(sell==-1||sell<temp){
                    //没有上一个收价记录 或者上一个最贵的收价比这个价格小。
                    caseNum=2;
                }else if(sell== temp){
                    //和上一次价格相同，卖了
                    caseNum=3;
                }else if(sell> temp){
                    //卖价这次少了，卖了
                    caseNum=3;
                }
            }
            switch (caseNum) {
                //重新买
                case 1:
                    buy = nums[i];
                    break;
                case 2:
                    sell = nums[i];
                    break;
                case 3:
                    //算算，赚了多少钱
                    earn += sell - buy;
                    //归为从来没有卖过
                    sell = -1;
                    //把当前这次买入
                    buy = nums[i];
                    break;
            }
            if (i == nums.length - 1) {
                if (buy < sell) {
                    earn += sell - buy;
                }
            }
        }
        return earn;
    }

    /**
     * 他的思路和我的思路不同的地方，是我是按照那种正常的抛售的角度去考虑这个问题，而下面的这个算法，却是将股票抛售问题，
     * 简化为了一个算数组差值的问题。思路是我只要算之间差值就可以，相邻值的差距，只要后面大于前面就累加，
     * 我在这个范围内的最大值和最小值的差值，必然是顺序数组的差值之和。
     * @param prices 股票价格
     * @return 最多能赚的钱
     */
    int maxProfit1(int[] prices) {
        int max_profit = 0;
        int diff = 0;
        for(int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[i-1];
            if(diff > 0) max_profit += diff;
        }

        return max_profit;
    }
}
