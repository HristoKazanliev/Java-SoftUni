import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                //.sorted(Comparator.comparing(person -> person.getName()))
                .sorted()
                .forEach(System.out::println);

//        for (Person person : people) {
//            System.out.println(person.toString());
//        }
    }
}