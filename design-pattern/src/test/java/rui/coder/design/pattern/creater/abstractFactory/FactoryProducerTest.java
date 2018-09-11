package rui.coder.design.pattern.creater.abstractFactory;

import org.junit.jupiter.api.*;
import rui.coder.design.pattern.creater.abstractFactory.color.Color;
import rui.coder.design.pattern.creater.abstractFactory.shape.Shape;

class FactoryProducerTest {
    private AbstractFactory shapeFactory;

    @Nested
    @DisplayName("shape")
    class ShapeTest{
        @BeforeEach
        void setUp() {
            //获取形状工厂
            shapeFactory = FactoryProducer.getFactory("SHAPE");
        }

        @Test
        void circle() {
            //获取形状为 Circle 的对象
            Shape shape1 = shapeFactory.getShape("CIRCLE");
            //调用 Circle 的 draw 方法
            shape1.draw();
        }

        @Test
        void rectangle() {
            Shape shape1 = shapeFactory.getShape("RECTANGLE");
            shape1.draw();
        }


        @Test
        void square() {
            Shape shape1 = shapeFactory.getShape("SQUARE");
            shape1.draw();
        }
    }


    @Nested
    @DisplayName("color")
    class ColorTest{
        @BeforeEach
        void setUp() {
            //获取形状工厂
            shapeFactory = FactoryProducer.getFactory("COLOR");
        }

        @Test
        void circle() {
            Color color = shapeFactory.getColor("RED");
            color.fill();
        }

        @Test
        void rectangle() {
            Color color = shapeFactory.getColor("Green");
            color.fill();
        }

        @Test
        void square() {
            Color color = shapeFactory.getColor("BLUE");
            color.fill();
        }
    }

}