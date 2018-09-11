package rui.coder.design.pattern.structure.decorator;

public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Shape: Rectangle");
   }
}