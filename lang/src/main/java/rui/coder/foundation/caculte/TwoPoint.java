package rui.coder.foundation.caculte;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("计算两点之间的距离")
class TwoPoint {


    private double x1 = 3;
    private double y1 = 4;
    private double x2 = 7;
    private double y2 = 1;
    private double result;

    @Test
    @DisplayName("使用 Point2D 计算两点之间的距离")
    void case1() {
        result = Point2D.distance(x1, y1, x2, y2);
    }


    @Test
    @DisplayName("原生api")
    void case2() {
        result=Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));

    }

    @Test
    @DisplayName("使用 Math算法包")
    void case3() {
        double ac=Math.abs(x2-x1);
        double cb=Math.abs(y2-y1);
        result=Math.hypot(ac,cb);
    }

    @AfterEach
    void tearDown() {
        assertEquals(5.0, result);
    }
}
