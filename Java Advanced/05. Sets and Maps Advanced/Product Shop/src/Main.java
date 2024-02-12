import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> stores = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(", ");
            String store = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);

            stores.putIfAbsent(store, new  LinkedHashMap<>());
//            if (stores.get(store).isEmpty()) {
//                stores.put(store, new LinkedHashMap<>());
//            }
            stores.get(store).put(product, price);

            input = scanner.nextLine();
        }

        for(String store : stores.keySet()){
            System.out.println(store + "->");
            for(String p : stores.get(store).keySet()){
                System.out.printf("Product: %s, Price: %.1f\n", p, stores.get(store).get(p));
            }

        }
    }
}