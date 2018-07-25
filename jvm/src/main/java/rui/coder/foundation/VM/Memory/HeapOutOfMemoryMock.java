package rui.coder.foundation.VM.Memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆-内存溢出
 * Created by 赵睿 on 2017/1/10.
 */
public class HeapOutOfMemoryMock {

    public static void main(String[] args) {
        List<byte[]> list=new ArrayList<>();
        int i=0;
        boolean flag=true;
        System.out.println("最大内存为"+Runtime.getRuntime().maxMemory()/1024/1024+"MB");
        while(flag){
            try {
                i++;
                list.add(new byte[1024*1024]);
            } catch (Throwable e) {
                System.out.println("运行次数:"+i);
                flag=false;
                e.printStackTrace();
            }
        }
    }

}
