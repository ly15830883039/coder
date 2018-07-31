package rui.coder.algorithms.interview.netEase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNumTest {

    private FindNum findNum=new FindNum();

    @Test
    void findNum() {
        int[] numbs=new int[]{1,1,7,1};
        assertSame(7,findNum.findNum(numbs.length,numbs));
    }
}