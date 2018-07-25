package rui.coder.foundation.collection.list.copy;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@DisplayName("数组拷贝")
class ListCopy {

    private List<Person> sourceList;
    private List<Person> copyList;

    @BeforeEach
    void setUp() {
        sourceList = Stream.generate(Person::random)
                .limit(17)
                .collect(Collectors.toList());
    }


    /**
     * 浅拷贝 实质虽然拷贝，但是是里面的数据内容仍然指向同一个对象；即修改这个对象，同样会对拷贝之前的list 和copy之后的list生效
     */
    @Nested
    @DisplayName("浅拷贝")
    class ShallowCopy {

        @SuppressWarnings("UseBulkOperation")
        @Test
        @DisplayName("遍历循环复制")
        void forEachCopy() {
            copyList = new ArrayList<>(sourceList.size());
            for (Person person : sourceList) {
                copyList.add(person);
            }
        }


        @Test
        @DisplayName("使用构造方法")
        void userConstruction() {
            copyList = new ArrayList<>(sourceList);
        }

        @Test
        @DisplayName("使用list.addAll()方法")
        void addAll() {
            copyList = new ArrayList<>(sourceList.size());
            copyList.addAll(sourceList);
        }

        @Test
        @DisplayName("使用System.arraycopy()方法")
        void arraycopy() {
            Person[] src = sourceList.toArray(new Person[0]);
            Person[] copy = new Person[src.length];
            System.arraycopy(src, 0, copy, 0, src.length);
            copyList = Arrays.asList(copy);
        }

        @SuppressWarnings("unchecked")
        @Test
        @DisplayName("使用 ArrayList的clone方法")
        void useArrayListClone() {
            copyList = (List<Person>) ((ArrayList) sourceList).clone();
        }

        @AfterEach
        void tearDown() {
            Person person = sourceList.get(3);
            String beforeName = person.name;
            String afterName = UUID.randomUUID().toString();
            person.name = afterName;
            assertNotEquals(beforeName, copyList.get(3).name);
            assertEquals(afterName, copyList.get(3).name);
        }
    }

    /**
     * 深拷贝 拷贝的同时 生成新的对象和数组，保证数据 修改，不会对两个数组产生影响
     */
    @Nested
    @DisplayName("深拷贝")
    class DeepCopy {

        @SuppressWarnings("unchecked")
        @Test
        @DisplayName("使用序列化")
        void serializable() throws IOException, ClassNotFoundException {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(sourceList);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);

            copyList = (List<Person>) in.readObject();
        }

        @SuppressWarnings("unchecked")
        @Test
        @DisplayName("使用 clone方法")
        void useClone() throws CloneNotSupportedException {
            copyList = new ArrayList<>(sourceList.size());
            for (Person person : sourceList) {
                copyList.add((Person) person.clone());
            }
        }

        @AfterEach
        void tearDown() {
            Person person = sourceList.get(3);
            String beforeName = person.name;
            String afterName = UUID.randomUUID().toString();
            person.name = afterName;
            assertEquals(beforeName, copyList.get(3).name);
            assertNotEquals(afterName, copyList.get(3).name);
        }
    }


    private static class Person implements Serializable, Cloneable {
        private String name;

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        static Person random() {
            Person person = new Person();
            person.name = UUID.randomUUID().toString();
            return person;
        }
    }
}
