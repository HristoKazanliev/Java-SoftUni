import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToDouble(Double::parseDouble)
                                .toArray();
        for (double number : input) {
            //numbers.putIfAbsent(number, 0);
            if (numbers.containsKey(number)) {
                numbers.put(number, numbers.get(number) + 1);
            } else {
                numbers.put(number, 1);
            }
        }

        for (double number : numbers.keySet()) {
            System.out.println(String.format("%.1f -> %d", number, numbers.get(number)));
        }
    }
}