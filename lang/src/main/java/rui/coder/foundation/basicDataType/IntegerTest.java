package rui.coder.foundation.basicDataType;


import org.junit.jupiter.api.Test;

/**
 * <p>
 * 测试int类型的++i和i++
 * </p>
 * 创建于 2017/2/13
 *
 * @author 赵睿
 */
public class IntegerTest {

    /*
        i++ 与 ++i 的主要区别有两个：
            1、 i++ 返回原来的值，++i 返回加1后的值。
            2、 i++ 不能作为左值，而++i 可以。

        i++ ：先引用后增加 先在i所在的表达式中使用i的当前值，后让i加1
        ++i ：先增加后引用 让i先加1，然后在i所在的表达式中使用i的新值

     */

    int i=1;

    @Test
    public void test1(){
        System.out.println(++i);
    }
    @Test
    public void test2(){
        System.out.println(i++);//i++ 最后返回的是一个临时变量，而临时变量是右值。
    }


    /*
        在for循环中没有任何影响,是因为最后一个在最终执行
     */
    @Test
    public void testFor1(){
        for (int j = 0; j <3 ; j++) {
            System.out.println(j);
        }
    }

    @Test
    public void testFor2(){
        for (int j = 0; j <3 ; ++j) {
            System.out.println(j);
        }
    }

    @Test
    public void assign1(){
        int x;
        x=i++;
        System.out.println(i); //2
        System.out.println(x); //1
    }

    @Test
    public void assign2(){
        int x;
        x=++i;
        System.out.println(i); //2
        System.out.println(x); //2
    }

    @Test
    public void compile(){
        int[]a=null;
        a[0]=0;
    }


}
