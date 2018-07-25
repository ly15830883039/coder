package rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈.Bag;

import java.util.Iterator;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    private Bag<String> bag=new Bag<>();

    @Nested
    class IsEmpty{

        @Test
        void isEmpty() {
           assertTrue( bag.isEmpty());
        }

        @Test
        void size() {
            assertSame(0, bag.size());
        }

        @SuppressWarnings("WhileLoopReplaceableByForEach")
        @Test
        void iterator() {
            Iterator iterator=bag.iterator();
            while (iterator.hasNext()){
                assertNull(iterator.next());
            }
        }

        @Test
        void forEach() {
            for (String s : bag) {
                assertNull(s);
            }
        }
    }

    @Nested
    class addMuch{

        private int size=100;

        @BeforeEach
        void setUp() {
            IntStream.range(0,size)
                    .forEach(value ->
                            bag.add(UUID.randomUUID().toString()));
        }

        @Test
        void isEmpty() {
            assertFalse(bag.isEmpty());
        }

        @Test
        void size() {
            assertSame(100,bag.size());
        }

        @Test
        void iterator() {
            Iterator iterator=bag.iterator();

            int i=0;
            while(iterator.hasNext()){
                assertNotNull(iterator.next());
                i++;
            }

            assertSame(size,i);
        }

        @Test
        void foreach() {
            int i=0;
            for (String s : bag) {
                assertNotNull(s);
                i++;
            }
            assertSame(size,i);
        }
    }

}