package rui.coder.algorithms.problem.byzantineGenerals.paxos;

import lombok.Getter;
import lombok.Setter;

/**
 * 决策者
 */
@Getter
@Setter
public class Acceptor {
    private String name;


    private int value;

    public Acceptor(String name) {
        this.name =this.getClass().getSimpleName()+name;
    }

    /**
     * 对倡议者的倡议进行决策
     * @param proposer 倡议者
     * @return  成功为1.不成功为0；
     */
    public int accept(Proposer proposer) {
        int proposerValue = proposer.getValue();
        if (value <= proposerValue) {
            value = proposerValue;
            return 1;
        }
        return 0;
    }
}
