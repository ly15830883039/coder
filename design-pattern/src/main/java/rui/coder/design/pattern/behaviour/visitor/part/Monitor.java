package rui.coder.design.pattern.behaviour.visitor.part;

import rui.coder.design.pattern.behaviour.visitor.ComputerPartVisitor;

public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}