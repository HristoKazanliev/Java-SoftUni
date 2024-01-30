import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<String>();

        String input = scanner.nextLine();
        while (!"Home".equals(input)) {
            if (!"back".equals(input)) {
                stack.push(input);
                System.out.println(input);
            } else {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }

            input = scanner.nextLine();
        }
    }
}