package rui.coder.algorithms.algs4.第一章_基础.c_第三节_背包_队列_栈;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 下压 （后进先出 LIFO） 栈
 */
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> end;


    private int size;

    /**
     * 创建一个空栈
     */
    public Stack() {
    }

    @AllArgsConstructor
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * 添加一个元素
     */
    public void push(Item item) {
        Node<Item> node;
        if (isEmpty()) {
            node = new Node<>(item, null);
        } else {
            node = new Node<>(item, end);
        }
        end = node;
        size++;

    }

    /**
     * 删除最近添加的元素
     */
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("栈已经空了");
        } else {
            Item item = end.item;
            end = end.next;
            size--;
            return item;
        }
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("栈已经空了");
        } else {
            return end.item;
        }
    }

    /**
     * 栈是否为空
     */
    public boolean isEmpty() {
        return end == null;
    }

    /**
     * 栈中的元素数量
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

    private class StackIterator<item> implements Iterator<item> {

        private Node<item> current;

        private StackIterator(Node<item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("栈已经空了");
            } else {
                item item = current.item;
                current = current.next;
                return item;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("不支持移除方法");
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator<>(end);
    }


}
