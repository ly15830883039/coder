package rui.coder.design.pattern.behaviour.visitor;

import org.junit.jupiter.api.Test;
import rui.coder.design.pattern.behaviour.visitor.part.Computer;
import rui.coder.design.pattern.behaviour.visitor.part.ComputerPart;

class ComputerPartTest {

    @Test
    void accept() {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}