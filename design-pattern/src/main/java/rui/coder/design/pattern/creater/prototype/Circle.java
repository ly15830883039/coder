package rui.coder.design.pattern.creater.prototype;

/**
 * 圆形
 * @author 赵睿
 */
public class Circle extends Shape{
    public Circle(){
        type = "圆形";
    }

    @Override
    public void draw() {
        System.out.println("开始绘制圆形");
    }
}

