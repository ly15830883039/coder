package rui.coder.design.pattern.creater.abstractFactory.shape;

/**
 *  矩形
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}