package rui.coder.foundation.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 在1.6.是false，false。
 * 在JDK 1.6中，intern（）方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串实例的引用，
 *      而由StringBuilder创建的字符串实例在Java堆上，所以必然不是同一个引用，将返回false
 *
 * 而JDK 1.7（以及部分其他虚拟机，例如JRockit）的intern（）实现不会再复制实例，只是在常量池中记录首次出现的实例引用，
 *      因此intern（）返回的引用和由StringBuilder创建的那个字符串实例是同一个。
 *
 *      对str2比较返回false是因为“java”这个字符串在执行StringBuilder.toString（）之前已经出现过，字符串常量池中已经有它的引用了，不符合“首次出现”的原则，
 *      而“计算机软件”这个字符串则是首次出现的，因此返回true。
 *
 * 创建于 2017-02-06.
 *
 * @author 赵睿
 */
@DisplayName("String的intern方法")
class StringIntern {


    @SuppressWarnings({"StringBufferReplaceableByString", "StringEquality"})
    @DisplayName("通过StringBuilder 获得新的String对象,新的String 在常量池中不可能存在，所以为true")
    @Test
    void stringBuilder_toString() {
        String str=new StringBuilder("计算器").append("软件").toString();
        assertTrue(str.intern()==str);
    }

    @SuppressWarnings({"StringBufferReplaceableByString", "StringEquality"})
    @Test
    @DisplayName("java 这个字符在常量池中已经存在，所以通过intern取出的数据是常量池中的java的引用，" +
            "而通过StringBuilder的toString生成的是新的，所以为false")
    void alreadyIn() {
        String str2=new StringBuilder("ja").append("va").toString();
        assertFalse(str2.intern()==str2);
    }







    @Test
    @DisplayName("G1中的String 重复数据消除")
    void name() {


    }
}
