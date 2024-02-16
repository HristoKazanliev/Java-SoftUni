import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] carArr = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(carArr[0]);
            car.setModel(carArr[1]);
            car.setHorsePower(Integer.parseInt(carArr[2]));

            cars.add(car);
        }

        //System.out.println(String.format("The car is: %s %s - %d HP", car.getBrand(), car.getModel(), car.getHorsePower()));
        for (Car car : cars) {
            car.carInfo();
        }
    }
}