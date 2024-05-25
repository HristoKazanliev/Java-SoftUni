import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int startIndex = 0;
    private static int endIndex = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        startIndex = range[0];
        endIndex = range[1];

        System.out.printf("Range: [%d...%d]%n", startIndex, endIndex);

        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (isValid(number)) {
                    System.out.println("Valid number: " + number);
                    return;
                } else System.out.println("Invalid number: " + input);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number: " + input);
            }
        }
    }

    private static boolean isValid(int num) {
        return startIndex <= num && num <= endIndex;
    }
}