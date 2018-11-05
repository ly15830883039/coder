package rui.coder.foundation.innerClass;

public class InnerClass {
    static class A {
        void say() {

        }
    }

    interface B {
        void doS();
    }

    private A a2=new A();
    void case2() {
        A a = new A();
        B b1 = () -> {
            a2.say();
            a.say();
//                a = new A();   //Variable 'a' is accessed from within inner class, needs to be final or effectively final
        };
        b1.doS();
    }
}
