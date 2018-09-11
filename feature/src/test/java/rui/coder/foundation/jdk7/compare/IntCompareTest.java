package rui.coder.foundation.jdk7.compare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class IntCompareTest {

    @Test
    void compare() {
        assertSame(-1,Integer.compare(0,1));
        assertSame(0,Integer.compare(1,1));
        assertSame(1,Integer.compare(1,0));
    }
}