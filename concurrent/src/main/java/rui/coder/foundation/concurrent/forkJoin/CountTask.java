package rui.coder.foundation.concurrent.forkJoin;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

/**
 * <a href="http://ifeve.com/talk-concurrency-forkjoin/">聊聊并发（八）——Fork/Join框架介绍</a>
 */
public class CountTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10000;
    private long start;
    private long end;


    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;

        boolean canCompute = (end - start) < THRESHOLD;

        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 2000
            long step = (start + end) / 100;
            ArrayList<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                //0-2000 个计算任务 * 100
                CountTask subTask = new CountTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();// fork
            }

            for (CountTask t : subTasks) {
                sum += t.join();
            }
        }

        return sum;
    }
}
