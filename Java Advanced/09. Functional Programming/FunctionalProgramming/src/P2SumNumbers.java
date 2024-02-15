import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Function<String, Integer> countNumbers = num -> num.split(", ").length;
        int count = countNumbers.apply(input);

        Function<String, Integer> sumNumbers = num ->
            Arrays.stream(num.split(", ")).mapToInt(Integer::parseInt).sum();
        int sum = sumNumbers.apply(input);

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
    }
}
