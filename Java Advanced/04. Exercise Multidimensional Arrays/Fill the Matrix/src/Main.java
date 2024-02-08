import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = null;
        if ("A".equals(pattern)) {
            matrix = CreatePatternA(size);
        } else if ("B".equals(pattern)) {
            matrix = CreatePatternB(size);
        }

        printMatrix(matrix);
    }

    public static int[][] CreatePatternA(int size) {
        int[][] matrix = new int[size][size];
        int number = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = number++;
            }
        }
        
        return matrix;
    }

    public static int[][] CreatePatternB(int size) {
        int[][] matrix = new int[size][size];
        int number = 1;

        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = number++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = number++;
                }
            }

        }

        return matrix;
    }
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}