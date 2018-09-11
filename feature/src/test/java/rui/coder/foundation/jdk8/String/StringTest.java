package rui.coder.foundation.jdk8.String;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author 赵睿
 */
@SuppressWarnings({"StringEquality", "ConstantConditions", "SimplifiableJUnitAssertion", "RedundantStringConstructorCall"})
class StringTest {

    @Test
    @DisplayName("编译的时候就做手脚了")
    void compiler() {
        String a = "hello2";
        String b = "hello" + 2;
        assertTrue(a == b);

        /*
            编译之后为：
                String a = "hello2";
                String b = "hello2";
                Assertions.assertTrue(a == b);
         */
    }

    @Test
    @DisplayName("运行时拼接，导致返回的是一个堆上的对象，而不是常量池中的")
    void runtimeGet() {
        String a = "hello2";
        String b ="hello";
        String c = b + 2;
        assertFalse(a == c);
    }


    @Test
    @DisplayName("final 修饰的，编译期会进行优化")
    void compilerReplace() {
        String a = "hello2";
        final String b ="hello";
        String c = b + 2;
        assertTrue(a == c);
        /*
            编译之后为：
                String a = "hello2";
                String b = "hello";
                String c = "hello2";
                Assertions.assertTrue(a == c);
         */
    }



    @Test
    @DisplayName("从常量池中获得，所以内存地址相同，方法也是一样")
    void constantPool() {
        String a = "hello2";
        String b = getHello2();
        assertTrue(a == b);
    }

    private String getHello() {
        return "hello";
    }

    private String getHello2() {
        return "hello2";
    }

    @Test
    @DisplayName("运行时候拼接，返回为新对象")
    void constantPool2() {
        String a = "hello2";
        String b = getHello();
        String c = b + 2;
        assertFalse(a == c);
    }


    @Test
    @DisplayName("运行时候 获得方法拼接，即使使用final修饰，但是一样不会在编译的时候优化")
    void constantPool3() {
        String a = "hello2";
        final String b = getHello();
        String c = b + 2;
        assertFalse(a == c);
    }

    @Test
    @DisplayName("intern的使用，如果常量池中存在，那就直接返回，如果不存在，压入。")
    void name3() {
        String a = "hello";
        String b =  new String("hello");
        String c =  new String("hello");
        String d = b.intern();

        assertFalse(a==b);
        assertFalse(b==c);
        assertFalse(c==d);
        assertTrue(a==d);
    }
}
