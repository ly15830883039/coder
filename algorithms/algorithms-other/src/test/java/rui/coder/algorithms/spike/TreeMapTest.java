package rui.coder.algorithms.spike;



import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.TreeMap;

public class TreeMapTest {

    @Test
    public void name() throws Exception {
        TreeMap treeMap = new TreeMap(new Rank());
        treeMap.put(new Rank("rui", 12, new Date()), "rui");
        treeMap.put(new Rank("rui1", 11, new Date()), "rui1");
        treeMap.put(new Rank("rui2", 13, new Date()), "rui2");
        System.out.println(treeMap);

    }
}
