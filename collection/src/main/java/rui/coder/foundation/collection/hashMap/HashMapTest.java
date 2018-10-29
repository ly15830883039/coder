package rui.coder.foundation.collection.hashMap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class HashMapTest {

    HashMap<MockKey, String> hashMap = new HashMap<>();

    @Test
    void case1() {
        for (int i = 0; i <= 1000; i++) {
             put(i);
        }
    }

    public void put(int i){
        int hash=i*16+1;
        hashMap.put(new MockKey(hash),hash+"");
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    public static class MockKey {
        private int key;
    }
}
