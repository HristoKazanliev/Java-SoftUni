import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = arr[col];
                sum += arr[col];
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }
}