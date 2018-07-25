package rui.coder.foundation.VM.Memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池的内存溢出
 *
 * 使用1.6版本测试
 * 创建于 2017-02-06.
 *
 * @author 赵睿
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //使用List保持对常量池的引用，防止Full GC 回收常量池的行为
        List<String> list=new ArrayList<String>();
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
