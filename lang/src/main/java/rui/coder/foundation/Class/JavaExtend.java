package rui.coder.foundation.Class;

/**
 * <p>
 * 类描述
 * </p>
 * 创建于 2017/2/13
 *
 * @author 赵睿
 */
public class JavaExtend {
    public static void main(String[] args) {
        Fruit fruit=new Apple();
        Apple apple=new Apple();

        /*
            之所以这样的原因是：在编译的过程肯定的使用左边的，在执行的时候，看本栈中的局部变量表中的引用即可获得对象

            和函数区别，函数首先需要找到那个对象，然后从这个对象中找到对应的方法区中的方法执行，这样就出现了使用子类的方法的缘故了。
         */
        System.out.println(fruit.name);//Fruit
        System.out.println(apple.name); //Apple
    }
}

class Fruit{
    String name="Fruit";
    public void print(int i){
        System.out.println("Fruit"+i);
    }
}

class Apple extends Fruit{
    //属性可以继承，可以覆盖
    String name = "Apple";
    public void print(int i){
        System.out.println("Apple"+i);
    }
}



