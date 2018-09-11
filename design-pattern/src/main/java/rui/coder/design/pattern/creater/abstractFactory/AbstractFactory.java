package rui.coder.design.pattern.creater.abstractFactory;

import rui.coder.design.pattern.creater.abstractFactory.color.Color;
import rui.coder.design.pattern.creater.abstractFactory.shape.Shape;

public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}