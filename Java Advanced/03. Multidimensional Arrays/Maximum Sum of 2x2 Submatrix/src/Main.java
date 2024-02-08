import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();
        }

        int highestSum  = Integer.MIN_VALUE;
        int highestRow = 0;
        int highestCol = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                                + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (currentSum > highestSum) {
                    highestSum = currentSum;
                    highestRow = row;
                    highestCol = col;
                }
            }
        }

        for (int row = highestRow; row < highestRow + 2; row++) {
            for (int col = highestCol; col < highestCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println(highestSum);
    }
}