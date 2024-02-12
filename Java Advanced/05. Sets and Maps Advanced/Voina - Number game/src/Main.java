import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> playerOne = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> playerTwo = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {
            if (playerOne.isEmpty() || playerTwo.isEmpty()) {
                break;
            }

            int firstNumber = playerOne.iterator().next();
            playerOne.remove(firstNumber);
            int secondNumber = playerTwo.iterator().next();
            playerTwo.remove(secondNumber);

            if (firstNumber > secondNumber) {
                playerOne.add(firstNumber);
                playerOne.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                playerTwo.add(firstNumber);
                playerTwo.add(secondNumber);
            }
        }

        if (playerOne.size() > playerTwo.size()) {
            System.out.println("First player win!");
        } else if (playerTwo.size() > playerOne.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}