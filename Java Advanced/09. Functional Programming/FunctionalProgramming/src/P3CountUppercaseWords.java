import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P3CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> printToConsole = s -> System.out.println(s);

        List<String> upperWords = Arrays.stream(input)
                                        .filter(isUpperCase)
                                        .collect(Collectors.toList());

//        for (int i = 0; i < input.length; i++) {
//            if (isUpperCase.test(input[i]))
//                upperWords.add(input[i]);
//        }

        printToConsole.accept(String.valueOf(upperWords.size()));
        upperWords.forEach(printToConsole);
//        System.out.println(upperWords.size());
//        System.out.println(String.join(System.lineSeparator(), upperWords));
    }
}
