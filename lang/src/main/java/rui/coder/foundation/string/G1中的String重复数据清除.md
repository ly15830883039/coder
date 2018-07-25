# G1中的String重复数据清除

##  概要
通过增强G1垃圾回收器，阻止java堆生成数据。这样String的实例对象将会被自动和持续的重复使用。

该方案只有G1垃圾回收器生效

## 动机
许多大规模的java程序目前的瓶颈是内存。而其中java堆中大致25%都是String对象。其中一般的String对象是重复的，重复的意思是`string1.equals(string2)`为true。在String堆上有重复的对象本质上只是浪费内存而已。

## 描述


## 资料来源
1. [openJdk-jeps-192](http://openjdk.java.net/jeps/192) 

## 备注
1. jep java enhancement proposals java 增强方案