package rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 背包数据结构
 *
 * 背包是一种不支持从中删除元素的集合数据类型
 *
 */
public class Bag<Item> implements Iterable<Item> {
    /** 背包的开始元素 */
    private Node<Item> first;

    /** 背包中的元素个数 */
    private int n;


    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    /**
     * 创建一个空的背包
     */
    public Bag() {
        first=null;
        n=0;
    }

    /**
     * 背包是否为空
     */
    public boolean isEmpty(){
        return first==null;
    }

    /**
     * 背包中的元素数量
     */
    public int size(){
        return n;
    }


    /**
     * 添加一个元素
     */
    public void add(Item item){
        Node<Item> oldFirst=first;
        first=new Node<>();
        first.item=item;
        first.next=oldFirst;
        n++;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }


    public class ListIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public ListIterator(Node<Item> first){
            current=first;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item=current.item;
            current=current.next;
            return item;

        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException();
        }

    }
}
