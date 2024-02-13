import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1))
                .limit(3)
                .collect(Collectors.toList());

        for (int num : numbers) {
            System.out.print(num + " ");
        }
        

//        List<Integer> nums = new ArrayList<>();
//        ascending order
//        nums = nums.stream()
//                .sorted((n1 , n2) -> n1.compareTo(n2))
//                .collect(Collectors.toList());
//        descending order
//        nums = nums.stream()
//                .sorted((n1 , n2) -> n2.compareTo(n1))
//                .collect(Collectors.toList());


//        Map<Integer, String> products = new HashMap<>();
//        products.put(3, "a");
//        products.put(4, "b");
//        products.put(2, "b");
//        products.put(1, "c");
//        products.entrySet()
//                .stream()
//                .sorted((e1, e2) -> {
//                    int res = e2.getValue().compareTo(e1.getValue());
//                    if (res == 0)
//                        res = e1.getKey().compareTo(e2.getKey());
//                    return res; })
//                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

//        Map<String, Integer> mp = new HashMap<>();
//        mp.put("Aries", 1);
//        mp.put("Taurus", 2);
//        mp.put("Gemini", 3);
//        Map<String, Integer> resultMap = mp.entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey,
//                        Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));

    }
}