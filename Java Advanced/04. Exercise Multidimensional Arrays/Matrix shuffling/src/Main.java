import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] commandArr = command.split("\\s+");

            if (isValid(commandArr, rows, cols)) {
                String firstEl = matrix[Integer.parseInt(commandArr[1])][Integer.parseInt(commandArr[2])];
                String secondEl = matrix[Integer.parseInt(commandArr[3])][Integer.parseInt(commandArr[4])];

                matrix[Integer.parseInt(commandArr[1])][Integer.parseInt(commandArr[2])] = secondEl;
                matrix[Integer.parseInt(commandArr[3])][Integer.parseInt(commandArr[4])] = firstEl;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }
    }

    private static boolean isValid(String[] cmdArr, int rows, int cols) {
        String keyword = cmdArr[0];

        if ("swap".equals(keyword) && cmdArr.length == 5) {
            int rowFirstEl = Integer.parseInt(cmdArr[1]);
            int colFirstEl = Integer.parseInt(cmdArr[2]);
            int rowSecondEl = Integer.parseInt(cmdArr[3]);
            int colSecondEl = Integer.parseInt(cmdArr[4]);

            if (rowFirstEl < 0 || rowFirstEl > rows
                || rowSecondEl < 0 || rowSecondEl > rows
                || colFirstEl < 0 || colFirstEl > cols
                || colSecondEl < 0 || colSecondEl > cols) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] row: matrix) {
            for (String el: row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}