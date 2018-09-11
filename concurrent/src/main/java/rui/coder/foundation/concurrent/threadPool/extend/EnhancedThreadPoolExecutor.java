package rui.coder.foundation.concurrent.threadPool.extend;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a href="http://blog.csdn.net/linsongbin1/article/details/78275283">扩展ThreadPoolExecutor的一种办法</a>
 * <p>
 * <ol>
 * <li>core线程还能应付的,则不断的创建新的线程;</li>
 * <li>core线程无法应付,则将任务扔到队列里面;</li>
 * <li>队列满了(意味着插入任务失败),则开始创建MAX线程.</li>
 * <li> 线程数达到MAX后,队列还一直是满的,则抛出RejectedExecutionException.</li>
 * </ol>
 */
public class EnhancedThreadPoolExecutor extends ThreadPoolExecutor {
    EnhancedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime
            , TimeUnit unit, TaskQueue taskQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, taskQueue);
        taskQueue.setExecutor(this);
    }

    /**
     * 计数器,用于表示已经提交到队列里面的task的数量,这里task特指还未完成的task。
     * 当task执行完后,submittedTaskCount会减1的。
     */

    private final AtomicInteger submittedTaskCount = new AtomicInteger(0);

    public int getSubmittedTaskCount() {
        return submittedTaskCount.get();
    }


    /**
     * 当task 执行完成之后，计数器减1
     */
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        //super 没有任何操作，只是保留一个可供覆盖扩展点
        submittedTaskCount.decrementAndGet();
    }

    @Override
    public void execute(Runnable command) {
        submittedTaskCount.incrementAndGet();
        try {
            super.execute(command);
        } catch (RejectedExecutionException e) {
            //当发生RejectedExecutionException,
            // 尝试再次将task丢到队列里面,如果还是发生RejectedExecutionException,则直接抛出异常。
            BlockingQueue<Runnable> taskQueue = super.getQueue();
            if (taskQueue instanceof TaskQueue) {
                forceTaskIntoQueue(command, (TaskQueue) taskQueue);
            } else {
                submittedTaskCount.decrementAndGet();
                throw e;
            }

        }
    }

    /**
     * 将 线程强制塞如队列，如果失败，抛出异常
     */
    private void forceTaskIntoQueue(Runnable command, TaskQueue taskQueue) {
        if (!taskQueue.forceTaskIntoQueue(command)) {
            submittedTaskCount.decrementAndGet();
            throw new RejectedExecutionException("队列已满");
        }
    }
}
