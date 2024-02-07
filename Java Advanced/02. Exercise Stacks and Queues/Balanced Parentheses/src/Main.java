import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        Stack<String> stack = new Stack<>();
        boolean isBalanced = true;

        for (String bracket : input) {
            if (bracket.equals("(") || bracket.equals("[") || bracket.equals("{")) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                } else {
                    if (")".equals(bracket) && "(".equals(stack.peek())) {
                        stack.pop();
                    } else if ("}".equals(bracket) && "{".equals(stack.peek())) {
                        stack.pop();
                    } else if ("]".equals(bracket) && "[".equals(stack.peek())) {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                }
            }
        }

        String result = isBalanced ? "YES" : "NO";
        System.out.println(result);
    }
}