package rui.coder.foundation.concurrent.jdk5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConcurrentHashMapTest {


    /*

     */
    private ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    @Nested
    class notAllowNull{
        @Test
        void key() {
            assertThrows(NullPointerException.class,()->{
                concurrentHashMap.put(null,"123");
            });

        }
        @SuppressWarnings({"unchecked", "ConstantConditions"})
        @Test
        void value() {
            assertThrows(NullPointerException.class,()->{
                concurrentHashMap.put("123",null);
            });

        }
    }


}
