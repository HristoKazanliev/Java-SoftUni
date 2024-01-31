import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String expression = scanner.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char currentCh = expression.charAt(i);

            if ('(' == currentCh) {
                stack.push(i);
            } else if (')' == currentCh) {
                int startIndex = stack.pop();
                String subExpression = expression.substring(startIndex, i + 1);
                System.out.println(subExpression);
            }
        }
    }
}