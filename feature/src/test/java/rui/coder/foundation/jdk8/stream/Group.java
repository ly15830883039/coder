package rui.coder.foundation.jdk8.stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("分组测试")
class Group {
    private Stream stream;
    private int size=10;
    @BeforeEach
    void setUp() {
        AtomicInteger atomicInteger=new AtomicInteger();

        stream=Stream.generate(atomicInteger::getAndIncrement)
                .limit(100);
    }

    @Test
    void groupingBy() {
        AtomicInteger finalAtomicInteger = new AtomicInteger();
        AtomicInteger group=new AtomicInteger();
        @SuppressWarnings("unchecked") HashMap o1= (HashMap) stream.collect(Collectors.groupingBy(o -> {
           if( finalAtomicInteger.getAndIncrement()%size==size-1){
               return group.getAndIncrement();
           }
           return group.get();
        }));
        System.out.println(o1);
    }
}
