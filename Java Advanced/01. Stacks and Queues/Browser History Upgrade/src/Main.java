import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!"Home".equals(input)) {
            if ("back".equals(input)) {
                if (stack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    queue.addFirst(stack.pop());
                    System.out.println(stack.peek());
                }
            } else if ("forward".equals(input)){
                if (queue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(queue.peek());
                    stack.push(queue.poll());
                }
            } else {
                stack.push(input);
                System.out.println(stack.peek());
                queue.clear();
            }

            input = scanner.nextLine();
        }
    }
}