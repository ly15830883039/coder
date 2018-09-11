package rui.coder.design.pattern.creater.abstractFactory;

import rui.coder.design.pattern.creater.abstractFactory.color.Blue;
import rui.coder.design.pattern.creater.abstractFactory.color.Color;
import rui.coder.design.pattern.creater.abstractFactory.color.Green;
import rui.coder.design.pattern.creater.abstractFactory.color.Red;
import rui.coder.design.pattern.creater.abstractFactory.shape.Shape;

public class ColorFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      return null;
   }
   
   @Override
   Color getColor(String color) {
      if(color == null){
         return null;
      }        
      if(color.equalsIgnoreCase("RED")){
         return new Red();
      } else if(color.equalsIgnoreCase("GREEN")){
         return new Green();
      } else if(color.equalsIgnoreCase("BLUE")){
         return new Blue();
      }
      return null;
   }
}