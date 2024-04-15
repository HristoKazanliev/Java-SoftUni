public class Car extends VehicleImpl{
    private final static double ADDITIONAL_SUMMER_FUEL_CONSUMPTION = 0.9;
    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_SUMMER_FUEL_CONSUMPTION, tankCapacity);
    }
}
