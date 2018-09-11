package rui.coder.design.pattern.creater.abstractFactory.color;

public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}