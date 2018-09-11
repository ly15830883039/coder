package rui.coder.design.pattern.behaviour.visitor.part;

import rui.coder.design.pattern.behaviour.visitor.ComputerPartVisitor;

public interface ComputerPart {
   public void accept(ComputerPartVisitor computerPartVisitor);
}