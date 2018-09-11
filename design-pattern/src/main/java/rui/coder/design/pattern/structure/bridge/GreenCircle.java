package rui.coder.design.pattern.structure.bridge;

/**
 * 绿色圆
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画圆 [ 色彩: green, 半径: " + radius + ", x: " + x + ", " + y + "]");
    }
}