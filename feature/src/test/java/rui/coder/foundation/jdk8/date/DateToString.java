package rui.coder.foundation.jdk8.date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;


@DisplayName("将时间转换为数据类型")
class DateToString {

    @Test
    void simple() {
        //2018
        System.out.println(Year.now().toString());
        //2018-08
        System.out.println(YearMonth.now().toString());
        //--08-28
        System.out.println(MonthDay.now().toString());
        //2018-08-28
        System.out.println(LocalDate.now().toString());

        //2018-08-28T14:23:01.613
        System.out.println(LocalDateTime.now().toString());
        //2018-08-28T06:25:09.164Z
        System.out.println(Instant.now().toString());
        //2018-08-28T14:27:18.371+08:00
        System.out.println(OffsetDateTime.now().toString());
        //2018-08-28T14:26:52.129+08:00[Asia/Shanghai]
        System.out.println(ZonedDateTime.now().toString());

    }

    @Test
    void ToString() {
//        Duration duration=Duration.cre;

    }
}
