import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<String>();
        String[] expression = scanner.nextLine().split("\\s+");

        //Collections.addAll(stack, expression);
        for (int i = expression.length - 1; i >= 0; i--) {
            String el = expression[i];
            stack.push(el);
        }

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(firstNum + secondNum));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNum - secondNum));
                    break;
            }
        }

        System.out.println(stack.pop());
    }
}