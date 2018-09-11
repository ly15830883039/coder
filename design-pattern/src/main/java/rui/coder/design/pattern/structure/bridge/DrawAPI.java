package rui.coder.design.pattern.structure.bridge;

/**
 * 画图的api
 * @author 赵睿
 */
public interface DrawAPI {

    /**
     * 画圆
     * @param radius  半径
     * @param x 坐标
     * @param y 坐标
     */
    void drawCircle(int radius,int x,int y);
}
