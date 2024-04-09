import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Citizen> citizenList = new ArrayList<>();
        List<Rebel> rebelList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 4) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                citizenList.add(citizen);
            } else if (tokens.length == 3) {
                Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                rebelList.add(rebel);
            }
        }

        String nameInput = scanner.nextLine();
        while (!"End".equals(nameInput)) {
            for (Citizen citizen : citizenList) {
                if (citizen.getName().equals(nameInput)) {
                    citizen.buyFood();
                }
            }

            for (Rebel rebel : rebelList) {
                if (rebel.getName().equals(nameInput)) {
                    rebel.buyFood();
                }
            }

            nameInput = scanner.nextLine();
        }

        int totalFood = 0;
        for (Citizen citizen : citizenList) {
            totalFood += citizen.getFood();
        }

        for (Rebel rebel : rebelList) {
            totalFood += rebel.getFood();
        }

        System.out.println(totalFood);
    }
}