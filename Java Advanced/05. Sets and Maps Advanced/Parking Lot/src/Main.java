import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(",\\s+");
            String direction = tokens[0];
            String carPlate = tokens[1];

            if ("IN".equals(direction)) {
                parking.add(carPlate);
            } else if ("OUT".equals(direction)) {
                parking.remove(carPlate);
            }

            input = scanner.nextLine();
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String number: parking) {
                System.out.println(number);
            }
        }
    }
}