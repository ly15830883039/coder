package rui.coder.foundation.concurrent.threadManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 使用线程工厂创建线程
 * Created by 赵睿 on 2017/2/17.
 */
public class CreatingThreadsByThreadFactory {

    public static void main(String[] args) {
        MyThreadFactory myThreadFactory=new MyThreadFactory("我的线程工厂");
        FactoryTask factoryTask=new FactoryTask();

        Thread thread;
        System.out.println("开始创建多个线程");
        for (int i = 0; i < 10; i++) {
            thread=myThreadFactory.newThread(factoryTask);
            thread.start();
        }
        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n",myThreadFactory.getStats());

    }




}

class MyThreadFactory implements ThreadFactory{
    private int counter;
    private String name;
    List<String> stats;

    public MyThreadFactory(String name) {
        counter=0;
        this.name = name;
        stats=new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t=new Thread(r,name+"-Thread_"+counter);
        counter++;
        stats.add(String.format("created thread %d with name %s on %s\n",t.getId(),t.getName(),new Date()));
        return t;
    }

    public String getStats(){
        StringBuffer buffer=new StringBuffer();
        Iterator<String> it=stats.iterator();
        while(it.hasNext()){
            buffer.append(it.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}

class  FactoryTask implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
