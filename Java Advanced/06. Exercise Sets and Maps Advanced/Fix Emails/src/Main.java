import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!"stop".equals(name)) {
            String email = scanner.nextLine();
            emails.put(name, email);

            name = scanner.nextLine();
        }

        emails.entrySet().removeIf(x -> x.getValue().endsWith("com")
                                        || x.getValue().endsWith("uk")
                                        || x.getValue().endsWith("us"));

        emails.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}