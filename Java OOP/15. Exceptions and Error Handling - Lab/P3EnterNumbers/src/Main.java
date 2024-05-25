import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = 1;
        int end = 100;
        int counter = 0;
        int num = 0;
        int[] numbers = new int[10];

        while (counter < 10) {
            num = readNumber(start, end, scanner);
            if (num > start)
            {
                start = num;
                numbers[counter] = num;
                counter++;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d", numbers[i]);
            if (i < numbers.length - 1) {
                System.out.printf(", ");
            }
        }
    }

    private static int readNumber(int start, int end, Scanner scanner) {
        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            if ( number > start && number < end) {
                start = number;
            } else throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number!");
        } catch (IllegalArgumentException e) {
            System.out.printf("Your number is not in range %d - %d!%n", start, end);
        }

        return start;
    }
}