import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class P4AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnaryOperator<Double> vatTax = x -> x * 1.2;

        Double[] result = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(vatTax)
                .toArray(Double[]::new);


        Consumer<Double[]> printArr = x -> {
            System.out.println("Prices with VAT:");
            for (double d : x) {
                System.out.printf("%.2f%n", d);
            }
        };

        printArr.accept(result);
    }
}
