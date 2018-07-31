package rui.coder.algorithms.interview.netEase;

class FindNum {

    /**
     * 只有一个数没有重复出现过三次
     * @param size 数组的长度
     * @param numbs 数组的内容
     * @return 唯一出现过一次的数
     */
    @SuppressWarnings("unused")
    int findNum(int size, int[] numbs){
       int a=0;
       int b=0;

        for (int anInt : numbs) {
            b=a&(b^anInt);// 和输入找不同 = b，和a比较，只有a中这个位数已经重复才能变1 。
            a=b|(a^anInt);// 和输入找不同 = a, 和b比较，如果b为1，则把这个位数赋给a。
            // a=0 b=0 重复0次,或者3的倍数
            // a=1 b=0 重复1次
            // a=1 b=1 重复2次
            // 因为不存在重复2此的，只有3的倍数。所以。最终结果中，a漂移的位数数即为只重复一次的数据。
        }
        return a;
    }
}
