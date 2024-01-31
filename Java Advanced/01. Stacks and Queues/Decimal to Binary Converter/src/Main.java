import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int decimalNum = Integer.valueOf(scanner.nextLine());

        if (decimalNum == 0) {
            System.out.println("0");
        } else {
            while (decimalNum != 0) {
                stack.push(decimalNum % 2);
                decimalNum /= 2;
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }
    }
}