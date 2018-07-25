package rui.coder.foundation.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 类描述
 * Created by 赵睿 on 2017/2/16.
 */
public class PrintWriterTest {

    //    @Test
    public void print() throws IOException {
        FileWriter fileWriter = new FileWriter("D:/logs/concurrent/log.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("test");
        printWriter.flush();
        printWriter.close();
    }

}
