import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();

        int firstRows = dimensions[0];
        int firstCols = dimensions[1];

        int[][] firstMatrix = new int[firstRows][firstCols];

        for (int row = 0; row < firstRows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            firstMatrix[row] = arr;
//            for (int col = 0; col < firstCols; col++) {
//                firstMatrix[row][col] = scanner.nextInt();
//            }
        }

        dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int secondRows = dimensions[0];
        int secondCols = dimensions[1];

        int[][] secondMatrix = new int[secondRows][secondCols];

        for (int row = 0; row < secondRows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            secondMatrix[row] = arr;
//            for (int col = 0; col < secondCols; col++) {
//                secondMatrix[row][col] = scanner.nextInt();
//            }
        }

        System.out.println(matricesAreEqual(firstMatrix, secondMatrix) ? "equal" : "not equal");
    }

    public static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) return false;

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) return false;
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) return false;
            }
        }

        return true;
    }
}