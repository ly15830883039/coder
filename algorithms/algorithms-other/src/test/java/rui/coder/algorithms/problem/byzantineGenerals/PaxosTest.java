package rui.coder.algorithms.problem.byzantineGenerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rui.coder.algorithms.problem.byzantineGenerals.paxos.Acceptor;
import rui.coder.algorithms.problem.byzantineGenerals.paxos.Client;
import rui.coder.algorithms.problem.byzantineGenerals.paxos.Proposer;

import java.util.stream.Stream;

public class PaxosTest {

    private Stream<Client> clients;

    private Stream<Acceptor> acceptors;

    @BeforeEach
    void setUp() {
        clients = Stream.of(new Client("A"), new Client("B"), new Client("C"));

        acceptors = Stream.of(new Acceptor("A"), new Acceptor("B"), new Acceptor("C"));
    }


    @Test
    void paxos() {
        // 客户端 产生议题， 交付给 Proposer；
        Stream<Proposer> stream = clients.map(Client::deliver);

        //--start  并发请求 开始； 向Acceptor提议，让Acceptor来决策。
        Proposer.firstProposal(stream, acceptors);
        //--end  并发请求 结束： 达成初步一致意见








    }


}

