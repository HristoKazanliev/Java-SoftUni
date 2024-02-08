import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        char[][] firstMatrix = CreateMatrix(rows, cols, scanner);
        char[][] secondMatrix = CreateMatrix(rows, cols, scanner);
        PrintMatrix(firstMatrix, secondMatrix);
    }

    private static char[][] CreateMatrix(int rows, int cols, Scanner scanner) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.next().charAt(0);
            }
        }

        return matrix;
    }

    private static void PrintMatrix(char[][] firstMatrix, char[][] secondMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }

            System.out.println();
        }
    }
}