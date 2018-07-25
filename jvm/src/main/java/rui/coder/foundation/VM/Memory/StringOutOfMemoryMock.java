package rui.coder.foundation.VM.Memory;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk1.6 ：java.lang.OutOfMemoryError: PermGen space
 * jdk1.7: java.lang.OutOfMemoryError: Java heap space
 * jdk1.8: java.lang.OutOfMemoryError: Java heap space
 *
 *
 *
 * Created by 赵睿 on 2017/1/10.
 */
public class StringOutOfMemoryMock {
    static String base="String";

    public static void main(String[] args) {
        List<String> stringList=new ArrayList<>();
        for (int i=0;i<Integer.MAX_VALUE;i++){
            String str=base+base;
            base=str;
            // intern的作用为：
            //   如果池已经包含一个等于此 String 对象的字符串（该对象由 equals(Object) 方法确定），则返回池中的字符串。
            //   否则，将此 String 对象添加到池中，并且返回此 String 对象的引用。
            stringList.add(str.intern());
        }
    }

}
