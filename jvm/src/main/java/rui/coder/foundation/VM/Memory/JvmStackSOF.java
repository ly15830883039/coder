package rui.coder.foundation.VM.Memory;

/**
 * Java 虚拟机栈和本地方法栈测试outOfMemory 测试
 *
 * 这个程序实现的本质是通过递归，通过递归方法的栈堆积，造成对栈所占空间不足，即发生了栈溢出
 *
 * Stack Over Flow Error
 *
 * 使用-Xss 调整栈内存的大小
 * -Xss128k
 * 创建于 2017-02-06.
 *
 * @author 赵睿
 */
public class JvmStackSOF {
    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JvmStackSOF jvmStackSOF=new JvmStackSOF();
        try {
            jvmStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈长度为"+jvmStackSOF.stackLength);
            throw e;
        }
    }
}
