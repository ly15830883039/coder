package rui.coder.foundation.io;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * <p>
 * 类描述
 * </p>
 * 创建于 2017/2/13
 *
 * @author 赵睿
 */
class StreamTest {

    @Test
    @DisplayName("先关闭然后读取,期待异常")
    void closeThenRead() throws IOException {
        FileInputStream fileInputStream=new FileInputStream(new File("D:/Pictures/龙王.jpg"));
        fileInputStream.close();
        @SuppressWarnings("ResultOfMethodCallIgnored")
        Throwable throwable=assertThrows(IOException.class, fileInputStream::read);
        assertEquals("Stream Closed",throwable.getMessage());
    }
}
