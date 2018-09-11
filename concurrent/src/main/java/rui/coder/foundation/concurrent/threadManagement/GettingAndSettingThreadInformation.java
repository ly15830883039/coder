package rui.coder.foundation.concurrent.threadManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Thread.currentThread;

/**
 * 获取和设置线程信息
 * http://ifeve.com/thread-management-3/
 * Created by 赵睿 on 2017/2/16.
 */
public class GettingAndSettingThreadInformation {
    private static int threadCount=10;

    private static Thread threads[] =new Thread[threadCount];
    private static Thread.State states[]=new Thread.State[threadCount];

    public static void main(String[] args) {
        initThread();

        FileWriter fileWriter;
        PrintWriter pw=null;

        try {
            String logPath = "D:/logs/concurrent/log.txt";
            fileWriter=new FileWriter(logPath);
            pw=new PrintWriter(fileWriter);
            for (int i = 0; i < 10; i++) {
                pw.println("Main: status of Thread "+ i +":" +threads[i].getState());
                states[i]=threads[i].getState();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <10 ; i++) {
            threads[i].start();
        }
        isFinished(threads, states, pw);
    }

    private static void initThread(){
        for (int i = 0; i < 10; i++) {
            threads[i]=new Thread(new Calculator(i));
            setThreadPriority(i);
            threads[i].setName("Thread"+i);
        }
    }

    private static void setThreadPriority(int threadsNo){
        if((threadsNo%2)==0){
            threads[threadsNo].setPriority(Thread.MAX_PRIORITY);
        }else{
            threads[threadsNo].setPriority(Thread.MIN_PRIORITY);
        }
    }


    private static void isFinished(Thread[] threads, Thread.State[] states, PrintWriter pw) {
        boolean finish=false;
        while(!finish){
            for (int i = 0; i <10 ; i++) {
                if(threads[i].getState()!=states[i]){
                    writeThreadInfo(pw,threads[i],states[i]);
                    states[i]=threads[i].getState();
                }
            }
            finish=true;
            for (int i = 0; i < 10; i++) {
                finish=finish &&(threads[i].getState()== Thread.State.TERMINATED);
            }
        }
        pw.flush();
        pw.close();
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        pw.printf("Main: Id %d -%s \n", thread.getId(),thread.getName());
        pw.printf("Main: 优先级别：%d\n",thread.getPriority());
        pw.printf("Main: Old Status：%s\n",state);
        pw.printf("Main: new Status：%s \n",thread.getState());
        pw.printf("***************************************\n");
    }
}

class Calculator implements Runnable {
    private int number;

    Calculator(int number) {
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            // 计算 1-10 * 成员变量的number
            System.out.printf("%s: %d * %d = %d\n", currentThread().getName(), number, i, i * number);
        }
    }
}
