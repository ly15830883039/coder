# 包装类 （自动拆装箱）
## 1. 包装类是一个封装java 基本类型的对象，每一个java基本类型都有其对于的包装类。
    | 基本类型 | 包装类 |
    | ---  | ---|
    | boolean |  java.lang.Boolean |
    | byte |  java.langByte |
    |short |  java.langShort |
    | char |  java.langCharacter |
    |int |  java.langInteger |
    | long |  java.langLong |
    | float |  java.langFloat |
    | double |  java.langDouble |


## 2. 一个包装类的目的是什么？
这是一个最常见的java面试题。
基本上，通常类只能成为一个个对象，而不支持 基本数据类型。作为这个结果，如果我们要操作基本数据类型，我们需要将基本数据类型包装为一个对象。
> 比如说，java 的 Collection  这个框架 只能用于处理对象相关的操作。在java5之前，没有自动拆装箱，
>所以，无法使用 collection 来添加一个 int，即 add(5); 如果要使用 Collection 必须手动的将 int 转换为 Integer。
> 现在，伴随的自动装箱，我们能够很容易的往 ArrayList中 执行 add(101)。但是内部的java 在存储之前，使用valueOf（），将 基本数据类型，转为 Integer

## 3. 基本类型转换为包装类。
1. 将int 转换为 Integer,返回的值的繁殖为
```
Integer object = new Integer(1);

Integer anotherObject = Integer.valueOf(1);
```

2. 我们要将 String 转换为整数，需要使用 parseInt(); 因为 String 不是一个包装类
3. 我们也可以使用
```
int val = object.intValue();
```

### 4. 自动拆装箱
1. autoboxing 自动装箱
```
List<Integer> list = new ArrayList<>();
list.add(1); // autoboxing 自动装箱

Integer val = 2; // autoboxing 自动装箱
```

2. unboxing 自动拆箱
```
Integer object = new Integer(1);
int val1 = getSquareValue(object); //unboxing 自动拆箱
int val2 = object; //unboxing 自动拆箱

public static int getSquareValue(int i) {
    return i*i;
}
```

# 资料来源：
1. [Baeldung java-wrapper-classes](http://www.baeldung.com/java-wrapper-classes)
