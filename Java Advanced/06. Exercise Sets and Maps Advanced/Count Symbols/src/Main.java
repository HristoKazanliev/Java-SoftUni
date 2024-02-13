import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> symbols = new TreeMap<>();

        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (!symbols.containsKey(symbol)) {
                symbols.put(symbol, 1);
            } else {
                symbols.put(symbol, symbols.get(symbol) + 1);
            }
        }

        symbols.entrySet().forEach(pair -> System.out.println(pair.getKey() + ": " + pair.getValue() + " time/s"));
    }
}