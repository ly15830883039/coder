package rui.coder.algorithms.problem.byzantineGenerals.paxos;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;

/**
 * 提倡者
 */
@Setter
@Getter
public class Proposer {
    private Client client;

    private int value;

    public Proposer(Client client) {
        this.client = client;
    }


    /**
     * 初次提议
     *
     * @param acceptorStream 决策者们
     * @param start          同步开始栅栏
     * @param end            同步结束 门栓
     */
    public void firstProposal(Stream<Acceptor> acceptorStream, CyclicBarrier start, CountDownLatch end) {
        new Thread(() -> {
            try {
                start.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                System.err.println("倡议者 同时开始出现问题！！！");
                e.printStackTrace();
            }
            long size = acceptorStream.count();
            int accepted = 0;
            //TODO 对于 accepter 的请求是并发的请求。

            //这里怎么处理啊？

            //接收者没过过半，则进行对 acceptor提议
            while (accepted < size / 2) {
                value += 1;
                accepted = acceptorStream.mapToInt(acceptor -> acceptor.accept(this))
                        .sum();
            }
            end.countDown();
        }).start();
    }


    private int proposal(Stream<Acceptor> acceptorStream, CyclicBarrier start, CountDownLatch end) {


//TODO
//        acceptorStream.forEach(acceptor
//                -> new Thread(() -> {
//                   acceptor.accept(this);
//        }).start());
        return 0;
    }


    /**
     * 多个提倡者并发请求决策者
     *
     * @param stream    提倡者们
     * @param acceptors 决策者们
     */
    public static void firstProposal(Stream<Proposer> stream, Stream<Acceptor> acceptors) {
        int count = (int) stream.count();
        CyclicBarrier start = new CyclicBarrier(count);
        CountDownLatch end = new CountDownLatch(count);
        stream.forEach(proposer -> proposer.firstProposal(acceptors, start, end));
        try {
            end.await();
        } catch (InterruptedException e) {
            //描述信息
            System.err.println("倡议者并发请求 向Acceptor提议，让Acceptor来决策,等初步协议达成失败");
            e.printStackTrace();
        }
    }


}
