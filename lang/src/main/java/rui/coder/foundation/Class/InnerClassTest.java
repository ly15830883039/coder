package rui.coder.foundation.Class;

/**
 * <p>
 * 类描述
 * </p>
 * 创建于 2017/2/13
 *
 * @author 赵睿
 */
public class InnerClassTest {

    public void someOuterMethod() {
        // Line 3
        new InnerClass();
    }

    public class InnerClass{
    }

    public static void main(String[] argv) {
        InnerClassTest innerClassTest = new InnerClassTest();
        // Line 11

        InnerClass innerClass= innerClassTest.new InnerClass();
        System.out.println(innerClass);

    }
}
