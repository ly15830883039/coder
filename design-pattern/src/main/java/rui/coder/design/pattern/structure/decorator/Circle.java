package rui.coder.design.pattern.structure.decorator;

public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Shape: Circle");
   }
}