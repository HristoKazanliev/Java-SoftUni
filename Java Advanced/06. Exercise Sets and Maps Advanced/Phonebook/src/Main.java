import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        String input = scanner.nextLine();
        while (!"search".equals(input)) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phonebook.put(name, number);

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!"stop".equals(name)) {
            if (phonebook.containsKey(name)) {
                System.out.println(name + " -> " + phonebook.get(name));
            } else {
                System.out.println("Contact " + name + " does not exist.");
            }

            name = scanner.nextLine();
        }
    }
}