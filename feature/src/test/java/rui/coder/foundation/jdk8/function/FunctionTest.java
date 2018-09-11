package rui.coder.foundation.jdk8.function;

import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

class FunctionTest {

    @Test
    void name() {
        BiConsumer<T, U> biConsumer = (T t, U u) ->
                System.out.println(String.format("BiConsumer receive -- > %s+%s", t, u));

        BiConsumer<T, U> biConsumer2 = (T t, U u) ->
                System.out.println(String.format("biConsumer2 receive-->%s+%s", t, u));

        biConsumer.andThen(biConsumer2).accept(new T(), new U());
    }


    static class T {
        @Override
        public String toString() {
            return "T";
        }
    }

    static class U {
        @Override
        public String toString() {
            return "U";
        }
    }

    static class W {
        @Override
        public String toString() {
            return "W";
        }
    }

    static class R {
        @Override
        public String toString() {
            return "R";
        }
    }
}