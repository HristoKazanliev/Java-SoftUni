import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        firstSet.stream()
                .filter(secondSet::contains)
                .forEach(x -> System.out.print(x + " "));
//        firstSet.retainAll(secondSet);
//        firstSet.forEach(x -> System.out.print(x + " "));
    }
}