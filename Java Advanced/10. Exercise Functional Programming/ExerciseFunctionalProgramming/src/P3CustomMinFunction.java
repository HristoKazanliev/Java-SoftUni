import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class P3CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine()
                                    .split("\\s+"))
                                    .map(Integer::parseInt)
                                    .toArray(Integer[]::new);

        Function<Integer[], Integer> findSmallestNumber = arr -> Arrays.stream(arr).min(Integer::compareTo).get();
        System.out.println(findSmallestNumber.apply(numbers));
    }
}
