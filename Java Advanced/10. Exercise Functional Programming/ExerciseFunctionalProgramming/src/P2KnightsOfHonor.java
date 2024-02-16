import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P2KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Consumer<String> printName = name -> System.out.println("Sir " + name);
        for (String name : input) {
            printName.accept(name);
        }
        //Arrays.stream(input).forEach(printName);
    }
}
