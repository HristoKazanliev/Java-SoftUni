import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P4AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers= Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addCmd = list -> list.stream().map(num -> num + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractCmd = list -> list.stream().map(num -> num - 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyCmd = list -> list.stream().map(num -> num * 2).collect(Collectors.toList());
        Consumer<List<Integer>> printCmd = list -> list.forEach(num -> System.out.print(num + " "));

        String line = scanner.nextLine();
        while (!"end".equals(line)) {
            switch (line) {
                case "add":
                    numbers = addCmd.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractCmd.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyCmd.apply(numbers);
                    break;
                case "print":
                    printCmd.accept(numbers);
                    System.out.println();
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
