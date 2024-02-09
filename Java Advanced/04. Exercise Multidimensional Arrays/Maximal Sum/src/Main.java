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
        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        int highestSum  = Integer.MIN_VALUE;
        int highestRow = 0;
        int highestCol = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                                + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                                + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > highestSum) {
                    highestSum = currentSum;
                    highestRow = row;
                    highestCol = col;
                }
            }
        }

        System.out.println("Sum = " + highestSum);
        printMatrix(matrix, highestRow, highestCol);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static void printMatrix(int[][] matrix, int highestRow, int highestCol) {
        for (int row = highestRow; row <= highestRow + 2; row++) {
            for (int col = highestCol; col <= highestCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}