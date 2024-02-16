import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> predicate;

        String input = scanner.nextLine();
        while (!"Party!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String criteria  = tokens[1];
            String parameter  = tokens[2];

            switch (criteria) {
                case "StartsWith":
                    predicate = x -> x.startsWith(parameter);
                    break;
                case "EndsWith":
                    predicate = x -> x.endsWith(parameter);
                    break;
                default:
                    predicate = x -> x.length() == Integer.parseInt(parameter);
                    break;
            }

            if ("Remove".equals(command)) {
                names.removeIf(predicate);
            } else {
                List<String> guestsToAdd = names.stream().filter(predicate).collect(Collectors.toList());
                names.addAll(guestsToAdd);
            }

            input = scanner.nextLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String result = names.stream().sorted().collect(Collectors.joining(", "));
            System.out.println(result + " are going to the party!");
        }
    }
}
