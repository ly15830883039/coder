package rui.coder.foundation.Class;



import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * <p>
 * 类描述
 * </p>
 * 创建于 2017/2/13
 *
 * @author 赵睿
 */
public class ReadClassTest {
    //TODO 还是不懂
    @Test
    public void readClass(){
        String classpath=this.getClass().getResource("").getFile()+"/"+this.getClass().getSimpleName()+".class";
        try {
            BufferedInputStream bis=new BufferedInputStream(new FileInputStream(new File(classpath)));
            ByteArrayOutputStream baos=new ByteArrayOutputStream();

            byte[] buffer=new byte[1024];
            int length=-1;

            try {
                while((length=bis.read(buffer))!=-1){
                    baos.write(buffer,0,length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(bis!=null){
                    bis.close();
                }
                if(baos!=null){
                    baos.close();
                }
            }

            byte [] codes=baos.toByteArray();
            bis.close();

            StringBuilder builder=new StringBuilder();

            for (int i = 0; i <codes.length ; i++) {
                byte b=codes[i];
                //0xFF表示的是16进制（十进制是255），表示为二进制就是”11111111“。那么&符表示的是按位数进行与（同为1的时候返回1，否则返回0）
                int value=b& 0xFF;
                String strHex=Integer.toHexString(value);
                if(strHex.length()<2){
                    strHex="0"+strHex;
                }
                builder.append(strHex);
            }
            System.out.println(builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
