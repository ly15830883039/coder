package rui.coder.foundation.concurrent.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThreadTest {

    @Test
    void twice() {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));

        thread.start();
        Assertions.assertThrows(IllegalThreadStateException.class, thread::start);
    }

}
