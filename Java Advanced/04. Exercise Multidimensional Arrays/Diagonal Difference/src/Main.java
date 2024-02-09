import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(matrix, scanner);

        int sumPrimaryDiagonal = getSumPrimaryDiagonal(matrix);
        int sumSecondaryDiagonal = getSumSecondaryDiagonal(matrix);

//        int sumPrimaryDiagonal = 0;
//        int sumSecondaryDiagonal = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            int currPrimaryDiagonal = matrix[i][i];
//            int currSecondaryDiagonal = matrix[i][size - i - 1];
//
//            sumPrimaryDiagonal += currPrimaryDiagonal;
//            sumSecondaryDiagonal += currSecondaryDiagonal;
//        }
//
        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }

    private static int getSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (col == matrix.length - row - 1) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }

    private static int getSumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row == col) {
                    sum += matrix[row][col];
                }
            }
        }

        return sum;
    }

    public static void fillMatrix(int[][] matrix, Scanner scanner) {
        int rows = matrix.length;

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        }

//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < rows; col++) {
//                matrix[row][col] = scanner.nextInt();
//            }
//        }
    }
}