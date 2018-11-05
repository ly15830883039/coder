package rui.coder.foundation.concurrent.safe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;

class IntegerTest {

    private Integer integer = 0;

    private int crySize = 1000;

    @Test
    void integer() throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < crySize; i++) {
                integer++;
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < crySize; i++) {
                integer++;
            }
        });

        thread.start();
        thread2.start();
        thread.join();
        thread.join();
        assertNotSame(crySize * 2, integer);
    }

}
