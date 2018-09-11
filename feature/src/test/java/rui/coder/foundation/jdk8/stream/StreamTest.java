package rui.coder.foundation.jdk8.stream;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rui.coder.foundation.jdk8.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.RandomUtils.nextDouble;

/**
 * jdk 8 stream 特性
 */
public class StreamTest {

    @Test
    public void toMap() throws Exception {

        List<Rank> rankList = Stream.generate(() -> new Rank(uuid(), nextDouble()))
                .limit(10)
                .collect(Collectors.toList());
        rankList.forEach(System.out::println);

        Map<String, Double> map = rankList.parallelStream()
                .collect(Collectors.toMap(Rank::getUserId, Rank::getNumber, (aLong, aLong2) -> aLong2, HashMap::new));
        System.out.println(map);
        map = rankList.parallelStream()
                .collect(Collectors.toMap(Rank::getUserId, Rank::getNumber));

        System.out.println(map);
    }

    private String uuid() {
        return null;
    }

    @Test
    public void getNeed() throws Exception {
        String uuid = uuid();
        List<Rank> rankList = Stream.generate(() -> new Rank(uuid(), nextDouble()))
                .limit(10)
                .collect(Collectors.toList());
        Rank rank1 = new Rank(uuid, nextDouble());
        rankList.add(rank1);
        rankList.stream().filter(rank -> Objects.equals(uuid, rank.getUserId()))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println(rank1);
    }


    @Test
    @DisplayName("验证idea 给的demo")
    void name() {
        List<String> str = Stream.of("1", "qwer", "234adfv").collect(Collectors.toList());

        System.out.println(toString(str));

    }

    public String toString2(List<String> strings) {
        return strings.stream().
                map(String::trim).
                filter(str -> !str.isEmpty())
                .collect(Collectors.joining(",", "[", "]"));

    }

    public String toString(List<String> strings) {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;

        for (String string : strings) {
            String str = string.trim();
            if (!str.isEmpty()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.append("]").toString();
    }

}
