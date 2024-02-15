import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P1SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersInput = Arrays.stream(scanner.nextLine().split(", "))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toList());

        //numbersInput.removeIf(n -> n % 2 != 0);
        List<Integer> evenNums = numbersInput.stream()
                                    .filter(n -> n % 2 ==0)
                                    .collect(Collectors.toList());

        //System.out.println(evenNums.toString().replaceAll("\\[|]]", ""));
        //evenNums.sort(Integer::compareTo);
        String firstOutput = evenNums
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(firstOutput);

        String secondOutput = evenNums
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(secondOutput);
    }
}