package rui.coder.foundation.jdk8.stream.parallelSteam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DisplayName("测试")
class Test2 {
    private AtomicInteger i = new AtomicInteger();
    private List<Integer> list = IntStream.generate(i::getAndIncrement)
            .limit(100000)
            .boxed()
            .collect(Collectors.toList());

    @Test
    @DisplayName("统计并发流中的线程数")
    void parallelThreadSize() {
        parallelThread();
    }

    private Set<Thread> parallelThread() {
        Set<Thread> threadSet=new CopyOnWriteArraySet<>();

        list.parallelStream().forEach(integer -> {
            Thread thread=Thread.currentThread();
            threadSet.add(thread);
        });

        System.out.println("threadSet一共有" + threadSet.size() + "个线程");
        System.out.println("系统一个有"+Runtime.getRuntime().availableProcessors()+"个cpu");
        return threadSet;
    }

    @Test
    void name() throws InterruptedException {
        Set<Thread> threadSet=parallelThread();

        Set<Thread> threadSetTwo=new CopyOnWriteArraySet<>();

        CountDownLatch countDownLatch=new CountDownLatch(2);

        Thread threadA=newThread(threadSetTwo,countDownLatch);

        Thread threadB = newThread(threadSetTwo,countDownLatch);

        threadA.start();
        threadB.start();

        countDownLatch.await();

        System.out.print("threadSetTwo一共有" + threadSetTwo.size() + "个线程");

        System.out.println("---------------------------");
        System.out.println(threadSet);
        System.out.println(threadSetTwo);
        System.out.println("---------------------------");
        threadSetTwo.addAll(threadSet);
        System.out.println(threadSetTwo);
        System.out.println("threadSetTwo一共有" + threadSetTwo.size() + "个线程");
        System.out.println("系统一个有"+Runtime.getRuntime().availableProcessors()+"个cpu");
    }


    private Thread newThread(Set<Thread> threadSet,CountDownLatch countDownLatch){
        List<Integer> list = IntStream.generate(i::getAndIncrement)
                .limit(100000)
                .boxed()
                .collect(Collectors.toList());

        return  new Thread(() -> {
            list.parallelStream().forEach(integer -> {
                Thread thread = Thread.currentThread();
                threadSet.add(thread);
            });
            countDownLatch.countDown();
        });
    }
}
