import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P6FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        String condition = scanner.nextLine();

        Function<String, IntPredicate> isEven = x -> "even".equals(x) ? n -> n % 2 == 0 : n -> n % 2 != 0;
        IntPredicate predicate = isEven.apply(condition);
        IntConsumer intConsumer = n -> System.out.print(n + " ");

        IntStream.range(bounds[0], bounds[1] + 1)
                .filter(predicate)
                .forEach(intConsumer);
    }
}
