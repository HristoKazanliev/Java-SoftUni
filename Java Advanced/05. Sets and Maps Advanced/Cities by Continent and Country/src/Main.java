import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> data = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String town = input[2];

            data.putIfAbsent(continent, new LinkedHashMap<>());
            data.get(continent).putIfAbsent(country, new ArrayList<>());
            data.get(continent).get(country).add(town);
        }

        for (String continent : data.keySet()) {
            System.out.println(continent + ":");
            for (String country: data.get(continent).keySet()) {
                System.out.print("  " + country + " -> ");
                System.out.println(String.join(", ", data.get(continent).get(country)));
            }
        }
    }
}