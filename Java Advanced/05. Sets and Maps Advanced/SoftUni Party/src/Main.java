import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"END".equals(input)) {
            if (vip.contains(input)) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }

            input = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());

        for (String vipGuest : vip) {
            System.out.println(vipGuest);
        }

        for (String regularGuest : regular) {
            System.out.println(regularGuest);
        }
    }
}