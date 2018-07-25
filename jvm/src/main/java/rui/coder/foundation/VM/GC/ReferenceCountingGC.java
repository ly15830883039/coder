package rui.coder.foundation.VM.GC;

/**
 * <p>
 * 引用计数法
 * -XX:+PrintGCDetails
 * </p>
 * 创建于 2017/2/9
 *
 * @author 赵睿
 */
public class ReferenceCountingGC {

    public Object instance=null;
    private static final int _1MB=1024*1024;

    //这个属性的作用就是占据内存空间，方便在GC日志中看到是否被回收
    private byte[] bigSize=new byte[2*_1MB];

    /*
        将这个类产生的两个类制作出一个环形的引用。
        但是在Gc日志中可以看出
     */
    public static void main(String[] args) {
        ReferenceCountingGC a=new ReferenceCountingGC();
        ReferenceCountingGC b=new ReferenceCountingGC();
        a.instance=b;
        b.instance=a;
        a=null;
        b=null;
        System.gc();
    }
}
