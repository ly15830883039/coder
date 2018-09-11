package rui.coder.foundation.concurrent.threadPool.extend;

import lombok.Setter;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;


public class TaskQueue extends LinkedBlockingQueue<Runnable> {
    @Setter
    private EnhancedThreadPoolExecutor executor;

    TaskQueue(int capacity) {
        super(capacity);
    }

    /**
     * 强制将 任务刷新到队列中
     */
    public boolean forceTaskIntoQueue(Runnable o) {
        if (executor.isShutdown()) {
            throw new RejectedExecutionException("Executor已经关闭了,不能将task添加到队列里面");
        }
        return super.offer(o);
    }

    @Override
    public boolean offer(Runnable runnable) {
        int currentThreadSize = executor.getPoolSize();

        //如果线程数中的线程已经达到了最大线程数，将任务添加到队列中。
        if (currentThreadSize == executor.getMaximumPoolSize()) {
            return super.offer(runnable);
        }

        //有空闲的线程，这个时候无需创建线程，见那个任务丢到队列中。
        if (currentThreadSize < executor.getSubmittedTaskCount()) {
            return super.offer(runnable);
        }

        //如果线程池里的线程数量还没有到达最大,直接创建线程,而不是把任务丢到队列里面
        return currentThreadSize >= executor.getMaximumPoolSize() && super.offer(runnable);
    }
}
