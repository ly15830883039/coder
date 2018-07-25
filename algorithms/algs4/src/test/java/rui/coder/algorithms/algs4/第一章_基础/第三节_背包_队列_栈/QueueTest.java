package rui.coder.algorithms.algs4.第一章_基础.第三节_背包_队列_栈;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import rui.coder.algorithms.algs4.第一章_基础.第三节_背包_队列_栈.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<String> queue = new Queue<>();

    @Nested
    class IsEmpty {

        @Test
        void isEmpty() {
            assertTrue(queue.isEmpty());
        }

        @Test
        void size() {
            assertSame(0, queue.size());
        }

        @SuppressWarnings("WhileLoopReplaceableByForEach")
        @Test
        void iterator() {
            Iterator iterator = queue.iterator();
            while (iterator.hasNext()) {
                assertNull(iterator.next());
            }
        }

        @Test
        void forEach() {
            for (String s : queue) {
                assertNull(s);
            }
        }

        @Test
        void toStringTest() {
            assertEquals("Queue{[]}", queue.toString());
        }

        @Test
        void peek() {
            assertThrows(NoSuchElementException.class, () ->
                    queue.peek());
        }

        @Test
        void enqueue() {
            queue.enqueue("TEST");
            assertSame(1, queue.size());
        }

        @Test
        void dequeue() {
            assertThrows(NoSuchElementException.class, () ->
                    queue.dequeue());
        }
    }

    @Nested
    class addMuch {

        private int size = 100;

        @BeforeEach
        void setUp() {
            IntStream.range(0, size)
                    .forEach(value ->
                            queue.enqueue(value+""));
        }

        @Test
        void isEmpty() {
            assertFalse(queue.isEmpty());
        }

        @Test
        void size() {
            assertSame(100, queue.size());
        }

        @Test
        void iterator() {
            Iterator iterator = queue.iterator();

            int i = 0;
            while (iterator.hasNext()) {
                assertNotNull(iterator.next());
                i++;
            }

            assertSame(size, i);
        }

        @Test
        void foreach() {
            int i = 0;
            for (String s : queue) {
                assertNotNull(s);
                i++;
            }
            assertSame(size, i);
        }

        @Test
        void toStringTest() {
            assertNotEquals("Queue{[]}", queue.toString());
        }

        @Test
        void peek() {
            assertNotNull(queue.peek());
            assertSame(size,queue.size());
        }

        @Test
        void enqueue() {
            queue.enqueue("TEST");
            assertSame(size+1, queue.size());
        }

        @Test
        void dequeue() {
            queue.forEach(Assertions::assertNotNull);
        }

        @Test
        void forEach() {
            queue.forEach(System.out::println);
        }
    }
}