package rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型.EuclidAlgorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("欧几里德算法")
class EuclidAlgorithmsTest {

    private EuclidAlgorithms euclidAlgorithms=new EuclidAlgorithms();
    @Test
    @DisplayName("获得最大公约数 gcd 即为 greatest common divisor")
    void gcd() throws Exception {
        int p = 35;
        int q =28;
        System.out.println(euclidAlgorithms.gcd(p,q));
        assertEquals(7,euclidAlgorithms.gcd(p,q));
    }
}