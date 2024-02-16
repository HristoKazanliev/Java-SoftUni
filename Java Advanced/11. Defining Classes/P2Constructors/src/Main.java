import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Car firstCar = new Car("BMW","M3", 180);
//        Car secondCar = new Car("Mercedes","C63 AMG", 180);
//        boolean isEqual = firstCar.equals(secondCar);
//        System.out.println(isEqual); //false

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] carArr = scanner.nextLine().split("\\s+");
            String brand = carArr[0];
            String model = "unknown";
            int horses = -1;

            if(carArr.length >= 2){
                model = carArr[1];
            };
            if(carArr.length >= 3) {
                horses = Integer.parseInt(carArr[2]);
            };

            Car current = new Car(brand, model, horses);
            cars.add(current);
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}