package rui.coder.foundation.concurrent.forkJoin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

class CountTaskTest {

    @Test
    void case1() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 200000L);
        // 将一个大的任务提交到池中
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        long res = 0;
        try {
            // 等待运算结果
            res = result.get();
            System.out.println("sum = " + res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}