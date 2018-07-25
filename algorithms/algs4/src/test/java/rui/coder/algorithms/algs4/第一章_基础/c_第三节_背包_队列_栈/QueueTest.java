package rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈.Queue;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈.Queue<String> queue = new java.util.Queue<>();


    @Test
    void enqueue () {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(UUID.randomUUID().toString());
        }
        assertSame(10,queue.size());
    }

    @Test
    void toStringMethod(){
        List<String> stringList=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String random=UUID.randomUUID().toString();
            stringList.add(random);
            queue.enqueue(random);
        }
        assertEquals(stringList.toString(),queue.toString());
    }

    @Nested
    class dequeue{

        @Test
        void noSuchElementException() {
            NoSuchElementException noSuchElementException= assertThrows(NoSuchElementException.class,() -> queue.dequeue());
            assertEquals("空队列",noSuchElementException.getMessage());
        }

        @Test
        void dequeue() {
            List<String> stringList=new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                String random=UUID.randomUUID().toString();
                stringList.add(random);
                queue.enqueue(random);
            }

            assertSame(10,queue.size());
            for (int i = 0; i < 10; i++) {
                String uuid=queue.dequeue();
                assertEquals(stringList.get(i),uuid);
            }

        }
    }

    @Nested
    class iterator{

        List<String> stringList=new ArrayList<>();
        @BeforeEach
        void setUp() {
            for (int i = 0; i < 10; i++) {
                String random=UUID.randomUUID().toString();
                stringList.add(random);
                queue.enqueue(random);
            }
        }

        @Test
        void remove() {
           UnsupportedOperationException unsupportedOperationException=assertThrows(UnsupportedOperationException.class,()->  queue.iterator().remove());
           assertEquals("不支持移除操作",unsupportedOperationException.getMessage());
        }

        @Test
        void next() {
            int i=0;
            Iterator<String> iterator=queue.iterator();
            while(iterator.hasNext()){
                String uuid=iterator.next();
                assertEquals(stringList.get(i++),uuid);
            }
        }

        @Test
        void noNext_stillUseNest() {
            Iterator<String> iterator=queue.iterator();
            while(iterator.hasNext()){
               iterator.next();
            }
            NoSuchElementException noSuchElementException=assertThrows(NoSuchElementException.class,()->iterator.next());
            assertEquals("迭代器已经没有下一个了",noSuchElementException.getMessage());
        }
        
        @Test
        void foreach(){
            int i=0;
            for (String s : queue) {
                assertEquals(stringList.get(i++),s);
            }
        }
    }

}