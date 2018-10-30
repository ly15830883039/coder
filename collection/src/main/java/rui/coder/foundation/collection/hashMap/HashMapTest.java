package rui.coder.foundation.collection.hashMap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertFalse;

class HashMapTest {

    private HashMap<MockKey, String> hashMap = new HashMap<>();

    @Test
    @DisplayName("查看put的逻辑，往一个桶中放入，然后出现resize的操作")
    void case1() {
        for (int i = 0; i <= 1000; i++) {
            put(i);
        }

        System.out.println(hashMap);
        hashMap.forEach((mockKey, s) -> {
            System.out.println("key -->  " + mockKey);
            System.out.println("value -->" + s);
        });
    }

    private void put(int i) {
        int hash = i * 16 + 1;
        hashMap.put(new MockKey(hash), hash + "");
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class MockKey {
        private int key;
    }


    @Test
    @DisplayName("并发put，查看是否线程安全")
    void currentPut() throws InterruptedException {
        hashMap = new HashMap<>(2048);
        AtomicInteger atomicInteger=new AtomicInteger(0);

        CountDownLatch countDownLatch=new CountDownLatch(2);

        new Thread(() -> {
            while (atomicInteger.get()<=1000){
                put(atomicInteger.getAndIncrement());
            }
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            while (atomicInteger.get()<=1000){
                put(atomicInteger.getAndIncrement());
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();

        assertFalse(hashMap.size()==1000);
    }

}
