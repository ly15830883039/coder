package rui.coder.foundation.concurrent.threadManagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 线程的睡眠和回复
 * Created by 赵睿 on 2017/2/16.
 */
public class SleepingAndResumingAThread {

    public static void main(String[] args) {
        Thread thread=new Thread(new FileClock());
        thread.start();
        try {
            /*
                调用sleep()方法， Thread 离开CPU并在一段时间内停止运行。在这段时间内，它是不消耗CPU时间的，使用可以执行其他任务。

                Java 并发 API 有另一种方法能让线程对象离开 CPU。它是 yield() 方法, 它向JVM表示线程对象可以让CPU执行其他任务。JVM 不保证它会遵守请求。通常，它只是用来试调的。
             */
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

}

class FileClock implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s \n",new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("当前的文件时钟被打断了！");
            }
        }
    }
}
