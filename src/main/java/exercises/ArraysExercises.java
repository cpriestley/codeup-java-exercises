package exercises;

import java.util.Arrays;

public class ArraysExercises {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));
        Person[] people = new Person[3];
        people[0] = new Person("John");
        people[1] = new Person("Jane");
        people[2] = new Person("Joe");
        System.out.println(Arrays.toString(people));
        people = addPerson(people, new Person("Jack"));
        System.out.println(Arrays.toString(people));
    }

    public static Person[] addPerson(Person[] people, Person person) {
        Person[] newPeople = Arrays.copyOf(people, people.length + 1);
        newPeople[newPeople.length - 1] = person;
        return newPeople;
    }
}
