import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> entries = new ArrayList<>();

        String input= scanner.nextLine();
        while (!"End".equals(input)) {
            String[] inputArgs = input.split("\\s+");
            if (inputArgs.length == 2) {
                String model = inputArgs[0];
                String id = inputArgs[1];
                Robot robot = new Robot(model, id);
                entries.add(robot);
            } else {
                String name = inputArgs[0];
                Integer age = Integer.parseInt(inputArgs[1]);
                String id = inputArgs[2];
                Citizen citizen = new Citizen(name, age, id);
                entries.add(citizen);
            }

            input = scanner.nextLine();
        }

        String lastDigits = scanner.nextLine();
        for (Identifiable entry : entries) {
            if (entry.getId().endsWith(lastDigits)) {
                System.out.println(entry.getId());
            }
        }
    }
}