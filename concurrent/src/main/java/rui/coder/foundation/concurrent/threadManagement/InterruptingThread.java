package rui.coder.foundation.concurrent.threadManagement;

/**
 * 线程的中断
 * Created by 赵睿 on 2017/2/16.
 */
public class InterruptingThread {

    public static void main(String[] args) {
        Thread thread=new PrimeGenerator();
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
            Thread 类有一个boolean类型的属性来表明线程是否被中断。当你调用线程的interrupt() 方法，就代表你把这个属性设置为 true。 而isInterrupted() 方法仅返回属性值
         */
        thread.interrupt();

    }

}

class PrimeGenerator extends Thread{
    @Override
    public void run() {
        long number=1L;
        while(true){
            if(isPrimes(number)){
                System.out.printf("Number %d 是一个素数\n",number);
            }
            if(isInterrupted()){
                System.out.println("该素数生成器已经被中断！");
                return;
            }
            number++;
        }
    }

    /**
     * 是否为一个素数
     * @param number 数
     * @return true 为素数，false为非素数
     */
    private boolean isPrimes(long number){
        //如果一个数不能被从2开始，到其开放数不能被整除，即为一个素数
        for (int i = 2; i <=Math.sqrt(number) ; i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}