package rui.coder.foundation.concurrent.threadManagement;

/**
 * 处理线程中的不受控制的异常
 * Created by 赵睿 on 2017/2/17.
 */
public class ProcessingUncontrolledExceptionInThread {
    public static void main(String[] args) {
        Thread thread=new Thread(new Task());
        /*
        当一个未捕捉的异常在线程里被抛出，JVM会寻找此异常的3种可能潜在的处理者（handler）。

            首先, 它寻找这个未捕捉的线程对象的异常handle，这个例子。
            如果这个handle 不存在，那么JVM会在线程对象的ThreadGroup里寻找非捕捉异常的handler，如在处理线程组内的不受控制异常里介绍的那样。
            如果此方法不存在，那么 JVM 会寻找默认非捕捉异常handle。
         */
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}


class Task implements Runnable{

    @Override
    public void run() {
        Integer.parseInt("or");
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("一个线程被捕捉到了！ \n");
        System.out.printf("Thread : %s \n",t.getId());
        System.out.printf("Exception : %s: %s \n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status : %s \n",t.getState());
    }
}
