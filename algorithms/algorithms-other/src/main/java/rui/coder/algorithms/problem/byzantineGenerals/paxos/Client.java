package rui.coder.algorithms.problem.byzantineGenerals.paxos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 产生议题的人
 */
@AllArgsConstructor
public class Client {

    @Getter
    @Setter
    private Proposer proposer;

    public Client() {
    }

    /**
     *
     */
    public void request(){

    }
}
