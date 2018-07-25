package rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈;


import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 先进先出（FIFO）队列
 */
public class Queue<Item> implements Iterable<Item> {


    private Node<Item> first;

    private Node<Item> lasted;

    private int size;

    @AllArgsConstructor
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }


    /**
     * 创建空队列
     */
    public Queue() {

    }

    /**
     * 添加一个元素
     */
    public void enqueue(Item Item) {
        if (isEmpty()) {
            first = new Node<>(Item, null);
            lasted = first;
        } else {
            Node node = new Node<>(Item, null);
            lasted.next = node;
            lasted = node;
        }
        size++;
    }

    /**
     * 删除最早的一个元素
     */
    public Item dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException("空队列");
        }
        Item Item = first.item;
        size--;
        first = first.next;
        return Item;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty() {
        return first ==null;
    }

    /**
     * 队列中的元素数量
     */
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder("[");

        Iterator iterator=this.iterator();
        while (iterator.hasNext()){
            builder.append(iterator.next());
            if(iterator.hasNext()){
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private class QueueIterator<Item> implements Iterator<Item>{

        private Node<Item> current;

        public QueueIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException("迭代器已经没有下一个了");
            }

            Item item=current.item;
            current=current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("不支持移除操作");
        }
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator<>(first);
    }
}
