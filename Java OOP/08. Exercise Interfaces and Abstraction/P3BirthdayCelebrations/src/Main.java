import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> printBirthdays = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    printBirthdays.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(tokens[1], tokens[2]);
                    printBirthdays.add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();
        printBirthdays.stream().
                filter(b -> b.getBirthDate().endsWith(year)).
                forEach(b -> System.out.println(b.getBirthDate()));
    }
}