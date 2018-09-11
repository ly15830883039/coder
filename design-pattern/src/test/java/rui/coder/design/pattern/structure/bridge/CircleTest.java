package rui.coder.design.pattern.structure.bridge;

import org.junit.jupiter.api.Test;

class CircleTest {

    @Test
    void draw() {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}