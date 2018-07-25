package rui.coder.foundation.processControl;


import org.junit.jupiter.api.Test;

/**
 * <p>
 * 类描述
 * </p>
 * 创建于 2017/2/13
 *
 * @author 赵睿
 */
public class DoWhileTest {

    @Test
    public void doWhile(){
        int x=2;
        do{
            x+=x;
        }while(x<17);
        System.out.println(x);
    }
}
