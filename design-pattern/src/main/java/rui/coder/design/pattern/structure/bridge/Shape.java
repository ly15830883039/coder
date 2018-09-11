package rui.coder.design.pattern.structure.bridge;

/**
 * 形状
 */
public abstract class Shape {
   protected DrawAPI drawAPI;
   protected Shape(DrawAPI drawAPI){
      this.drawAPI = drawAPI;
   }
   public abstract void draw();    
}