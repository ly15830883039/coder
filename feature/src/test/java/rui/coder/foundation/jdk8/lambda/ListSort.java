package rui.coder.foundation.jdk8.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author 赵睿
 */
class ListSort {

    private List<Person> personList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        personList.add(new Person("Virat", "Kohli"));
        personList.add(new Person("Arun", "Kumar"));
        personList.add(new Person("Rajesh", "Mohan"));
        personList.add(new Person("Rahul", "Dravid"));
    }


    @SuppressWarnings({"Java8ListSort", "Convert2Lambda"})
    @Test
    void sortBefore8() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
    }

    @SuppressWarnings({"ComparatorCombinators", "Java8ListSort"})
    @Test
    void sort1() {
        Collections.sort(personList,
                (Person o1, Person o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    }

    @SuppressWarnings({"ComparatorCombinators", "Java8ListSort"})
    @Test
    void sort2() {
        Collections.sort(personList,
                (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    }


    @SuppressWarnings("Java8ListSort")
    @Test
    void sort3() {
        Collections.sort(personList, Comparator.comparing(Person::getFirstName));
    }

    @SuppressWarnings("ComparatorCombinators")
    @Test
    void sort4() {
        personList.sort((o1,o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    }
    @Test
    void sort5() {
        personList.sort(Comparator.comparing(Person::getFirstName));
    }


    @Test
    void lambda() {
        personList.forEach(person -> System.out.println(person));

        personList.forEach(System.out::println);
    }
}