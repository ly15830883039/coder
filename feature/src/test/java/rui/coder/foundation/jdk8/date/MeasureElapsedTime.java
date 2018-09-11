package rui.coder.foundation.jdk8.date;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * 测量时间
 *
 * @author 赵睿
 */
class MeasureElapsedTime {

    @DisplayName("简单测量")
    @Nested
    class SimpleMeasurements {

        /**
         * 问题： 1.基于系统时间，如果中间存在修改时间的之类的操作，会导致时间不准确。
         *
         * @throws InterruptedException 。。。
         */
        @Test
        void currentTimeMillis() throws InterruptedException {
            long start = System.currentTimeMillis();
            Thread.sleep(100);
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            System.out.println(timeElapsed);
        }

        /**
         * nanoTime 是返回纳秒时间。
         * 问题和 currentTimeMillis 相同，但是上述返回的是毫秒数，这个是纳秒数。
         *
         * @throws InterruptedException 。。。
         */
        @Test
        void nanoTime() throws InterruptedException {
            long start = System.nanoTime();
            Thread.sleep(100);
            long finish = System.nanoTime();
            long timeElapsed = finish - start;
            System.out.println(timeElapsed);
        }
    }

    @Nested
    class java8 {

        /**
         * 获得实时值，然后做对比
         */
        @Test
        void instant() throws InterruptedException {
            Instant start = Instant.now();
            Thread.sleep(100);
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            System.out.println(timeElapsed);

        }


    }

    @DisplayName("秒表")
    @Nested
    class stopWatch {
        @Test
        void measureElapsed() throws InterruptedException {
            StopWatch watch = new StopWatch();
            watch.start();

            Thread.sleep(100);
            watch.start();
            System.out.println(watch.getNanoTime());
            System.out.println(watch.getTime());
        }
    }


}
