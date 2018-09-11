package rui.coder.design.pattern.behaviour.visitor;

import rui.coder.design.pattern.behaviour.visitor.part.Computer;
import rui.coder.design.pattern.behaviour.visitor.part.Keyboard;
import rui.coder.design.pattern.behaviour.visitor.part.Monitor;
import rui.coder.design.pattern.behaviour.visitor.part.Mouse;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

   @Override
   public void visit(Computer computer) {
      System.out.println("Displaying Computer.");
   }

   @Override
   public void visit(Mouse mouse) {
      System.out.println("Displaying Mouse.");
   }

   @Override
   public void visit(Keyboard keyboard) {
      System.out.println("Displaying Keyboard.");
   }

   @Override
   public void visit(Monitor monitor) {
      System.out.println("Displaying Monitor.");
   }
}