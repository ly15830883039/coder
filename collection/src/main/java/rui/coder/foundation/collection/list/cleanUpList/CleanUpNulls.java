package rui.coder.foundation.collection.list.cleanUpList;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * <a href="http://www.baeldung.com/java-remove-nulls-from-list?utm_source=email-newsletter&utm_medium=email
 * &utm_campaign=auto_36_java&tl_inbound=1&tl_target_all=1&tl_period_type=3">来源：Removing all Nulls from a List in Java</a>
 */
@DisplayName("list 移除null")
class CleanUpNulls {
    private List<Integer> list;

    @BeforeEach
    @DisplayName("提供一个list ，该list中存在null")
    void setUp() {
        list = Lists.newArrayList(null, 1, null);
    }


    @Nested
    @DisplayName("使用java api")
    class JavaPlain {
        /**
         * The Java Collections Framework offers a simple solution for removing all null elements in the List – a basic while loop:
         * java 的 Collection 框架提供了一个简单的解决方案， 可以伤处里诶报中所有为空的元素-一个简单的while 循环
         */
        @Test
        @DisplayName("使用 remove 清理 null")
        void whenRemovingNullsWithPlainJava_thenCorrect() {
            while (list.remove(null)) ;
            assertSame(1, list.size());
        }

        /**
         * java api中 另外一种清理null的方法 即 removeAll
         */
        @Test
        @DisplayName("使用 removeAll ")
        void whenRemovingNullsWithPlainJavaAlternative() {
            list.removeAll(Collections.singleton(null));
            assertSame(1, list.size());
        }
    }

    /**
     * 需要导入依赖
     * <p>
     * <dependency>
     * <groupId>com.google.guava</groupId>
     * <artifactId>guava</artifactId>
     * <version>20.0</version>
     * </dependency>
     */
    @Nested
    @DisplayName("使用谷歌的guava")
    class UseGuava {

        /**
         * 使用 Iterables.removeIf 可以操作list
         */
        @Test
        @DisplayName("使用 Iterables.removeIf")
        void removeIf() {
            Iterables.removeIf(list, Predicates.isNull());
            assertSame(1, list.size());
        }

        /**
         * 如果不想修改 源数组 。guava 可以创建一个新的
         */
        @Test
        @DisplayName("使用 filter 生成新的数组")
        void filter() {
            List<Integer> listWithOutNulls = Lists.newArrayList(
                    Iterables.filter(list, Predicates.notNull())
            );
            assertSame(1, listWithOutNulls.size());
            assertSame(3, list.size());
        }
    }

    /**
     * 需要导出 依赖
     * <xml>
     * <dependency>
     * <groupId>org.apache.commons</groupId>
     * <artifactId>commons-collections4</artifactId>
     * <version>4.1</version>
     * </dependency>
     * </xml>
     */
    @Nested
    @DisplayName("使用 apache commons collections")
    class ApacheCommonsCollections {

        @Test
        @DisplayName("使用 CollectionUtils.filter")
        void filter() {
            CollectionUtils.filter(list, PredicateUtils.notNullPredicate());
            assertSame(1, list.size());
        }
    }

    @Nested
    @DisplayName("使用 java8 的 lambdas表达式")
    class Lambdas {

        @Test
        @DisplayName("使用 parallelStream 的filter")
        void parallelFilter() {
            List<Integer> listWithoutNulls = list.parallelStream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            assertSame(1, listWithoutNulls.size());
        }

        @Test
        @DisplayName("使用 单线程 Stream 的filter")
        void serialFilter() {
            List<Integer> listWithoutNulls = list.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            assertSame(1, listWithoutNulls.size());
        }

        @Test
        @DisplayName("使用 removeIf ")
        void removeIf() {
            list.removeIf(Objects::isNull);
            assertSame(1, list.size());
        }
    }
}
