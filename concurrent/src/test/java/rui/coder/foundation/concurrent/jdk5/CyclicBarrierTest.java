package rui.coder.foundation.concurrent.jdk5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 同步屏障
 *
 * @see java.util.concurrent.CyclicBarrier
 */
class CyclicBarrierTest {

    @Nested
    @DisplayName("线程等待，一同并发")
    class WaitAndConcurrent {
        @Test
        void simple() throws InterruptedException, BrokenBarrierException {
            CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
            mainThreadAndANewThread(cyclicBarrier);
        }

        @Test
        void barrierAction() throws BrokenBarrierException, InterruptedException {
            CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () ->
                    printThreadInfoAndTime(Thread.currentThread(), "barrierAction  开始work"));
            mainThreadAndANewThread(cyclicBarrier);
        }

        @Test
        @DisplayName("interrupt线程，通过cyclicBarrier 得知阻塞线程已经被打断")
        void interrupt_CyclicBarrier_isBroken_true() {
            CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
            Thread thread = new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    assertTrue(cyclicBarrier.isBroken());
                }
            });
            thread.start();
            thread.interrupt();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                assertTrue(cyclicBarrier.isBroken());
            }
        }

        private void mainThreadAndANewThread(CyclicBarrier cyclicBarrier) throws InterruptedException, BrokenBarrierException {
            new Thread(() -> {
                try {
                    printThreadInfoAndTime(Thread.currentThread(), "抵达 cyclicBarrier");
                    cyclicBarrier.await();
                    printThreadInfoAndTime(Thread.currentThread(), "开始work");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            printThreadInfoAndTime(Thread.currentThread(), "开始休息");
            Thread.sleep(1000);
            printThreadInfoAndTime(Thread.currentThread(), "抵达 cyclicBarrier");
            cyclicBarrier.await();
            printThreadInfoAndTime(Thread.currentThread(), "开始work");
        }

    }


    private void printThreadInfoAndTime(Thread thread, String desc) {
        System.out.printf("%s   ： %s 当天时间： %s \r\n", thread, desc, System.currentTimeMillis());
    }
}
