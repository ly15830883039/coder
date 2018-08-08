package rui.coder.foundation.collection.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMap {

    @Test
    void t(){
        Stream.of("tye","helll eee")
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .forEach(System.out::println);
    }
}
