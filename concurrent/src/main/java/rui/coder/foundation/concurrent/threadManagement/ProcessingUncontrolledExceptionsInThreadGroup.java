package rui.coder.foundation.concurrent.threadManagement;

import java.util.Random;

/**
 * 处理线程组内不受控制的异常
 * Created by 赵睿 on 2017/2/17.
 */
public class ProcessingUncontrolledExceptionsInThreadGroup {

    public static void main(String[] args) {
        MyThreadGroup threadGroup=new MyThreadGroup("MyThreadGroup");
        GroupTask task=new GroupTask();
        for (int i = 0; i < 2; i++) {
            Thread t=new Thread(threadGroup,task);
            t.start();
        }

    }


}
class MyThreadGroup extends ThreadGroup {
    MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("线程 %s 抛出了一个异常\n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();
    }
}
class GroupTask implements Runnable{

    @Override
    public void run() {
        int result;
        Random random=new Random(Thread.currentThread().getId());
        while (true) {
            result=1000/((int)(random.nextDouble()*1000));
            System.out.printf("%s : %d\n",Thread.currentThread().getId(),result);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n",Thread.currentThread().getId());
                return;
            }
        }

    }
}
