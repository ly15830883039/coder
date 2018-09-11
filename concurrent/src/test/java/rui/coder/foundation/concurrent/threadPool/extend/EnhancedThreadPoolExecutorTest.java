package rui.coder.foundation.concurrent.threadPool.extend;

import org.junit.jupiter.api.Test;
import rui.coder.foundation.concurrent.threadPool.extend.EnhancedThreadPoolExecutor;
import rui.coder.foundation.concurrent.threadPool.extend.TaskQueue;

import java.util.concurrent.TimeUnit;


class EnhancedThreadPoolExecutorTest {
    private static final int CORE_SIZE = 5;

    private static final int MAX_SIZE = 10;

    private static final long KEEP_ALIVE_TIME = 30;

    private static final int QUEUE_SIZE = 5;

    private static EnhancedThreadPoolExecutor executor = new EnhancedThreadPoolExecutor(CORE_SIZE, MAX_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.SECONDS, new TaskQueue(QUEUE_SIZE));


    @Test
    void execute() {
        for (int i = 0; i < 25; i++) {
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