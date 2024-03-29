import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaTokens = scanner.nextLine().split("\\s+");
        String[] doughTokens = scanner.nextLine().split("\\s+");
        Pizza pizza = null;

        try {
            pizza = new Pizza(pizzaTokens[1], Integer.parseInt(pizzaTokens[2]));
            Dough dough = new Dough(doughTokens[1], doughTokens[2], Double.parseDouble(doughTokens[3]));

            pizza.setDough(dough);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] toppingTokens = input.split("\\s+");

            try {
                Topping topping = new Topping(toppingTokens[1], Double.parseDouble(toppingTokens[2]));
                pizza.addTopping(topping);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            input = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}