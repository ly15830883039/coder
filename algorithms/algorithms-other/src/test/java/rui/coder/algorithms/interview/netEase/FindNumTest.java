package rui.coder.algorithms.interview.netEase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNumTest {

    @Test
    void two() {
        int i =7;


        System.out.println(Integer.toBinaryString(i));
        int j;

        // 异或 相同为0，不同为1
        j=i^i;

        System.out.println(Integer.toBinaryString(j));

        //都为1方能为 1
        j=i&i;

        System.out.println(Integer.toBinaryString(j));


        j = i| i;
        System.out.println(Integer.toBinaryString(j));


        System.out.println(Integer.toBinaryString(0&j));


        System.out.println(0^1);

        System.out.println(0|1);

    }


    @Test
    void three() {

        //两位表示 即 00 01 10

        //位累计到3自动清零
        int[] nums;

        nums=new int[]{5,11,5,5};

        int a = 0;
        int b = 0;

        for (int num : nums) {
            System.out.println(Integer.toBinaryString(num));

            System.out.println(Integer.toBinaryString(b^num));
            System.out.println(Integer.toBinaryString(a&(b^num)));
            b=a&(b^num);
            System.out.println(Integer.toBinaryString(a^num));
            System.out.println(Integer.toBinaryString(b|(a^num)));
            a=b|(a^num);
            System.out.println("a-->"+Integer.toBinaryString(a));
            System.out.println("b-->"+Integer.toBinaryString(b));

        }
        System.out.println(a);


        /*
            1. 第一次 b=0, a=记录1 ;
            2. 第二次
                1. 不同 b=记录1 , a=记录2
                    1. 和第一次同， 即为记录1 ，b= 0, [和记录1相同了] a=记录1^记录2
                        1. 和第一次相同， 即为 b=记录1^记录2&记录1 ； a= 记录1？？？？
//                    2. 和第一次不同，即为记录3，b=记录2&记录1^记录3  a=


         */


        /*
           s     b^num              b=a&(b^num)            a^num              a=b|(a^num)          4 3 2 1
          0101   0000^0101=0000     0000&0000=0000         0000^0101=0101     0000|0101=0101       0 1 0 1
          1011   0000^1011=0100     0101&0100=0001         0101^1011=1110     0001|1110=1111       1 1 1 2
          0101   0001^0101=0100     1110&0100=0100         1111^0101=1010     0100|1010=1110       1 2 1 3  1 2 1 0  1210
          0101   1011^0101=1110     1110&1110=0000         1110^0101=1011     0000|1011=1011       1 3 1 4  1 0 1 1  1011
         */


        /*
            b^num
         */

    }


    @Test
    void name() {
        System.out.println(110^100);

        System.out.println(Integer.toBinaryString(233));
        System.out.println(Integer.toBinaryString(123));
        System.out.println(Integer.toBinaryString(233&123^123));
        System.out.println(Integer.toBinaryString(233&(123^123)));
//        System.out.println(Integer.toBinaryString(233^123));
//        System.out.println(Integer.toBinaryString(123&(233^123)));
//        System.out.println(Integer.toBinaryString(123&233^123));
//        System.out.println(Integer.toBinaryString(123^(233^123)));
//        System.out.println(Integer.toBinaryString(123|(123&(233^123))));
//
//
//        System.out.println(123&(233^123));
//        System.out.println(233^123);


    }
}