import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            Animal animal = createAnimal(input);
            input = scanner.nextLine();
            Food food = createFood(input);

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.printf("%s%n", animal.toString());
        }
    }

    private static Animal createAnimal(String input) {
        Animal animal = null;
        String[] inputArg = input.split("\\s+");
        String animalType = inputArg[0];
        String animalName = inputArg[1];
        Double animalWeight = Double.parseDouble(inputArg[2]);
        String animalLivingRegion = inputArg[3];

        if (animalType.equals("Cat")) {
            animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, inputArg[4]);
        } else if (animalType.equals("Tiger")) {
            animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
        } else if (animalType.equals("Mouse")) {
            animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
        } else if (animalType.equals("Zebra")) {
            animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
        }
        return animal;
    }

    private static Food createFood(String input) {
        Food food = null;
        String[] inputArg = input.split("\\s+");
        String foodType = inputArg[0];
        Integer foodQuantity = Integer.parseInt(inputArg[1]);

        if (foodType.equals("Meat")) {
            food = new Meat(foodQuantity);
        } else if (foodType.equals("Vegetable")) {
            food = new Vegetable(foodQuantity);
        }

        return food;
    }
}