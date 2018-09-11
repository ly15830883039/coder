package rui.coder.design.pattern.creater.singleton;

class DoubleCheckedLockingWithSingleton {

    static class Lazy {
        /**
         * 这个类是线程安全的。
         * 缺点：
         * 1. 每次一我们获取实例的时候，都需要获取一个潜在的不必要的锁。
         */
        public static class DraconianSingleton {
            private static DraconianSingleton instance;

            public static synchronized DraconianSingleton getInstance() {
                if (instance == null) {
                    instance = new DraconianSingleton();
                }
                return instance;
            }

            // private constructor and other methods ...
            private DraconianSingleton() {
            }
        }

        /**
         * 我们先检验我们的对象是否存在，然后再使用锁。
         * 缺点：
         * 1. 需要 volatile  关键词 ，这个在java 1.4 之前不支持
         * 2. 代码冗长，不太好阅读
         */
        public static class DclSingleton {
            private static volatile DclSingleton instance;

            public static DclSingleton getInstance() {
                if (instance == null) {
                    synchronized (DclSingleton.class) {
                        if (instance == null) {
                            instance = new DclSingleton();
                        }
                    }
                }
                return instance;
            }

            // private constructor and other methods...
        }
    }

    static class Hungry {

        //https://docs.oracle.com/javase/specs/jls/se7/html/jls-12.html#jls-12.4.2

        /**
         * 静态语句块，或者属性初始化的时候创建。
         * 问题： 不需要的时候，也会创建。
         */
        public static class EarlyInitSingleton {
            private static final EarlyInitSingleton INSTANCE = new EarlyInitSingleton();

            public static EarlyInitSingleton getInstance() {
                return INSTANCE;
            }

            // private constructor and other methods...
        }

        /**
         * 类初始化时我们第一次使用它的一个方法或字段，我们可以使用一个嵌套的静态类实现延迟初始化：
         */
        public static class InitOnDemandSingleton {
            private static class InstanceHolder {
                private static final InitOnDemandSingleton INSTANCE = new InitOnDemandSingleton();
            }

            public static InitOnDemandSingleton getInstance() {
                return InstanceHolder.INSTANCE;
            }

            // private constructor and other methods...
        }

        /**
         * Joshua Block： Effective Java book (Item 3)
         */
        public enum EnumSingleton {
            INSTANCE;

            // other methods...
        }


    }

}