package rui.coder.foundation.basicDataType;

import org.junit.jupiter.api.Test;

/**
 * <p>
 * 类描述
 * </p>
 * 创建于 2017/2/13
 *
 * @author 赵睿
 */
public class DoubleTest {

    @Test
    public void accuracy(){
        Double a=2.00;
        Double b=1.10;
        System.out.println(a.byteValue());
        System.out.println(b.byteValue());
        Double c=a-b;
        System.out.println(c.byteValue());
        System.out.println(c);
    }
}
