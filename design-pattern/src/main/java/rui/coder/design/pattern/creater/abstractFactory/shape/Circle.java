package rui.coder.design.pattern.creater.abstractFactory.shape;

public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}