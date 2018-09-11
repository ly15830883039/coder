package rui.coder.design.pattern.behaviour.visitor;

import rui.coder.design.pattern.behaviour.visitor.part.Computer;
import rui.coder.design.pattern.behaviour.visitor.part.Keyboard;
import rui.coder.design.pattern.behaviour.visitor.part.Monitor;
import rui.coder.design.pattern.behaviour.visitor.part.Mouse;

public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}