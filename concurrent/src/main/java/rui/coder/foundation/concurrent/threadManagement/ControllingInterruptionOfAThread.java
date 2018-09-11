package rui.coder.foundation.concurrent.threadManagement;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 操作线程的中断机制
 * Created by 赵睿 on 2017/2/16.
 */
public class ControllingInterruptionOfAThread {
    public static void main(String[] args) {
        FileSearch fileSearch=new FileSearch("D:\\","log.txt");
        Thread thread=new Thread(fileSearch);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

}

class FileSearch implements Runnable{
    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file=new File(initPath);
        if(file.isDirectory()){
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.printf("%s: 搜索工作被打断！",Thread.currentThread().getName());
            }
        }
    }
    private void directoryProcess(File file) throws InterruptedException {
       File list[] =file.listFiles();
       if(list!=null){
           for (int i = 0; i < list.length; i++) {
               if(list[i].isDirectory()){
                   directoryProcess(list[i]);
               }else {
                   fileProcess(list[i]);
               }
           }
       }
       if(Thread.interrupted()){
           throw new InterruptedException();
       }
    }

    private void fileProcess(File file) throws InterruptedException {
        if(file.getName().equals(fileName)){
            System.out.printf("%s  : %s\n",Thread.currentThread().getName(),file.getAbsolutePath());
        }
        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }
}
