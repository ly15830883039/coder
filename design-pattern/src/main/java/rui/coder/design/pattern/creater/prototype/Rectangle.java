package rui.coder.design.pattern.creater.prototype;

/**
 * 矩形
 * @author 赵睿
 */
public class Rectangle extends Shape{
    public Rectangle(){
        type = "矩形";
    }

    @Override
    public void draw() {
        System.out.println("开始绘制矩形");
    }
}
