package rui.coder.design.pattern.structure.facade;

import org.junit.jupiter.api.Test;

class ShapeMakerTest {

    @Test
    void draw() {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}