package rui.coder.foundation.jdk8.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 赵睿
 */
class OptionalTest {


    private String value="TEST";
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional empty=Optional.empty();
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    private Optional<String> have=Optional.of(value);

    @Nested
    class create{
        @SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
        @Test
        void of() {
            Optional.of("TEST");
            Assertions.assertThrows(NullPointerException.class, () -> Optional.of(null));
        }

        @SuppressWarnings("ConstantConditions")
        @Test
        void ofNullable(){
            Optional empty=Optional.ofNullable(null);
            assertFalse(empty.isPresent());
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void isPresent(){
        assertFalse(empty.isPresent());
        assertTrue(have.isPresent());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void get() {
        assertThrows(NoSuchElementException.class,()-> empty.get());
        assertEquals(value,have.get());
    }

    @Nested
    @DisplayName("逻辑")
    class logic{

        @SuppressWarnings({"unchecked", "Convert2MethodRef"})
        @Test
        void ifPresent() {
            empty.ifPresent((value) -> assertNotNull(value));
            have.ifPresent((value1) -> assertEquals(value,value1));
        }

        @SuppressWarnings("unchecked")
        @Test
        void orElse() {
            String value2="value2";
            assertEquals(value2,empty.orElse(value2));
            assertEquals(value,have.orElse(value2));
        }

        @SuppressWarnings({"unchecked", "ExcessiveLambdaUsage"})
        @Test
        void orElseGet() {
            String value2="value2";
            assertEquals(value2,empty.orElseGet(()-> value2));
            assertEquals(value,have.orElseGet(()-> value2));
        }

        @Test
        void orElseThrow() {
            assertThrows(NoClassDefFoundError.class,()-> empty.orElseThrow(NoClassDefFoundError::new));
            have.orElseThrow(NoClassDefFoundError::new);
        }
    }

    @Nested
    @DisplayName("数据处理")
    class dataProcess{
        @SuppressWarnings("Convert2MethodRef")
        @Test
        void map() {
            Optional<String> lower = have.map((value) -> value.toLowerCase());
            assertEquals(value.toLowerCase(),lower.orElse("No"));
        }

        @Test
        void flatMap() {
            Optional<String> lower =have.flatMap(s -> Optional.of(s.toLowerCase()));
            assertEquals(value.toLowerCase(),lower.orElse("No"));
        }

        @Test
        void filter() {
            Optional<String> filter=have.filter(s -> s.equals(value.toLowerCase()));
            assertFalse(filter.isPresent());
            filter=have.filter(s -> s.equals(value));
            assertTrue(filter.isPresent());
        }
    }
}
