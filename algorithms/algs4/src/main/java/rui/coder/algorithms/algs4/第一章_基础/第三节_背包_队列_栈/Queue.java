package rui.coder.algorithms.algs4.第一章_基础.第三节_背包_队列_栈;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 先进先出（FIFO）队列
 */
public class Queue <Item> implements Iterable<Item>{

    /**
     * 队列的开始
     */
    private Node<Item> first;
    /**
     * 队列的结束
     */
    private Node<Item> last;

    /**
     * 队列中的元素个数
     */
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * 创建空队列
     */
    public Queue() {
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty(){
        return first==null;
    }


    /**
     * 队列中的元素数量
     */
    public int size(){
        return size;
    }

    /**
     * 查看队首的元素
     */
    public Item peek(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is Empty");
        }
        return first.item;
    }


    /**
     * 添加一个元素
     */
    public void enqueue(Item item){
        Node<Item> oldLast=last;
        last=new Node<>();
        last.item=item;
        if(isEmpty()){
            first=last;
        }else {
            oldLast.next=last;
        }
        size ++;
    }

    /**
     * 删除最早的一个元素
     */
    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        Item item=first.item;

        first=first.next;
        size--;
        if(isEmpty()){
            last=null;
        }
        return item;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("Queue{[");

        for (Item item : this) {
            stringBuilder.append(item.toString());
            stringBuilder.append(",");
        }

        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<>(first);
    }


    public static class ListIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public ListIterator(Node<Item> node) {
            this.current = node;
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
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
