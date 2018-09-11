package rui.coder.design.pattern.structure.filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CriteriaTest {

    private List<Person> persons = new ArrayList<>();

    private Criteria male = new CriteriaMale();
    private Criteria female = new CriteriaFemale();
    private Criteria single = new CriteriaSingle();
    private Criteria singleMale = new AndCriteria(single, male);
    private Criteria singleOrFemale = new OrCriteria(single, female);

    @BeforeEach
    void setUp() {
        persons.add(new Person("Robert", "Male", "Single"));
        persons.add(new Person("John", "Male", "Married"));
        persons.add(new Person("Laura", "Female", "Married"));
        persons.add(new Person("Diana", "Female", "Single"));
        persons.add(new Person("Mike", "Male", "Single"));
        persons.add(new Person("Bobby", "Male", "Single"));
    }

    @Test
    void males() {
        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));
    }

    @Test
    void female() {
        System.out.println("Females: ");
        printPersons(female.meetCriteria(persons));
    }

    @Test
    void single() {
        System.out.println("Single Males: ");
        printPersons(singleMale.meetCriteria(persons));
    }

    @Test
    void singleOrFemales() {
        System.out.println("Single Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    private static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    + ", Gender : " + person.getGender()
                    + ", Marital Status : " + person.getMaritalStatus()
                    + " ]");
        }
    }


}