# paxos [帕克索斯]
1.Proposer拿着Client的议题去向Acceptor提议，让Acceptor来决策。
2.Proposer提出议题，Acceptor初步接受或者Acceptor初步不接受。
3. Acceptor初步接受则Proposer再次向Acceptor确认是否最终接受。
4. Acceptor最终接受或者Acceptor最终不接受。

5. Learner最终学习的目标是向所有Acceptor学习，如果有多数派个Acceptor最终接受了某提议，那就得到了最终的结果，算法的目的就达到了。

## 拜占庭将军问题
1. Proposer 副官【可能叛变】
2. 



#资料来源 
1. [深入浅出理解Paxos算法](https://blog.csdn.net/21aspnet/article/details/50700123)