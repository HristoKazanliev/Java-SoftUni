import java.util.*;

public class Main {
    public static Map<String, Integer> getSymbolsValues() {
        //Map.of() - maximum of 10 elements
        Map<String, Integer> cardValue = new HashMap<>();
        cardValue.put("2", 2);
        cardValue.put("3", 3);
        cardValue.put("4", 4);
        cardValue.put("5", 5);
        cardValue.put("6", 6);
        cardValue.put("7", 7);
        cardValue.put("8", 8);
        cardValue.put("9", 9);
        cardValue.put("10", 10);
        cardValue.put("J", 11);
        cardValue.put("Q", 12);
        cardValue.put("K", 13);
        cardValue.put("A", 14);
        cardValue.put("S", 4);
        cardValue.put("H", 3);
        cardValue.put("D", 2);
        cardValue.put("C", 1);
        return cardValue;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"JOKER".equals(input)) {
            String[] tokens = input.split(": "); //Peter: 2C, 4H, 9H, AS, QS
            String playerName = tokens[0];             //"Peter"

            players.putIfAbsent(playerName, new HashSet<>());

            //["2C", "4H", "9H", "AS", "QS"]
            Arrays.stream(tokens[1].split(", "))
                    .forEach(players.get(playerName)::add);

            input = scanner.nextLine();
        }

        players.forEach((player, cards) -> {
            int points = calculatePoints(cards);
            System.out.printf("%s: %d\n", player, points);
        });
    }

    private static int calculatePoints(Set<String> cards){
        Map<String, Integer> symbolsValues = getSymbolsValues();
        int points = 0;
        for (String card : cards) {
            //"10C"
            String cardPower = card.substring(0, card.length() - 1);
            String type = String.valueOf(card.charAt(card.length() - 1));

            points += symbolsValues.get(cardPower) * symbolsValues.get(type);
        }

        return points;
    }
}