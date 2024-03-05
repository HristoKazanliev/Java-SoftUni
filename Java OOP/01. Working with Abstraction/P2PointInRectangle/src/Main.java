import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        Point bottomCoordinates  = new Point(input[0], input[1]);
        Point topCoordinates  = new Point(input[2], input[3]);
        Rectangle rectangle = new Rectangle(bottomCoordinates, topCoordinates);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int[] checkCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                                            .mapToInt(Integer::parseInt)
                                            .toArray();
            Point point = new Point(checkCoordinates[0], checkCoordinates[1]);

            System.out.println(rectangle.contains(point));
        }
    }
}