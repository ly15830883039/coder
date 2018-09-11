package rui.coder.foundation.concurrent.threadManagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 使用本地线程变量
 * Created by 赵睿 on 2017/2/17.
 */
public class UsingLocalThreadVariables {

    public static void main(String[] args) {
//        UnsafeTask task=new UnsafeTask();
        SafeTask task=new SafeTask();
        runTask(task);

    }

    static void runTask(Runnable task){
        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UnsafeTask implements Runnable{
    private Date startDate;

    @Override
    public void run() {
        startDate=new Date();
        System.out.printf("开始线程 ：%s : %s\n",Thread.currentThread().getId(),startDate);

        int sleepSeconds= (int) Math.rint(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(sleepSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("线程执行完成： %s : %s \n",Thread.currentThread().getId(),startDate);
    }
}

class SafeTask implements Runnable{
    /*
        本地线程变量为每个使用这些变量的线程储存属性值。
            可以用 get() 方法读取值和使用 set() 方法改变值。
            如果第一次你访问本地线程变量的值，如果没有值给当前的线程对象，那么本地线程变量会调用 initialValue() 方法来设置值给线程并返回初始值。

            本地线程类还提供 remove() 方法，删除存储在线程本地变量里的值。

        Java 并发 API 包括 InheritableThreadLocal 类提供线程创建线程的值的遗传性 。
            如果线程A有一个本地线程变量，然后它创建了另一个线程B，那么线程B将有与A相同的本地线程变量值。
                你可以覆盖 childValue() 方法来初始子线程的本地线程变量的值。 它接收父线程的本地线程变量作为参数。
     */
    private static ThreadLocal<Date> startDate=new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}
