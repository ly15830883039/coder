package rui.coder.foundation.jdk8.date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

class TimeTest {

    @Test
    @DisplayName("一天前，并获得为整点")
    void minusDays() {
        System.out.println(LocalDateTime.now()
                .minusDays(1)
                .with(ChronoField.NANO_OF_DAY, 0)
        );
    }

    @Test
    @DisplayName("当天的开始时间")
    void thisDayStart() {
        System.out.println(LocalDateTime.now()
                .with(ChronoField.NANO_OF_DAY, 0));
    }

    @Test
    @DisplayName("当天某些特殊的小时开始")
    void thisDaySomeHours() {
        LocalDateTime dateTime= LocalDateTime.now()
                .with(ChronoField.NANO_OF_DAY, 0)
                .withHour(10)
                ;
        System.out.println(dateTime);
    }

    @Test
    void parse() {

    }

    @Test
    void parse1() {
        String time = "20180330121706";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDateTime = LocalDateTime.parse(time, dateTimeFormatter);
        System.out.println(localDateTime);
    }

    @Nested
    class instant{

        @Test
        void name() {

            System.out.println(Instant.now());
        }
    }

    @Nested
    @DisplayName("将 LocalDateTime 转换为 Date")
    class date{

        @Test
        void convert() {
            LocalDateTime localDateTime=LocalDateTime.now();

            ZoneId zoneId = ZoneId.systemDefault();

            ZonedDateTime zdt = localDateTime.atZone(zoneId);

            Date date = Date.from(zdt.toInstant());
            System.out.println(date);

        }
    }
}