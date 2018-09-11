package rui.coder.foundation.jdk8.date;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;

/**
 * @author 赵睿
 */
public class InstantTest {

    @Test
    void ToString() {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant=Instant.now();
        System.out.println(instant);
        System.out.println(instant.atZone(zoneId));
    }
}
