package rui.coder.algorithms.java.hash;

import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;


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
     * @param key
     * @param value
     * @param onlyIfAbsent
     * @param evict
     * @return
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;

        //table为空，或者长度为n
        if (( tab = table) == null || (n=tab.length)==0) {
            //初始化
//            tab = resize();
            n = tab.length;
        }

        //
        if((p=tab[i=(n-1)&hash])==null){

        }


    }

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


}
