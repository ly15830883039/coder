package rui.coder.design.pattern.creater.prototype;

/**
 * 正方形
 * @author 赵睿
 */
public class Square extends Shape{
    public Square(){
        type = "正方形";
    }

    @Override
    public void draw() {
        System.out.println("开始绘制正方形");
    }
}

