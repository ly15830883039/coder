package rui.coder.foundation.VM.Memory;




import java.lang.reflect.Field;

/**
 * 创建于 2017-02-06.
 *
 * @author 赵睿
 */
public class DirectMemoryOOM {
    private static final  int _1M=1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        //TODO  合并
//        Field unSafeField=Unsafe.class.getDeclaredFields()[0];
//        unSafeField.setAccessible(true);
//        Unsafe unsafe= (Unsafe) unSafeField.get(null);
//        while(true){
//            unsafe.allocateMemory(_1M);
//        }
    }
}
