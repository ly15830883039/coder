package rui.coder.foundation.VM;

/**
 * <p>
 * -Xmx 设置JVM最大可用内存
 * -Xms 设置JVM促使内存。  一般和-Xmx相同，避免JVM重新分配内存
 * -Xmn 设置年轻代的大小，整个JVM内存大小=年轻代大小 + 年老代大小 + 持久代大小；持久代一般固定大小为64m，所以增大年轻代后，将会减小年老代大小。此值对系统性能影响较大，Sun官方推荐配置为整个堆的3/8
 * -Xss 设置每个线程的堆栈的大小。JDK5.0以后每个线程堆栈大小为1M
 * </p>
 * 创建于 2017/2/10
 *
 * @author 赵睿
 */
public class MinorGC {
    private static int _1M=1024*1024;

    public static void main(String[] args) {
        byte[] allocation1 , allocation2,allocation3,allocation4;
        allocation1=new byte[2*_1M];
        allocation2=new byte[2*_1M];
        allocation3=new byte[2*_1M];
        allocation4=new byte[4*_1M];
    }

}

