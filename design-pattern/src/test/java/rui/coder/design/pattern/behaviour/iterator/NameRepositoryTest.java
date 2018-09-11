package rui.coder.design.pattern.behaviour.iterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameRepositoryTest {

    @Test
    void iterator() {
        NameRepository namesRepository = new NameRepository();

        for(Iterator iterator = namesRepository.getIterator(); iterator.hasNext();){
            String name = (String)iterator.next();
            System.out.println("Name : " + name);
        }
    }
}