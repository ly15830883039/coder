package rui.coder.foundation.VM.Memory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * 永久带-内存溢出
 * 在1.8JDK 无效
 *
 * 但是能够看到输出明细的卡顿，即GC开始清理
 * Created by 赵睿 on 2017/1/10.
 */
public class PermGenOutOfMemoryMock {

    public static void main(String[] args) {
        URL url=null;
        List<ClassLoader> classLoaders=new ArrayList<>();
        try {
            url=new File("/tmp").toURI().toURL();
            URL[] urls={url};
            while(true){
                ClassLoader loader=new URLClassLoader(urls);
                classLoaders.add(loader);
                loader.loadClass("rui.basic.VM.GC.HeapOutOfMemoryMock");
                System.out.println("剩余内存为"+Runtime.getRuntime().freeMemory()/1024/1024+"MB");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
