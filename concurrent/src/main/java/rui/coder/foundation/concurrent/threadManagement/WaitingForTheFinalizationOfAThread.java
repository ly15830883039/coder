package rui.coder.foundation.concurrent.threadManagement;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 等待线程终结
 * Created by 赵睿 on 2017/2/17.
 */
public class WaitingForTheFinalizationOfAThread {

    public static void main(String[] args) {
        Thread dataSourceLoaderThread=new Thread(new DataSourceLoader());
        Thread networkConnectionsLoaderThread=new Thread(new NetworkConnectionsLoader());

        dataSourceLoaderThread.start();
        networkConnectionsLoaderThread.start();

        try {
            /*
                java 提供2种形式的 join() 方法:
                    join (long milliseconds)
                    join (long milliseconds, long nanos)
                    第一种join() 方法, 这方法让调用线程等待特定的毫秒数。例如，如果thread1对象使用代码thread2.join(1000), 那么线程 thread1暂停运行，直到以下其中一个条件发生：
                        thread2 结束运行
                        1000 毫秒过去了
                        当其中一个条件为真时，join() 方法返回。

                    第二个版本的 join() 方法和第一个很像，只不过它接收一个毫秒数和一个纳秒数作为参数。
             */

            dataSourceLoaderThread.join();
            networkConnectionsLoaderThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main : 配置已经导入成功：%s\n",new Date());
    }

}

class DataSourceLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("开始数据源导入: %s \n",new Date());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("数据源导入成功： %s\n",new Date());
    }
}

class NetworkConnectionsLoader implements Runnable{

    @Override
    public void run() {
        System.out.printf("开始进行网络连接： %s\n",new Date());

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("网络连接完成： %s\n",new Date());
    }
}