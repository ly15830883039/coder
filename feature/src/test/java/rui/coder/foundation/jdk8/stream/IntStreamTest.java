package rui.coder.foundation.jdk8.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * {@link IntStream}
 * 一个顺序的
 */
@DisplayName("IntStream int 流的测试")
class IntStreamTest {

    @DisplayName("生成斐波那契数")
    @Test
    void generateFibonacciSequence() {
        IntStream.iterate(1, new IntUnaryOperator() {

            private int prev = 0;

            @Override
            public int applyAsInt(int operand) {
                int temp = operand + prev;
                prev = operand;
                return temp;
            }
        })
                .limit(20)
                .forEach(System.out::println);
    }
}