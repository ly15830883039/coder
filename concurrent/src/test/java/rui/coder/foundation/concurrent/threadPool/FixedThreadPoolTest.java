package rui.coder.foundation.concurrent.threadPool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.jupiter.api.Assertions.*;

class FixedThreadPoolTest {

    private static ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(10);



    @Test
    void execute() {
        for (int i = 0; i < 10000000; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


            System.out.println("线程池中现在的线程数目是："
                    + executor.getPoolSize()
                    + ",  队列中正在等待执行的任务数量为："
                    + executor.getQueue().size()
                    + ", core 核心线程数 ："
                    + executor.getCorePoolSize()
                    + ", max mum 池大小"
                    + executor.getMaximumPoolSize()
                    + ", 当前激活的数量 count:"
                    + executor.getActiveCount()
            );
        }
    }
}