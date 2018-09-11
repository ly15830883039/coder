package rui.coder.foundation.concurrent.jdk5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 对 CountDownLatch 的测试和学习
 *
 * @since jdk1.5
 */
class CountDownLatchTest {
    private int threadSize = 5;

    @Nested
    @DisplayName("主线程等待子线程执行完成")
    class mainWaitForThreadStop{
        @Test
        @DisplayName("简单 thread")
        void simple() throws InterruptedException {
            CountDownLatch latch = new CountDownLatch(threadSize);

            for (int i = 0; i < threadSize; i++) {
                new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " finished");
                    latch.countDown();
                }).start();
            }
            latch.await();
            System.out.println("I wait  for child thread run end");
        }

        @Test
        @DisplayName("线程池")
        void executor() throws InterruptedException {
            CountDownLatch latch = new CountDownLatch(threadSize);
            ExecutorService executorService = Executors.newFixedThreadPool(threadSize);

            for (int i = 0; i < threadSize; i++) {
                executorService.execute(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " finished");
                    latch.countDown();
                });

            }
            latch.await();
            System.out.println("I wait  for child thread run end");
        }
    }




    /**
     * @see CountDownLatch
     */
    @Test
    @DisplayName("主线程先阻塞子线程执行，运行子线程执行之后，等待从线程执行完成")
    void countDownAndAwait() throws InterruptedException {

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(threadSize);

        // 依次创建并启动5个worker线程
        for (int i = 0; i < threadSize; ++i) {

            new Thread(() -> {
                try {
                    System.out.println("wait from start countDown    " + System.currentTimeMillis());
                    start.await(); // 等待Driver线程执行完毕，获得开始信号
                    System.out.println("Working now ...   " + System.currentTimeMillis());
                    done.countDown(); // 当前worker执行完毕，释放一个完成信号
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.printf("main want sleep ,now : %s \r\n", System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.printf("main work , start all workers ... now : %s \r\n", System.currentTimeMillis());
        start.countDown(); // Driver执行完毕，发出开始信号，使所有的worker线程开始执行
        done.await(); // 等待所有的worker线程执行结束
        System.out.printf("Finished... now : %s \r\n", System.currentTimeMillis());
    }
}

