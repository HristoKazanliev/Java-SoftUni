
package workingWithAbstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static long gold = 0;
    private static long gems = 0;
    private static long cash = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            String itemType = getItemType(name);

            if (itemType.equals("")) {
                continue;
            } else if (bagCapacity < getBagCapacity(bag, amount)) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > getAmountInBag(bag, "Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (getAmountInBag(bag, itemType) + amount > getAmountInBag(bag, "Gold")) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > getAmountInBag(bag, "Gold")) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (getAmountInBag(bag, itemType) + amount > getAmountInBag(bag, "Gem")) {
                        continue;
                    }
                    break;
            }

            addToBag(bag, itemType, name, amount);

            increaseQuantity(itemType, amount);
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static String getItemType(String currItemType) {
        String itemType = "";

        if (currItemType.length() == 3) {
            itemType = "Cash";
        } else if (currItemType.toLowerCase().endsWith("gem")) {
            itemType = "Gem";
        } else if (currItemType.toLowerCase().equals("gold")) {
            itemType = "Gold";
        }

        return itemType;
    }

    private static long getBagCapacity(Map<String, LinkedHashMap<String, Long>> bag, long amount) {
        return bag.values().stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .mapToLong(e -> e).sum() + amount;
    }

    private static long getAmountInBag(Map<String, LinkedHashMap<String, Long>> bag, String gold) {
        return bag.get(gold).values().stream().mapToLong(e -> e).sum();
    }

    private static void addToBag(Map<String, LinkedHashMap<String, Long>> bag,  String itemType, String itemName, long amount) {
        if (!bag.containsKey(itemType)) {
            bag.put((itemType), new LinkedHashMap<String, Long>());
        }

        if (!bag.get(itemType).containsKey(itemName)) {
            bag.get(itemType).put(itemName, 0L);
        }

        bag.get(itemType).put(itemName, bag.get(itemType).get(itemName) + amount);
    }

    private static void increaseQuantity(String itemType, long currAmount) {
        if (itemType.equals("Gold")) {
            gold += currAmount;
        } else if (itemType.equals("Gem")) {
            gems += currAmount;
        } else if (itemType.equals("Cash")) {
            cash += currAmount;
        }
    }
}