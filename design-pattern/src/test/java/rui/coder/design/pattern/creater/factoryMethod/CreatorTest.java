package rui.coder.design.pattern.creater.factoryMethod;

import org.junit.jupiter.api.Test;

class CreatorTest {

    private Creator creator;

    @Test
    void eat() {
        creator = new EatCreator();
        creator.create().doSomeThings();
    }

    @Test
    void play() {
        creator = new PlayCreator();
        creator.create().doSomeThings();
    }
}