package rui.coder.foundation.jdk7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Phaser;

import static org.junit.jupiter.api.Assertions.*;

class Jdk7PhaserTest {
    private final static Logger logger = LoggerFactory.getLogger(Jdk7Phaser.class);

    @DisplayName("控制多个线程的启动时机：以期获得最大程度的并发。也可通过 CountDownLatch实现")
    @Test
    void arriveAndAwaitAdvance() {
        final int count = 5;
        final Phaser phaser = new Phaser(count);
        for (int i = 0; i < count; i++) {
            logger.info("启动线程，id:{}", i);
            final Thread thread = new Thread(new Task(i, phaser));
            thread.start();
        }
    }


    @Test
    @DisplayName("当其他条件满足，方才开始任务执行")
    void arriveAndDeregister() throws IOException, InterruptedException {
        final Phaser phaser = new Phaser(1);
        for (int i = 0; i < 5; i++) {
            phaser.register();
            logger.info("开始线程id为{}", i);
            final Thread thread = new Thread(new Task(i, phaser));
            thread.start();
        }
        logger.info("卡住不让主程序走，时间：{}", new Date().getTime());
        Thread.sleep(1000);
        logger.info("允许其他线程执行，，时间：{}", new Date().getTime());
        phaser.arriveAndDeregister();
    }

    @Test
    @DisplayName("障碍操作，只有满足条件才会停止，类似CyclicBarrier")
    void barrierAction() throws InterruptedException {
        final int count =5;
        final int phaseToTerminate=3;
        final Phaser phaser=new Phaser(count){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                logger.info("========{}======",phase);
                return phase>=phaseToTerminate||registeredParties==0;
            }
        };

        for (int i = 0; i < count; i++) {
            logger.info("开始线程id为{}", i);
            final Thread thread = new Thread(new Task2(i, phaser));
            thread.start();
        }
        phaser.register();
        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }
        logger.info("执行完成");
    }



    public static class Task implements Runnable {

        final int id;
        final Phaser phaser;

        Task(int id, Phaser phaser) {
            this.id = id;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            logger.info("在Task.run() 到达, phase:{},id:{},时间：{}", phaser.getPhase(), this.id, new Date().getTime());
            phaser.arriveAndAwaitAdvance();
            logger.info("在Task.run() 结束, phase:{},id:{},时间：{}", phaser.getPhase(), this.id, new Date().getTime());
        }
    }

    public static class Task2 extends Task{

        Task2(int id, Phaser phaser) {
            super(id, phaser);
        }

        @Override
        public void run() {
            do {
                logger.info("在Task.run() 到达, phase:{},id:{},时间：{}", phaser.getPhase(), this.id, new Date().getTime());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("在Task.run() sleep, phase:{},id:{},时间：{}", phaser.getPhase(), this.id, new Date().getTime());
                phaser.arriveAndAwaitAdvance();
                logger.info("在Task.run() 结束, phase:{},id:{},时间：{}", phaser.getPhase(), this.id, new Date().getTime());
            }while (!phaser.isTerminated());
        }
    }
}