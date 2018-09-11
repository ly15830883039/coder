package rui.coder.foundation.concurrent.threadManagement;


import java.util.Date;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 守护线程的创建和运行
 * Created by 赵睿 on 2017/2/17.
 */
public class CeatingAndRunningDaemonThread {



    public static void main(String[] args) throws InterruptedException {
        Deque<Event> deque=new LinkedBlockingDeque<>();
        WriterTask writerTask=new WriterTask(deque);


        for (int i = 0; i < 3; i++) {
            Thread thread=new Thread(writerTask);
            thread.start();
        }
        CleanerTask cleanerTask=new CleanerTask(deque);
        cleanerTask.start();
    }
}

class WriterTask implements Runnable{
    private Deque<Event> deque;

    WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event=new Event();
            event.setDate(new Date());
            event.setEvent(String.format("线程 %s 生成了一个时间",Thread.currentThread().getId()));
            deque.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class CleanerTask extends Thread{
    private Deque<Event> deque;

    CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        //让此线程成为守护线程
        setDaemon(true);
    }

    @Override
    public void run() {
        while(true){
            clean(new Date());
        }

        }
    /**
     * 获取最后的事件，
     *  如果它在10秒前被创建，就删除它并查看下一个事件。
     *  如果一个事件被删除，它会写一个事件信息和queue的新的大小，
     * @param date 清理者运行时间
     */
    private void clean(Date date) {
        long difference;
        boolean delete;
        if(deque.size()==0){
            return;
        }
        delete=false;
        do{
           Event e=deque.getLast();
           difference=date.getTime()-e.getDate().getTime();
           if(difference>10000){
               System.out.printf("Cleaner :%s\n",e.getEvent());
               deque.removeLast();
               delete=true;
           }
        }while (difference>100000);

        if(delete){
            System.out.printf("Cleaner: 队列大小为 ： %d \n" ,deque.size());
        }
    }
}

class Event{
    private Date date;
    private String event;

    Date getDate() {
        return date;
    }

    void setDate(Date date) {
        this.date = date;
    }

    String getEvent() {
        return event;
    }

    void setEvent(String event) {
        this.event = event;
    }
}
