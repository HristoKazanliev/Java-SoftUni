public class Person implements Comparable<Person>{
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());
    }
}
