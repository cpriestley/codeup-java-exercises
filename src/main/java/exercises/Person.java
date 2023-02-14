package exercises;

public class Person implements Cloneable {
    String name;

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("John");
        Person person2 = person1;
        System.out.println(person1.getName());
        System.out.println(person2.getName());
        person1.sayHello();
        person2.sayHello();
        person2.setName("Jane");
        System.out.println(person1.getName());
        System.out.println(person2.getName());
        person1.sayHello();
        person2.sayHello();

        Person person3 = (Person) person2.clone();
        System.out.printf("Clone name: %s%n", person3.getName());
    }

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.format("%s says hello%n", name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
