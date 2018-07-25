package rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型.b_练习;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("练习题")
public class PracticeTest {

    @Test
    @DisplayName("1.1.1 得到表达式的值")
    void test1() {
        System.out.println("a." + (0 + 15) / 2);
        System.out.println("b." + ((2.0e-6) * (100000000.1)));
        System.out.println("c." + ((true && false) || (true && true)));
        System.out.println("c." + (true && false || true && true));
        System.out.println("c." + (true && false || true));
    }

    @Test
    @DisplayName("1.1.2 获得表达式的类型和值")
    void test2() {
        double a = (1 + 2.236) / 2;
        System.out.println(a);

        double b = 1 + 2 + 3 + 4.0;
        System.out.println(b);

        boolean c = 4.1 >= 4;
        System.out.println(c);

        String d = 1 + 2 + "3";
        System.out.println(d);
    }

    @DisplayName("1.1.3 代码测试")
    @Nested
    class test3 {

        /**
         * 三处整形参数， 如果都相同，则打印 equal ，否则 notEqual·
         */
        class Equals {

            boolean isEquals(int a, int b, int c) {
                return a == b && b == c;
            }

            void say(boolean flag){
                if(flag){
                    System.out.println("Equals");
                }else {
                    System.out.println("Not Equals");
                }
            }
        }

        private Equals equals=new Equals();

        private Random random=new Random();

        @Test
        @DisplayName("相等")
        void isEquals() {
            int i = random.nextInt();
            boolean flag=equals.isEquals(i,i,i);
            equals.say(flag);
            assertTrue(flag);
        }
        @Test
        @DisplayName("不等")
        void isNotEquals(){
            boolean flag=equals.isEquals(random.nextInt(),random.nextInt(),random.nextInt());
            equals.say(flag);
            assertFalse(flag);
        }

    }

    @Test
    @DisplayName("1.1.6")
    void test6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    @DisplayName("1.1.7")
    @Nested
    class test7 {
        @Test
        @DisplayName("a")
        void test7A() {
            double t = 9.0;
            while (Math.abs(t - 9.0 / t) > .0001) {
                t = (9.0 / t + t) / 2.0;
                System.out.println(t);
            }
            StdOut.printf("%.5f\n", t);
        }

        @Test
        @DisplayName("b")
        void test7B() {
            int sum = 0;
            for (int i = 1; i < 1000; i++) {
                for (int j = 0; j < i; j++) {
                    sum++;
                }
            }
            System.out.println(sum);
        }

        @Test
        @DisplayName("c")
        void test7C() {
            int sum = 0;
            for (int i = 1; i < 1000; i *= 2) {
                for (int j = 0; j < 1000; j++) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

    @Test
    @DisplayName("1.1.8")
    void test8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
        System.out.println((int) 'b');
    }

    @Test
    @DisplayName("1.1.9")
    void test9() {
        int N =9;
        String s="";
        for (int n = N; n >0; n/=2) {
            s=(n%2)+s;
        }
        System.out.println(s);
    }

    @Test
    @DisplayName("1.1.10")
    void test10() {
        int []a ;
        for (int i = 0; i < 10; i++) {
        //需要初始化 a 不然编译不通过，
//      a[i]=i*i;
        }

    }


    @Test
    @DisplayName("1.1.11")
    void test11() {
        Practice practice=new Practice();
        int length=10;
        int large=10;

        boolean[][] booleans=new boolean[large][length];
        for (int i = 0; i < large; i++) {
            boolean[] booleans1=new boolean[length];
            for (int j = 0; j < length; j++) {
              booleans1[j]=new Random().nextBoolean();
            }
            booleans[i]=booleans1;
        }
        System.out.println( practice.printBooleanArray(booleans));
    }


    @Test
    @DisplayName("1.1.12")
    void test12(){
        int[] a =new int[10];
        for (int i = 0; i < 10; i++) {
            a[i]=9-i;
        }

        for (int i = 0; i < 10; i++) {
            a[i]=a[a[i]];
        }
        Arrays.stream(a).forEach(System.out::println);
    }


    @Nested
    @DisplayName("1.1.13")
    class test13 {
        private PrintArray printArray;

        @BeforeEach
        void setUp() {
            List<List<String>> lists=new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                List<String> stringList=new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    stringList.add(UUID.randomUUID().toString());
                }
                lists.add(stringList);
            }
            printArray=new PrintArray(lists);
        }

        @Test
        @DisplayName("模拟 mysql 等的打印")
        void print() {
            System.out.println(printArray.print());
        }

        @Test
        @DisplayName("获得空的字符串")
        void getEmptyString() {
            String str=PrintArray.getEmptyString(10);
            assertSame(10,str.length());
            System.out.println(str+"--");
        }

        @Test
        void name() {
            char[] chars="行".toCharArray();
            System.out.println("行");
            System.out.println("a");
            System.out.println(1);
        }
    }



}
