import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> elements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
//            String[] input = scanner.nextLine().split("\\s+");
//            for (String el : input) {
//                elements.add(el);
//            }

            elements.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        System.out.println(String.join(" ", elements));;
        //elements.forEach(el -> System.out.print(el + " "));
    }
}