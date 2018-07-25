package rui.coder.foundation.collection.hashset;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 对 {@link HashSet} 的一些测试和验证
 * @author 赵睿
 */
class HashSetTest {


    @Test
    void contains() {
        HashSet<Integer> hashSet=new HashSet<Integer>();

        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        assertTrue(hashSet.contains(1));
        assertTrue(hashSet.contains(2));
        assertTrue(hashSet.contains(3));


    }
}
