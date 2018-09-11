package rui.coder.foundation.jdk8.stream.parallelSteam;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.joda.time.DateTime.now;

@DisplayName("并发流： 循环打印")
class ForEachPrint {
    private int size = 10000;

    private int cycle = 100;

    private List<Integer> numbers = IntStream.iterate(1, operand -> operand + 1)
            .limit(size)
            .boxed()
            .collect(toList());

    private DateTime start;


    @BeforeEach
    void setUp() {
        start = now();
    }

    @Test
    @DisplayName("并发流 并发打印")
    void parallel() {
        for (int i = 0; i < cycle; i++) {
            numbers.parallelStream()
                    .forEach(System.out::println);
        }
        //耗时为 ： 68
    }

    @Test
    @DisplayName("并发流，顺序输出")
    void forEachOrdered() {
        for (int i = 0; i < cycle; i++) {
            numbers.parallelStream()
                    .forEachOrdered(System.out::println);
            //耗时为 ： 52
        }
    }

    @Test
    @DisplayName("正常流，输出")
    void generate() {
        for (int i = 0; i < cycle; i++) {
            numbers.forEach(System.out::println);
        }
        //耗时为 ： 53
    }

    @SuppressWarnings("SimplifyStreamApiCallChains")
    @Test
    @DisplayName("正常流，顺序输出")
    void generateOrder() {
        for (int i = 0; i < cycle; i++) {
            numbers.stream()
                    .forEachOrdered(System.out::println);
        }
        //耗时为 ： 50
    }

    @AfterEach
    void tearDown() {
        DateTime end = now();

        long cost = new Duration(start, end).getMillis();

        System.out.println("耗时为 ： " + cost / cycle);
    }

}
