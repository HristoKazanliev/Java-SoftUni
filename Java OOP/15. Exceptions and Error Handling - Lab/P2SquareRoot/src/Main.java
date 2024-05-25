import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            int number = Integer.parseInt(input);
            if ( number > 0 ) {
                double squareNumber = Math.sqrt(number);
                System.out.printf("%.2f%n", squareNumber);
            } else throw new NumberFormatException();
        } catch (Exception e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}