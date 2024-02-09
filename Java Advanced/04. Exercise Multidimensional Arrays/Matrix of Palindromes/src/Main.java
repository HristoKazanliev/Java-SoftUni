import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = fillMatrix(rows, cols);

        printMatrix(matrix);
    }

    public  static String[][] fillMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstAndThird = (char)(row + 'a');
                char second = (char)(firstAndThird + col);
                String result = String.valueOf(firstAndThird) + second + firstAndThird;
                matrix[row][col] = result;
            }
        }

        return matrix;
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}