package rui.coder.design.pattern.structure.bridge;

/**
 * 红色圆
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画圆 [ 色彩: red, 半径: " + radius + ", x: " + x + ", " + y + "]");
    }
}