package rui.coder.foundation.VM.Memory;

/**
 * 栈溢出模拟器
 *
 * 每个线程都有自己的私有栈，随线程的创建而创建。栈中存在栈帧（Frame）。
 * 每个方法会创建一个栈帧，栈帧中存放了局部变量表（基本数据类型和对象引用）、操作数栈，方法出口等。
 * 栈的大小可以固定也可以动态扩展。
 *
 * 当栈调用深度大于JVM所允许的范围，会抛出StackOverflowError的错误，不过这个深度范围不是一个恒定的值.
 *
 * @see <a href="http://www.cnblogs.com/paddix/p/5309550.html">Java8内存模型—永久代(PermGen)和元空间(Metaspace)</a>
 *
 *
 * Created by 赵睿 on 2017/1/10.
 */
public class StackErrorMock {

    public static int index=1;

    public void call(){
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock=new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable e) {
            System.out.println("栈溢出："+index);
            e.printStackTrace();
        }
    }
}
