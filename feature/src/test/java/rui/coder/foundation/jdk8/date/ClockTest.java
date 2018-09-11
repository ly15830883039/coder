package rui.coder.foundation.jdk8.date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;

/**
 * @see java.time.Clock
 */
class ClockTest {

    @Test
    @DisplayName("通过 Clock 获得当前时间")
    void getInstantByClock() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println("now: " + clock.instant());
    }

    @Test
    void utc() {
        Clock clock = Clock.systemUTC();
        System.out.println("utc: " + clock.instant());
    }

    @Test
    void timezone() {
        Clock clock = Clock.system(ZoneId.of("Asia/Shanghai"));
        System.out.println("zoneId: " + clock.instant());
    }

    @Test
    void systemDefaultZone() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println("systemDefaultZone: " + clock);
    }

    @Test
    void systemDefaultZone2() {
        Clock clock = Clock.system(ZoneId.systemDefault());
        System.out.println("systemDefaultZone2: " + clock);
    }

    @Test
    void millis() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println("millis: " + clock.millis());
    }


    @Nested
    @DisplayName("时间前后移动")
    class offset {

        Clock baseClock = Clock.systemDefaultZone();

        @Test
        @DisplayName("延后")
        void later() {
            // result clock will be later than baseClock
            Clock clock = Clock.offset(baseClock, Duration.ofHours(72));
            System.out.println(clock.instant());
        }

        @Test
        @DisplayName("当前")
        void now() {
            // result clock will be same as baseClock
            Clock clock = Clock.offset(baseClock, Duration.ZERO);
            System.out.println(clock.instant());
        }

        @Test
        void earlier() {
            // result clock will be earlier than baseClock
            Clock clock = Clock.offset(baseClock, Duration.ofHours(-72));
            System.out.println(clock.instant());
        }
    }
}