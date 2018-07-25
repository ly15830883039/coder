package rui.coder.foundation.collection.list.cleanUpList;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * <a href="http://www.baeldung.com/java-remove-duplicates-from-list?utm_source=email-newsletter&utm_medium=email&utm_campaign=auto_36_java&tl_inbound=1&tl_target_all=1&tl_period_type=3">
 * Removing all duplicates from a List in Java  <a/>
 */
@DisplayName("清理重复数据")
class CleanUpDuplicates {

    private List<Integer> list = Lists.newArrayList(0, 1, 2, 3, 0, 1);

    @Nested
    @DisplayName("普通java 方法")
    class JavaPlain {
        @Test
        @DisplayName("通过一个 set 来去重")
        void throughASet() {
            List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(list));
            assertSame(4, listWithoutDuplicates.size());
        }
    }

    @Nested
    @DisplayName("使用谷歌的guava")
    class UseGuava {

        @Test
        @DisplayName("本质上还是通过 set 实现，不过使用guava的方式去new 了")
        void throughASet() {
            List<Integer> listWithoutDuplicates = Lists.newArrayList(Sets.newHashSet(list));
            assertSame(4, listWithoutDuplicates.size());
        }
    }

    @Nested
    @DisplayName("使用 java 8的 lambdas")
    class UseJava8 {
        /**
         * 注意 ，这个去重的本质是通过equals 方法实现的
         */
        @Test
        @DisplayName("使用 Stream 的 distinct的 方式去重")
        void distinct() {
            List<Integer> listWithoutDuplicates = list.stream()
                    .distinct()
                    .collect(Collectors.toList());
            assertSame(4, listWithoutDuplicates.size());
        }
    }

}
