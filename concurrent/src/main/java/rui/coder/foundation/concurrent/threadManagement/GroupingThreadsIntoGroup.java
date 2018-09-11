package rui.coder.foundation.concurrent.threadManagement;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 线程组
 * Created by 赵睿 on 2017/2/17.
 */
public class GroupingThreadsIntoGroup {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result=new Result();
        SearchTask searchTask=new SearchTask(result);


        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(threadGroup,searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("线程组的数量: %d\n",threadGroup.activeCount());
        System.out.printf("线程组详情 ：\n");
        threadGroup.list();


        Thread[] threads=new Thread[threadGroup.activeCount()];
        //复制该线程组及其子组中的所有活动线程到指定的数组。
        threadGroup.enumerate(threads);
        for (int i=0; i<threadGroup.activeCount(); i++) {
            System.out.println(threadGroup.activeCount());
            System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
        }

        waitFinish(threadGroup);
        threadGroup.interrupt();
    }


    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount()>9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SearchTask implements Runnable{

    private Result result;

    SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        System.out.printf("Thread %s: Start\n",name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n",name);
            return;
        }
        System.out.printf("Thread %s: End\n",name);

    }

    private void doTask() throws InterruptedException {
        Random random=new Random((new Date()).getTime());
        int value=(int)(random.nextDouble()*100);
        System.out.printf("Thread %s: %d\n",Thread.currentThread(). getName(),value);
        TimeUnit.SECONDS.sleep(value);
    }

}

class Result{
    private String name;
    void setName(String name) {
        this.name = name;
    }
}
