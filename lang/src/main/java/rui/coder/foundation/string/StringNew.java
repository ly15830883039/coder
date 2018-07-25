package rui.coder.foundation.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings({"RedundantStringConstructorCall", "StringEquality", "ConstantStringIntern", "ConstantConditions"})
@DisplayName("String 创建新对象与否")
class StringNew {
    @Test
    @DisplayName("常量池中没有，new 一个")
    void new_string() {
        String a="测试非常量池中的String";
        String s=new String(a);
        assertFalse(a==s,"新new的是一个新对象");
    }
    @Test
    @DisplayName("常量池中存在，new 一个")
    void new_string_in_StringConstantPool() {
        String s="A".intern();
        String a=new String(s);
        assertFalse(s==a,"新new的是一个新对象");
    }

    @Test
    @DisplayName("常量池中存在，且为空串；new 一个")
    void new_empty_string() {
        String s=new String();
        assertFalse(""==s,"新new的是一个新对象");
    }

    @Test
    @DisplayName("只是简单的赋值")
    void assignment() {
        String s="";
        assertTrue(""==s,"是同一个对象");
    }

    @Test
    @DisplayName("从 string常量池中获得")
    void get_from_StringConstantPool() {
        String a="A".intern();
        String s=a.intern();
        assertTrue(a==s);
    }

    @DisplayName("通过 class 的 newInstance() 方法获得新的String对象")
    @Test
    void get_by_class_newInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String d= String.class.getDeclaredConstructor().newInstance();
        System.out.println(""==d);
        assertFalse(""==d,"新new了一个对象");
    }
}
