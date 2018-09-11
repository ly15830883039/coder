package rui.coder.algorithms.problem.byzantineGenerals.paxos;

import lombok.Getter;
import lombok.Setter;

/**
 * 产生议题的人
 */
@Getter
@Setter
public class Client {

    private String name;

    public Client(String name) {
        this.name = this.getClass().getSimpleName() + name;
    }


    /**
     * Client(客户端) 产生议题， 交付给 Proposer(提倡者)；
     */
    public Proposer deliver() {
        return new Proposer(this);
    }
}
