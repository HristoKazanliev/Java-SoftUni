public class Bus extends VehicleImpl{
    private boolean isAcOn= false;
    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }
    public boolean isAcOn() {
        return isAcOn;
    }
    public void setAcOn(boolean isAcOnOrOff) {
        this.isAcOn = isAcOnOrOff;
    }
    @Override
    public String drive(double distance) {
        if (this.isAcOn) {
            super.setFuelConsumption(this.getFuelConsumption() + 1.4);
        }
        return super.drive(distance);
    }
}
