package rui.coder.foundation.collection.map;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.*;


/**
 * 实现注意事项：
 * <p>
 * 这个 Map 通常作为一个存储 hash表的箱子，但
 * 当这个箱子太大了，就会转换成TreeNodes这种箱子。
 * 每一个结构都和它们在java.util.TreeMap中的一样。
 * 大多数方法同样适用于普通的箱子。但是当可用性检查（检查
 * 节点的实例）会转换为 TreeNode的方法。TreeNode桶可能不被使用
 * 或者使用其他，但是当太大，并想快速的获得，最好使用。
 * 然而绝大多数容器的使用都不会太大，检查使用存在Tree桶，可能在使用表方法的
 * 时候会比较慢。
 * <p>
 * Tree 桶（比如说： 这些桶中所有的元素都是TreeNodes）主要是通过hashcode进行的排序
 * 问题的关键就是，如果两个元素实现了 Comparable 接口，使用 compareTo  进行比较排序
 * （通过反射检查 参见方法comparableClassFor）。这个添加了复杂性，最坏的情况下是O(log n)
 * 当key有不同的hash的时候，性能提升非常好。如果hashCode()方法偶然或者错误使用导致了返回了
 * 分布很差的值，即多个key共享了同一个hashCode。或者实现了Comparable。如果两个都没有
 * （我们会浪费大量时间在时间和空间复杂度都是2的操作来比较）
 * <p>
 * <p>
 * 因为 TreeNodes 的大小是常规节点的两倍，所用当之后在桶中有足够的节点才会使用，（see TREEIFY_THRESHOLD）
 * 或者当变的足够小的时候，会转换为正常的容器。在使用分布良好的用户hashCode 的使用，tree桶是很少使用的。
 * 在理想情况下，在随机hashcode 的情况下，在容器中的节点将遵循 泊松分布。
 * <p>
 * 默认调整大小的参数平均为0.5左右，阈值为0.75，
 */

/**
 * @author 赵睿
 */
public class HashMap2<K, V> implements Serializable {


    private static final long serialVersionUID = 362498820763181265L;

    /**
     * 默认的初始化容量大小，容量必须为2的倍数
     * 2的4次方，即16
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 不能超过最大的容量。容量必须为2的倍数
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 自动扩容的因素
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 使用树而不是list 的阀值，必须 2<TREEIFY_THRESHOLD<=8
     *
     * Tree if y threshold 启动tree 的门槛
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 使用list而不是tree ，UNTREEIFY_THRESHOLD<TREEIFY_THRESHOLD
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * 可以对容器进行树化的最小的表容量，>=4*TREEIFY_THRESHOLD,从而避免大小调整和 TREEIFY_THRESHOLD 之间的冲突。
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

    /**
     * 生成hash 尽量避免hash碰撞
     * @param key key值
     * @return key对象的 hash值
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 找到 刚好 比 cap 大的 2的幂数
     *
     * 本质上我们要做到事情是对该数进行增加，增加什么呢，位数，即最好保证最高为不变，其他位数填充满。
     * 这样的这个数 只要+1 必然是一个2的幂数。
     *
     *
     * @param cap 容量大小
     * @return 2的幂数
     */
    static final int tableSizeFor(int cap) {
        //防止 cap已经是 2的幂数
        int n = cap - 1;
        //将最高位的下一位填充上
        n |= n >>> 1;
        //现在 前两位都是1了，那么这一步的操作就是将战果扩大为4位。 以此类推。
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        // 这一步操作完成，就已经能搞保证将 一个32位数的数，也能进行上面的操作。
        n |= n >>> 16;
        // 看到了没有最后一步干的操作，就是将 n+1 返回。
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 下一个重新计算大小的值（容量* 负载因子 ）[capacity * load factor]
     */
    int threshold;
    /**
     * 负载因子
     */
    final float loadFactor;


    /**
     * 这个 属性不参与序列化
     *
     * The table, initialized on first use, and resized as
     * 这个表，首次使用需要初始化，并根据需要调整大小。
     * necessary. When allocated, length is always a power of two.
     * 当分配时，长度为2的倍数。
     * (We also tolerate length zero in some operations to allow
     * （在当前不需要的引导机制 ，我们可以让长度为0）
     * bootstrapping mechanics that are currently not needed.)
     */
    transient Node<K, V>[] table;

    /**
     * k-v 这个结构一共有多少个
     */
    transient int size;
    /**
     * 这个数是 HashMap中结构改变过几次。
     *
     * 结构改变 是指 吸怪了hash的映射数量，或者修改了内部的结构，比如说进行了rehash的操作。
     *
     * 这个参数是用于 让一些迭代器能够 快速失败。
     *
     */
    transient int modCount;

    public HashMap2(int initialCapacity, float loadFactor) {
        //初始化大小非负数
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);

        //初始化大小 不能超限
        if (initialCapacity > MAXIMUM_CAPACITY) initialCapacity = MAXIMUM_CAPACITY;

        //负载因子 必须为正数，且 必须是一个数字
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);


        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }


    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
     *
     * @param hash key的hash值
     * @param key key
     * @param value value
     * @param onlyIfAbsent 如果是true 将不改变原来的值
     * @param evict 如果是false ，这个表将是创建模式
     * @return 之前的值，或者为空。
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;

        //table为空，或者长度为n·
        if (( tab = table) == null || (n=tab.length)==0) {
            //初始化
            tab = resize();
            n = tab.length;
        }

        //i=(n-1)&hash 是计算在那个桶的算法
        if((p=tab[i=(n-1)&hash])==null){  //判断桶中没有数据
            //创建一个新节点，并赋予到桶中
            tab[i]=newNode(hash,key,value,null);

        }else{//这个桶中有数据
            Node<K,V> e; K k;
            //如果这个桶中的Node的hash和我们运算出来的key的hash值相同。
            //并且
            //      桶中节点的key和我们的key为同一个 或者 （入参key 不为空同时，入参key的和桶中节点的key相同 ）
            if(p.hash==hash &&
                    ((k=p.key)==key|| (key !=null && key.equals(k)))){
                e=p;
            }else if(p instanceof TreeNode){//桶中节点 为 TreeNode结构
                //往 Tree 节点中添加value
                e=((TreeNode<K,V>)p).putTreeVal(this,tab,hash,key,value);
            }else{
                //从1开始，然后自增
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {//如果 桶中节点下一个为空
                        //将新节点赋予桶中节点的链上
                        p.next = newNode(hash, key, value, null);
                        //如果 链表的长度大于 等于 tree -1，将 链表转换为 TreeNode
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    // 桶中节点中的链next不为空 并且
                    //       桶中节点的key和next的key相同，或者 输入key不为空，且输入key和next的key相同

                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;//跳出循环
                    }
                    //将最新的next链节点的地址替换了桶的地址
                    p = e;
                }
            }
            //如果 e 不为空，可知  已经存在了这个映射关系,即这个key重复了
            if (e != null) { // existing mapping for key
                //取出旧的值来
                V oldValue = e.value;
                //onlyIfAbsent 为  只有在缺少的情况下,默认put为false
                //所以这一步直接执行
                if (!onlyIfAbsent || oldValue == null)//替换旧值
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }

        }
        //这个数改变了，说明了说明了什么，结构变了，其他相关迭代的就会失败
        ++modCount;
        if (++size > threshold)//如果这个大小超过了预设范围，将进行扩容
            resize();

        afterNodeInsertion(evict);
        return null;
    }

    private void afterNodeInsertion(boolean evict) {
    }

    private void afterNodeAccess(Node<K,V> e) {
    }

    private void treeifyBin(Node<K,V>[] tab, int hash) {
    }

    private Node<K,V> newNode(int hash, K key, V value, Object o) {
        //TODO
        return null;
    }

    private Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;

        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;

        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        } else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }


        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }

        //TODO
        return null;
    }

    /*

     */

    @AllArgsConstructor
    static class Node<K, V> implements Map.Entry<K, V> {
        /**
         * key 不变，所以key所对应的hash不能变
         */
        final int hash;

        /**
         * key 不可变
         */
        final K key;

        V value;

        Node<K, V> next;


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = value;
            this.value = value;
            return oldValue;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public int hashCode() {
            //^是异或运算符（把数据转换成二进制，然后按位进行运算）。
            // 相同为0，不同为1
            return Objects.hashCode(key) ^ Objects.hash(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) obj;
                return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
            }
            return false;
        }
    }

    static class Entry<K,V> extends HashMap2.Node<K,V> {
        Entry<K,V> before, after;
        Entry(int hash, K key, V value, HashMap2.Node<K,V> next) {
            super(hash, key, value, next);
        }
    }

    static final class TreeNode<K,V> extends Entry<K,V>{

        TreeNode(int hash, K key, V value, Node<K, V> next) {
            super(hash, key, value, next);
        }


        public Node<K,V> putTreeVal(HashMap2<K, V> kvHashMap2, Node<K, V>[] tab, int hash, K key, V value) {
            return  null;
        }
    }

}
