import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCmds = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numOfCmds; i++) {
            String[] cmdInput = scanner.nextLine().split("\\s+");

            switch (cmdInput[0]) {
                case "1":
                    stack.push(Integer.parseInt(cmdInput[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}