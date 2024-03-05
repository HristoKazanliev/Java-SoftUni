import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int starsCount = 1; starsCount <= n; starsCount++) {
            printRow(n , starsCount);
        }

        for (int starsCount = n - 1; starsCount >= 1; starsCount--) {
            printRow(n, starsCount);
        }
    }

    public static void printRow(int figureSize, int starsCount) {
        for (int i = 0; i < figureSize - starsCount; i++) {
            System.out.print(" ");
        }

        for (int i = 1; i < starsCount; i++) {
            System.out.print("* ");
        }

        System.out.println("*");
    }
}