package rui.coder.algorithms.spike;


import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.TreeSet;

public class TreeSetTest {

    @Test
    public void name() throws Exception {
        TreeSet treeSet = new TreeSet(new Rank());
        treeSet.add(new Rank("rui", 12, new Date()));
        treeSet.add(new Rank("rui", 11, new Date()));
        treeSet.add(new Rank("rui", 14, new Date()));
        treeSet.add(new Rank("rui", 10, new Date()));
        System.out.println(treeSet);

    }
}
