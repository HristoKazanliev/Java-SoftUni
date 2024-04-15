import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInput = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));
        String[] truckInput = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandTokens = scanner.nextLine().split("\\s+");
            String command = commandTokens[0];
            String vehicle = commandTokens[1];

            if ("Drive".equals(command)) {
                if ("Car".equals(vehicle)) {
                    System.out.printf("%s%n", car.drive(Double.parseDouble(commandTokens[2])));
                } else {
                    System.out.printf("%s%n", truck.drive(Double.parseDouble(commandTokens[2])));
                }
            } else if ("Refuel".equals(command)) {
                if ("Car".equals(vehicle)) {
                    car.refuel(Double.parseDouble(commandTokens[2]));
                } else {
                    truck.refuel(Double.parseDouble(commandTokens[2]));
                }
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }
}