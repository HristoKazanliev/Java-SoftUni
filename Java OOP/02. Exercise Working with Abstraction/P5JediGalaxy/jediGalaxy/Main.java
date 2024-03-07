package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int rows = dimensions[0];
            int cols = dimensions[1];

            int[][] matrix = new int[rows][cols];

            fillMatrix(matrix, rows, cols);

            String command = scanner.nextLine();
            long sum = 0;
            while (!"Let the Force be with you".equals(command)) {
                int[] jediCoordinates  = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int rowEvil = evilCoordinates[0];
                int colEvil = evilCoordinates[1];

                moveEvil(matrix, rowEvil, colEvil);

                int rowJedi = jediCoordinates[0];
                int colJEdi = jediCoordinates[1];
                sum += moveJedi(matrix, rowJedi, colJEdi);

                command = scanner.nextLine();
            }

        System.out.println(sum);
    }

    private static void fillMatrix(int[][] matrix, int rows, int cols) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
    }

    private static void moveEvil(int[][] matrix, int rowEvil, int colEvil) {
        while (rowEvil >= 0 && colEvil >= 0) {
            if (rowEvil >= 0 && rowEvil < matrix.length && colEvil >= 0 && colEvil < matrix[0].length) {
                matrix[rowEvil] [colEvil] = 0;
            }
            rowEvil--;
            colEvil--;
        }
    }

    private static int moveJedi(int[][] matrix, int rowJedi, int colJEdi) {
        int collectedStars = 0;
        while (rowJedi >= 0 && colJEdi < matrix[1].length)
        {
            if (rowJedi >= 0 && rowJedi < matrix.length && colJEdi >= 0 && colJEdi < matrix[0].length)
            {
                collectedStars += matrix[rowJedi][colJEdi];
            }

            colJEdi++;
            rowJedi--;
        }

        return collectedStars;
    }
}
