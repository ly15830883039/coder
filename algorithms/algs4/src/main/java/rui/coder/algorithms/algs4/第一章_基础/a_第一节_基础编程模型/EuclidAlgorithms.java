package rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型;

/**
 * 欧几里得算法（辗转相除法）
 *
 * 自然语言描述：
 * <p>
 *     计算两个非负整数p和q的最大公约数：
 *     <ol>
 *         <li>若 q为0 ，则最大公约数为p。</li>
 *         <li>否则，将p除以q得到r，p和q的最大公约数即为 q和r的最大公约数</li>
 *     </ol>
 * </p>
 *
 * Created by 赵睿 on 2017-05-15.
 */
class EuclidAlgorithms {

    /**
     *最大公约数（greatest common divisor）缩写为gcd。
     */
    int gcd(int p,int q){
        if(q==0) return p;
        int r=p%q;
        return gcd(q,r);
    }

}
