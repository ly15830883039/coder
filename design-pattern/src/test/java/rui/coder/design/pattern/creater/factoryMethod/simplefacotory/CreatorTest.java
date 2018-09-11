package rui.coder.design.pattern.creater.factoryMethod.simplefacotory;

import org.junit.jupiter.api.Test;

class CreatorTest {

    private Creator creator = new Creator();


    @Test
    void eat() {
        creator.factoryMethod("eat").doSomeThings();
    }

    @Test
    void play() {
        creator.factoryMethod("play").doSomeThings();
    }
}