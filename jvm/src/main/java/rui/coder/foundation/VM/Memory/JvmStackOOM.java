package rui.coder.foundation.VM.Memory;

/**
 * java 虚拟机栈和本地方法栈 测试内存溢出
 *
 * 虚拟机栈和本地方法栈是对于每个线程而言的，这样给每个栈分配的空间越大，越会出现内存溢出的问题。
 *
 * 操作系统对于每个进程是有限制的，总内存-最大堆内存-最大方法区，剩下的被线程瓜分。
 * 所以如果设置线程栈空间很大，就会在较少的线程的情况下出现内存无法分配的情况，这种情况就是内存溢出
 *
 * 创建于 2017-02-06.
 *
 * @author 赵睿
 */
public class JvmStackOOM {
    private int threadSize=1;
     private void notStop(){
         while(true){
         }
     }

    public void stackLeakByThread(){
        while (true){
            Thread thread=new Thread(new Runnable() {
                public void run() {
                    notStop();
                }
            });
            thread.start();
            threadSize++;
        }
    }

    public static void main(String[] args) throws Throwable {
        JvmStackOOM jvmStackOOM=new JvmStackOOM();
        try {
            jvmStackOOM.stackLeakByThread();
        } catch (Throwable e) {
            System.out.println("触发线程数"+jvmStackOOM.threadSize);
            throw e;
        }

    }
}
