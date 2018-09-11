package rui.coder.design.pattern.creater.abstractFactory;

import rui.coder.design.pattern.creater.abstractFactory.color.Color;
import rui.coder.design.pattern.creater.abstractFactory.shape.Circle;
import rui.coder.design.pattern.creater.abstractFactory.shape.Rectangle;
import rui.coder.design.pattern.creater.abstractFactory.shape.Shape;
import rui.coder.design.pattern.creater.abstractFactory.shape.Square;

public class ShapeFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }        
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      return null;
   }
   
   @Override
   Color getColor(String color) {
      return null;
   }
}