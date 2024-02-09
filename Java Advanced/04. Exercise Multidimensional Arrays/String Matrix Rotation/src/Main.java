import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[()]");
        int rotationAngle = Integer.parseInt(input[1]) % 360;

        List<String> linesForMatrix = new ArrayList<>();
        String line = scanner.nextLine();
        int maxLength = Integer.MIN_VALUE;
        while (!"END".equals(line)) {
            linesForMatrix.add(line);

            if (line.length() > maxLength) {
                maxLength = line.length();
            }

            line = scanner.nextLine();
        }

        int rows = linesForMatrix.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < linesForMatrix.get(row).length()) {
                    matrix[row][col] = linesForMatrix.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        rotateMatrix(rotationAngle, rows, cols, matrix);
    }

    public static void rotateMatrix(int rotationAngle, int rows, int cols, char[][] matrix) {
        if (rotationAngle == 0) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 90) {
            for (int col = 0; col < cols; col++) {
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 180) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (rotationAngle == 270) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}