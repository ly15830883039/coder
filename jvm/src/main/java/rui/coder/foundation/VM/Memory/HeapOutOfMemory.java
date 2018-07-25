package rui.coder.foundation.VM.Memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建于 2017-02-05.
 * @author 赵睿
 *
 * 虚拟机参数： -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOutOfMemory {

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }
}
